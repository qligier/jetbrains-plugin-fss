// Copyright 2024 Quentin Ligier. Use of this source code is governed by the MIT license.

package ch.qligier.jetbrains.plugin.fhir.igpublisher.jar;

import ch.qligier.jetbrains.plugin.fhir.common.ThePlugin;
import com.intellij.notification.*;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.fileChooser.FileChooser;
import com.intellij.openapi.fileChooser.FileChooserDescriptorFactory;
import com.intellij.openapi.progress.ProgressIndicator;
import com.intellij.openapi.progress.ProgressManager;
import com.intellij.openapi.progress.Task;
import com.intellij.openapi.progress.impl.BackgroundableProcessIndicator;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.util.download.DownloadableFileDescription;
import com.intellij.util.download.DownloadableFileService;
import com.intellij.util.download.FileDownloader;
import org.apache.commons.io.FileUtils;

import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * A downloader of IG Publisher JAR files.
 *
 * @author Quentin Ligier
 * @implNote Inspired from <a
 * href="https://github.com/asciidoctor/asciidoctor-intellij-plugin/blob/main/src/main/java/org/asciidoc/intellij/download/AsciiDocDownloaderUtil.java">asciidoctor-intellij-plugin
 * implementation</a> (Apache-2.0 license).
 **/
@ThreadSafe
public class IgPublisherJarDownloader {
    private static final Logger LOG = Logger.getInstance("IgPublisherJarDownloader");

    /**
     * The URL of the release page.
     */
    private static final String RELEASES_URL = "https://github.com/HL7/fhir-ig-publisher/releases";

    /**
     * The URL of a specific IG Publisher JAR file, with '%s' as a placeholder for the version.
     */
    private static final String SPECIFIC_JAR_URL = "https://github.com/HL7/fhir-ig-publisher/releases/download" +
            "/%s/publisher.jar";

    /**
     * The full pattern of version links on the release page.
     */
    private static final Pattern VERSION_PATTERN = Pattern.compile("/HL7/fhir-ig-publisher/tree/(\\d+\\.\\d+\\.\\d+)");

    public static void downloadLatestRelease(@Nullable final Project project,
                                             @Nullable final Runnable onSuccess,
                                             @Nullable final Consumer<Throwable> onFailure) {
        System.out.println("downloadLatestRelease");
        final List<String> versions;
        try {
            versions = fetchVersions();
        } catch (final Exception ignored) {
            // Ignore the exception here
            return;
        }
        if (versions.isEmpty()) {
            return;
        }

        downloadSpecificRelease(versions.get(0), project, onSuccess, onFailure);

    }

    public static void downloadSpecificRelease(final String version,
                                               @Nullable final Project project,
                                               @Nullable final Runnable onSuccess,
                                               @Nullable final Consumer<Throwable> onFailure) {
        System.out.println("downloadSpecificRelease: " + version);
        final String jarUrl = String.format(SPECIFIC_JAR_URL, version);
        final String jarFileName = String.format("publisher-%s.jar", version);
        final String jarPartFileName = jarFileName + ".part";
        System.out.println(jarUrl);
        System.out.println(jarFileName);
        System.out.println(jarPartFileName);
        System.out.println(IgPublisherJarManager.LOCAL_JAR_DIRECTORY);

        final File directory = new File(IgPublisherJarManager.LOCAL_JAR_DIRECTORY);
        if (!directory.exists()) {
            //noinspection ResultOfMethodCallIgnored
            directory.mkdirs();
        }

        final DownloadableFileService service = DownloadableFileService.getInstance();
        final DownloadableFileDescription description = service.createFileDescription(jarUrl, jarPartFileName);
        final FileDownloader downloader = service.createDownloader(List.of(description), jarPartFileName);

        final var task = new Task.Backgroundable(project, "Downloading the IG Publisher v" + version) {

            @Override
            public void run(final ProgressIndicator indicator) {
                try {
                    final List<VirtualFile> files = downloader.downloadFilesWithProgress(
                            IgPublisherJarManager.LOCAL_JAR_DIRECTORY,
                            project,
                            null);
                    if (files == null || files.size() == 0) {
                        throw new IOException("Download failed");
                    }
                    final File file = files.get(0).toNioPath().toFile();
                    if (!file.renameTo(new File(IgPublisherJarManager.LOCAL_JAR_DIRECTORY, jarFileName))) {
                        //noinspection ResultOfMethodCallIgnored
                        file.delete();
                        throw new IOException("Unable to rename file '" + file.getAbsolutePath() + "' to '" + jarFileName + "'");
                    }
                    ApplicationManager.getApplication().invokeLater(onSuccess);
                } catch (IOException e) {
                    LOG.warn("Can't download content '" + jarUrl + "' as '" + jarFileName + "'", e);
                    this.createFailureNotification(e, true);
                    if (onFailure != null) {
                        ApplicationManager.getApplication().invokeLater(() -> onFailure.accept(e));
                    }
                }
            }

            private void createFailureNotification(final IOException e,
                                                   final boolean download) {
                final NotificationAction retry = NotificationAction.createSimpleExpiring(
                        "Retry download",
                        () -> downloadSpecificRelease(version, project, onSuccess, onFailure));
                final NotificationAction pick = NotificationAction.createSimpleExpiring(
                        "Pick local file", () -> {
                            try {
                                pickFile(jarFileName, project, onSuccess);
                            } catch (IOException ex) {
                                LOG.warn("Can't pick file '" + jarUrl + "' as '" + jarFileName + "'",
                                         ex);
                                this.createFailureNotification(ex, false);
                                if (onFailure != null) {
                                    ApplicationManager.getApplication().invokeLater(() -> onFailure.accept(ex));
                                }
                            }
                        }
                );
                final var notification = new Notification(
                        ThePlugin.MAIN_GROUP_ID,
                        "IG Publisher download",
                        (download ? "Download failed: Can't download <a href=\"" + jarUrl + "\">" + jarUrl + "</a>" : "Copy failed. Can't copy " + jarFileName)
                                + " to folder " + directory.getAbsolutePath() + ": " + e.getMessage() + "."
                                + (download ? "" : " If you haven't downloaded the file yet, you can download it from <a href=\"" + jarUrl + "\">" + jarUrl + "</a>"),
                        NotificationType.ERROR)
                        .setListener(new NotificationListener.UrlOpeningListener(false))
                        .addAction(retry)
                        .addAction(pick);
                Notifications.Bus.notify(notification, project);
            }
        };
        final BackgroundableProcessIndicator processIndicator = new BackgroundableProcessIndicator(task);
        processIndicator.setIndeterminate(false);
        ProgressManager.getInstance().runProcessWithProgressAsynchronously(task, processIndicator);

    }

    protected static void pickFile(final String jarFileName,
                                   @Nullable final Project project,
                                   final Runnable onSuccess) throws IOException {
        final File directory = new File(IgPublisherJarManager.LOCAL_JAR_DIRECTORY);
        if (!directory.exists()) {
            //noinspection ResultOfMethodCallIgnored
            directory.mkdirs();
        }
        final VirtualFile[] virtualFiles =
                FileChooser.chooseFiles(FileChooserDescriptorFactory.createSingleFileDescriptor()
                                                .withFileFilter(virtualFile -> virtualFile.getName().equals(jarFileName))
                                                .withTitle("Pick Local File...")
                                                .withDescription("Please select file '" + jarFileName + "' on your local disk."),
                                        project, null);
        if (virtualFiles.length == 1) {
            if (virtualFiles[0].isDirectory()) {
                throw new IOException("Directory selected. Please select a file named '" + jarFileName + "'!");
            }
            if (!virtualFiles[0].getName().equals(jarFileName)) {
                throw new IOException("Wrong file selected. Please select a file named '" + jarFileName + "'!");
            }
            final Path sourcePath = virtualFiles[0].getFileSystem().getNioPath(virtualFiles[0]);
            if (sourcePath == null) {
                throw new IOException("unable to so pick source path");
            }
            FileUtils.copyFile(sourcePath.toFile(), new File(directory, jarFileName));
            // Update IG Publisher configuration
            ApplicationManager.getApplication().invokeLater(onSuccess);
        } else {
            throw new IOException("No file selected. Please select a file named '" + jarFileName + "'!");
        }
    }

    public static List<String> fetchVersions() throws IOException, InterruptedException {
        final HttpClient client = HttpClient.newHttpClient();
        final HttpRequest request = HttpRequest.newBuilder(URI.create(RELEASES_URL)).build();
        final HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        final Matcher matcher = VERSION_PATTERN.matcher(response.body());

        final List<String> versions = new ArrayList<>(10);
        while (matcher.find()) {
            if (matcher.groupCount() == 1) {
                versions.add(matcher.group(1));
            }
        }
        return versions;
    }
}

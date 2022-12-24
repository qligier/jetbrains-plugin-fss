// Copyright 2022 Quentin Ligier. Use of this source code is governed by the MIT license.

package ch.qligier.jetbrains.plugin.fhir.igpublisher.jar;

import com.intellij.openapi.application.PathManager;

import javax.annotation.Nullable;
import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

/**
 * The manager of local IG Publisher files.
 *
 * @author Quentin Ligier
 **/
public class IgPublisherJarManager {

    /**
     * The local directory that contains the IG Publisher JAR files.
     * <p>
     * The grazie and asciidoctor plugins use the 'download-cache' directory, let's do the same.
     */
    public static final String LOCAL_JAR_DIRECTORY =
            PathManager.getSystemPath() + File.separator + "download-cache" + File.separator + "fhir-plugin" + File.separator;

    private static final Pattern JAR_NAME_PATTERN = Pattern.compile("publisher-(\\d+\\.\\d+\\.\\d+)\\.jar");

    private static final Pattern PART_NAME_PATTERN = Pattern.compile("publisher-(\\d+\\.\\d+\\.\\d+)\\.jar\\.part");

    public static void cleanPartFiles() {
        final var directory = new File(LOCAL_JAR_DIRECTORY);

        final var filenameFilter = new FilenameFilter() {

            /**
             * Tests if a specified file should be included in a file list.
             *
             * @param dir  the directory in which the file was found.
             * @param name the name of the file.
             * @return {@code true} if and only if the name should be included in the file list;
             * {@code false} otherwise.
             */
            @Override
            public boolean accept(final File dir, final String name) {
                return PART_NAME_PATTERN.matcher(name).matches();
            }
        };
        final var files = directory.listFiles(filenameFilter);
        if (files == null || files.length == 0) {
            return;
        }
        for (final var file : files) {
            //noinspection ResultOfMethodCallIgnored
            file.delete();
        }
    }

    @Nullable
    public static File findJar() {
        final var directory = new File(LOCAL_JAR_DIRECTORY);

        final var filenameFilter = new FilenameFilter() {

            /**
             * Tests if a specified file should be included in a file list.
             *
             * @param dir  the directory in which the file was found.
             * @param name the name of the file.
             * @return {@code true} if and only if the name should be included in the file list;
             * {@code false} otherwise.
             */
            @Override
            public boolean accept(final File dir, final String name) {
                return JAR_NAME_PATTERN.matcher(name).matches();
            }
        };
        final var files = directory.listFiles(filenameFilter);
        if (files == null || files.length == 0) {
            return null;
        }
        for (final var file : files) {
            System.out.println("Found " + file.getName());
            return file;
        }
        return null;
    }
}

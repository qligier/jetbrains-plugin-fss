// Copyright 2024 Quentin Ligier. Use of this source code is governed by the MIT license.

package ch.qligier.jetbrains.plugin.fhir.igpublisher.jar;

import ch.qligier.jetbrains.plugin.fhir.common.ThePlugin;
import com.intellij.notification.Notification;
import com.intellij.notification.NotificationType;
import com.intellij.notification.Notifications;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.UpdateInBackground;
import com.intellij.openapi.project.DumbAware;

/**
 * An action that downloads the latest version of the IG Publisher JAR file.
 *
 * @author Quentin Ligier
 * @see <a href="https://plugins.jetbrains.com/docs/intellij/basic-action-system.html">Actions</a>
 **/
public class DownloadLatestIgPublisherJarAction extends AnAction implements DumbAware, UpdateInBackground {

    /**
     * Implement this method to provide your action handler.
     *
     * @param e Carries information on the invocation place
     */
    @Override
    public void actionPerformed(final AnActionEvent e) {
        final var onSuccess = new Runnable() {
            /**
             * When an object implementing interface {@code Runnable} is used to create a thread,
             * starting the thread causes the object's {@code run} method to be called in that
             * separately executing thread.
             * <p>
             * The general contract of the method {@code run} is that it may take any action
             * whatsoever.
             *
             * @see Thread#run()
             */
            @Override
            public void run() {
                final var notification = new Notification(ThePlugin.MAIN_GROUP_ID,
                                                          "IG Publisher download",
                                                          "The latest release has been downloaded",
                                                          NotificationType.INFORMATION);
                Notifications.Bus.notify(notification, e.getProject());
            }
        };
        IgPublisherJarDownloader.downloadLatestRelease(e.getProject(),
                                                       onSuccess,
                                                       null);
    }
}

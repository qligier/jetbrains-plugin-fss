// Copyright 2022 Quentin Ligier. Use of this source code is governed by the MIT license.

package ch.qligier.jetbrains.plugin.fhir.common;

import com.intellij.ide.impl.TrustedProjects;
import com.intellij.openapi.project.Project;
import com.intellij.psi.search.FilenameIndex;
import com.intellij.psi.search.GlobalSearchScope;

import javax.annotation.Nullable;

/**
 * Common class about notifications.
 *
 * @author Quentin Ligier
 * @see <a href="https://plugins.jetbrains.com/docs/intellij/notifications.html">Notifications</a>
 **/
public class ThePlugin {

    /**
     * The plugin id.
     */
    public static final String PLUGIN_ID = "jetbrains-plugin-fhir";

    /**
     * The main notification group id.
     */
    public static final String MAIN_GROUP_ID = "fhir-plugin";

    /**
     * This class is not instantiable.
     */
    private ThePlugin() {
    }

    /**
     * @return
     */
    public static boolean shouldActivateInProject(@Nullable final Project project) {
        if (project == null || !TrustedProjects.isTrusted(project)) {
            return false;
        }
        FilenameIndex.getFilesByName(project, "ig.ini", GlobalSearchScope.EMPTY_SCOPE);
        return true;
    }
}

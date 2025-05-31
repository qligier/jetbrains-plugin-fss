/*
 * Copyright 2025 Quentin Ligier. Use of this source code is governed by the MIT license.
 */

package ch.qligier.jetbrains.plugin.fss.common

import com.intellij.ide.FileIconProvider
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile
import javax.swing.Icon

class IconProvider : FileIconProvider {
    /**
     * Provides a custom icon for the given virtual file, or {@code null} it there is no icon to provide.
     *
     * @param file    The target file.
     * @param flags   Some flags.
     * @param project The project.
     * @return an icon to override the default one or {@code null}.
     */
    override fun getIcon(
        file: VirtualFile,
        flags: Int,
        project: Project?
    ): Icon? {
        when (file.name) {
            "ig.ini" -> return Icons.FHIR_FLAME
            "sushi-config.json" -> return Icons.FSH_FLAME
        }

        if (file.path.endsWith("/input/includes/menu.xml")) {
            return Icons.MENU_XML
        }

        return null // No custom icon provided for other files
    }
}


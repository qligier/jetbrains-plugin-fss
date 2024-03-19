// Copyright 2024 Quentin Ligier. Use of this source code is governed by the MIT license.

package ch.qligier.jetbrains.plugin.fhir.common;

import com.intellij.ide.FileIconProvider;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.Iconable;
import com.intellij.openapi.vfs.VirtualFile;
import org.jspecify.annotations.Nullable;

import javax.swing.*;

/**
 * A custom icon provider: it's used to give a better icon to files such as <em>ig.ini</em> and <em>sushi-config
 * .yaml</em>.
 *
 * @author Quentin Ligier
 * @see <a href=""></a>
 **/
public class CustomIconProvider implements FileIconProvider {

    /**
     * Provides a custom icon for the given virtual file, or {@code null} it there's no icon to provide.
     *
     * @param file    The target file.
     * @param flags   Some flags.
     * @param project The project.
     * @return an icon to override the default one or {@code null}.
     */
    @Override
    public @Nullable Icon getIcon(final VirtualFile file,
                                  final @Iconable.IconFlags int flags,
                                  @Nullable final Project project) {
        if ("ig.ini".equals(file.getName())) {
            return Icons.FHIR_FLAME;
        } else if ("sushi-config.yaml".equals(file.getName())) {
            return Icons.FSH_FLAME;
        } else if (file.getPath().endsWith("/input/includes/menu.xml")) {
            return Icons.MENU_XML;
        }
        return null;
    }
}

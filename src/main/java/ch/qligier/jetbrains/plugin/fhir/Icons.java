// Copyright 2022 Quentin Ligier. Use of this source code is governed by the MIT license.

package ch.qligier.jetbrains.plugin.fhir;

import com.intellij.openapi.util.IconLoader;

import javax.swing.*;

/**
 * The icons used by this plugin.
 *
 * @author Quentin Ligier
 * @see <a href="https://plugins.jetbrains.com/docs/intellij/work-with-icons-and-images.html">Working with Icons and
 * Images</a>
 * @see <a href="https://jetbrains.design/intellij/principles/icons/">Icons</a>
 * @see <a href="https://jetbrains.design/intellij/resources/icons_list/">Icons list</a>
 **/
public class Icons {

    // 16x16 icon for the language type
    public static final Icon FSH_FLAME = IconLoader.getIcon("/icons/fsh_flame.png", Icons.class);

    /**
     * Icons based on <a href="https://jetbrains.design/intellij/resources/icons_list/">JetBrains ones</a>.
     */
    public static final Icon FSH_FILE = IconLoader.getIcon("/icons/fsh_file.svg", Icons.class);
    public static final Icon VALUESET = IconLoader.getIcon("/icons/valueset.svg", Icons.class);

    /**
     * Icons of <a href="https://tabler-icons.io">Tabler Icons</a> (MIT License).
     */
    public static final Icon TABLER_AB = IconLoader.getIcon("/icons/a-b.png", Icons.class);
}

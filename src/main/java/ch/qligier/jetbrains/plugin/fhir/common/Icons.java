// Copyright 2022 Quentin Ligier. Use of this source code is governed by the MIT license.

package ch.qligier.jetbrains.plugin.fhir.common;

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
 * @see <a href="https://bjansen.github.io/intellij-icon-generator/">IntelliJ Icon Generator</a>
 **/
public class Icons {

    // 16x16 icon for the language type
    public static final Icon FSH_FLAME = IconLoader.getIcon("/icons/fsh_flame.png", Icons.class);
    public static final Icon FHIR_FLAME = IconLoader.getIcon("/icons/fhir.png", Icons.class);
    public static final Icon MENU_XML = IconLoader.getIcon("/icons/menu.svg", Icons.class);

    /**
     * Icons based on <a href="https://jetbrains.design/intellij/resources/icons_list/">JetBrains ones</a>.
     */
    public static final Icon FSH_FILE = IconLoader.getIcon("/icons/fsh_file.svg", Icons.class);
    public static final Icon VALUESET = IconLoader.getIcon("/icons/valueset.svg", Icons.class);
    public static final Icon PROFILE = IconLoader.getIcon("/icons/profile.svg", Icons.class);
    public static final Icon EXTENSION = IconLoader.getIcon("/icons/extension.svg", Icons.class);
    public static final Icon RESOURCE = IconLoader.getIcon("/icons/resource.svg", Icons.class);
    public static final Icon MAPPING = IconLoader.getIcon("/icons/mapping.svg", Icons.class);
    public static final Icon ALIAS = IconLoader.getIcon("/icons/alias.svg", Icons.class);
    public static final Icon LOGICAL = IconLoader.getIcon("/icons/logical.svg", Icons.class);
    public static final Icon CODESYSTEM = IconLoader.getIcon("/icons/codesystem.svg", Icons.class);
    public static final Icon RULESET = IconLoader.getIcon("/icons/ruleset.svg", Icons.class);
    public static final Icon INVARIANT = IconLoader.getIcon("/icons/invariant.svg", Icons.class);
    public static final Icon INSTANCE = IconLoader.getIcon("/icons/instance.svg", Icons.class);
}

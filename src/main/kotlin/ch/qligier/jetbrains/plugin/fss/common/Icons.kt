/*
 * Copyright 2025 Quentin Ligier. Use of this source code is governed by the MIT license.
 */

package ch.qligier.jetbrains.plugin.fss.common

import com.intellij.openapi.util.IconLoader
import javax.swing.Icon

/**
 * The icons used by this plugin.
 *
 * @author Quentin Ligier
 * @see [Working with Icons and Images](https://plugins.jetbrains.com/docs/intellij/work-with-icons-and-images.html)
 * @see [Icons](https://jetbrains.design/intellij/principles/icons/)
 * @see [Icons list](https://jetbrains.design/intellij/resources/icons_list/)
 * @see [IntelliJ Icon Generator](https://bjansen.github.io/intellij-icon-generator/)
 * @see [IntelliJ Platform Icons](https://intellij-icons.jetbrains.design)
 */
object Icons {

    // 16x16 icon for the language types
    val FSH_FLAME = loadIcon("fsh_flame.png")
    val FHIR_FLAME = loadIcon("fhir.png")
    val MENU_XML = loadIcon("menu.svg")

    // Icons based on [JetBrains ones](https://jetbrains.design/intellij/resources/icons_list/).
    val FSH_FILE = loadIcon("fsh_file.svg")
    val VALUESET = loadIcon("valueset.svg")
    val PROFILE = loadIcon("profile.svg")
    val EXTENSION = loadIcon("extension.svg")
    val RESOURCE = loadIcon("resource.svg")
    val MAPPING = loadIcon("mapping.svg")
    val ALIAS = loadIcon("alias.svg")
    val LOGICAL = loadIcon("logical.svg")
    val CODESYSTEM = loadIcon("codesystem.svg")
    val RULESET = loadIcon("ruleset.svg")
    val INVARIANT = loadIcon("invariant.svg")
    val INSTANCE = loadIcon("instance.svg")

    // Utility function to load icons from the resources
    private fun loadIcon(path: String): Icon = IconLoader.getIcon("icons/$path", Icons::class.java)
}

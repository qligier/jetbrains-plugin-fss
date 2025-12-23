/*
 * Copyright 2025 Quentin Ligier. Use of this source code is governed by the MIT license.
 */
package ch.qligier.jetbrains.plugin.fss.fsh

import ch.qligier.jetbrains.plugin.fss.common.FssIcons
import com.intellij.openapi.fileTypes.LanguageFileType

/**
 * Definition of the FSH file type.
 *
 * @author Quentin Ligier
 * @see [Language and File Type](https://plugins.jetbrains.com/docs/intellij/language-and-filetype.html)
 */
class FshFileType : LanguageFileType(FshLanguage) {
    companion object {
        @Suppress("unused")
        val INSTANCE: FshFileType = FshFileType()
    }

    /**
     * Returns the name of the file type. The name must be unique among all file types registered in the system.
     */
    override fun getName(): String = "FSH"

    /**
     * Returns the user-readable description of the file type.
     */
    override fun getDescription(): String = "FHIR Shorthand file"

    /**
     * Returns the default extension for files of the type, *not* including the leading '.'.
     */
    override fun getDefaultExtension(): String = "fsh"

    /**
     * Returns the icon used for showing files of the type, or `null` if no icon should be shown.
     */
    override fun getIcon() = FssIcons.FSH_FILE

}

/*
 * Copyright 2025 Quentin Ligier. Use of this source code is governed by the MIT license.
 */

package ch.qligier.jetbrains.plugin.fss.igini

import ch.qligier.jetbrains.plugin.fss.common.FssIcons
import com.intellij.openapi.fileTypes.LanguageFileType

val IG_INI_FILE_TYPE = IgIniFileType()

/**
 * Definition of the 'ig.ini' file type.
 *
 * @author Quentin Ligier
 * @see [Language and File Type](https://plugins.jetbrains.com/docs/intellij/language-and-filetype.html)
 **/
class IgIniFileType : LanguageFileType(IgIniLanguage) {

    /**
     * Returns the name of the file type. The name must be unique among all file types registered in the system.
     */
    override fun getName(): String = "ig.ini"

    /**
     * Returns the user-readable description of the file type.
     */
    override fun getDescription(): String = "FHIR IG configuration file"

    /**
     * Returns the default extension for files of the type, <em>not</em> including the leading '.'.
     */
    override fun getDefaultExtension(): String = "ini"

    /**
     * Returns the icon used for showing files of the type, or {@code null} if no icon should be shown.
     */
    override fun getIcon() = FssIcons.FHIR_FLAME

    companion object {
        val INSTANCE: IgIniFileType = IgIniFileType()
    }
}

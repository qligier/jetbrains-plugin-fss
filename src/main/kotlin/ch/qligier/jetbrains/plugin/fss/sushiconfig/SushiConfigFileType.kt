/*
 * Copyright 2025 Quentin Ligier. Use of this source code is governed by the MIT license.
 */

package ch.qligier.jetbrains.plugin.fss.sushiconfig

import ch.qligier.jetbrains.plugin.fss.common.FssIcons
import com.intellij.openapi.fileTypes.LanguageFileType
import org.jetbrains.yaml.YAMLLanguage

class SushiConfigFileType : LanguageFileType(YAMLLanguage.INSTANCE) {
    /**
     * Returns the name of the file type. The name must be unique among all file types registered in the system.
     */
    override fun getName(): String = SushiConfigSpecs.FILENAME

    /**
     * Returns the user-readable description of the file type.
     */
    override fun getDescription(): String = "SUSHI configuration file"

    /**
     * Returns the default extension for files of the type, <em>not</em> including the leading '.'.
     */
    override fun getDefaultExtension(): String = "yaml"

    /**
     * Returns the icon used for showing files of the type, or {@code null} if no icon should be shown.
     */
    override fun getIcon() = FssIcons.FSH_FLAME

    companion object {
        val INSTANCE: SushiConfigFileType = SushiConfigFileType()
    }
}

/*
 * Copyright 2025 Quentin Ligier. Use of this source code is governed by the MIT license.
 */
package ch.qligier.jetbrains.plugin.fss.fsh

import com.intellij.openapi.application.PluginPathManager
import com.intellij.openapi.diagnostic.thisLogger
import org.jetbrains.plugins.textmate.api.TextMateBundleProvider
import java.io.File

/**
 * The provider of the FSH TextMate bundle.
 *
 * @author Quentin Ligier
 */
class FshTextMateBundleProvider : TextMateBundleProvider {
    override fun getBundles(): MutableList<TextMateBundleProvider.PluginBundle> {
        val directory: File? = PluginPathManager.getPluginResource(this.javaClass, "fsh/fsh.tmbundle")
        if (directory == null) {
            thisLogger().warn("Could not find the FSH TextMate bundle")
            return mutableListOf()
        }
        return mutableListOf(TextMateBundleProvider.PluginBundle("FSH", directory.toPath()))
    }
}

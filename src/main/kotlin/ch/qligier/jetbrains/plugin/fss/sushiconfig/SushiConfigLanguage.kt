/*
 * Copyright 2025 Quentin Ligier. Use of this source code is governed by the MIT license.
 */

package ch.qligier.jetbrains.plugin.fss.sushiconfig

import com.intellij.lang.Language

/**
 * Definition of the language for 'sushi-config.yaml' files.
 * @see [Language and File Type](https://plugins.jetbrains.com/docs/intellij/language-and-filetype.html)
 **/
object SushiConfigLanguage : Language("SUSHI_CONFIG") {
    private fun readResolve(): Any = SushiConfigLanguage
}

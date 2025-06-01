/*
 * Copyright 2025 Quentin Ligier. Use of this source code is governed by the MIT license.
 */

package ch.qligier.jetbrains.plugin.fss

import ch.qligier.jetbrains.plugin.fss.fsh.FshLanguage
import ch.qligier.jetbrains.plugin.fss.fsh.antlr.FSHParser
import com.intellij.openapi.application.ApplicationActivationListener
import com.intellij.openapi.wm.IdeFrame
import org.antlr.intellij.adaptor.lexer.PSIElementTypeFactory

class FssPluginActivationListener : ApplicationActivationListener {
    override fun applicationActivated(ideFrame: IdeFrame) {
        // Load all IElementTypes for FSH
        PSIElementTypeFactory.defineLanguageIElementTypes(
            FshLanguage,
            FSHParser.tokenNames,
            FSHParser.ruleNames
        )
    }
}

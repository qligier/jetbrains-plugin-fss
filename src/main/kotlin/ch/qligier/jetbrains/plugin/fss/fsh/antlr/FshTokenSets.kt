/*
 * Copyright 2025 Quentin Ligier. Use of this source code is governed by the MIT license.
 */

package ch.qligier.jetbrains.plugin.fss.fsh.antlr

import ch.qligier.jetbrains.plugin.fss.fsh.FshLanguage
import com.intellij.psi.tree.TokenSet
import org.antlr.intellij.adaptor.lexer.PSIElementTypeFactory

object FshTokenSets {
    val COMMENTS = createTokenSet(FSHLexer.LINE_COMMENT, FSHLexer.BLOCK_COMMENT)
    val WHITESPACES = createTokenSet(FSHLexer.WHITESPACE)
    val STRINGS = createTokenSet(FSHLexer.STRING, FSHLexer.MULTILINE_STRING)

    private fun createTokenSet(vararg tokenTypes: Int): TokenSet {
        return PSIElementTypeFactory.createTokenSet(FshLanguage, *tokenTypes)
    }
}

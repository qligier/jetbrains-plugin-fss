/*
 * Copyright 2025 Quentin Ligier. Use of this source code is governed by the MIT license.
 */

package ch.qligier.jetbrains.plugin.fss.fsh.antlr

import ch.qligier.jetbrains.plugin.fss.fsh.FshLanguage
import com.intellij.psi.tree.IElementType
import org.antlr.intellij.adaptor.lexer.ANTLRLexerAdaptor

class FshLexerAdapter : ANTLRLexerAdaptor(FshLanguage, FSHLexer(null)) {

    override fun getTokenType(): IElementType? {
        val tokenType = super.getTokenType()
        println("tokenType = $tokenType")
        if (tokenType?.debugName == "STAR") {
            println("  STAR index = ${tokenType.index}")
            println("  getTokenSequence() = $tokenSequence")
        }
        return tokenType
    }


}

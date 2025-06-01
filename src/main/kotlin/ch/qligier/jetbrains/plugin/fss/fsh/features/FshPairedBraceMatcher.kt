/*
 * Copyright 2025 Quentin Ligier. Use of this source code is governed by the MIT license.
 */
package ch.qligier.jetbrains.plugin.fss.fsh.features

import ch.qligier.jetbrains.plugin.fss.fsh.FshLanguage
import ch.qligier.jetbrains.plugin.fss.fsh.antlr.FSHLexer
import com.intellij.lang.BracePair
import com.intellij.lang.PairedBraceMatcher
import com.intellij.psi.PsiFile
import com.intellij.psi.tree.IElementType
import org.antlr.intellij.adaptor.lexer.PSIElementTypeFactory

/**
 * Defines the brace matching support for the FSH language. Only parentheses are supported.
 * @see [Brace
 * Matching](https://plugins.jetbrains.com/docs/intellij/additional-minor-features.html.brace-matching)
 */
class FshPairedBraceMatcher : PairedBraceMatcher {
    /**
     * Returns the array of definitions for brace pairs that need to be matched when editing code in the language.
     *
     * @return the array of brace pair definitions.
     */
    override fun getPairs(): Array<BracePair> {
        return PAIRS
    }

    /**
     * Returns `true` if paired rbrace should be inserted after lbrace of given type when lbrace is encountered
     * before contextType token. It is safe to always return `true`, then paired brace will be inserted anyway.
     *
     * @param lbraceType  lbrace for which information is queried
     * @param contextType token type that follows lbrace
     * @return true / false as described
     */
    override fun isPairedBracesAllowedBeforeType(
        lbraceType: IElementType,
        contextType: IElementType?,
    ): Boolean {
        return true
    }

    /**
     * Returns the start offset of the code construct which owns the opening structural brace at the specified offset.
     * For example, if the opening brace belongs to an 'if' statement, returns the start offset of the 'if' statement.
     *
     * @param file               the file in which brace matching is performed.
     * @param openingBraceOffset the offset of an opening structural brace.
     * @return the offset of corresponding code construct, or the same offset if not defined.
     */
    override fun getCodeConstructStart(file: PsiFile?, openingBraceOffset: Int): Int {
        return 0
    }

    companion object {
        private val PAIRS: Array<BracePair>

        init {
            val types = PSIElementTypeFactory.getTokenIElementTypes(FshLanguage)
            PAIRS = arrayOf<BracePair>(
                BracePair(
                    types[FSHLexer.LEFT_PAREN]!!,
                    types[FSHLexer.RIGHT_PAREN]!!,
                    false
                ),
            )
        }
    }
}

/*
 * Copyright 2026 Quentin Ligier. Use of this source code is governed by the MIT license.
 */

package ch.qligier.jetbrains.plugin.fss.fsh.language.lexer

import ch.qligier.jetbrains.plugin.fss.fsh.language.FshLexer
import com.intellij.lexer.FlexAdapter

/**
 * The FSH lexer, wrapped for the IntelliJ Platform.
 *
 * On every (re)start, the "dirty" flag of the lexer is reset from the initial state: the editor highlighter restarts the
 * lexer at state-0 tokens, or in the DIRTY state after an unterminated token.
 */
class FshLexerAdapter : FlexAdapter(FshLexer(null)) {
    override fun start(
        buffer: CharSequence,
        startOffset: Int,
        endOffset: Int,
        initialState: Int,
    ) {
        (flex as FshLexer).resetLineState(initialState)
        super.start(buffer, startOffset, endOffset, initialState)
    }
}

/*
 * Copyright 2026 Quentin Ligier. Use of this source code is governed by the MIT license.
 */

package ch.qligier.jetbrains.plugin.fss.fsh.language.parser

import ch.qligier.jetbrains.plugin.fss.fsh.language.psi.FshTypes
import com.intellij.lang.WhitespacesAndCommentsBinder
import com.intellij.psi.TokenType

/**
 * Comment binding, registered with `hooks` in fsh.bnf. By default, the platform leaves comments between nodes outside of them.
 */
object FshBinders {
    /**
     * Comment lines directly above an entity belong to it: comments that start their own line, with no blank line between them and
     * the declaration. Folding, the structure view and "move statement" then carry them along.
     */
    @JvmField
    val ENTITY_LEFT: WhitespacesAndCommentsBinder =
        WhitespacesAndCommentsBinder { tokens, atStreamEdge, getter ->
            var edge = tokens.size
            var i = tokens.size - 1
            while (i >= 0) {
                val type = tokens[i]
                if (type == TokenType.WHITE_SPACE) {
                    if (lineBreaks(getter[i]) > 1) break
                } else if (type == FshTypes.LINE_COMMENT || type == FshTypes.BLOCK_COMMENT) {
                    // Only a comment that starts its line: a comment after a rule on the same line belongs to that rule
                    val startsLine =
                        if (i == 0) atStreamEdge else tokens[i - 1] == TokenType.WHITE_SPACE && lineBreaks(getter[i - 1]) > 0
                    if (!startsLine) break
                    edge = i
                } else {
                    break
                }
                i--
            }
            edge
        }

    /** A comment on the same line as the end of a rule or a metadata belongs to it (`* status MS // comment`). */
    @JvmField
    val TRAILING_COMMENT: WhitespacesAndCommentsBinder =
        WhitespacesAndCommentsBinder { tokens, _, getter ->
            var edge = 0
            for (i in tokens.indices) {
                val type = tokens[i]
                if (type == TokenType.WHITE_SPACE) {
                    if (lineBreaks(getter[i]) > 0) break
                } else if (type == FshTypes.LINE_COMMENT) {
                    edge = i + 1
                    break
                } else if (type == FshTypes.BLOCK_COMMENT) {
                    edge = i + 1
                } else {
                    break
                }
            }
            edge
        }

    private fun lineBreaks(text: CharSequence): Int {
        var count = 0
        var i = 0
        while (i < text.length) {
            val c = text[i]
            if (c == '\n' || c == '\r') {
                count++
                if (c == '\r' && i + 1 < text.length && text[i + 1] == '\n') i++
            }
            i++
        }
        return count
    }
}

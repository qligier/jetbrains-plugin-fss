/*
 * Copyright 2025 Quentin Ligier. Use of this source code is governed by the MIT license.
 */
package ch.qligier.jetbrains.plugin.fss.fsh.color

import ch.qligier.jetbrains.plugin.fss.fsh.antlr.FSHLexer
import ch.qligier.jetbrains.plugin.fss.fsh.antlr.FshLexerAdapter
import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.tree.IElementType
import org.antlr.intellij.adaptor.lexer.TokenIElementType

class FshSyntaxHighlighter : SyntaxHighlighterBase() {
    override fun getHighlightingLexer(): Lexer = FshLexerAdapter()

    /**
     * Returns the list of text attribute keys used for highlighting the specified token type. The attributes of all
     * attribute keys returned for the token type are successively merged to obtain the color and attributes of the
     * token.
     *
     * @param tokenType The token type for which the highlighting is requested.
     * @return The array of text attribute keys.
     */
    override fun getTokenHighlights(tokenType: IElementType): Array<out TextAttributesKey> {
        if (tokenType !is TokenIElementType) return EMPTY_KEYS

        return when (tokenType.antlrTokenType) {
            FSHLexer.STRING -> pack(STRING)
            FSHLexer.LINE_COMMENT -> pack(LINE_COMMENT)
            FSHLexer.BLOCK_COMMENT -> pack(BLOCK_COMMENT)
            FSHLexer.KW_ALIAS, FSHLexer.KW_CODESYSTEM, FSHLexer.KW_EXTENSION, FSHLexer.KW_INSTANCE, FSHLexer
                .KW_INVARIANT, FSHLexer.KW_LOGICAL, FSHLexer.KW_MAPPING, FSHLexer.KW_PROFILE, FSHLexer.KW_RESOURCE,
            FSHLexer.KW_RULESET, FSHLexer.KW_VALUESET -> pack(DECLARATION)

            FSHLexer.KW_CHARACTERISTICS, FSHLexer.KW_CONTEXT, FSHLexer.KW_DESCRIPTION, FSHLexer.KW_EXPRESSION,
            FSHLexer.KW_ID, FSHLexer.KW_INSTANCEOF, FSHLexer.KW_PARENT, FSHLexer.KW_SEVERITY, FSHLexer.KW_SOURCE,
            FSHLexer.KW_TARGET, FSHLexer.KW_TITLE, FSHLexer.KW_USAGE, FSHLexer.KW_XPATH -> pack(KEYWORD)

            FSHLexer.KW_AND, FSHLexer.KW_OR, FSHLexer.KW_OBEYS, FSHLexer.KW_INCLUDE, FSHLexer.KW_EXCLUDE -> pack(
                OPERATOR
            )

            FSHLexer.COMMA -> pack(COMMA)
            FSHLexer.DATETIME, FSHLexer.TIME, FSHLexer.CANONICAL, FSHLexer.REGEX, FSHLexer.UNIT, FSHLexer.CODE,
            FSHLexer.NUMBER -> pack(VALUE)

            FSHLexer.STAR -> pack(STAR)
            else -> EMPTY_KEYS
        }
    }

    companion object {
        private val ID: TextAttributesKey =
            TextAttributesKey.createTextAttributesKey("FSH_ID", DefaultLanguageHighlighterColors.IDENTIFIER)
        val KEYWORD: TextAttributesKey =
            TextAttributesKey.createTextAttributesKey("FSH_KEYWORD", DefaultLanguageHighlighterColors.KEYWORD)
        private val OPERATOR: TextAttributesKey =
            TextAttributesKey.createTextAttributesKey("FSH_OPERATOR", DefaultLanguageHighlighterColors.KEYWORD)
        val STRING: TextAttributesKey =
            TextAttributesKey.createTextAttributesKey("FSH_STRING", DefaultLanguageHighlighterColors.STRING)
        val LINE_COMMENT: TextAttributesKey =
            TextAttributesKey.createTextAttributesKey("FSH_LINE_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT)
        val BLOCK_COMMENT: TextAttributesKey = TextAttributesKey.createTextAttributesKey(
            "FSH_BLOCK_COMMENT",
            DefaultLanguageHighlighterColors.BLOCK_COMMENT
        )
        val DECLARATION: TextAttributesKey =
            TextAttributesKey.createTextAttributesKey("FSH_DECLARATION", DefaultLanguageHighlighterColors.KEYWORD)
        private val COMMA: TextAttributesKey =
            TextAttributesKey.createTextAttributesKey("FSH_COMMA", DefaultLanguageHighlighterColors.COMMA)
        private val NUMBER: TextAttributesKey =
            TextAttributesKey.createTextAttributesKey("FSH_NUMBER", DefaultLanguageHighlighterColors.NUMBER)
        val VALUE: TextAttributesKey =
            TextAttributesKey.createTextAttributesKey("FSH_VALUE", DefaultLanguageHighlighterColors.NUMBER)
        private val STAR: TextAttributesKey =
            TextAttributesKey.createTextAttributesKey("FSH_STAR", DefaultLanguageHighlighterColors.KEYWORD)
        private val EMPTY_KEYS: Array<TextAttributesKey> = emptyArray()
    }
}

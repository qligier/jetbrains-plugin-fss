/*
 * Copyright 2025 Quentin Ligier. Use of this source code is governed by the MIT license.
 */

package ch.qligier.jetbrains.plugin.fss.igini.language.highlighter

import ch.qligier.jetbrains.plugin.fss.igini.language.lexer.IniLexerAdapter
import ch.qligier.jetbrains.plugin.fss.igini.language.psi.IniTypes
import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.HighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IElementType

/**
 * The syntax highlighter for the INI file format.
 * @see [Syntax
 * Highlighter and Color Settings Page](https://plugins.jetbrains.com/docs/intellij/syntax-highlighter-and-color-settings-page.html)
 * @see [Syntax and
 * Error Highlighting](https://plugins.jetbrains.com/docs/intellij/syntax-highlighting-and-error-highlighting.html)
 */
class IniSyntaxHighlighter : SyntaxHighlighterBase() {

    override fun getHighlightingLexer(): Lexer = IniLexerAdapter()

    override fun getTokenHighlights(iElementType: IElementType): Array<TextAttributesKey?> {
        if (iElementType == IniTypes.EQUAL) {
            return SEPARATOR_KEYS
        }
        if (iElementType == IniTypes.SECTION_NAME) {
            return SECTION_KEYS
        }
        if (iElementType == IniTypes.PKEY) {
            return KEY_KEYS
        }
        if (iElementType == IniTypes.PVALUE) {
            return VALUE_KEYS
        }
        if (iElementType == IniTypes.COMMENT) {
            return COMMENT_KEYS
        }
        if (iElementType == TokenType.BAD_CHARACTER) {
            return BAD_CHAR_KEYS
        }
        return EMPTY_KEYS
    }

    companion object {
        val SEPARATOR: TextAttributesKey =
            TextAttributesKey.createTextAttributesKey("INI_SEPARATOR", DefaultLanguageHighlighterColors.OPERATION_SIGN)
        val SECTION: TextAttributesKey =
            TextAttributesKey.createTextAttributesKey("INI_SECTION", DefaultLanguageHighlighterColors.KEYWORD)
        val KEY: TextAttributesKey =
            TextAttributesKey.createTextAttributesKey("INI_KEY", DefaultLanguageHighlighterColors.MARKUP_ATTRIBUTE)
        val VALUE: TextAttributesKey =
            TextAttributesKey.createTextAttributesKey("INI_VALUE", DefaultLanguageHighlighterColors.STRING)
        val COMMENT: TextAttributesKey =
            TextAttributesKey.createTextAttributesKey("INI_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT)
        val BAD_CHARACTER: TextAttributesKey =
            TextAttributesKey.createTextAttributesKey("INI_BAD_CHARACTER", HighlighterColors.BAD_CHARACTER)

        private val BAD_CHAR_KEYS: Array<TextAttributesKey?> = arrayOf(BAD_CHARACTER)
        private val SEPARATOR_KEYS: Array<TextAttributesKey?> = arrayOf(SEPARATOR)
        private val SECTION_KEYS: Array<TextAttributesKey?> = arrayOf(SECTION)
        private val KEY_KEYS: Array<TextAttributesKey?> = arrayOf(KEY)
        private val VALUE_KEYS: Array<TextAttributesKey?> = arrayOf(VALUE)
        private val COMMENT_KEYS: Array<TextAttributesKey?> = arrayOf(COMMENT)
        private val EMPTY_KEYS = arrayOfNulls<TextAttributesKey>(0)
    }
}

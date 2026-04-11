/*
 * Copyright 2026 Quentin Ligier. Use of this source code is governed by the MIT license.
 */

package ch.qligier.jetbrains.plugin.fss.fsh.language.highlighter

import ch.qligier.jetbrains.plugin.fss.fsh.language.lexer.FshLexerAdapter
import ch.qligier.jetbrains.plugin.fss.fsh.language.psi.FshTypes
import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.tree.IElementType

class FshSyntaxHighlighter : SyntaxHighlighterBase() {
    val ID: TextAttributesKey = createTextAttributesKey("FSH_ID", DefaultLanguageHighlighterColors.IDENTIFIER)
    val KEYWORD: TextAttributesKey = createTextAttributesKey("FSH_KEYWORD", DefaultLanguageHighlighterColors.KEYWORD)
    val STRING: TextAttributesKey = createTextAttributesKey("FSH_STRING", DefaultLanguageHighlighterColors.STRING)
    val LINE_COMMENT: TextAttributesKey =
        createTextAttributesKey("FSH_LINE_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT)
    val BLOCK_COMMENT: TextAttributesKey =
        createTextAttributesKey("FSH_BLOCK_COMMENT", DefaultLanguageHighlighterColors.BLOCK_COMMENT)
    val NUMBER: TextAttributesKey = createTextAttributesKey("FSH_NUMBER", DefaultLanguageHighlighterColors.NUMBER)

    val METADATA: TextAttributesKey =
        createTextAttributesKey("FSH_METADATA", DefaultLanguageHighlighterColors.METADATA)

    override fun getHighlightingLexer(): Lexer = FshLexerAdapter()

    override fun getTokenHighlights(tokenType: IElementType): Array<out TextAttributesKey> =
        when (tokenType) {
            FshTypes.KW_ALIAS,
            FshTypes.KW_PROFILE,
            FshTypes.KW_EXTENSION,
            FshTypes.KW_RESOURCE,
            FshTypes.KW_LOGICAL,
            FshTypes.KW_INSTANCE,
            FshTypes.KW_VALUESET,
            FshTypes.KW_CODESYSTEM,
            FshTypes.KW_MAPPING,
            FshTypes.KW_RULESET,
            FshTypes.KW_INVARIANT,
            -> pack(KEYWORD)

            FshTypes.KW_ID,
            FshTypes.KW_TITLE,
            FshTypes.KW_DESCRIPTION,
            FshTypes.KW_PARENT,
            FshTypes.KW_INSTANCEOF,
            FshTypes.KW_USAGE,
            FshTypes.KW_SOURCE,
            FshTypes.KW_TARGET,
            FshTypes.KW_SEVERITY,
            FshTypes.KW_EXPRESSION,
            FshTypes.KW_XPATH,
            FshTypes.KW_CONTEXT,
            FshTypes.KW_CHARACTERISTICS,
            FshTypes.KW_MIXINS,
            -> pack(METADATA)

            FshTypes.STRING,
            FshTypes.MULTILINE_STRING,
            -> pack(STRING)

            FshTypes.LINE_COMMENT -> pack(LINE_COMMENT)

            FshTypes.BLOCK_COMMENT -> pack(BLOCK_COMMENT)

            else -> emptyArray()
        }
}

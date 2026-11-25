/*
 * Copyright 2026 Quentin Ligier. Use of this source code is governed by the MIT license.
 */

package ch.qligier.jetbrains.plugin.fss.fsh.language.highlighter

import ch.qligier.jetbrains.plugin.fss.fsh.language.lexer.FshLexerAdapter
import ch.qligier.jetbrains.plugin.fss.fsh.language.psi.FshTypes
import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.HighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IElementType

/**
 * The lexer-based syntax highlighter for FSH files.
 *
 * Rule keywords and flags are also accepted as names and paths (design D14): the lexer cannot tell `* system = …` from
 * `* include codes from system …`, so [FshHighlightingAnnotator] resets the color of the keywords the parser remapped to names.
 *
 * @see [Syntax Highlighter and Color Settings Page](https://plugins.jetbrains.com/docs/intellij/syntax-highlighter-and-color-settings-page.html)
 */
class FshSyntaxHighlighter : SyntaxHighlighterBase() {
    override fun getHighlightingLexer(): Lexer = FshLexerAdapter()

    override fun getTokenHighlights(tokenType: IElementType): Array<TextAttributesKey> = pack(ATTRIBUTES[tokenType])

    companion object {
        // Keywords
        @JvmField
        val DECLARATION_KEYWORD = createTextAttributesKey("FSH_DECLARATION_KEYWORD", DefaultLanguageHighlighterColors.KEYWORD)

        @JvmField
        val METADATA_KEYWORD = createTextAttributesKey("FSH_METADATA_KEYWORD", DefaultLanguageHighlighterColors.METADATA)

        @JvmField
        val RULE_KEYWORD = createTextAttributesKey("FSH_RULE_KEYWORD", DefaultLanguageHighlighterColors.KEYWORD)

        @JvmField
        val REFERENCE_KEYWORD = createTextAttributesKey("FSH_REFERENCE_KEYWORD", DefaultLanguageHighlighterColors.KEYWORD)

        @JvmField
        val BINDING_STRENGTH = createTextAttributesKey("FSH_BINDING_STRENGTH", DefaultLanguageHighlighterColors.KEYWORD)

        /** Bold teal in the bundled schemes (colorSchemes/FshDefault.xml and FshDarcula.xml); keyword-colored elsewhere */
        @JvmField
        val FLAG = createTextAttributesKey("FSH_FLAG", DefaultLanguageHighlighterColors.KEYWORD)

        @JvmField
        val BOOLEAN = createTextAttributesKey("FSH_BOOLEAN", DefaultLanguageHighlighterColors.KEYWORD)

        // Values
        @JvmField
        val STRING = createTextAttributesKey("FSH_STRING", DefaultLanguageHighlighterColors.STRING)

        @JvmField
        val NUMBER = createTextAttributesKey("FSH_NUMBER", DefaultLanguageHighlighterColors.NUMBER)

        @JvmField
        val DATE_TIME = createTextAttributesKey("FSH_DATE_TIME", DefaultLanguageHighlighterColors.NUMBER)

        @JvmField
        val CARDINALITY = createTextAttributesKey("FSH_CARDINALITY", DefaultLanguageHighlighterColors.NUMBER)

        @JvmField
        val CODE = createTextAttributesKey("FSH_CODE", DefaultLanguageHighlighterColors.CONSTANT)

        @JvmField
        val UNIT = createTextAttributesKey("FSH_UNIT", DefaultLanguageHighlighterColors.STRING)

        @JvmField
        val REGEX = createTextAttributesKey("FSH_REGEX", DefaultLanguageHighlighterColors.VALID_STRING_ESCAPE)

        // Names, paths and arguments
        @JvmField
        val IDENTIFIER = createTextAttributesKey("FSH_IDENTIFIER", DefaultLanguageHighlighterColors.IDENTIFIER)

        @JvmField
        val CARET_PATH = createTextAttributesKey("FSH_CARET_PATH", DefaultLanguageHighlighterColors.INSTANCE_FIELD)

        @JvmField
        val ARGUMENT = createTextAttributesKey("FSH_ARGUMENT", DefaultLanguageHighlighterColors.PARAMETER)

        /** Applied by [FshHighlightingAnnotator], not by the lexer */
        @JvmField
        val ENTITY_NAME = createTextAttributesKey("FSH_ENTITY_NAME", DefaultLanguageHighlighterColors.CLASS_NAME)

        // Symbols
        @JvmField
        val RULE_MARKER = createTextAttributesKey("FSH_RULE_MARKER", DefaultLanguageHighlighterColors.OPERATION_SIGN)

        @JvmField
        val OPERATOR = createTextAttributesKey("FSH_OPERATOR", DefaultLanguageHighlighterColors.OPERATION_SIGN)

        @JvmField
        val COMMA = createTextAttributesKey("FSH_COMMA", DefaultLanguageHighlighterColors.COMMA)

        @JvmField
        val PARENTHESES = createTextAttributesKey("FSH_PARENTHESES", DefaultLanguageHighlighterColors.PARENTHESES)

        // Comments and errors
        @JvmField
        val LINE_COMMENT = createTextAttributesKey("FSH_LINE_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT)

        @JvmField
        val BLOCK_COMMENT = createTextAttributesKey("FSH_BLOCK_COMMENT", DefaultLanguageHighlighterColors.BLOCK_COMMENT)

        @JvmField
        val BAD_CHARACTER = createTextAttributesKey("FSH_BAD_CHARACTER", HighlighterColors.BAD_CHARACTER)

        private val ATTRIBUTES: Map<IElementType, TextAttributesKey> =
            buildMap {
                fun put(
                    key: TextAttributesKey,
                    vararg types: IElementType,
                ) = types.forEach { put(it, key) }

                put(
                    DECLARATION_KEYWORD,
                    FshTypes.KW_ALIAS,
                    FshTypes.KW_PROFILE,
                    FshTypes.KW_EXTENSION,
                    FshTypes.KW_INSTANCE,
                    FshTypes.KW_INVARIANT,
                    FshTypes.KW_VALUESET,
                    FshTypes.KW_CODESYSTEM,
                    FshTypes.KW_RULESET,
                    FshTypes.KW_MAPPING,
                    FshTypes.KW_LOGICAL,
                    FshTypes.KW_RESOURCE,
                )
                put(
                    METADATA_KEYWORD,
                    FshTypes.KW_PARENT,
                    FshTypes.KW_ID,
                    FshTypes.KW_TITLE,
                    FshTypes.KW_DESCRIPTION,
                    FshTypes.KW_EXPRESSION,
                    FshTypes.KW_XPATH,
                    FshTypes.KW_SEVERITY,
                    FshTypes.KW_INSTANCEOF,
                    FshTypes.KW_USAGE,
                    FshTypes.KW_SOURCE,
                    FshTypes.KW_TARGET,
                    FshTypes.KW_CONTEXT,
                    FshTypes.KW_CHARACTERISTICS,
                )
                put(
                    RULE_KEYWORD,
                    FshTypes.KW_FROM,
                    FshTypes.KW_CONTAINS,
                    FshTypes.KW_NAMED,
                    FshTypes.KW_AND,
                    FshTypes.KW_OR,
                    FshTypes.KW_ONLY,
                    FshTypes.KW_OBEYS,
                    FshTypes.KW_INSERT,
                    FshTypes.KW_INCLUDE,
                    FshTypes.KW_EXCLUDE,
                    FshTypes.KW_CODES,
                    FshTypes.KW_WHERE,
                    FshTypes.KW_VALUESET_REF,
                    FshTypes.KW_SYSTEM,
                    FshTypes.KW_CONTENT_REFERENCE,
                )
                put(REFERENCE_KEYWORD, FshTypes.KW_REFERENCE, FshTypes.KW_CANONICAL, FshTypes.KW_CODEABLE_REFERENCE)
                put(
                    BINDING_STRENGTH,
                    FshTypes.KW_EXAMPLE,
                    FshTypes.KW_PREFERRED,
                    FshTypes.KW_EXTENSIBLE,
                    FshTypes.KW_REQUIRED,
                    FshTypes.KW_EXACTLY,
                )
                put(FLAG, FshTypes.KW_MS, FshTypes.KW_SU, FshTypes.KW_TU, FshTypes.KW_N, FshTypes.KW_D, FshTypes.KW_MOD)
                put(BOOLEAN, FshTypes.KW_TRUE, FshTypes.KW_FALSE)

                put(STRING, FshTypes.STRING, FshTypes.MULTILINE_STRING)
                put(NUMBER, FshTypes.NUMBER)
                put(DATE_TIME, FshTypes.DATE_TIME, FshTypes.TIME)
                put(CARDINALITY, FshTypes.CARD)
                put(CODE, FshTypes.CODE)
                put(UNIT, FshTypes.UNIT)
                put(REGEX, FshTypes.REGEX)

                put(IDENTIFIER, FshTypes.WORD)
                put(CARET_PATH, FshTypes.CARET_PATH)
                put(ARGUMENT, FshTypes.ARG_TEXT, FshTypes.ARG_BRACKETED)

                put(RULE_MARKER, FshTypes.STAR)
                put(OPERATOR, FshTypes.EQUAL, FshTypes.ARROW, FshTypes.COLON)
                put(COMMA, FshTypes.COMMA)
                put(PARENTHESES, FshTypes.LPAREN, FshTypes.RPAREN)

                put(LINE_COMMENT, FshTypes.LINE_COMMENT)
                put(BLOCK_COMMENT, FshTypes.BLOCK_COMMENT)
                put(BAD_CHARACTER, TokenType.BAD_CHARACTER)
            }
    }
}

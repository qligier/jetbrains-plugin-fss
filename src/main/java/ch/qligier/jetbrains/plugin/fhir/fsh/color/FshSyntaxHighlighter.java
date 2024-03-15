// Copyright 2024 Quentin Ligier. Use of this source code is governed by the MIT license.

package ch.qligier.jetbrains.plugin.fhir.fsh.color;

import ch.qligier.jetbrains.plugin.fhir.fsh.FshUtils;
import ch.qligier.jetbrains.plugin.fhir.fsh.grammar.FSHLexer;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.tree.IElementType;
import org.antlr.intellij.adaptor.lexer.TokenIElementType;
import org.jetbrains.annotations.NotNull;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

/**
 * jetbrains-plugin-fhir
 *
 * @author Quentin Ligier
 **/
public class FshSyntaxHighlighter extends SyntaxHighlighterBase {
    public static final TextAttributesKey ID =
            createTextAttributesKey("FSH_ID", DefaultLanguageHighlighterColors.IDENTIFIER);
    public static final TextAttributesKey KEYWORD =
            createTextAttributesKey("FSH_KEYWORD", DefaultLanguageHighlighterColors.KEYWORD);
    public static final TextAttributesKey OPERATOR =
            createTextAttributesKey("FSH_OPERATOR", DefaultLanguageHighlighterColors.KEYWORD);
    public static final TextAttributesKey STRING =
            createTextAttributesKey("FSH_STRING", DefaultLanguageHighlighterColors.STRING);
    public static final TextAttributesKey LINE_COMMENT =
            createTextAttributesKey("FSH_LINE_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT);
    public static final TextAttributesKey BLOCK_COMMENT =
            createTextAttributesKey("FSH_BLOCK_COMMENT", DefaultLanguageHighlighterColors.BLOCK_COMMENT);
    public static final TextAttributesKey DECLARATION =
            createTextAttributesKey("FSH_DECLARATION", DefaultLanguageHighlighterColors.KEYWORD);
    public static final TextAttributesKey COMMA =
            createTextAttributesKey("FSH_COMMA", DefaultLanguageHighlighterColors.COMMA);
    public static final TextAttributesKey NUMBER =
            createTextAttributesKey("FSH_NUMBER", DefaultLanguageHighlighterColors.NUMBER);
    public static final TextAttributesKey VALUE =
            createTextAttributesKey("FSH_VALUE", DefaultLanguageHighlighterColors.NUMBER);
    public static final TextAttributesKey STAR =
            createTextAttributesKey("FSH_STAR", DefaultLanguageHighlighterColors.KEYWORD);
    private static final TextAttributesKey[] EMPTY_KEYS = new TextAttributesKey[0];

    /**
     * Returns the lexer used for highlighting the file. The lexer is invoked incrementally when the file is changed, so
     * it must be capable of saving/restoring state and resuming lexing from the middle of the file.
     *
     * @return The lexer implementation.
     */
    @Override
    public @NotNull Lexer getHighlightingLexer() {
        return FshUtils.createLexer();
    }

    /**
     * Returns the list of text attribute keys used for highlighting the specified token type. The attributes of all
     * attribute keys returned for the token type are successively merged to obtain the color and attributes of the
     * token.
     *
     * @param tokenType The token type for which the highlighting is requested.
     * @return The array of text attribute keys.
     */
    @Override
    public TextAttributesKey @NotNull [] getTokenHighlights(final IElementType tokenType) {
        if (!(tokenType instanceof final TokenIElementType myType))
            return EMPTY_KEYS;

        switch (myType.getANTLRTokenType()) {
            case FSHLexer.STRING:
                return pack(STRING);
            case FSHLexer.LINE_COMMENT:
                return pack(LINE_COMMENT);
            case FSHLexer.BLOCK_COMMENT:
                return pack(BLOCK_COMMENT);
            case FSHLexer.KW_ALIAS:
            case FSHLexer.KW_CODESYSTEM:
            case FSHLexer.KW_EXTENSION:
            case FSHLexer.KW_INSTANCE:
            case FSHLexer.KW_INVARIANT:
            case FSHLexer.KW_LOGICAL:
            case FSHLexer.KW_MAPPING:
            case FSHLexer.KW_PROFILE:
            case FSHLexer.KW_RESOURCE:
            case FSHLexer.KW_RULESET:
            case FSHLexer.KW_VALUESET:
                return pack(DECLARATION);
            case FSHLexer.KW_CHARACTERISTICS:
            case FSHLexer.KW_CONTEXT:
            case FSHLexer.KW_DESCRIPTION:
            case FSHLexer.KW_EXPRESSION:
            case FSHLexer.KW_ID:
            case FSHLexer.KW_INSTANCEOF:
            case FSHLexer.KW_PARENT:
            case FSHLexer.KW_SEVERITY:
            case FSHLexer.KW_SOURCE:
            case FSHLexer.KW_TARGET:
            case FSHLexer.KW_TITLE:
            case FSHLexer.KW_USAGE:
            case FSHLexer.KW_XPATH:
                return pack(KEYWORD);
            case FSHLexer.KW_AND:
            case FSHLexer.KW_OR:
            case FSHLexer.KW_OBEYS:
            case FSHLexer.KW_INCLUDE:
            case FSHLexer.KW_EXCLUDE:
                return pack(OPERATOR);
            case FSHLexer.COMMA:
                return pack(COMMA);
            case FSHLexer.DATETIME:
            case FSHLexer.TIME:
            case FSHLexer.CANONICAL:
            case FSHLexer.REGEX:
            case FSHLexer.UNIT:
            case FSHLexer.CODE:
            case FSHLexer.NUMBER:
                return pack(VALUE);
            case FSHLexer.STAR:
                return pack(STAR);
            default:
                return EMPTY_KEYS;
        }
    }
}

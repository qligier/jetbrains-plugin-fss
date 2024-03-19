// Copyright 2024 Quentin Ligier. Use of this source code is governed by the MIT license.

package ch.qligier.jetbrains.plugin.fhir.fsh.color;

import ch.qligier.jetbrains.plugin.fhir.fsh.FshUtils;
import ch.qligier.jetbrains.plugin.fhir.fsh.grammar.FshLexer;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.tree.IElementType;
import org.antlr.intellij.adaptor.lexer.TokenIElementType;
import org.jspecify.annotations.NonNull;

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
    public Lexer getHighlightingLexer() {
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
    public TextAttributesKey @NonNull [] getTokenHighlights(final IElementType tokenType) {
        if (!(tokenType instanceof final TokenIElementType myType))
            return EMPTY_KEYS;

        switch (myType.getANTLRTokenType()) {
            case FshLexer.STRING:
                return pack(STRING);
            case FshLexer.LINE_COMMENT:
                return pack(LINE_COMMENT);
            case FshLexer.BLOCK_COMMENT:
                return pack(BLOCK_COMMENT);
            case FshLexer.KW_ALIAS:
            case FshLexer.KW_CODESYSTEM:
            case FshLexer.KW_EXTENSION:
            case FshLexer.KW_INSTANCE:
            case FshLexer.KW_INVARIANT:
            case FshLexer.KW_LOGICAL:
            case FshLexer.KW_MAPPING:
            case FshLexer.KW_PROFILE:
            case FshLexer.KW_RESOURCE:
            case FshLexer.KW_RULESET:
            case FshLexer.KW_VALUESET:
                return pack(DECLARATION);
            case FshLexer.KW_CHARACTERISTICS:
            case FshLexer.KW_CONTEXT:
            case FshLexer.KW_DESCRIPTION:
            case FshLexer.KW_EXPRESSION:
            case FshLexer.KW_ID:
            case FshLexer.KW_INSTANCEOF:
            case FshLexer.KW_PARENT:
            case FshLexer.KW_SEVERITY:
            case FshLexer.KW_SOURCE:
            case FshLexer.KW_TARGET:
            case FshLexer.KW_TITLE:
            case FshLexer.KW_USAGE:
            case FshLexer.KW_XPATH:
                return pack(KEYWORD);
            case FshLexer.KW_AND:
            case FshLexer.KW_OR:
            case FshLexer.KW_OBEYS:
            case FshLexer.KW_INCLUDE:
            case FshLexer.KW_EXCLUDE:
                return pack(OPERATOR);
            case FshLexer.COMMA:
                return pack(COMMA);
            case FshLexer.DATETIME:
            case FshLexer.TIME:
            case FshLexer.CANONICAL:
            case FshLexer.REGEX:
            case FshLexer.UNIT:
            case FshLexer.CODE:
            case FshLexer.NUMBER:
                return pack(VALUE);
            case FshLexer.STAR:
                return pack(STAR);
            default:
                return EMPTY_KEYS;
        }
    }
}

package ch.qligier.jetbrains.plugin.fhir.fsh.highlighter;

import ch.qligier.jetbrains.plugin.fhir.fsh.grammar.FshLexer;
import ch.qligier.jetbrains.plugin.fhir.fsh.grammar.FshParser;
import ch.qligier.jetbrains.plugin.fhir.fsh.language.FshLanguage;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.tree.IElementType;
import org.antlr.intellij.adaptor.lexer.ANTLRLexerAdaptor;
import org.antlr.intellij.adaptor.lexer.TokenIElementType;
import org.jetbrains.annotations.NotNull;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

/**
 * jetbrains-language-fsh
 *
 * @author Quentin Ligier
 * @see <a href="https://plugins.jetbrains.com/docs/intellij/syntax-highlighter-and-color-settings-page.html">Syntax
 * Highlighter and Color Settings Page</a>
 * @see <a href="https://plugins.jetbrains.com/docs/intellij/syntax-highlighting-and-error-highlighting.html">Syntax and
 * Error Highlighting</a>
 **/
public class FshSyntaxHighlighter extends SyntaxHighlighterBase {

    public static final TextAttributesKey ID =
            createTextAttributesKey("FSH_ID", DefaultLanguageHighlighterColors.IDENTIFIER);
    public static final TextAttributesKey KEYWORD =
            createTextAttributesKey("FSH_KEYWORD", DefaultLanguageHighlighterColors.KEYWORD);
    public static final TextAttributesKey STRING =
            createTextAttributesKey("FSH_STRING", DefaultLanguageHighlighterColors.STRING);
    public static final TextAttributesKey LINE_COMMENT =
            createTextAttributesKey("FSH_LINE_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT);
    public static final TextAttributesKey BLOCK_COMMENT =
            createTextAttributesKey("FSH_BLOCK_COMMENT", DefaultLanguageHighlighterColors.BLOCK_COMMENT);
    public static final TextAttributesKey NUMBER =
            createTextAttributesKey("FSH_NUMBER", DefaultLanguageHighlighterColors.NUMBER);
    public static final TextAttributesKey METADATA =
            createTextAttributesKey("FSH_METADATA", DefaultLanguageHighlighterColors.METADATA);


    private static final TextAttributesKey[] EMPTY_KEYS = new TextAttributesKey[0];

    /**
     * Returns the lexer used for highlighting the file. The lexer is invoked incrementally when the file is changed, so
     * it must be capable of saving/restoring state and resuming lexing from the middle of the file.
     *
     * @return The lexer implementation.
     */
    @Override
    public @NotNull Lexer getHighlightingLexer() {
        final var lexer = new FshLexer(null);
        return new ANTLRLexerAdaptor(FshLanguage.INSTANCE, lexer);
    }

    /**
     * Returns the list of text attribute keys used for highlighting the specified token type. The attributes of all
     * attribute keys returned for the token type are successively merged to obtain the color and attributes of the
     * token.
     *
     * @param type The token type for which the highlighting is requested.
     * @return The array of text attribute keys.
     */
    @Override
    public TextAttributesKey @NotNull [] getTokenHighlights(final IElementType type) {
        if (!(type instanceof TokenIElementType)) {
            return EMPTY_KEYS;
        }
        final var tokenType = (TokenIElementType) type;

        switch (tokenType.getANTLRTokenType()) {
            // Entity declaration
            case FshParser.KW_ALIAS:
            case FshParser.KW_PROFILE:
            case FshParser.KW_EXTENSION:
            case FshParser.KW_INVARIANT:
            case FshParser.KW_INSTANCE:
            case FshParser.KW_VALUESET:
            case FshParser.KW_CODESYSTEM:
            case FshParser.KW_RULESET:
            case FshParser.KW_MAPPING:
            case FshParser.KW_LOGICAL:
            case FshParser.KW_RESOURCE:
                return pack(KEYWORD);

            case FshParser.IDENTIFIER:
                return pack(createTextAttributesKey("FSH_CLASS_NAME", DefaultLanguageHighlighterColors.CLASS_NAME));

            case FshParser.KW_INSERT:
            case FshParser.KW_EXACTLY:
            case FshParser.KW_FROM:
            case FshParser.KW_ONLY:
            case FshParser.KW_OR:
            case FshParser.KW_TRUE:
            case FshParser.KW_FALSE:
            case FshParser.KW_INCLUDE:
            case FshParser.KW_EXCLUDE:
            case FshParser.KW_OBEYS:
                return pack(KEYWORD);

            // Metadata declaration
            case FshParser.KW_PARENT:
            case FshParser.KW_ID:
            case FshParser.KW_TITLE:
            case FshParser.KW_DESCRIPTION:
            case FshParser.KW_SOURCE:
            case FshParser.KW_TARGET:
            case FshParser.KW_INSTANCEOF:
            case FshParser.KW_USAGE:
            case FshParser.KW_EXPRESSION:
            case FshParser.KW_XPATH:
            case FshParser.KW_SEVERITY:
                return pack(METADATA);

            case FshParser.STRING:
            case FshParser.MULTILINE_STRING:
                return pack(STRING);

            case FshParser.LINE_COMMENT:
                return pack(LINE_COMMENT);

            case FshParser.COMMENT:
                return pack(BLOCK_COMMENT);

            case FshParser.DIGIT:
            case FshParser.DATETIME:
                return pack(NUMBER);

            // Flags
            case FshParser.KW_MOD:
            case FshParser.KW_MS:
            case FshParser.KW_SU:
            case FshParser.KW_TU:
            case FshParser.KW_NORMATIVE:
            case FshParser.KW_DRAFT:
                return pack(METADATA);

            case FshParser.DOT:
            case FshParser.DOUBLE_DOT:
            case FshParser.TRIPLE_DOT:
            case FshParser.ARROW:
            case FshParser.STAR:
            case FshParser.EQUAL:
            case FshParser.PLUS:
            case FshParser.MINUS:
            case FshParser.COMMA:
                return pack(createTextAttributesKey("FSH_SYMBOLS", DefaultLanguageHighlighterColors.PREDEFINED_SYMBOL));

            default:
                return EMPTY_KEYS;
        }
    }
}

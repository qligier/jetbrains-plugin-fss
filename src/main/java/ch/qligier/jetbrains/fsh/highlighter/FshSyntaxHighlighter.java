package ch.qligier.jetbrains.fsh.highlighter;

import ch.qligier.jetbrains.fsh.grammar.FSHLexer;
import ch.qligier.jetbrains.fsh.grammar.FSHParser;
import ch.qligier.jetbrains.fsh.language.FshLanguage;
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
            createTextAttributesKey("SAMPLE_ID", DefaultLanguageHighlighterColors.IDENTIFIER);
    public static final TextAttributesKey KEYWORD =
            createTextAttributesKey("SAMPLE_KEYWORD", DefaultLanguageHighlighterColors.KEYWORD);
    public static final TextAttributesKey STRING =
            createTextAttributesKey("SAMPLE_STRING", DefaultLanguageHighlighterColors.STRING);
    public static final TextAttributesKey LINE_COMMENT =
            createTextAttributesKey("SAMPLE_LINE_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT);
    public static final TextAttributesKey BLOCK_COMMENT =
            createTextAttributesKey("SAMPLE_BLOCK_COMMENT", DefaultLanguageHighlighterColors.BLOCK_COMMENT);
    public static final TextAttributesKey NUMBER =
            createTextAttributesKey("SAMPLE_NUMBER", DefaultLanguageHighlighterColors.NUMBER);
    public static final TextAttributesKey METADATA =
            createTextAttributesKey("SAMPLE_METADATA", DefaultLanguageHighlighterColors.METADATA);

    private static final TextAttributesKey[] EMPTY_KEYS = new TextAttributesKey[0];

    /**
     * Returns the lexer used for highlighting the file. The lexer is invoked incrementally when the file is changed, so
     * it must be capable of saving/restoring state and resuming lexing from the middle of the file.
     *
     * @return The lexer implementation.
     */
    @Override
    public @NotNull Lexer getHighlightingLexer() {
        final var lexer = new FSHLexer(null);
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

        final TextAttributesKey attrKey;
        switch (tokenType.getANTLRTokenType()) {
            case FSHParser.SEQUENCE:
                attrKey = ID;
                break;
            case FSHParser.KW_INSERT:
            case FSHParser.KW_EXACTLY:
            case FSHParser.KW_FROM:
            case FSHParser.KW_ONLY:
            case FSHParser.KW_OR:
            case FSHParser.KW_TRUE:
            case FSHParser.KW_FALSE:
            case FSHParser.KW_INCLUDE:
            case FSHParser.KW_EXCLUDE:
                attrKey = KEYWORD;
                break;
            case FSHParser.STRING:
            case FSHParser.MULTILINE_STRING:
                attrKey = STRING;
                break;
            case FSHParser.LINE_COMMENT:
                attrKey = LINE_COMMENT;
                break;
            case FSHParser.BLOCK_COMMENT:
                attrKey = BLOCK_COMMENT;
                break;
            case FSHParser.CARD:
            case FSHParser.DATETIME:
                attrKey = NUMBER;
                break;
            // Flags
            case FSHParser.KW_MOD:
            case FSHParser.KW_MS:
            case FSHParser.KW_SU:
            case FSHParser.KW_TU:
            case FSHParser.KW_NORMATIVE:
            case FSHParser.KW_DRAFT:
                attrKey = METADATA;
                break;
            default:
                return EMPTY_KEYS;
        }
        return new TextAttributesKey[]{attrKey};
    }
}

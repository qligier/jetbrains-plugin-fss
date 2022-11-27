// Copyright 2022 Quentin Ligier. Use of this source code is governed by the MIT license.

package ch.qligier.jetbrains.plugin.fhir.fsh.highlighter;

import ch.qligier.jetbrains.plugin.fhir.fsh.lexer.FshLexerAdapter;
import ch.qligier.jetbrains.plugin.fhir.fsh.parser.psi.FshTypes;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

/**
 * The syntax highlighter for the FSH language. It associates token types to highlighting color (or highlighting
 * types).
 * <p>
 * Default highlighting types are defined in {@link DefaultLanguageHighlighterColors}.
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
        return new FshLexerAdapter();
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
        // Entity declaration
        if (FshTypes.KWALIAS.equals(type)
                || FshTypes.KWPROFILE.equals(type)
                || FshTypes.KWEXTENSION.equals(type)
                || FshTypes.KWINVARIANT.equals(type)
                || FshTypes.KWINSTANCE.equals(type)
                || FshTypes.KWVALUESET.equals(type)
                || FshTypes.KWCODESYSTEM.equals(type)
                || FshTypes.KWRULESET.equals(type)
                || FshTypes.KWMAPPING.equals(type)
                || FshTypes.KWLOGICAL.equals(type)
                || FshTypes.KWRESOURCE.equals(type)) {
            return pack(KEYWORD);
        } else if (FshTypes.IDENTIFIER.equals(type)) {
            return pack(createTextAttributesKey("FSH_CLASS_NAME", DefaultLanguageHighlighterColors.CLASS_NAME));
        } else if (FshTypes.KWINSERT.equals(type)
                || FshTypes.KWEXACTLY.equals(type)
                || FshTypes.KWFROM.equals(type)
                || FshTypes.KWONLY.equals(type)
                || FshTypes.KWOR.equals(type)
                || FshTypes.KWBOOLEAN.equals(type)
                || FshTypes.KWINCLUDE.equals(type)
                || FshTypes.KWEXCLUDE.equals(type)
                || FshTypes.KWOBEYS.equals(type)) {
            return pack(KEYWORD);

            // Metadata declaration
        } else if (FshTypes.KWPARENT.equals(type)
                || FshTypes.KWID.equals(type)
                || FshTypes.KWTITLE.equals(type)
                || FshTypes.KWDESCRIPTION.equals(type)
                || FshTypes.KWSOURCE.equals(type)
                || FshTypes.KWTARGET.equals(type)
                || FshTypes.KWINSTANCEOF.equals(type)
                || FshTypes.KWUSAGE.equals(type)
                || FshTypes.KWEXPRESSION.equals(type)
                || FshTypes.KWXPATH.equals(type)
                || FshTypes.KWSEVERITY.equals(type)) {
            return pack(METADATA);
        } else if (FshTypes.STRING.equals(type)
                || FshTypes.MULTILINESTRING.equals(type)) {
            return pack(STRING);
        } else if (FshTypes.LINECOMMENT.equals(type)) {
                return pack(LINE_COMMENT);
/*
            case FshTypes.COMMENT:
                return pack(BLOCK_COMMENT);
*/
        } else if (FshTypes.DIGIT.equals(type)
                || FshTypes.DATETIME.equals(type)) {
            return pack(NUMBER);

            // Flags
        } else if (FshTypes.KWFLAG.equals(type)) {
            return pack(METADATA);
        } else if (FshTypes.DOT.equals(type)
                || FshTypes.DOUBLEDOT.equals(type)
                || FshTypes.ARROW.equals(type)
                || FshTypes.STAR.equals(type)
                || FshTypes.EQUAL.equals(type)
                || FshTypes.PLUS.equals(type)
                || FshTypes.COMMA.equals(type)) {
            return pack(createTextAttributesKey("FSH_SYMBOLS", DefaultLanguageHighlighterColors.PREDEFINED_SYMBOL));
        }
        return EMPTY_KEYS;
    }
}

// Copyright 2024 Quentin Ligier. Use of this source code is governed by the MIT license.

package ch.qligier.jetbrains.plugin.fss.igini.language.highlighter;

import ch.qligier.jetbrains.plugin.fss.igini.language.lexer.IniLexerAdapter;
import ch.qligier.jetbrains.plugin.fss.igini.language.psi.IniTypes;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.HighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

/**
 * The syntax highlighter for the INI file format.
 *
 * @author Quentin Ligier
 * @see <a href="https://plugins.jetbrains.com/docs/intellij/syntax-highlighter-and-color-settings-page.html">Syntax
 * Highlighter and Color Settings Page</a>
 * @see <a href="https://plugins.jetbrains.com/docs/intellij/syntax-highlighting-and-error-highlighting.html">Syntax and
 * Error Highlighting</a>
 **/
public class IniSyntaxHighlighter extends SyntaxHighlighterBase {

    public static final TextAttributesKey SEPARATOR =
            createTextAttributesKey("INI_SEPARATOR", DefaultLanguageHighlighterColors.OPERATION_SIGN);
    public static final TextAttributesKey SECTION =
            createTextAttributesKey("INI_SECTION", DefaultLanguageHighlighterColors.KEYWORD);
    public static final TextAttributesKey KEY =
            createTextAttributesKey("INI_KEY", DefaultLanguageHighlighterColors.MARKUP_ATTRIBUTE);
    public static final TextAttributesKey VALUE =
            createTextAttributesKey("INI_VALUE", DefaultLanguageHighlighterColors.STRING);
    public static final TextAttributesKey COMMENT =
            createTextAttributesKey("INI_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT);
    public static final TextAttributesKey BAD_CHARACTER =
            createTextAttributesKey("INI_BAD_CHARACTER", HighlighterColors.BAD_CHARACTER);

    private static final TextAttributesKey[] BAD_CHAR_KEYS = new TextAttributesKey[]{BAD_CHARACTER};
    private static final TextAttributesKey[] SEPARATOR_KEYS = new TextAttributesKey[]{SEPARATOR};
    private static final TextAttributesKey[] SECTION_KEYS = new TextAttributesKey[]{SECTION};
    private static final TextAttributesKey[] KEY_KEYS = new TextAttributesKey[]{KEY};
    private static final TextAttributesKey[] VALUE_KEYS = new TextAttributesKey[]{VALUE};
    private static final TextAttributesKey[] COMMENT_KEYS = new TextAttributesKey[]{COMMENT};
    private static final TextAttributesKey[] EMPTY_KEYS = new TextAttributesKey[0];


    @Override
    public @NotNull Lexer getHighlightingLexer() {
        return new IniLexerAdapter();
    }

    @Override
    public TextAttributesKey @NotNull [] getTokenHighlights(final IElementType iElementType) {
        if (iElementType.equals(IniTypes.EQUAL)) {
            return SEPARATOR_KEYS;
        }
        if (iElementType.equals(IniTypes.SECTION_NAME)) {
            return SECTION_KEYS;
        }
        if (iElementType.equals(IniTypes.PKEY)) {
            return KEY_KEYS;
        }
        if (iElementType.equals(IniTypes.PVALUE)) {
            return VALUE_KEYS;
        }
        if (iElementType.equals(IniTypes.COMMENT)) {
            return COMMENT_KEYS;
        }
        if (iElementType.equals(TokenType.BAD_CHARACTER)) {
            return BAD_CHAR_KEYS;
        }
        return EMPTY_KEYS;
    }
}

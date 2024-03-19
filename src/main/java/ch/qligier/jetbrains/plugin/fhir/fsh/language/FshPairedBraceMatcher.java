// Copyright 2024 Quentin Ligier. Use of this source code is governed by the MIT license.

package ch.qligier.jetbrains.plugin.fhir.fsh.language;

import ch.qligier.jetbrains.plugin.fhir.fsh.FshLanguage;
import ch.qligier.jetbrains.plugin.fhir.fsh.grammar.FshLexer;
import com.intellij.lang.BracePair;
import com.intellij.lang.PairedBraceMatcher;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;
import org.antlr.intellij.adaptor.lexer.PSIElementTypeFactory;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

/**
 * Defines the brace matching support for the FSH language. Only parentheses are supported.
 *
 * @author Quentin Ligier
 * @see <a href="https://plugins.jetbrains.com/docs/intellij/additional-minor-features.html#brace-matching">Brace
 * Matching</a>
 **/
public class FshPairedBraceMatcher implements PairedBraceMatcher {

    private static final BracePair[] PAIRS;

    static {
        final var types = PSIElementTypeFactory.getTokenIElementTypes(FshLanguage.INSTANCE);
        PAIRS = new BracePair[]{
                new BracePair(types.get(FshLexer.LEFT_PAREN),
                              types.get(FshLexer.RIGHT_PAREN),
                              false),
        };
    }

    /**
     * Returns the array of definitions for brace pairs that need to be matched when editing code in the language.
     *
     * @return the array of brace pair definitions.
     */
    @Override
    public BracePair @NonNull [] getPairs() {
        return PAIRS;
    }

    /**
     * Returns {@code true} if paired rbrace should be inserted after lbrace of given type when lbrace is encountered
     * before contextType token. It is safe to always return {@code true}, then paired brace will be inserted anyway.
     *
     * @param lbraceType  lbrace for which information is queried
     * @param contextType token type that follows lbrace
     * @return true / false as described
     */
    @Override
    public boolean isPairedBracesAllowedBeforeType(final IElementType lbraceType,
                                                   @Nullable final IElementType contextType) {
        return true;
    }

    /**
     * Returns the start offset of the code construct which owns the opening structural brace at the specified offset.
     * For example, if the opening brace belongs to an 'if' statement, returns the start offset of the 'if' statement.
     *
     * @param file               the file in which brace matching is performed.
     * @param openingBraceOffset the offset of an opening structural brace.
     * @return the offset of corresponding code construct, or the same offset if not defined.
     */
    @Override
    public int getCodeConstructStart(final PsiFile file, final int openingBraceOffset) {
        return 0;
    }
}

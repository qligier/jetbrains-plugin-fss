// Copyright 2022 Quentin Ligier. Use of this source code is governed by the MIT license.

package ch.qligier.jetbrains.plugin.fhir.fsh.lexer;

import com.intellij.lexer.FlexAdapter;

/**
 * The JFlex lexer needs to be adapted to the IntelliJ Platform Lexer API.
 *
 * @author Quentin Ligier
 * @see <a
 * href="https://plugins.jetbrains.com/docs/intellij/lexer-and-parser-definition.html#define-a-lexer-adapter">Define a
 * Lexer Adapter</a>
 **/
public class FshLexerAdapter extends FlexAdapter {

    /**
     * Constructor.
     */
    public FshLexerAdapter() {
        super(new FshLexer(null));
    }
}

// Copyright 2022 Quentin Ligier. Use of this source code is governed by the MIT license.

package ch.qligier.jetbrains.plugin.fhir.fsh.lexer;

import ch.qligier.jetbrains.plugin.fhir.fsh.parser.psi.FshTypes;
import com.intellij.psi.tree.TokenSet;

/**
 * Some token sets used by Jetbrains IDE for avoiding parsing useless tokens, syntax highlighting and probably some more
 * functionalities.
 *
 * @author Quentin Ligier
 * @see <a
 * href="https://plugins.jetbrains.com/docs/intellij/lexer-and-parser-definition.html#define-simpletokensets">Define
 * SimpleTokenSets</a>
 **/
public class FshTokenSets {

    public static final TokenSet COMMENTS = TokenSet.create(FshTypes.LINECOMMENT, FshTypes.BLOCKCOMMENT);
    public static final TokenSet WHITESPACE = TokenSet.create(FshTypes.WHITESPACE);
    public static final TokenSet STRING = TokenSet.create(FshTypes.STRING, FshTypes.MULTILINESTRING);
}

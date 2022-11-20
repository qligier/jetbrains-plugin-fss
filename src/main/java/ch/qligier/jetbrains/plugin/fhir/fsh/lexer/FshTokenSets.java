// Copyright 2022 Quentin Ligier. Use of this source code is governed by the MIT license.

package ch.qligier.jetbrains.plugin.fhir.fsh.lexer;

import ch.qligier.jetbrains.plugin.fhir.fsh.parser.psi.FshTypes;
import com.intellij.psi.tree.TokenSet;

/**
 * jetbrains-language-fsh
 *
 * @author Quentin Ligier
 **/
public class FshTokenSets {

    /*public static final TokenSet COMMENTS = TokenSet.create(FshTypes.LINECOMMENT,
                                                            FshTypes.BLOCKCOMMENT);*/
    public static final TokenSet WHITESPACE = TokenSet.create(FshTypes.WHITESPACE);
    public static final TokenSet STRING = TokenSet.create(FshTypes.STRING,
                                                          FshTypes.MULTILINESTRING);
}

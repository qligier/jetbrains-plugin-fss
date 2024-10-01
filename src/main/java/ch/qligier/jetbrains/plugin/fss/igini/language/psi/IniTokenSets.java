// Copyright 2024 Quentin Ligier. Use of this source code is governed by the MIT license.

package ch.qligier.jetbrains.plugin.fss.igini.language.psi;

import com.intellij.psi.tree.TokenSet;

/**
 * jetbrains-plugin-fss
 *
 * @author Quentin Ligier
 **/
public interface IniTokenSets {

    TokenSet COMMENTS = TokenSet.create(IniTypes.COMMENT);
}

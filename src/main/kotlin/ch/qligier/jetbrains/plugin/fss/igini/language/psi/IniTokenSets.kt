/*
 * Copyright 2025 Quentin Ligier. Use of this source code is governed by the MIT license.
 */

package ch.qligier.jetbrains.plugin.fss.igini.language.psi

import com.intellij.psi.tree.TokenSet

interface IniTokenSets {
    companion object {
        val COMMENTS: TokenSet = TokenSet.create(IniTypes.COMMENT)
    }
}

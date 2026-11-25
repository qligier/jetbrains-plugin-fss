/*
 * Copyright 2026 Quentin Ligier. Use of this source code is governed by the MIT license.
 */
package ch.qligier.jetbrains.plugin.fss.fsh.language.psi

import com.intellij.psi.tree.TokenSet

object FshTokenSets {
    @JvmField
    val COMMENTS: TokenSet = TokenSet.create(FshTypes.LINE_COMMENT, FshTypes.BLOCK_COMMENT)

    @JvmField
    val STRINGS: TokenSet = TokenSet.create(FshTypes.STRING, FshTypes.MULTILINE_STRING)
}

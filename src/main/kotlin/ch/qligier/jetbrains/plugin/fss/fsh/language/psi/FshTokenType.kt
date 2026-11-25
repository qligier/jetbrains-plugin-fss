/*
 * Copyright 2026 Quentin Ligier. Use of this source code is governed by the MIT license.
 */
package ch.qligier.jetbrains.plugin.fss.fsh.language.psi

import ch.qligier.jetbrains.plugin.fss.fsh.FshLanguage
import com.intellij.psi.tree.IElementType

class FshTokenType(
    debugName: String,
) : IElementType(debugName, FshLanguage) {
    override fun toString(): String = "FshTokenType." + super.toString()
}

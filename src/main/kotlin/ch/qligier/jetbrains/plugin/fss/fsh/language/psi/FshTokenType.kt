/*
 * Copyright 2026 Quentin Ligier. Use of this source code is governed by the MIT license.
 */

package ch.qligier.jetbrains.plugin.fss.fsh.language.psi

import ch.qligier.jetbrains.plugin.fss.fsh.FshLanguage
import com.intellij.psi.tree.IElementType
import org.jetbrains.annotations.NonNls

class FshTokenType(debugName: @NonNls String) : IElementType(debugName, FshLanguage) {
    override fun toString(): String {
        return "FshTokenType." + super.toString()
    }
}


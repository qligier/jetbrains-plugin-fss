/*
 * Copyright 2025 Quentin Ligier. Use of this source code is governed by the MIT license.
 */

package ch.qligier.jetbrains.plugin.fss.igini.language.psi

import ch.qligier.jetbrains.plugin.fss.igini.IgIniLanguage
import com.intellij.psi.tree.IElementType
import org.jetbrains.annotations.NonNls

class IniTokenType(debugName: @NonNls String) : IElementType(debugName, IgIniLanguage) {
    override fun toString(): String {
        return "IniTokenType." + super.toString()
    }
}

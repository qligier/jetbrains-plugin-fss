/*
 * Copyright 2025 Quentin Ligier. Use of this source code is governed by the MIT license.
 */
package ch.qligier.jetbrains.plugin.fss.ig_ini.language.psi

import ch.qligier.jetbrains.plugin.fss.ig_ini.IgIniLanguage
import com.intellij.psi.tree.IElementType
import org.jetbrains.annotations.NonNls

class IniElementType(debugName: @NonNls String) : IElementType(debugName, IgIniLanguage)

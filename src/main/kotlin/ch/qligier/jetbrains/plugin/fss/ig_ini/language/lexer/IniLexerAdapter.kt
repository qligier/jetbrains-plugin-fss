/*
 * Copyright 2025 Quentin Ligier. Use of this source code is governed by the MIT license.
 */

package ch.qligier.jetbrains.plugin.fss.ig_ini.language.lexer

import ch.qligier.jetbrains.plugin.fss.ig_ini.language.IniLexer
import com.intellij.lexer.FlexAdapter

class IniLexerAdapter : FlexAdapter(IniLexer(null))

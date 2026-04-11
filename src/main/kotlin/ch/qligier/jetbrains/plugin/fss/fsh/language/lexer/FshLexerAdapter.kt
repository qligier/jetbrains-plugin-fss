/*
 * Copyright 2026 Quentin Ligier. Use of this source code is governed by the MIT license.
 */

package ch.qligier.jetbrains.plugin.fss.fsh.language.lexer

import ch.qligier.jetbrains.plugin.fss.fsh.language.FshLexer
import com.intellij.lexer.FlexAdapter

class FshLexerAdapter : FlexAdapter(FshLexer(null))


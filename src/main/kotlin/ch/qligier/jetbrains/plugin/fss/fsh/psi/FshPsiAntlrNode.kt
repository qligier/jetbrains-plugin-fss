// Copyright 2025 Quentin Ligier. Use of this source code is governed by the MIT license.
package ch.qligier.jetbrains.plugin.fss.fsh.psi

import com.intellij.lang.ASTNode
import org.antlr.intellij.adaptor.psi.ANTLRPsiNode

/**
 * Represents a PSI node in the FSH language.
 */
open class FshPsiAntlrNode(node: ASTNode) : ANTLRPsiNode(node)

// Copyright 2025 Quentin Ligier. Use of this source code is governed by the MIT license.
package ch.qligier.jetbrains.plugin.fss.fsh.psi

import com.intellij.lang.ASTNode
import org.antlr.intellij.adaptor.psi.ANTLRPsiNode

class DebugPsiNode(
    private val node: ASTNode,
    private val text: String?
) : ANTLRPsiNode(node) {
    override fun toString(): String {
        return javaClass.getSimpleName() + "(" + node.elementType + ", " + text + ")"
    }
}

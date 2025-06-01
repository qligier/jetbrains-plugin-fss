// Copyright 2025 Quentin Ligier. Use of this source code is governed by the MIT license.
package ch.qligier.jetbrains.plugin.fss.fsh.psi

import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNameIdentifierOwner
import com.intellij.util.IncorrectOperationException
import org.antlr.intellij.adaptor.psi.ANTLRPsiNode

/**
 * @see org.antlr.intellij.adaptor.psi.IdentifierDefSubtree
 */
class FshPsiName(node: ASTNode) : ANTLRPsiNode(node), PsiNameIdentifierOwner {
    init {
        System.out.printf("FshPsiName.<init> text=%s%n", node.text)
    }

    /**
     * @return
     */
    override fun getNameIdentifier(): PsiElement? {
        return null
    }

    /**
     * Renames the element.
     *
     * @param name the new element name.
     * @return the element corresponding to this element after the renaming (either `this` or a different element
     * if the renaming caused the element to be replaced).
     * @throws IncorrectOperationException if the modification is not supported or not possible for some reason.
     */
    @Throws(IncorrectOperationException::class)
    override fun setName(name: String): PsiElement? {
        return null
    }
}

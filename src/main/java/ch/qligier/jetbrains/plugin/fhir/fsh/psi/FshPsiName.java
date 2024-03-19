// Copyright 2024 Quentin Ligier. Use of this source code is governed by the MIT license.

package ch.qligier.jetbrains.plugin.fhir.fsh.psi;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiNameIdentifierOwner;
import com.intellij.util.IncorrectOperationException;
import org.antlr.intellij.adaptor.psi.ANTLRPsiNode;
import org.jspecify.annotations.Nullable;

/**
 * jetbrains-plugin-fhir
 *
 * @author Quentin Ligier
 * @see org.antlr.intellij.adaptor.psi.IdentifierDefSubtree
 **/
public class FshPsiName extends ANTLRPsiNode implements PsiNameIdentifierOwner {

    public FshPsiName(final ASTNode node) {
        super(node);
        System.out.printf("FshPsiName.<init> text=%s%n", node.getText());
    }

    /**
     * @return
     */
    @Override
    public @Nullable PsiElement getNameIdentifier() {
        return null;
    }

    /**
     * Renames the element.
     *
     * @param name the new element name.
     * @return the element corresponding to this element after the renaming (either {@code this} or a different element
     * if the renaming caused the element to be replaced).
     * @throws IncorrectOperationException if the modification is not supported or not possible for some reason.
     */
    @Override
    public PsiElement setName(final String name) throws IncorrectOperationException {
        return null;
    }
}

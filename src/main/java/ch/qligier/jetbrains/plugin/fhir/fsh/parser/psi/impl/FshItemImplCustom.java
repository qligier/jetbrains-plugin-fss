// Copyright 2022 Quentin Ligier. Use of this source code is governed by the MIT license.

package ch.qligier.jetbrains.plugin.fhir.fsh.parser.psi.impl;

import ch.qligier.jetbrains.plugin.fhir.fsh.parser.psi.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiNameIdentifierOwner;
import com.intellij.psi.impl.source.tree.LeafPsiElement;
import com.intellij.util.IncorrectOperationException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * Implementation of custom methods for FSH item PSI elements.
 *
 * @author Quentin Ligier
 * @see FshItemCustom
 */
public abstract class FshItemImplCustom extends ASTWrapperPsiElement implements FshItemCustom {

    /**
     * Constructor.
     *
     * @param node The AST node.
     */
    public FshItemImplCustom(@NotNull final ASTNode node) {
        super(node);
    }

    /**
     * Returns the name of the element.
     *
     * @return the element name.
     */
    @Override
    public String getName() {
        final ASTNode keyNode = this.getNode().findChildByType(FshTypes.IDENTIFIER);
        if (keyNode != null) {
            return keyNode.getText();
        } else {
            return null;
        }
    }

    /**
     * Renames the element.
     *
     * @param newName the new element name.
     * @return the element corresponding to this element after the renaming (either {@code this} or a different element
     * if the renaming caused the element to be replaced).
     * @throws IncorrectOperationException if the modification is not supported or not possible for some reason.
     */
    @Override
    public PsiElement setName(@NotNull final String newName) {
        final ASTNode keyNode = this.getNode().findChildByType(FshTypes.IDENTIFIER);
        if (keyNode instanceof LeafPsiElement) {
            ((LeafPsiElement) keyNode).replaceWithText(newName);
        }
        return this;
    }

    /**
     * Implementation of {@link PsiNameIdentifierOwner#getNameIdentifier()}.
     *
     * @return
     */
    @Override
    public PsiElement getNameIdentifier() {
        final var keyNode = this.getNode().findChildByType(FshTypes.IDENTIFIER);
        if (keyNode != null) {
            return keyNode.getPsi();
        } else {
            return null;
        }
    }

    /**
     * Retrieves all PSI elements of item metadata.
     */
    @Override
    public List<FshMetadata> getMetadataElements() {
        return List.of(this.findChildrenByClass(FshMetadata.class));
    }

    /**
     * Retrieves the PSI element of an ID metadata.
     */
    @Nullable
    @Override
    public FshId getMetadataIdElement() {
        return this.findChildByClass(FshId.class);
    }

    /**
     * Retrieves the PSI element of a title metadata.
     */
    @Nullable
    @Override
    public FshTitle getMetadataTitleElement() {
        return this.findChildByClass(FshTitle.class);
    }
}

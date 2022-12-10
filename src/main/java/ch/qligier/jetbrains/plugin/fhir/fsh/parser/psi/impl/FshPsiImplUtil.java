// Copyright 2022 Quentin Ligier. Use of this source code is governed by the MIT license.

package ch.qligier.jetbrains.plugin.fhir.fsh.parser.psi.impl;

import ch.qligier.jetbrains.plugin.fhir.fsh.parser.psi.*;
import ch.qligier.jetbrains.plugin.fhir.fsh.reference.FshReference;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.impl.source.tree.LeafPsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;

/**
 * Utility methods that are inserted in PSI files by the parser generator.
 *
 * @author Quentin Ligier
 * @see <a
 * href="https://plugins.jetbrains.com/docs/intellij/reference-contributor.html#define-helper-methods-for-generated-psi-elements">Define
 * Helper Methods for Generated PSI Elements</a>
 */
public class FshPsiImplUtil {

    /**
     * This class is not instantiable.
     */
    private FshPsiImplUtil() {
    }

    @Nullable
    public static PsiElement getValueElement(@NotNull final FshMetadata metadataElement) {
        return metadataElement.getFirstChild();
    }

    public static String getName(@NotNull final FshId element) {
        final ASTNode keyNode = element.getNode().findChildByType(FshTypes.IDENTIFIER);
        if (keyNode != null) {
            return keyNode.getText();
        } else {
            return null;
        }
    }

    public static PsiElement setName(@NotNull final FshId element, String newName) {
        ASTNode keyNode = element.getNode().findChildByType(FshTypes.IDENTIFIER);
        if (keyNode instanceof LeafPsiElement) {
            ((LeafPsiElement) keyNode).replaceWithText(newName);
        }
        return element;
    }

    public static PsiElement getNameIdentifier(@NotNull final FshId element) {
        ASTNode keyNode = element.getNode().findChildByType(FshTypes.IDENTIFIER);
        return keyNode != null ? keyNode.getPsi() : null;
    }

    public static FshReference getReference(@NotNull final FshIdentifierRef identifier) {
        return new FshReference(identifier, identifier.getTextRangeInParent());
    }

    public static FshReference getReference(@NotNull final FshItemIdentifier identifier) {
        final var child = identifier.getFirstChild();
        // The ItemIdentifier should contain a leaf PsiElement(Identifier) that must be used here
        if (child != null) {
            return new FshReference(identifier, child.getTextRangeInParent());
        }
        return null;
    }

    public static int getParameterCount(@NotNull final FshRuleSetReference ruleSetReference) {
        // The item name identifier is inside a FshIdentifierRef, it won't appear here
        return (int) Arrays.stream(ruleSetReference.getChildren())
                .filter(child -> child.getNode().getElementType() == FshTypes.IDENTIFIER)
                .count();
    }
}

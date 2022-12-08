// Copyright 2022 Quentin Ligier. Use of this source code is governed by the MIT license.

package ch.qligier.jetbrains.plugin.fhir.fsh.parser.psi.impl;

import ch.qligier.jetbrains.plugin.fhir.fsh.parser.psi.FshId;
import ch.qligier.jetbrains.plugin.fhir.fsh.parser.psi.FshMetadata;
import ch.qligier.jetbrains.plugin.fhir.fsh.parser.psi.FshTypes;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.impl.source.tree.LeafPsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

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
}

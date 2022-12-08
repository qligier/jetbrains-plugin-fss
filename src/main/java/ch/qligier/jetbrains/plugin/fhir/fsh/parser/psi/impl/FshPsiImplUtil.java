// Copyright 2022 Quentin Ligier. Use of this source code is governed by the MIT license.

package ch.qligier.jetbrains.plugin.fhir.fsh.parser.psi.impl;

import ch.qligier.jetbrains.plugin.fhir.fsh.parser.psi.FshItem;
import ch.qligier.jetbrains.plugin.fhir.fsh.parser.psi.FshTypes;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiNameIdentifierOwner;
import org.jetbrains.annotations.NotNull;

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

    public static String getKey(@NotNull final FshItem element) {
        final var keyNode = element.getNode().findChildByType(FshTypes.IDENTIFIER);
        if (keyNode != null) {
            return keyNode.getText();
        } else {
            return null;
        }
    }

    public static String getName(@NotNull final FshItem element) {
        return getKey(element);
    }

    public static PsiElement setName(@NotNull final FshItem element, @NotNull final String newName) {
        ASTNode keyNode = element.getNode().findChildByType(FshTypes.IDENTIFIER);
        if (keyNode != null) {
            //keyNode.
        }
        return element;
    }

    /**
     * Implementation of {@link PsiNameIdentifierOwner#getNameIdentifier()} for {@link FshItem}.
     *
     * @param element
     * @return
     */
    public static PsiElement getNameIdentifier(@NotNull final FshItem element) {
        final var keyNode = element.getNode().findChildByType(FshTypes.IDENTIFIER);
        if (keyNode != null) {
            return keyNode.getPsi();
        } else {
            return null;
        }
    }
}

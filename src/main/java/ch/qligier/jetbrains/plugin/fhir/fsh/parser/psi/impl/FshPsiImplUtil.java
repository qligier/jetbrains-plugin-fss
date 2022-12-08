// Copyright 2022 Quentin Ligier. Use of this source code is governed by the MIT license.

package ch.qligier.jetbrains.plugin.fhir.fsh.parser.psi.impl;

import ch.qligier.jetbrains.plugin.fhir.fsh.parser.psi.FshMetadata;
import com.intellij.psi.PsiElement;
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
}

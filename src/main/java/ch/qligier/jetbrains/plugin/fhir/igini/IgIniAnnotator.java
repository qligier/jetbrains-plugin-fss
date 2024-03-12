// Copyright 2023 Quentin Ligier. Use of this source code is governed by the MIT license.

package ch.qligier.jetbrains.plugin.fhir.igini;

import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.lang.annotation.Annotator;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import org.jetbrains.annotations.NotNull;

/**
 * jetbrains-plugin-fhir
 *
 * @author Quentin Ligier
 **/
public class IgIniAnnotator implements Annotator {
    /**
     * Annotates the specified PSI element. It is guaranteed to be executed in non-reentrant fashion. I.e there will be
     * no call of this method for this instance before previous call get completed. Multiple instances of the annotator
     * might exist simultaneously, though.
     *
     * @param element to annotate.
     * @param holder  the container which receives annotations created by the plugin.
     */
    @Override
    public void annotate(@NotNull final PsiElement element, @NotNull final AnnotationHolder holder) {
        System.out.println("IgIniAnnotator.annotate");

        final PsiFile containingFile = element.getContainingFile();
        if (containingFile == null || !containingFile.getName().equals("ig.ini")) {
            return;
        }

        System.out.println("Annotate ig.ini");
    }
}

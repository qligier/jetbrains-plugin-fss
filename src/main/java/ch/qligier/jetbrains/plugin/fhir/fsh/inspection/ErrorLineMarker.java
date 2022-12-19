// Copyright 2022 Quentin Ligier. Use of this source code is governed by the MIT license.

package ch.qligier.jetbrains.plugin.fhir.fsh.inspection;

import com.intellij.codeInsight.daemon.RelatedItemLineMarkerInfo;
import com.intellij.codeInsight.daemon.RelatedItemLineMarkerProvider;
import com.intellij.codeInsight.navigation.NavigationGutterIconBuilder;
import com.intellij.icons.AllIcons;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiErrorElement;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;

/**
 * A class that adds error markers in the left gutter for PSI error elements.
 *
 * @author Quentin Ligier
 **/
public class ErrorLineMarker extends RelatedItemLineMarkerProvider {

    /**
     * @param element
     * @param result
     */
    @Override
    protected void collectNavigationMarkers(@NotNull final PsiElement element,
                                            @NotNull final Collection<? super RelatedItemLineMarkerInfo<?>> result) {
        if (element instanceof PsiErrorElement) {
            final var errorElement = (PsiErrorElement) element;
            final var builder = NavigationGutterIconBuilder.create(AllIcons.Ide.FatalError)
                    .setTarget(errorElement)
                    .setTooltipText(errorElement.getErrorDescription());
            result.add(builder.createLineMarkerInfo(element));
        }
    }
}

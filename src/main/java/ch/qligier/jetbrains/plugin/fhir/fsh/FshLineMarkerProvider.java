/*
 * Copyright 2022 Quentin Ligier. Use of this source code is governed by the MIT license
 */

package ch.qligier.jetbrains.plugin.fhir.fsh;

import com.intellij.codeInsight.daemon.RelatedItemLineMarkerInfo;
import com.intellij.codeInsight.daemon.RelatedItemLineMarkerProvider;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;

/**
 * Line markers help annotate code with icons on the gutter. These markers can provide navigation targets to related
 * code.
 *
 * @author Quentin Ligier
 * @see <a
 * href="https://plugins.jetbrains.com/docs/intellij/line-marker-provider.html#define-a-line-marker-provider">Line
 * Marker Provider</a>
 **/
public class FshLineMarkerProvider extends RelatedItemLineMarkerProvider {

    /**
     * @param element
     * @param result
     */
    @Override
    protected void collectNavigationMarkers(@NotNull final PsiElement element,
                                            @NotNull final Collection<? super RelatedItemLineMarkerInfo<?>> result) {
        super.collectNavigationMarkers(element, result);
    }
}

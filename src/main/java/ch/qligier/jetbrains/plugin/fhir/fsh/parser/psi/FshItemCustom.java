// Copyright 2022 Quentin Ligier. Use of this source code is governed by the MIT license.

package ch.qligier.jetbrains.plugin.fhir.fsh.parser.psi;

import ch.qligier.jetbrains.plugin.fhir.fsh.FshItemType;
import ch.qligier.jetbrains.plugin.fhir.fsh.FshMetadataPolicy;
import ch.qligier.jetbrains.plugin.fhir.fsh.FshNameType;
import com.intellij.navigation.ItemPresentation;
import com.intellij.psi.PsiNameIdentifierOwner;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * Custom methods for FSH item PSI elements.
 *
 * @author Quentin Ligier
 * @see ch.qligier.jetbrains.plugin.fhir.fsh.parser.psi.impl.FshItemImplCustom
 **/
public interface FshItemCustom extends PsiNameIdentifierOwner {

    List<FshMetadata> getMetadataElements();

    @Nullable
    FshId getIdElement();

    @Nullable
    FshDescription getDescriptionElement();

    @Nullable
    FshTitle getTitleElement();

    @Nullable
    FshParent getParentElement();

    @Nullable
    FshInstanceOf getInstanceOfElement();

    @Nullable
    FshUsage getUsageElement();

    @Nullable
    FshSource getSourceElement();

    @Nullable
    FshTarget getTargetElement();

    @Nullable
    FshSeverity getSeverityElement();

    @Nullable
    FshXpath getXPathElement();

    @Nullable
    FshExpression getExpressionElement();

    FshItemType getItemType();

    String getFoldedPlaceholder();

    ItemPresentation getPresentation();

    FshNameType getNameType();

    FshMetadataPolicy getMetadataPolicy();

    <T> T @NotNull [] findChildrenByClass(Class<T> aClass);
}

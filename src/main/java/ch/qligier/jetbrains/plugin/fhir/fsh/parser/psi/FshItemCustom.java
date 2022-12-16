// Copyright 2022 Quentin Ligier. Use of this source code is governed by the MIT license.

package ch.qligier.jetbrains.plugin.fhir.fsh.parser.psi;

import ch.qligier.jetbrains.plugin.fhir.fsh.specification.ItemNameType;
import ch.qligier.jetbrains.plugin.fhir.fsh.specification.ItemType;
import ch.qligier.jetbrains.plugin.fhir.fsh.specification.MetadataPolicy;
import ch.qligier.jetbrains.plugin.fhir.fsh.specification.MetadataType;
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

    List<FshMetadata> getMetadataElements(final MetadataType type);

    @Nullable
    FshMetadata getMetadata(final MetadataType type);

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

    ItemType getItemType();

    String getFoldedPlaceholder();

    ItemPresentation getPresentation();

    ItemNameType getNameType();

    MetadataPolicy getMetadataPolicy();

    <T> T @NotNull [] findChildrenByClass(Class<T> aClass);
}

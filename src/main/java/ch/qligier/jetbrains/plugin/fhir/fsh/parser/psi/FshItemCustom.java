// Copyright 2022 Quentin Ligier. Use of this source code is governed by the MIT license.

package ch.qligier.jetbrains.plugin.fhir.fsh.parser.psi;

import com.intellij.psi.PsiNameIdentifierOwner;
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
    FshId getMetadataIdElement();

    @Nullable
    FshTitle getMetadataTitleElement();
}

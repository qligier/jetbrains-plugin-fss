// Copyright 2022 Quentin Ligier. Use of this source code is governed by the MIT license.

package ch.qligier.jetbrains.plugin.fhir.fsh.reference;

import ch.qligier.jetbrains.plugin.fhir.fsh.FshUtil;
import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * A reference to a named item in FSH.
 *
 * @author Quentin Ligier
 * @see <a href="https://plugins.jetbrains.com/docs/intellij/reference-contributor.html#define-a-reference">Define a
 * Reference</a>
 **/
public class FshReference extends PsiReferenceBase<PsiElement> implements PsiPolyVariantReference {

    /**
     * The name of the item.
     */
    private final String name;

    /**
     * @param element        Underlying element.
     * @param rangeInElement Reference range {@link PsiReference#getRangeInElement() relative to given element}.
     */
    public FshReference(@NotNull final PsiElement element,
                        final TextRange rangeInElement) {
        super(element, rangeInElement);
        this.name = element.getText().substring(rangeInElement.getStartOffset(), rangeInElement.getEndOffset());
    }

    /**
     * Returns the results of resolving the reference.
     *
     * @param incompleteCode if true, the code in the context of which the reference is being resolved is considered
     *                       incomplete, and the method may return additional invalid results.
     * @return the array of results for resolving the reference.
     */
    @Override
    public ResolveResult @NotNull [] multiResolve(final boolean incompleteCode) {
        return FshUtil.findItems(this.myElement.getProject(), this.name).stream()
                .map(PsiElementResolveResult::new)
                .toArray(ResolveResult[]::new);
    }

    /**
     * Returns the element which is the target of the reference.
     *
     * @return the target element, or {@code null} if it was not possible to resolve the reference to a valid target.
     * @see PsiPolyVariantReference#multiResolve(boolean)
     */
    @Override
    public @Nullable PsiElement resolve() {
        final ResolveResult[] results = this.multiResolve(false);
        return results.length > 0 ? results[0].getElement() : null;
    }

    /**
     * Returns the array of String, {@link PsiElement} and/or {@link LookupElement} instances representing all
     * identifiers that are visible at the location of the reference. The contents of the returned array are used to
     * build the lookup list for basic code completion. (The list of visible identifiers may not be filtered by the
     * completion prefix string - the filtering is performed later by the IDE.)
     * <p>
     * This method is default since 2018.3.
     *
     * @return the array of available identifiers.
     */
    @Override
    public Object @NotNull [] getVariants() {
        return super.getVariants();
    }
}

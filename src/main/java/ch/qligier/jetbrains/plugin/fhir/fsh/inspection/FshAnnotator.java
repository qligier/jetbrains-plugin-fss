// Copyright 2022 Quentin Ligier. Use of this source code is governed by the MIT license.

package ch.qligier.jetbrains.plugin.fhir.fsh.inspection;

import ch.qligier.jetbrains.plugin.fhir.fsh.parser.psi.FshId;
import ch.qligier.jetbrains.plugin.fhir.fsh.parser.psi.FshItem;
import ch.qligier.jetbrains.plugin.fhir.fsh.parser.psi.FshMetadata;
import ch.qligier.jetbrains.plugin.fhir.fsh.specification.ItemNameType;
import ch.qligier.jetbrains.plugin.fhir.fsh.specification.MetadataPolicy;
import ch.qligier.jetbrains.plugin.fhir.fsh.specification.MetadataType;
import com.intellij.codeInspection.ProblemHighlightType;
import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.lang.annotation.Annotator;
import com.intellij.lang.annotation.HighlightSeverity;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.regex.Pattern;

/**
 * An annotator of FSH PSI elements.
 *
 * @author Quentin Ligier
 * @see <a href="https://plugins.jetbrains.com/docs/intellij/annotator.html">Annotator</a>
 * @see <a
 * href="https://plugins.jetbrains.com/docs/intellij/syntax-highlighting-and-error-highlighting.html#annotator">Annotator</a>
 **/
public class FshAnnotator implements Annotator {

    // As seen in http://hl7.org/fhir/R4/structuredefinition-definitions.html#StructureDefinition.name
    private static final Pattern ITEM_NAME_PATTERN = Pattern.compile("^[A-Z]([A-Za-z0-9_]){0,254}$");

    /**
     * Annotates the specified PSI element. It is guaranteed to be executed in non-reentrant fashion. I.e there will be
     * no call of this method for this instance before previous call get completed. Multiple instances of the annotator
     * might exist simultaneously, though.
     *
     * @param element to annotate.
     * @param holder  the container which receives annotations created by the plugin.
     */
    @Override
    public void annotate(@NotNull final PsiElement element,
                         @NotNull final AnnotationHolder holder) {
        if (element instanceof FshItem) {
            this.annotateItem((FshItem) element, holder);
        } else if (element instanceof FshMetadata) {
            if (element instanceof FshId) {
                this.annotateItemId((FshId) element, holder);
            }
        }
    }

    protected void annotateItem(@NotNull final FshItem item,
                                @NotNull final AnnotationHolder holder) {
        final var itemName = item.getName();
        if (itemName != null) {
            if (item.getNameType() == ItemNameType.NAME) {
                if (!ITEM_NAME_PATTERN.matcher(itemName).matches()) {
                    holder.newAnnotation(HighlightSeverity.ERROR,
                                         "An item name MUST be between 1 and 255 characters, begin with an uppercase letter and contain only letters, numbers, and underscores.")
                            .highlightType(ProblemHighlightType.ERROR)
                            .create();
                }
            } else {
                if (itemName.length() > 64) {
                    holder.newAnnotation(HighlightSeverity.ERROR,
                                         "An alias name length MUST NOT be more than 64 characters.")
                            .highlightType(ProblemHighlightType.ERROR)
                            .create();
                }
            }
        }


        final var metadataPolicy = item.getItemType().getMetadataPolicy();
        final var annotationParentTarget = Objects.requireNonNullElse(item.getNameIdentifier(), item);
        for (final MetadataType metadataType : MetadataType.values()) {
            final var children = item.getMetadataElements(metadataType);

            // Check that it doesn't appear multiple times
            for (int i = 1; i < children.size(); ++i) {
                holder.newAnnotation(HighlightSeverity.ERROR,
                                     "The metadata " + metadataType.getName() + " shall not appear more than once")
                        .highlightType(ProblemHighlightType.ERROR)
                        .range(children.get(i))
                        .create();
            }

            // Check that it appears if it's required, or that it doesn't appear if it's forbidden
            final MetadataPolicy.Cardinality cardinality = metadataPolicy.getCardinality(metadataType);
            if (cardinality == MetadataPolicy.Cardinality.REQUIRED && children.isEmpty()) {
                holder.newAnnotation(HighlightSeverity.ERROR,
                                     "The metadata " + metadataType.getName() + " is required but missing in item " + item.getItemType().getName())
                        .highlightType(ProblemHighlightType.ERROR)
                        .range(annotationParentTarget)
                        .create();
            } else if (cardinality == MetadataPolicy.Cardinality.FORBIDDEN && !children.isEmpty()) {
                for (final var child : children) {
                    holder.newAnnotation(HighlightSeverity.ERROR,
                                         "The metadata " + metadataType.getName() + " is forbidden but present in " +
                                                 "item " + item.getItemType().getName())
                            .highlightType(ProblemHighlightType.ERROR)
                            .range(child)
                            .create();
                }
            }
        }
    }

    protected void annotateItemId(@NotNull final FshId itemIdElement,
                                  @NotNull final AnnotationHolder holder) {
        if (Objects.requireNonNull(itemIdElement.getName()).length() > 64) {
            holder.newAnnotation(HighlightSeverity.ERROR,
                                 "An id length MUST NOT be more than 64 characters.")
                    .highlightType(ProblemHighlightType.ERROR)
                    .create();
        }
    }
}

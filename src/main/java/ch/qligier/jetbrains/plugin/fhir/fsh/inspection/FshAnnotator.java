// Copyright 2022 Quentin Ligier. Use of this source code is governed by the MIT license.

package ch.qligier.jetbrains.plugin.fhir.fsh.inspection;

import ch.qligier.jetbrains.plugin.fhir.fsh.parser.psi.*;
import ch.qligier.jetbrains.plugin.fhir.fsh.specification.ItemNameType;
import ch.qligier.jetbrains.plugin.fhir.fsh.specification.MetadataPolicy;
import com.intellij.codeInspection.ProblemHighlightType;
import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.lang.annotation.Annotator;
import com.intellij.lang.annotation.HighlightSeverity;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
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

    private static final List<Class<? extends FshMetadata>> ITEM_METADATA_CLASSES = List.of(FshId.class,
                                                                                            FshDescription.class,
                                                                                            FshTitle.class,
                                                                                            FshParent.class,
                                                                                            FshInstanceOf.class,
                                                                                            FshUsage.class,
                                                                                            FshSource.class,
                                                                                            FshTarget.class,
                                                                                            FshSeverity.class,
                                                                                            FshXpath.class,
                                                                                            FshExpression.class);

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
        if (item.getNameType() == ItemNameType.NAME) {
            if (!ITEM_NAME_PATTERN.matcher(Objects.requireNonNull(item.getName())).matches()) {
                holder.newAnnotation(HighlightSeverity.ERROR,
                                     "An item name MUST be between 1 and 255 characters, begin with an uppercase letter and contain only letters, numbers, and underscores.")
                        .highlightType(ProblemHighlightType.ERROR)
                        .create();
            }
        } else {
            if (Objects.requireNonNull(item.getName()).length() > 64) {
                holder.newAnnotation(HighlightSeverity.ERROR,
                                     "An alias name length MUST NOT be more than 64 characters.")
                        .highlightType(ProblemHighlightType.ERROR)
                        .create();
            }
        }

        this.annotateItemMetadata(item,
                                  "Id",
                                  item.getIdElement(),
                                  item.getMetadataPolicy().getId(),
                                  holder);
        this.annotateItemMetadata(item,
                                  "Description",
                                  item.getDescriptionElement(),
                                  item.getMetadataPolicy().getDescription(),
                                  holder);
        this.annotateItemMetadata(item,
                                  "Title",
                                  item.getTitleElement(),
                                  item.getMetadataPolicy().getTitle(),
                                  holder);
        this.annotateItemMetadata(item,
                                  "Parent",
                                  item.getParentElement(),
                                  item.getMetadataPolicy().getParent(),
                                  holder);
        this.annotateItemMetadata(item,
                                  "InstanceOf",
                                  item.getInstanceOfElement(),
                                  item.getMetadataPolicy().getInstanceOf(),
                                  holder);
        this.annotateItemMetadata(item,
                                  "Usage",
                                  item.getUsageElement(),
                                  item.getMetadataPolicy().getUsage(),
                                  holder);
        this.annotateItemMetadata(item,
                                  "Source",
                                  item.getSourceElement(),
                                  item.getMetadataPolicy().getSource(),
                                  holder);
        this.annotateItemMetadata(item,
                                  "Target",
                                  item.getTargetElement(),
                                  item.getMetadataPolicy().getTarget(),
                                  holder);
        this.annotateItemMetadata(item,
                                  "Severity",
                                  item.getSeverityElement(),
                                  item.getMetadataPolicy().getSeverity(),
                                  holder);
        this.annotateItemMetadata(item,
                                  "XPath",
                                  item.getXPathElement(),
                                  item.getMetadataPolicy().getXpath(),
                                  holder);
        this.annotateItemMetadata(item,
                                  "Expression",
                                  item.getExpressionElement(),
                                  item.getMetadataPolicy().getExpression(),
                                  holder);

        for (final var metadataClass : ITEM_METADATA_CLASSES) {
            final var nodes = item.findChildrenByClass(metadataClass);
            for (int i = 1; i < nodes.length; ++i) {
                final var node = nodes[i];
                holder.newAnnotation(HighlightSeverity.ERROR,
                                     "The metadata " + metadataClass.getName() + "shall not appear more than once")
                        .highlightType(ProblemHighlightType.ERROR)
                        .range(node)
                        .create();
            }
        }
    }

    protected void annotateItemMetadata(@NotNull final FshItem item,
                                        @NotNull final String metadataName,
                                        @Nullable final FshMetadata metadata,
                                        @NotNull final MetadataPolicy.Cardinality cardinality,
                                        @NotNull final AnnotationHolder holder) {
        if (item.getNameIdentifier() == null) {
            return;
        }
        if (metadata == null) {
            if (cardinality == MetadataPolicy.Cardinality.REQUIRED) {
                holder.newAnnotation(HighlightSeverity.ERROR,
                                     "The metadata " + metadataName + " is required but missing")
                        .highlightType(ProblemHighlightType.ERROR)
                        .range(item.getNameIdentifier())
                        .create();
            }
        } else {
            if (cardinality == MetadataPolicy.Cardinality.FORBIDDEN) {
                holder.newAnnotation(HighlightSeverity.ERROR,
                                     "The metadata " + metadataName + " is forbidden in this item")
                        .highlightType(ProblemHighlightType.ERROR)
                        .range(metadata)
                        .create();
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

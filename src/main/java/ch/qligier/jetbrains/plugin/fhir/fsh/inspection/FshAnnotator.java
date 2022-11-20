package ch.qligier.jetbrains.plugin.fhir.fsh.inspection;

import ch.qligier.jetbrains.plugin.fhir.fsh.language.FshNameType;
import ch.qligier.jetbrains.plugin.fhir.fsh.parser.psi.FshIdentifierDecl;
import ch.qligier.jetbrains.plugin.fhir.fsh.parser.psi.item.FshItem;
import ch.qligier.jetbrains.plugin.fhir.fsh.parser.psi.metadata.FshIdMetadata;
import com.intellij.codeInspection.ProblemHighlightType;
import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.lang.annotation.Annotator;
import com.intellij.lang.annotation.HighlightSeverity;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.regex.Pattern;

/**
 * An annotator
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
    public void annotate(@NotNull final PsiElement element, @NotNull final AnnotationHolder holder) {
        if (element instanceof FshIdentifierDecl) {
            this.annotateIdentifier((FshIdentifierDecl) element, holder);
        }
    }

    protected void annotateIdentifier(@NotNull final FshIdentifierDecl identifierElement,
                                      @NotNull final AnnotationHolder holder) {
        if (identifierElement.getParent() instanceof FshItem) {
            this.annotateItemName(identifierElement, holder);
        } else if (identifierElement.getParent() instanceof FshIdMetadata) {
            this.annotateItemId(identifierElement, holder);
        }
    }

    protected void annotateItemName(@NotNull final FshIdentifierDecl itemNameElement,
                                    @NotNull final AnnotationHolder holder) {
        final FshItem item = (FshItem) itemNameElement.getParent();

        if (item.getNameType() == FshNameType.NAME) {
            if (!ITEM_NAME_PATTERN.matcher(Objects.requireNonNull(itemNameElement.getName())).matches()) {
                holder.newAnnotation(HighlightSeverity.ERROR,
                                     "An item name MUST be between 1 and 255 characters, begin with an uppercase letter and contain only letters, numbers, and underscores.")
                        .highlightType(ProblemHighlightType.ERROR)
                        .create();
            }
        } else {
            if (Objects.requireNonNull(itemNameElement.getName()).length() > 64) {
                holder.newAnnotation(HighlightSeverity.ERROR,
                                     "An alias name length MUST NOT be more than 64 characters.")
                        .highlightType(ProblemHighlightType.ERROR)
                        .create();
            }
        }
    }

    protected void annotateItemId(@NotNull final FshIdentifierDecl itemIdElement,
                                  @NotNull final AnnotationHolder holder) {
        if (Objects.requireNonNull(itemIdElement.getName()).length() > 64) {
            holder.newAnnotation(HighlightSeverity.ERROR,
                                 "An ID length MUST NOT be more than 64 characters.")
                    .highlightType(ProblemHighlightType.ERROR)
                    .create();
        }
    }
}

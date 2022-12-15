// Copyright 2022 Quentin Ligier. Use of this source code is governed by the MIT license.

package ch.qligier.jetbrains.plugin.fhir.fsh.completion;

import ch.qligier.jetbrains.plugin.fhir.fhir.Constants;
import ch.qligier.jetbrains.plugin.fhir.fsh.FshUtil;
import ch.qligier.jetbrains.plugin.fhir.fsh.parser.psi.*;
import com.intellij.codeInsight.completion.*;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.openapi.progress.ProgressManager;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiNamedElement;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * The completion provider for the FSH language.
 *
 * @author Quentin Ligier
 * @see <a href="https://plugins.jetbrains.com/docs/intellij/completion-contributor.html">Completion Contributor</a>
 * @see <a href="https://plugins.jetbrains.com/docs/intellij/code-completion.html">Code Completion</a>
 **/
public class FshCompletionProvider extends CompletionContributor {

    /**
     * The main contributor method that is supposed to provide completion variants to result, based on completion
     * parameters. The default implementation looks for {@link CompletionProvider}s you could register by invoking
     * {@link #extend(CompletionType, ElementPattern, CompletionProvider)} from your contributor constructor, matches
     * the desired completion type and {@link ElementPattern} with actual ones, and, depending on it, invokes those
     * completion providers.<p>
     * <p>
     * If you want to implement this functionality directly by overriding this method, the following is for you. Always
     * check that parameters match your situation, and that completion type
     * ({@link CompletionParameters#getCompletionType()} is of your favourite kind. This method is run inside a read
     * action. If you do any long activity non-related to PSI in it, please ensure you call
     * {@link ProgressManager#checkCanceled()} often enough so that the completion process can be cancelled smoothly
     * when the user begins to type in the editor.
     *
     * @param parameters The completion parameters.
     * @param result     The completion result.
     */
    @Override
    public void fillCompletionVariants(@NotNull final CompletionParameters parameters,
                                       @NotNull final CompletionResultSet result) {
        final PsiElement element = parameters.getPosition();
        final Project project = Objects.requireNonNull(parameters.getEditor().getProject());

        // Get the element text and remove the inserted dummy text, if any
        String text = element.getText().trim();
        if (text.endsWith(CompletionUtilCore.DUMMY_IDENTIFIER_TRIMMED)) {
            text = text.substring(0, text.length() - CompletionUtilCore.DUMMY_IDENTIFIER_TRIMMED.length());
        }

        if (element.getNode().getElementType() == FshTypes.IDENTIFIER) {
            if (element.getParent() instanceof FshIdentifierRef) {
                // The parent is an IdentifierRef
                final var parentIdentifierRef = (FshIdentifierRef) element.getParent();

                if (parentIdentifierRef.getParent() instanceof FshObeysRule) {
                    // We're looking for an invariant name
                    this.fillCompletionVariantsForInvariants(text, project, result);
                }
            } else if (element.getParent() instanceof FshItemIdentifier) {
                // The parent is an ItemIdentifier
                final var parentItemIdentifier = (FshItemIdentifier) element.getParent();

                if (parentItemIdentifier.getParent() instanceof FshParent) {
                    // We're looking for a FHIR resource or FSH profile name
                    final var fshParent = (FshParent) parentItemIdentifier.getParent();
                    final var fshItem = (FshItem) fshParent.getParent();
                    this.fillCompletionVariantsForProfileOrResource(text, project, result, fshItem.getName());
                }
            }
        }
        super.fillCompletionVariants(parameters, result);
    }

    /**
     * Provides completion variants for FSH invariants.
     *
     * @param text    The text already typed by the user. It may be blank.
     * @param project The current project.
     * @param result  The completion result.
     */
    protected void fillCompletionVariantsForInvariants(@NotNull final String text,
                                                       @NotNull final Project project,
                                                       @NotNull final CompletionResultSet result) {
        FshUtil.findItems(project, FshInvariant.class).forEach(invariant -> {
            if (invariant.getName() == null) {
                return;
            }
            if (text.isBlank()) {
                result.addElement(LookupElementBuilder.create(invariant.getName()));
            } else if (StringUtils.containsIgnoreCase(invariant.getName(), text)) {
                result.addElement(LookupElementBuilder.create(invariant.getName()));
            }
        });
    }

    /**
     * Provides completion variants for FSH profiles or FHIR resources.
     *
     * @param text       The text already typed by the user. It may be blank.
     * @param project    The current project.
     * @param result     The completion result.
     * @param removeName A name to remove from the results, or {@code null}.
     */
    protected void fillCompletionVariantsForProfileOrResource(@NotNull final String text,
                                                              @NotNull final Project project,
                                                              @NotNull final CompletionResultSet result,
                                                              @Nullable final String removeName) {
        Stream<String> candidates = Stream.of(
                Constants.RESOURCE_NAMES.stream(),
                Constants.GENERAL_TYPE_NAMES.stream(),
                Constants.METADATA_TYPE_NAMES.stream(),
                Constants.SPECIAL_TYPE_NAMES.stream(),
                FshUtil.findItems(project, FshProfile.class).stream()
                        .map(PsiNamedElement::getName)
                        .filter(Objects::nonNull)
        ).flatMap(Function.identity());
        if (removeName != null) {
            candidates = candidates.filter(name -> !name.equals(removeName));
        }
        if (!text.isBlank()) {
            candidates = candidates.filter(name -> StringUtils.containsIgnoreCase(name, text));
        }
        candidates.forEach(name -> result.addElement(LookupElementBuilder.create(name)));
    }
}

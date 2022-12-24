// Copyright 2022 Quentin Ligier. Use of this source code is governed by the MIT license.

package ch.qligier.jetbrains.plugin.fhir.fsh.inspection;

import ch.qligier.jetbrains.plugin.fhir.fsh.parser.psi.FshFile;
import ch.qligier.jetbrains.plugin.fhir.fsh.parser.psi.FshId;
import ch.qligier.jetbrains.plugin.fhir.fsh.parser.psi.FshItem;
import com.intellij.codeInspection.InspectionManager;
import com.intellij.codeInspection.LocalQuickFix;
import com.intellij.codeInspection.ProblemDescriptor;
import com.intellij.codeInspection.ProblemHighlightType;
import com.intellij.codeInspection.util.IntentionFamilyName;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.TextRange;
import com.intellij.profile.codeInspection.ProjectInspectionProfileManager;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

/**
 * An inspection that verifies item ids are derived from the name.
 *
 * @author Quentin Ligier
 **/
public class IdDerivedFromNameInspection extends FshInspectionBase {
    private static final Logger LOG = Logger.getInstance("IdDerivedFromNameInspection");

    /**
     * Override to report problems at file level.
     *
     * @param file       to check.
     * @param manager    InspectionManager to ask for ProblemDescriptor's from.
     * @param isOnTheFly true if called during on the fly editor highlighting. Called from Inspect Code action
     *                   otherwise.
     * @return {@code null} if no problems found or not applicable at file level.
     */
    @Override
    public ProblemDescriptor @Nullable [] checkFile(@NotNull final PsiFile file,
                                                    @NotNull final InspectionManager manager,
                                                    final boolean isOnTheFly) {
        if (!(file instanceof FshFile)) {
            return null;
        }

        final List<ProblemDescriptor> descriptors = new ArrayList<>(0);
        for (final FshItem item : ((FshFile) file).getItems()) {
            final var id = Optional.ofNullable(item.getIdElement())
                    .map(FshId::getValueElement)
                    .map(PsiElement::getText)
                    .orElse(null);
            if (id == null) {
                continue;
            }
            final var name = Optional.ofNullable(item.getNameIdentifier())
                    .map(PsiElement::getText)
                    .orElse(null);
            if (name == null) {
                continue;
            }

            final var expectedId = name.substring(0, Math.min(name.length(), 64))
                    .replace("_", "-")
                    .toLowerCase(Locale.ROOT);
            if (!expectedId.equals(id)) {
                descriptors.add(manager.createProblemDescriptor(
                        item.getIdElement(),
                        (TextRange) null, // The entire element
                        String.format("An item id SHOULD be derived from the name (expected '%s')", expectedId),
                        ProblemHighlightType.WEAK_WARNING,
                        true,
                        new IdDerivedFromNameQuickFix(expectedId)));
            }
        }

        return descriptors.toArray(new ProblemDescriptor[0]);
    }

    private static final class IdDerivedFromNameQuickFix implements LocalQuickFix {

        private final String rightId;

        public IdDerivedFromNameQuickFix(@NotNull final String rightId) {
            this.rightId = rightId;
        }

        /**
         * @return text to appear in "Apply Fix" popup when multiple Quick Fixes exist (in the results of batch code
         * inspection). For example, if the name of the quickfix is "Create template &lt;filename&gt", the return value
         * of getFamilyName() should be "Create template". If the name of the quickfix does not depend on a specific
         * element, simply return {@link #getName()}.
         */
        @Override
        public @IntentionFamilyName
        @NotNull String getFamilyName() {
            return "Derive the id from the name";
        }

        /**
         * Called to apply the fix.
         * <p>
         * Please call {@link ProjectInspectionProfileManager#fireProfileChanged()} if inspection profile is changed as
         * result of fix.
         *
         * @param project    {@link Project}
         * @param descriptor problem reported by the tool which provided this quick fix action
         */
        @Override
        public void applyFix(@NotNull final Project project, @NotNull final ProblemDescriptor descriptor) {
            final PsiElement element = descriptor.getPsiElement();
            if (element instanceof FshId) {
                ((FshId) element).setName(this.rightId);
            } else {
                LOG.warn("IdDerivedFromNameQuickFix.applyFix(): got element that's not the child of an FshId");
            }
        }
    }
}

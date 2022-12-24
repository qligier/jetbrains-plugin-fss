// Copyright 2022 Quentin Ligier. Use of this source code is governed by the MIT license.

package ch.qligier.jetbrains.plugin.fhir.fsh.inspection;

import ch.qligier.jetbrains.plugin.fhir.fsh.parser.psi.FshAlias;
import ch.qligier.jetbrains.plugin.fhir.fsh.parser.psi.FshFile;
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

/**
 * An inspection that verifies alias names start with the '$' sign.
 *
 * @author Quentin Ligier
 **/
public class AliasDollarNameInspection extends FshInspectionBase {
    private static final Logger LOG = Logger.getInstance("AliasDollarNameInspection");

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
        for (final var item : ((FshFile) file).getItems()) {
            if (!(item instanceof FshAlias)) {
                continue;
            }
            final var aliasNameElement = item.getNameIdentifier();
            if (aliasNameElement == null) {
                continue;
            }
            if (!aliasNameElement.getText().startsWith("$")) {
                descriptors.add(manager.createProblemDescriptor(aliasNameElement,
                                                                (TextRange) null, // The entire element
                                                                "An alias name SHOULD start with a '$' sign",
                                                                ProblemHighlightType.WEAK_WARNING,
                                                                true,
                                                                new AliasDollarNameQuickFix()));
            }
        }

        return descriptors.toArray(new ProblemDescriptor[0]);
    }

    /**
     * The quick fix for this inspection.
     */
    private static final class AliasDollarNameQuickFix implements LocalQuickFix {

        /**
         * @return text to appear in "Apply Fix" popup when multiple Quick Fixes exist (in the results of batch code
         * inspection). For example, if the name of the quickfix is "Create template &lt;filename&gt", the return value
         * of getFamilyName() should be "Create template". If the name of the quickfix does not depend on a specific
         * element, simply return {@link #getName()}.
         */
        @Override
        public @IntentionFamilyName
        @NotNull String getFamilyName() {
            return "Prefix the name with a '$' sign";
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
            if (element.getParent() instanceof FshAlias) {
                ((FshAlias) element.getParent()).setName("$" + element.getText());
            } else {
                LOG.warn("AliasDollarNameQuickFix.applyFix(): got element that's not the child of an FshAlias");
            }
        }
    }
}

package ch.qligier.jetbrains.plugin.fhir.fsh.inspection;

import ch.qligier.jetbrains.plugin.fhir.fsh.parser.psi.FshAliasItem;
import ch.qligier.jetbrains.plugin.fhir.fsh.parser.psi.FshFileBase;
import com.intellij.codeInspection.InspectionManager;
import com.intellij.codeInspection.ProblemDescriptor;
import com.intellij.psi.PsiFile;
import org.antlr.intellij.adaptor.psi.ANTLRPsiNode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * jetbrains-language-fsh
 *
 * @author Quentin Ligier
 **/
public class AliasDollarNameInspection extends FshInspectionBase {

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
        if (!(file instanceof FshFileBase)) {
            return null;
        }
        final var document = ((FshFileBase) file).findChildByClass(ANTLRPsiNode.class);
        if (document == null) {
            return null;
        }

        for (final var item : document.getChildren()) {
            if (!(item instanceof FshAliasItem)) {
                continue;
            }
            final var alias = (FshAliasItem) item;
            //System.out.println("Got alias");
        }

        return null;
    }
}

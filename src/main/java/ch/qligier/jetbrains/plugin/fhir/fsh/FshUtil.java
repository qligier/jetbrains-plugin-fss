package ch.qligier.jetbrains.plugin.fhir.fsh;

import ch.qligier.jetbrains.plugin.fhir.fsh.language.FshFileType;
import ch.qligier.jetbrains.plugin.fhir.fsh.parser.psi.FshFileBase;
import ch.qligier.jetbrains.plugin.fhir.fsh.parser.psi.item.FshItem;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiManager;
import com.intellij.psi.search.FileTypeIndex;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.util.PsiTreeUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Utilities for the FSH language.
 *
 * @author Quentin Ligier
 * @see <a
 * href="https://plugins.jetbrains.com/docs/intellij/psi-helper-and-utilities.html#define-a-utility-to-search-properties">Define
 * a Utility to Search Properties</a>
 **/
public class FshUtil {

    public static List<FshItem> findItems(final Project project) {
        final var result = new ArrayList<FshItem>(10);
        final var virtualFiles = FileTypeIndex.getFiles(FshFileType.INSTANCE, GlobalSearchScope.allScope(project));
        for (final var virtualFile : virtualFiles) {
            final var fshFile = (FshFileBase) PsiManager.getInstance(project).findFile(virtualFile);
            if (fshFile != null) {
                result.addAll(PsiTreeUtil.getChildrenOfTypeAsList(fshFile, FshItem.class));
            }
        }
        return result;
    }
}

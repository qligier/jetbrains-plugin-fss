// Copyright 2022 Quentin Ligier. Use of this source code is governed by the MIT license.

package ch.qligier.jetbrains.plugin.fhir.fsh;

/**
 * Utilities for the FSH language.
 *
 * @author Quentin Ligier
 * @see <a
 * href="https://plugins.jetbrains.com/docs/intellij/psi-helper-and-utilities.html#define-a-utility-to-search-properties">Define
 * a Utility to Search Properties</a>
 **/
public class FshUtil {

    /*public static List<FshItem> findItems(final Project project) {
        final var result = new ArrayList<FshItem>(10);
        final var virtualFiles = FileTypeIndex.getFiles(FshFileType.INSTANCE, GlobalSearchScope.allScope(project));
        for (final var virtualFile : virtualFiles) {
            final var fshFile = (FshFile) PsiManager.getInstance(project).findFile(virtualFile);
            if (fshFile != null) {
                result.addAll(PsiTreeUtil.getChildrenOfTypeAsList(fshFile, FshItem.class));
            }
        }
        return result;
    }*/
}

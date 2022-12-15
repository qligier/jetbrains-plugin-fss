// Copyright 2022 Quentin Ligier. Use of this source code is governed by the MIT license.

package ch.qligier.jetbrains.plugin.fhir.fsh;

import ch.qligier.jetbrains.plugin.fhir.fsh.parser.psi.FshFile;
import ch.qligier.jetbrains.plugin.fhir.fsh.parser.psi.FshItem;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiManager;
import com.intellij.psi.search.FileTypeIndex;
import com.intellij.psi.search.GlobalSearchScope;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
            final var fshFile = (FshFile) PsiManager.getInstance(project).findFile(virtualFile);
            if (fshFile != null) {
                result.addAll(fshFile.getItems());
            }
        }
        return result;
    }

    public static List<FshItem> findItems(final Project project, final String name) {
        final var result = new ArrayList<FshItem>(10);
        final var virtualFiles = FileTypeIndex.getFiles(FshFileType.INSTANCE, GlobalSearchScope.allScope(project));
        for (final var virtualFile : virtualFiles) {
            final var fshFile = (FshFile) PsiManager.getInstance(project).findFile(virtualFile);
            if (fshFile != null) {
                for (final var item : fshFile.getItems()) {
                    if (name.equals(item.getName())) {
                        result.add(item);
                    }
                }
            }
        }
        return result;
    }

    public static <T extends FshItem> List<T> findItems(final Project project,
                                                        final Class<T> type) {
        return findItems(project).stream()
                .filter(type::isInstance)
                .map(type::cast)
                .collect(Collectors.toList());
    }
}

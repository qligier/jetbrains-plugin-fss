// Copyright 2024 Quentin Ligier. Use of this source code is governed by the MIT license.

package ch.qligier.jetbrains.plugin.fhir.fsh.psi;

import ch.qligier.jetbrains.plugin.fhir.fsh.FshFileType;
import ch.qligier.jetbrains.plugin.fhir.fsh.FshLanguage;
import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiNamedElement;
import org.antlr.intellij.adaptor.psi.ScopeNode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * jetbrains-plugin-fhir
 *
 * @author Quentin Ligier
 **/
public class FshPsiFile extends PsiFileBase implements ScopeNode {

    public FshPsiFile(@NotNull final FileViewProvider viewProvider) {
        super(viewProvider, FshLanguage.INSTANCE);
    }

    /**
     * Returns the file type for the file.
     *
     * @return the file type instance.
     */
    @Override
    public @NotNull FileType getFileType() {
        return FshFileType.INSTANCE;
    }

    /**
     * @param element
     * @return
     */
    @Nullable
    @Override
    public PsiElement resolve(final PsiNamedElement element) {
        //TODO
        return null;
    }

    /**
     * Return null since a file scope has no enclosing scope. It is not itself in a scope.
     */
    @Override
    public ScopeNode getContext() {
        return null;
    }
}

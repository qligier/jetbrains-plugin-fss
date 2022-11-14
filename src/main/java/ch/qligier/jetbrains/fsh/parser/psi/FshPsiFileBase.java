package ch.qligier.jetbrains.fsh.parser.psi;

import ch.qligier.jetbrains.fsh.Icons;
import ch.qligier.jetbrains.fsh.language.FshFileType;
import ch.qligier.jetbrains.fsh.language.FshLanguage;
import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiNamedElement;
import org.antlr.intellij.adaptor.psi.ScopeNode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

/**
 * jetbrains-language-fsh
 *
 * @author Quentin Ligier
 **/
public class FshPsiFileBase extends PsiFileBase implements ScopeNode {

    /**
     * Constructor.
     *
     * @param viewProvider
     */
    public FshPsiFileBase(@NotNull final FileViewProvider viewProvider) {
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
     * TODO
     */
    @Nullable
    @Override
    public PsiElement resolve(final PsiNamedElement element) {
        return null;
    }

    @Override
    public @Nullable Icon getIcon(final int flags) {
        return Icons.LANGUAGE;
    }

    /**
     * Return null since a file scope has no enclosing scope. It is not itself in a scope.
     */
    @Override
    public @Nullable ScopeNode getContext() {
        return null;
    }

    @Override
    public String toString() {
        return "FshPsiFileBase (FSH file)";
    }
}

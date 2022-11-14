package ch.qligier.jetbrains.plugin.fhir.fsh.parser.psi;

import ch.qligier.jetbrains.plugin.fhir.Icons;
import ch.qligier.jetbrains.plugin.fhir.fsh.language.FshFileType;
import ch.qligier.jetbrains.plugin.fhir.fsh.language.FshLanguage;
import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiNamedElement;
import com.intellij.psi.util.PsiTreeUtil;
import org.antlr.intellij.adaptor.psi.ANTLRPsiNode;
import org.antlr.intellij.adaptor.psi.ScopeNode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

/**
 * jetbrains-language-fsh
 *
 * @author Quentin Ligier
 **/
public class FshFileBase extends PsiFileBase implements ScopeNode {

    /**
     * Constructor.
     *
     * @param viewProvider
     */
    public FshFileBase(@NotNull final FileViewProvider viewProvider) {
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
        return Icons.FSH_FLAME;
    }

    /**
     * Return null since a file scope has no enclosing scope. It is not itself in a scope.
     */
    @Override
    public @Nullable ScopeNode getContext() {
        return null;
    }

    public FshItem @Nullable [] getItems() {
        final var document = this.findChildByClass(ANTLRPsiNode.class);
        if (document == null) {
            return null;
        }
        return PsiTreeUtil.getChildrenOfType(document, FshItem.class);
    }

    @Override
    public String toString() {
        return "FshFileBase (FSH file)";
    }
}

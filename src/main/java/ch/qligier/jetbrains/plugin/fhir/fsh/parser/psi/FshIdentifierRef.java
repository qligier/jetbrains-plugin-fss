package ch.qligier.jetbrains.plugin.fhir.fsh.parser.psi;

import com.intellij.psi.PsiReference;
import com.intellij.psi.tree.IElementType;
import org.antlr.intellij.adaptor.psi.ANTLRPsiLeafNode;

/**
 * A PSI model for the reference to an identifier.
 *
 * @author Quentin Ligier
 **/
public class FshIdentifierRef extends ANTLRPsiLeafNode {
    public FshIdentifierRef(final IElementType type, final CharSequence text) {
        super(type, text);
    }

    /**
     * @return
     */
    @Override
    public PsiReference getReference() {
        return null;
    }
}

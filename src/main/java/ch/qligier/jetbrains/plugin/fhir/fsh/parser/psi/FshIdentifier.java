package ch.qligier.jetbrains.plugin.fhir.fsh.parser.psi;

import ch.qligier.jetbrains.plugin.fhir.fsh.grammar.FshParser;
import ch.qligier.jetbrains.plugin.fhir.fsh.language.FshLanguage;
import ch.qligier.jetbrains.plugin.fhir.fsh.parser.FshTokenTypes;
import com.intellij.openapi.util.NlsSafe;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiNameIdentifierOwner;
import com.intellij.psi.tree.IElementType;
import com.intellij.util.IncorrectOperationException;
import org.antlr.intellij.adaptor.psi.ANTLRPsiLeafNode;
import org.antlr.intellij.adaptor.psi.Trees;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * jetbrains-language-fsh
 *
 * @author Quentin Ligier
 **/
public class FshIdentifier extends ANTLRPsiLeafNode implements PsiNameIdentifierOwner {

    public FshIdentifier(final IElementType type, final CharSequence text) {
        super(type, text);
    }

    /**
     * Returns the name of the element.
     *
     * @return the element name.
     */
    @Override
    public @Nullable @NlsSafe String getName() {
        return this.getText();
    }

    /**
     * Renames the element.
     *
     * @param name the new element name.
     * @return the element corresponding to this element after the renaming (either {@code this} or a different element
     * if the renaming caused the element to be replaced).
     * @throws IncorrectOperationException if the modification is not supported or not possible for some reason.
     */
    @Override
    public PsiElement setName(@NlsSafe @NotNull final String name) throws IncorrectOperationException {
        if (getParent() == null) {
            return this;
        }
        final PsiElement newIdentifier = Trees.createLeafFromText(getProject(),
                                                                  FshLanguage.INSTANCE,
                                                                  getContext(),
                                                                  name,
                                                                  FshTokenTypes.getTokenElementType(FshParser.IDENTIFIER));
        if (newIdentifier != null) {
            return this.replace(newIdentifier);
        }
        return this;
    }

    @Override
    public String toString() {
        return String.format("FshIdentifier('%s')", this.getText());
    }

    @Override
    public @NotNull PsiElement getNameIdentifier() {
        return this;
    }
}

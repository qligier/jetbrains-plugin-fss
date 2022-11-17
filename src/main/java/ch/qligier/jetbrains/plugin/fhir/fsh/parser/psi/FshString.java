package ch.qligier.jetbrains.plugin.fhir.fsh.parser.psi;

import com.intellij.psi.impl.source.tree.LeafPsiElement;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;

/**
 * jetbrains-language-fsh
 *
 * @author Quentin Ligier
 **/
public class FshString extends LeafPsiElement {

    public FshString(@NotNull final IElementType type, final CharSequence text) {
        super(type, text);
    }
}

package ch.qligier.jetbrains.plugin.fhir.fsh.parser.psi;

import com.intellij.lang.ASTNode;
import org.jetbrains.annotations.NotNull;

/**
 * jetbrains-language-fsh
 *
 * @author Quentin Ligier
 **/
public class FshAliasItem extends FshItem {

    public FshAliasItem(final @NotNull ASTNode node) {
        super(node);
    }
}

package ch.qligier.jetbrains.plugin.fhir.fsh.parser.psi.item;

import ch.qligier.jetbrains.plugin.fhir.fsh.language.FshNameType;
import ch.qligier.jetbrains.plugin.fhir.fsh.parser.psi.FshIdentifierDecl;
import com.intellij.lang.ASTNode;
import org.jetbrains.annotations.NotNull;

/**
 * PSI model for an FSH Alias item.
 *
 * @author Quentin Ligier
 **/
public class FshAliasItem extends FshItem {

    public FshAliasItem(final @NotNull ASTNode node) {
        super(node);
    }

    /**
     * Returns the type of the name (name, id or expression).
     */
    @Override
    public @NotNull FshNameType getNameType() {
        return FshNameType.EXPRESSION;
    }

    /**
     * Returns the placeholder used in this folding region.
     */
    @Override
    public @NotNull String getFoldedPlaceholder() {
        return "Alias: " + this.getSafeName();
    }

    public FshIdentifierDecl getIdentifier() {
        return this.findChildByClass(FshIdentifierDecl.class);
    }
}

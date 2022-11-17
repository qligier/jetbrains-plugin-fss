package ch.qligier.jetbrains.plugin.fhir.fsh.parser.psi.item;

import ch.qligier.jetbrains.plugin.fhir.fsh.language.FshNameType;
import com.intellij.lang.ASTNode;
import org.jetbrains.annotations.NotNull;

/**
 * PSI model for an FSH CodeSystem item.
 *
 * @author Quentin Ligier
 **/
public class FshCodeSystemItem extends FshItem {
    public FshCodeSystemItem(final @NotNull ASTNode node) {
        super(node);
    }

    /**
     * Returns the type of the name (name, id or expression).
     */
    @Override
    public @NotNull FshNameType getNameType() {
        return FshNameType.NAME;
    }

    /**
     * Returns the placeholder used in this folding region.
     */
    @Override
    public @NotNull String getFoldedPlaceholder() {
        return "CodeSystem: " + this.getSafeName();
    }
}

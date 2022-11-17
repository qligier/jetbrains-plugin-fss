package ch.qligier.jetbrains.plugin.fhir.fsh.parser.psi.item;

import ch.qligier.jetbrains.plugin.fhir.fsh.language.FshNameType;
import ch.qligier.jetbrains.plugin.fhir.fsh.parser.psi.FshIdentifier;
import ch.qligier.jetbrains.plugin.fhir.fsh.parser.psi.metadata.FshIdMetadata;
import ch.qligier.jetbrains.plugin.fhir.fsh.parser.psi.metadata.FshMetadata;
import com.intellij.lang.ASTNode;
import com.intellij.psi.util.PsiTreeUtil;
import org.antlr.intellij.adaptor.psi.ANTLRPsiNode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Optional;

/**
 * PSI model for an FSH item. A central purpose of FSH is to create and define items that represent and can be
 * translated into FHIR artifacts.
 * <p>
 * The general pattern used to define an item in FSH is: (1) Declaration statement, (2) Keyword statements, (3) Rule
 * statements.
 *
 * @author Quentin Ligier
 **/
public abstract class FshItem extends ANTLRPsiNode {

    public FshItem(@NotNull final ASTNode node) {
        super(node);
    }

    public @NotNull List<FshMetadata> getMetadata() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, FshMetadata.class);
    }

    /**
     * Returns the PSI element that contains the FSH Item name.
     *
     * @return the PSI element or {@code null}.
     */
    public @Nullable FshIdentifier getItemNameElement() {
        return PsiTreeUtil.getChildOfType(this, FshIdentifier.class);
    }

    /**
     * Safely gets the name of the item.
     */
    public @NotNull String getSafeName() {
        return Optional.ofNullable(this.getItemNameElement())
                .map(FshIdentifier::getName)
                .orElse("noname");
    }

    /**
     * Returns the PSI element that contains the FSH Item id.
     *
     * @return the PSI element or {@code null}.
     */
    public @Nullable FshIdMetadata getItemIdElement() {
        return PsiTreeUtil.getChildOfType(this, FshIdMetadata.class);
    }

    /**
     * Returns the type of the name (name, id or expression).
     */
    public abstract @NotNull FshNameType getNameType();

    /**
     * Returns the placeholder used in this folding region.
     */
    public abstract @NotNull String getFoldedPlaceholder();
}

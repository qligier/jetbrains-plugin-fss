package ch.qligier.jetbrains.plugin.fhir.fsh.parser.psi;

import com.intellij.lang.ASTNode;
import org.antlr.intellij.adaptor.psi.ANTLRPsiNode;
import org.jetbrains.annotations.NotNull;

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
}

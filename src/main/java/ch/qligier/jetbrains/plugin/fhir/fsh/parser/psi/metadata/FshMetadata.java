package ch.qligier.jetbrains.plugin.fhir.fsh.parser.psi.metadata;

import ch.qligier.jetbrains.plugin.fhir.fsh.grammar.FshParser;
import com.intellij.lang.ASTNode;
import org.antlr.intellij.adaptor.psi.ANTLRPsiNode;
import org.intellij.lang.annotations.MagicConstant;
import org.jetbrains.annotations.NotNull;

/**
 * PSI model for an FSH item metadata.
 *
 * @author Quentin Ligier
 **/
public abstract class FshMetadata extends ANTLRPsiNode {
    public FshMetadata(@NotNull final ASTNode node) {
        super(node);
    }

    public abstract @MagicConstant(valuesFromClass = FshParser.class) int getRule();
}

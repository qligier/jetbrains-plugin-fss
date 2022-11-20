package ch.qligier.jetbrains.plugin.fhir.fsh.parser.psi.metadata;

import ch.qligier.jetbrains.plugin.fhir.fsh.grammar.FshParser;
import ch.qligier.jetbrains.plugin.fhir.fsh.parser.psi.FshIdentifierDecl;
import com.intellij.lang.ASTNode;
import org.intellij.lang.annotations.MagicConstant;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * PSI model for an FSH Id metadata.
 *
 * @author Quentin Ligier
 **/
public class FshIdMetadata extends FshMetadata {

    public FshIdMetadata(final @NotNull ASTNode node) {
        super(node);
    }

    @Override
    public @MagicConstant(valuesFromClass = FshParser.class) int getRule() {
        return FshParser.RULE_id;
    }

    public @Nullable FshIdentifierDecl getValueElement() {
        return this.findChildByClass(FshIdentifierDecl.class);
    }
}

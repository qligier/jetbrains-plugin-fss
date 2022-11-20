package ch.qligier.jetbrains.plugin.fhir.fsh.parser.ast;

import ch.qligier.jetbrains.plugin.fhir.fsh.grammar.FshParser;
import ch.qligier.jetbrains.plugin.fhir.fsh.parser.psi.FshIdentifierDecl;
import ch.qligier.jetbrains.plugin.fhir.fsh.parser.psi.FshString;
import ch.qligier.jetbrains.plugin.fhir.fsh.parser.psi.item.*;
import ch.qligier.jetbrains.plugin.fhir.fsh.parser.psi.metadata.FshIdMetadata;
import com.intellij.lang.ASTFactory;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.impl.source.tree.CompositeElement;
import com.intellij.psi.impl.source.tree.FileElement;
import com.intellij.psi.impl.source.tree.LeafElement;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.IFileElementType;
import org.antlr.intellij.adaptor.lexer.RuleIElementType;
import org.antlr.intellij.adaptor.lexer.TokenIElementType;
import org.antlr.intellij.adaptor.psi.ANTLRPsiNode;

/**
 * An expert-level extension point for exercising fine-grained control over abstract syntax tree (AST) element
 * generation, when PSI is not enough (see the <a
 * href="https://plugins.jetbrains.com/docs/intellij/implementing-parser-and-psi.html">Implementing Parser and PSI</a>
 * section for description of PSI/AST relation).
 *
 * @author Quentin Ligier
 **/
public class FshAstFactory extends ASTFactory {

    public static PsiElement createInternalParseTreeNode(ASTNode node) {
        if (node.getElementType() instanceof RuleIElementType) {
            final var rule = (RuleIElementType) node.getElementType();
            //System.out.println("createElement: rule " + rule.getRuleIndex());
            switch (rule.getRuleIndex()) {
                // Items
                case FshParser.RULE_alias:
                    return new FshAliasItem(node);
                case FshParser.RULE_profile:
                    return new FshProfileItem(node);
                case FshParser.RULE_extension:
                    return new FshExtensionItem(node);
                case FshParser.RULE_invariant:
                    return new FshInvariantItem(node);
                case FshParser.RULE_instance:
                    return new FshInstanceItem(node);
                case FshParser.RULE_valueSet:
                    return new FshValueSetItem(node);
                case FshParser.RULE_codeSystem:
                    return new FshCodeSystemItem(node);
                case FshParser.RULE_ruleSet:
                    return new FshRuleSetItem(node);
                case FshParser.RULE_mapping:
                    return new FshMappingItem(node);
                case FshParser.RULE_logical:
                    return new FshLogicalItem(node);
                case FshParser.RULE_resource:
                    return new FshResourceItem(node);

                // Metadata
                case FshParser.RULE_id:
                    return new FshIdMetadata(node);
            }
        }
        return new ANTLRPsiNode(node);
    }

    /**
     * Create a FileElement for root or a parse tree CompositeElement (not PSI) for the token.
     */
    @Override
    public CompositeElement createComposite(final IElementType type) {
        if (type instanceof IFileElementType) {
            //System.out.println("Creating FileElement");
            return new FileElement(type, null);
        }
        //System.out.println("Creating CompositeElement");
        return super.createComposite(type);
    }

    /**
     * Create PSI nodes out of tokens so even parse tree sees them as such. Does not see whitespace tokens.
     */
    @Override
    public LeafElement createLeaf(final IElementType type, final CharSequence text) {
        if (type instanceof TokenIElementType) {
            final var tokenType = (TokenIElementType) type;
            //System.out.println("token " + tokenType.getANTLRTokenType());
            if (tokenType.getANTLRTokenType() == FshParser.IDENTIFIER) {
                // An identifier can be a declaration of a reference
                return new FshIdentifierDecl(type, text);
            } else if (tokenType.getANTLRTokenType() == FshParser.STRING
                    || tokenType.getANTLRTokenType() == FshParser.MULTILINE_STRING) {
                return new FshString(type, text);
            }
        }
        return super.createLeaf(type, text);
    }
}

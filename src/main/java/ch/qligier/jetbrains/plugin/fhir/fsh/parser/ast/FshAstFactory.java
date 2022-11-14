package ch.qligier.jetbrains.plugin.fhir.fsh.parser.ast;

import ch.qligier.jetbrains.plugin.fhir.fsh.grammar.FshParser;
import ch.qligier.jetbrains.plugin.fhir.fsh.parser.psi.FshAliasItem;
import ch.qligier.jetbrains.plugin.fhir.fsh.parser.psi.FshIdentifier;
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
 * jetbrains-language-fsh
 *
 * @author Quentin Ligier
 **/
public class FshAstFactory extends ASTFactory {

    public static PsiElement createInternalParseTreeNode(ASTNode node) {
        if (node.getElementType() instanceof RuleIElementType) {
            final var rule = (RuleIElementType) node.getElementType();
            //System.out.println("createElement: rule " + rule.getRuleIndex());
            if (rule.getRuleIndex() == FshParser.RULE_alias) {
                return new FshAliasItem(node);
            }
        }
        //System.out.println("createElement: type " + node.getClass());
        return new ANTLRPsiNode(node);

        /*PsiElement t;
        IElementType tokenType = node.getElementType();
        PsiElementFactory factory = ruleElementTypeToPsiFactory.get(tokenType);
        if (factory != null) {
            t = factory.createElement(node);
        } else {
            t = new ASTWrapperPsiElement(node);
        }

        return t;*/
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
                return new FshIdentifier(type, text);
            }
        }
        LeafElement t;
        /*if (type == FshTokenTypes.TOKEN_ELEMENT_TYPES.get(FSHLexer.RULE_REF)) {
            t = new ParserRuleRefNode(type, text);
        } else if (type == FshTokenTypes.TOKEN_ELEMENT_TYPES.get(FSHLexer.TOKEN_REF)) {
            t = new LexerRuleRefNode(type, text);
        } else if (type == FshTokenTypes.TOKEN_ELEMENT_TYPES.get(FSHLexer.STRING_LITERAL)) {
            t = new StringLiteralElement(type, text);
        } else {
            t = new LeafPsiElement(type, text);
        }*/
        //System.out.println("Creating LeafPsiElement");
        return super.createLeaf(type, text);
    }
}

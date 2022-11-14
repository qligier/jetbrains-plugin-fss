package ch.qligier.jetbrains.fsh.parser.ast;

import ch.qligier.jetbrains.fsh.grammar.FSHParser;
import ch.qligier.jetbrains.fsh.parser.psi.FshItem;
import com.intellij.lang.ASTFactory;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.impl.source.tree.CompositeElement;
import com.intellij.psi.impl.source.tree.FileElement;
import com.intellij.psi.impl.source.tree.LeafElement;
import com.intellij.psi.impl.source.tree.LeafPsiElement;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.IFileElementType;
import org.antlr.intellij.adaptor.lexer.RuleIElementType;
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
            System.out.println("createElement: rule " + rule.getRuleIndex());
            if (rule.getRuleIndex() == FSHParser.RULE_entity) {
                return new FshItem(node);
            }
        }
        System.out.println("createElement: type " + node.getClass());
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
     * Create a FileElement for root or a parse tree CompositeElement (not PSI) for the token. This impl is more or less
     * the default.
     */
    @Override
    public CompositeElement createComposite(IElementType type) {
        if (type instanceof IFileElementType) {
            return new FileElement(type, null);
        }
        return new CompositeElement(type);
    }

    /**
     * Create PSI nodes out of tokens so even parse tree sees them as such. Does not see whitespace tokens.
     */
    @Override
    public LeafElement createLeaf(IElementType type, CharSequence text) {
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
        return new LeafPsiElement(type, text);
    }
}

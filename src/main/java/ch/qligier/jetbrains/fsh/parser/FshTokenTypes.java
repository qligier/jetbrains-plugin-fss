package ch.qligier.jetbrains.fsh.parser;

import ch.qligier.jetbrains.fsh.grammar.FSHParser;
import ch.qligier.jetbrains.fsh.language.FshLanguage;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.TokenSet;
import org.antlr.intellij.adaptor.lexer.PSIElementTypeFactory;
import org.antlr.intellij.adaptor.lexer.RuleIElementType;
import org.antlr.intellij.adaptor.lexer.TokenIElementType;
import org.intellij.lang.annotations.MagicConstant;

import java.util.List;

/**
 * jetbrains-language-fsh
 *
 * @author Quentin Ligier
 **/
public class FshTokenTypes {

    public static final List<TokenIElementType> TOKEN_ELEMENT_TYPES =
            PSIElementTypeFactory.getTokenIElementTypes(FshLanguage.INSTANCE);
    public static final List<RuleIElementType> RULE_ELEMENT_TYPES =
            PSIElementTypeFactory.getRuleIElementTypes(FshLanguage.INSTANCE);

    public static final IElementType WHITE_SPACE = TokenType.WHITE_SPACE;
    public static final IElementType BAD_CHARACTER = TokenType.BAD_CHARACTER;

    public static final IElementType LEFT_PAREN = new FshTokenType("LEFT_PAREN");
    public static final IElementType RIGHT_PAREN = new FshTokenType("RIGHT_PAREN");
    public static final IElementType LEFT_BRACKET = new FshTokenType("LEFT_BRACKET");
    public static final IElementType RIGHT_BRACKET = new FshTokenType("RIGHT_BRACKET");

    public static final TokenSet COMMENTS = PSIElementTypeFactory.createTokenSet(
            FshLanguage.INSTANCE,
            FSHParser.BLOCK_COMMENT,
            FSHParser.LINE_COMMENT);

    public static final TokenSet WHITESPACE = PSIElementTypeFactory.createTokenSet(
            FshLanguage.INSTANCE,
            FSHParser.WHITESPACE/*,
            FSHParser.SPACES*/);

    public static final TokenSet STRING = PSIElementTypeFactory.createTokenSet(
            FshLanguage.INSTANCE,
            FSHParser.STRING);

    public static RuleIElementType getRuleElementType(@MagicConstant(valuesFromClass = FSHParser.class) int ruleIndex) {
        return RULE_ELEMENT_TYPES.get(ruleIndex);
    }

    public static TokenIElementType getTokenElementType(@MagicConstant(valuesFromClass = FSHParser.class) int ruleIndex) {
        return TOKEN_ELEMENT_TYPES.get(ruleIndex);
    }
}

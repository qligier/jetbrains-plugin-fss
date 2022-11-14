package ch.qligier.jetbrains.plugin.fhir.fsh.parser;

import ch.qligier.jetbrains.plugin.fhir.fsh.grammar.FshParser;
import ch.qligier.jetbrains.plugin.fhir.fsh.language.FshLanguage;
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

    public static final List<TokenIElementType> TOKEN_ELEMENT_TYPES;
    public static final List<RuleIElementType> RULE_ELEMENT_TYPES;

    public static final TokenSet COMMENTS;
    public static final TokenSet WHITESPACE;
    public static final TokenSet STRING;

    static {
        try {
            PSIElementTypeFactory.defineLanguageIElementTypes(FshLanguage.INSTANCE,
                                                              FshParser.tokenNames,
                                                              FshParser.ruleNames);
            TOKEN_ELEMENT_TYPES =
                    PSIElementTypeFactory.getTokenIElementTypes(FshLanguage.INSTANCE);
            RULE_ELEMENT_TYPES =
                    PSIElementTypeFactory.getRuleIElementTypes(FshLanguage.INSTANCE);

            COMMENTS = PSIElementTypeFactory.createTokenSet(
                    FshLanguage.INSTANCE,
                    FshParser.LINE_COMMENT);
            WHITESPACE = PSIElementTypeFactory.createTokenSet(
                    FshLanguage.INSTANCE,
                    FshParser.WHITESPACES);
            STRING = PSIElementTypeFactory.createTokenSet(
                    FshLanguage.INSTANCE,
                    FshParser.STRING);
        } catch (final Exception e) {
            System.out.println(e);
            throw e;
        }
    }

    public static RuleIElementType getRuleElementType(@MagicConstant(valuesFromClass = FshParser.class) int
                                                              ruleIndex) {
        return RULE_ELEMENT_TYPES.get(ruleIndex);
    }

    public static TokenIElementType getTokenElementType(@MagicConstant(valuesFromClass = FshParser.class) int ruleIndex) {
        return TOKEN_ELEMENT_TYPES.get(ruleIndex);
    }
}

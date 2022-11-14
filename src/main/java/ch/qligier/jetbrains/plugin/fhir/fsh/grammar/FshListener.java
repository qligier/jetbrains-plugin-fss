// Generated from java-escape by ANTLR 4.11.1
package ch.qligier.jetbrains.plugin.fhir.fsh.grammar;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link FshParser}.
 */
public interface FshListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link FshParser#doc}.
	 * @param ctx the parse tree
	 */
	void enterDoc(FshParser.DocContext ctx);
	/**
	 * Exit a parse tree produced by {@link FshParser#doc}.
	 * @param ctx the parse tree
	 */
	void exitDoc(FshParser.DocContext ctx);
	/**
	 * Enter a parse tree produced by {@link FshParser#alias}.
	 * @param ctx the parse tree
	 */
	void enterAlias(FshParser.AliasContext ctx);
	/**
	 * Exit a parse tree produced by {@link FshParser#alias}.
	 * @param ctx the parse tree
	 */
	void exitAlias(FshParser.AliasContext ctx);
	/**
	 * Enter a parse tree produced by {@link FshParser#aliasName}.
	 * @param ctx the parse tree
	 */
	void enterAliasName(FshParser.AliasNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link FshParser#aliasName}.
	 * @param ctx the parse tree
	 */
	void exitAliasName(FshParser.AliasNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link FshParser#aliasValue}.
	 * @param ctx the parse tree
	 */
	void enterAliasValue(FshParser.AliasValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link FshParser#aliasValue}.
	 * @param ctx the parse tree
	 */
	void exitAliasValue(FshParser.AliasValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link FshParser#ruleStart}.
	 * @param ctx the parse tree
	 */
	void enterRuleStart(FshParser.RuleStartContext ctx);
	/**
	 * Exit a parse tree produced by {@link FshParser#ruleStart}.
	 * @param ctx the parse tree
	 */
	void exitRuleStart(FshParser.RuleStartContext ctx);
	/**
	 * Enter a parse tree produced by {@link FshParser#path}.
	 * @param ctx the parse tree
	 */
	void enterPath(FshParser.PathContext ctx);
	/**
	 * Exit a parse tree produced by {@link FshParser#path}.
	 * @param ctx the parse tree
	 */
	void exitPath(FshParser.PathContext ctx);
	/**
	 * Enter a parse tree produced by {@link FshParser#pathPart}.
	 * @param ctx the parse tree
	 */
	void enterPathPart(FshParser.PathPartContext ctx);
	/**
	 * Exit a parse tree produced by {@link FshParser#pathPart}.
	 * @param ctx the parse tree
	 */
	void exitPathPart(FshParser.PathPartContext ctx);
	/**
	 * Enter a parse tree produced by {@link FshParser#simplePathPart}.
	 * @param ctx the parse tree
	 */
	void enterSimplePathPart(FshParser.SimplePathPartContext ctx);
	/**
	 * Exit a parse tree produced by {@link FshParser#simplePathPart}.
	 * @param ctx the parse tree
	 */
	void exitSimplePathPart(FshParser.SimplePathPartContext ctx);
	/**
	 * Enter a parse tree produced by {@link FshParser#bracketPathPart}.
	 * @param ctx the parse tree
	 */
	void enterBracketPathPart(FshParser.BracketPathPartContext ctx);
	/**
	 * Exit a parse tree produced by {@link FshParser#bracketPathPart}.
	 * @param ctx the parse tree
	 */
	void exitBracketPathPart(FshParser.BracketPathPartContext ctx);
	/**
	 * Enter a parse tree produced by {@link FshParser#bracketSuffix}.
	 * @param ctx the parse tree
	 */
	void enterBracketSuffix(FshParser.BracketSuffixContext ctx);
	/**
	 * Exit a parse tree produced by {@link FshParser#bracketSuffix}.
	 * @param ctx the parse tree
	 */
	void exitBracketSuffix(FshParser.BracketSuffixContext ctx);
	/**
	 * Enter a parse tree produced by {@link FshParser#cardinality}.
	 * @param ctx the parse tree
	 */
	void enterCardinality(FshParser.CardinalityContext ctx);
	/**
	 * Exit a parse tree produced by {@link FshParser#cardinality}.
	 * @param ctx the parse tree
	 */
	void exitCardinality(FshParser.CardinalityContext ctx);
	/**
	 * Enter a parse tree produced by {@link FshParser#number}.
	 * @param ctx the parse tree
	 */
	void enterNumber(FshParser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by {@link FshParser#number}.
	 * @param ctx the parse tree
	 */
	void exitNumber(FshParser.NumberContext ctx);
	/**
	 * Enter a parse tree produced by {@link FshParser#integer}.
	 * @param ctx the parse tree
	 */
	void enterInteger(FshParser.IntegerContext ctx);
	/**
	 * Exit a parse tree produced by {@link FshParser#integer}.
	 * @param ctx the parse tree
	 */
	void exitInteger(FshParser.IntegerContext ctx);
	/**
	 * Enter a parse tree produced by {@link FshParser#unit}.
	 * @param ctx the parse tree
	 */
	void enterUnit(FshParser.UnitContext ctx);
	/**
	 * Exit a parse tree produced by {@link FshParser#unit}.
	 * @param ctx the parse tree
	 */
	void exitUnit(FshParser.UnitContext ctx);
	/**
	 * Enter a parse tree produced by {@link FshParser#code}.
	 * @param ctx the parse tree
	 */
	void enterCode(FshParser.CodeContext ctx);
	/**
	 * Exit a parse tree produced by {@link FshParser#code}.
	 * @param ctx the parse tree
	 */
	void exitCode(FshParser.CodeContext ctx);
	/**
	 * Enter a parse tree produced by {@link FshParser#dateTime}.
	 * @param ctx the parse tree
	 */
	void enterDateTime(FshParser.DateTimeContext ctx);
	/**
	 * Exit a parse tree produced by {@link FshParser#dateTime}.
	 * @param ctx the parse tree
	 */
	void exitDateTime(FshParser.DateTimeContext ctx);
	/**
	 * Enter a parse tree produced by {@link FshParser#time}.
	 * @param ctx the parse tree
	 */
	void enterTime(FshParser.TimeContext ctx);
	/**
	 * Exit a parse tree produced by {@link FshParser#time}.
	 * @param ctx the parse tree
	 */
	void exitTime(FshParser.TimeContext ctx);
}
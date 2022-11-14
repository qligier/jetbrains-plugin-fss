package ch.qligier.jetbrains.plugin.fhir.grammar;

import ch.qligier.jetbrains.plugin.fhir.fsh.grammar.FshLexer;
import ch.qligier.jetbrains.plugin.fhir.fsh.grammar.FshListener;
import ch.qligier.jetbrains.plugin.fhir.fsh.grammar.FshParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.junit.jupiter.api.Test;

import java.io.IOException;

/**
 * jetbrains-language-fsh
 *
 * @author Quentin Ligier
 **/
public class FSHParserTest {

    @Test
    void testParser() throws IOException {
        final var lexer = new FshLexer(CharStreams.fromStream(FSHParserTest.class.getResourceAsStream("/alias.fsh")));
        final var tokens = new CommonTokenStream(lexer);
        final var parser = new FshParser(tokens);
        final var tree = parser.doc();

        final var listener = new FshListener() {
            @Override
            public void enterDoc(final FshParser.DocContext ctx) {
                System.out.println("doc: " + ctx);
            }

            @Override
            public void exitDoc(final FshParser.DocContext ctx) {

            }

            @Override
            public void enterEntity(final FshParser.EntityContext ctx) {
                System.out.println("entity: " + ctx);

            }

            @Override
            public void exitEntity(final FshParser.EntityContext ctx) {

            }

            @Override
            public void enterAlias(final FshParser.AliasContext ctx) {
                System.out.println("alias: " + ctx);

            }

            @Override
            public void exitAlias(final FshParser.AliasContext ctx) {

            }

            /**
             * Enter a parse tree produced by {@link FshParser#aliasName}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void enterAliasName(final FshParser.AliasNameContext ctx) {
                System.out.println("aliasName: " + ctx);

            }

            /**
             * Exit a parse tree produced by {@link FshParser#aliasName}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void exitAliasName(final FshParser.AliasNameContext ctx) {

            }

            /**
             * Enter a parse tree produced by {@link FshParser#aliasValue}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void enterAliasValue(final FshParser.AliasValueContext ctx) {
                System.out.println("aliasValue: " + ctx);

            }

            /**
             * Exit a parse tree produced by {@link FshParser#aliasValue}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void exitAliasValue(final FshParser.AliasValueContext ctx) {

            }

            /**
             * Enter a parse tree produced by {@link FshParser#ruleStart}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void enterRuleStart(final FshParser.RuleStartContext ctx) {

            }

            /**
             * Exit a parse tree produced by {@link FshParser#ruleStart}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void exitRuleStart(final FshParser.RuleStartContext ctx) {

            }

            /**
             * Enter a parse tree produced by {@link FshParser#path}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void enterPath(final FshParser.PathContext ctx) {

            }

            /**
             * Exit a parse tree produced by {@link FshParser#path}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void exitPath(final FshParser.PathContext ctx) {

            }

            /**
             * Enter a parse tree produced by {@link FshParser#pathPart}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void enterPathPart(final FshParser.PathPartContext ctx) {

            }

            /**
             * Exit a parse tree produced by {@link FshParser#pathPart}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void exitPathPart(final FshParser.PathPartContext ctx) {

            }

            /**
             * Enter a parse tree produced by {@link FshParser#simplePathPart}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void enterSimplePathPart(final FshParser.SimplePathPartContext ctx) {

            }

            /**
             * Exit a parse tree produced by {@link FshParser#simplePathPart}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void exitSimplePathPart(final FshParser.SimplePathPartContext ctx) {

            }

            /**
             * Enter a parse tree produced by {@link FshParser#bracketPathPart}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void enterBracketPathPart(final FshParser.BracketPathPartContext ctx) {

            }

            /**
             * Exit a parse tree produced by {@link FshParser#bracketPathPart}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void exitBracketPathPart(final FshParser.BracketPathPartContext ctx) {

            }

            /**
             * Enter a parse tree produced by {@link FshParser#bracketSuffix}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void enterBracketSuffix(final FshParser.BracketSuffixContext ctx) {

            }

            /**
             * Exit a parse tree produced by {@link FshParser#bracketSuffix}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void exitBracketSuffix(final FshParser.BracketSuffixContext ctx) {

            }

            /**
             * Enter a parse tree produced by {@link FshParser#cardinality}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void enterCardinality(final FshParser.CardinalityContext ctx) {

            }

            /**
             * Exit a parse tree produced by {@link FshParser#cardinality}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void exitCardinality(final FshParser.CardinalityContext ctx) {

            }

            /**
             * Enter a parse tree produced by {@link FshParser#number}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void enterNumber(final FshParser.NumberContext ctx) {

            }

            /**
             * Exit a parse tree produced by {@link FshParser#number}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void exitNumber(final FshParser.NumberContext ctx) {

            }

            /**
             * Enter a parse tree produced by {@link FshParser#integer}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void enterInteger(final FshParser.IntegerContext ctx) {

            }

            /**
             * Exit a parse tree produced by {@link FshParser#integer}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void exitInteger(final FshParser.IntegerContext ctx) {

            }

            /**
             * Enter a parse tree produced by {@link FshParser#unit}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void enterUnit(final FshParser.UnitContext ctx) {

            }

            /**
             * Exit a parse tree produced by {@link FshParser#unit}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void exitUnit(final FshParser.UnitContext ctx) {

            }

            /**
             * Enter a parse tree produced by {@link FshParser#code}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void enterCode(final FshParser.CodeContext ctx) {

            }

            /**
             * Exit a parse tree produced by {@link FshParser#code}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void exitCode(final FshParser.CodeContext ctx) {

            }

            /**
             * Enter a parse tree produced by {@link FshParser#dateTime}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void enterDateTime(final FshParser.DateTimeContext ctx) {

            }

            /**
             * Exit a parse tree produced by {@link FshParser#dateTime}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void exitDateTime(final FshParser.DateTimeContext ctx) {

            }

            /**
             * Enter a parse tree produced by {@link FshParser#time}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void enterTime(final FshParser.TimeContext ctx) {

            }

            /**
             * Exit a parse tree produced by {@link FshParser#time}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void exitTime(final FshParser.TimeContext ctx) {

            }

            @Override
            public void visitTerminal(final TerminalNode node) {
                System.out.println("terminal: " + node);

            }

            @Override
            public void visitErrorNode(final ErrorNode node) {

            }

            @Override
            public void enterEveryRule(final ParserRuleContext ctx) {
            }

            @Override
            public void exitEveryRule(final ParserRuleContext ctx) {

            }
        };
        final var walker = new ParseTreeWalker();
        walker.walk(listener, tree);
    }
}

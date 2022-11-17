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
            public void enterAlias(final FshParser.AliasContext ctx) {
                System.out.println("alias: " + ctx);

            }

            @Override
            public void exitAlias(final FshParser.AliasContext ctx) {

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
             * Enter a parse tree produced by {@link FshParser#profile}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void enterProfile(final FshParser.ProfileContext ctx) {

            }

            /**
             * Exit a parse tree produced by {@link FshParser#profile}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void exitProfile(final FshParser.ProfileContext ctx) {

            }

            /**
             * Enter a parse tree produced by {@link FshParser#extension}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void enterExtension(final FshParser.ExtensionContext ctx) {

            }

            /**
             * Exit a parse tree produced by {@link FshParser#extension}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void exitExtension(final FshParser.ExtensionContext ctx) {

            }

            /**
             * Enter a parse tree produced by {@link FshParser#invariant}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void enterInvariant(final FshParser.InvariantContext ctx) {

            }

            /**
             * Exit a parse tree produced by {@link FshParser#invariant}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void exitInvariant(final FshParser.InvariantContext ctx) {

            }

            /**
             * Enter a parse tree produced by {@link FshParser#invariantMetadata}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void enterInvariantMetadata(final FshParser.InvariantMetadataContext ctx) {

            }

            /**
             * Exit a parse tree produced by {@link FshParser#invariantMetadata}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void exitInvariantMetadata(final FshParser.InvariantMetadataContext ctx) {

            }

            /**
             * Enter a parse tree produced by {@link FshParser#instance}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void enterInstance(final FshParser.InstanceContext ctx) {

            }

            /**
             * Exit a parse tree produced by {@link FshParser#instance}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void exitInstance(final FshParser.InstanceContext ctx) {

            }

            /**
             * Enter a parse tree produced by {@link FshParser#instanceMetadata}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void enterInstanceMetadata(final FshParser.InstanceMetadataContext ctx) {

            }

            /**
             * Exit a parse tree produced by {@link FshParser#instanceMetadata}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void exitInstanceMetadata(final FshParser.InstanceMetadataContext ctx) {

            }

            /**
             * Enter a parse tree produced by {@link FshParser#instanceRule}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void enterInstanceRule(final FshParser.InstanceRuleContext ctx) {

            }

            /**
             * Exit a parse tree produced by {@link FshParser#instanceRule}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void exitInstanceRule(final FshParser.InstanceRuleContext ctx) {

            }

            /**
             * Enter a parse tree produced by {@link FshParser#valueSet}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void enterValueSet(final FshParser.ValueSetContext ctx) {

            }

            /**
             * Exit a parse tree produced by {@link FshParser#valueSet}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void exitValueSet(final FshParser.ValueSetContext ctx) {

            }

            /**
             * Enter a parse tree produced by {@link FshParser#vsRule}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void enterVsRule(final FshParser.VsRuleContext ctx) {

            }

            /**
             * Exit a parse tree produced by {@link FshParser#vsRule}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void exitVsRule(final FshParser.VsRuleContext ctx) {

            }

            /**
             * Enter a parse tree produced by {@link FshParser#vsMetadata}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void enterVsMetadata(final FshParser.VsMetadataContext ctx) {

            }

            /**
             * Exit a parse tree produced by {@link FshParser#vsMetadata}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void exitVsMetadata(final FshParser.VsMetadataContext ctx) {

            }

            /**
             * Enter a parse tree produced by {@link FshParser#vsComponent}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void enterVsComponent(final FshParser.VsComponentContext ctx) {

            }

            /**
             * Exit a parse tree produced by {@link FshParser#vsComponent}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void exitVsComponent(final FshParser.VsComponentContext ctx) {

            }

            /**
             * Enter a parse tree produced by {@link FshParser#vsConceptComponent}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void enterVsConceptComponent(final FshParser.VsConceptComponentContext ctx) {

            }

            /**
             * Exit a parse tree produced by {@link FshParser#vsConceptComponent}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void exitVsConceptComponent(final FshParser.VsConceptComponentContext ctx) {

            }

            /**
             * Enter a parse tree produced by {@link FshParser#vsFilterComponent}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void enterVsFilterComponent(final FshParser.VsFilterComponentContext ctx) {

            }

            /**
             * Exit a parse tree produced by {@link FshParser#vsFilterComponent}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void exitVsFilterComponent(final FshParser.VsFilterComponentContext ctx) {

            }

            /**
             * Enter a parse tree produced by {@link FshParser#vsComponentFrom}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void enterVsComponentFrom(final FshParser.VsComponentFromContext ctx) {

            }

            /**
             * Exit a parse tree produced by {@link FshParser#vsComponentFrom}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void exitVsComponentFrom(final FshParser.VsComponentFromContext ctx) {

            }

            /**
             * Enter a parse tree produced by {@link FshParser#vsFromSystem}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void enterVsFromSystem(final FshParser.VsFromSystemContext ctx) {

            }

            /**
             * Exit a parse tree produced by {@link FshParser#vsFromSystem}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void exitVsFromSystem(final FshParser.VsFromSystemContext ctx) {

            }

            /**
             * Enter a parse tree produced by {@link FshParser#vsFromValueset}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void enterVsFromValueset(final FshParser.VsFromValuesetContext ctx) {

            }

            /**
             * Exit a parse tree produced by {@link FshParser#vsFromValueset}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void exitVsFromValueset(final FshParser.VsFromValuesetContext ctx) {

            }

            /**
             * Enter a parse tree produced by {@link FshParser#vsFilterList}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void enterVsFilterList(final FshParser.VsFilterListContext ctx) {

            }

            /**
             * Exit a parse tree produced by {@link FshParser#vsFilterList}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void exitVsFilterList(final FshParser.VsFilterListContext ctx) {

            }

            /**
             * Enter a parse tree produced by {@link FshParser#vsFilterDefinition}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void enterVsFilterDefinition(final FshParser.VsFilterDefinitionContext ctx) {

            }

            /**
             * Exit a parse tree produced by {@link FshParser#vsFilterDefinition}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void exitVsFilterDefinition(final FshParser.VsFilterDefinitionContext ctx) {

            }

            /**
             * Enter a parse tree produced by {@link FshParser#vsFilterOperator}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void enterVsFilterOperator(final FshParser.VsFilterOperatorContext ctx) {

            }

            /**
             * Exit a parse tree produced by {@link FshParser#vsFilterOperator}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void exitVsFilterOperator(final FshParser.VsFilterOperatorContext ctx) {

            }

            /**
             * Enter a parse tree produced by {@link FshParser#vsFilterValue}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void enterVsFilterValue(final FshParser.VsFilterValueContext ctx) {

            }

            /**
             * Exit a parse tree produced by {@link FshParser#vsFilterValue}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void exitVsFilterValue(final FshParser.VsFilterValueContext ctx) {

            }

            /**
             * Enter a parse tree produced by {@link FshParser#codeSystem}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void enterCodeSystem(final FshParser.CodeSystemContext ctx) {

            }

            /**
             * Exit a parse tree produced by {@link FshParser#codeSystem}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void exitCodeSystem(final FshParser.CodeSystemContext ctx) {

            }

            /**
             * Enter a parse tree produced by {@link FshParser#csMetadata}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void enterCsMetadata(final FshParser.CsMetadataContext ctx) {

            }

            /**
             * Exit a parse tree produced by {@link FshParser#csMetadata}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void exitCsMetadata(final FshParser.CsMetadataContext ctx) {

            }

            /**
             * Enter a parse tree produced by {@link FshParser#csRule}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void enterCsRule(final FshParser.CsRuleContext ctx) {

            }

            /**
             * Exit a parse tree produced by {@link FshParser#csRule}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void exitCsRule(final FshParser.CsRuleContext ctx) {

            }

            /**
             * Enter a parse tree produced by {@link FshParser#ruleSet}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void enterRuleSet(final FshParser.RuleSetContext ctx) {

            }

            /**
             * Exit a parse tree produced by {@link FshParser#ruleSet}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void exitRuleSet(final FshParser.RuleSetContext ctx) {

            }

            /**
             * Enter a parse tree produced by {@link FshParser#ruleSetRule}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void enterRuleSetRule(final FshParser.RuleSetRuleContext ctx) {

            }

            /**
             * Exit a parse tree produced by {@link FshParser#ruleSetRule}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void exitRuleSetRule(final FshParser.RuleSetRuleContext ctx) {

            }

            /**
             * Enter a parse tree produced by {@link FshParser#mapping}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void enterMapping(final FshParser.MappingContext ctx) {

            }

            /**
             * Exit a parse tree produced by {@link FshParser#mapping}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void exitMapping(final FshParser.MappingContext ctx) {

            }

            /**
             * Enter a parse tree produced by {@link FshParser#mappingMetadata}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void enterMappingMetadata(final FshParser.MappingMetadataContext ctx) {

            }

            /**
             * Exit a parse tree produced by {@link FshParser#mappingMetadata}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void exitMappingMetadata(final FshParser.MappingMetadataContext ctx) {

            }

            /**
             * Enter a parse tree produced by {@link FshParser#mappingEntityRule}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void enterMappingEntityRule(final FshParser.MappingEntityRuleContext ctx) {

            }

            /**
             * Exit a parse tree produced by {@link FshParser#mappingEntityRule}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void exitMappingEntityRule(final FshParser.MappingEntityRuleContext ctx) {

            }

            /**
             * Enter a parse tree produced by {@link FshParser#logical}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void enterLogical(final FshParser.LogicalContext ctx) {

            }

            /**
             * Exit a parse tree produced by {@link FshParser#logical}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void exitLogical(final FshParser.LogicalContext ctx) {

            }

            /**
             * Enter a parse tree produced by {@link FshParser#resource}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void enterResource(final FshParser.ResourceContext ctx) {

            }

            /**
             * Exit a parse tree produced by {@link FshParser#resource}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void exitResource(final FshParser.ResourceContext ctx) {

            }

            /**
             * Enter a parse tree produced by {@link FshParser#sdMetadata}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void enterSdMetadata(final FshParser.SdMetadataContext ctx) {

            }

            /**
             * Exit a parse tree produced by {@link FshParser#sdMetadata}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void exitSdMetadata(final FshParser.SdMetadataContext ctx) {

            }

            /**
             * Enter a parse tree produced by {@link FshParser#parent}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void enterParent(final FshParser.ParentContext ctx) {

            }

            /**
             * Exit a parse tree produced by {@link FshParser#parent}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void exitParent(final FshParser.ParentContext ctx) {

            }

            /**
             * Enter a parse tree produced by {@link FshParser#id}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void enterId(final FshParser.IdContext ctx) {

            }

            /**
             * Exit a parse tree produced by {@link FshParser#id}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void exitId(final FshParser.IdContext ctx) {

            }

            /**
             * Enter a parse tree produced by {@link FshParser#title}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void enterTitle(final FshParser.TitleContext ctx) {

            }

            /**
             * Exit a parse tree produced by {@link FshParser#title}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void exitTitle(final FshParser.TitleContext ctx) {

            }

            /**
             * Enter a parse tree produced by {@link FshParser#description}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void enterDescription(final FshParser.DescriptionContext ctx) {

            }

            /**
             * Exit a parse tree produced by {@link FshParser#description}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void exitDescription(final FshParser.DescriptionContext ctx) {

            }

            /**
             * Enter a parse tree produced by {@link FshParser#expression}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void enterExpression(final FshParser.ExpressionContext ctx) {

            }

            /**
             * Exit a parse tree produced by {@link FshParser#expression}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void exitExpression(final FshParser.ExpressionContext ctx) {

            }

            /**
             * Enter a parse tree produced by {@link FshParser#xpath}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void enterXpath(final FshParser.XpathContext ctx) {

            }

            /**
             * Exit a parse tree produced by {@link FshParser#xpath}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void exitXpath(final FshParser.XpathContext ctx) {

            }

            /**
             * Enter a parse tree produced by {@link FshParser#severity}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void enterSeverity(final FshParser.SeverityContext ctx) {

            }

            /**
             * Exit a parse tree produced by {@link FshParser#severity}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void exitSeverity(final FshParser.SeverityContext ctx) {

            }

            /**
             * Enter a parse tree produced by {@link FshParser#instanceOf}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void enterInstanceOf(final FshParser.InstanceOfContext ctx) {

            }

            /**
             * Exit a parse tree produced by {@link FshParser#instanceOf}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void exitInstanceOf(final FshParser.InstanceOfContext ctx) {

            }

            /**
             * Enter a parse tree produced by {@link FshParser#usage}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void enterUsage(final FshParser.UsageContext ctx) {

            }

            /**
             * Exit a parse tree produced by {@link FshParser#usage}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void exitUsage(final FshParser.UsageContext ctx) {

            }

            /**
             * Enter a parse tree produced by {@link FshParser#source}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void enterSource(final FshParser.SourceContext ctx) {

            }

            /**
             * Exit a parse tree produced by {@link FshParser#source}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void exitSource(final FshParser.SourceContext ctx) {

            }

            /**
             * Enter a parse tree produced by {@link FshParser#target}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void enterTarget(final FshParser.TargetContext ctx) {

            }

            /**
             * Exit a parse tree produced by {@link FshParser#target}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void exitTarget(final FshParser.TargetContext ctx) {

            }

            /**
             * Enter a parse tree produced by {@link FshParser#sdRule}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void enterSdRule(final FshParser.SdRuleContext ctx) {

            }

            /**
             * Exit a parse tree produced by {@link FshParser#sdRule}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void exitSdRule(final FshParser.SdRuleContext ctx) {

            }

            /**
             * Enter a parse tree produced by {@link FshParser#lrRule}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void enterLrRule(final FshParser.LrRuleContext ctx) {

            }

            /**
             * Exit a parse tree produced by {@link FshParser#lrRule}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void exitLrRule(final FshParser.LrRuleContext ctx) {

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
             * Enter a parse tree produced by {@link FshParser#cardRule}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void enterCardRule(final FshParser.CardRuleContext ctx) {

            }

            /**
             * Exit a parse tree produced by {@link FshParser#cardRule}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void exitCardRule(final FshParser.CardRuleContext ctx) {

            }

            /**
             * Enter a parse tree produced by {@link FshParser#flagRule}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void enterFlagRule(final FshParser.FlagRuleContext ctx) {

            }

            /**
             * Exit a parse tree produced by {@link FshParser#flagRule}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void exitFlagRule(final FshParser.FlagRuleContext ctx) {

            }

            /**
             * Enter a parse tree produced by {@link FshParser#valueSetRule}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void enterValueSetRule(final FshParser.ValueSetRuleContext ctx) {

            }

            /**
             * Exit a parse tree produced by {@link FshParser#valueSetRule}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void exitValueSetRule(final FshParser.ValueSetRuleContext ctx) {

            }

            /**
             * Enter a parse tree produced by {@link FshParser#fixedValueRule}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void enterFixedValueRule(final FshParser.FixedValueRuleContext ctx) {

            }

            /**
             * Exit a parse tree produced by {@link FshParser#fixedValueRule}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void exitFixedValueRule(final FshParser.FixedValueRuleContext ctx) {

            }

            /**
             * Enter a parse tree produced by {@link FshParser#containsRule}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void enterContainsRule(final FshParser.ContainsRuleContext ctx) {

            }

            /**
             * Exit a parse tree produced by {@link FshParser#containsRule}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void exitContainsRule(final FshParser.ContainsRuleContext ctx) {

            }

            /**
             * Enter a parse tree produced by {@link FshParser#onlyRule}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void enterOnlyRule(final FshParser.OnlyRuleContext ctx) {

            }

            /**
             * Exit a parse tree produced by {@link FshParser#onlyRule}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void exitOnlyRule(final FshParser.OnlyRuleContext ctx) {

            }

            /**
             * Enter a parse tree produced by {@link FshParser#obeysRule}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void enterObeysRule(final FshParser.ObeysRuleContext ctx) {

            }

            /**
             * Exit a parse tree produced by {@link FshParser#obeysRule}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void exitObeysRule(final FshParser.ObeysRuleContext ctx) {

            }

            /**
             * Enter a parse tree produced by {@link FshParser#caretValueRule}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void enterCaretValueRule(final FshParser.CaretValueRuleContext ctx) {

            }

            /**
             * Exit a parse tree produced by {@link FshParser#caretValueRule}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void exitCaretValueRule(final FshParser.CaretValueRuleContext ctx) {

            }

            /**
             * Enter a parse tree produced by {@link FshParser#codeCaretValueRule}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void enterCodeCaretValueRule(final FshParser.CodeCaretValueRuleContext ctx) {

            }

            /**
             * Exit a parse tree produced by {@link FshParser#codeCaretValueRule}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void exitCodeCaretValueRule(final FshParser.CodeCaretValueRuleContext ctx) {

            }

            /**
             * Enter a parse tree produced by {@link FshParser#mappingRule}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void enterMappingRule(final FshParser.MappingRuleContext ctx) {

            }

            /**
             * Exit a parse tree produced by {@link FshParser#mappingRule}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void exitMappingRule(final FshParser.MappingRuleContext ctx) {

            }

            /**
             * Enter a parse tree produced by {@link FshParser#insertRule}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void enterInsertRule(final FshParser.InsertRuleContext ctx) {

            }

            /**
             * Exit a parse tree produced by {@link FshParser#insertRule}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void exitInsertRule(final FshParser.InsertRuleContext ctx) {

            }

            /**
             * Enter a parse tree produced by {@link FshParser#codeInsertRule}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void enterCodeInsertRule(final FshParser.CodeInsertRuleContext ctx) {

            }

            /**
             * Exit a parse tree produced by {@link FshParser#codeInsertRule}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void exitCodeInsertRule(final FshParser.CodeInsertRuleContext ctx) {

            }

            /**
             * Enter a parse tree produced by {@link FshParser#addCRElementRule}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void enterAddCRElementRule(final FshParser.AddCRElementRuleContext ctx) {

            }

            /**
             * Exit a parse tree produced by {@link FshParser#addCRElementRule}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void exitAddCRElementRule(final FshParser.AddCRElementRuleContext ctx) {

            }

            /**
             * Enter a parse tree produced by {@link FshParser#addElementRule}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void enterAddElementRule(final FshParser.AddElementRuleContext ctx) {

            }

            /**
             * Exit a parse tree produced by {@link FshParser#addElementRule}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void exitAddElementRule(final FshParser.AddElementRuleContext ctx) {

            }

            /**
             * Enter a parse tree produced by {@link FshParser#pathRule}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void enterPathRule(final FshParser.PathRuleContext ctx) {

            }

            /**
             * Exit a parse tree produced by {@link FshParser#pathRule}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void exitPathRule(final FshParser.PathRuleContext ctx) {

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
             * Enter a parse tree produced by {@link FshParser#flag}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void enterFlag(final FshParser.FlagContext ctx) {

            }

            /**
             * Exit a parse tree produced by {@link FshParser#flag}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void exitFlag(final FshParser.FlagContext ctx) {

            }

            /**
             * Enter a parse tree produced by {@link FshParser#strength}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void enterStrength(final FshParser.StrengthContext ctx) {

            }

            /**
             * Exit a parse tree produced by {@link FshParser#strength}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void exitStrength(final FshParser.StrengthContext ctx) {

            }

            /**
             * Enter a parse tree produced by {@link FshParser#ratio}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void enterRatio(final FshParser.RatioContext ctx) {

            }

            /**
             * Exit a parse tree produced by {@link FshParser#ratio}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void exitRatio(final FshParser.RatioContext ctx) {

            }

            /**
             * Enter a parse tree produced by {@link FshParser#quantity}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void enterQuantity(final FshParser.QuantityContext ctx) {

            }

            /**
             * Exit a parse tree produced by {@link FshParser#quantity}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void exitQuantity(final FshParser.QuantityContext ctx) {

            }

            /**
             * Enter a parse tree produced by {@link FshParser#reference}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void enterReference(final FshParser.ReferenceContext ctx) {

            }

            /**
             * Exit a parse tree produced by {@link FshParser#reference}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void exitReference(final FshParser.ReferenceContext ctx) {

            }

            /**
             * Enter a parse tree produced by {@link FshParser#itemIdentifier}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void enterItemIdentifier(final FshParser.ItemIdentifierContext ctx) {

            }

            /**
             * Exit a parse tree produced by {@link FshParser#itemIdentifier}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void exitItemIdentifier(final FshParser.ItemIdentifierContext ctx) {

            }

            /**
             * Enter a parse tree produced by {@link FshParser#canonical}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void enterCanonical(final FshParser.CanonicalContext ctx) {

            }

            /**
             * Exit a parse tree produced by {@link FshParser#canonical}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void exitCanonical(final FshParser.CanonicalContext ctx) {

            }

            /**
             * Enter a parse tree produced by {@link FshParser#targetType}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void enterTargetType(final FshParser.TargetTypeContext ctx) {

            }

            /**
             * Exit a parse tree produced by {@link FshParser#targetType}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void exitTargetType(final FshParser.TargetTypeContext ctx) {

            }

            /**
             * Enter a parse tree produced by {@link FshParser#value}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void enterValue(final FshParser.ValueContext ctx) {

            }

            /**
             * Exit a parse tree produced by {@link FshParser#value}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void exitValue(final FshParser.ValueContext ctx) {

            }

            /**
             * Enter a parse tree produced by {@link FshParser#item}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void enterItem(final FshParser.ItemContext ctx) {

            }

            /**
             * Exit a parse tree produced by {@link FshParser#item}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void exitItem(final FshParser.ItemContext ctx) {

            }

            /**
             * Enter a parse tree produced by {@link FshParser#bool}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void enterBool(final FshParser.BoolContext ctx) {

            }

            /**
             * Exit a parse tree produced by {@link FshParser#bool}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void exitBool(final FshParser.BoolContext ctx) {

            }

            /**
             * Enter a parse tree produced by {@link FshParser#concept}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void enterConcept(final FshParser.ConceptContext ctx) {

            }

            /**
             * Exit a parse tree produced by {@link FshParser#concept}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void exitConcept(final FshParser.ConceptContext ctx) {

            }

            /**
             * Enter a parse tree produced by {@link FshParser#ruleSetReference}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void enterRuleSetReference(final FshParser.RuleSetReferenceContext ctx) {

            }

            /**
             * Exit a parse tree produced by {@link FshParser#ruleSetReference}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void exitRuleSetReference(final FshParser.RuleSetReferenceContext ctx) {

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

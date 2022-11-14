package ch.qligier.jetbrains.fsh.grammar;

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
        final var lexer = new FSHLexer(CharStreams.fromStream(FSHParserTest.class.getResourceAsStream("/test1.fsh")));
        final var tokens = new CommonTokenStream(lexer);
        final var parser = new FSHParser(tokens);
        final var tree = parser.doc();

        final var listener = new FSHListener() {
            @Override
            public void enterDoc(final FSHParser.DocContext ctx) {

            }

            @Override
            public void exitDoc(final FSHParser.DocContext ctx) {

            }

            @Override
            public void enterEntity(final FSHParser.EntityContext ctx) {

            }

            @Override
            public void exitEntity(final FSHParser.EntityContext ctx) {

            }

            @Override
            public void enterAlias(final FSHParser.AliasContext ctx) {

            }

            @Override
            public void exitAlias(final FSHParser.AliasContext ctx) {

            }

            @Override
            public void enterProfile(final FSHParser.ProfileContext ctx) {

            }

            @Override
            public void exitProfile(final FSHParser.ProfileContext ctx) {

            }

            @Override
            public void enterExtension(final FSHParser.ExtensionContext ctx) {

            }

            @Override
            public void exitExtension(final FSHParser.ExtensionContext ctx) {

            }

            @Override
            public void enterLogical(final FSHParser.LogicalContext ctx) {

            }

            @Override
            public void exitLogical(final FSHParser.LogicalContext ctx) {

            }

            @Override
            public void enterResource(final FSHParser.ResourceContext ctx) {

            }

            @Override
            public void exitResource(final FSHParser.ResourceContext ctx) {

            }

            @Override
            public void enterSdMetadata(final FSHParser.SdMetadataContext ctx) {

            }

            @Override
            public void exitSdMetadata(final FSHParser.SdMetadataContext ctx) {

            }

            @Override
            public void enterSdRule(final FSHParser.SdRuleContext ctx) {

            }

            @Override
            public void exitSdRule(final FSHParser.SdRuleContext ctx) {

            }

            @Override
            public void enterLrRule(final FSHParser.LrRuleContext ctx) {

            }

            @Override
            public void exitLrRule(final FSHParser.LrRuleContext ctx) {

            }

            @Override
            public void enterInstance(final FSHParser.InstanceContext ctx) {

            }

            @Override
            public void exitInstance(final FSHParser.InstanceContext ctx) {

            }

            @Override
            public void enterInstanceMetadata(final FSHParser.InstanceMetadataContext ctx) {

            }

            @Override
            public void exitInstanceMetadata(final FSHParser.InstanceMetadataContext ctx) {

            }

            @Override
            public void enterInstanceRule(final FSHParser.InstanceRuleContext ctx) {

            }

            @Override
            public void exitInstanceRule(final FSHParser.InstanceRuleContext ctx) {

            }

            @Override
            public void enterInvariant(final FSHParser.InvariantContext ctx) {

            }

            @Override
            public void exitInvariant(final FSHParser.InvariantContext ctx) {

            }

            @Override
            public void enterInvariantMetadata(final FSHParser.InvariantMetadataContext ctx) {

            }

            @Override
            public void exitInvariantMetadata(final FSHParser.InvariantMetadataContext ctx) {

            }

            @Override
            public void enterValueSet(final FSHParser.ValueSetContext ctx) {

            }

            @Override
            public void exitValueSet(final FSHParser.ValueSetContext ctx) {

            }

            @Override
            public void enterVsMetadata(final FSHParser.VsMetadataContext ctx) {

            }

            @Override
            public void exitVsMetadata(final FSHParser.VsMetadataContext ctx) {

            }

            @Override
            public void enterVsRule(final FSHParser.VsRuleContext ctx) {

            }

            @Override
            public void exitVsRule(final FSHParser.VsRuleContext ctx) {

            }

            @Override
            public void enterCodeSystem(final FSHParser.CodeSystemContext ctx) {

            }

            @Override
            public void exitCodeSystem(final FSHParser.CodeSystemContext ctx) {

            }

            @Override
            public void enterCsMetadata(final FSHParser.CsMetadataContext ctx) {

            }

            @Override
            public void exitCsMetadata(final FSHParser.CsMetadataContext ctx) {

            }

            @Override
            public void enterCsRule(final FSHParser.CsRuleContext ctx) {

            }

            @Override
            public void exitCsRule(final FSHParser.CsRuleContext ctx) {

            }

            @Override
            public void enterRuleSet(final FSHParser.RuleSetContext ctx) {

            }

            @Override
            public void exitRuleSet(final FSHParser.RuleSetContext ctx) {

            }

            @Override
            public void enterRuleSetRule(final FSHParser.RuleSetRuleContext ctx) {

            }

            @Override
            public void exitRuleSetRule(final FSHParser.RuleSetRuleContext ctx) {

            }

            @Override
            public void enterParamRuleSet(final FSHParser.ParamRuleSetContext ctx) {

            }

            @Override
            public void exitParamRuleSet(final FSHParser.ParamRuleSetContext ctx) {

            }

            @Override
            public void enterParamRuleSetContent(final FSHParser.ParamRuleSetContentContext ctx) {

            }

            @Override
            public void exitParamRuleSetContent(final FSHParser.ParamRuleSetContentContext ctx) {

            }

            @Override
            public void enterMapping(final FSHParser.MappingContext ctx) {

            }

            @Override
            public void exitMapping(final FSHParser.MappingContext ctx) {

            }

            @Override
            public void enterMappingMetadata(final FSHParser.MappingMetadataContext ctx) {

            }

            @Override
            public void exitMappingMetadata(final FSHParser.MappingMetadataContext ctx) {

            }

            @Override
            public void enterMappingEntityRule(final FSHParser.MappingEntityRuleContext ctx) {

            }

            @Override
            public void exitMappingEntityRule(final FSHParser.MappingEntityRuleContext ctx) {

            }

            @Override
            public void enterParent(final FSHParser.ParentContext ctx) {

            }

            @Override
            public void exitParent(final FSHParser.ParentContext ctx) {

            }

            @Override
            public void enterId(final FSHParser.IdContext ctx) {

            }

            @Override
            public void exitId(final FSHParser.IdContext ctx) {

            }

            @Override
            public void enterTitle(final FSHParser.TitleContext ctx) {

            }

            @Override
            public void exitTitle(final FSHParser.TitleContext ctx) {

            }

            @Override
            public void enterDescription(final FSHParser.DescriptionContext ctx) {

            }

            @Override
            public void exitDescription(final FSHParser.DescriptionContext ctx) {

            }

            @Override
            public void enterExpression(final FSHParser.ExpressionContext ctx) {

            }

            @Override
            public void exitExpression(final FSHParser.ExpressionContext ctx) {

            }

            @Override
            public void enterXpath(final FSHParser.XpathContext ctx) {

            }

            @Override
            public void exitXpath(final FSHParser.XpathContext ctx) {

            }

            @Override
            public void enterSeverity(final FSHParser.SeverityContext ctx) {

            }

            @Override
            public void exitSeverity(final FSHParser.SeverityContext ctx) {

            }

            @Override
            public void enterInstanceOf(final FSHParser.InstanceOfContext ctx) {

            }

            @Override
            public void exitInstanceOf(final FSHParser.InstanceOfContext ctx) {

            }

            /**
             * Enter a parse tree produced by {@link FSHParser#usage}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void enterUsage(final FSHParser.UsageContext ctx) {

            }

            /**
             * Exit a parse tree produced by {@link FSHParser#usage}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void exitUsage(final FSHParser.UsageContext ctx) {

            }

            /**
             * Enter a parse tree produced by {@link FSHParser#source}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void enterSource(final FSHParser.SourceContext ctx) {

            }

            /**
             * Exit a parse tree produced by {@link FSHParser#source}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void exitSource(final FSHParser.SourceContext ctx) {

            }

            /**
             * Enter a parse tree produced by {@link FSHParser#target}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void enterTarget(final FSHParser.TargetContext ctx) {

            }

            /**
             * Exit a parse tree produced by {@link FSHParser#target}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void exitTarget(final FSHParser.TargetContext ctx) {

            }

            /**
             * Enter a parse tree produced by {@link FSHParser#cardRule}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void enterCardRule(final FSHParser.CardRuleContext ctx) {

            }

            /**
             * Exit a parse tree produced by {@link FSHParser#cardRule}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void exitCardRule(final FSHParser.CardRuleContext ctx) {

            }

            /**
             * Enter a parse tree produced by {@link FSHParser#flagRule}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void enterFlagRule(final FSHParser.FlagRuleContext ctx) {

            }

            /**
             * Exit a parse tree produced by {@link FSHParser#flagRule}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void exitFlagRule(final FSHParser.FlagRuleContext ctx) {

            }

            /**
             * Enter a parse tree produced by {@link FSHParser#valueSetRule}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void enterValueSetRule(final FSHParser.ValueSetRuleContext ctx) {

            }

            /**
             * Exit a parse tree produced by {@link FSHParser#valueSetRule}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void exitValueSetRule(final FSHParser.ValueSetRuleContext ctx) {

            }

            /**
             * Enter a parse tree produced by {@link FSHParser#fixedValueRule}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void enterFixedValueRule(final FSHParser.FixedValueRuleContext ctx) {

            }

            /**
             * Exit a parse tree produced by {@link FSHParser#fixedValueRule}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void exitFixedValueRule(final FSHParser.FixedValueRuleContext ctx) {

            }

            /**
             * Enter a parse tree produced by {@link FSHParser#containsRule}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void enterContainsRule(final FSHParser.ContainsRuleContext ctx) {

            }

            /**
             * Exit a parse tree produced by {@link FSHParser#containsRule}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void exitContainsRule(final FSHParser.ContainsRuleContext ctx) {

            }

            /**
             * Enter a parse tree produced by {@link FSHParser#onlyRule}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void enterOnlyRule(final FSHParser.OnlyRuleContext ctx) {

            }

            /**
             * Exit a parse tree produced by {@link FSHParser#onlyRule}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void exitOnlyRule(final FSHParser.OnlyRuleContext ctx) {

            }

            /**
             * Enter a parse tree produced by {@link FSHParser#obeysRule}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void enterObeysRule(final FSHParser.ObeysRuleContext ctx) {

            }

            /**
             * Exit a parse tree produced by {@link FSHParser#obeysRule}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void exitObeysRule(final FSHParser.ObeysRuleContext ctx) {

            }

            /**
             * Enter a parse tree produced by {@link FSHParser#caretValueRule}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void enterCaretValueRule(final FSHParser.CaretValueRuleContext ctx) {

            }

            /**
             * Exit a parse tree produced by {@link FSHParser#caretValueRule}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void exitCaretValueRule(final FSHParser.CaretValueRuleContext ctx) {

            }

            /**
             * Enter a parse tree produced by {@link FSHParser#codeCaretValueRule}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void enterCodeCaretValueRule(final FSHParser.CodeCaretValueRuleContext ctx) {

            }

            /**
             * Exit a parse tree produced by {@link FSHParser#codeCaretValueRule}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void exitCodeCaretValueRule(final FSHParser.CodeCaretValueRuleContext ctx) {

            }

            /**
             * Enter a parse tree produced by {@link FSHParser#mappingRule}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void enterMappingRule(final FSHParser.MappingRuleContext ctx) {

            }

            /**
             * Exit a parse tree produced by {@link FSHParser#mappingRule}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void exitMappingRule(final FSHParser.MappingRuleContext ctx) {

            }

            /**
             * Enter a parse tree produced by {@link FSHParser#insertRule}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void enterInsertRule(final FSHParser.InsertRuleContext ctx) {

            }

            /**
             * Exit a parse tree produced by {@link FSHParser#insertRule}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void exitInsertRule(final FSHParser.InsertRuleContext ctx) {

            }

            /**
             * Enter a parse tree produced by {@link FSHParser#codeInsertRule}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void enterCodeInsertRule(final FSHParser.CodeInsertRuleContext ctx) {

            }

            /**
             * Exit a parse tree produced by {@link FSHParser#codeInsertRule}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void exitCodeInsertRule(final FSHParser.CodeInsertRuleContext ctx) {

            }

            /**
             * Enter a parse tree produced by {@link FSHParser#addCRElementRule}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void enterAddCRElementRule(final FSHParser.AddCRElementRuleContext ctx) {

            }

            /**
             * Exit a parse tree produced by {@link FSHParser#addCRElementRule}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void exitAddCRElementRule(final FSHParser.AddCRElementRuleContext ctx) {

            }

            /**
             * Enter a parse tree produced by {@link FSHParser#addElementRule}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void enterAddElementRule(final FSHParser.AddElementRuleContext ctx) {

            }

            /**
             * Exit a parse tree produced by {@link FSHParser#addElementRule}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void exitAddElementRule(final FSHParser.AddElementRuleContext ctx) {

            }

            /**
             * Enter a parse tree produced by {@link FSHParser#pathRule}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void enterPathRule(final FSHParser.PathRuleContext ctx) {

            }

            /**
             * Exit a parse tree produced by {@link FSHParser#pathRule}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void exitPathRule(final FSHParser.PathRuleContext ctx) {

            }

            /**
             * Enter a parse tree produced by {@link FSHParser#vsComponent}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void enterVsComponent(final FSHParser.VsComponentContext ctx) {

            }

            /**
             * Exit a parse tree produced by {@link FSHParser#vsComponent}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void exitVsComponent(final FSHParser.VsComponentContext ctx) {

            }

            /**
             * Enter a parse tree produced by {@link FSHParser#vsConceptComponent}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void enterVsConceptComponent(final FSHParser.VsConceptComponentContext ctx) {

            }

            /**
             * Exit a parse tree produced by {@link FSHParser#vsConceptComponent}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void exitVsConceptComponent(final FSHParser.VsConceptComponentContext ctx) {

            }

            /**
             * Enter a parse tree produced by {@link FSHParser#vsFilterComponent}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void enterVsFilterComponent(final FSHParser.VsFilterComponentContext ctx) {

            }

            /**
             * Exit a parse tree produced by {@link FSHParser#vsFilterComponent}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void exitVsFilterComponent(final FSHParser.VsFilterComponentContext ctx) {

            }

            /**
             * Enter a parse tree produced by {@link FSHParser#vsComponentFrom}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void enterVsComponentFrom(final FSHParser.VsComponentFromContext ctx) {

            }

            /**
             * Exit a parse tree produced by {@link FSHParser#vsComponentFrom}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void exitVsComponentFrom(final FSHParser.VsComponentFromContext ctx) {

            }

            /**
             * Enter a parse tree produced by {@link FSHParser#vsFromSystem}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void enterVsFromSystem(final FSHParser.VsFromSystemContext ctx) {

            }

            /**
             * Exit a parse tree produced by {@link FSHParser#vsFromSystem}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void exitVsFromSystem(final FSHParser.VsFromSystemContext ctx) {

            }

            /**
             * Enter a parse tree produced by {@link FSHParser#vsFromValueset}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void enterVsFromValueset(final FSHParser.VsFromValuesetContext ctx) {

            }

            /**
             * Exit a parse tree produced by {@link FSHParser#vsFromValueset}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void exitVsFromValueset(final FSHParser.VsFromValuesetContext ctx) {

            }

            /**
             * Enter a parse tree produced by {@link FSHParser#vsFilterList}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void enterVsFilterList(final FSHParser.VsFilterListContext ctx) {

            }

            /**
             * Exit a parse tree produced by {@link FSHParser#vsFilterList}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void exitVsFilterList(final FSHParser.VsFilterListContext ctx) {

            }

            /**
             * Enter a parse tree produced by {@link FSHParser#vsFilterDefinition}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void enterVsFilterDefinition(final FSHParser.VsFilterDefinitionContext ctx) {

            }

            /**
             * Exit a parse tree produced by {@link FSHParser#vsFilterDefinition}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void exitVsFilterDefinition(final FSHParser.VsFilterDefinitionContext ctx) {

            }

            /**
             * Enter a parse tree produced by {@link FSHParser#vsFilterOperator}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void enterVsFilterOperator(final FSHParser.VsFilterOperatorContext ctx) {

            }

            /**
             * Exit a parse tree produced by {@link FSHParser#vsFilterOperator}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void exitVsFilterOperator(final FSHParser.VsFilterOperatorContext ctx) {

            }

            /**
             * Enter a parse tree produced by {@link FSHParser#vsFilterValue}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void enterVsFilterValue(final FSHParser.VsFilterValueContext ctx) {

            }

            /**
             * Exit a parse tree produced by {@link FSHParser#vsFilterValue}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void exitVsFilterValue(final FSHParser.VsFilterValueContext ctx) {

            }

            /**
             * Enter a parse tree produced by {@link FSHParser#name}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void enterName(final FSHParser.NameContext ctx) {

            }

            /**
             * Exit a parse tree produced by {@link FSHParser#name}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void exitName(final FSHParser.NameContext ctx) {

            }

            /**
             * Enter a parse tree produced by {@link FSHParser#path}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void enterPath(final FSHParser.PathContext ctx) {

            }

            /**
             * Exit a parse tree produced by {@link FSHParser#path}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void exitPath(final FSHParser.PathContext ctx) {

            }

            /**
             * Enter a parse tree produced by {@link FSHParser#caretPath}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void enterCaretPath(final FSHParser.CaretPathContext ctx) {

            }

            /**
             * Exit a parse tree produced by {@link FSHParser#caretPath}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void exitCaretPath(final FSHParser.CaretPathContext ctx) {

            }

            /**
             * Enter a parse tree produced by {@link FSHParser#flag}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void enterFlag(final FSHParser.FlagContext ctx) {

            }

            /**
             * Exit a parse tree produced by {@link FSHParser#flag}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void exitFlag(final FSHParser.FlagContext ctx) {

            }

            /**
             * Enter a parse tree produced by {@link FSHParser#strength}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void enterStrength(final FSHParser.StrengthContext ctx) {

            }

            /**
             * Exit a parse tree produced by {@link FSHParser#strength}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void exitStrength(final FSHParser.StrengthContext ctx) {

            }

            /**
             * Enter a parse tree produced by {@link FSHParser#value}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void enterValue(final FSHParser.ValueContext ctx) {

            }

            /**
             * Exit a parse tree produced by {@link FSHParser#value}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void exitValue(final FSHParser.ValueContext ctx) {

            }

            /**
             * Enter a parse tree produced by {@link FSHParser#item}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void enterItem(final FSHParser.ItemContext ctx) {

            }

            /**
             * Exit a parse tree produced by {@link FSHParser#item}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void exitItem(final FSHParser.ItemContext ctx) {

            }

            /**
             * Enter a parse tree produced by {@link FSHParser#code}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void enterCode(final FSHParser.CodeContext ctx) {

            }

            /**
             * Exit a parse tree produced by {@link FSHParser#code}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void exitCode(final FSHParser.CodeContext ctx) {

            }

            /**
             * Enter a parse tree produced by {@link FSHParser#concept}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void enterConcept(final FSHParser.ConceptContext ctx) {

            }

            /**
             * Exit a parse tree produced by {@link FSHParser#concept}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void exitConcept(final FSHParser.ConceptContext ctx) {

            }

            /**
             * Enter a parse tree produced by {@link FSHParser#quantity}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void enterQuantity(final FSHParser.QuantityContext ctx) {

            }

            /**
             * Exit a parse tree produced by {@link FSHParser#quantity}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void exitQuantity(final FSHParser.QuantityContext ctx) {

            }

            /**
             * Enter a parse tree produced by {@link FSHParser#ratio}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void enterRatio(final FSHParser.RatioContext ctx) {

            }

            /**
             * Exit a parse tree produced by {@link FSHParser#ratio}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void exitRatio(final FSHParser.RatioContext ctx) {

            }

            /**
             * Enter a parse tree produced by {@link FSHParser#reference}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void enterReference(final FSHParser.ReferenceContext ctx) {

            }

            /**
             * Exit a parse tree produced by {@link FSHParser#reference}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void exitReference(final FSHParser.ReferenceContext ctx) {

            }

            /**
             * Enter a parse tree produced by {@link FSHParser#referenceType}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void enterReferenceType(final FSHParser.ReferenceTypeContext ctx) {

            }

            /**
             * Exit a parse tree produced by {@link FSHParser#referenceType}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void exitReferenceType(final FSHParser.ReferenceTypeContext ctx) {

            }

            /**
             * Enter a parse tree produced by {@link FSHParser#canonical}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void enterCanonical(final FSHParser.CanonicalContext ctx) {

            }

            /**
             * Exit a parse tree produced by {@link FSHParser#canonical}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void exitCanonical(final FSHParser.CanonicalContext ctx) {

            }

            /**
             * Enter a parse tree produced by {@link FSHParser#ratioPart}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void enterRatioPart(final FSHParser.RatioPartContext ctx) {

            }

            /**
             * Exit a parse tree produced by {@link FSHParser#ratioPart}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void exitRatioPart(final FSHParser.RatioPartContext ctx) {

            }

            /**
             * Enter a parse tree produced by {@link FSHParser#bool}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void enterBool(final FSHParser.BoolContext ctx) {

            }

            /**
             * Exit a parse tree produced by {@link FSHParser#bool}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void exitBool(final FSHParser.BoolContext ctx) {

            }

            /**
             * Enter a parse tree produced by {@link FSHParser#targetType}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void enterTargetType(final FSHParser.TargetTypeContext ctx) {

            }

            /**
             * Exit a parse tree produced by {@link FSHParser#targetType}.
             *
             * @param ctx the parse tree
             */
            @Override
            public void exitTargetType(final FSHParser.TargetTypeContext ctx) {

            }


            @Override
            public void visitTerminal(final TerminalNode node) {

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

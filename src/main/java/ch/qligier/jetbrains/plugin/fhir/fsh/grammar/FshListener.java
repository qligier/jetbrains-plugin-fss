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
	 * Enter a parse tree produced by {@link FshParser#profile}.
	 * @param ctx the parse tree
	 */
	void enterProfile(FshParser.ProfileContext ctx);
	/**
	 * Exit a parse tree produced by {@link FshParser#profile}.
	 * @param ctx the parse tree
	 */
	void exitProfile(FshParser.ProfileContext ctx);
	/**
	 * Enter a parse tree produced by {@link FshParser#extension}.
	 * @param ctx the parse tree
	 */
	void enterExtension(FshParser.ExtensionContext ctx);
	/**
	 * Exit a parse tree produced by {@link FshParser#extension}.
	 * @param ctx the parse tree
	 */
	void exitExtension(FshParser.ExtensionContext ctx);
	/**
	 * Enter a parse tree produced by {@link FshParser#invariant}.
	 * @param ctx the parse tree
	 */
	void enterInvariant(FshParser.InvariantContext ctx);
	/**
	 * Exit a parse tree produced by {@link FshParser#invariant}.
	 * @param ctx the parse tree
	 */
	void exitInvariant(FshParser.InvariantContext ctx);
	/**
	 * Enter a parse tree produced by {@link FshParser#invariantMetadata}.
	 * @param ctx the parse tree
	 */
	void enterInvariantMetadata(FshParser.InvariantMetadataContext ctx);
	/**
	 * Exit a parse tree produced by {@link FshParser#invariantMetadata}.
	 * @param ctx the parse tree
	 */
	void exitInvariantMetadata(FshParser.InvariantMetadataContext ctx);
	/**
	 * Enter a parse tree produced by {@link FshParser#instance}.
	 * @param ctx the parse tree
	 */
	void enterInstance(FshParser.InstanceContext ctx);
	/**
	 * Exit a parse tree produced by {@link FshParser#instance}.
	 * @param ctx the parse tree
	 */
	void exitInstance(FshParser.InstanceContext ctx);
	/**
	 * Enter a parse tree produced by {@link FshParser#instanceMetadata}.
	 * @param ctx the parse tree
	 */
	void enterInstanceMetadata(FshParser.InstanceMetadataContext ctx);
	/**
	 * Exit a parse tree produced by {@link FshParser#instanceMetadata}.
	 * @param ctx the parse tree
	 */
	void exitInstanceMetadata(FshParser.InstanceMetadataContext ctx);
	/**
	 * Enter a parse tree produced by {@link FshParser#instanceRule}.
	 * @param ctx the parse tree
	 */
	void enterInstanceRule(FshParser.InstanceRuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link FshParser#instanceRule}.
	 * @param ctx the parse tree
	 */
	void exitInstanceRule(FshParser.InstanceRuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link FshParser#valueSet}.
	 * @param ctx the parse tree
	 */
	void enterValueSet(FshParser.ValueSetContext ctx);
	/**
	 * Exit a parse tree produced by {@link FshParser#valueSet}.
	 * @param ctx the parse tree
	 */
	void exitValueSet(FshParser.ValueSetContext ctx);
	/**
	 * Enter a parse tree produced by {@link FshParser#vsComponent}.
	 * @param ctx the parse tree
	 */
	void enterVsComponent(FshParser.VsComponentContext ctx);
	/**
	 * Exit a parse tree produced by {@link FshParser#vsComponent}.
	 * @param ctx the parse tree
	 */
	void exitVsComponent(FshParser.VsComponentContext ctx);
	/**
	 * Enter a parse tree produced by {@link FshParser#vsConceptComponent}.
	 * @param ctx the parse tree
	 */
	void enterVsConceptComponent(FshParser.VsConceptComponentContext ctx);
	/**
	 * Exit a parse tree produced by {@link FshParser#vsConceptComponent}.
	 * @param ctx the parse tree
	 */
	void exitVsConceptComponent(FshParser.VsConceptComponentContext ctx);
	/**
	 * Enter a parse tree produced by {@link FshParser#vsFilterComponent}.
	 * @param ctx the parse tree
	 */
	void enterVsFilterComponent(FshParser.VsFilterComponentContext ctx);
	/**
	 * Exit a parse tree produced by {@link FshParser#vsFilterComponent}.
	 * @param ctx the parse tree
	 */
	void exitVsFilterComponent(FshParser.VsFilterComponentContext ctx);
	/**
	 * Enter a parse tree produced by {@link FshParser#vsComponentFrom}.
	 * @param ctx the parse tree
	 */
	void enterVsComponentFrom(FshParser.VsComponentFromContext ctx);
	/**
	 * Exit a parse tree produced by {@link FshParser#vsComponentFrom}.
	 * @param ctx the parse tree
	 */
	void exitVsComponentFrom(FshParser.VsComponentFromContext ctx);
	/**
	 * Enter a parse tree produced by {@link FshParser#vsFromSystem}.
	 * @param ctx the parse tree
	 */
	void enterVsFromSystem(FshParser.VsFromSystemContext ctx);
	/**
	 * Exit a parse tree produced by {@link FshParser#vsFromSystem}.
	 * @param ctx the parse tree
	 */
	void exitVsFromSystem(FshParser.VsFromSystemContext ctx);
	/**
	 * Enter a parse tree produced by {@link FshParser#vsFromValueset}.
	 * @param ctx the parse tree
	 */
	void enterVsFromValueset(FshParser.VsFromValuesetContext ctx);
	/**
	 * Exit a parse tree produced by {@link FshParser#vsFromValueset}.
	 * @param ctx the parse tree
	 */
	void exitVsFromValueset(FshParser.VsFromValuesetContext ctx);
	/**
	 * Enter a parse tree produced by {@link FshParser#vsFilterList}.
	 * @param ctx the parse tree
	 */
	void enterVsFilterList(FshParser.VsFilterListContext ctx);
	/**
	 * Exit a parse tree produced by {@link FshParser#vsFilterList}.
	 * @param ctx the parse tree
	 */
	void exitVsFilterList(FshParser.VsFilterListContext ctx);
	/**
	 * Enter a parse tree produced by {@link FshParser#vsFilterDefinition}.
	 * @param ctx the parse tree
	 */
	void enterVsFilterDefinition(FshParser.VsFilterDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link FshParser#vsFilterDefinition}.
	 * @param ctx the parse tree
	 */
	void exitVsFilterDefinition(FshParser.VsFilterDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link FshParser#vsFilterOperator}.
	 * @param ctx the parse tree
	 */
	void enterVsFilterOperator(FshParser.VsFilterOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link FshParser#vsFilterOperator}.
	 * @param ctx the parse tree
	 */
	void exitVsFilterOperator(FshParser.VsFilterOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link FshParser#vsFilterValue}.
	 * @param ctx the parse tree
	 */
	void enterVsFilterValue(FshParser.VsFilterValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link FshParser#vsFilterValue}.
	 * @param ctx the parse tree
	 */
	void exitVsFilterValue(FshParser.VsFilterValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link FshParser#codeSystem}.
	 * @param ctx the parse tree
	 */
	void enterCodeSystem(FshParser.CodeSystemContext ctx);
	/**
	 * Exit a parse tree produced by {@link FshParser#codeSystem}.
	 * @param ctx the parse tree
	 */
	void exitCodeSystem(FshParser.CodeSystemContext ctx);
	/**
	 * Enter a parse tree produced by {@link FshParser#csMetadata}.
	 * @param ctx the parse tree
	 */
	void enterCsMetadata(FshParser.CsMetadataContext ctx);
	/**
	 * Exit a parse tree produced by {@link FshParser#csMetadata}.
	 * @param ctx the parse tree
	 */
	void exitCsMetadata(FshParser.CsMetadataContext ctx);
	/**
	 * Enter a parse tree produced by {@link FshParser#csRule}.
	 * @param ctx the parse tree
	 */
	void enterCsRule(FshParser.CsRuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link FshParser#csRule}.
	 * @param ctx the parse tree
	 */
	void exitCsRule(FshParser.CsRuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link FshParser#ruleSet}.
	 * @param ctx the parse tree
	 */
	void enterRuleSet(FshParser.RuleSetContext ctx);
	/**
	 * Exit a parse tree produced by {@link FshParser#ruleSet}.
	 * @param ctx the parse tree
	 */
	void exitRuleSet(FshParser.RuleSetContext ctx);
	/**
	 * Enter a parse tree produced by {@link FshParser#ruleSetRule}.
	 * @param ctx the parse tree
	 */
	void enterRuleSetRule(FshParser.RuleSetRuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link FshParser#ruleSetRule}.
	 * @param ctx the parse tree
	 */
	void exitRuleSetRule(FshParser.RuleSetRuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link FshParser#mapping}.
	 * @param ctx the parse tree
	 */
	void enterMapping(FshParser.MappingContext ctx);
	/**
	 * Exit a parse tree produced by {@link FshParser#mapping}.
	 * @param ctx the parse tree
	 */
	void exitMapping(FshParser.MappingContext ctx);
	/**
	 * Enter a parse tree produced by {@link FshParser#mappingMetadata}.
	 * @param ctx the parse tree
	 */
	void enterMappingMetadata(FshParser.MappingMetadataContext ctx);
	/**
	 * Exit a parse tree produced by {@link FshParser#mappingMetadata}.
	 * @param ctx the parse tree
	 */
	void exitMappingMetadata(FshParser.MappingMetadataContext ctx);
	/**
	 * Enter a parse tree produced by {@link FshParser#mappingEntityRule}.
	 * @param ctx the parse tree
	 */
	void enterMappingEntityRule(FshParser.MappingEntityRuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link FshParser#mappingEntityRule}.
	 * @param ctx the parse tree
	 */
	void exitMappingEntityRule(FshParser.MappingEntityRuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link FshParser#logical}.
	 * @param ctx the parse tree
	 */
	void enterLogical(FshParser.LogicalContext ctx);
	/**
	 * Exit a parse tree produced by {@link FshParser#logical}.
	 * @param ctx the parse tree
	 */
	void exitLogical(FshParser.LogicalContext ctx);
	/**
	 * Enter a parse tree produced by {@link FshParser#resource}.
	 * @param ctx the parse tree
	 */
	void enterResource(FshParser.ResourceContext ctx);
	/**
	 * Exit a parse tree produced by {@link FshParser#resource}.
	 * @param ctx the parse tree
	 */
	void exitResource(FshParser.ResourceContext ctx);
	/**
	 * Enter a parse tree produced by {@link FshParser#parent}.
	 * @param ctx the parse tree
	 */
	void enterParent(FshParser.ParentContext ctx);
	/**
	 * Exit a parse tree produced by {@link FshParser#parent}.
	 * @param ctx the parse tree
	 */
	void exitParent(FshParser.ParentContext ctx);
	/**
	 * Enter a parse tree produced by {@link FshParser#id}.
	 * @param ctx the parse tree
	 */
	void enterId(FshParser.IdContext ctx);
	/**
	 * Exit a parse tree produced by {@link FshParser#id}.
	 * @param ctx the parse tree
	 */
	void exitId(FshParser.IdContext ctx);
	/**
	 * Enter a parse tree produced by {@link FshParser#title}.
	 * @param ctx the parse tree
	 */
	void enterTitle(FshParser.TitleContext ctx);
	/**
	 * Exit a parse tree produced by {@link FshParser#title}.
	 * @param ctx the parse tree
	 */
	void exitTitle(FshParser.TitleContext ctx);
	/**
	 * Enter a parse tree produced by {@link FshParser#description}.
	 * @param ctx the parse tree
	 */
	void enterDescription(FshParser.DescriptionContext ctx);
	/**
	 * Exit a parse tree produced by {@link FshParser#description}.
	 * @param ctx the parse tree
	 */
	void exitDescription(FshParser.DescriptionContext ctx);
	/**
	 * Enter a parse tree produced by {@link FshParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(FshParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link FshParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(FshParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link FshParser#xpath}.
	 * @param ctx the parse tree
	 */
	void enterXpath(FshParser.XpathContext ctx);
	/**
	 * Exit a parse tree produced by {@link FshParser#xpath}.
	 * @param ctx the parse tree
	 */
	void exitXpath(FshParser.XpathContext ctx);
	/**
	 * Enter a parse tree produced by {@link FshParser#severity}.
	 * @param ctx the parse tree
	 */
	void enterSeverity(FshParser.SeverityContext ctx);
	/**
	 * Exit a parse tree produced by {@link FshParser#severity}.
	 * @param ctx the parse tree
	 */
	void exitSeverity(FshParser.SeverityContext ctx);
	/**
	 * Enter a parse tree produced by {@link FshParser#instanceOf}.
	 * @param ctx the parse tree
	 */
	void enterInstanceOf(FshParser.InstanceOfContext ctx);
	/**
	 * Exit a parse tree produced by {@link FshParser#instanceOf}.
	 * @param ctx the parse tree
	 */
	void exitInstanceOf(FshParser.InstanceOfContext ctx);
	/**
	 * Enter a parse tree produced by {@link FshParser#usage}.
	 * @param ctx the parse tree
	 */
	void enterUsage(FshParser.UsageContext ctx);
	/**
	 * Exit a parse tree produced by {@link FshParser#usage}.
	 * @param ctx the parse tree
	 */
	void exitUsage(FshParser.UsageContext ctx);
	/**
	 * Enter a parse tree produced by {@link FshParser#source}.
	 * @param ctx the parse tree
	 */
	void enterSource(FshParser.SourceContext ctx);
	/**
	 * Exit a parse tree produced by {@link FshParser#source}.
	 * @param ctx the parse tree
	 */
	void exitSource(FshParser.SourceContext ctx);
	/**
	 * Enter a parse tree produced by {@link FshParser#target}.
	 * @param ctx the parse tree
	 */
	void enterTarget(FshParser.TargetContext ctx);
	/**
	 * Exit a parse tree produced by {@link FshParser#target}.
	 * @param ctx the parse tree
	 */
	void exitTarget(FshParser.TargetContext ctx);
	/**
	 * Enter a parse tree produced by {@link FshParser#sdRule}.
	 * @param ctx the parse tree
	 */
	void enterSdRule(FshParser.SdRuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link FshParser#sdRule}.
	 * @param ctx the parse tree
	 */
	void exitSdRule(FshParser.SdRuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link FshParser#lrRule}.
	 * @param ctx the parse tree
	 */
	void enterLrRule(FshParser.LrRuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link FshParser#lrRule}.
	 * @param ctx the parse tree
	 */
	void exitLrRule(FshParser.LrRuleContext ctx);
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
	 * Enter a parse tree produced by {@link FshParser#cardRule}.
	 * @param ctx the parse tree
	 */
	void enterCardRule(FshParser.CardRuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link FshParser#cardRule}.
	 * @param ctx the parse tree
	 */
	void exitCardRule(FshParser.CardRuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link FshParser#flagRule}.
	 * @param ctx the parse tree
	 */
	void enterFlagRule(FshParser.FlagRuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link FshParser#flagRule}.
	 * @param ctx the parse tree
	 */
	void exitFlagRule(FshParser.FlagRuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link FshParser#valueSetRule}.
	 * @param ctx the parse tree
	 */
	void enterValueSetRule(FshParser.ValueSetRuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link FshParser#valueSetRule}.
	 * @param ctx the parse tree
	 */
	void exitValueSetRule(FshParser.ValueSetRuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link FshParser#fixedValueRule}.
	 * @param ctx the parse tree
	 */
	void enterFixedValueRule(FshParser.FixedValueRuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link FshParser#fixedValueRule}.
	 * @param ctx the parse tree
	 */
	void exitFixedValueRule(FshParser.FixedValueRuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link FshParser#containsRule}.
	 * @param ctx the parse tree
	 */
	void enterContainsRule(FshParser.ContainsRuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link FshParser#containsRule}.
	 * @param ctx the parse tree
	 */
	void exitContainsRule(FshParser.ContainsRuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link FshParser#onlyRule}.
	 * @param ctx the parse tree
	 */
	void enterOnlyRule(FshParser.OnlyRuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link FshParser#onlyRule}.
	 * @param ctx the parse tree
	 */
	void exitOnlyRule(FshParser.OnlyRuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link FshParser#obeysRule}.
	 * @param ctx the parse tree
	 */
	void enterObeysRule(FshParser.ObeysRuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link FshParser#obeysRule}.
	 * @param ctx the parse tree
	 */
	void exitObeysRule(FshParser.ObeysRuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link FshParser#caretValueRule}.
	 * @param ctx the parse tree
	 */
	void enterCaretValueRule(FshParser.CaretValueRuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link FshParser#caretValueRule}.
	 * @param ctx the parse tree
	 */
	void exitCaretValueRule(FshParser.CaretValueRuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link FshParser#codeCaretValueRule}.
	 * @param ctx the parse tree
	 */
	void enterCodeCaretValueRule(FshParser.CodeCaretValueRuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link FshParser#codeCaretValueRule}.
	 * @param ctx the parse tree
	 */
	void exitCodeCaretValueRule(FshParser.CodeCaretValueRuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link FshParser#mappingRule}.
	 * @param ctx the parse tree
	 */
	void enterMappingRule(FshParser.MappingRuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link FshParser#mappingRule}.
	 * @param ctx the parse tree
	 */
	void exitMappingRule(FshParser.MappingRuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link FshParser#insertRule}.
	 * @param ctx the parse tree
	 */
	void enterInsertRule(FshParser.InsertRuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link FshParser#insertRule}.
	 * @param ctx the parse tree
	 */
	void exitInsertRule(FshParser.InsertRuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link FshParser#codeInsertRule}.
	 * @param ctx the parse tree
	 */
	void enterCodeInsertRule(FshParser.CodeInsertRuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link FshParser#codeInsertRule}.
	 * @param ctx the parse tree
	 */
	void exitCodeInsertRule(FshParser.CodeInsertRuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link FshParser#addCRElementRule}.
	 * @param ctx the parse tree
	 */
	void enterAddCRElementRule(FshParser.AddCRElementRuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link FshParser#addCRElementRule}.
	 * @param ctx the parse tree
	 */
	void exitAddCRElementRule(FshParser.AddCRElementRuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link FshParser#addElementRule}.
	 * @param ctx the parse tree
	 */
	void enterAddElementRule(FshParser.AddElementRuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link FshParser#addElementRule}.
	 * @param ctx the parse tree
	 */
	void exitAddElementRule(FshParser.AddElementRuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link FshParser#pathRule}.
	 * @param ctx the parse tree
	 */
	void enterPathRule(FshParser.PathRuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link FshParser#pathRule}.
	 * @param ctx the parse tree
	 */
	void exitPathRule(FshParser.PathRuleContext ctx);
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
	 * Enter a parse tree produced by {@link FshParser#flag}.
	 * @param ctx the parse tree
	 */
	void enterFlag(FshParser.FlagContext ctx);
	/**
	 * Exit a parse tree produced by {@link FshParser#flag}.
	 * @param ctx the parse tree
	 */
	void exitFlag(FshParser.FlagContext ctx);
	/**
	 * Enter a parse tree produced by {@link FshParser#strength}.
	 * @param ctx the parse tree
	 */
	void enterStrength(FshParser.StrengthContext ctx);
	/**
	 * Exit a parse tree produced by {@link FshParser#strength}.
	 * @param ctx the parse tree
	 */
	void exitStrength(FshParser.StrengthContext ctx);
	/**
	 * Enter a parse tree produced by {@link FshParser#ratio}.
	 * @param ctx the parse tree
	 */
	void enterRatio(FshParser.RatioContext ctx);
	/**
	 * Exit a parse tree produced by {@link FshParser#ratio}.
	 * @param ctx the parse tree
	 */
	void exitRatio(FshParser.RatioContext ctx);
	/**
	 * Enter a parse tree produced by {@link FshParser#quantity}.
	 * @param ctx the parse tree
	 */
	void enterQuantity(FshParser.QuantityContext ctx);
	/**
	 * Exit a parse tree produced by {@link FshParser#quantity}.
	 * @param ctx the parse tree
	 */
	void exitQuantity(FshParser.QuantityContext ctx);
	/**
	 * Enter a parse tree produced by {@link FshParser#reference}.
	 * @param ctx the parse tree
	 */
	void enterReference(FshParser.ReferenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link FshParser#reference}.
	 * @param ctx the parse tree
	 */
	void exitReference(FshParser.ReferenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link FshParser#itemIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterItemIdentifier(FshParser.ItemIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link FshParser#itemIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitItemIdentifier(FshParser.ItemIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link FshParser#canonical}.
	 * @param ctx the parse tree
	 */
	void enterCanonical(FshParser.CanonicalContext ctx);
	/**
	 * Exit a parse tree produced by {@link FshParser#canonical}.
	 * @param ctx the parse tree
	 */
	void exitCanonical(FshParser.CanonicalContext ctx);
	/**
	 * Enter a parse tree produced by {@link FshParser#targetType}.
	 * @param ctx the parse tree
	 */
	void enterTargetType(FshParser.TargetTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link FshParser#targetType}.
	 * @param ctx the parse tree
	 */
	void exitTargetType(FshParser.TargetTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link FshParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(FshParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link FshParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(FshParser.ValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link FshParser#item}.
	 * @param ctx the parse tree
	 */
	void enterItem(FshParser.ItemContext ctx);
	/**
	 * Exit a parse tree produced by {@link FshParser#item}.
	 * @param ctx the parse tree
	 */
	void exitItem(FshParser.ItemContext ctx);
	/**
	 * Enter a parse tree produced by {@link FshParser#bool}.
	 * @param ctx the parse tree
	 */
	void enterBool(FshParser.BoolContext ctx);
	/**
	 * Exit a parse tree produced by {@link FshParser#bool}.
	 * @param ctx the parse tree
	 */
	void exitBool(FshParser.BoolContext ctx);
	/**
	 * Enter a parse tree produced by {@link FshParser#concept}.
	 * @param ctx the parse tree
	 */
	void enterConcept(FshParser.ConceptContext ctx);
	/**
	 * Exit a parse tree produced by {@link FshParser#concept}.
	 * @param ctx the parse tree
	 */
	void exitConcept(FshParser.ConceptContext ctx);
	/**
	 * Enter a parse tree produced by {@link FshParser#ruleSetReference}.
	 * @param ctx the parse tree
	 */
	void enterRuleSetReference(FshParser.RuleSetReferenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link FshParser#ruleSetReference}.
	 * @param ctx the parse tree
	 */
	void exitRuleSetReference(FshParser.RuleSetReferenceContext ctx);
}
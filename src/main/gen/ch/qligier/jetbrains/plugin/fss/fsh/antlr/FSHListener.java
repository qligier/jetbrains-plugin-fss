// Generated from ch/qligier/jetbrains/plugin/fss/fsh/antlr/FSH.g4 by ANTLR 4.13.1
package ch.qligier.jetbrains.plugin.fss.fsh.antlr;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link FSHParser}.
 */
public interface FSHListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link FSHParser#doc}.
	 * @param ctx the parse tree
	 */
	void enterDoc(FSHParser.DocContext ctx);
	/**
	 * Exit a parse tree produced by {@link FSHParser#doc}.
	 * @param ctx the parse tree
	 */
	void exitDoc(FSHParser.DocContext ctx);
	/**
	 * Enter a parse tree produced by {@link FSHParser#entity}.
	 * @param ctx the parse tree
	 */
	void enterEntity(FSHParser.EntityContext ctx);
	/**
	 * Exit a parse tree produced by {@link FSHParser#entity}.
	 * @param ctx the parse tree
	 */
	void exitEntity(FSHParser.EntityContext ctx);
	/**
	 * Enter a parse tree produced by {@link FSHParser#alias}.
	 * @param ctx the parse tree
	 */
	void enterAlias(FSHParser.AliasContext ctx);
	/**
	 * Exit a parse tree produced by {@link FSHParser#alias}.
	 * @param ctx the parse tree
	 */
	void exitAlias(FSHParser.AliasContext ctx);
	/**
	 * Enter a parse tree produced by {@link FSHParser#profile}.
	 * @param ctx the parse tree
	 */
	void enterProfile(FSHParser.ProfileContext ctx);
	/**
	 * Exit a parse tree produced by {@link FSHParser#profile}.
	 * @param ctx the parse tree
	 */
	void exitProfile(FSHParser.ProfileContext ctx);
	/**
	 * Enter a parse tree produced by {@link FSHParser#extension}.
	 * @param ctx the parse tree
	 */
	void enterExtension(FSHParser.ExtensionContext ctx);
	/**
	 * Exit a parse tree produced by {@link FSHParser#extension}.
	 * @param ctx the parse tree
	 */
	void exitExtension(FSHParser.ExtensionContext ctx);
	/**
	 * Enter a parse tree produced by {@link FSHParser#logical}.
	 * @param ctx the parse tree
	 */
	void enterLogical(FSHParser.LogicalContext ctx);
	/**
	 * Exit a parse tree produced by {@link FSHParser#logical}.
	 * @param ctx the parse tree
	 */
	void exitLogical(FSHParser.LogicalContext ctx);
	/**
	 * Enter a parse tree produced by {@link FSHParser#resource}.
	 * @param ctx the parse tree
	 */
	void enterResource(FSHParser.ResourceContext ctx);
	/**
	 * Exit a parse tree produced by {@link FSHParser#resource}.
	 * @param ctx the parse tree
	 */
	void exitResource(FSHParser.ResourceContext ctx);
	/**
	 * Enter a parse tree produced by {@link FSHParser#sdMetadata}.
	 * @param ctx the parse tree
	 */
	void enterSdMetadata(FSHParser.SdMetadataContext ctx);
	/**
	 * Exit a parse tree produced by {@link FSHParser#sdMetadata}.
	 * @param ctx the parse tree
	 */
	void exitSdMetadata(FSHParser.SdMetadataContext ctx);
	/**
	 * Enter a parse tree produced by {@link FSHParser#sdRule}.
	 * @param ctx the parse tree
	 */
	void enterSdRule(FSHParser.SdRuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link FSHParser#sdRule}.
	 * @param ctx the parse tree
	 */
	void exitSdRule(FSHParser.SdRuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link FSHParser#lrRule}.
	 * @param ctx the parse tree
	 */
	void enterLrRule(FSHParser.LrRuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link FSHParser#lrRule}.
	 * @param ctx the parse tree
	 */
	void exitLrRule(FSHParser.LrRuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link FSHParser#instance}.
	 * @param ctx the parse tree
	 */
	void enterInstance(FSHParser.InstanceContext ctx);
	/**
	 * Exit a parse tree produced by {@link FSHParser#instance}.
	 * @param ctx the parse tree
	 */
	void exitInstance(FSHParser.InstanceContext ctx);
	/**
	 * Enter a parse tree produced by {@link FSHParser#instanceMetadata}.
	 * @param ctx the parse tree
	 */
	void enterInstanceMetadata(FSHParser.InstanceMetadataContext ctx);
	/**
	 * Exit a parse tree produced by {@link FSHParser#instanceMetadata}.
	 * @param ctx the parse tree
	 */
	void exitInstanceMetadata(FSHParser.InstanceMetadataContext ctx);
	/**
	 * Enter a parse tree produced by {@link FSHParser#instanceRule}.
	 * @param ctx the parse tree
	 */
	void enterInstanceRule(FSHParser.InstanceRuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link FSHParser#instanceRule}.
	 * @param ctx the parse tree
	 */
	void exitInstanceRule(FSHParser.InstanceRuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link FSHParser#invariant}.
	 * @param ctx the parse tree
	 */
	void enterInvariant(FSHParser.InvariantContext ctx);
	/**
	 * Exit a parse tree produced by {@link FSHParser#invariant}.
	 * @param ctx the parse tree
	 */
	void exitInvariant(FSHParser.InvariantContext ctx);
	/**
	 * Enter a parse tree produced by {@link FSHParser#invariantMetadata}.
	 * @param ctx the parse tree
	 */
	void enterInvariantMetadata(FSHParser.InvariantMetadataContext ctx);
	/**
	 * Exit a parse tree produced by {@link FSHParser#invariantMetadata}.
	 * @param ctx the parse tree
	 */
	void exitInvariantMetadata(FSHParser.InvariantMetadataContext ctx);
	/**
	 * Enter a parse tree produced by {@link FSHParser#invariantRule}.
	 * @param ctx the parse tree
	 */
	void enterInvariantRule(FSHParser.InvariantRuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link FSHParser#invariantRule}.
	 * @param ctx the parse tree
	 */
	void exitInvariantRule(FSHParser.InvariantRuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link FSHParser#valueSet}.
	 * @param ctx the parse tree
	 */
	void enterValueSet(FSHParser.ValueSetContext ctx);
	/**
	 * Exit a parse tree produced by {@link FSHParser#valueSet}.
	 * @param ctx the parse tree
	 */
	void exitValueSet(FSHParser.ValueSetContext ctx);
	/**
	 * Enter a parse tree produced by {@link FSHParser#vsMetadata}.
	 * @param ctx the parse tree
	 */
	void enterVsMetadata(FSHParser.VsMetadataContext ctx);
	/**
	 * Exit a parse tree produced by {@link FSHParser#vsMetadata}.
	 * @param ctx the parse tree
	 */
	void exitVsMetadata(FSHParser.VsMetadataContext ctx);
	/**
	 * Enter a parse tree produced by {@link FSHParser#vsRule}.
	 * @param ctx the parse tree
	 */
	void enterVsRule(FSHParser.VsRuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link FSHParser#vsRule}.
	 * @param ctx the parse tree
	 */
	void exitVsRule(FSHParser.VsRuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link FSHParser#codeSystem}.
	 * @param ctx the parse tree
	 */
	void enterCodeSystem(FSHParser.CodeSystemContext ctx);
	/**
	 * Exit a parse tree produced by {@link FSHParser#codeSystem}.
	 * @param ctx the parse tree
	 */
	void exitCodeSystem(FSHParser.CodeSystemContext ctx);
	/**
	 * Enter a parse tree produced by {@link FSHParser#csMetadata}.
	 * @param ctx the parse tree
	 */
	void enterCsMetadata(FSHParser.CsMetadataContext ctx);
	/**
	 * Exit a parse tree produced by {@link FSHParser#csMetadata}.
	 * @param ctx the parse tree
	 */
	void exitCsMetadata(FSHParser.CsMetadataContext ctx);
	/**
	 * Enter a parse tree produced by {@link FSHParser#csRule}.
	 * @param ctx the parse tree
	 */
	void enterCsRule(FSHParser.CsRuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link FSHParser#csRule}.
	 * @param ctx the parse tree
	 */
	void exitCsRule(FSHParser.CsRuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link FSHParser#ruleSet}.
	 * @param ctx the parse tree
	 */
	void enterRuleSet(FSHParser.RuleSetContext ctx);
	/**
	 * Exit a parse tree produced by {@link FSHParser#ruleSet}.
	 * @param ctx the parse tree
	 */
	void exitRuleSet(FSHParser.RuleSetContext ctx);
	/**
	 * Enter a parse tree produced by {@link FSHParser#ruleSetRule}.
	 * @param ctx the parse tree
	 */
	void enterRuleSetRule(FSHParser.RuleSetRuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link FSHParser#ruleSetRule}.
	 * @param ctx the parse tree
	 */
	void exitRuleSetRule(FSHParser.RuleSetRuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link FSHParser#paramRuleSet}.
	 * @param ctx the parse tree
	 */
	void enterParamRuleSet(FSHParser.ParamRuleSetContext ctx);
	/**
	 * Exit a parse tree produced by {@link FSHParser#paramRuleSet}.
	 * @param ctx the parse tree
	 */
	void exitParamRuleSet(FSHParser.ParamRuleSetContext ctx);
	/**
	 * Enter a parse tree produced by {@link FSHParser#paramRuleSetRef}.
	 * @param ctx the parse tree
	 */
	void enterParamRuleSetRef(FSHParser.ParamRuleSetRefContext ctx);
	/**
	 * Exit a parse tree produced by {@link FSHParser#paramRuleSetRef}.
	 * @param ctx the parse tree
	 */
	void exitParamRuleSetRef(FSHParser.ParamRuleSetRefContext ctx);
	/**
	 * Enter a parse tree produced by {@link FSHParser#parameter}.
	 * @param ctx the parse tree
	 */
	void enterParameter(FSHParser.ParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link FSHParser#parameter}.
	 * @param ctx the parse tree
	 */
	void exitParameter(FSHParser.ParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link FSHParser#lastParameter}.
	 * @param ctx the parse tree
	 */
	void enterLastParameter(FSHParser.LastParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link FSHParser#lastParameter}.
	 * @param ctx the parse tree
	 */
	void exitLastParameter(FSHParser.LastParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link FSHParser#paramRuleSetContent}.
	 * @param ctx the parse tree
	 */
	void enterParamRuleSetContent(FSHParser.ParamRuleSetContentContext ctx);
	/**
	 * Exit a parse tree produced by {@link FSHParser#paramRuleSetContent}.
	 * @param ctx the parse tree
	 */
	void exitParamRuleSetContent(FSHParser.ParamRuleSetContentContext ctx);
	/**
	 * Enter a parse tree produced by {@link FSHParser#mapping}.
	 * @param ctx the parse tree
	 */
	void enterMapping(FSHParser.MappingContext ctx);
	/**
	 * Exit a parse tree produced by {@link FSHParser#mapping}.
	 * @param ctx the parse tree
	 */
	void exitMapping(FSHParser.MappingContext ctx);
	/**
	 * Enter a parse tree produced by {@link FSHParser#mappingMetadata}.
	 * @param ctx the parse tree
	 */
	void enterMappingMetadata(FSHParser.MappingMetadataContext ctx);
	/**
	 * Exit a parse tree produced by {@link FSHParser#mappingMetadata}.
	 * @param ctx the parse tree
	 */
	void exitMappingMetadata(FSHParser.MappingMetadataContext ctx);
	/**
	 * Enter a parse tree produced by {@link FSHParser#mappingEntityRule}.
	 * @param ctx the parse tree
	 */
	void enterMappingEntityRule(FSHParser.MappingEntityRuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link FSHParser#mappingEntityRule}.
	 * @param ctx the parse tree
	 */
	void exitMappingEntityRule(FSHParser.MappingEntityRuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link FSHParser#parent}.
	 * @param ctx the parse tree
	 */
	void enterParent(FSHParser.ParentContext ctx);
	/**
	 * Exit a parse tree produced by {@link FSHParser#parent}.
	 * @param ctx the parse tree
	 */
	void exitParent(FSHParser.ParentContext ctx);
	/**
	 * Enter a parse tree produced by {@link FSHParser#id}.
	 * @param ctx the parse tree
	 */
	void enterId(FSHParser.IdContext ctx);
	/**
	 * Exit a parse tree produced by {@link FSHParser#id}.
	 * @param ctx the parse tree
	 */
	void exitId(FSHParser.IdContext ctx);
	/**
	 * Enter a parse tree produced by {@link FSHParser#title}.
	 * @param ctx the parse tree
	 */
	void enterTitle(FSHParser.TitleContext ctx);
	/**
	 * Exit a parse tree produced by {@link FSHParser#title}.
	 * @param ctx the parse tree
	 */
	void exitTitle(FSHParser.TitleContext ctx);
	/**
	 * Enter a parse tree produced by {@link FSHParser#description}.
	 * @param ctx the parse tree
	 */
	void enterDescription(FSHParser.DescriptionContext ctx);
	/**
	 * Exit a parse tree produced by {@link FSHParser#description}.
	 * @param ctx the parse tree
	 */
	void exitDescription(FSHParser.DescriptionContext ctx);
	/**
	 * Enter a parse tree produced by {@link FSHParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(FSHParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link FSHParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(FSHParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link FSHParser#xpath}.
	 * @param ctx the parse tree
	 */
	void enterXpath(FSHParser.XpathContext ctx);
	/**
	 * Exit a parse tree produced by {@link FSHParser#xpath}.
	 * @param ctx the parse tree
	 */
	void exitXpath(FSHParser.XpathContext ctx);
	/**
	 * Enter a parse tree produced by {@link FSHParser#severity}.
	 * @param ctx the parse tree
	 */
	void enterSeverity(FSHParser.SeverityContext ctx);
	/**
	 * Exit a parse tree produced by {@link FSHParser#severity}.
	 * @param ctx the parse tree
	 */
	void exitSeverity(FSHParser.SeverityContext ctx);
	/**
	 * Enter a parse tree produced by {@link FSHParser#instanceOf}.
	 * @param ctx the parse tree
	 */
	void enterInstanceOf(FSHParser.InstanceOfContext ctx);
	/**
	 * Exit a parse tree produced by {@link FSHParser#instanceOf}.
	 * @param ctx the parse tree
	 */
	void exitInstanceOf(FSHParser.InstanceOfContext ctx);
	/**
	 * Enter a parse tree produced by {@link FSHParser#usage}.
	 * @param ctx the parse tree
	 */
	void enterUsage(FSHParser.UsageContext ctx);
	/**
	 * Exit a parse tree produced by {@link FSHParser#usage}.
	 * @param ctx the parse tree
	 */
	void exitUsage(FSHParser.UsageContext ctx);
	/**
	 * Enter a parse tree produced by {@link FSHParser#source}.
	 * @param ctx the parse tree
	 */
	void enterSource(FSHParser.SourceContext ctx);
	/**
	 * Exit a parse tree produced by {@link FSHParser#source}.
	 * @param ctx the parse tree
	 */
	void exitSource(FSHParser.SourceContext ctx);
	/**
	 * Enter a parse tree produced by {@link FSHParser#target}.
	 * @param ctx the parse tree
	 */
	void enterTarget(FSHParser.TargetContext ctx);
	/**
	 * Exit a parse tree produced by {@link FSHParser#target}.
	 * @param ctx the parse tree
	 */
	void exitTarget(FSHParser.TargetContext ctx);
	/**
	 * Enter a parse tree produced by {@link FSHParser#context}.
	 * @param ctx the parse tree
	 */
	void enterContext(FSHParser.ContextContext ctx);
	/**
	 * Exit a parse tree produced by {@link FSHParser#context}.
	 * @param ctx the parse tree
	 */
	void exitContext(FSHParser.ContextContext ctx);
	/**
	 * Enter a parse tree produced by {@link FSHParser#contextItem}.
	 * @param ctx the parse tree
	 */
	void enterContextItem(FSHParser.ContextItemContext ctx);
	/**
	 * Exit a parse tree produced by {@link FSHParser#contextItem}.
	 * @param ctx the parse tree
	 */
	void exitContextItem(FSHParser.ContextItemContext ctx);
	/**
	 * Enter a parse tree produced by {@link FSHParser#lastContextItem}.
	 * @param ctx the parse tree
	 */
	void enterLastContextItem(FSHParser.LastContextItemContext ctx);
	/**
	 * Exit a parse tree produced by {@link FSHParser#lastContextItem}.
	 * @param ctx the parse tree
	 */
	void exitLastContextItem(FSHParser.LastContextItemContext ctx);
	/**
	 * Enter a parse tree produced by {@link FSHParser#characteristics}.
	 * @param ctx the parse tree
	 */
	void enterCharacteristics(FSHParser.CharacteristicsContext ctx);
	/**
	 * Exit a parse tree produced by {@link FSHParser#characteristics}.
	 * @param ctx the parse tree
	 */
	void exitCharacteristics(FSHParser.CharacteristicsContext ctx);
	/**
	 * Enter a parse tree produced by {@link FSHParser#cardRule}.
	 * @param ctx the parse tree
	 */
	void enterCardRule(FSHParser.CardRuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link FSHParser#cardRule}.
	 * @param ctx the parse tree
	 */
	void exitCardRule(FSHParser.CardRuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link FSHParser#flagRule}.
	 * @param ctx the parse tree
	 */
	void enterFlagRule(FSHParser.FlagRuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link FSHParser#flagRule}.
	 * @param ctx the parse tree
	 */
	void exitFlagRule(FSHParser.FlagRuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link FSHParser#valueSetRule}.
	 * @param ctx the parse tree
	 */
	void enterValueSetRule(FSHParser.ValueSetRuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link FSHParser#valueSetRule}.
	 * @param ctx the parse tree
	 */
	void exitValueSetRule(FSHParser.ValueSetRuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link FSHParser#fixedValueRule}.
	 * @param ctx the parse tree
	 */
	void enterFixedValueRule(FSHParser.FixedValueRuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link FSHParser#fixedValueRule}.
	 * @param ctx the parse tree
	 */
	void exitFixedValueRule(FSHParser.FixedValueRuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link FSHParser#containsRule}.
	 * @param ctx the parse tree
	 */
	void enterContainsRule(FSHParser.ContainsRuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link FSHParser#containsRule}.
	 * @param ctx the parse tree
	 */
	void exitContainsRule(FSHParser.ContainsRuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link FSHParser#onlyRule}.
	 * @param ctx the parse tree
	 */
	void enterOnlyRule(FSHParser.OnlyRuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link FSHParser#onlyRule}.
	 * @param ctx the parse tree
	 */
	void exitOnlyRule(FSHParser.OnlyRuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link FSHParser#obeysRule}.
	 * @param ctx the parse tree
	 */
	void enterObeysRule(FSHParser.ObeysRuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link FSHParser#obeysRule}.
	 * @param ctx the parse tree
	 */
	void exitObeysRule(FSHParser.ObeysRuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link FSHParser#caretValueRule}.
	 * @param ctx the parse tree
	 */
	void enterCaretValueRule(FSHParser.CaretValueRuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link FSHParser#caretValueRule}.
	 * @param ctx the parse tree
	 */
	void exitCaretValueRule(FSHParser.CaretValueRuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link FSHParser#codeCaretValueRule}.
	 * @param ctx the parse tree
	 */
	void enterCodeCaretValueRule(FSHParser.CodeCaretValueRuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link FSHParser#codeCaretValueRule}.
	 * @param ctx the parse tree
	 */
	void exitCodeCaretValueRule(FSHParser.CodeCaretValueRuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link FSHParser#mappingRule}.
	 * @param ctx the parse tree
	 */
	void enterMappingRule(FSHParser.MappingRuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link FSHParser#mappingRule}.
	 * @param ctx the parse tree
	 */
	void exitMappingRule(FSHParser.MappingRuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link FSHParser#insertRule}.
	 * @param ctx the parse tree
	 */
	void enterInsertRule(FSHParser.InsertRuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link FSHParser#insertRule}.
	 * @param ctx the parse tree
	 */
	void exitInsertRule(FSHParser.InsertRuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link FSHParser#codeInsertRule}.
	 * @param ctx the parse tree
	 */
	void enterCodeInsertRule(FSHParser.CodeInsertRuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link FSHParser#codeInsertRule}.
	 * @param ctx the parse tree
	 */
	void exitCodeInsertRule(FSHParser.CodeInsertRuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link FSHParser#addCRElementRule}.
	 * @param ctx the parse tree
	 */
	void enterAddCRElementRule(FSHParser.AddCRElementRuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link FSHParser#addCRElementRule}.
	 * @param ctx the parse tree
	 */
	void exitAddCRElementRule(FSHParser.AddCRElementRuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link FSHParser#addElementRule}.
	 * @param ctx the parse tree
	 */
	void enterAddElementRule(FSHParser.AddElementRuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link FSHParser#addElementRule}.
	 * @param ctx the parse tree
	 */
	void exitAddElementRule(FSHParser.AddElementRuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link FSHParser#pathRule}.
	 * @param ctx the parse tree
	 */
	void enterPathRule(FSHParser.PathRuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link FSHParser#pathRule}.
	 * @param ctx the parse tree
	 */
	void exitPathRule(FSHParser.PathRuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link FSHParser#vsComponent}.
	 * @param ctx the parse tree
	 */
	void enterVsComponent(FSHParser.VsComponentContext ctx);
	/**
	 * Exit a parse tree produced by {@link FSHParser#vsComponent}.
	 * @param ctx the parse tree
	 */
	void exitVsComponent(FSHParser.VsComponentContext ctx);
	/**
	 * Enter a parse tree produced by {@link FSHParser#vsConceptComponent}.
	 * @param ctx the parse tree
	 */
	void enterVsConceptComponent(FSHParser.VsConceptComponentContext ctx);
	/**
	 * Exit a parse tree produced by {@link FSHParser#vsConceptComponent}.
	 * @param ctx the parse tree
	 */
	void exitVsConceptComponent(FSHParser.VsConceptComponentContext ctx);
	/**
	 * Enter a parse tree produced by {@link FSHParser#vsFilterComponent}.
	 * @param ctx the parse tree
	 */
	void enterVsFilterComponent(FSHParser.VsFilterComponentContext ctx);
	/**
	 * Exit a parse tree produced by {@link FSHParser#vsFilterComponent}.
	 * @param ctx the parse tree
	 */
	void exitVsFilterComponent(FSHParser.VsFilterComponentContext ctx);
	/**
	 * Enter a parse tree produced by {@link FSHParser#vsComponentFrom}.
	 * @param ctx the parse tree
	 */
	void enterVsComponentFrom(FSHParser.VsComponentFromContext ctx);
	/**
	 * Exit a parse tree produced by {@link FSHParser#vsComponentFrom}.
	 * @param ctx the parse tree
	 */
	void exitVsComponentFrom(FSHParser.VsComponentFromContext ctx);
	/**
	 * Enter a parse tree produced by {@link FSHParser#vsFromSystem}.
	 * @param ctx the parse tree
	 */
	void enterVsFromSystem(FSHParser.VsFromSystemContext ctx);
	/**
	 * Exit a parse tree produced by {@link FSHParser#vsFromSystem}.
	 * @param ctx the parse tree
	 */
	void exitVsFromSystem(FSHParser.VsFromSystemContext ctx);
	/**
	 * Enter a parse tree produced by {@link FSHParser#vsFromValueset}.
	 * @param ctx the parse tree
	 */
	void enterVsFromValueset(FSHParser.VsFromValuesetContext ctx);
	/**
	 * Exit a parse tree produced by {@link FSHParser#vsFromValueset}.
	 * @param ctx the parse tree
	 */
	void exitVsFromValueset(FSHParser.VsFromValuesetContext ctx);
	/**
	 * Enter a parse tree produced by {@link FSHParser#vsFilterList}.
	 * @param ctx the parse tree
	 */
	void enterVsFilterList(FSHParser.VsFilterListContext ctx);
	/**
	 * Exit a parse tree produced by {@link FSHParser#vsFilterList}.
	 * @param ctx the parse tree
	 */
	void exitVsFilterList(FSHParser.VsFilterListContext ctx);
	/**
	 * Enter a parse tree produced by {@link FSHParser#vsFilterDefinition}.
	 * @param ctx the parse tree
	 */
	void enterVsFilterDefinition(FSHParser.VsFilterDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link FSHParser#vsFilterDefinition}.
	 * @param ctx the parse tree
	 */
	void exitVsFilterDefinition(FSHParser.VsFilterDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link FSHParser#vsFilterOperator}.
	 * @param ctx the parse tree
	 */
	void enterVsFilterOperator(FSHParser.VsFilterOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link FSHParser#vsFilterOperator}.
	 * @param ctx the parse tree
	 */
	void exitVsFilterOperator(FSHParser.VsFilterOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link FSHParser#vsFilterValue}.
	 * @param ctx the parse tree
	 */
	void enterVsFilterValue(FSHParser.VsFilterValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link FSHParser#vsFilterValue}.
	 * @param ctx the parse tree
	 */
	void exitVsFilterValue(FSHParser.VsFilterValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link FSHParser#name}.
	 * @param ctx the parse tree
	 */
	void enterName(FSHParser.NameContext ctx);
	/**
	 * Exit a parse tree produced by {@link FSHParser#name}.
	 * @param ctx the parse tree
	 */
	void exitName(FSHParser.NameContext ctx);
	/**
	 * Enter a parse tree produced by {@link FSHParser#path}.
	 * @param ctx the parse tree
	 */
	void enterPath(FSHParser.PathContext ctx);
	/**
	 * Exit a parse tree produced by {@link FSHParser#path}.
	 * @param ctx the parse tree
	 */
	void exitPath(FSHParser.PathContext ctx);
	/**
	 * Enter a parse tree produced by {@link FSHParser#caretPath}.
	 * @param ctx the parse tree
	 */
	void enterCaretPath(FSHParser.CaretPathContext ctx);
	/**
	 * Exit a parse tree produced by {@link FSHParser#caretPath}.
	 * @param ctx the parse tree
	 */
	void exitCaretPath(FSHParser.CaretPathContext ctx);
	/**
	 * Enter a parse tree produced by {@link FSHParser#flag}.
	 * @param ctx the parse tree
	 */
	void enterFlag(FSHParser.FlagContext ctx);
	/**
	 * Exit a parse tree produced by {@link FSHParser#flag}.
	 * @param ctx the parse tree
	 */
	void exitFlag(FSHParser.FlagContext ctx);
	/**
	 * Enter a parse tree produced by {@link FSHParser#strength}.
	 * @param ctx the parse tree
	 */
	void enterStrength(FSHParser.StrengthContext ctx);
	/**
	 * Exit a parse tree produced by {@link FSHParser#strength}.
	 * @param ctx the parse tree
	 */
	void exitStrength(FSHParser.StrengthContext ctx);
	/**
	 * Enter a parse tree produced by {@link FSHParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(FSHParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link FSHParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(FSHParser.ValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link FSHParser#item}.
	 * @param ctx the parse tree
	 */
	void enterItem(FSHParser.ItemContext ctx);
	/**
	 * Exit a parse tree produced by {@link FSHParser#item}.
	 * @param ctx the parse tree
	 */
	void exitItem(FSHParser.ItemContext ctx);
	/**
	 * Enter a parse tree produced by {@link FSHParser#code}.
	 * @param ctx the parse tree
	 */
	void enterCode(FSHParser.CodeContext ctx);
	/**
	 * Exit a parse tree produced by {@link FSHParser#code}.
	 * @param ctx the parse tree
	 */
	void exitCode(FSHParser.CodeContext ctx);
	/**
	 * Enter a parse tree produced by {@link FSHParser#concept}.
	 * @param ctx the parse tree
	 */
	void enterConcept(FSHParser.ConceptContext ctx);
	/**
	 * Exit a parse tree produced by {@link FSHParser#concept}.
	 * @param ctx the parse tree
	 */
	void exitConcept(FSHParser.ConceptContext ctx);
	/**
	 * Enter a parse tree produced by {@link FSHParser#quantity}.
	 * @param ctx the parse tree
	 */
	void enterQuantity(FSHParser.QuantityContext ctx);
	/**
	 * Exit a parse tree produced by {@link FSHParser#quantity}.
	 * @param ctx the parse tree
	 */
	void exitQuantity(FSHParser.QuantityContext ctx);
	/**
	 * Enter a parse tree produced by {@link FSHParser#ratio}.
	 * @param ctx the parse tree
	 */
	void enterRatio(FSHParser.RatioContext ctx);
	/**
	 * Exit a parse tree produced by {@link FSHParser#ratio}.
	 * @param ctx the parse tree
	 */
	void exitRatio(FSHParser.RatioContext ctx);
	/**
	 * Enter a parse tree produced by {@link FSHParser#reference}.
	 * @param ctx the parse tree
	 */
	void enterReference(FSHParser.ReferenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link FSHParser#reference}.
	 * @param ctx the parse tree
	 */
	void exitReference(FSHParser.ReferenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link FSHParser#referenceType}.
	 * @param ctx the parse tree
	 */
	void enterReferenceType(FSHParser.ReferenceTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link FSHParser#referenceType}.
	 * @param ctx the parse tree
	 */
	void exitReferenceType(FSHParser.ReferenceTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link FSHParser#codeableReferenceType}.
	 * @param ctx the parse tree
	 */
	void enterCodeableReferenceType(FSHParser.CodeableReferenceTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link FSHParser#codeableReferenceType}.
	 * @param ctx the parse tree
	 */
	void exitCodeableReferenceType(FSHParser.CodeableReferenceTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link FSHParser#canonical}.
	 * @param ctx the parse tree
	 */
	void enterCanonical(FSHParser.CanonicalContext ctx);
	/**
	 * Exit a parse tree produced by {@link FSHParser#canonical}.
	 * @param ctx the parse tree
	 */
	void exitCanonical(FSHParser.CanonicalContext ctx);
	/**
	 * Enter a parse tree produced by {@link FSHParser#ratioPart}.
	 * @param ctx the parse tree
	 */
	void enterRatioPart(FSHParser.RatioPartContext ctx);
	/**
	 * Exit a parse tree produced by {@link FSHParser#ratioPart}.
	 * @param ctx the parse tree
	 */
	void exitRatioPart(FSHParser.RatioPartContext ctx);
	/**
	 * Enter a parse tree produced by {@link FSHParser#bool}.
	 * @param ctx the parse tree
	 */
	void enterBool(FSHParser.BoolContext ctx);
	/**
	 * Exit a parse tree produced by {@link FSHParser#bool}.
	 * @param ctx the parse tree
	 */
	void exitBool(FSHParser.BoolContext ctx);
	/**
	 * Enter a parse tree produced by {@link FSHParser#targetType}.
	 * @param ctx the parse tree
	 */
	void enterTargetType(FSHParser.TargetTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link FSHParser#targetType}.
	 * @param ctx the parse tree
	 */
	void exitTargetType(FSHParser.TargetTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link FSHParser#mostAlphaKeywords}.
	 * @param ctx the parse tree
	 */
	void enterMostAlphaKeywords(FSHParser.MostAlphaKeywordsContext ctx);
	/**
	 * Exit a parse tree produced by {@link FSHParser#mostAlphaKeywords}.
	 * @param ctx the parse tree
	 */
	void exitMostAlphaKeywords(FSHParser.MostAlphaKeywordsContext ctx);
}
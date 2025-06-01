// Generated from ch/qligier/jetbrains/plugin/fss/fsh/antlr/FSH.g4 by ANTLR 4.13.1
package ch.qligier.jetbrains.plugin.fss.fsh.antlr;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link FSHParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface FSHVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link FSHParser#doc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoc(FSHParser.DocContext ctx);
	/**
	 * Visit a parse tree produced by {@link FSHParser#entity}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEntity(FSHParser.EntityContext ctx);
	/**
	 * Visit a parse tree produced by {@link FSHParser#alias}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlias(FSHParser.AliasContext ctx);
	/**
	 * Visit a parse tree produced by {@link FSHParser#profile}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProfile(FSHParser.ProfileContext ctx);
	/**
	 * Visit a parse tree produced by {@link FSHParser#extension}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExtension(FSHParser.ExtensionContext ctx);
	/**
	 * Visit a parse tree produced by {@link FSHParser#logical}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogical(FSHParser.LogicalContext ctx);
	/**
	 * Visit a parse tree produced by {@link FSHParser#resource}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitResource(FSHParser.ResourceContext ctx);
	/**
	 * Visit a parse tree produced by {@link FSHParser#sdMetadata}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSdMetadata(FSHParser.SdMetadataContext ctx);
	/**
	 * Visit a parse tree produced by {@link FSHParser#sdRule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSdRule(FSHParser.SdRuleContext ctx);
	/**
	 * Visit a parse tree produced by {@link FSHParser#lrRule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLrRule(FSHParser.LrRuleContext ctx);
	/**
	 * Visit a parse tree produced by {@link FSHParser#instance}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstance(FSHParser.InstanceContext ctx);
	/**
	 * Visit a parse tree produced by {@link FSHParser#instanceMetadata}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstanceMetadata(FSHParser.InstanceMetadataContext ctx);
	/**
	 * Visit a parse tree produced by {@link FSHParser#instanceRule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstanceRule(FSHParser.InstanceRuleContext ctx);
	/**
	 * Visit a parse tree produced by {@link FSHParser#invariant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInvariant(FSHParser.InvariantContext ctx);
	/**
	 * Visit a parse tree produced by {@link FSHParser#invariantMetadata}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInvariantMetadata(FSHParser.InvariantMetadataContext ctx);
	/**
	 * Visit a parse tree produced by {@link FSHParser#invariantRule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInvariantRule(FSHParser.InvariantRuleContext ctx);
	/**
	 * Visit a parse tree produced by {@link FSHParser#valueSet}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValueSet(FSHParser.ValueSetContext ctx);
	/**
	 * Visit a parse tree produced by {@link FSHParser#vsMetadata}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVsMetadata(FSHParser.VsMetadataContext ctx);
	/**
	 * Visit a parse tree produced by {@link FSHParser#vsRule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVsRule(FSHParser.VsRuleContext ctx);
	/**
	 * Visit a parse tree produced by {@link FSHParser#codeSystem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCodeSystem(FSHParser.CodeSystemContext ctx);
	/**
	 * Visit a parse tree produced by {@link FSHParser#csMetadata}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCsMetadata(FSHParser.CsMetadataContext ctx);
	/**
	 * Visit a parse tree produced by {@link FSHParser#csRule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCsRule(FSHParser.CsRuleContext ctx);
	/**
	 * Visit a parse tree produced by {@link FSHParser#ruleSet}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRuleSet(FSHParser.RuleSetContext ctx);
	/**
	 * Visit a parse tree produced by {@link FSHParser#ruleSetRule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRuleSetRule(FSHParser.RuleSetRuleContext ctx);
	/**
	 * Visit a parse tree produced by {@link FSHParser#paramRuleSet}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParamRuleSet(FSHParser.ParamRuleSetContext ctx);
	/**
	 * Visit a parse tree produced by {@link FSHParser#paramRuleSetRef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParamRuleSetRef(FSHParser.ParamRuleSetRefContext ctx);
	/**
	 * Visit a parse tree produced by {@link FSHParser#parameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameter(FSHParser.ParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link FSHParser#lastParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLastParameter(FSHParser.LastParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link FSHParser#paramRuleSetContent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParamRuleSetContent(FSHParser.ParamRuleSetContentContext ctx);
	/**
	 * Visit a parse tree produced by {@link FSHParser#mapping}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMapping(FSHParser.MappingContext ctx);
	/**
	 * Visit a parse tree produced by {@link FSHParser#mappingMetadata}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMappingMetadata(FSHParser.MappingMetadataContext ctx);
	/**
	 * Visit a parse tree produced by {@link FSHParser#mappingEntityRule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMappingEntityRule(FSHParser.MappingEntityRuleContext ctx);
	/**
	 * Visit a parse tree produced by {@link FSHParser#parent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParent(FSHParser.ParentContext ctx);
	/**
	 * Visit a parse tree produced by {@link FSHParser#id}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitId(FSHParser.IdContext ctx);
	/**
	 * Visit a parse tree produced by {@link FSHParser#title}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTitle(FSHParser.TitleContext ctx);
	/**
	 * Visit a parse tree produced by {@link FSHParser#description}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDescription(FSHParser.DescriptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link FSHParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(FSHParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link FSHParser#xpath}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXpath(FSHParser.XpathContext ctx);
	/**
	 * Visit a parse tree produced by {@link FSHParser#severity}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSeverity(FSHParser.SeverityContext ctx);
	/**
	 * Visit a parse tree produced by {@link FSHParser#instanceOf}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstanceOf(FSHParser.InstanceOfContext ctx);
	/**
	 * Visit a parse tree produced by {@link FSHParser#usage}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUsage(FSHParser.UsageContext ctx);
	/**
	 * Visit a parse tree produced by {@link FSHParser#source}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSource(FSHParser.SourceContext ctx);
	/**
	 * Visit a parse tree produced by {@link FSHParser#target}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTarget(FSHParser.TargetContext ctx);
	/**
	 * Visit a parse tree produced by {@link FSHParser#context}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContext(FSHParser.ContextContext ctx);
	/**
	 * Visit a parse tree produced by {@link FSHParser#contextItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContextItem(FSHParser.ContextItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link FSHParser#lastContextItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLastContextItem(FSHParser.LastContextItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link FSHParser#characteristics}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCharacteristics(FSHParser.CharacteristicsContext ctx);
	/**
	 * Visit a parse tree produced by {@link FSHParser#cardRule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCardRule(FSHParser.CardRuleContext ctx);
	/**
	 * Visit a parse tree produced by {@link FSHParser#flagRule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFlagRule(FSHParser.FlagRuleContext ctx);
	/**
	 * Visit a parse tree produced by {@link FSHParser#valueSetRule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValueSetRule(FSHParser.ValueSetRuleContext ctx);
	/**
	 * Visit a parse tree produced by {@link FSHParser#fixedValueRule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFixedValueRule(FSHParser.FixedValueRuleContext ctx);
	/**
	 * Visit a parse tree produced by {@link FSHParser#containsRule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContainsRule(FSHParser.ContainsRuleContext ctx);
	/**
	 * Visit a parse tree produced by {@link FSHParser#onlyRule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOnlyRule(FSHParser.OnlyRuleContext ctx);
	/**
	 * Visit a parse tree produced by {@link FSHParser#obeysRule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObeysRule(FSHParser.ObeysRuleContext ctx);
	/**
	 * Visit a parse tree produced by {@link FSHParser#caretValueRule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCaretValueRule(FSHParser.CaretValueRuleContext ctx);
	/**
	 * Visit a parse tree produced by {@link FSHParser#codeCaretValueRule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCodeCaretValueRule(FSHParser.CodeCaretValueRuleContext ctx);
	/**
	 * Visit a parse tree produced by {@link FSHParser#mappingRule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMappingRule(FSHParser.MappingRuleContext ctx);
	/**
	 * Visit a parse tree produced by {@link FSHParser#insertRule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInsertRule(FSHParser.InsertRuleContext ctx);
	/**
	 * Visit a parse tree produced by {@link FSHParser#codeInsertRule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCodeInsertRule(FSHParser.CodeInsertRuleContext ctx);
	/**
	 * Visit a parse tree produced by {@link FSHParser#addCRElementRule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddCRElementRule(FSHParser.AddCRElementRuleContext ctx);
	/**
	 * Visit a parse tree produced by {@link FSHParser#addElementRule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddElementRule(FSHParser.AddElementRuleContext ctx);
	/**
	 * Visit a parse tree produced by {@link FSHParser#pathRule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPathRule(FSHParser.PathRuleContext ctx);
	/**
	 * Visit a parse tree produced by {@link FSHParser#vsComponent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVsComponent(FSHParser.VsComponentContext ctx);
	/**
	 * Visit a parse tree produced by {@link FSHParser#vsConceptComponent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVsConceptComponent(FSHParser.VsConceptComponentContext ctx);
	/**
	 * Visit a parse tree produced by {@link FSHParser#vsFilterComponent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVsFilterComponent(FSHParser.VsFilterComponentContext ctx);
	/**
	 * Visit a parse tree produced by {@link FSHParser#vsComponentFrom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVsComponentFrom(FSHParser.VsComponentFromContext ctx);
	/**
	 * Visit a parse tree produced by {@link FSHParser#vsFromSystem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVsFromSystem(FSHParser.VsFromSystemContext ctx);
	/**
	 * Visit a parse tree produced by {@link FSHParser#vsFromValueset}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVsFromValueset(FSHParser.VsFromValuesetContext ctx);
	/**
	 * Visit a parse tree produced by {@link FSHParser#vsFilterList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVsFilterList(FSHParser.VsFilterListContext ctx);
	/**
	 * Visit a parse tree produced by {@link FSHParser#vsFilterDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVsFilterDefinition(FSHParser.VsFilterDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link FSHParser#vsFilterOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVsFilterOperator(FSHParser.VsFilterOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link FSHParser#vsFilterValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVsFilterValue(FSHParser.VsFilterValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link FSHParser#name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitName(FSHParser.NameContext ctx);
	/**
	 * Visit a parse tree produced by {@link FSHParser#path}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPath(FSHParser.PathContext ctx);
	/**
	 * Visit a parse tree produced by {@link FSHParser#caretPath}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCaretPath(FSHParser.CaretPathContext ctx);
	/**
	 * Visit a parse tree produced by {@link FSHParser#flag}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFlag(FSHParser.FlagContext ctx);
	/**
	 * Visit a parse tree produced by {@link FSHParser#strength}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStrength(FSHParser.StrengthContext ctx);
	/**
	 * Visit a parse tree produced by {@link FSHParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue(FSHParser.ValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link FSHParser#item}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitItem(FSHParser.ItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link FSHParser#code}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCode(FSHParser.CodeContext ctx);
	/**
	 * Visit a parse tree produced by {@link FSHParser#concept}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConcept(FSHParser.ConceptContext ctx);
	/**
	 * Visit a parse tree produced by {@link FSHParser#quantity}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuantity(FSHParser.QuantityContext ctx);
	/**
	 * Visit a parse tree produced by {@link FSHParser#ratio}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRatio(FSHParser.RatioContext ctx);
	/**
	 * Visit a parse tree produced by {@link FSHParser#reference}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReference(FSHParser.ReferenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link FSHParser#referenceType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReferenceType(FSHParser.ReferenceTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link FSHParser#codeableReferenceType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCodeableReferenceType(FSHParser.CodeableReferenceTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link FSHParser#canonical}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCanonical(FSHParser.CanonicalContext ctx);
	/**
	 * Visit a parse tree produced by {@link FSHParser#ratioPart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRatioPart(FSHParser.RatioPartContext ctx);
	/**
	 * Visit a parse tree produced by {@link FSHParser#bool}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBool(FSHParser.BoolContext ctx);
	/**
	 * Visit a parse tree produced by {@link FSHParser#targetType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTargetType(FSHParser.TargetTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link FSHParser#mostAlphaKeywords}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMostAlphaKeywords(FSHParser.MostAlphaKeywordsContext ctx);
}
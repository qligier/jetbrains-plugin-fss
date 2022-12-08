// This is a generated file. Not intended for manual editing.
package ch.qligier.jetbrains.plugin.fhir.fsh.parser.psi;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiElement;

public class FshVisitor extends PsiElementVisitor {

  public void visitAddCRElementRule(@NotNull FshAddCRElementRule o) {
    visitRule(o);
  }

  public void visitAddElementRule(@NotNull FshAddElementRule o) {
    visitRule(o);
  }

  public void visitAlias(@NotNull FshAlias o) {
    visitItem(o);
    // visitNamedItem(o);
  }

  public void visitAliasValue(@NotNull FshAliasValue o) {
    visitPsiElement(o);
  }

  public void visitBracketSuffix(@NotNull FshBracketSuffix o) {
    visitPsiElement(o);
  }

  public void visitCanonical(@NotNull FshCanonical o) {
    visitPsiElement(o);
  }

  public void visitCardRule(@NotNull FshCardRule o) {
    visitRule(o);
  }

  public void visitCardinality(@NotNull FshCardinality o) {
    visitPsiElement(o);
  }

  public void visitCaretValueRule(@NotNull FshCaretValueRule o) {
    visitRule(o);
  }

  public void visitCode(@NotNull FshCode o) {
    visitPsiElement(o);
  }

  public void visitCodeCaretValueRule(@NotNull FshCodeCaretValueRule o) {
    visitRule(o);
  }

  public void visitCodeInsertRule(@NotNull FshCodeInsertRule o) {
    visitRule(o);
  }

  public void visitCodeSystem(@NotNull FshCodeSystem o) {
    visitItem(o);
  }

  public void visitConcept(@NotNull FshConcept o) {
    visitRule(o);
  }

  public void visitContainsRule(@NotNull FshContainsRule o) {
    visitRule(o);
  }

  public void visitCsRule(@NotNull FshCsRule o) {
    visitPsiElement(o);
  }

  public void visitDescription(@NotNull FshDescription o) {
    visitItemMetadata(o);
  }

  public void visitExpression(@NotNull FshExpression o) {
    visitItemMetadata(o);
  }

  public void visitExtension(@NotNull FshExtension o) {
    visitItem(o);
  }

  public void visitFixedValueRule(@NotNull FshFixedValueRule o) {
    visitRule(o);
  }

  public void visitFlagRule(@NotNull FshFlagRule o) {
    visitRule(o);
  }

  public void visitId(@NotNull FshId o) {
    visitItemMetadata(o);
  }

  public void visitInsertRule(@NotNull FshInsertRule o) {
    visitRule(o);
  }

  public void visitInstance(@NotNull FshInstance o) {
    visitItem(o);
  }

  public void visitInstanceOf(@NotNull FshInstanceOf o) {
    visitItemMetadata(o);
  }

  public void visitInstanceRule(@NotNull FshInstanceRule o) {
    visitPsiElement(o);
  }

  public void visitInteger(@NotNull FshInteger o) {
    visitPsiElement(o);
  }

  public void visitInvariant(@NotNull FshInvariant o) {
    visitItem(o);
  }

  public void visitItem(@NotNull FshItem o) {
    visitPsiElement(o);
  }

  public void visitItemIdentifier(@NotNull FshItemIdentifier o) {
    visitPsiElement(o);
  }

  public void visitItemMetadata(@NotNull FshItemMetadata o) {
    visitPsiElement(o);
  }

  public void visitItemType(@NotNull FshItemType o) {
    visitPsiElement(o);
  }

  public void visitLogical(@NotNull FshLogical o) {
    visitItem(o);
  }

  public void visitMapping(@NotNull FshMapping o) {
    visitItem(o);
  }

  public void visitMappingEntityRule(@NotNull FshMappingEntityRule o) {
    visitPsiElement(o);
  }

  public void visitMappingMetadata(@NotNull FshMappingMetadata o) {
    visitPsiElement(o);
  }

  public void visitMappingRule(@NotNull FshMappingRule o) {
    visitRule(o);
  }

  public void visitNumber(@NotNull FshNumber o) {
    visitPsiElement(o);
  }

  public void visitObeysRule(@NotNull FshObeysRule o) {
    visitRule(o);
  }

  public void visitOnlyRule(@NotNull FshOnlyRule o) {
    visitRule(o);
  }

  public void visitParent(@NotNull FshParent o) {
    visitItemMetadata(o);
  }

  public void visitPath(@NotNull FshPath o) {
    visitPsiElement(o);
  }

  public void visitPathPart(@NotNull FshPathPart o) {
    visitPsiElement(o);
  }

  public void visitPathRule(@NotNull FshPathRule o) {
    visitRule(o);
  }

  public void visitProfile(@NotNull FshProfile o) {
    visitItem(o);
  }

  public void visitQuantity(@NotNull FshQuantity o) {
    visitPsiElement(o);
  }

  public void visitRatio(@NotNull FshRatio o) {
    visitPsiElement(o);
  }

  public void visitReferenceType(@NotNull FshReferenceType o) {
    visitPsiElement(o);
  }

  public void visitResource(@NotNull FshResource o) {
    visitItem(o);
  }

  public void visitRule(@NotNull FshRule o) {
    visitPsiElement(o);
  }

  public void visitRuleSet(@NotNull FshRuleSet o) {
    visitItem(o);
  }

  public void visitRuleSetReference(@NotNull FshRuleSetReference o) {
    visitPsiElement(o);
  }

  public void visitRuleSetRule(@NotNull FshRuleSetRule o) {
    visitPsiElement(o);
  }

  public void visitRuleStart(@NotNull FshRuleStart o) {
    visitPsiElement(o);
  }

  public void visitSeverity(@NotNull FshSeverity o) {
    visitItemMetadata(o);
  }

  public void visitSource(@NotNull FshSource o) {
    visitItemMetadata(o);
  }

  public void visitStrength(@NotNull FshStrength o) {
    visitPsiElement(o);
  }

  public void visitTarget(@NotNull FshTarget o) {
    visitItemMetadata(o);
  }

  public void visitTargetType(@NotNull FshTargetType o) {
    visitPsiElement(o);
  }

  public void visitTitle(@NotNull FshTitle o) {
    visitItemMetadata(o);
  }

  public void visitUsage(@NotNull FshUsage o) {
    visitItemMetadata(o);
  }

  public void visitValue(@NotNull FshValue o) {
    visitPsiElement(o);
  }

  public void visitValueSet(@NotNull FshValueSet o) {
    visitItem(o);
  }

  public void visitValueSetRule(@NotNull FshValueSetRule o) {
    visitRule(o);
  }

  public void visitVsComponent(@NotNull FshVsComponent o) {
    visitRule(o);
  }

  public void visitVsComponentFrom(@NotNull FshVsComponentFrom o) {
    visitPsiElement(o);
  }

  public void visitVsConceptComponent(@NotNull FshVsConceptComponent o) {
    visitPsiElement(o);
  }

  public void visitVsFilterComponent(@NotNull FshVsFilterComponent o) {
    visitPsiElement(o);
  }

  public void visitVsFilterDefinition(@NotNull FshVsFilterDefinition o) {
    visitPsiElement(o);
  }

  public void visitVsFilterList(@NotNull FshVsFilterList o) {
    visitPsiElement(o);
  }

  public void visitVsFilterOperator(@NotNull FshVsFilterOperator o) {
    visitPsiElement(o);
  }

  public void visitVsFilterValue(@NotNull FshVsFilterValue o) {
    visitPsiElement(o);
  }

  public void visitVsFromSystem(@NotNull FshVsFromSystem o) {
    visitPsiElement(o);
  }

  public void visitVsFromValueset(@NotNull FshVsFromValueset o) {
    visitPsiElement(o);
  }

  public void visitXpath(@NotNull FshXpath o) {
    visitItemMetadata(o);
  }

  public void visitPsiElement(@NotNull PsiElement o) {
    visitElement(o);
  }

}

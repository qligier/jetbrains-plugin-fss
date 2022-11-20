// This is a generated file. Not intended for manual editing.
package ch.qligier.jetbrains.plugin.fhir.fsh.parser.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static ch.qligier.jetbrains.plugin.fhir.fsh.parser.psi.FshTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import ch.qligier.jetbrains.plugin.fhir.fsh.parser.psi.*;

public class FshRuleSetRuleImpl extends ASTWrapperPsiElement implements FshRuleSetRule {

  public FshRuleSetRuleImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull FshVisitor visitor) {
    visitor.visitRuleSetRule(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof FshVisitor) accept((FshVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public FshAddCRElementRule getAddCRElementRule() {
    return findChildByClass(FshAddCRElementRule.class);
  }

  @Override
  @Nullable
  public FshAddElementRule getAddElementRule() {
    return findChildByClass(FshAddElementRule.class);
  }

  @Override
  @Nullable
  public FshCodeCaretValueRule getCodeCaretValueRule() {
    return findChildByClass(FshCodeCaretValueRule.class);
  }

  @Override
  @Nullable
  public FshCodeInsertRule getCodeInsertRule() {
    return findChildByClass(FshCodeInsertRule.class);
  }

  @Override
  @Nullable
  public FshConcept getConcept() {
    return findChildByClass(FshConcept.class);
  }

  @Override
  @Nullable
  public FshMappingRule getMappingRule() {
    return findChildByClass(FshMappingRule.class);
  }

  @Override
  @Nullable
  public FshSdRule getSdRule() {
    return findChildByClass(FshSdRule.class);
  }

  @Override
  @Nullable
  public FshVsComponent getVsComponent() {
    return findChildByClass(FshVsComponent.class);
  }

}

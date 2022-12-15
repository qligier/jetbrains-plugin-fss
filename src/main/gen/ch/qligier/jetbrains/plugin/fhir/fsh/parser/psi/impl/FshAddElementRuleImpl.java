// This is a generated file. Not intended for manual editing.
package ch.qligier.jetbrains.plugin.fhir.fsh.parser.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static ch.qligier.jetbrains.plugin.fhir.fsh.parser.psi.FshTypes.*;
import ch.qligier.jetbrains.plugin.fhir.fsh.parser.psi.*;

public class FshAddElementRuleImpl extends FshRuleImpl implements FshAddElementRule {

  public FshAddElementRuleImpl(@NotNull ASTNode node) {
    super(node);
  }

  @Override
  public void accept(@NotNull FshVisitor visitor) {
    visitor.visitAddElementRule(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof FshVisitor) accept((FshVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public FshCardinality getCardinality() {
    return findNotNullChildByClass(FshCardinality.class);
  }

  @Override
  @NotNull
  public FshPath getPath() {
    return findNotNullChildByClass(FshPath.class);
  }

  @Override
  @NotNull
  public FshRuleStart getRuleStart() {
    return findNotNullChildByClass(FshRuleStart.class);
  }

  @Override
  @NotNull
  public List<FshString> getStringList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, FshString.class);
  }

  @Override
  @NotNull
  public List<FshTargetType> getTargetTypeList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, FshTargetType.class);
  }

}

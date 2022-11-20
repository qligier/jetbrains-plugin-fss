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

public class FshInstanceRuleImpl extends ASTWrapperPsiElement implements FshInstanceRule {

  public FshInstanceRuleImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull FshVisitor visitor) {
    visitor.visitInstanceRule(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof FshVisitor) accept((FshVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public FshFixedValueRule getFixedValueRule() {
    return findChildByClass(FshFixedValueRule.class);
  }

  @Override
  @Nullable
  public FshInsertRule getInsertRule() {
    return findChildByClass(FshInsertRule.class);
  }

  @Override
  @Nullable
  public FshPathRule getPathRule() {
    return findChildByClass(FshPathRule.class);
  }

}

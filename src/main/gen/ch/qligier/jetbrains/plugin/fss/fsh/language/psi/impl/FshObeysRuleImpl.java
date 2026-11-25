// This is a generated file. Not intended for manual editing.
package ch.qligier.jetbrains.plugin.fss.fsh.language.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static ch.qligier.jetbrains.plugin.fss.fsh.language.psi.FshTypes.*;
import ch.qligier.jetbrains.plugin.fss.fsh.language.psi.*;

public class FshObeysRuleImpl extends FshRuleImpl implements FshObeysRule {

  public FshObeysRuleImpl(@NotNull ASTNode node) {
    super(node);
  }

  @Override
  public void accept(@NotNull FshVisitor visitor) {
    visitor.visitObeysRule(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof FshVisitor) accept((FshVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<FshInvariantRef> getInvariantRefList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, FshInvariantRef.class);
  }

}

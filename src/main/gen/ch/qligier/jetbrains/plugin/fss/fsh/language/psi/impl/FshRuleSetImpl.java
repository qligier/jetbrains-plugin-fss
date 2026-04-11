// This is a generated file. Not intended for manual editing.
package ch.qligier.jetbrains.plugin.fss.fsh.language.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static ch.qligier.jetbrains.plugin.fss.fsh.language.psi.FshTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import ch.qligier.jetbrains.plugin.fss.fsh.language.psi.*;

public class FshRuleSetImpl extends ASTWrapperPsiElement implements FshRuleSet {

  public FshRuleSetImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull FshVisitor visitor) {
    visitor.visitRuleSet(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof FshVisitor) accept((FshVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public FshRuleSetId getRuleSetId() {
    return findChildByClass(FshRuleSetId.class);
  }

  @Override
  @NotNull
  public List<FshRuleSetRule> getRuleSetRuleList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, FshRuleSetRule.class);
  }

  @Override
  public @Nullable String getName() {
    return FshPsiImplUtil.getName(this);
  }

  @Override
  public @NotNull List<@NotNull FshRuleSetRule> getRules() {
    return FshPsiImplUtil.getRules(this);
  }

}

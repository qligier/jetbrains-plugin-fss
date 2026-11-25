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

public class FshVsFilterRuleImpl extends FshRuleImpl implements FshVsFilterRule {

  public FshVsFilterRuleImpl(@NotNull ASTNode node) {
    super(node);
  }

  @Override
  public void accept(@NotNull FshVisitor visitor) {
    visitor.visitVsFilterRule(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof FshVisitor) accept((FshVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public FshVsComponentFrom getVsComponentFrom() {
    return notNullChild(PsiTreeUtil.getChildOfType(this, FshVsComponentFrom.class));
  }

  @Override
  @Nullable
  public FshVsFilterList getVsFilterList() {
    return PsiTreeUtil.getChildOfType(this, FshVsFilterList.class);
  }

}

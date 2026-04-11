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

public class FshCaretValueRuleImpl extends ASTWrapperPsiElement implements FshCaretValueRule {

  public FshCaretValueRuleImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull FshVisitor visitor) {
    visitor.visitCaretValueRule(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof FshVisitor) accept((FshVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<FshPath> getPathList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, FshPath.class);
  }

  @Override
  @Nullable
  public FshValue getValue() {
    return findChildByClass(FshValue.class);
  }

  @Override
  public @Nullable FshPath getElementPath() {
    return FshPsiImplUtil.getElementPath(this);
  }

  @Override
  public @Nullable FshPath getCaretPath() {
    return FshPsiImplUtil.getCaretPath(this);
  }

}

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

public class FshVsComponentFromImpl extends ASTWrapperPsiElement implements FshVsComponentFrom {

  public FshVsComponentFromImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull FshVisitor visitor) {
    visitor.visitVsComponentFrom(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof FshVisitor) accept((FshVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<FshVsFromSystem> getVsFromSystemList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, FshVsFromSystem.class);
  }

  @Override
  @NotNull
  public List<FshVsFromValueSet> getVsFromValueSetList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, FshVsFromValueSet.class);
  }

}

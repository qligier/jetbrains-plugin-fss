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

public class FshCardRuleImpl extends ASTWrapperPsiElement implements FshCardRule {

  public FshCardRuleImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull FshVisitor visitor) {
    visitor.visitCardRule(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof FshVisitor) accept((FshVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public FshCardinality getCardinality() {
    return findChildByClass(FshCardinality.class);
  }

  @Override
  @NotNull
  public List<FshFlag> getFlagList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, FshFlag.class);
  }

  @Override
  @Nullable
  public FshPath getPath() {
    return findChildByClass(FshPath.class);
  }

  @Override
  public @NotNull List<@NotNull FshFlag> getFlags() {
    return FshPsiImplUtil.getFlags(this);
  }

}

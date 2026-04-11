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

public class FshMappingEntityRuleImpl extends ASTWrapperPsiElement implements FshMappingEntityRule {

  public FshMappingEntityRuleImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull FshVisitor visitor) {
    visitor.visitMappingEntityRule(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof FshVisitor) accept((FshVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public FshPath getPath() {
    return findChildByClass(FshPath.class);
  }

  @Override
  @Nullable
  public PsiElement getCode() {
    return findChildByType(CODE);
  }

  @Override
  @Nullable
  public PsiElement getMultilineString() {
    return findChildByType(MULTILINE_STRING);
  }

  @Override
  @Nullable
  public PsiElement getQuotedCode() {
    return findChildByType(QUOTED_CODE);
  }

  @Override
  public @Nullable PsiElement getTarget() {
    return FshPsiImplUtil.getTarget(this);
  }

  @Override
  public @Nullable PsiElement getComment() {
    return FshPsiImplUtil.getComment(this);
  }

}

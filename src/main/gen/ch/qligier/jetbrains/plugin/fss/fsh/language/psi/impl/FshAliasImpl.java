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

public class FshAliasImpl extends FshNamedElementImpl implements FshAlias {

  public FshAliasImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull FshVisitor visitor) {
    visitor.visitAlias(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof FshVisitor) accept((FshVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public PsiElement getAliasRef() {
    return findChildByType(ALIAS_REF);
  }

  @Override
  @Nullable
  public PsiElement getIdentifier() {
    return findChildByType(IDENTIFIER);
  }

  @Override
  @Nullable
  public PsiElement getSequence() {
    return findChildByType(SEQUENCE);
  }

  @Override
  @Nullable
  public PsiElement getUrl() {
    return findChildByType(URL);
  }

  @Override
  public @Nullable String getName() {
    return FshPsiImplUtil.getName(this);
  }

  @Override
  public @Nullable String getAliasValue() {
    return FshPsiImplUtil.getAliasValue(this);
  }

}

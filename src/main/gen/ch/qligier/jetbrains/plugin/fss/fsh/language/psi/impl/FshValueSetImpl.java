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

public class FshValueSetImpl extends FshNamedElementImpl implements FshValueSet {

  public FshValueSetImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull FshVisitor visitor) {
    visitor.visitValueSet(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof FshVisitor) accept((FshVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public FshNameToken getNameToken() {
    return findChildByClass(FshNameToken.class);
  }

  @Override
  @NotNull
  public List<FshVsMetadata> getVsMetadataList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, FshVsMetadata.class);
  }

  @Override
  @NotNull
  public List<FshVsRule> getVsRuleList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, FshVsRule.class);
  }

  @Override
  public @Nullable String getName() {
    return FshPsiImplUtil.getName(this);
  }

  @Override
  public @NotNull List<@NotNull FshVsMetadata> getMetadata() {
    return FshPsiImplUtil.getMetadata(this);
  }

  @Override
  public @NotNull List<@NotNull FshVsRule> getRules() {
    return FshPsiImplUtil.getRules(this);
  }

}

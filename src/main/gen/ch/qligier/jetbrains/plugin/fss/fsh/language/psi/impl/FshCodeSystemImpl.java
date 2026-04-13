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

public class FshCodeSystemImpl extends FshEntityImpl implements FshCodeSystem {

  public FshCodeSystemImpl(@NotNull ASTNode node) {
    super(node);
  }

  @Override
  public void accept(@NotNull FshVisitor visitor) {
    visitor.visitCodeSystem(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof FshVisitor) accept((FshVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<FshCsMetadata> getCsMetadataList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, FshCsMetadata.class);
  }

  @Override
  @NotNull
  public List<FshCsRule> getCsRuleList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, FshCsRule.class);
  }

  @Override
  @Nullable
  public FshNameToken getNameToken() {
    return findChildByClass(FshNameToken.class);
  }

  @Override
  public @Nullable String getName() {
    return FshPsiImplUtil.getName(this);
  }

  @Override
  public @NotNull List<@NotNull FshCsMetadata> getMetadata() {
    return FshPsiImplUtil.getMetadata(this);
  }

  @Override
  public @NotNull List<@NotNull FshCsRule> getRules() {
    return FshPsiImplUtil.getRules(this);
  }

}

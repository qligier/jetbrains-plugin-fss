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

public class FshExtensionImpl extends FshNamedElementImpl implements FshExtension {

  public FshExtensionImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull FshVisitor visitor) {
    visitor.visitExtension(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof FshVisitor) accept((FshVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<FshExtensionMetadata> getExtensionMetadataList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, FshExtensionMetadata.class);
  }

  @Override
  @Nullable
  public FshNameToken getNameToken() {
    return findChildByClass(FshNameToken.class);
  }

  @Override
  @NotNull
  public List<FshSdRule> getSdRuleList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, FshSdRule.class);
  }

  @Override
  public @Nullable String getName() {
    return FshPsiImplUtil.getName(this);
  }

  @Override
  public @NotNull List<@NotNull FshExtensionMetadata> getMetadata() {
    return FshPsiImplUtil.getMetadata(this);
  }

  @Override
  public @NotNull List<@NotNull FshSdRule> getRules() {
    return FshPsiImplUtil.getRules(this);
  }

}

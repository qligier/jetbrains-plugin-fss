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

public class FshInstanceMetadataImpl extends ASTWrapperPsiElement implements FshInstanceMetadata {

  public FshInstanceMetadataImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull FshVisitor visitor) {
    visitor.visitInstanceMetadata(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof FshVisitor) accept((FshVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public FshDescriptionMetadata getDescriptionMetadata() {
    return findChildByClass(FshDescriptionMetadata.class);
  }

  @Override
  @Nullable
  public FshIdMetadata getIdMetadata() {
    return findChildByClass(FshIdMetadata.class);
  }

  @Override
  @Nullable
  public FshInstanceOfMetadata getInstanceOfMetadata() {
    return findChildByClass(FshInstanceOfMetadata.class);
  }

  @Override
  @Nullable
  public FshTitleMetadata getTitleMetadata() {
    return findChildByClass(FshTitleMetadata.class);
  }

  @Override
  @Nullable
  public FshUsageMetadata getUsageMetadata() {
    return findChildByClass(FshUsageMetadata.class);
  }

}

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

public class FshResourceMetadataImpl extends ASTWrapperPsiElement implements FshResourceMetadata {

  public FshResourceMetadataImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull FshVisitor visitor) {
    visitor.visitResourceMetadata(this);
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
  public FshMixinsMetadata getMixinsMetadata() {
    return findChildByClass(FshMixinsMetadata.class);
  }

  @Override
  @Nullable
  public FshParentMetadata getParentMetadata() {
    return findChildByClass(FshParentMetadata.class);
  }

  @Override
  @Nullable
  public FshTitleMetadata getTitleMetadata() {
    return findChildByClass(FshTitleMetadata.class);
  }

}

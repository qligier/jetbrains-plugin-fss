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

public class FshInvariantMetadataImpl extends ASTWrapperPsiElement implements FshInvariantMetadata {

  public FshInvariantMetadataImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull FshVisitor visitor) {
    visitor.visitInvariantMetadata(this);
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
  public FshExpressionMetadata getExpressionMetadata() {
    return findChildByClass(FshExpressionMetadata.class);
  }

  @Override
  @Nullable
  public FshSeverityMetadata getSeverityMetadata() {
    return findChildByClass(FshSeverityMetadata.class);
  }

  @Override
  @Nullable
  public FshXpathMetadata getXpathMetadata() {
    return findChildByClass(FshXpathMetadata.class);
  }

}

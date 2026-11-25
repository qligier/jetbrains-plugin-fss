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

public class FshTypeRefImpl extends FshReferenceHostMixin implements FshTypeRef {

  public FshTypeRefImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull FshVisitor visitor) {
    visitor.visitTypeRef(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof FshVisitor) accept((FshVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public FshCanonicalType getCanonicalType() {
    return PsiTreeUtil.getChildOfType(this, FshCanonicalType.class);
  }

  @Override
  @Nullable
  public FshReferenceType getReferenceType() {
    return PsiTreeUtil.getChildOfType(this, FshReferenceType.class);
  }

}

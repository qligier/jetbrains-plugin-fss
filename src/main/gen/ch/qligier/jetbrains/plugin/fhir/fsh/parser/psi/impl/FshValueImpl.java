// This is a generated file. Not intended for manual editing.
package ch.qligier.jetbrains.plugin.fhir.fsh.parser.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static ch.qligier.jetbrains.plugin.fhir.fsh.parser.psi.FshTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import ch.qligier.jetbrains.plugin.fhir.fsh.parser.psi.*;

public class FshValueImpl extends ASTWrapperPsiElement implements FshValue {

  public FshValueImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull FshVisitor visitor) {
    visitor.visitValue(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof FshVisitor) accept((FshVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public FshCanonical getCanonical() {
    return findChildByClass(FshCanonical.class);
  }

  @Override
  @Nullable
  public FshCode getCode() {
    return findChildByClass(FshCode.class);
  }

  @Override
  @Nullable
  public FshIdentifierRef getIdentifierRef() {
    return findChildByClass(FshIdentifierRef.class);
  }

  @Override
  @Nullable
  public FshNumber getNumber() {
    return findChildByClass(FshNumber.class);
  }

  @Override
  @Nullable
  public FshQuantity getQuantity() {
    return findChildByClass(FshQuantity.class);
  }

  @Override
  @Nullable
  public FshRatio getRatio() {
    return findChildByClass(FshRatio.class);
  }

  @Override
  @Nullable
  public FshReferenceType getReferenceType() {
    return findChildByClass(FshReferenceType.class);
  }

}

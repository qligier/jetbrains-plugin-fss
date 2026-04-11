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
  public FshBooleanValue getBooleanValue() {
    return findChildByClass(FshBooleanValue.class);
  }

  @Override
  @Nullable
  public FshCanonicalType getCanonicalType() {
    return findChildByClass(FshCanonicalType.class);
  }

  @Override
  @Nullable
  public FshCodeValue getCodeValue() {
    return findChildByClass(FshCodeValue.class);
  }

  @Override
  @Nullable
  public FshCodeableReferenceType getCodeableReferenceType() {
    return findChildByClass(FshCodeableReferenceType.class);
  }

  @Override
  @Nullable
  public FshDateTimeValue getDateTimeValue() {
    return findChildByClass(FshDateTimeValue.class);
  }

  @Override
  @Nullable
  public FshDateValue getDateValue() {
    return findChildByClass(FshDateValue.class);
  }

  @Override
  @Nullable
  public FshNameToken getNameToken() {
    return findChildByClass(FshNameToken.class);
  }

  @Override
  @Nullable
  public FshQuantity getQuantity() {
    return findChildByClass(FshQuantity.class);
  }

  @Override
  @Nullable
  public FshRatioValue getRatioValue() {
    return findChildByClass(FshRatioValue.class);
  }

  @Override
  @Nullable
  public FshReferenceType getReferenceType() {
    return findChildByClass(FshReferenceType.class);
  }

  @Override
  @Nullable
  public FshTimeValue getTimeValue() {
    return findChildByClass(FshTimeValue.class);
  }

  @Override
  @Nullable
  public PsiElement getAliasRef() {
    return findChildByType(ALIAS_REF);
  }

  @Override
  @Nullable
  public PsiElement getDecimal() {
    return findChildByType(DECIMAL);
  }

  @Override
  @Nullable
  public PsiElement getInteger() {
    return findChildByType(INTEGER);
  }

  @Override
  @Nullable
  public PsiElement getMultilineString() {
    return findChildByType(MULTILINE_STRING);
  }

  @Override
  @Nullable
  public PsiElement getString() {
    return findChildByType(STRING);
  }

  @Override
  @Nullable
  public PsiElement getUrl() {
    return findChildByType(URL);
  }

}

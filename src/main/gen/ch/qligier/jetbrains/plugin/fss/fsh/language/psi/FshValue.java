// This is a generated file. Not intended for manual editing.
package ch.qligier.jetbrains.plugin.fss.fsh.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface FshValue extends PsiElement {

  @Nullable
  FshBooleanValue getBooleanValue();

  @Nullable
  FshCanonicalType getCanonicalType();

  @Nullable
  FshCodeValue getCodeValue();

  @Nullable
  FshCodeableReferenceType getCodeableReferenceType();

  @Nullable
  FshDateTimeValue getDateTimeValue();

  @Nullable
  FshDateValue getDateValue();

  @Nullable
  FshNameToken getNameToken();

  @Nullable
  FshQuantity getQuantity();

  @Nullable
  FshRatioValue getRatioValue();

  @Nullable
  FshReferenceType getReferenceType();

  @Nullable
  FshTimeValue getTimeValue();

  @Nullable
  PsiElement getAliasRef();

  @Nullable
  PsiElement getDecimal();

  @Nullable
  PsiElement getInteger();

  @Nullable
  PsiElement getMultilineString();

  @Nullable
  PsiElement getString();

  @Nullable
  PsiElement getUrl();

}

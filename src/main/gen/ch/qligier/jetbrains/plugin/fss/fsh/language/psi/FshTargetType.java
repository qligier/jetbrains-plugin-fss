// This is a generated file. Not intended for manual editing.
package ch.qligier.jetbrains.plugin.fss.fsh.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface FshTargetType extends PsiElement {

  @Nullable
  FshCanonicalType getCanonicalType();

  @Nullable
  FshCodeableReferenceType getCodeableReferenceType();

  @Nullable
  FshNameToken getNameToken();

  @Nullable
  FshReferenceType getReferenceType();

}

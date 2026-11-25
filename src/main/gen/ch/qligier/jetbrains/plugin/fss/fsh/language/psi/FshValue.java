// This is a generated file. Not intended for manual editing.
package ch.qligier.jetbrains.plugin.fss.fsh.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface FshValue extends PsiElement {

  @Nullable
  FshCanonicalValue getCanonicalValue();

  @Nullable
  FshCodeValue getCodeValue();

  @Nullable
  FshNameRef getNameRef();

  @Nullable
  FshQuantity getQuantity();

  @Nullable
  FshRatio getRatio();

  @Nullable
  FshReferenceValue getReferenceValue();

}

// This is a generated file. Not intended for manual editing.
package ch.qligier.jetbrains.plugin.fhir.fsh.parser.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface FshValue extends PsiElement {

  @Nullable
  FshCanonical getCanonical();

  @Nullable
  FshCode getCode();

  @Nullable
  FshIdentifierRef getIdentifierRef();

  @Nullable
  FshNumber getNumber();

  @Nullable
  FshQuantity getQuantity();

  @Nullable
  FshRatio getRatio();

  @Nullable
  FshReferenceType getReferenceType();

  @Nullable
  FshString getString();

}

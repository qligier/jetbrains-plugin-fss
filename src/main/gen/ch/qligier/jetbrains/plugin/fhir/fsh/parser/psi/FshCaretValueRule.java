// This is a generated file. Not intended for manual editing.
package ch.qligier.jetbrains.plugin.fhir.fsh.parser.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface FshCaretValueRule extends PsiElement {

  @NotNull
  List<FshPath> getPathList();

  @NotNull
  FshRuleStart getRuleStart();

  @NotNull
  FshValue getValue();

}

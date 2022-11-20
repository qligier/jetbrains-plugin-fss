// This is a generated file. Not intended for manual editing.
package ch.qligier.jetbrains.plugin.fhir.fsh.parser.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface FshInvariant extends PsiElement {

  @NotNull
  List<FshDescription> getDescriptionList();

  @NotNull
  List<FshExpression> getExpressionList();

  @NotNull
  List<FshSeverity> getSeverityList();

  @NotNull
  List<FshXpath> getXpathList();

}

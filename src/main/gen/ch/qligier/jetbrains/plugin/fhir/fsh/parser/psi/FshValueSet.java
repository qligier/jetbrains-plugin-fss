// This is a generated file. Not intended for manual editing.
package ch.qligier.jetbrains.plugin.fhir.fsh.parser.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface FshValueSet extends PsiElement {

  @NotNull
  List<FshCaretValueRule> getCaretValueRuleList();

  @NotNull
  List<FshDescription> getDescriptionList();

  @NotNull
  List<FshId> getIdList();

  @NotNull
  List<FshInsertRule> getInsertRuleList();

  @NotNull
  List<FshTitle> getTitleList();

  @NotNull
  List<FshVsComponent> getVsComponentList();

}

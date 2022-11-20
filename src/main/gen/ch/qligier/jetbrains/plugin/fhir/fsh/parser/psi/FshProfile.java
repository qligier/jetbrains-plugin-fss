// This is a generated file. Not intended for manual editing.
package ch.qligier.jetbrains.plugin.fhir.fsh.parser.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface FshProfile extends PsiElement {

  @NotNull
  List<FshDescription> getDescriptionList();

  @NotNull
  List<FshId> getIdList();

  @NotNull
  List<FshParent> getParentList();

  @NotNull
  List<FshSdRule> getSdRuleList();

  @NotNull
  List<FshTitle> getTitleList();

}

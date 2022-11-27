// This is a generated file. Not intended for manual editing.
package ch.qligier.jetbrains.plugin.fhir.fsh.parser.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface FshInstance extends FshItem {

  @NotNull
  List<FshInstanceRule> getInstanceRuleList();

  @NotNull
  List<FshItemMetadata> getItemMetadataList();

}

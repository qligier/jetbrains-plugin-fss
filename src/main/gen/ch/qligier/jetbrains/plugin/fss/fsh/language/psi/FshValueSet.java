// This is a generated file. Not intended for manual editing.
package ch.qligier.jetbrains.plugin.fss.fsh.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface FshValueSet extends FshNamedElement {

  @Nullable
  FshNameToken getNameToken();

  @NotNull
  List<FshVsMetadata> getVsMetadataList();

  @NotNull
  List<FshVsRule> getVsRuleList();

  @Nullable String getName();

  @NotNull List<@NotNull FshVsMetadata> getMetadata();

  @NotNull List<@NotNull FshVsRule> getRules();

}

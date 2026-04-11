// This is a generated file. Not intended for manual editing.
package ch.qligier.jetbrains.plugin.fss.fsh.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface FshMapping extends PsiElement {

  @NotNull
  List<FshMappingEntityMetadata> getMappingEntityMetadataList();

  @NotNull
  List<FshMappingRule> getMappingRuleList();

  @Nullable
  FshNameToken getNameToken();

  @Nullable String getName();

  @NotNull List<@NotNull FshMappingEntityMetadata> getMetadata();

  @NotNull List<@NotNull FshMappingRule> getRules();

}

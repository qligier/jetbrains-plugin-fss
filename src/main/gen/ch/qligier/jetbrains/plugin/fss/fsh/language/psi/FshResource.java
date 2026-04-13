// This is a generated file. Not intended for manual editing.
package ch.qligier.jetbrains.plugin.fss.fsh.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface FshResource extends FshEntity {

  @Nullable
  FshNameToken getNameToken();

  @NotNull
  List<FshResourceMetadata> getResourceMetadataList();

  @NotNull
  List<FshSdRule> getSdRuleList();

  @Nullable String getName();

  @NotNull List<@NotNull FshResourceMetadata> getMetadata();

  @NotNull List<@NotNull FshSdRule> getRules();

}

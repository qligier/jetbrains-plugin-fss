// This is a generated file. Not intended for manual editing.
package ch.qligier.jetbrains.plugin.fss.fsh.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface FshExtension extends PsiElement {

  @NotNull
  List<FshExtensionMetadata> getExtensionMetadataList();

  @Nullable
  FshNameToken getNameToken();

  @NotNull
  List<FshSdRule> getSdRuleList();

  @Nullable String getName();

  @NotNull List<@NotNull FshExtensionMetadata> getMetadata();

  @NotNull List<@NotNull FshSdRule> getRules();

}

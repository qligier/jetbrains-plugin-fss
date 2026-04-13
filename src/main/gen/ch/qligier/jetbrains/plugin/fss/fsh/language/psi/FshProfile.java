// This is a generated file. Not intended for manual editing.
package ch.qligier.jetbrains.plugin.fss.fsh.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface FshProfile extends FshNamedElement {

  @Nullable
  FshNameToken getNameToken();

  @NotNull
  List<FshProfileMetadata> getProfileMetadataList();

  @NotNull
  List<FshSdRule> getSdRuleList();

  @Nullable String getName();

  @NotNull List<@NotNull FshProfileMetadata> getMetadata();

  @NotNull List<@NotNull FshSdRule> getRules();

}

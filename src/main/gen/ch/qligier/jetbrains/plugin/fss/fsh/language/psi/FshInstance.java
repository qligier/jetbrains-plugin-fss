// This is a generated file. Not intended for manual editing.
package ch.qligier.jetbrains.plugin.fss.fsh.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface FshInstance extends FshNamedElement {

  @NotNull
  List<FshInstanceMetadata> getInstanceMetadataList();

  @NotNull
  List<FshInstanceRule> getInstanceRuleList();

  @Nullable
  FshNameToken getNameToken();

  @Nullable String getName();

  @NotNull List<@NotNull FshInstanceMetadata> getMetadata();

  @NotNull List<@NotNull FshInstanceRule> getRules();

}

// This is a generated file. Not intended for manual editing.
package ch.qligier.jetbrains.plugin.fss.fsh.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface FshCodeSystem extends FshEntity {

  @NotNull
  List<FshCsMetadata> getCsMetadataList();

  @NotNull
  List<FshCsRule> getCsRuleList();

  @Nullable
  FshNameToken getNameToken();

  @Nullable String getName();

  @NotNull List<@NotNull FshCsMetadata> getMetadata();

  @NotNull List<@NotNull FshCsRule> getRules();

}

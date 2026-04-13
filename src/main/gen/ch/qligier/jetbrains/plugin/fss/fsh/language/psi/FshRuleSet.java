// This is a generated file. Not intended for manual editing.
package ch.qligier.jetbrains.plugin.fss.fsh.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface FshRuleSet extends FshEntity {

  @Nullable
  FshRuleSetId getRuleSetId();

  @NotNull
  List<FshRuleSetRule> getRuleSetRuleList();

  @Nullable String getName();

  @NotNull List<@NotNull FshRuleSetRule> getRules();

}

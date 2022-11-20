// This is a generated file. Not intended for manual editing.
package ch.qligier.jetbrains.plugin.fhir.fsh.parser.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface FshSdRule extends PsiElement {

  @Nullable
  FshCardRule getCardRule();

  @Nullable
  FshCaretValueRule getCaretValueRule();

  @Nullable
  FshContainsRule getContainsRule();

  @Nullable
  FshFixedValueRule getFixedValueRule();

  @Nullable
  FshFlagRule getFlagRule();

  @Nullable
  FshInsertRule getInsertRule();

  @Nullable
  FshObeysRule getObeysRule();

  @Nullable
  FshOnlyRule getOnlyRule();

  @Nullable
  FshPathRule getPathRule();

  @Nullable
  FshValueSetRule getValueSetRule();

}

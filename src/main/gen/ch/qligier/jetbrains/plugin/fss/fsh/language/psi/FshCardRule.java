// This is a generated file. Not intended for manual editing.
package ch.qligier.jetbrains.plugin.fss.fsh.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface FshCardRule extends PsiElement {

  @Nullable
  FshCardinality getCardinality();

  @NotNull
  List<FshFlag> getFlagList();

  @Nullable
  FshPath getPath();

  @NotNull List<@NotNull FshFlag> getFlags();

}

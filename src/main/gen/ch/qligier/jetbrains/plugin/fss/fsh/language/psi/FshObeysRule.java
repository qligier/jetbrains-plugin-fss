// This is a generated file. Not intended for manual editing.
package ch.qligier.jetbrains.plugin.fss.fsh.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface FshObeysRule extends PsiElement {

  @NotNull
  List<FshNameToken> getNameTokenList();

  @Nullable
  FshPath getPath();

  @NotNull List<@NotNull FshNameToken> getInvariantNames();

}

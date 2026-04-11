// This is a generated file. Not intended for manual editing.
package ch.qligier.jetbrains.plugin.fss.fsh.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface FshOnlyRule extends PsiElement {

  @NotNull
  FshPath getPath();

  @NotNull
  List<FshTargetType> getTargetTypeList();

  @NotNull List<@NotNull FshTargetType> getTargetTypes();

}

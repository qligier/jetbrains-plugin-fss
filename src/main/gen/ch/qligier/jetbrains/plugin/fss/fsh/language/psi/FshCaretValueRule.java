// This is a generated file. Not intended for manual editing.
package ch.qligier.jetbrains.plugin.fss.fsh.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface FshCaretValueRule extends PsiElement {

  @NotNull
  List<FshPath> getPathList();

  @Nullable
  FshValue getValue();

  @Nullable FshPath getElementPath();

  @Nullable FshPath getCaretPath();

}

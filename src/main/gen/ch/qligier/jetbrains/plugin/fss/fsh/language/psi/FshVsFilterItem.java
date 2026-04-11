// This is a generated file. Not intended for manual editing.
package ch.qligier.jetbrains.plugin.fss.fsh.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface FshVsFilterItem extends PsiElement {

  @NotNull
  FshNameToken getNameToken();

  @NotNull
  FshVsFilterOperator getVsFilterOperator();

  @NotNull
  FshVsFilterValue getVsFilterValue();

}

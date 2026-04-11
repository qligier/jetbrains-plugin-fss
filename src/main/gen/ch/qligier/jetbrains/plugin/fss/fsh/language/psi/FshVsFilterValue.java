// This is a generated file. Not intended for manual editing.
package ch.qligier.jetbrains.plugin.fss.fsh.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface FshVsFilterValue extends PsiElement {

  @Nullable
  FshNameToken getNameToken();

  @Nullable
  PsiElement getCode();

  @Nullable
  PsiElement getQuotedCode();

  @Nullable
  PsiElement getRegexLiteral();

  @Nullable
  PsiElement getString();

}

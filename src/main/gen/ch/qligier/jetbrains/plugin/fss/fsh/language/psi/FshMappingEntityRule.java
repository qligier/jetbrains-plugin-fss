// This is a generated file. Not intended for manual editing.
package ch.qligier.jetbrains.plugin.fss.fsh.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface FshMappingEntityRule extends PsiElement {

  @Nullable
  FshPath getPath();

  @Nullable
  PsiElement getCode();

  @Nullable
  PsiElement getMultilineString();

  @Nullable
  PsiElement getQuotedCode();

  @Nullable PsiElement getTarget();

  @Nullable PsiElement getComment();

}

// This is a generated file. Not intended for manual editing.
package ch.qligier.jetbrains.plugin.fss.fsh.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface FshAlias extends PsiElement {

  @Nullable
  PsiElement getAliasRef();

  @Nullable
  PsiElement getIdentifier();

  @Nullable
  PsiElement getSequence();

  @Nullable
  PsiElement getUrl();

  @Nullable String getName();

  @Nullable String getAliasValue();

}

// This is a generated file. Not intended for manual editing.
package ch.qligier.jetbrains.plugin.fss.fsh.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface FshEntity extends PsiElement {

  @Nullable
  FshAlias getAlias();

  @Nullable
  FshCodeSystem getCodeSystem();

  @Nullable
  FshExtension getExtension();

  @Nullable
  FshInstance getInstance();

  @Nullable
  FshInvariant getInvariant();

  @Nullable
  FshLogical getLogical();

  @Nullable
  FshMapping getMapping();

  @Nullable
  FshProfile getProfile();

  @Nullable
  FshResource getResource();

  @Nullable
  FshRuleSet getRuleSet();

  @Nullable
  FshValueSet getValueSet();

}

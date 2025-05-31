// This is a generated file. Not intended for manual editing.
package ch.qligier.jetbrains.plugin.fss.ig_ini.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface IniSection extends PsiElement {

  @NotNull
  List<IniProperty> getPropertyList();

  @Nullable String getSectionName();

  @NotNull List<@NotNull IniProperty> getProperties();

}

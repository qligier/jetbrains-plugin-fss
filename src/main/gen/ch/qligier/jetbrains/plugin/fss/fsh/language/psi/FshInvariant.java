// This is a generated file. Not intended for manual editing.
package ch.qligier.jetbrains.plugin.fss.fsh.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface FshInvariant extends PsiElement {

  @NotNull
  List<FshInvariantMetadata> getInvariantMetadataList();

  @Nullable
  FshNameToken getNameToken();

  @Nullable String getName();

  @NotNull List<@NotNull FshInvariantMetadata> getMetadata();

}

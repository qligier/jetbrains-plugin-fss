// This is a generated file. Not intended for manual editing.
package ch.qligier.jetbrains.plugin.fss.fsh.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import com.intellij.psi.StubBasedPsiElement;
import ch.qligier.jetbrains.plugin.fss.fsh.language.psi.stubs.FshEntityStub;

public interface FshResourceEntity extends FshEntity, StubBasedPsiElement<FshEntityStub> {

  @Nullable
  FshEntityName getEntityName();

  @NotNull
  List<FshMetadata> getMetadataList();

  @NotNull
  List<FshRule> getRuleList();

}

// This is a generated file. Not intended for manual editing.
package ch.qligier.jetbrains.plugin.fss.fsh.language.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static ch.qligier.jetbrains.plugin.fss.fsh.language.psi.FshTypes.*;
import ch.qligier.jetbrains.plugin.fss.fsh.language.psi.*;
import com.intellij.psi.stubs.IStubElementType;
import ch.qligier.jetbrains.plugin.fss.fsh.language.psi.stubs.FshEntityStub;

public class FshCodeSystemEntityImpl extends FshEntityImpl implements FshCodeSystemEntity {

  public FshCodeSystemEntityImpl(ASTNode node) {
    super(node);
  }

  public FshCodeSystemEntityImpl(FshEntityStub stub, IStubElementType stubType) {
    super(stub, stubType);
  }

  @Override
  public void accept(@NotNull FshVisitor visitor) {
    visitor.visitCodeSystemEntity(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof FshVisitor) accept((FshVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public FshEntityName getEntityName() {
    return PsiTreeUtil.getChildOfType(this, FshEntityName.class);
  }

  @Override
  @NotNull
  public List<FshMetadata> getMetadataList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, FshMetadata.class);
  }

  @Override
  @NotNull
  public List<FshRule> getRuleList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, FshRule.class);
  }

}

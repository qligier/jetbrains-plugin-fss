// This is a generated file. Not intended for manual editing.
package ch.qligier.jetbrains.plugin.fss.igini.language.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static ch.qligier.jetbrains.plugin.fss.igini.language.psi.IniTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import ch.qligier.jetbrains.plugin.fss.igini.language.psi.*;

public class IniSectionImpl extends ASTWrapperPsiElement implements IniSection {

  public IniSectionImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull IniVisitor visitor) {
    visitor.visitSection(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof IniVisitor) accept((IniVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<IniProperty> getPropertyList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, IniProperty.class);
  }

  @Override
  public @Nullable String getSectionName() {
    return IniPsiImplUtil.getSectionName(this);
  }

  @Override
  public @NotNull List<IniProperty> getProperties() {
    return IniPsiImplUtil.getProperties(this);
  }

}

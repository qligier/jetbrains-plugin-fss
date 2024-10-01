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

public class IniPropertyImpl extends ASTWrapperPsiElement implements IniProperty {

  public IniPropertyImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull IniVisitor visitor) {
    visitor.visitProperty(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof IniVisitor) accept((IniVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public IniKey getKey() {
    return findNotNullChildByClass(IniKey.class);
  }

  @Override
  @NotNull
  public IniValue getValue() {
    return findNotNullChildByClass(IniValue.class);
  }

  @Override
  public @Nullable String getKeyName() {
    return IniPsiImplUtil.getKeyName(this);
  }

  @Override
  public @Nullable IniKey getKeyElement() {
    return IniPsiImplUtil.getKeyElement(this);
  }

}

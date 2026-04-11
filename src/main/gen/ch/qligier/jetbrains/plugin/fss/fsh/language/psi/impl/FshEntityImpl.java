// This is a generated file. Not intended for manual editing.
package ch.qligier.jetbrains.plugin.fss.fsh.language.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static ch.qligier.jetbrains.plugin.fss.fsh.language.psi.FshTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import ch.qligier.jetbrains.plugin.fss.fsh.language.psi.*;

public class FshEntityImpl extends ASTWrapperPsiElement implements FshEntity {

  public FshEntityImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull FshVisitor visitor) {
    visitor.visitEntity(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof FshVisitor) accept((FshVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public FshAlias getAlias() {
    return findChildByClass(FshAlias.class);
  }

  @Override
  @Nullable
  public FshCodeSystem getCodeSystem() {
    return findChildByClass(FshCodeSystem.class);
  }

  @Override
  @Nullable
  public FshExtension getExtension() {
    return findChildByClass(FshExtension.class);
  }

  @Override
  @Nullable
  public FshInstance getInstance() {
    return findChildByClass(FshInstance.class);
  }

  @Override
  @Nullable
  public FshInvariant getInvariant() {
    return findChildByClass(FshInvariant.class);
  }

  @Override
  @Nullable
  public FshLogical getLogical() {
    return findChildByClass(FshLogical.class);
  }

  @Override
  @Nullable
  public FshMapping getMapping() {
    return findChildByClass(FshMapping.class);
  }

  @Override
  @Nullable
  public FshProfile getProfile() {
    return findChildByClass(FshProfile.class);
  }

  @Override
  @Nullable
  public FshResource getResource() {
    return findChildByClass(FshResource.class);
  }

  @Override
  @Nullable
  public FshRuleSet getRuleSet() {
    return findChildByClass(FshRuleSet.class);
  }

  @Override
  @Nullable
  public FshValueSet getValueSet() {
    return findChildByClass(FshValueSet.class);
  }

}

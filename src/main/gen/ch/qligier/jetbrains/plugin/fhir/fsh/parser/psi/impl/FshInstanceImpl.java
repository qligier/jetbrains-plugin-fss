// This is a generated file. Not intended for manual editing.
package ch.qligier.jetbrains.plugin.fhir.fsh.parser.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static ch.qligier.jetbrains.plugin.fhir.fsh.parser.psi.FshTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import ch.qligier.jetbrains.plugin.fhir.fsh.parser.psi.*;

public class FshInstanceImpl extends ASTWrapperPsiElement implements FshInstance {

  public FshInstanceImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull FshVisitor visitor) {
    visitor.visitInstance(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof FshVisitor) accept((FshVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<FshDescription> getDescriptionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, FshDescription.class);
  }

  @Override
  @NotNull
  public List<FshInstanceOf> getInstanceOfList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, FshInstanceOf.class);
  }

  @Override
  @NotNull
  public List<FshInstanceRule> getInstanceRuleList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, FshInstanceRule.class);
  }

  @Override
  @NotNull
  public List<FshTitle> getTitleList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, FshTitle.class);
  }

  @Override
  @NotNull
  public List<FshUsage> getUsageList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, FshUsage.class);
  }

}

// This is a generated file. Not intended for manual editing.
package ch.qligier.jetbrains.plugin.fhir.fsh.parser.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static ch.qligier.jetbrains.plugin.fhir.fsh.parser.psi.FshTypes.*;
import ch.qligier.jetbrains.plugin.fhir.fsh.parser.psi.*;

public class FshMappingRuleImpl extends FshRuleImpl implements FshMappingRule {

  public FshMappingRuleImpl(@NotNull ASTNode node) {
    super(node);
  }

  @Override
  public void accept(@NotNull FshVisitor visitor) {
    visitor.visitMappingRule(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof FshVisitor) accept((FshVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public FshCode getCode() {
    return findChildByClass(FshCode.class);
  }

  @Override
  @Nullable
  public FshPath getPath() {
    return findChildByClass(FshPath.class);
  }

  @Override
  @NotNull
  public FshRuleStart getRuleStart() {
    return findNotNullChildByClass(FshRuleStart.class);
  }

  @Override
  @NotNull
  public List<FshString> getStringList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, FshString.class);
  }

}

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

public class FshTitleImpl extends FshMetadataImpl implements FshTitle {

  public FshTitleImpl(@NotNull ASTNode node) {
    super(node);
  }

  @Override
  public void accept(@NotNull FshVisitor visitor) {
    visitor.visitTitle(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof FshVisitor) accept((FshVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public FshString getString() {
    return findNotNullChildByClass(FshString.class);
  }

}

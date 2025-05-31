// This is a generated file. Not intended for manual editing.
package ch.qligier.jetbrains.plugin.fss.ig_ini.language.psi;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiElement;

public class IniVisitor extends PsiElementVisitor {

  public void visitKey(@NotNull IniKey o) {
    visitPsiElement(o);
  }

  public void visitProperty(@NotNull IniProperty o) {
    visitPsiElement(o);
  }

  public void visitSection(@NotNull IniSection o) {
    visitPsiElement(o);
  }

  public void visitValue(@NotNull IniValue o) {
    visitPsiElement(o);
  }

  public void visitPsiElement(@NotNull PsiElement o) {
    visitElement(o);
  }

}

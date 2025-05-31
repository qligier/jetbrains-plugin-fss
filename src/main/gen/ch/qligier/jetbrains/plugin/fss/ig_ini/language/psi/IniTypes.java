// This is a generated file. Not intended for manual editing.
package ch.qligier.jetbrains.plugin.fss.ig_ini.language.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import ch.qligier.jetbrains.plugin.fss.ig_ini.language.psi.impl.*;

public interface IniTypes {

  IElementType KEY = new IniElementType("KEY");
  IElementType PROPERTY = new IniElementType("PROPERTY");
  IElementType SECTION = new IniElementType("SECTION");
  IElementType VALUE = new IniElementType("VALUE");

  IElementType COMMENT = new IniTokenType("COMMENT");
  IElementType EQUAL = new IniTokenType("EQUAL");
  IElementType PKEY = new IniTokenType("PKEY");
  IElementType PVALUE = new IniTokenType("PVALUE");
  IElementType SECTION_NAME = new IniTokenType("SECTION_NAME");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == KEY) {
        return new IniKeyImpl(node);
      }
      else if (type == PROPERTY) {
        return new IniPropertyImpl(node);
      }
      else if (type == SECTION) {
        return new IniSectionImpl(node);
      }
      else if (type == VALUE) {
        return new IniValueImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}

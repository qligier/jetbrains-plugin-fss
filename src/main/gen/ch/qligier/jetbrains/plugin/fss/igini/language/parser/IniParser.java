// This is a generated file. Not intended for manual editing.
package ch.qligier.jetbrains.plugin.fss.igini.language.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static ch.qligier.jetbrains.plugin.fss.igini.language.psi.IniTypes.*;
import static ch.qligier.jetbrains.plugin.fss.igini.language.parser.IniParserUtil.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class IniParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    r = parse_root_(t, b);
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b) {
    return parse_root_(t, b, 0);
  }

  static boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return iniFile(b, l + 1);
  }

  /* ********************************************************** */
  // (property|COMMENT)* (section|property|COMMENT)*
  static boolean iniFile(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "iniFile")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = iniFile_0(b, l + 1);
    r = r && iniFile_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (property|COMMENT)*
  private static boolean iniFile_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "iniFile_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!iniFile_0_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "iniFile_0", c)) break;
    }
    return true;
  }

  // property|COMMENT
  private static boolean iniFile_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "iniFile_0_0")) return false;
    boolean r;
    r = property(b, l + 1);
    if (!r) r = consumeToken(b, COMMENT);
    return r;
  }

  // (section|property|COMMENT)*
  private static boolean iniFile_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "iniFile_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!iniFile_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "iniFile_1", c)) break;
    }
    return true;
  }

  // section|property|COMMENT
  private static boolean iniFile_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "iniFile_1_0")) return false;
    boolean r;
    r = section(b, l + 1);
    if (!r) r = property(b, l + 1);
    if (!r) r = consumeToken(b, COMMENT);
    return r;
  }

  /* ********************************************************** */
  // PKEY
  public static boolean key(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "key")) return false;
    if (!nextTokenIs(b, PKEY)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, PKEY);
    exit_section_(b, m, KEY, r);
    return r;
  }

  /* ********************************************************** */
  // key EQUAL value
  public static boolean property(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "property")) return false;
    if (!nextTokenIs(b, PKEY)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = key(b, l + 1);
    r = r && consumeToken(b, EQUAL);
    r = r && value(b, l + 1);
    exit_section_(b, m, PROPERTY, r);
    return r;
  }

  /* ********************************************************** */
  // SECTION_NAME property*
  public static boolean section(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "section")) return false;
    if (!nextTokenIs(b, SECTION_NAME)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SECTION_NAME);
    r = r && section_1(b, l + 1);
    exit_section_(b, m, SECTION, r);
    return r;
  }

  // property*
  private static boolean section_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "section_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!property(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "section_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // PVALUE
  public static boolean value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "value")) return false;
    if (!nextTokenIs(b, PVALUE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, PVALUE);
    exit_section_(b, m, VALUE, r);
    return r;
  }

}

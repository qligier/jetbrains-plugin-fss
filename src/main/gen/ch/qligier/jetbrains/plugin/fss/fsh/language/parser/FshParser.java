// This is a generated file. Not intended for manual editing.
package ch.qligier.jetbrains.plugin.fss.fsh.language.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static ch.qligier.jetbrains.plugin.fss.fsh.language.psi.FshTypes.*;
import static ch.qligier.jetbrains.plugin.fss.fsh.language.parser.FshParserUtil.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class FshParser implements PsiParser, LightPsiParser {

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
    return fshFile(b, l + 1);
  }

  /* ********************************************************** */
  // STAR path cardinality flag* targetType (KW_OR targetType)* (STRING | MULTILINE_STRING)?
  public static boolean addElementRule(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "addElementRule")) return false;
    if (!nextTokenIs(b, STAR)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, ADD_ELEMENT_RULE, null);
    r = consumeToken(b, STAR);
    p = r; // pin = 1
    r = r && report_error_(b, path(b, l + 1));
    r = p && report_error_(b, cardinality(b, l + 1)) && r;
    r = p && report_error_(b, addElementRule_3(b, l + 1)) && r;
    r = p && report_error_(b, targetType(b, l + 1)) && r;
    r = p && report_error_(b, addElementRule_5(b, l + 1)) && r;
    r = p && addElementRule_6(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // flag*
  private static boolean addElementRule_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "addElementRule_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!flag(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "addElementRule_3", c)) break;
    }
    return true;
  }

  // (KW_OR targetType)*
  private static boolean addElementRule_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "addElementRule_5")) return false;
    while (true) {
      int c = current_position_(b);
      if (!addElementRule_5_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "addElementRule_5", c)) break;
    }
    return true;
  }

  // KW_OR targetType
  private static boolean addElementRule_5_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "addElementRule_5_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KW_OR);
    r = r && targetType(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (STRING | MULTILINE_STRING)?
  private static boolean addElementRule_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "addElementRule_6")) return false;
    addElementRule_6_0(b, l + 1);
    return true;
  }

  // STRING | MULTILINE_STRING
  private static boolean addElementRule_6_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "addElementRule_6_0")) return false;
    boolean r;
    r = consumeToken(b, STRING);
    if (!r) r = consumeToken(b, MULTILINE_STRING);
    return r;
  }

  /* ********************************************************** */
  // KW_ALIAS COLON ALIAS_REF EQUALS (URL | IDENTIFIER | SEQUENCE)
  public static boolean alias(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "alias")) return false;
    if (!nextTokenIs(b, KW_ALIAS)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, ALIAS, null);
    r = consumeTokens(b, 1, KW_ALIAS, COLON, ALIAS_REF, EQUALS);
    p = r; // pin = 1
    r = r && alias_4(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // URL | IDENTIFIER | SEQUENCE
  private static boolean alias_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "alias_4")) return false;
    boolean r;
    r = consumeToken(b, URL);
    if (!r) r = consumeToken(b, IDENTIFIER);
    if (!r) r = consumeToken(b, SEQUENCE);
    return r;
  }

  /* ********************************************************** */
  // STAR path KW_FROM nameToken (LPAREN bindingStrength RPAREN)?
  public static boolean bindingRule(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bindingRule")) return false;
    if (!nextTokenIs(b, STAR)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, BINDING_RULE, null);
    r = consumeToken(b, STAR);
    r = r && path(b, l + 1);
    r = r && consumeToken(b, KW_FROM);
    p = r; // pin = 3
    r = r && report_error_(b, nameToken(b, l + 1));
    r = p && bindingRule_4(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // (LPAREN bindingStrength RPAREN)?
  private static boolean bindingRule_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bindingRule_4")) return false;
    bindingRule_4_0(b, l + 1);
    return true;
  }

  // LPAREN bindingStrength RPAREN
  private static boolean bindingRule_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bindingRule_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LPAREN);
    r = r && bindingStrength(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // KW_EXACTLY
  //                   | KW_EXAMPLE
  //                   | KW_EXTENSIBLE
  //                   | KW_PREFERRED
  //                   | KW_REQUIRED
  public static boolean bindingStrength(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bindingStrength")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BINDING_STRENGTH, "<binding strength>");
    r = consumeToken(b, KW_EXACTLY);
    if (!r) r = consumeToken(b, KW_EXAMPLE);
    if (!r) r = consumeToken(b, KW_EXTENSIBLE);
    if (!r) r = consumeToken(b, KW_PREFERRED);
    if (!r) r = consumeToken(b, KW_REQUIRED);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // KW_TRUE | KW_FALSE
  public static boolean booleanValue(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "booleanValue")) return false;
    if (!nextTokenIs(b, "<boolean value>", KW_FALSE, KW_TRUE)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BOOLEAN_VALUE, "<boolean value>");
    r = consumeToken(b, KW_TRUE);
    if (!r) r = consumeToken(b, KW_FALSE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // LBRACKET (nameToken | URL | INTEGER) RBRACKET
  public static boolean bracketSuffix(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bracketSuffix")) return false;
    if (!nextTokenIs(b, LBRACKET)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LBRACKET);
    r = r && bracketSuffix_1(b, l + 1);
    r = r && consumeToken(b, RBRACKET);
    exit_section_(b, m, BRACKET_SUFFIX, r);
    return r;
  }

  // nameToken | URL | INTEGER
  private static boolean bracketSuffix_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bracketSuffix_1")) return false;
    boolean r;
    r = nameToken(b, l + 1);
    if (!r) r = consumeToken(b, URL);
    if (!r) r = consumeToken(b, INTEGER);
    return r;
  }

  /* ********************************************************** */
  // nameToken (PIPE nameToken)?
  public static boolean canonicalTarget(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "canonicalTarget")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CANONICAL_TARGET, "<canonical target>");
    r = nameToken(b, l + 1);
    r = r && canonicalTarget_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (PIPE nameToken)?
  private static boolean canonicalTarget_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "canonicalTarget_1")) return false;
    canonicalTarget_1_0(b, l + 1);
    return true;
  }

  // PIPE nameToken
  private static boolean canonicalTarget_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "canonicalTarget_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, PIPE);
    r = r && nameToken(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // KW_CANONICAL LPAREN canonicalTarget (KW_OR canonicalTarget)* RPAREN
  public static boolean canonicalType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "canonicalType")) return false;
    if (!nextTokenIs(b, KW_CANONICAL)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, KW_CANONICAL, LPAREN);
    r = r && canonicalTarget(b, l + 1);
    r = r && canonicalType_3(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, CANONICAL_TYPE, r);
    return r;
  }

  // (KW_OR canonicalTarget)*
  private static boolean canonicalType_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "canonicalType_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!canonicalType_3_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "canonicalType_3", c)) break;
    }
    return true;
  }

  // KW_OR canonicalTarget
  private static boolean canonicalType_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "canonicalType_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KW_OR);
    r = r && canonicalTarget(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // STAR path cardinality flag*
  public static boolean cardRule(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "cardRule")) return false;
    if (!nextTokenIs(b, STAR)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, CARD_RULE, null);
    r = consumeToken(b, STAR);
    p = r; // pin = 1
    r = r && report_error_(b, path(b, l + 1));
    r = p && report_error_(b, cardinality(b, l + 1)) && r;
    r = p && cardRule_3(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // flag*
  private static boolean cardRule_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "cardRule_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!flag(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "cardRule_3", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // CARDINALITY_TOKEN
  public static boolean cardinality(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "cardinality")) return false;
    if (!nextTokenIs(b, CARDINALITY_TOKEN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, CARDINALITY_TOKEN);
    exit_section_(b, m, CARDINALITY, r);
    return r;
  }

  /* ********************************************************** */
  // STAR path? CARET path EQUALS value
  public static boolean caretValueRule(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "caretValueRule")) return false;
    if (!nextTokenIs(b, STAR)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, CARET_VALUE_RULE, null);
    r = consumeToken(b, STAR);
    r = r && caretValueRule_1(b, l + 1);
    r = r && consumeToken(b, CARET);
    p = r; // pin = 3
    r = r && report_error_(b, path(b, l + 1));
    r = p && report_error_(b, consumeToken(b, EQUALS)) && r;
    r = p && value(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // path?
  private static boolean caretValueRule_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "caretValueRule_1")) return false;
    path(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // KW_CHARACTERISTICS COLON nameToken (COMMA nameToken)*
  public static boolean characteristicsMetadata(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "characteristicsMetadata")) return false;
    if (!nextTokenIs(b, KW_CHARACTERISTICS)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, CHARACTERISTICS_METADATA, null);
    r = consumeTokens(b, 1, KW_CHARACTERISTICS, COLON);
    p = r; // pin = 1
    r = r && report_error_(b, nameToken(b, l + 1));
    r = p && characteristicsMetadata_3(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // (COMMA nameToken)*
  private static boolean characteristicsMetadata_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "characteristicsMetadata_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!characteristicsMetadata_3_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "characteristicsMetadata_3", c)) break;
    }
    return true;
  }

  // COMMA nameToken
  private static boolean characteristicsMetadata_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "characteristicsMetadata_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && nameToken(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // STAR CODE? CARET path EQUALS value
  public static boolean codeCaretValueRule(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "codeCaretValueRule")) return false;
    if (!nextTokenIs(b, STAR)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, CODE_CARET_VALUE_RULE, null);
    r = consumeToken(b, STAR);
    r = r && codeCaretValueRule_1(b, l + 1);
    r = r && consumeToken(b, CARET);
    p = r; // pin = 3
    r = r && report_error_(b, path(b, l + 1));
    r = p && report_error_(b, consumeToken(b, EQUALS)) && r;
    r = p && value(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // CODE?
  private static boolean codeCaretValueRule_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "codeCaretValueRule_1")) return false;
    consumeToken(b, CODE);
    return true;
  }

  /* ********************************************************** */
  // KW_CODESYSTEM COLON nameToken csMetadata* csRule*
  public static boolean codeSystem(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "codeSystem")) return false;
    if (!nextTokenIs(b, KW_CODESYSTEM)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, CODE_SYSTEM, null);
    r = consumeTokens(b, 1, KW_CODESYSTEM, COLON);
    p = r; // pin = 1
    r = r && report_error_(b, nameToken(b, l + 1));
    r = p && report_error_(b, codeSystem_3(b, l + 1)) && r;
    r = p && codeSystem_4(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // csMetadata*
  private static boolean codeSystem_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "codeSystem_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!csMetadata(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "codeSystem_3", c)) break;
    }
    return true;
  }

  // csRule*
  private static boolean codeSystem_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "codeSystem_4")) return false;
    while (true) {
      int c = current_position_(b);
      if (!csRule(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "codeSystem_4", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // (URL | ALIAS_REF | nameToken)? CODE STRING?
  //             | QUOTED_CODE STRING?
  public static boolean codeValue(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "codeValue")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CODE_VALUE, "<code value>");
    r = codeValue_0(b, l + 1);
    if (!r) r = codeValue_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (URL | ALIAS_REF | nameToken)? CODE STRING?
  private static boolean codeValue_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "codeValue_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = codeValue_0_0(b, l + 1);
    r = r && consumeToken(b, CODE);
    r = r && codeValue_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (URL | ALIAS_REF | nameToken)?
  private static boolean codeValue_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "codeValue_0_0")) return false;
    codeValue_0_0_0(b, l + 1);
    return true;
  }

  // URL | ALIAS_REF | nameToken
  private static boolean codeValue_0_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "codeValue_0_0_0")) return false;
    boolean r;
    r = consumeToken(b, URL);
    if (!r) r = consumeToken(b, ALIAS_REF);
    if (!r) r = nameToken(b, l + 1);
    return r;
  }

  // STRING?
  private static boolean codeValue_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "codeValue_0_2")) return false;
    consumeToken(b, STRING);
    return true;
  }

  // QUOTED_CODE STRING?
  private static boolean codeValue_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "codeValue_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, QUOTED_CODE);
    r = r && codeValue_1_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // STRING?
  private static boolean codeValue_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "codeValue_1_1")) return false;
    consumeToken(b, STRING);
    return true;
  }

  /* ********************************************************** */
  // KW_CODEABLE_REF LPAREN nameToken (KW_OR nameToken)* RPAREN
  public static boolean codeableReferenceType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "codeableReferenceType")) return false;
    if (!nextTokenIs(b, KW_CODEABLE_REF)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, KW_CODEABLE_REF, LPAREN);
    r = r && nameToken(b, l + 1);
    r = r && codeableReferenceType_3(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, CODEABLE_REFERENCE_TYPE, r);
    return r;
  }

  // (KW_OR nameToken)*
  private static boolean codeableReferenceType_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "codeableReferenceType_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!codeableReferenceType_3_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "codeableReferenceType_3", c)) break;
    }
    return true;
  }

  // KW_OR nameToken
  private static boolean codeableReferenceType_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "codeableReferenceType_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KW_OR);
    r = r && nameToken(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // STAR CODE (STRING (STRING)?)?
  public static boolean conceptRule(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "conceptRule")) return false;
    if (!nextTokenIs(b, STAR)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, CONCEPT_RULE, null);
    r = consumeTokens(b, 2, STAR, CODE);
    p = r; // pin = 2
    r = r && conceptRule_2(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // (STRING (STRING)?)?
  private static boolean conceptRule_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "conceptRule_2")) return false;
    conceptRule_2_0(b, l + 1);
    return true;
  }

  // STRING (STRING)?
  private static boolean conceptRule_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "conceptRule_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, STRING);
    r = r && conceptRule_2_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (STRING)?
  private static boolean conceptRule_2_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "conceptRule_2_0_1")) return false;
    consumeToken(b, STRING);
    return true;
  }

  /* ********************************************************** */
  // nameToken KW_NAMED nameToken cardinality
  //                | nameToken cardinality
  public static boolean containsItem(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "containsItem")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CONTAINS_ITEM, "<contains item>");
    r = containsItem_0(b, l + 1);
    if (!r) r = containsItem_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // nameToken KW_NAMED nameToken cardinality
  private static boolean containsItem_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "containsItem_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = nameToken(b, l + 1);
    r = r && consumeToken(b, KW_NAMED);
    r = r && nameToken(b, l + 1);
    r = r && cardinality(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // nameToken cardinality
  private static boolean containsItem_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "containsItem_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = nameToken(b, l + 1);
    r = r && cardinality(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // STAR path KW_CONTAINS containsItem (KW_AND containsItem)*
  public static boolean containsRule(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "containsRule")) return false;
    if (!nextTokenIs(b, STAR)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, CONTAINS_RULE, null);
    r = consumeToken(b, STAR);
    r = r && path(b, l + 1);
    r = r && consumeToken(b, KW_CONTAINS);
    p = r; // pin = 3
    r = r && report_error_(b, containsItem(b, l + 1));
    r = p && containsRule_4(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // (KW_AND containsItem)*
  private static boolean containsRule_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "containsRule_4")) return false;
    while (true) {
      int c = current_position_(b);
      if (!containsRule_4_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "containsRule_4", c)) break;
    }
    return true;
  }

  // KW_AND containsItem
  private static boolean containsRule_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "containsRule_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KW_AND);
    r = r && containsItem(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // STRING | nameToken
  public static boolean contextItem(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "contextItem")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CONTEXT_ITEM, "<context item>");
    r = consumeToken(b, STRING);
    if (!r) r = nameToken(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // KW_CONTEXT COLON contextItem (COMMA contextItem)*
  public static boolean contextMetadata(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "contextMetadata")) return false;
    if (!nextTokenIs(b, KW_CONTEXT)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, CONTEXT_METADATA, null);
    r = consumeTokens(b, 1, KW_CONTEXT, COLON);
    p = r; // pin = 1
    r = r && report_error_(b, contextItem(b, l + 1));
    r = p && contextMetadata_3(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // (COMMA contextItem)*
  private static boolean contextMetadata_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "contextMetadata_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!contextMetadata_3_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "contextMetadata_3", c)) break;
    }
    return true;
  }

  // COMMA contextItem
  private static boolean contextMetadata_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "contextMetadata_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && contextItem(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // idMetadata
  //                       | titleMetadata
  //                       | descriptionMetadata
  public static boolean csMetadata(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "csMetadata")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CS_METADATA, "<cs metadata>");
    r = idMetadata(b, l + 1);
    if (!r) r = titleMetadata(b, l + 1);
    if (!r) r = descriptionMetadata(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // conceptRule
  //          | codeCaretValueRule
  //          | insertRule
  public static boolean csRule(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "csRule")) return false;
    if (!nextTokenIs(b, STAR)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = conceptRule(b, l + 1);
    if (!r) r = codeCaretValueRule(b, l + 1);
    if (!r) r = insertRule(b, l + 1);
    exit_section_(b, m, CS_RULE, r);
    return r;
  }

  /* ********************************************************** */
  // DATETIME
  public static boolean dateTimeValue(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dateTimeValue")) return false;
    if (!nextTokenIs(b, DATETIME)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DATETIME);
    exit_section_(b, m, DATE_TIME_VALUE, r);
    return r;
  }

  /* ********************************************************** */
  // DATE
  public static boolean dateValue(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dateValue")) return false;
    if (!nextTokenIs(b, DATE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DATE);
    exit_section_(b, m, DATE_VALUE, r);
    return r;
  }

  /* ********************************************************** */
  // KW_DESCRIPTION COLON (STRING | MULTILINE_STRING)
  public static boolean descriptionMetadata(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "descriptionMetadata")) return false;
    if (!nextTokenIs(b, KW_DESCRIPTION)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, DESCRIPTION_METADATA, null);
    r = consumeTokens(b, 1, KW_DESCRIPTION, COLON);
    p = r; // pin = 1
    r = r && descriptionMetadata_2(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // STRING | MULTILINE_STRING
  private static boolean descriptionMetadata_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "descriptionMetadata_2")) return false;
    boolean r;
    r = consumeToken(b, STRING);
    if (!r) r = consumeToken(b, MULTILINE_STRING);
    return r;
  }

  /* ********************************************************** */
  // alias
  //          | profile
  //          | extension
  //          | resource
  //          | logical
  //          | instance
  //          | valueSet
  //          | codeSystem
  //          | mapping
  //          | ruleSet
  //          | invariant
  public static boolean entity(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "entity")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ENTITY, "<entity>");
    r = alias(b, l + 1);
    if (!r) r = profile(b, l + 1);
    if (!r) r = extension(b, l + 1);
    if (!r) r = resource(b, l + 1);
    if (!r) r = logical(b, l + 1);
    if (!r) r = instance(b, l + 1);
    if (!r) r = valueSet(b, l + 1);
    if (!r) r = codeSystem(b, l + 1);
    if (!r) r = mapping(b, l + 1);
    if (!r) r = ruleSet(b, l + 1);
    if (!r) r = invariant(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // KW_EXPRESSION COLON STRING
  public static boolean expressionMetadata(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expressionMetadata")) return false;
    if (!nextTokenIs(b, KW_EXPRESSION)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, EXPRESSION_METADATA, null);
    r = consumeTokens(b, 1, KW_EXPRESSION, COLON, STRING);
    p = r; // pin = 1
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // KW_EXTENSION COLON nameToken extensionMetadata* sdRule*
  public static boolean extension(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "extension")) return false;
    if (!nextTokenIs(b, KW_EXTENSION)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, EXTENSION, null);
    r = consumeTokens(b, 1, KW_EXTENSION, COLON);
    p = r; // pin = 1
    r = r && report_error_(b, nameToken(b, l + 1));
    r = p && report_error_(b, extension_3(b, l + 1)) && r;
    r = p && extension_4(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // extensionMetadata*
  private static boolean extension_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "extension_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!extensionMetadata(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "extension_3", c)) break;
    }
    return true;
  }

  // sdRule*
  private static boolean extension_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "extension_4")) return false;
    while (true) {
      int c = current_position_(b);
      if (!sdRule(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "extension_4", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // idMetadata
  //                       | parentMetadata
  //                       | titleMetadata
  //                       | descriptionMetadata
  //                       | contextMetadata
  //                       | mixinsMetadata
  public static boolean extensionMetadata(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "extensionMetadata")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, EXTENSION_METADATA, "<extension metadata>");
    r = idMetadata(b, l + 1);
    if (!r) r = parentMetadata(b, l + 1);
    if (!r) r = titleMetadata(b, l + 1);
    if (!r) r = descriptionMetadata(b, l + 1);
    if (!r) r = contextMetadata(b, l + 1);
    if (!r) r = mixinsMetadata(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // STAR path EQUALS value (LPAREN KW_EXACTLY RPAREN)?
  public static boolean fixedValueRule(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fixedValueRule")) return false;
    if (!nextTokenIs(b, STAR)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, FIXED_VALUE_RULE, null);
    r = consumeToken(b, STAR);
    r = r && path(b, l + 1);
    r = r && consumeToken(b, EQUALS);
    p = r; // pin = 3
    r = r && report_error_(b, value(b, l + 1));
    r = p && fixedValueRule_4(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // (LPAREN KW_EXACTLY RPAREN)?
  private static boolean fixedValueRule_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fixedValueRule_4")) return false;
    fixedValueRule_4_0(b, l + 1);
    return true;
  }

  // LPAREN KW_EXACTLY RPAREN
  private static boolean fixedValueRule_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fixedValueRule_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, LPAREN, KW_EXACTLY, RPAREN);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // KW_MS
  //        | KW_SU
  //        | KW_TU
  //        | KW_NORMATIVE
  //        | KW_DRAFT
  //        | KW_MODIFIEREXT
  public static boolean flag(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "flag")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FLAG, "<flag>");
    r = consumeToken(b, KW_MS);
    if (!r) r = consumeToken(b, KW_SU);
    if (!r) r = consumeToken(b, KW_TU);
    if (!r) r = consumeToken(b, KW_NORMATIVE);
    if (!r) r = consumeToken(b, KW_DRAFT);
    if (!r) r = consumeToken(b, KW_MODIFIEREXT);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // STAR path flag (KW_AND flag)*
  public static boolean flagRule(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "flagRule")) return false;
    if (!nextTokenIs(b, STAR)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, FLAG_RULE, null);
    r = consumeToken(b, STAR);
    p = r; // pin = 1
    r = r && report_error_(b, path(b, l + 1));
    r = p && report_error_(b, flag(b, l + 1)) && r;
    r = p && flagRule_3(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // (KW_AND flag)*
  private static boolean flagRule_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "flagRule_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!flagRule_3_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "flagRule_3", c)) break;
    }
    return true;
  }

  // KW_AND flag
  private static boolean flagRule_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "flagRule_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KW_AND);
    r = r && flag(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // item_*
  static boolean fshFile(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fshFile")) return false;
    while (true) {
      int c = current_position_(b);
      if (!item_(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "fshFile", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // KW_ID COLON nameToken
  public static boolean idMetadata(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "idMetadata")) return false;
    if (!nextTokenIs(b, KW_ID)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, ID_METADATA, null);
    r = consumeTokens(b, 1, KW_ID, COLON);
    p = r; // pin = 1
    r = r && nameToken(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // STAR KW_INSERT ruleSetReference
  public static boolean insertRule(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "insertRule")) return false;
    if (!nextTokenIs(b, STAR)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, INSERT_RULE, null);
    r = consumeTokens(b, 2, STAR, KW_INSERT);
    p = r; // pin = 2
    r = r && ruleSetReference(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // KW_INSTANCE COLON nameToken instanceMetadata* instanceRule*
  public static boolean instance(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "instance")) return false;
    if (!nextTokenIs(b, KW_INSTANCE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, INSTANCE, null);
    r = consumeTokens(b, 1, KW_INSTANCE, COLON);
    p = r; // pin = 1
    r = r && report_error_(b, nameToken(b, l + 1));
    r = p && report_error_(b, instance_3(b, l + 1)) && r;
    r = p && instance_4(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // instanceMetadata*
  private static boolean instance_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "instance_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!instanceMetadata(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "instance_3", c)) break;
    }
    return true;
  }

  // instanceRule*
  private static boolean instance_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "instance_4")) return false;
    while (true) {
      int c = current_position_(b);
      if (!instanceRule(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "instance_4", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // idMetadata
  //                       | instanceOfMetadata
  //                       | titleMetadata
  //                       | descriptionMetadata
  //                       | usageMetadata
  public static boolean instanceMetadata(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "instanceMetadata")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, INSTANCE_METADATA, "<instance metadata>");
    r = idMetadata(b, l + 1);
    if (!r) r = instanceOfMetadata(b, l + 1);
    if (!r) r = titleMetadata(b, l + 1);
    if (!r) r = descriptionMetadata(b, l + 1);
    if (!r) r = usageMetadata(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // KW_INSTANCEOF COLON nameToken
  public static boolean instanceOfMetadata(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "instanceOfMetadata")) return false;
    if (!nextTokenIs(b, KW_INSTANCEOF)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, INSTANCE_OF_METADATA, null);
    r = consumeTokens(b, 1, KW_INSTANCEOF, COLON);
    p = r; // pin = 1
    r = r && nameToken(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // fixedValueRule
  //                | insertRule
  //                | pathRule
  public static boolean instanceRule(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "instanceRule")) return false;
    if (!nextTokenIs(b, STAR)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = fixedValueRule(b, l + 1);
    if (!r) r = insertRule(b, l + 1);
    if (!r) r = pathRule(b, l + 1);
    exit_section_(b, m, INSTANCE_RULE, r);
    return r;
  }

  /* ********************************************************** */
  // KW_INVARIANT COLON nameToken invariantMetadata*
  public static boolean invariant(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "invariant")) return false;
    if (!nextTokenIs(b, KW_INVARIANT)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, INVARIANT, null);
    r = consumeTokens(b, 1, KW_INVARIANT, COLON);
    p = r; // pin = 1
    r = r && report_error_(b, nameToken(b, l + 1));
    r = p && invariant_3(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // invariantMetadata*
  private static boolean invariant_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "invariant_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!invariantMetadata(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "invariant_3", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // descriptionMetadata
  //                       | expressionMetadata
  //                       | xpathMetadata
  //                       | severityMetadata
  public static boolean invariantMetadata(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "invariantMetadata")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, INVARIANT_METADATA, "<invariant metadata>");
    r = descriptionMetadata(b, l + 1);
    if (!r) r = expressionMetadata(b, l + 1);
    if (!r) r = xpathMetadata(b, l + 1);
    if (!r) r = severityMetadata(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // entity | LINE_COMMENT | BLOCK_COMMENT
  static boolean item_(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "item_")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_);
    r = entity(b, l + 1);
    if (!r) r = consumeToken(b, LINE_COMMENT);
    if (!r) r = consumeToken(b, BLOCK_COMMENT);
    exit_section_(b, l, m, r, false, FshParser::item_recover_);
    return r;
  }

  /* ********************************************************** */
  // !(KW_ALIAS | KW_PROFILE | KW_EXTENSION | KW_RESOURCE | KW_LOGICAL
  //                            | KW_INSTANCE | KW_VALUESET | KW_CODESYSTEM | KW_MAPPING | KW_RULESET
  //                            | KW_INVARIANT | <<eof>>)
  static boolean item_recover_(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "item_recover_")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !item_recover__0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // KW_ALIAS | KW_PROFILE | KW_EXTENSION | KW_RESOURCE | KW_LOGICAL
  //                            | KW_INSTANCE | KW_VALUESET | KW_CODESYSTEM | KW_MAPPING | KW_RULESET
  //                            | KW_INVARIANT | <<eof>>
  private static boolean item_recover__0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "item_recover__0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KW_ALIAS);
    if (!r) r = consumeToken(b, KW_PROFILE);
    if (!r) r = consumeToken(b, KW_EXTENSION);
    if (!r) r = consumeToken(b, KW_RESOURCE);
    if (!r) r = consumeToken(b, KW_LOGICAL);
    if (!r) r = consumeToken(b, KW_INSTANCE);
    if (!r) r = consumeToken(b, KW_VALUESET);
    if (!r) r = consumeToken(b, KW_CODESYSTEM);
    if (!r) r = consumeToken(b, KW_MAPPING);
    if (!r) r = consumeToken(b, KW_RULESET);
    if (!r) r = consumeToken(b, KW_INVARIANT);
    if (!r) r = eof(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // KW_LOGICAL COLON nameToken logicalMetadata* sdRule*
  public static boolean logical(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "logical")) return false;
    if (!nextTokenIs(b, KW_LOGICAL)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, LOGICAL, null);
    r = consumeTokens(b, 1, KW_LOGICAL, COLON);
    p = r; // pin = 1
    r = r && report_error_(b, nameToken(b, l + 1));
    r = p && report_error_(b, logical_3(b, l + 1)) && r;
    r = p && logical_4(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // logicalMetadata*
  private static boolean logical_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "logical_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!logicalMetadata(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "logical_3", c)) break;
    }
    return true;
  }

  // sdRule*
  private static boolean logical_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "logical_4")) return false;
    while (true) {
      int c = current_position_(b);
      if (!sdRule(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "logical_4", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // idMetadata
  //                       | parentMetadata
  //                       | titleMetadata
  //                       | descriptionMetadata
  //                       | characteristicsMetadata
  //                       | mixinsMetadata
  public static boolean logicalMetadata(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "logicalMetadata")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, LOGICAL_METADATA, "<logical metadata>");
    r = idMetadata(b, l + 1);
    if (!r) r = parentMetadata(b, l + 1);
    if (!r) r = titleMetadata(b, l + 1);
    if (!r) r = descriptionMetadata(b, l + 1);
    if (!r) r = characteristicsMetadata(b, l + 1);
    if (!r) r = mixinsMetadata(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // KW_MAPPING COLON nameToken mappingEntityMetadata* mappingRule*
  public static boolean mapping(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "mapping")) return false;
    if (!nextTokenIs(b, KW_MAPPING)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, MAPPING, null);
    r = consumeTokens(b, 1, KW_MAPPING, COLON);
    p = r; // pin = 1
    r = r && report_error_(b, nameToken(b, l + 1));
    r = p && report_error_(b, mapping_3(b, l + 1)) && r;
    r = p && mapping_4(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // mappingEntityMetadata*
  private static boolean mapping_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "mapping_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!mappingEntityMetadata(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "mapping_3", c)) break;
    }
    return true;
  }

  // mappingRule*
  private static boolean mapping_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "mapping_4")) return false;
    while (true) {
      int c = current_position_(b);
      if (!mappingRule(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "mapping_4", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // idMetadata
  //                         | sourceMetadata
  //                         | targetMetadata
  //                         | titleMetadata
  //                         | descriptionMetadata
  public static boolean mappingEntityMetadata(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "mappingEntityMetadata")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, MAPPING_ENTITY_METADATA, "<mapping entity metadata>");
    r = idMetadata(b, l + 1);
    if (!r) r = sourceMetadata(b, l + 1);
    if (!r) r = targetMetadata(b, l + 1);
    if (!r) r = titleMetadata(b, l + 1);
    if (!r) r = descriptionMetadata(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // STAR path? ARROW STRING (STRING | MULTILINE_STRING)? (CODE | QUOTED_CODE)?
  public static boolean mappingEntityRule(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "mappingEntityRule")) return false;
    if (!nextTokenIs(b, STAR)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, MAPPING_ENTITY_RULE, null);
    r = consumeToken(b, STAR);
    r = r && mappingEntityRule_1(b, l + 1);
    r = r && consumeTokens(b, 1, ARROW, STRING);
    p = r; // pin = 3
    r = r && report_error_(b, mappingEntityRule_4(b, l + 1));
    r = p && mappingEntityRule_5(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // path?
  private static boolean mappingEntityRule_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "mappingEntityRule_1")) return false;
    path(b, l + 1);
    return true;
  }

  // (STRING | MULTILINE_STRING)?
  private static boolean mappingEntityRule_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "mappingEntityRule_4")) return false;
    mappingEntityRule_4_0(b, l + 1);
    return true;
  }

  // STRING | MULTILINE_STRING
  private static boolean mappingEntityRule_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "mappingEntityRule_4_0")) return false;
    boolean r;
    r = consumeToken(b, STRING);
    if (!r) r = consumeToken(b, MULTILINE_STRING);
    return r;
  }

  // (CODE | QUOTED_CODE)?
  private static boolean mappingEntityRule_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "mappingEntityRule_5")) return false;
    mappingEntityRule_5_0(b, l + 1);
    return true;
  }

  // CODE | QUOTED_CODE
  private static boolean mappingEntityRule_5_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "mappingEntityRule_5_0")) return false;
    boolean r;
    r = consumeToken(b, CODE);
    if (!r) r = consumeToken(b, QUOTED_CODE);
    return r;
  }

  /* ********************************************************** */
  // mappingEntityRule
  //               | insertRule
  public static boolean mappingRule(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "mappingRule")) return false;
    if (!nextTokenIs(b, STAR)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = mappingEntityRule(b, l + 1);
    if (!r) r = insertRule(b, l + 1);
    exit_section_(b, m, MAPPING_RULE, r);
    return r;
  }

  /* ********************************************************** */
  // KW_MIXINS COLON nameToken (COMMA nameToken)*
  public static boolean mixinsMetadata(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "mixinsMetadata")) return false;
    if (!nextTokenIs(b, KW_MIXINS)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, MIXINS_METADATA, null);
    r = consumeTokens(b, 1, KW_MIXINS, COLON);
    p = r; // pin = 1
    r = r && report_error_(b, nameToken(b, l + 1));
    r = p && mixinsMetadata_3(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // (COMMA nameToken)*
  private static boolean mixinsMetadata_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "mixinsMetadata_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!mixinsMetadata_3_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "mixinsMetadata_3", c)) break;
    }
    return true;
  }

  // COMMA nameToken
  private static boolean mixinsMetadata_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "mixinsMetadata_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && nameToken(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER | SEQUENCE | ALIAS_REF | URL
  public static boolean nameToken(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nameToken")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, NAME_TOKEN, "<name token>");
    r = consumeToken(b, IDENTIFIER);
    if (!r) r = consumeToken(b, SEQUENCE);
    if (!r) r = consumeToken(b, ALIAS_REF);
    if (!r) r = consumeToken(b, URL);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // STAR path? KW_OBEYS nameToken (KW_AND nameToken)*
  public static boolean obeysRule(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "obeysRule")) return false;
    if (!nextTokenIs(b, STAR)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, OBEYS_RULE, null);
    r = consumeToken(b, STAR);
    r = r && obeysRule_1(b, l + 1);
    r = r && consumeToken(b, KW_OBEYS);
    p = r; // pin = 3
    r = r && report_error_(b, nameToken(b, l + 1));
    r = p && obeysRule_4(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // path?
  private static boolean obeysRule_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "obeysRule_1")) return false;
    path(b, l + 1);
    return true;
  }

  // (KW_AND nameToken)*
  private static boolean obeysRule_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "obeysRule_4")) return false;
    while (true) {
      int c = current_position_(b);
      if (!obeysRule_4_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "obeysRule_4", c)) break;
    }
    return true;
  }

  // KW_AND nameToken
  private static boolean obeysRule_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "obeysRule_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KW_AND);
    r = r && nameToken(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // STAR path KW_ONLY targetType (KW_OR targetType)*
  public static boolean onlyRule(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "onlyRule")) return false;
    if (!nextTokenIs(b, STAR)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, ONLY_RULE, null);
    r = consumeToken(b, STAR);
    r = r && path(b, l + 1);
    r = r && consumeToken(b, KW_ONLY);
    p = r; // pin = 3
    r = r && report_error_(b, targetType(b, l + 1));
    r = p && onlyRule_4(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // (KW_OR targetType)*
  private static boolean onlyRule_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "onlyRule_4")) return false;
    while (true) {
      int c = current_position_(b);
      if (!onlyRule_4_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "onlyRule_4", c)) break;
    }
    return true;
  }

  // KW_OR targetType
  private static boolean onlyRule_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "onlyRule_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KW_OR);
    r = r && targetType(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // KW_PARENT COLON nameToken
  public static boolean parentMetadata(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parentMetadata")) return false;
    if (!nextTokenIs(b, KW_PARENT)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, PARENT_METADATA, null);
    r = consumeTokens(b, 1, KW_PARENT, COLON);
    p = r; // pin = 1
    r = r && nameToken(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // pathPart (DOT pathPart)*
  public static boolean path(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "path")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PATH, "<path>");
    r = pathPart(b, l + 1);
    r = r && path_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (DOT pathPart)*
  private static boolean path_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "path_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!path_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "path_1", c)) break;
    }
    return true;
  }

  // DOT pathPart
  private static boolean path_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "path_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DOT);
    r = r && pathPart(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // nameToken bracketSuffix?
  public static boolean pathPart(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pathPart")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PATH_PART, "<path part>");
    r = nameToken(b, l + 1);
    r = r && pathPart_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // bracketSuffix?
  private static boolean pathPart_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pathPart_1")) return false;
    bracketSuffix(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // STAR path
  public static boolean pathRule(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pathRule")) return false;
    if (!nextTokenIs(b, STAR)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, PATH_RULE, null);
    r = consumeToken(b, STAR);
    p = r; // pin = 1
    r = r && path(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // KW_PROFILE COLON nameToken profileMetadata* sdRule*
  public static boolean profile(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "profile")) return false;
    if (!nextTokenIs(b, KW_PROFILE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, PROFILE, null);
    r = consumeTokens(b, 1, KW_PROFILE, COLON);
    p = r; // pin = 1
    r = r && report_error_(b, nameToken(b, l + 1));
    r = p && report_error_(b, profile_3(b, l + 1)) && r;
    r = p && profile_4(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // profileMetadata*
  private static boolean profile_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "profile_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!profileMetadata(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "profile_3", c)) break;
    }
    return true;
  }

  // sdRule*
  private static boolean profile_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "profile_4")) return false;
    while (true) {
      int c = current_position_(b);
      if (!sdRule(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "profile_4", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // idMetadata
  //                       | parentMetadata
  //                       | titleMetadata
  //                       | descriptionMetadata
  //                       | mixinsMetadata
  public static boolean profileMetadata(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "profileMetadata")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PROFILE_METADATA, "<profile metadata>");
    r = idMetadata(b, l + 1);
    if (!r) r = parentMetadata(b, l + 1);
    if (!r) r = titleMetadata(b, l + 1);
    if (!r) r = descriptionMetadata(b, l + 1);
    if (!r) r = mixinsMetadata(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // (INTEGER | DECIMAL) (UCUM_UNIT | codeValue)
  public static boolean quantity(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "quantity")) return false;
    if (!nextTokenIs(b, "<quantity>", DECIMAL, INTEGER)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, QUANTITY, "<quantity>");
    r = quantity_0(b, l + 1);
    r = r && quantity_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // INTEGER | DECIMAL
  private static boolean quantity_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "quantity_0")) return false;
    boolean r;
    r = consumeToken(b, INTEGER);
    if (!r) r = consumeToken(b, DECIMAL);
    return r;
  }

  // UCUM_UNIT | codeValue
  private static boolean quantity_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "quantity_1")) return false;
    boolean r;
    r = consumeToken(b, UCUM_UNIT);
    if (!r) r = codeValue(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // quantity COLON quantity
  public static boolean ratioValue(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ratioValue")) return false;
    if (!nextTokenIs(b, "<ratio value>", DECIMAL, INTEGER)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, RATIO_VALUE, "<ratio value>");
    r = quantity(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && quantity(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // KW_REFERENCE LPAREN nameToken (KW_OR nameToken)* RPAREN
  public static boolean referenceType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "referenceType")) return false;
    if (!nextTokenIs(b, KW_REFERENCE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, KW_REFERENCE, LPAREN);
    r = r && nameToken(b, l + 1);
    r = r && referenceType_3(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, REFERENCE_TYPE, r);
    return r;
  }

  // (KW_OR nameToken)*
  private static boolean referenceType_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "referenceType_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!referenceType_3_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "referenceType_3", c)) break;
    }
    return true;
  }

  // KW_OR nameToken
  private static boolean referenceType_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "referenceType_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KW_OR);
    r = r && nameToken(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // KW_RESOURCE COLON nameToken resourceMetadata* sdRule*
  public static boolean resource(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "resource")) return false;
    if (!nextTokenIs(b, KW_RESOURCE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, RESOURCE, null);
    r = consumeTokens(b, 1, KW_RESOURCE, COLON);
    p = r; // pin = 1
    r = r && report_error_(b, nameToken(b, l + 1));
    r = p && report_error_(b, resource_3(b, l + 1)) && r;
    r = p && resource_4(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // resourceMetadata*
  private static boolean resource_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "resource_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!resourceMetadata(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "resource_3", c)) break;
    }
    return true;
  }

  // sdRule*
  private static boolean resource_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "resource_4")) return false;
    while (true) {
      int c = current_position_(b);
      if (!sdRule(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "resource_4", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // idMetadata
  //                       | parentMetadata
  //                       | titleMetadata
  //                       | descriptionMetadata
  //                       | mixinsMetadata
  public static boolean resourceMetadata(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "resourceMetadata")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, RESOURCE_METADATA, "<resource metadata>");
    r = idMetadata(b, l + 1);
    if (!r) r = parentMetadata(b, l + 1);
    if (!r) r = titleMetadata(b, l + 1);
    if (!r) r = descriptionMetadata(b, l + 1);
    if (!r) r = mixinsMetadata(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // KW_RULESET COLON ruleSetId ruleSetRule*
  public static boolean ruleSet(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ruleSet")) return false;
    if (!nextTokenIs(b, KW_RULESET)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, RULE_SET, null);
    r = consumeTokens(b, 1, KW_RULESET, COLON);
    p = r; // pin = 1
    r = r && report_error_(b, ruleSetId(b, l + 1));
    r = p && ruleSet_3(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // ruleSetRule*
  private static boolean ruleSet_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ruleSet_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!ruleSetRule(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "ruleSet_3", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // (IDENTIFIER | SEQUENCE | STRING | CODE | QUOTED_CODE | STAR | DOT | EQUALS
  //                       | COLON | COMMA | LPAREN | RPAREN | LBRACKET | RBRACKET | URL | ALIAS_REF
  //                       | INTEGER | DECIMAL | CARDINALITY_TOKEN | UCUM_UNIT
  //                       | KW_AND | KW_OR | KW_FROM | KW_ONLY | KW_CONTAINS
  //                       | KW_NAMED | KW_OBEYS | KW_TRUE | KW_FALSE
  //                       | KW_MS | KW_SU | KW_TU | KW_NORMATIVE | KW_DRAFT
  //                       | KW_REFERENCE | KW_CANONICAL | KW_CODEABLE_REF
  //                       | CARET | ARROW | PIPE | PLUS)*
  public static boolean ruleSetArgContent(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ruleSetArgContent")) return false;
    Marker m = enter_section_(b, l, _NONE_, RULE_SET_ARG_CONTENT, "<rule set arg content>");
    while (true) {
      int c = current_position_(b);
      if (!ruleSetArgContent_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "ruleSetArgContent", c)) break;
    }
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  // IDENTIFIER | SEQUENCE | STRING | CODE | QUOTED_CODE | STAR | DOT | EQUALS
  //                       | COLON | COMMA | LPAREN | RPAREN | LBRACKET | RBRACKET | URL | ALIAS_REF
  //                       | INTEGER | DECIMAL | CARDINALITY_TOKEN | UCUM_UNIT
  //                       | KW_AND | KW_OR | KW_FROM | KW_ONLY | KW_CONTAINS
  //                       | KW_NAMED | KW_OBEYS | KW_TRUE | KW_FALSE
  //                       | KW_MS | KW_SU | KW_TU | KW_NORMATIVE | KW_DRAFT
  //                       | KW_REFERENCE | KW_CANONICAL | KW_CODEABLE_REF
  //                       | CARET | ARROW | PIPE | PLUS
  private static boolean ruleSetArgContent_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ruleSetArgContent_0")) return false;
    boolean r;
    r = consumeToken(b, IDENTIFIER);
    if (!r) r = consumeToken(b, SEQUENCE);
    if (!r) r = consumeToken(b, STRING);
    if (!r) r = consumeToken(b, CODE);
    if (!r) r = consumeToken(b, QUOTED_CODE);
    if (!r) r = consumeToken(b, STAR);
    if (!r) r = consumeToken(b, DOT);
    if (!r) r = consumeToken(b, EQUALS);
    if (!r) r = consumeToken(b, COLON);
    if (!r) r = consumeToken(b, COMMA);
    if (!r) r = consumeToken(b, LPAREN);
    if (!r) r = consumeToken(b, RPAREN);
    if (!r) r = consumeToken(b, LBRACKET);
    if (!r) r = consumeToken(b, RBRACKET);
    if (!r) r = consumeToken(b, URL);
    if (!r) r = consumeToken(b, ALIAS_REF);
    if (!r) r = consumeToken(b, INTEGER);
    if (!r) r = consumeToken(b, DECIMAL);
    if (!r) r = consumeToken(b, CARDINALITY_TOKEN);
    if (!r) r = consumeToken(b, UCUM_UNIT);
    if (!r) r = consumeToken(b, KW_AND);
    if (!r) r = consumeToken(b, KW_OR);
    if (!r) r = consumeToken(b, KW_FROM);
    if (!r) r = consumeToken(b, KW_ONLY);
    if (!r) r = consumeToken(b, KW_CONTAINS);
    if (!r) r = consumeToken(b, KW_NAMED);
    if (!r) r = consumeToken(b, KW_OBEYS);
    if (!r) r = consumeToken(b, KW_TRUE);
    if (!r) r = consumeToken(b, KW_FALSE);
    if (!r) r = consumeToken(b, KW_MS);
    if (!r) r = consumeToken(b, KW_SU);
    if (!r) r = consumeToken(b, KW_TU);
    if (!r) r = consumeToken(b, KW_NORMATIVE);
    if (!r) r = consumeToken(b, KW_DRAFT);
    if (!r) r = consumeToken(b, KW_REFERENCE);
    if (!r) r = consumeToken(b, KW_CANONICAL);
    if (!r) r = consumeToken(b, KW_CODEABLE_REF);
    if (!r) r = consumeToken(b, CARET);
    if (!r) r = consumeToken(b, ARROW);
    if (!r) r = consumeToken(b, PIPE);
    if (!r) r = consumeToken(b, PLUS);
    return r;
  }

  /* ********************************************************** */
  // DBL_LBRACKET ruleSetArgContent DBL_RBRACKET
  //                   | value
  public static boolean ruleSetArgument(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ruleSetArgument")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, RULE_SET_ARGUMENT, "<rule set argument>");
    r = ruleSetArgument_0(b, l + 1);
    if (!r) r = value(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // DBL_LBRACKET ruleSetArgContent DBL_RBRACKET
  private static boolean ruleSetArgument_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ruleSetArgument_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DBL_LBRACKET);
    r = r && ruleSetArgContent(b, l + 1);
    r = r && consumeToken(b, DBL_RBRACKET);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // nameToken (LPAREN ruleSetParam (COMMA ruleSetParam)* RPAREN)?
  public static boolean ruleSetId(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ruleSetId")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, RULE_SET_ID, "<rule set id>");
    r = nameToken(b, l + 1);
    r = r && ruleSetId_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (LPAREN ruleSetParam (COMMA ruleSetParam)* RPAREN)?
  private static boolean ruleSetId_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ruleSetId_1")) return false;
    ruleSetId_1_0(b, l + 1);
    return true;
  }

  // LPAREN ruleSetParam (COMMA ruleSetParam)* RPAREN
  private static boolean ruleSetId_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ruleSetId_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LPAREN);
    r = r && ruleSetParam(b, l + 1);
    r = r && ruleSetId_1_0_2(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA ruleSetParam)*
  private static boolean ruleSetId_1_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ruleSetId_1_0_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!ruleSetId_1_0_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "ruleSetId_1_0_2", c)) break;
    }
    return true;
  }

  // COMMA ruleSetParam
  private static boolean ruleSetId_1_0_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ruleSetId_1_0_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && ruleSetParam(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // nameToken
  public static boolean ruleSetParam(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ruleSetParam")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, RULE_SET_PARAM, "<rule set param>");
    r = nameToken(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // nameToken (LPAREN ruleSetArgument (COMMA ruleSetArgument)* RPAREN)?
  public static boolean ruleSetReference(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ruleSetReference")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, RULE_SET_REFERENCE, "<rule set reference>");
    r = nameToken(b, l + 1);
    r = r && ruleSetReference_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (LPAREN ruleSetArgument (COMMA ruleSetArgument)* RPAREN)?
  private static boolean ruleSetReference_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ruleSetReference_1")) return false;
    ruleSetReference_1_0(b, l + 1);
    return true;
  }

  // LPAREN ruleSetArgument (COMMA ruleSetArgument)* RPAREN
  private static boolean ruleSetReference_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ruleSetReference_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LPAREN);
    r = r && ruleSetArgument(b, l + 1);
    r = r && ruleSetReference_1_0_2(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA ruleSetArgument)*
  private static boolean ruleSetReference_1_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ruleSetReference_1_0_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!ruleSetReference_1_0_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "ruleSetReference_1_0_2", c)) break;
    }
    return true;
  }

  // COMMA ruleSetArgument
  private static boolean ruleSetReference_1_0_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ruleSetReference_1_0_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && ruleSetArgument(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // caretValueRule
  //               | codeCaretValueRule
  //               | bindingRule
  //               | obeysRule
  //               | onlyRule
  //               | containsRule
  //               | insertRule
  //               | addElementRule
  //               | mappingEntityRule
  //               | cardRule
  //               | flagRule
  //               | fixedValueRule
  //               | vsComponent
  //               | conceptRule
  //               | pathRule
  public static boolean ruleSetRule(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ruleSetRule")) return false;
    if (!nextTokenIs(b, STAR)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = caretValueRule(b, l + 1);
    if (!r) r = codeCaretValueRule(b, l + 1);
    if (!r) r = bindingRule(b, l + 1);
    if (!r) r = obeysRule(b, l + 1);
    if (!r) r = onlyRule(b, l + 1);
    if (!r) r = containsRule(b, l + 1);
    if (!r) r = insertRule(b, l + 1);
    if (!r) r = addElementRule(b, l + 1);
    if (!r) r = mappingEntityRule(b, l + 1);
    if (!r) r = cardRule(b, l + 1);
    if (!r) r = flagRule(b, l + 1);
    if (!r) r = fixedValueRule(b, l + 1);
    if (!r) r = vsComponent(b, l + 1);
    if (!r) r = conceptRule(b, l + 1);
    if (!r) r = pathRule(b, l + 1);
    exit_section_(b, m, RULE_SET_RULE, r);
    return r;
  }

  /* ********************************************************** */
  // caretValueRule
  //          | bindingRule
  //          | obeysRule
  //          | onlyRule
  //          | containsRule
  //          | insertRule
  //          | addElementRule
  //          | cardRule
  //          | flagRule
  //          | fixedValueRule
  //          | pathRule
  public static boolean sdRule(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sdRule")) return false;
    if (!nextTokenIs(b, STAR)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = caretValueRule(b, l + 1);
    if (!r) r = bindingRule(b, l + 1);
    if (!r) r = obeysRule(b, l + 1);
    if (!r) r = onlyRule(b, l + 1);
    if (!r) r = containsRule(b, l + 1);
    if (!r) r = insertRule(b, l + 1);
    if (!r) r = addElementRule(b, l + 1);
    if (!r) r = cardRule(b, l + 1);
    if (!r) r = flagRule(b, l + 1);
    if (!r) r = fixedValueRule(b, l + 1);
    if (!r) r = pathRule(b, l + 1);
    exit_section_(b, m, SD_RULE, r);
    return r;
  }

  /* ********************************************************** */
  // KW_SEVERITY COLON (codeValue | nameToken)
  public static boolean severityMetadata(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "severityMetadata")) return false;
    if (!nextTokenIs(b, KW_SEVERITY)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, SEVERITY_METADATA, null);
    r = consumeTokens(b, 1, KW_SEVERITY, COLON);
    p = r; // pin = 1
    r = r && severityMetadata_2(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // codeValue | nameToken
  private static boolean severityMetadata_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "severityMetadata_2")) return false;
    boolean r;
    r = codeValue(b, l + 1);
    if (!r) r = nameToken(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // KW_SOURCE COLON nameToken
  public static boolean sourceMetadata(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sourceMetadata")) return false;
    if (!nextTokenIs(b, KW_SOURCE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, SOURCE_METADATA, null);
    r = consumeTokens(b, 1, KW_SOURCE, COLON);
    p = r; // pin = 1
    r = r && nameToken(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // KW_TARGET COLON (STRING | URL | nameToken)
  public static boolean targetMetadata(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "targetMetadata")) return false;
    if (!nextTokenIs(b, KW_TARGET)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, TARGET_METADATA, null);
    r = consumeTokens(b, 1, KW_TARGET, COLON);
    p = r; // pin = 1
    r = r && targetMetadata_2(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // STRING | URL | nameToken
  private static boolean targetMetadata_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "targetMetadata_2")) return false;
    boolean r;
    r = consumeToken(b, STRING);
    if (!r) r = consumeToken(b, URL);
    if (!r) r = nameToken(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // referenceType
  //              | canonicalType
  //              | codeableReferenceType
  //              | nameToken
  public static boolean targetType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "targetType")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TARGET_TYPE, "<target type>");
    r = referenceType(b, l + 1);
    if (!r) r = canonicalType(b, l + 1);
    if (!r) r = codeableReferenceType(b, l + 1);
    if (!r) r = nameToken(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // TIME
  public static boolean timeValue(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "timeValue")) return false;
    if (!nextTokenIs(b, TIME)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, TIME);
    exit_section_(b, m, TIME_VALUE, r);
    return r;
  }

  /* ********************************************************** */
  // KW_TITLE COLON STRING
  public static boolean titleMetadata(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "titleMetadata")) return false;
    if (!nextTokenIs(b, KW_TITLE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, TITLE_METADATA, null);
    r = consumeTokens(b, 1, KW_TITLE, COLON, STRING);
    p = r; // pin = 1
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // KW_USAGE COLON (codeValue | nameToken)
  public static boolean usageMetadata(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "usageMetadata")) return false;
    if (!nextTokenIs(b, KW_USAGE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, USAGE_METADATA, null);
    r = consumeTokens(b, 1, KW_USAGE, COLON);
    p = r; // pin = 1
    r = r && usageMetadata_2(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // codeValue | nameToken
  private static boolean usageMetadata_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "usageMetadata_2")) return false;
    boolean r;
    r = codeValue(b, l + 1);
    if (!r) r = nameToken(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // MULTILINE_STRING
  //         | STRING
  //         | booleanValue
  //         | quantity
  //         | dateTimeValue
  //         | dateValue
  //         | timeValue
  //         | codeValue
  //         | referenceType
  //         | canonicalType
  //         | codeableReferenceType
  //         | ratioValue
  //         | DECIMAL
  //         | INTEGER
  //         | URL
  //         | ALIAS_REF
  //         | nameToken
  public static boolean value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "value")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, VALUE, "<value>");
    r = consumeToken(b, MULTILINE_STRING);
    if (!r) r = consumeToken(b, STRING);
    if (!r) r = booleanValue(b, l + 1);
    if (!r) r = quantity(b, l + 1);
    if (!r) r = dateTimeValue(b, l + 1);
    if (!r) r = dateValue(b, l + 1);
    if (!r) r = timeValue(b, l + 1);
    if (!r) r = codeValue(b, l + 1);
    if (!r) r = referenceType(b, l + 1);
    if (!r) r = canonicalType(b, l + 1);
    if (!r) r = codeableReferenceType(b, l + 1);
    if (!r) r = ratioValue(b, l + 1);
    if (!r) r = consumeToken(b, DECIMAL);
    if (!r) r = consumeToken(b, INTEGER);
    if (!r) r = consumeToken(b, URL);
    if (!r) r = consumeToken(b, ALIAS_REF);
    if (!r) r = nameToken(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // KW_VALUESET COLON nameToken vsMetadata* vsRule*
  public static boolean valueSet(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "valueSet")) return false;
    if (!nextTokenIs(b, KW_VALUESET)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, VALUE_SET, null);
    r = consumeTokens(b, 1, KW_VALUESET, COLON);
    p = r; // pin = 1
    r = r && report_error_(b, nameToken(b, l + 1));
    r = p && report_error_(b, valueSet_3(b, l + 1)) && r;
    r = p && valueSet_4(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // vsMetadata*
  private static boolean valueSet_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "valueSet_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!vsMetadata(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "valueSet_3", c)) break;
    }
    return true;
  }

  // vsRule*
  private static boolean valueSet_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "valueSet_4")) return false;
    while (true) {
      int c = current_position_(b);
      if (!vsRule(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "valueSet_4", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // STAR (vsConceptComponent | vsFilterComponent)
  public static boolean vsComponent(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "vsComponent")) return false;
    if (!nextTokenIs(b, STAR)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, VS_COMPONENT, null);
    r = consumeToken(b, STAR);
    p = r; // pin = 1
    r = r && vsComponent_1(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // vsConceptComponent | vsFilterComponent
  private static boolean vsComponent_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "vsComponent_1")) return false;
    boolean r;
    r = vsConceptComponent(b, l + 1);
    if (!r) r = vsFilterComponent(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // vsFromSystem KW_AND vsFromValueSets
  //                    | vsFromValueSets KW_AND vsFromSystem
  //                    | vsFromSystem
  //                    | vsFromValueSets
  public static boolean vsComponentFrom(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "vsComponentFrom")) return false;
    if (!nextTokenIs(b, "<vs component from>", KW_SYSTEM, KW_VS_VALUESET)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, VS_COMPONENT_FROM, "<vs component from>");
    r = vsComponentFrom_0(b, l + 1);
    if (!r) r = vsComponentFrom_1(b, l + 1);
    if (!r) r = vsFromSystem(b, l + 1);
    if (!r) r = vsFromValueSets(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // vsFromSystem KW_AND vsFromValueSets
  private static boolean vsComponentFrom_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "vsComponentFrom_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = vsFromSystem(b, l + 1);
    r = r && consumeToken(b, KW_AND);
    r = r && vsFromValueSets(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // vsFromValueSets KW_AND vsFromSystem
  private static boolean vsComponentFrom_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "vsComponentFrom_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = vsFromValueSets(b, l + 1);
    r = r && consumeToken(b, KW_AND);
    r = r && vsFromSystem(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // codeValue KW_FROM vsComponentFrom
  //                       | KW_INCLUDE codeValue (KW_AND codeValue)* (KW_FROM vsComponentFrom)?
  //                       | KW_EXCLUDE codeValue (KW_AND codeValue)* (KW_FROM vsComponentFrom)?
  //                       | codeValue
  public static boolean vsConceptComponent(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "vsConceptComponent")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, VS_CONCEPT_COMPONENT, "<vs concept component>");
    r = vsConceptComponent_0(b, l + 1);
    if (!r) r = vsConceptComponent_1(b, l + 1);
    if (!r) r = vsConceptComponent_2(b, l + 1);
    if (!r) r = codeValue(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // codeValue KW_FROM vsComponentFrom
  private static boolean vsConceptComponent_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "vsConceptComponent_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = codeValue(b, l + 1);
    r = r && consumeToken(b, KW_FROM);
    r = r && vsComponentFrom(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // KW_INCLUDE codeValue (KW_AND codeValue)* (KW_FROM vsComponentFrom)?
  private static boolean vsConceptComponent_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "vsConceptComponent_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KW_INCLUDE);
    r = r && codeValue(b, l + 1);
    r = r && vsConceptComponent_1_2(b, l + 1);
    r = r && vsConceptComponent_1_3(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (KW_AND codeValue)*
  private static boolean vsConceptComponent_1_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "vsConceptComponent_1_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!vsConceptComponent_1_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "vsConceptComponent_1_2", c)) break;
    }
    return true;
  }

  // KW_AND codeValue
  private static boolean vsConceptComponent_1_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "vsConceptComponent_1_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KW_AND);
    r = r && codeValue(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (KW_FROM vsComponentFrom)?
  private static boolean vsConceptComponent_1_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "vsConceptComponent_1_3")) return false;
    vsConceptComponent_1_3_0(b, l + 1);
    return true;
  }

  // KW_FROM vsComponentFrom
  private static boolean vsConceptComponent_1_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "vsConceptComponent_1_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KW_FROM);
    r = r && vsComponentFrom(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // KW_EXCLUDE codeValue (KW_AND codeValue)* (KW_FROM vsComponentFrom)?
  private static boolean vsConceptComponent_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "vsConceptComponent_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KW_EXCLUDE);
    r = r && codeValue(b, l + 1);
    r = r && vsConceptComponent_2_2(b, l + 1);
    r = r && vsConceptComponent_2_3(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (KW_AND codeValue)*
  private static boolean vsConceptComponent_2_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "vsConceptComponent_2_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!vsConceptComponent_2_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "vsConceptComponent_2_2", c)) break;
    }
    return true;
  }

  // KW_AND codeValue
  private static boolean vsConceptComponent_2_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "vsConceptComponent_2_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KW_AND);
    r = r && codeValue(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (KW_FROM vsComponentFrom)?
  private static boolean vsConceptComponent_2_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "vsConceptComponent_2_3")) return false;
    vsConceptComponent_2_3_0(b, l + 1);
    return true;
  }

  // KW_FROM vsComponentFrom
  private static boolean vsConceptComponent_2_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "vsConceptComponent_2_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KW_FROM);
    r = r && vsComponentFrom(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // KW_INCLUDE KW_CODES KW_FROM vsComponentFrom (KW_WHERE vsFilterList)?
  //                      | KW_EXCLUDE KW_CODES KW_FROM vsComponentFrom (KW_WHERE vsFilterList)?
  //                      | KW_CODES KW_FROM vsComponentFrom (KW_WHERE vsFilterList)?
  public static boolean vsFilterComponent(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "vsFilterComponent")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, VS_FILTER_COMPONENT, "<vs filter component>");
    r = vsFilterComponent_0(b, l + 1);
    if (!r) r = vsFilterComponent_1(b, l + 1);
    if (!r) r = vsFilterComponent_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // KW_INCLUDE KW_CODES KW_FROM vsComponentFrom (KW_WHERE vsFilterList)?
  private static boolean vsFilterComponent_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "vsFilterComponent_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, KW_INCLUDE, KW_CODES, KW_FROM);
    r = r && vsComponentFrom(b, l + 1);
    r = r && vsFilterComponent_0_4(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (KW_WHERE vsFilterList)?
  private static boolean vsFilterComponent_0_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "vsFilterComponent_0_4")) return false;
    vsFilterComponent_0_4_0(b, l + 1);
    return true;
  }

  // KW_WHERE vsFilterList
  private static boolean vsFilterComponent_0_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "vsFilterComponent_0_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KW_WHERE);
    r = r && vsFilterList(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // KW_EXCLUDE KW_CODES KW_FROM vsComponentFrom (KW_WHERE vsFilterList)?
  private static boolean vsFilterComponent_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "vsFilterComponent_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, KW_EXCLUDE, KW_CODES, KW_FROM);
    r = r && vsComponentFrom(b, l + 1);
    r = r && vsFilterComponent_1_4(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (KW_WHERE vsFilterList)?
  private static boolean vsFilterComponent_1_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "vsFilterComponent_1_4")) return false;
    vsFilterComponent_1_4_0(b, l + 1);
    return true;
  }

  // KW_WHERE vsFilterList
  private static boolean vsFilterComponent_1_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "vsFilterComponent_1_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KW_WHERE);
    r = r && vsFilterList(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // KW_CODES KW_FROM vsComponentFrom (KW_WHERE vsFilterList)?
  private static boolean vsFilterComponent_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "vsFilterComponent_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, KW_CODES, KW_FROM);
    r = r && vsComponentFrom(b, l + 1);
    r = r && vsFilterComponent_2_3(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (KW_WHERE vsFilterList)?
  private static boolean vsFilterComponent_2_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "vsFilterComponent_2_3")) return false;
    vsFilterComponent_2_3_0(b, l + 1);
    return true;
  }

  // KW_WHERE vsFilterList
  private static boolean vsFilterComponent_2_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "vsFilterComponent_2_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KW_WHERE);
    r = r && vsFilterList(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // nameToken vsFilterOperator vsFilterValue
  public static boolean vsFilterItem(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "vsFilterItem")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, VS_FILTER_ITEM, "<vs filter item>");
    r = nameToken(b, l + 1);
    r = r && vsFilterOperator(b, l + 1);
    r = r && vsFilterValue(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // vsFilterItem (KW_AND vsFilterItem)*
  public static boolean vsFilterList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "vsFilterList")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, VS_FILTER_LIST, "<vs filter list>");
    r = vsFilterItem(b, l + 1);
    r = r && vsFilterList_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (KW_AND vsFilterItem)*
  private static boolean vsFilterList_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "vsFilterList_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!vsFilterList_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "vsFilterList_1", c)) break;
    }
    return true;
  }

  // KW_AND vsFilterItem
  private static boolean vsFilterList_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "vsFilterList_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KW_AND);
    r = r && vsFilterItem(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // EQUALS
  //                    | KW_IS_A
  //                    | KW_IS_NOT_A
  //                    | KW_DESCENDENT_OF
  //                    | KW_GENERALIZES
  //                    | KW_NOT_IN
  //                    | KW_IN
  //                    | KW_REGEX
  //                    | KW_EXISTS
  public static boolean vsFilterOperator(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "vsFilterOperator")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, VS_FILTER_OPERATOR, "<vs filter operator>");
    r = consumeToken(b, EQUALS);
    if (!r) r = consumeToken(b, KW_IS_A);
    if (!r) r = consumeToken(b, KW_IS_NOT_A);
    if (!r) r = consumeToken(b, KW_DESCENDENT_OF);
    if (!r) r = consumeToken(b, KW_GENERALIZES);
    if (!r) r = consumeToken(b, KW_NOT_IN);
    if (!r) r = consumeToken(b, KW_IN);
    if (!r) r = consumeToken(b, KW_REGEX);
    if (!r) r = consumeToken(b, KW_EXISTS);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // CODE
  //                 | QUOTED_CODE
  //                 | STRING
  //                 | KW_TRUE
  //                 | KW_FALSE
  //                 | REGEX_LITERAL
  //                 | nameToken
  public static boolean vsFilterValue(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "vsFilterValue")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, VS_FILTER_VALUE, "<vs filter value>");
    r = consumeToken(b, CODE);
    if (!r) r = consumeToken(b, QUOTED_CODE);
    if (!r) r = consumeToken(b, STRING);
    if (!r) r = consumeToken(b, KW_TRUE);
    if (!r) r = consumeToken(b, KW_FALSE);
    if (!r) r = consumeToken(b, REGEX_LITERAL);
    if (!r) r = nameToken(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // KW_SYSTEM nameToken
  public static boolean vsFromSystem(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "vsFromSystem")) return false;
    if (!nextTokenIs(b, KW_SYSTEM)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KW_SYSTEM);
    r = r && nameToken(b, l + 1);
    exit_section_(b, m, VS_FROM_SYSTEM, r);
    return r;
  }

  /* ********************************************************** */
  // KW_VS_VALUESET nameToken (KW_AND nameToken)*
  public static boolean vsFromValueSets(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "vsFromValueSets")) return false;
    if (!nextTokenIs(b, KW_VS_VALUESET)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KW_VS_VALUESET);
    r = r && nameToken(b, l + 1);
    r = r && vsFromValueSets_2(b, l + 1);
    exit_section_(b, m, VS_FROM_VALUE_SETS, r);
    return r;
  }

  // (KW_AND nameToken)*
  private static boolean vsFromValueSets_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "vsFromValueSets_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!vsFromValueSets_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "vsFromValueSets_2", c)) break;
    }
    return true;
  }

  // KW_AND nameToken
  private static boolean vsFromValueSets_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "vsFromValueSets_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KW_AND);
    r = r && nameToken(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // idMetadata
  //                       | titleMetadata
  //                       | descriptionMetadata
  public static boolean vsMetadata(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "vsMetadata")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, VS_METADATA, "<vs metadata>");
    r = idMetadata(b, l + 1);
    if (!r) r = titleMetadata(b, l + 1);
    if (!r) r = descriptionMetadata(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // vsComponent
  //          | caretValueRule
  //          | insertRule
  public static boolean vsRule(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "vsRule")) return false;
    if (!nextTokenIs(b, STAR)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = vsComponent(b, l + 1);
    if (!r) r = caretValueRule(b, l + 1);
    if (!r) r = insertRule(b, l + 1);
    exit_section_(b, m, VS_RULE, r);
    return r;
  }

  /* ********************************************************** */
  // KW_XPATH COLON STRING
  public static boolean xpathMetadata(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "xpathMetadata")) return false;
    if (!nextTokenIs(b, KW_XPATH)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, XPATH_METADATA, null);
    r = consumeTokens(b, 1, KW_XPATH, COLON, STRING);
    p = r; // pin = 1
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

}

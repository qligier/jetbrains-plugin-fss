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
import static ch.qligier.jetbrains.plugin.fss.fsh.language.parser.FshBinders.*;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class FshParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, EXTENDS_SETS_);
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

  public static final TokenSet[] EXTENDS_SETS_ = new TokenSet[] {
    create_token_set_(ALIAS_ENTITY, CODE_SYSTEM_ENTITY, ENTITY, EXTENSION_ENTITY,
      INSTANCE_ENTITY, INVARIANT_ENTITY, LOGICAL_ENTITY, MAPPING_ENTITY,
      PARAM_RULE_SET_ENTITY, PROFILE_ENTITY, RESOURCE_ENTITY, RULE_SET_ENTITY,
      VALUE_SET_ENTITY),
    create_token_set_(CHARACTERISTICS_METADATA, CONTEXT_METADATA, DESCRIPTION_METADATA, EXPRESSION_METADATA,
      ID_METADATA, INSTANCE_OF_METADATA, METADATA, PARENT_METADATA,
      SEVERITY_METADATA, SOURCE_METADATA, TARGET_METADATA, TITLE_METADATA,
      USAGE_METADATA, XPATH_METADATA),
    create_token_set_(ADD_CR_ELEMENT_RULE, ADD_ELEMENT_RULE, ASSIGNMENT_RULE, BINDING_RULE,
      CARD_RULE, CARET_VALUE_RULE, CONCEPT_RULE, CONTAINS_RULE,
      FLAG_RULE, INSERT_RULE, MAPPING_RULE, OBEYS_RULE,
      ONLY_RULE, RAW_RULE, RULE, VS_CONCEPT_RULE,
      VS_FILTER_RULE),
  };

  /* ********************************************************** */
  // CARD flag* KW_CONTENT_REFERENCE content_reference_target STRING (STRING | MULTILINE_STRING)?
  public static boolean add_cr_element_rule(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "add_cr_element_rule")) return false;
    if (!nextTokenIs(b, CARD)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _UPPER_, ADD_CR_ELEMENT_RULE, null);
    r = consumeToken(b, CARD);
    r = r && add_cr_element_rule_1(b, l + 1);
    r = r && consumeToken(b, KW_CONTENT_REFERENCE);
    p = r; // pin = 3
    r = r && report_error_(b, content_reference_target(b, l + 1));
    r = p && report_error_(b, consumeToken(b, STRING)) && r;
    r = p && add_cr_element_rule_5(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // flag*
  private static boolean add_cr_element_rule_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "add_cr_element_rule_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!flag(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "add_cr_element_rule_1", c)) break;
    }
    return true;
  }

  // (STRING | MULTILINE_STRING)?
  private static boolean add_cr_element_rule_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "add_cr_element_rule_5")) return false;
    add_cr_element_rule_5_0(b, l + 1);
    return true;
  }

  // STRING | MULTILINE_STRING
  private static boolean add_cr_element_rule_5_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "add_cr_element_rule_5_0")) return false;
    boolean r;
    r = consumeToken(b, STRING);
    if (!r) r = consumeToken(b, MULTILINE_STRING);
    return r;
  }

  /* ********************************************************** */
  // CARD (flag !STRING)* type_ref (KW_OR type_ref)* STRING (STRING | MULTILINE_STRING)?
  public static boolean add_element_rule(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "add_element_rule")) return false;
    if (!nextTokenIs(b, CARD)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _UPPER_, ADD_ELEMENT_RULE, null);
    r = consumeToken(b, CARD);
    r = r && add_element_rule_1(b, l + 1);
    r = r && type_ref(b, l + 1);
    p = r; // pin = 3
    r = r && report_error_(b, add_element_rule_3(b, l + 1));
    r = p && report_error_(b, consumeToken(b, STRING)) && r;
    r = p && add_element_rule_5(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // (flag !STRING)*
  private static boolean add_element_rule_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "add_element_rule_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!add_element_rule_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "add_element_rule_1", c)) break;
    }
    return true;
  }

  // flag !STRING
  private static boolean add_element_rule_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "add_element_rule_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = flag(b, l + 1);
    r = r && add_element_rule_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // !STRING
  private static boolean add_element_rule_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "add_element_rule_1_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !consumeToken(b, STRING);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (KW_OR type_ref)*
  private static boolean add_element_rule_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "add_element_rule_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!add_element_rule_3_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "add_element_rule_3", c)) break;
    }
    return true;
  }

  // KW_OR type_ref
  private static boolean add_element_rule_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "add_element_rule_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KW_OR);
    r = r && type_ref(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (STRING | MULTILINE_STRING)?
  private static boolean add_element_rule_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "add_element_rule_5")) return false;
    add_element_rule_5_0(b, l + 1);
    return true;
  }

  // STRING | MULTILINE_STRING
  private static boolean add_element_rule_5_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "add_element_rule_5_0")) return false;
    boolean r;
    r = consumeToken(b, STRING);
    if (!r) r = consumeToken(b, MULTILINE_STRING);
    return r;
  }

  /* ********************************************************** */
  // KW_ALIAS COLON entity_name? alias_value? junk?
  public static boolean alias_entity(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "alias_entity")) return false;
    if (!nextTokenIs(b, KW_ALIAS)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, ALIAS_ENTITY, null);
    r = consumeTokens(b, 1, KW_ALIAS, COLON);
    p = r; // pin = 1
    r = r && report_error_(b, alias_entity_2(b, l + 1));
    r = p && report_error_(b, alias_entity_3(b, l + 1)) && r;
    r = p && alias_entity_4(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // entity_name?
  private static boolean alias_entity_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "alias_entity_2")) return false;
    entity_name(b, l + 1);
    return true;
  }

  // alias_value?
  private static boolean alias_entity_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "alias_entity_3")) return false;
    alias_value(b, l + 1);
    return true;
  }

  // junk?
  private static boolean alias_entity_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "alias_entity_4")) return false;
    junk(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // EQUAL (CODE | <<nameToken>>)
  public static boolean alias_value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "alias_value")) return false;
    if (!nextTokenIs(b, EQUAL)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, ALIAS_VALUE, null);
    r = consumeToken(b, EQUAL);
    p = r; // pin = 1
    r = r && alias_value_1(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // CODE | <<nameToken>>
  private static boolean alias_value_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "alias_value_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, CODE);
    if (!r) r = nameToken(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (ARG_TEXT | ARG_BRACKETED)+
  public static boolean argument(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "argument")) return false;
    if (!nextTokenIs(b, "<argument>", ARG_BRACKETED, ARG_TEXT)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ARGUMENT, "<argument>");
    r = argument_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!argument_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "argument", c)) break;
    }
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ARG_TEXT | ARG_BRACKETED
  private static boolean argument_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "argument_0")) return false;
    boolean r;
    r = consumeToken(b, ARG_TEXT);
    if (!r) r = consumeToken(b, ARG_BRACKETED);
    return r;
  }

  /* ********************************************************** */
  // LPAREN argument? (COMMA argument?)* RPAREN
  public static boolean argument_list(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "argument_list")) return false;
    if (!nextTokenIs(b, LPAREN)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, ARGUMENT_LIST, null);
    r = consumeToken(b, LPAREN);
    p = r; // pin = 1
    r = r && report_error_(b, argument_list_1(b, l + 1));
    r = p && report_error_(b, argument_list_2(b, l + 1)) && r;
    r = p && consumeToken(b, RPAREN) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // argument?
  private static boolean argument_list_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "argument_list_1")) return false;
    argument(b, l + 1);
    return true;
  }

  // (COMMA argument?)*
  private static boolean argument_list_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "argument_list_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!argument_list_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "argument_list_2", c)) break;
    }
    return true;
  }

  // COMMA argument?
  private static boolean argument_list_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "argument_list_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && argument_list_2_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // argument?
  private static boolean argument_list_2_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "argument_list_2_0_1")) return false;
    argument(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // EQUAL value KW_EXACTLY?
  public static boolean assignment_rule(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assignment_rule")) return false;
    if (!nextTokenIs(b, EQUAL)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _UPPER_, ASSIGNMENT_RULE, null);
    r = consumeToken(b, EQUAL);
    p = r; // pin = 1
    r = r && report_error_(b, value(b, l + 1));
    r = p && assignment_rule_2(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // KW_EXACTLY?
  private static boolean assignment_rule_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assignment_rule_2")) return false;
    consumeToken(b, KW_EXACTLY);
    return true;
  }

  /* ********************************************************** */
  // KW_FROM value_set_ref strength?
  public static boolean binding_rule(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "binding_rule")) return false;
    if (!nextTokenIs(b, KW_FROM)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _UPPER_, BINDING_RULE, null);
    r = consumeToken(b, KW_FROM);
    p = r; // pin = 1
    r = r && report_error_(b, value_set_ref(b, l + 1));
    r = p && binding_rule_2(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // strength?
  private static boolean binding_rule_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "binding_rule_2")) return false;
    strength(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // KW_CANONICAL LPAREN reference_target (KW_OR reference_target)* RPAREN
  static boolean canonical_parens(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "canonical_parens")) return false;
    if (!nextTokenIs(b, KW_CANONICAL)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = consumeTokens(b, 2, KW_CANONICAL, LPAREN);
    p = r; // pin = 2
    r = r && report_error_(b, reference_target(b, l + 1));
    r = p && report_error_(b, canonical_parens_3(b, l + 1)) && r;
    r = p && consumeToken(b, RPAREN) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // (KW_OR reference_target)*
  private static boolean canonical_parens_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "canonical_parens_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!canonical_parens_3_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "canonical_parens_3", c)) break;
    }
    return true;
  }

  // KW_OR reference_target
  private static boolean canonical_parens_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "canonical_parens_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KW_OR);
    r = r && reference_target(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // canonical_parens
  public static boolean canonical_type(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "canonical_type")) return false;
    if (!nextTokenIs(b, KW_CANONICAL)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = canonical_parens(b, l + 1);
    exit_section_(b, m, CANONICAL_TYPE, r);
    return r;
  }

  /* ********************************************************** */
  // canonical_parens
  public static boolean canonical_value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "canonical_value")) return false;
    if (!nextTokenIs(b, KW_CANONICAL)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = canonical_parens(b, l + 1);
    exit_section_(b, m, CANONICAL_VALUE, r);
    return r;
  }

  /* ********************************************************** */
  // CARD flag*
  public static boolean card_rule(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "card_rule")) return false;
    if (!nextTokenIs(b, CARD)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _UPPER_, CARD_RULE, null);
    r = consumeToken(b, CARD);
    p = r; // pin = 1
    r = r && card_rule_1(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // flag*
  private static boolean card_rule_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "card_rule_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!flag(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "card_rule_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // add_cr_element_rule | add_element_rule | card_rule
  static boolean card_tail(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "card_tail")) return false;
    if (!nextTokenIs(b, CARD)) return false;
    boolean r;
    r = add_cr_element_rule(b, l + 1);
    if (!r) r = add_element_rule(b, l + 1);
    if (!r) r = card_rule(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // CARET_PATH EQUAL value KW_EXACTLY?
  public static boolean caret_value_rule(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "caret_value_rule")) return false;
    if (!nextTokenIs(b, CARET_PATH)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _UPPER_, CARET_VALUE_RULE, null);
    r = consumeTokens(b, 1, CARET_PATH, EQUAL);
    p = r; // pin = 1
    r = r && report_error_(b, value(b, l + 1));
    r = p && caret_value_rule_3(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // KW_EXACTLY?
  private static boolean caret_value_rule_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "caret_value_rule_3")) return false;
    consumeToken(b, KW_EXACTLY);
    return true;
  }

  /* ********************************************************** */
  // KW_CHARACTERISTICS COLON metadata_value
  public static boolean characteristics_metadata(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "characteristics_metadata")) return false;
    if (!nextTokenIs(b, KW_CHARACTERISTICS)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _UPPER_, CHARACTERISTICS_METADATA, null);
    r = consumeTokens(b, 1, KW_CHARACTERISTICS, COLON);
    p = r; // pin = 1
    r = r && metadata_value(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // KW_CODESYSTEM COLON entity_name? entity_item*
  public static boolean code_system_entity(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "code_system_entity")) return false;
    if (!nextTokenIs(b, KW_CODESYSTEM)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, CODE_SYSTEM_ENTITY, null);
    r = consumeTokens(b, 1, KW_CODESYSTEM, COLON);
    p = r; // pin = 1
    r = r && report_error_(b, code_system_entity_2(b, l + 1));
    r = p && code_system_entity_3(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // entity_name?
  private static boolean code_system_entity_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "code_system_entity_2")) return false;
    entity_name(b, l + 1);
    return true;
  }

  // entity_item*
  private static boolean code_system_entity_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "code_system_entity_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!entity_item(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "code_system_entity_3", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // caret_value_rule | insert_rule | &(STRING? KW_FROM) vs_concept_rule | concept_rule
  static boolean code_tail(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "code_tail")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = caret_value_rule(b, l + 1);
    if (!r) r = insert_rule(b, l + 1);
    if (!r) r = code_tail_2(b, l + 1);
    if (!r) r = concept_rule(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &(STRING? KW_FROM) vs_concept_rule
  private static boolean code_tail_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "code_tail_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = code_tail_2_0(b, l + 1);
    r = r && vs_concept_rule(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &(STRING? KW_FROM)
  private static boolean code_tail_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "code_tail_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_);
    r = code_tail_2_0_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // STRING? KW_FROM
  private static boolean code_tail_2_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "code_tail_2_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = code_tail_2_0_0_0(b, l + 1);
    r = r && consumeToken(b, KW_FROM);
    exit_section_(b, m, null, r);
    return r;
  }

  // STRING?
  private static boolean code_tail_2_0_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "code_tail_2_0_0_0")) return false;
    consumeToken(b, STRING);
    return true;
  }

  /* ********************************************************** */
  // CODE STRING?
  public static boolean code_value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "code_value")) return false;
    if (!nextTokenIs(b, CODE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, CODE);
    r = r && code_value_1(b, l + 1);
    exit_section_(b, m, CODE_VALUE, r);
    return r;
  }

  // STRING?
  private static boolean code_value_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "code_value_1")) return false;
    consumeToken(b, STRING);
    return true;
  }

  /* ********************************************************** */
  // CODE+
  public static boolean codes(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "codes")) return false;
    if (!nextTokenIs(b, CODE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, CODE);
    while (r) {
      int c = current_position_(b);
      if (!consumeToken(b, CODE)) break;
      if (!empty_element_parsed_guard_(b, "codes", c)) break;
    }
    exit_section_(b, m, CODES, r);
    return r;
  }

  /* ********************************************************** */
  // (STRING (STRING | MULTILINE_STRING)? | MULTILINE_STRING)?
  public static boolean concept_rule(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "concept_rule")) return false;
    Marker m = enter_section_(b, l, _UPPER_, CONCEPT_RULE, "<concept rule>");
    concept_rule_0(b, l + 1);
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  // STRING (STRING | MULTILINE_STRING)? | MULTILINE_STRING
  private static boolean concept_rule_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "concept_rule_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = concept_rule_0_0(b, l + 1);
    if (!r) r = consumeToken(b, MULTILINE_STRING);
    exit_section_(b, m, null, r);
    return r;
  }

  // STRING (STRING | MULTILINE_STRING)?
  private static boolean concept_rule_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "concept_rule_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, STRING);
    r = r && concept_rule_0_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (STRING | MULTILINE_STRING)?
  private static boolean concept_rule_0_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "concept_rule_0_0_1")) return false;
    concept_rule_0_0_1_0(b, l + 1);
    return true;
  }

  // STRING | MULTILINE_STRING
  private static boolean concept_rule_0_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "concept_rule_0_0_1_0")) return false;
    boolean r;
    r = consumeToken(b, STRING);
    if (!r) r = consumeToken(b, MULTILINE_STRING);
    return r;
  }

  /* ********************************************************** */
  // (extension_ref KW_NAMED)? slice_name CARD flag*
  public static boolean contains_item(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "contains_item")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CONTAINS_ITEM, "<contains item>");
    r = contains_item_0(b, l + 1);
    r = r && slice_name(b, l + 1);
    r = r && consumeToken(b, CARD);
    r = r && contains_item_3(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (extension_ref KW_NAMED)?
  private static boolean contains_item_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "contains_item_0")) return false;
    contains_item_0_0(b, l + 1);
    return true;
  }

  // extension_ref KW_NAMED
  private static boolean contains_item_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "contains_item_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = extension_ref(b, l + 1);
    r = r && consumeToken(b, KW_NAMED);
    exit_section_(b, m, null, r);
    return r;
  }

  // flag*
  private static boolean contains_item_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "contains_item_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!flag(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "contains_item_3", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // KW_CONTAINS contains_item (KW_AND contains_item)*
  public static boolean contains_rule(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "contains_rule")) return false;
    if (!nextTokenIs(b, KW_CONTAINS)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _UPPER_, CONTAINS_RULE, null);
    r = consumeToken(b, KW_CONTAINS);
    p = r; // pin = 1
    r = r && report_error_(b, contains_item(b, l + 1));
    r = p && contains_rule_2(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // (KW_AND contains_item)*
  private static boolean contains_rule_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "contains_rule_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!contains_rule_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "contains_rule_2", c)) break;
    }
    return true;
  }

  // KW_AND contains_item
  private static boolean contains_rule_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "contains_rule_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KW_AND);
    r = r && contains_item(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // CODE | <<nameToken>>
  public static boolean content_reference_target(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "content_reference_target")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CONTENT_REFERENCE_TARGET, "<content reference target>");
    r = consumeToken(b, CODE);
    if (!r) r = nameToken(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // STRING | CODE | <<nameToken>>
  public static boolean context_item(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "context_item")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CONTEXT_ITEM, "<context item>");
    r = consumeToken(b, STRING);
    if (!r) r = consumeToken(b, CODE);
    if (!r) r = nameToken(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // KW_CONTEXT COLON context_item (COMMA? context_item)*
  public static boolean context_metadata(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "context_metadata")) return false;
    if (!nextTokenIs(b, KW_CONTEXT)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _UPPER_, CONTEXT_METADATA, null);
    r = consumeTokens(b, 1, KW_CONTEXT, COLON);
    p = r; // pin = 1
    r = r && report_error_(b, context_item(b, l + 1));
    r = p && context_metadata_3(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // (COMMA? context_item)*
  private static boolean context_metadata_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "context_metadata_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!context_metadata_3_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "context_metadata_3", c)) break;
    }
    return true;
  }

  // COMMA? context_item
  private static boolean context_metadata_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "context_metadata_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = context_metadata_3_0_0(b, l + 1);
    r = r && context_item(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // COMMA?
  private static boolean context_metadata_3_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "context_metadata_3_0_0")) return false;
    consumeToken(b, COMMA);
    return true;
  }

  /* ********************************************************** */
  // KW_ALIAS | KW_PROFILE | KW_EXTENSION | KW_INSTANCE | KW_INVARIANT | KW_VALUESET
  //                               | KW_CODESYSTEM | KW_RULESET | KW_MAPPING | KW_LOGICAL | KW_RESOURCE
  static boolean declaration_keyword(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "declaration_keyword")) return false;
    boolean r;
    r = consumeToken(b, KW_ALIAS);
    if (!r) r = consumeToken(b, KW_PROFILE);
    if (!r) r = consumeToken(b, KW_EXTENSION);
    if (!r) r = consumeToken(b, KW_INSTANCE);
    if (!r) r = consumeToken(b, KW_INVARIANT);
    if (!r) r = consumeToken(b, KW_VALUESET);
    if (!r) r = consumeToken(b, KW_CODESYSTEM);
    if (!r) r = consumeToken(b, KW_RULESET);
    if (!r) r = consumeToken(b, KW_MAPPING);
    if (!r) r = consumeToken(b, KW_LOGICAL);
    if (!r) r = consumeToken(b, KW_RESOURCE);
    return r;
  }

  /* ********************************************************** */
  // KW_DESCRIPTION COLON metadata_value
  public static boolean description_metadata(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "description_metadata")) return false;
    if (!nextTokenIs(b, KW_DESCRIPTION)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _UPPER_, DESCRIPTION_METADATA, null);
    r = consumeTokens(b, 1, KW_DESCRIPTION, COLON);
    p = r; // pin = 1
    r = r && metadata_value(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // alias_entity
  //          | profile_entity
  //          | extension_entity
  //          | logical_entity
  //          | resource_entity
  //          | instance_entity
  //          | invariant_entity
  //          | value_set_entity
  //          | code_system_entity
  //          | param_rule_set_entity
  //          | rule_set_entity
  //          | mapping_entity
  public static boolean entity(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "entity")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _COLLAPSE_, ENTITY, "<entity>");
    r = alias_entity(b, l + 1);
    if (!r) r = profile_entity(b, l + 1);
    if (!r) r = extension_entity(b, l + 1);
    if (!r) r = logical_entity(b, l + 1);
    if (!r) r = resource_entity(b, l + 1);
    if (!r) r = instance_entity(b, l + 1);
    if (!r) r = invariant_entity(b, l + 1);
    if (!r) r = value_set_entity(b, l + 1);
    if (!r) r = code_system_entity(b, l + 1);
    if (!r) r = param_rule_set_entity(b, l + 1);
    if (!r) r = rule_set_entity(b, l + 1);
    if (!r) r = mapping_entity(b, l + 1);
    register_hook_(b, LEFT_BINDER, ENTITY_LEFT);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // &metadata_keyword metadata | &STAR rule | junk
  static boolean entity_item(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "entity_item")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = entity_item_0(b, l + 1);
    if (!r) r = entity_item_1(b, l + 1);
    if (!r) r = junk(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &metadata_keyword metadata
  private static boolean entity_item_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "entity_item_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = entity_item_0_0(b, l + 1);
    r = r && metadata(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &metadata_keyword
  private static boolean entity_item_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "entity_item_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_);
    r = metadata_keyword(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // &STAR rule
  private static boolean entity_item_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "entity_item_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = entity_item_1_0(b, l + 1);
    r = r && rule(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &STAR
  private static boolean entity_item_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "entity_item_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_);
    r = consumeToken(b, STAR);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // <<nameToken>>
  public static boolean entity_name(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "entity_name")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ENTITY_NAME, "<entity name>");
    r = nameToken(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // KW_EXPRESSION COLON metadata_value
  public static boolean expression_metadata(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expression_metadata")) return false;
    if (!nextTokenIs(b, KW_EXPRESSION)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _UPPER_, EXPRESSION_METADATA, null);
    r = consumeTokens(b, 1, KW_EXPRESSION, COLON);
    p = r; // pin = 1
    r = r && metadata_value(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // KW_EXTENSION COLON entity_name? entity_item*
  public static boolean extension_entity(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "extension_entity")) return false;
    if (!nextTokenIs(b, KW_EXTENSION)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, EXTENSION_ENTITY, null);
    r = consumeTokens(b, 1, KW_EXTENSION, COLON);
    p = r; // pin = 1
    r = r && report_error_(b, extension_entity_2(b, l + 1));
    r = p && extension_entity_3(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // entity_name?
  private static boolean extension_entity_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "extension_entity_2")) return false;
    entity_name(b, l + 1);
    return true;
  }

  // entity_item*
  private static boolean extension_entity_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "extension_entity_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!entity_item(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "extension_entity_3", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // <<nameToken>>
  public static boolean extension_ref(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "extension_ref")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, EXTENSION_REF, "<extension ref>");
    r = nameToken(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // entity | &STAR rule | <<orphanTokens>>
  static boolean file_item(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "file_item")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = entity(b, l + 1);
    if (!r) r = file_item_1(b, l + 1);
    if (!r) r = orphanTokens(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &STAR rule
  private static boolean file_item_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "file_item_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = file_item_1_0(b, l + 1);
    r = r && rule(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &STAR
  private static boolean file_item_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "file_item_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_);
    r = consumeToken(b, STAR);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // EQUAL | <<nameToken>>
  public static boolean filter_operator(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "filter_operator")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FILTER_OPERATOR, "<filter operator>");
    r = consumeToken(b, EQUAL);
    if (!r) r = nameToken(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // <<nameToken>>
  public static boolean filter_property(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "filter_property")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FILTER_PROPERTY, "<filter property>");
    r = nameToken(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // KW_MS | KW_SU | KW_TU | KW_N | KW_D | KW_MOD
  static boolean flag(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "flag")) return false;
    boolean r;
    r = consumeToken(b, KW_MS);
    if (!r) r = consumeToken(b, KW_SU);
    if (!r) r = consumeToken(b, KW_TU);
    if (!r) r = consumeToken(b, KW_N);
    if (!r) r = consumeToken(b, KW_D);
    if (!r) r = consumeToken(b, KW_MOD);
    return r;
  }

  /* ********************************************************** */
  // (KW_AND path)* flag+
  public static boolean flag_rule(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "flag_rule")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _UPPER_, FLAG_RULE, "<flag rule>");
    r = flag_rule_0(b, l + 1);
    r = r && flag_rule_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (KW_AND path)*
  private static boolean flag_rule_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "flag_rule_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!flag_rule_0_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "flag_rule_0", c)) break;
    }
    return true;
  }

  // KW_AND path
  private static boolean flag_rule_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "flag_rule_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KW_AND);
    r = r && path(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // flag+
  private static boolean flag_rule_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "flag_rule_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = flag(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!flag(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "flag_rule_1", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // file_item*
  static boolean fshFile(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fshFile")) return false;
    while (true) {
      int c = current_position_(b);
      if (!file_item(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "fshFile", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // &(KW_OBEYS !(path_tail_start | rule_end)) obeys_rule
  static boolean headless_obeys(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "headless_obeys")) return false;
    if (!nextTokenIs(b, KW_OBEYS)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = headless_obeys_0(b, l + 1);
    r = r && obeys_rule(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &(KW_OBEYS !(path_tail_start | rule_end))
  private static boolean headless_obeys_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "headless_obeys_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_);
    r = headless_obeys_0_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // KW_OBEYS !(path_tail_start | rule_end)
  private static boolean headless_obeys_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "headless_obeys_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KW_OBEYS);
    r = r && headless_obeys_0_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // !(path_tail_start | rule_end)
  private static boolean headless_obeys_0_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "headless_obeys_0_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !headless_obeys_0_0_1_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // path_tail_start | rule_end
  private static boolean headless_obeys_0_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "headless_obeys_0_0_1_0")) return false;
    boolean r;
    r = path_tail_start(b, l + 1);
    if (!r) r = rule_end(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // caret_value_rule | insert_rule | headless_obeys | mapping_rule
  static boolean headless_tail(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "headless_tail")) return false;
    boolean r;
    r = caret_value_rule(b, l + 1);
    if (!r) r = insert_rule(b, l + 1);
    if (!r) r = headless_obeys(b, l + 1);
    if (!r) r = mapping_rule(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // KW_ID COLON metadata_value
  public static boolean id_metadata(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "id_metadata")) return false;
    if (!nextTokenIs(b, KW_ID)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _UPPER_, ID_METADATA, null);
    r = consumeTokens(b, 1, KW_ID, COLON);
    p = r; // pin = 1
    r = r && metadata_value(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // KW_INSERT rule_set_ref argument_list?
  public static boolean insert_rule(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "insert_rule")) return false;
    if (!nextTokenIs(b, KW_INSERT)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _UPPER_, INSERT_RULE, null);
    r = consumeToken(b, KW_INSERT);
    p = r; // pin = 1
    r = r && report_error_(b, rule_set_ref(b, l + 1));
    r = p && insert_rule_2(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // argument_list?
  private static boolean insert_rule_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "insert_rule_2")) return false;
    argument_list(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // KW_INSTANCE COLON entity_name? entity_item*
  public static boolean instance_entity(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "instance_entity")) return false;
    if (!nextTokenIs(b, KW_INSTANCE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, INSTANCE_ENTITY, null);
    r = consumeTokens(b, 1, KW_INSTANCE, COLON);
    p = r; // pin = 1
    r = r && report_error_(b, instance_entity_2(b, l + 1));
    r = p && instance_entity_3(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // entity_name?
  private static boolean instance_entity_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "instance_entity_2")) return false;
    entity_name(b, l + 1);
    return true;
  }

  // entity_item*
  private static boolean instance_entity_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "instance_entity_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!entity_item(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "instance_entity_3", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // KW_INSTANCEOF COLON metadata_value
  public static boolean instance_of_metadata(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "instance_of_metadata")) return false;
    if (!nextTokenIs(b, KW_INSTANCEOF)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _UPPER_, INSTANCE_OF_METADATA, null);
    r = consumeTokens(b, 1, KW_INSTANCEOF, COLON);
    p = r; // pin = 1
    r = r && metadata_value(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // KW_INVARIANT COLON entity_name? entity_item*
  public static boolean invariant_entity(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "invariant_entity")) return false;
    if (!nextTokenIs(b, KW_INVARIANT)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, INVARIANT_ENTITY, null);
    r = consumeTokens(b, 1, KW_INVARIANT, COLON);
    p = r; // pin = 1
    r = r && report_error_(b, invariant_entity_2(b, l + 1));
    r = p && invariant_entity_3(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // entity_name?
  private static boolean invariant_entity_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "invariant_entity_2")) return false;
    entity_name(b, l + 1);
    return true;
  }

  // entity_item*
  private static boolean invariant_entity_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "invariant_entity_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!entity_item(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "invariant_entity_3", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // <<nameToken>>
  public static boolean invariant_ref(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "invariant_ref")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, INVARIANT_REF, "<invariant ref>");
    r = nameToken(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // <<junkTokens>>
  static boolean junk(PsiBuilder b, int l) {
    return junkTokens(b, l + 1);
  }

  /* ********************************************************** */
  // KW_LOGICAL COLON entity_name? entity_item*
  public static boolean logical_entity(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "logical_entity")) return false;
    if (!nextTokenIs(b, KW_LOGICAL)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, LOGICAL_ENTITY, null);
    r = consumeTokens(b, 1, KW_LOGICAL, COLON);
    p = r; // pin = 1
    r = r && report_error_(b, logical_entity_2(b, l + 1));
    r = p && logical_entity_3(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // entity_name?
  private static boolean logical_entity_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "logical_entity_2")) return false;
    entity_name(b, l + 1);
    return true;
  }

  // entity_item*
  private static boolean logical_entity_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "logical_entity_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!entity_item(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "logical_entity_3", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // KW_MAPPING COLON entity_name? entity_item*
  public static boolean mapping_entity(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "mapping_entity")) return false;
    if (!nextTokenIs(b, KW_MAPPING)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, MAPPING_ENTITY, null);
    r = consumeTokens(b, 1, KW_MAPPING, COLON);
    p = r; // pin = 1
    r = r && report_error_(b, mapping_entity_2(b, l + 1));
    r = p && mapping_entity_3(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // entity_name?
  private static boolean mapping_entity_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "mapping_entity_2")) return false;
    entity_name(b, l + 1);
    return true;
  }

  // entity_item*
  private static boolean mapping_entity_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "mapping_entity_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!entity_item(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "mapping_entity_3", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // ARROW STRING (STRING | MULTILINE_STRING)? CODE?
  public static boolean mapping_rule(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "mapping_rule")) return false;
    if (!nextTokenIs(b, ARROW)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _UPPER_, MAPPING_RULE, null);
    r = consumeTokens(b, 1, ARROW, STRING);
    p = r; // pin = 1
    r = r && report_error_(b, mapping_rule_2(b, l + 1));
    r = p && mapping_rule_3(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // (STRING | MULTILINE_STRING)?
  private static boolean mapping_rule_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "mapping_rule_2")) return false;
    mapping_rule_2_0(b, l + 1);
    return true;
  }

  // STRING | MULTILINE_STRING
  private static boolean mapping_rule_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "mapping_rule_2_0")) return false;
    boolean r;
    r = consumeToken(b, STRING);
    if (!r) r = consumeToken(b, MULTILINE_STRING);
    return r;
  }

  // CODE?
  private static boolean mapping_rule_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "mapping_rule_3")) return false;
    consumeToken(b, CODE);
    return true;
  }

  /* ********************************************************** */
  // metadata_body
  public static boolean metadata(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "metadata")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _COLLAPSE_, METADATA, "<metadata>");
    r = metadata_body(b, l + 1);
    register_hook_(b, RIGHT_BINDER, TRAILING_COMMENT);
    exit_section_(b, l, m, r, false, FshParser::metadata_recover);
    return r;
  }

  /* ********************************************************** */
  // parent_metadata | id_metadata | title_metadata | description_metadata | expression_metadata
  //                         | xpath_metadata | severity_metadata | instance_of_metadata | usage_metadata | source_metadata
  //                         | target_metadata | context_metadata | characteristics_metadata
  static boolean metadata_body(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "metadata_body")) return false;
    boolean r;
    r = parent_metadata(b, l + 1);
    if (!r) r = id_metadata(b, l + 1);
    if (!r) r = title_metadata(b, l + 1);
    if (!r) r = description_metadata(b, l + 1);
    if (!r) r = expression_metadata(b, l + 1);
    if (!r) r = xpath_metadata(b, l + 1);
    if (!r) r = severity_metadata(b, l + 1);
    if (!r) r = instance_of_metadata(b, l + 1);
    if (!r) r = usage_metadata(b, l + 1);
    if (!r) r = source_metadata(b, l + 1);
    if (!r) r = target_metadata(b, l + 1);
    if (!r) r = context_metadata(b, l + 1);
    if (!r) r = characteristics_metadata(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // KW_PARENT | KW_ID | KW_TITLE | KW_DESCRIPTION | KW_EXPRESSION | KW_XPATH | KW_SEVERITY
  //                            | KW_INSTANCEOF | KW_USAGE | KW_SOURCE | KW_TARGET | KW_CONTEXT | KW_CHARACTERISTICS
  static boolean metadata_keyword(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "metadata_keyword")) return false;
    boolean r;
    r = consumeToken(b, KW_PARENT);
    if (!r) r = consumeToken(b, KW_ID);
    if (!r) r = consumeToken(b, KW_TITLE);
    if (!r) r = consumeToken(b, KW_DESCRIPTION);
    if (!r) r = consumeToken(b, KW_EXPRESSION);
    if (!r) r = consumeToken(b, KW_XPATH);
    if (!r) r = consumeToken(b, KW_SEVERITY);
    if (!r) r = consumeToken(b, KW_INSTANCEOF);
    if (!r) r = consumeToken(b, KW_USAGE);
    if (!r) r = consumeToken(b, KW_SOURCE);
    if (!r) r = consumeToken(b, KW_TARGET);
    if (!r) r = consumeToken(b, KW_CONTEXT);
    if (!r) r = consumeToken(b, KW_CHARACTERISTICS);
    return r;
  }

  /* ********************************************************** */
  // !(STAR | declaration_keyword | metadata_keyword)
  static boolean metadata_recover(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "metadata_recover")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !metadata_recover_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // STAR | declaration_keyword | metadata_keyword
  private static boolean metadata_recover_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "metadata_recover_0")) return false;
    boolean r;
    r = consumeToken(b, STAR);
    if (!r) r = declaration_keyword(b, l + 1);
    if (!r) r = metadata_keyword(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // value (COMMA? value)*
  static boolean metadata_value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "metadata_value")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = value(b, l + 1);
    r = r && metadata_value_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA? value)*
  private static boolean metadata_value_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "metadata_value_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!metadata_value_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "metadata_value_1", c)) break;
    }
    return true;
  }

  // COMMA? value
  private static boolean metadata_value_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "metadata_value_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = metadata_value_1_0_0(b, l + 1);
    r = r && value(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // COMMA?
  private static boolean metadata_value_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "metadata_value_1_0_0")) return false;
    consumeToken(b, COMMA);
    return true;
  }

  /* ********************************************************** */
  // <<nameToken>>
  public static boolean name_ref(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "name_ref")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, NAME_REF, "<name ref>");
    r = nameToken(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // KW_OBEYS invariant_ref (KW_AND invariant_ref)*
  public static boolean obeys_rule(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "obeys_rule")) return false;
    if (!nextTokenIs(b, KW_OBEYS)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _UPPER_, OBEYS_RULE, null);
    r = consumeToken(b, KW_OBEYS);
    p = r; // pin = 1
    r = r && report_error_(b, invariant_ref(b, l + 1));
    r = p && obeys_rule_2(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // (KW_AND invariant_ref)*
  private static boolean obeys_rule_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "obeys_rule_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!obeys_rule_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "obeys_rule_2", c)) break;
    }
    return true;
  }

  // KW_AND invariant_ref
  private static boolean obeys_rule_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "obeys_rule_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KW_AND);
    r = r && invariant_ref(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // KW_ONLY type_ref (KW_OR type_ref)*
  public static boolean only_rule(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "only_rule")) return false;
    if (!nextTokenIs(b, KW_ONLY)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _UPPER_, ONLY_RULE, null);
    r = consumeToken(b, KW_ONLY);
    p = r; // pin = 1
    r = r && report_error_(b, type_ref(b, l + 1));
    r = p && only_rule_2(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // (KW_OR type_ref)*
  private static boolean only_rule_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "only_rule_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!only_rule_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "only_rule_2", c)) break;
    }
    return true;
  }

  // KW_OR type_ref
  private static boolean only_rule_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "only_rule_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KW_OR);
    r = r && type_ref(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // KW_RULESET COLON entity_name parameter_list param_rule_set_item*
  public static boolean param_rule_set_entity(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "param_rule_set_entity")) return false;
    if (!nextTokenIs(b, KW_RULESET)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, PARAM_RULE_SET_ENTITY, null);
    r = consumeTokens(b, 0, KW_RULESET, COLON);
    r = r && entity_name(b, l + 1);
    r = r && parameter_list(b, l + 1);
    p = r; // pin = 4
    r = r && param_rule_set_entity_4(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // param_rule_set_item*
  private static boolean param_rule_set_entity_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "param_rule_set_entity_4")) return false;
    while (true) {
      int c = current_position_(b);
      if (!param_rule_set_item(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "param_rule_set_entity_4", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // &metadata_keyword metadata | typed_param_line | raw_rule | junk
  static boolean param_rule_set_item(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "param_rule_set_item")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = param_rule_set_item_0(b, l + 1);
    if (!r) r = typed_param_line(b, l + 1);
    if (!r) r = raw_rule(b, l + 1);
    if (!r) r = junk(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &metadata_keyword metadata
  private static boolean param_rule_set_item_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "param_rule_set_item_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = param_rule_set_item_0_0(b, l + 1);
    r = r && metadata(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &metadata_keyword
  private static boolean param_rule_set_item_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "param_rule_set_item_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_);
    r = metadata_keyword(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // (ARG_TEXT | ARG_BRACKETED)+
  public static boolean parameter(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameter")) return false;
    if (!nextTokenIs(b, "<parameter>", ARG_BRACKETED, ARG_TEXT)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PARAMETER, "<parameter>");
    r = parameter_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!parameter_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "parameter", c)) break;
    }
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ARG_TEXT | ARG_BRACKETED
  private static boolean parameter_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameter_0")) return false;
    boolean r;
    r = consumeToken(b, ARG_TEXT);
    if (!r) r = consumeToken(b, ARG_BRACKETED);
    return r;
  }

  /* ********************************************************** */
  // LPAREN parameter? (COMMA parameter?)* RPAREN
  public static boolean parameter_list(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameter_list")) return false;
    if (!nextTokenIs(b, LPAREN)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, PARAMETER_LIST, null);
    r = consumeToken(b, LPAREN);
    p = r; // pin = 1
    r = r && report_error_(b, parameter_list_1(b, l + 1));
    r = p && report_error_(b, parameter_list_2(b, l + 1)) && r;
    r = p && consumeToken(b, RPAREN) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // parameter?
  private static boolean parameter_list_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameter_list_1")) return false;
    parameter(b, l + 1);
    return true;
  }

  // (COMMA parameter?)*
  private static boolean parameter_list_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameter_list_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!parameter_list_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "parameter_list_2", c)) break;
    }
    return true;
  }

  // COMMA parameter?
  private static boolean parameter_list_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameter_list_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && parameter_list_2_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // parameter?
  private static boolean parameter_list_2_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameter_list_2_0_1")) return false;
    parameter(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // KW_PARENT COLON metadata_value
  public static boolean parent_metadata(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parent_metadata")) return false;
    if (!nextTokenIs(b, KW_PARENT)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _UPPER_, PARENT_METADATA, null);
    r = consumeTokens(b, 1, KW_PARENT, COLON);
    p = r; // pin = 1
    r = r && metadata_value(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // <<nameToken>>
  public static boolean path(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "path")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PATH, "<path>");
    r = nameToken(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // EQUAL | CARET_PATH | KW_FROM | KW_ONLY | KW_CONTAINS | KW_OBEYS | KW_INSERT | ARROW | KW_AND | CARD | flag
  static boolean path_tail_start(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "path_tail_start")) return false;
    boolean r;
    r = consumeToken(b, EQUAL);
    if (!r) r = consumeToken(b, CARET_PATH);
    if (!r) r = consumeToken(b, KW_FROM);
    if (!r) r = consumeToken(b, KW_ONLY);
    if (!r) r = consumeToken(b, KW_CONTAINS);
    if (!r) r = consumeToken(b, KW_OBEYS);
    if (!r) r = consumeToken(b, KW_INSERT);
    if (!r) r = consumeToken(b, ARROW);
    if (!r) r = consumeToken(b, KW_AND);
    if (!r) r = consumeToken(b, CARD);
    if (!r) r = flag(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // KW_PROFILE COLON entity_name? entity_item*
  public static boolean profile_entity(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "profile_entity")) return false;
    if (!nextTokenIs(b, KW_PROFILE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, PROFILE_ENTITY, null);
    r = consumeTokens(b, 1, KW_PROFILE, COLON);
    p = r; // pin = 1
    r = r && report_error_(b, profile_entity_2(b, l + 1));
    r = p && profile_entity_3(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // entity_name?
  private static boolean profile_entity_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "profile_entity_2")) return false;
    entity_name(b, l + 1);
    return true;
  }

  // entity_item*
  private static boolean profile_entity_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "profile_entity_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!entity_item(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "profile_entity_3", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // NUMBER (UNIT | CODE) STRING? | UNIT STRING?
  public static boolean quantity(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "quantity")) return false;
    if (!nextTokenIs(b, "<quantity>", NUMBER, UNIT)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, QUANTITY, "<quantity>");
    r = quantity_0(b, l + 1);
    if (!r) r = quantity_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // NUMBER (UNIT | CODE) STRING?
  private static boolean quantity_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "quantity_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, NUMBER);
    r = r && quantity_0_1(b, l + 1);
    r = r && quantity_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // UNIT | CODE
  private static boolean quantity_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "quantity_0_1")) return false;
    boolean r;
    r = consumeToken(b, UNIT);
    if (!r) r = consumeToken(b, CODE);
    return r;
  }

  // STRING?
  private static boolean quantity_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "quantity_0_2")) return false;
    consumeToken(b, STRING);
    return true;
  }

  // UNIT STRING?
  private static boolean quantity_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "quantity_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, UNIT);
    r = r && quantity_1_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // STRING?
  private static boolean quantity_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "quantity_1_1")) return false;
    consumeToken(b, STRING);
    return true;
  }

  /* ********************************************************** */
  // ratio_part COLON ratio_part
  public static boolean ratio(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ratio")) return false;
    if (!nextTokenIs(b, "<ratio>", NUMBER, UNIT)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, RATIO, "<ratio>");
    r = ratio_part(b, l + 1);
    r = r && consumeToken(b, COLON);
    p = r; // pin = 2
    r = r && ratio_part(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // quantity | NUMBER
  static boolean ratio_part(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ratio_part")) return false;
    if (!nextTokenIs(b, "", NUMBER, UNIT)) return false;
    boolean r;
    r = quantity(b, l + 1);
    if (!r) r = consumeToken(b, NUMBER);
    return r;
  }

  /* ********************************************************** */
  // STAR raw_token*
  public static boolean raw_rule(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "raw_rule")) return false;
    if (!nextTokenIs(b, STAR)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, RAW_RULE, null);
    r = consumeToken(b, STAR);
    p = r; // pin = 1
    r = r && raw_rule_1(b, l + 1);
    register_hook_(b, RIGHT_BINDER, TRAILING_COMMENT);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // raw_token*
  private static boolean raw_rule_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "raw_rule_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!raw_token(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "raw_rule_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // !metadata_keyword <<junkToken>>
  static boolean raw_token(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "raw_token")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = raw_token_0(b, l + 1);
    r = r && junkToken(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // !metadata_keyword
  private static boolean raw_token_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "raw_token_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !metadata_keyword(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // (KW_REFERENCE | KW_CODEABLE_REFERENCE) LPAREN reference_target (KW_OR reference_target)* RPAREN
  static boolean reference_parens(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "reference_parens")) return false;
    if (!nextTokenIs(b, "", KW_CODEABLE_REFERENCE, KW_REFERENCE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = reference_parens_0(b, l + 1);
    r = r && consumeToken(b, LPAREN);
    p = r; // pin = 2
    r = r && report_error_(b, reference_target(b, l + 1));
    r = p && report_error_(b, reference_parens_3(b, l + 1)) && r;
    r = p && consumeToken(b, RPAREN) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // KW_REFERENCE | KW_CODEABLE_REFERENCE
  private static boolean reference_parens_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "reference_parens_0")) return false;
    boolean r;
    r = consumeToken(b, KW_REFERENCE);
    if (!r) r = consumeToken(b, KW_CODEABLE_REFERENCE);
    return r;
  }

  // (KW_OR reference_target)*
  private static boolean reference_parens_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "reference_parens_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!reference_parens_3_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "reference_parens_3", c)) break;
    }
    return true;
  }

  // KW_OR reference_target
  private static boolean reference_parens_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "reference_parens_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KW_OR);
    r = r && reference_target(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // WORD
  public static boolean reference_target(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "reference_target")) return false;
    if (!nextTokenIs(b, WORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, WORD);
    exit_section_(b, m, REFERENCE_TARGET, r);
    return r;
  }

  /* ********************************************************** */
  // reference_parens
  public static boolean reference_type(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "reference_type")) return false;
    if (!nextTokenIs(b, "<reference type>", KW_CODEABLE_REFERENCE, KW_REFERENCE)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, REFERENCE_TYPE, "<reference type>");
    r = reference_parens(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // reference_parens STRING?
  public static boolean reference_value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "reference_value")) return false;
    if (!nextTokenIs(b, "<reference value>", KW_CODEABLE_REFERENCE, KW_REFERENCE)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, REFERENCE_VALUE, "<reference value>");
    r = reference_parens(b, l + 1);
    r = r && reference_value_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // STRING?
  private static boolean reference_value_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "reference_value_1")) return false;
    consumeToken(b, STRING);
    return true;
  }

  /* ********************************************************** */
  // KW_RESOURCE COLON entity_name? entity_item*
  public static boolean resource_entity(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "resource_entity")) return false;
    if (!nextTokenIs(b, KW_RESOURCE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, RESOURCE_ENTITY, null);
    r = consumeTokens(b, 1, KW_RESOURCE, COLON);
    p = r; // pin = 1
    r = r && report_error_(b, resource_entity_2(b, l + 1));
    r = p && resource_entity_3(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // entity_name?
  private static boolean resource_entity_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "resource_entity_2")) return false;
    entity_name(b, l + 1);
    return true;
  }

  // entity_item*
  private static boolean resource_entity_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "resource_entity_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!entity_item(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "resource_entity_3", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // STAR rule_body?
  public static boolean rule(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "rule")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, RULE, "<rule>");
    r = consumeToken(b, STAR);
    p = r; // pin = 1
    r = r && rule_1(b, l + 1);
    register_hook_(b, RIGHT_BINDER, TRAILING_COMMENT);
    exit_section_(b, l, m, r, p, FshParser::rule_recover);
    return r || p;
  }

  // rule_body?
  private static boolean rule_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "rule_1")) return false;
    rule_body(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // headless_tail
  //                     | vs_include_component
  //                     | vs_filter_rule
  //                     | codes code_tail
  //                     | path rule_tail?
  static boolean rule_body(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "rule_body")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = headless_tail(b, l + 1);
    if (!r) r = vs_include_component(b, l + 1);
    if (!r) r = vs_filter_rule(b, l + 1);
    if (!r) r = rule_body_3(b, l + 1);
    if (!r) r = rule_body_4(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // codes code_tail
  private static boolean rule_body_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "rule_body_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = codes(b, l + 1);
    r = r && code_tail(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // path rule_tail?
  private static boolean rule_body_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "rule_body_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = path(b, l + 1);
    r = r && rule_body_4_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // rule_tail?
  private static boolean rule_body_4_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "rule_body_4_1")) return false;
    rule_tail(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // STAR | declaration_keyword | metadata_keyword | <<eof>>
  static boolean rule_end(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "rule_end")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, STAR);
    if (!r) r = declaration_keyword(b, l + 1);
    if (!r) r = metadata_keyword(b, l + 1);
    if (!r) r = eof(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // !(STAR | declaration_keyword | metadata_keyword)
  static boolean rule_recover(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "rule_recover")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !rule_recover_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // STAR | declaration_keyword | metadata_keyword
  private static boolean rule_recover_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "rule_recover_0")) return false;
    boolean r;
    r = consumeToken(b, STAR);
    if (!r) r = declaration_keyword(b, l + 1);
    if (!r) r = metadata_keyword(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // KW_RULESET COLON entity_name? entity_item*
  public static boolean rule_set_entity(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "rule_set_entity")) return false;
    if (!nextTokenIs(b, KW_RULESET)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, RULE_SET_ENTITY, null);
    r = consumeTokens(b, 1, KW_RULESET, COLON);
    p = r; // pin = 1
    r = r && report_error_(b, rule_set_entity_2(b, l + 1));
    r = p && rule_set_entity_3(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // entity_name?
  private static boolean rule_set_entity_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "rule_set_entity_2")) return false;
    entity_name(b, l + 1);
    return true;
  }

  // entity_item*
  private static boolean rule_set_entity_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "rule_set_entity_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!entity_item(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "rule_set_entity_3", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // WORD
  public static boolean rule_set_ref(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "rule_set_ref")) return false;
    if (!nextTokenIs(b, WORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, WORD);
    exit_section_(b, m, RULE_SET_REF, r);
    return r;
  }

  /* ********************************************************** */
  // assignment_rule
  //                     | caret_value_rule
  //                     | binding_rule
  //                     | only_rule
  //                     | contains_rule
  //                     | obeys_rule
  //                     | insert_rule
  //                     | mapping_rule
  //                     | flag_rule
  //                     | card_tail
  static boolean rule_tail(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "rule_tail")) return false;
    boolean r;
    r = assignment_rule(b, l + 1);
    if (!r) r = caret_value_rule(b, l + 1);
    if (!r) r = binding_rule(b, l + 1);
    if (!r) r = only_rule(b, l + 1);
    if (!r) r = contains_rule(b, l + 1);
    if (!r) r = obeys_rule(b, l + 1);
    if (!r) r = insert_rule(b, l + 1);
    if (!r) r = mapping_rule(b, l + 1);
    if (!r) r = flag_rule(b, l + 1);
    if (!r) r = card_tail(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // KW_SEVERITY COLON metadata_value
  public static boolean severity_metadata(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "severity_metadata")) return false;
    if (!nextTokenIs(b, KW_SEVERITY)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _UPPER_, SEVERITY_METADATA, null);
    r = consumeTokens(b, 1, KW_SEVERITY, COLON);
    p = r; // pin = 1
    r = r && metadata_value(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // <<nameToken>>
  public static boolean slice_name(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "slice_name")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SLICE_NAME, "<slice name>");
    r = nameToken(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // KW_SOURCE COLON metadata_value
  public static boolean source_metadata(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "source_metadata")) return false;
    if (!nextTokenIs(b, KW_SOURCE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _UPPER_, SOURCE_METADATA, null);
    r = consumeTokens(b, 1, KW_SOURCE, COLON);
    p = r; // pin = 1
    r = r && metadata_value(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // KW_EXAMPLE | KW_PREFERRED | KW_EXTENSIBLE | KW_REQUIRED
  static boolean strength(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "strength")) return false;
    boolean r;
    r = consumeToken(b, KW_EXAMPLE);
    if (!r) r = consumeToken(b, KW_PREFERRED);
    if (!r) r = consumeToken(b, KW_EXTENSIBLE);
    if (!r) r = consumeToken(b, KW_REQUIRED);
    return r;
  }

  /* ********************************************************** */
  // <<nameToken>>
  public static boolean system_ref(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "system_ref")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SYSTEM_REF, "<system ref>");
    r = nameToken(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // KW_TARGET COLON metadata_value
  public static boolean target_metadata(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "target_metadata")) return false;
    if (!nextTokenIs(b, KW_TARGET)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _UPPER_, TARGET_METADATA, null);
    r = consumeTokens(b, 1, KW_TARGET, COLON);
    p = r; // pin = 1
    r = r && metadata_value(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // KW_TITLE COLON metadata_value
  public static boolean title_metadata(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "title_metadata")) return false;
    if (!nextTokenIs(b, KW_TITLE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _UPPER_, TITLE_METADATA, null);
    r = consumeTokens(b, 1, KW_TITLE, COLON);
    p = r; // pin = 1
    r = r && metadata_value(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // reference_type | canonical_type | <<nameToken>>
  public static boolean type_ref(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_ref")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TYPE_REF, "<type ref>");
    r = reference_type(b, l + 1);
    if (!r) r = canonical_type(b, l + 1);
    if (!r) r = nameToken(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // STAR rule_body? &rule_end
  public static boolean typed_param_line(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typed_param_line")) return false;
    if (!nextTokenIs(b, "<rule>", STAR)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, RULE, "<rule>");
    r = consumeToken(b, STAR);
    r = r && typed_param_line_1(b, l + 1);
    r = r && typed_param_line_2(b, l + 1);
    register_hook_(b, RIGHT_BINDER, TRAILING_COMMENT);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // rule_body?
  private static boolean typed_param_line_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typed_param_line_1")) return false;
    rule_body(b, l + 1);
    return true;
  }

  // &rule_end
  private static boolean typed_param_line_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typed_param_line_2")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_);
    r = rule_end(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // KW_USAGE COLON metadata_value
  public static boolean usage_metadata(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "usage_metadata")) return false;
    if (!nextTokenIs(b, KW_USAGE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _UPPER_, USAGE_METADATA, null);
    r = consumeTokens(b, 1, KW_USAGE, COLON);
    p = r; // pin = 1
    r = r && metadata_value(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // ratio
  //         | quantity
  //         | STRING
  //         | MULTILINE_STRING
  //         | NUMBER
  //         | DATE_TIME
  //         | TIME
  //         | reference_value
  //         | canonical_value
  //         | code_value
  //         | KW_TRUE
  //         | KW_FALSE
  //         | REGEX
  //         | name_ref
  public static boolean value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "value")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, VALUE, "<value>");
    r = ratio(b, l + 1);
    if (!r) r = quantity(b, l + 1);
    if (!r) r = consumeToken(b, STRING);
    if (!r) r = consumeToken(b, MULTILINE_STRING);
    if (!r) r = consumeToken(b, NUMBER);
    if (!r) r = consumeToken(b, DATE_TIME);
    if (!r) r = consumeToken(b, TIME);
    if (!r) r = reference_value(b, l + 1);
    if (!r) r = canonical_value(b, l + 1);
    if (!r) r = code_value(b, l + 1);
    if (!r) r = consumeToken(b, KW_TRUE);
    if (!r) r = consumeToken(b, KW_FALSE);
    if (!r) r = consumeToken(b, REGEX);
    if (!r) r = name_ref(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // KW_VALUESET COLON entity_name? entity_item*
  public static boolean value_set_entity(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "value_set_entity")) return false;
    if (!nextTokenIs(b, KW_VALUESET)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, VALUE_SET_ENTITY, null);
    r = consumeTokens(b, 1, KW_VALUESET, COLON);
    p = r; // pin = 1
    r = r && report_error_(b, value_set_entity_2(b, l + 1));
    r = p && value_set_entity_3(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // entity_name?
  private static boolean value_set_entity_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "value_set_entity_2")) return false;
    entity_name(b, l + 1);
    return true;
  }

  // entity_item*
  private static boolean value_set_entity_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "value_set_entity_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!entity_item(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "value_set_entity_3", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // <<nameToken>>
  public static boolean value_set_ref(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "value_set_ref")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, VALUE_SET_REF, "<value set ref>");
    r = nameToken(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // KW_FROM &(KW_SYSTEM | KW_VALUESET_REF) vs_from_item (KW_AND vs_from_item)*
  public static boolean vs_component_from(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "vs_component_from")) return false;
    if (!nextTokenIs(b, KW_FROM)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, VS_COMPONENT_FROM, null);
    r = consumeToken(b, KW_FROM);
    r = r && vs_component_from_1(b, l + 1);
    p = r; // pin = 2
    r = r && report_error_(b, vs_from_item(b, l + 1));
    r = p && vs_component_from_3(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // &(KW_SYSTEM | KW_VALUESET_REF)
  private static boolean vs_component_from_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "vs_component_from_1")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_);
    r = vs_component_from_1_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // KW_SYSTEM | KW_VALUESET_REF
  private static boolean vs_component_from_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "vs_component_from_1_0")) return false;
    boolean r;
    r = consumeToken(b, KW_SYSTEM);
    if (!r) r = consumeToken(b, KW_VALUESET_REF);
    return r;
  }

  // (KW_AND vs_from_item)*
  private static boolean vs_component_from_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "vs_component_from_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!vs_component_from_3_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "vs_component_from_3", c)) break;
    }
    return true;
  }

  // KW_AND vs_from_item
  private static boolean vs_component_from_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "vs_component_from_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KW_AND);
    r = r && vs_from_item(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // STRING? vs_component_from?
  public static boolean vs_concept_rule(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "vs_concept_rule")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _UPPER_, VS_CONCEPT_RULE, "<vs concept rule>");
    r = vs_concept_rule_0(b, l + 1);
    r = r && vs_concept_rule_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // STRING?
  private static boolean vs_concept_rule_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "vs_concept_rule_0")) return false;
    consumeToken(b, STRING);
    return true;
  }

  // vs_component_from?
  private static boolean vs_concept_rule_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "vs_concept_rule_1")) return false;
    vs_component_from(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // filter_property filter_operator vs_filter_value?
  public static boolean vs_filter(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "vs_filter")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, VS_FILTER, "<vs filter>");
    r = filter_property(b, l + 1);
    r = r && filter_operator(b, l + 1);
    r = r && vs_filter_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // vs_filter_value?
  private static boolean vs_filter_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "vs_filter_2")) return false;
    vs_filter_value(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // KW_WHERE vs_filter (KW_AND vs_filter)*
  public static boolean vs_filter_list(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "vs_filter_list")) return false;
    if (!nextTokenIs(b, KW_WHERE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, VS_FILTER_LIST, null);
    r = consumeToken(b, KW_WHERE);
    p = r; // pin = 1
    r = r && report_error_(b, vs_filter(b, l + 1));
    r = p && vs_filter_list_2(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // (KW_AND vs_filter)*
  private static boolean vs_filter_list_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "vs_filter_list_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!vs_filter_list_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "vs_filter_list_2", c)) break;
    }
    return true;
  }

  // KW_AND vs_filter
  private static boolean vs_filter_list_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "vs_filter_list_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KW_AND);
    r = r && vs_filter(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // KW_CODES vs_component_from vs_filter_list?
  public static boolean vs_filter_rule(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "vs_filter_rule")) return false;
    if (!nextTokenIs(b, KW_CODES)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _UPPER_, VS_FILTER_RULE, null);
    r = consumeToken(b, KW_CODES);
    r = r && vs_component_from(b, l + 1);
    p = r; // pin = 2
    r = r && vs_filter_rule_2(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // vs_filter_list?
  private static boolean vs_filter_rule_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "vs_filter_rule_2")) return false;
    vs_filter_list(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // code_value | KW_TRUE | KW_FALSE | REGEX | STRING
  static boolean vs_filter_value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "vs_filter_value")) return false;
    boolean r;
    r = code_value(b, l + 1);
    if (!r) r = consumeToken(b, KW_TRUE);
    if (!r) r = consumeToken(b, KW_FALSE);
    if (!r) r = consumeToken(b, REGEX);
    if (!r) r = consumeToken(b, STRING);
    return r;
  }

  /* ********************************************************** */
  // vs_from_system | vs_from_value_set
  static boolean vs_from_item(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "vs_from_item")) return false;
    if (!nextTokenIs(b, "", KW_SYSTEM, KW_VALUESET_REF)) return false;
    boolean r;
    r = vs_from_system(b, l + 1);
    if (!r) r = vs_from_value_set(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // KW_SYSTEM system_ref
  public static boolean vs_from_system(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "vs_from_system")) return false;
    if (!nextTokenIs(b, KW_SYSTEM)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, VS_FROM_SYSTEM, null);
    r = consumeToken(b, KW_SYSTEM);
    p = r; // pin = 1
    r = r && system_ref(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // KW_VALUESET_REF value_set_ref (KW_AND !(KW_SYSTEM | KW_VALUESET_REF) value_set_ref)*
  public static boolean vs_from_value_set(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "vs_from_value_set")) return false;
    if (!nextTokenIs(b, KW_VALUESET_REF)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, VS_FROM_VALUE_SET, null);
    r = consumeToken(b, KW_VALUESET_REF);
    p = r; // pin = 1
    r = r && report_error_(b, value_set_ref(b, l + 1));
    r = p && vs_from_value_set_2(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // (KW_AND !(KW_SYSTEM | KW_VALUESET_REF) value_set_ref)*
  private static boolean vs_from_value_set_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "vs_from_value_set_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!vs_from_value_set_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "vs_from_value_set_2", c)) break;
    }
    return true;
  }

  // KW_AND !(KW_SYSTEM | KW_VALUESET_REF) value_set_ref
  private static boolean vs_from_value_set_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "vs_from_value_set_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KW_AND);
    r = r && vs_from_value_set_2_0_1(b, l + 1);
    r = r && value_set_ref(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // !(KW_SYSTEM | KW_VALUESET_REF)
  private static boolean vs_from_value_set_2_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "vs_from_value_set_2_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !vs_from_value_set_2_0_1_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // KW_SYSTEM | KW_VALUESET_REF
  private static boolean vs_from_value_set_2_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "vs_from_value_set_2_0_1_0")) return false;
    boolean r;
    r = consumeToken(b, KW_SYSTEM);
    if (!r) r = consumeToken(b, KW_VALUESET_REF);
    return r;
  }

  /* ********************************************************** */
  // (KW_INCLUDE | KW_EXCLUDE) (vs_filter_rule | codes vs_concept_rule)
  static boolean vs_include_component(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "vs_include_component")) return false;
    if (!nextTokenIs(b, "", KW_EXCLUDE, KW_INCLUDE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = vs_include_component_0(b, l + 1);
    r = r && vs_include_component_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // KW_INCLUDE | KW_EXCLUDE
  private static boolean vs_include_component_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "vs_include_component_0")) return false;
    boolean r;
    r = consumeToken(b, KW_INCLUDE);
    if (!r) r = consumeToken(b, KW_EXCLUDE);
    return r;
  }

  // vs_filter_rule | codes vs_concept_rule
  private static boolean vs_include_component_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "vs_include_component_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = vs_filter_rule(b, l + 1);
    if (!r) r = vs_include_component_1_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // codes vs_concept_rule
  private static boolean vs_include_component_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "vs_include_component_1_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = codes(b, l + 1);
    r = r && vs_concept_rule(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // KW_XPATH COLON metadata_value
  public static boolean xpath_metadata(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "xpath_metadata")) return false;
    if (!nextTokenIs(b, KW_XPATH)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _UPPER_, XPATH_METADATA, null);
    r = consumeTokens(b, 1, KW_XPATH, COLON);
    p = r; // pin = 1
    r = r && metadata_value(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

}

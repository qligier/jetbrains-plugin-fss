// This is a generated file. Not intended for manual editing.
package ch.qligier.jetbrains.plugin.fhir.fsh.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static ch.qligier.jetbrains.plugin.fhir.fsh.parser.psi.FshTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
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
    create_token_set_(ALIAS, CODE_SYSTEM, EXTENSION, INSTANCE,
      INVARIANT, LOGICAL, MAPPING, PROFILE,
      RESOURCE, RULE_SET, VALUE_SET),
    create_token_set_(DESCRIPTION, EXPRESSION, ID, INSTANCE_OF,
      PARENT, SEVERITY, SOURCE, TARGET,
      TITLE, USAGE, XPATH),
    create_token_set_(ADD_CR_ELEMENT_RULE, ADD_ELEMENT_RULE, CARD_RULE, CARET_VALUE_RULE,
      CODE_CARET_VALUE_RULE, CODE_INSERT_RULE, CONCEPT, CONTAINS_RULE,
      FIXED_VALUE_RULE, FLAG_RULE, INSERT_RULE, MAPPING_RULE,
      OBEYS_RULE, ONLY_RULE, PATH_RULE, VALUE_SET_RULE,
      VS_COMPONENT),
  };

  /* ********************************************************** */
  // ruleStart path cardinality KwFlag* KwContentReference Url String (String | MultilineString)?
  public static boolean addCRElementRule(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "addCRElementRule")) return false;
    if (!nextTokenIs(b, "<add cr element rule>", STAR, WHITESPACE)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ADD_CR_ELEMENT_RULE, "<add cr element rule>");
    r = ruleStart(b, l + 1);
    r = r && path(b, l + 1);
    r = r && cardinality(b, l + 1);
    r = r && addCRElementRule_3(b, l + 1);
    r = r && consumeTokens(b, 0, KWCONTENTREFERENCE, URL, STRING);
    r = r && addCRElementRule_7(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // KwFlag*
  private static boolean addCRElementRule_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "addCRElementRule_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, KWFLAG)) break;
      if (!empty_element_parsed_guard_(b, "addCRElementRule_3", c)) break;
    }
    return true;
  }

  // (String | MultilineString)?
  private static boolean addCRElementRule_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "addCRElementRule_7")) return false;
    addCRElementRule_7_0(b, l + 1);
    return true;
  }

  // String | MultilineString
  private static boolean addCRElementRule_7_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "addCRElementRule_7_0")) return false;
    boolean r;
    r = consumeToken(b, STRING);
    if (!r) r = consumeToken(b, MULTILINESTRING);
    return r;
  }

  /* ********************************************************** */
  // ruleStart path cardinality KwFlag* targetType (KwOr targetType)* String (String | MultilineString)?
  public static boolean addElementRule(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "addElementRule")) return false;
    if (!nextTokenIs(b, "<add element rule>", STAR, WHITESPACE)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ADD_ELEMENT_RULE, "<add element rule>");
    r = ruleStart(b, l + 1);
    r = r && path(b, l + 1);
    r = r && cardinality(b, l + 1);
    r = r && addElementRule_3(b, l + 1);
    r = r && targetType(b, l + 1);
    r = r && addElementRule_5(b, l + 1);
    r = r && consumeToken(b, STRING);
    r = r && addElementRule_7(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // KwFlag*
  private static boolean addElementRule_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "addElementRule_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, KWFLAG)) break;
      if (!empty_element_parsed_guard_(b, "addElementRule_3", c)) break;
    }
    return true;
  }

  // (KwOr targetType)*
  private static boolean addElementRule_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "addElementRule_5")) return false;
    while (true) {
      int c = current_position_(b);
      if (!addElementRule_5_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "addElementRule_5", c)) break;
    }
    return true;
  }

  // KwOr targetType
  private static boolean addElementRule_5_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "addElementRule_5_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KWOR);
    r = r && targetType(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (String | MultilineString)?
  private static boolean addElementRule_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "addElementRule_7")) return false;
    addElementRule_7_0(b, l + 1);
    return true;
  }

  // String | MultilineString
  private static boolean addElementRule_7_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "addElementRule_7_0")) return false;
    boolean r;
    r = consumeToken(b, STRING);
    if (!r) r = consumeToken(b, MULTILINESTRING);
    return r;
  }

  /* ********************************************************** */
  // KwAlias Colon Identifier Equal aliasValue
  public static boolean alias(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "alias")) return false;
    if (!nextTokenIs(b, KWALIAS)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, KWALIAS, COLON, IDENTIFIER, EQUAL);
    r = r && aliasValue(b, l + 1);
    exit_section_(b, m, ALIAS, r);
    return r;
  }

  /* ********************************************************** */
  // Urn | Url
  public static boolean aliasValue(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "aliasValue")) return false;
    if (!nextTokenIs(b, "<alias value>", URL, URN)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ALIAS_VALUE, "<alias value>");
    r = consumeToken(b, URN);
    if (!r) r = consumeToken(b, URL);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // !<<eof>> item_
  static boolean any_(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "any_")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = any__0(b, l + 1);
    p = r; // pin = 1
    r = r && item_(b, l + 1);
    exit_section_(b, l, m, r, p, FshParser::recover);
    return r || p;
  }

  // !<<eof>>
  private static boolean any__0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "any__0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !eof(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // LeftBracket (Identifier | Url | integer | Equal | Plus) RightBracket
  public static boolean bracketSuffix(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bracketSuffix")) return false;
    if (!nextTokenIs(b, LEFTBRACKET)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LEFTBRACKET);
    r = r && bracketSuffix_1(b, l + 1);
    r = r && consumeToken(b, RIGHTBRACKET);
    exit_section_(b, m, BRACKET_SUFFIX, r);
    return r;
  }

  // Identifier | Url | integer | Equal | Plus
  private static boolean bracketSuffix_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bracketSuffix_1")) return false;
    boolean r;
    r = consumeToken(b, IDENTIFIER);
    if (!r) r = consumeToken(b, URL);
    if (!r) r = integer(b, l + 1);
    if (!r) r = consumeToken(b, EQUAL);
    if (!r) r = consumeToken(b, PLUS);
    return r;
  }

  /* ********************************************************** */
  // KwCanonical LeftParen itemIdentifier (Pipe itemIdentifier)? (KwOr itemIdentifier (Pipe itemIdentifier)?)* RightParen
  public static boolean canonical(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "canonical")) return false;
    if (!nextTokenIs(b, KWCANONICAL)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, KWCANONICAL, LEFTPAREN);
    r = r && itemIdentifier(b, l + 1);
    r = r && canonical_3(b, l + 1);
    r = r && canonical_4(b, l + 1);
    r = r && consumeToken(b, RIGHTPAREN);
    exit_section_(b, m, CANONICAL, r);
    return r;
  }

  // (Pipe itemIdentifier)?
  private static boolean canonical_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "canonical_3")) return false;
    canonical_3_0(b, l + 1);
    return true;
  }

  // Pipe itemIdentifier
  private static boolean canonical_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "canonical_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, PIPE);
    r = r && itemIdentifier(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (KwOr itemIdentifier (Pipe itemIdentifier)?)*
  private static boolean canonical_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "canonical_4")) return false;
    while (true) {
      int c = current_position_(b);
      if (!canonical_4_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "canonical_4", c)) break;
    }
    return true;
  }

  // KwOr itemIdentifier (Pipe itemIdentifier)?
  private static boolean canonical_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "canonical_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KWOR);
    r = r && itemIdentifier(b, l + 1);
    r = r && canonical_4_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (Pipe itemIdentifier)?
  private static boolean canonical_4_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "canonical_4_0_2")) return false;
    canonical_4_0_2_0(b, l + 1);
    return true;
  }

  // Pipe itemIdentifier
  private static boolean canonical_4_0_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "canonical_4_0_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, PIPE);
    r = r && itemIdentifier(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ruleStart path cardinality KwFlag*
  public static boolean cardRule(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "cardRule")) return false;
    if (!nextTokenIs(b, "<card rule>", STAR, WHITESPACE)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CARD_RULE, "<card rule>");
    r = ruleStart(b, l + 1);
    r = r && path(b, l + 1);
    r = r && cardinality(b, l + 1);
    r = r && cardRule_3(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // KwFlag*
  private static boolean cardRule_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "cardRule_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, KWFLAG)) break;
      if (!empty_element_parsed_guard_(b, "cardRule_3", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // integer? DoubleDot (integer | Star)?
  public static boolean cardinality(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "cardinality")) return false;
    if (!nextTokenIs(b, "<cardinality>", DIGIT, DOUBLEDOT)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CARDINALITY, "<cardinality>");
    r = cardinality_0(b, l + 1);
    r = r && consumeToken(b, DOUBLEDOT);
    r = r && cardinality_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // integer?
  private static boolean cardinality_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "cardinality_0")) return false;
    integer(b, l + 1);
    return true;
  }

  // (integer | Star)?
  private static boolean cardinality_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "cardinality_2")) return false;
    cardinality_2_0(b, l + 1);
    return true;
  }

  // integer | Star
  private static boolean cardinality_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "cardinality_2_0")) return false;
    boolean r;
    r = integer(b, l + 1);
    if (!r) r = consumeToken(b, STAR);
    return r;
  }

  /* ********************************************************** */
  // ruleStart path? Caret path Equal value
  public static boolean caretValueRule(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "caretValueRule")) return false;
    if (!nextTokenIs(b, "<caret value rule>", STAR, WHITESPACE)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CARET_VALUE_RULE, "<caret value rule>");
    r = ruleStart(b, l + 1);
    r = r && caretValueRule_1(b, l + 1);
    r = r && consumeToken(b, CARET);
    r = r && path(b, l + 1);
    r = r && consumeToken(b, EQUAL);
    r = r && value(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // path?
  private static boolean caretValueRule_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "caretValueRule_1")) return false;
    path(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // (Identifier | Url | Urn)? Hash (Identifier | ConceptString) String?
  public static boolean code(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "code")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CODE, "<code>");
    r = code_0(b, l + 1);
    r = r && consumeToken(b, HASH);
    r = r && code_2(b, l + 1);
    r = r && code_3(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (Identifier | Url | Urn)?
  private static boolean code_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "code_0")) return false;
    code_0_0(b, l + 1);
    return true;
  }

  // Identifier | Url | Urn
  private static boolean code_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "code_0_0")) return false;
    boolean r;
    r = consumeToken(b, IDENTIFIER);
    if (!r) r = consumeToken(b, URL);
    if (!r) r = consumeToken(b, URN);
    return r;
  }

  // Identifier | ConceptString
  private static boolean code_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "code_2")) return false;
    boolean r;
    r = consumeToken(b, IDENTIFIER);
    if (!r) r = consumeToken(b, CONCEPTSTRING);
    return r;
  }

  // String?
  private static boolean code_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "code_3")) return false;
    consumeToken(b, STRING);
    return true;
  }

  /* ********************************************************** */
  // ruleStart code* Caret path Equal value
  public static boolean codeCaretValueRule(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "codeCaretValueRule")) return false;
    if (!nextTokenIs(b, "<code caret value rule>", STAR, WHITESPACE)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CODE_CARET_VALUE_RULE, "<code caret value rule>");
    r = ruleStart(b, l + 1);
    r = r && codeCaretValueRule_1(b, l + 1);
    r = r && consumeToken(b, CARET);
    r = r && path(b, l + 1);
    r = r && consumeToken(b, EQUAL);
    r = r && value(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // code*
  private static boolean codeCaretValueRule_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "codeCaretValueRule_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!code(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "codeCaretValueRule_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // ruleStart code* KwInsert ruleSetReference
  public static boolean codeInsertRule(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "codeInsertRule")) return false;
    if (!nextTokenIs(b, "<code insert rule>", STAR, WHITESPACE)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CODE_INSERT_RULE, "<code insert rule>");
    r = ruleStart(b, l + 1);
    r = r && codeInsertRule_1(b, l + 1);
    r = r && consumeToken(b, KWINSERT);
    r = r && ruleSetReference(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // code*
  private static boolean codeInsertRule_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "codeInsertRule_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!code(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "codeInsertRule_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // KwCodeSystem Colon Identifier csMetadata_* csRule*
  public static boolean codeSystem(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "codeSystem")) return false;
    if (!nextTokenIs(b, KWCODESYSTEM)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, KWCODESYSTEM, COLON, IDENTIFIER);
    r = r && codeSystem_3(b, l + 1);
    r = r && codeSystem_4(b, l + 1);
    exit_section_(b, m, CODE_SYSTEM, r);
    return r;
  }

  // csMetadata_*
  private static boolean codeSystem_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "codeSystem_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!csMetadata_(b, l + 1)) break;
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
  // LineComment | BlockComment
  static boolean comment_(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "comment_")) return false;
    if (!nextTokenIs(b, "", BLOCKCOMMENT, LINECOMMENT)) return false;
    boolean r;
    r = consumeToken(b, LINECOMMENT);
    if (!r) r = consumeToken(b, BLOCKCOMMENT);
    return r;
  }

  /* ********************************************************** */
  // ruleStart code+ String? (String | MultilineString)?
  public static boolean concept(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "concept")) return false;
    if (!nextTokenIs(b, "<concept>", STAR, WHITESPACE)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CONCEPT, "<concept>");
    r = ruleStart(b, l + 1);
    r = r && concept_1(b, l + 1);
    r = r && concept_2(b, l + 1);
    r = r && concept_3(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // code+
  private static boolean concept_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "concept_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = code(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!code(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "concept_1", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // String?
  private static boolean concept_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "concept_2")) return false;
    consumeToken(b, STRING);
    return true;
  }

  // (String | MultilineString)?
  private static boolean concept_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "concept_3")) return false;
    concept_3_0(b, l + 1);
    return true;
  }

  // String | MultilineString
  private static boolean concept_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "concept_3_0")) return false;
    boolean r;
    r = consumeToken(b, STRING);
    if (!r) r = consumeToken(b, MULTILINESTRING);
    return r;
  }

  /* ********************************************************** */
  // ruleStart path KwContains itemType (KwAnd itemType)*
  public static boolean containsRule(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "containsRule")) return false;
    if (!nextTokenIs(b, "<contains rule>", STAR, WHITESPACE)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CONTAINS_RULE, "<contains rule>");
    r = ruleStart(b, l + 1);
    r = r && path(b, l + 1);
    r = r && consumeToken(b, KWCONTAINS);
    r = r && itemType(b, l + 1);
    r = r && containsRule_4(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (KwAnd itemType)*
  private static boolean containsRule_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "containsRule_4")) return false;
    while (true) {
      int c = current_position_(b);
      if (!containsRule_4_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "containsRule_4", c)) break;
    }
    return true;
  }

  // KwAnd itemType
  private static boolean containsRule_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "containsRule_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KWAND);
    r = r && itemType(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // id | title | description
  static boolean csMetadata_(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "csMetadata_")) return false;
    boolean r;
    r = id(b, l + 1);
    if (!r) r = title(b, l + 1);
    if (!r) r = description(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // concept | codeCaretValueRule | codeInsertRule
  public static boolean csRule(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "csRule")) return false;
    if (!nextTokenIs(b, "<cs rule>", STAR, WHITESPACE)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CS_RULE, "<cs rule>");
    r = concept(b, l + 1);
    if (!r) r = codeCaretValueRule(b, l + 1);
    if (!r) r = codeInsertRule(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // KwDescription Colon (String | MultilineString)
  public static boolean description(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "description")) return false;
    if (!nextTokenIs(b, KWDESCRIPTION)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, KWDESCRIPTION, COLON);
    r = r && description_2(b, l + 1);
    exit_section_(b, m, DESCRIPTION, r);
    return r;
  }

  // String | MultilineString
  private static boolean description_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "description_2")) return false;
    boolean r;
    r = consumeToken(b, STRING);
    if (!r) r = consumeToken(b, MULTILINESTRING);
    return r;
  }

  /* ********************************************************** */
  // KwExpression Colon String
  public static boolean expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expression")) return false;
    if (!nextTokenIs(b, KWEXPRESSION)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, KWEXPRESSION, COLON, STRING);
    exit_section_(b, m, EXPRESSION, r);
    return r;
  }

  /* ********************************************************** */
  // KwExtension Colon Identifier sdMetadata_* sdRule_*
  public static boolean extension(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "extension")) return false;
    if (!nextTokenIs(b, KWEXTENSION)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, KWEXTENSION, COLON, IDENTIFIER);
    r = r && extension_3(b, l + 1);
    r = r && extension_4(b, l + 1);
    exit_section_(b, m, EXTENSION, r);
    return r;
  }

  // sdMetadata_*
  private static boolean extension_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "extension_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!sdMetadata_(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "extension_3", c)) break;
    }
    return true;
  }

  // sdRule_*
  private static boolean extension_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "extension_4")) return false;
    while (true) {
      int c = current_position_(b);
      if (!sdRule_(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "extension_4", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // ruleStart path Equal value (LeftParen KwExactly RightParen)?
  public static boolean fixedValueRule(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fixedValueRule")) return false;
    if (!nextTokenIs(b, "<fixed value rule>", STAR, WHITESPACE)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FIXED_VALUE_RULE, "<fixed value rule>");
    r = ruleStart(b, l + 1);
    r = r && path(b, l + 1);
    r = r && consumeToken(b, EQUAL);
    r = r && value(b, l + 1);
    r = r && fixedValueRule_4(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (LeftParen KwExactly RightParen)?
  private static boolean fixedValueRule_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fixedValueRule_4")) return false;
    fixedValueRule_4_0(b, l + 1);
    return true;
  }

  // LeftParen KwExactly RightParen
  private static boolean fixedValueRule_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fixedValueRule_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, LEFTPAREN, KWEXACTLY, RIGHTPAREN);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ruleStart path KwFlag+ (KwAnd path)*
  public static boolean flagRule(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "flagRule")) return false;
    if (!nextTokenIs(b, "<flag rule>", STAR, WHITESPACE)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FLAG_RULE, "<flag rule>");
    r = ruleStart(b, l + 1);
    r = r && path(b, l + 1);
    r = r && flagRule_2(b, l + 1);
    r = r && flagRule_3(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // KwFlag+
  private static boolean flagRule_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "flagRule_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KWFLAG);
    while (r) {
      int c = current_position_(b);
      if (!consumeToken(b, KWFLAG)) break;
      if (!empty_element_parsed_guard_(b, "flagRule_2", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // (KwAnd path)*
  private static boolean flagRule_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "flagRule_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!flagRule_3_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "flagRule_3", c)) break;
    }
    return true;
  }

  // KwAnd path
  private static boolean flagRule_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "flagRule_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KWAND);
    r = r && path(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // any_*
  static boolean fshFile(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fshFile")) return false;
    while (true) {
      int c = current_position_(b);
      if (!any_(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "fshFile", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // KwId Colon Identifier
  public static boolean id(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "id")) return false;
    if (!nextTokenIs(b, KWID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, KWID, COLON, IDENTIFIER);
    exit_section_(b, m, ID, r);
    return r;
  }

  /* ********************************************************** */
  // ruleStart path? KwInsert ruleSetReference
  public static boolean insertRule(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "insertRule")) return false;
    if (!nextTokenIs(b, "<insert rule>", STAR, WHITESPACE)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, INSERT_RULE, "<insert rule>");
    r = ruleStart(b, l + 1);
    r = r && insertRule_1(b, l + 1);
    r = r && consumeToken(b, KWINSERT);
    r = r && ruleSetReference(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // path?
  private static boolean insertRule_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "insertRule_1")) return false;
    path(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // KwInstance Colon Identifier instanceMetadata_* instanceRule*
  public static boolean instance(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "instance")) return false;
    if (!nextTokenIs(b, KWINSTANCE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, KWINSTANCE, COLON, IDENTIFIER);
    r = r && instance_3(b, l + 1);
    r = r && instance_4(b, l + 1);
    exit_section_(b, m, INSTANCE, r);
    return r;
  }

  // instanceMetadata_*
  private static boolean instance_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "instance_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!instanceMetadata_(b, l + 1)) break;
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
  // instanceOf | title | description | usage
  static boolean instanceMetadata_(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "instanceMetadata_")) return false;
    boolean r;
    r = instanceOf(b, l + 1);
    if (!r) r = title(b, l + 1);
    if (!r) r = description(b, l + 1);
    if (!r) r = usage(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // KwInstanceOf Colon itemIdentifier
  public static boolean instanceOf(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "instanceOf")) return false;
    if (!nextTokenIs(b, KWINSTANCEOF)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, KWINSTANCEOF, COLON);
    r = r && itemIdentifier(b, l + 1);
    exit_section_(b, m, INSTANCE_OF, r);
    return r;
  }

  /* ********************************************************** */
  // fixedValueRule | insertRule | pathRule
  public static boolean instanceRule(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "instanceRule")) return false;
    if (!nextTokenIs(b, "<instance rule>", STAR, WHITESPACE)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, INSTANCE_RULE, "<instance rule>");
    r = fixedValueRule(b, l + 1);
    if (!r) r = insertRule(b, l + 1);
    if (!r) r = pathRule(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // Digit+
  public static boolean integer(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "integer")) return false;
    if (!nextTokenIs(b, DIGIT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DIGIT);
    while (r) {
      int c = current_position_(b);
      if (!consumeToken(b, DIGIT)) break;
      if (!empty_element_parsed_guard_(b, "integer", c)) break;
    }
    exit_section_(b, m, INTEGER, r);
    return r;
  }

  /* ********************************************************** */
  // KwInvariant Colon Identifier invariantMetadata_+
  public static boolean invariant(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "invariant")) return false;
    if (!nextTokenIs(b, KWINVARIANT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, KWINVARIANT, COLON, IDENTIFIER);
    r = r && invariant_3(b, l + 1);
    exit_section_(b, m, INVARIANT, r);
    return r;
  }

  // invariantMetadata_+
  private static boolean invariant_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "invariant_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = invariantMetadata_(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!invariantMetadata_(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "invariant_3", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // description | expression | xpath | severity
  static boolean invariantMetadata_(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "invariantMetadata_")) return false;
    boolean r;
    r = description(b, l + 1);
    if (!r) r = expression(b, l + 1);
    if (!r) r = xpath(b, l + 1);
    if (!r) r = severity(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // Identifier | Url
  public static boolean itemIdentifier(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "itemIdentifier")) return false;
    if (!nextTokenIs(b, "<item identifier>", IDENTIFIER, URL)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ITEM_IDENTIFIER, "<item identifier>");
    r = consumeToken(b, IDENTIFIER);
    if (!r) r = consumeToken(b, URL);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // itemIdentifier (KwNamed Identifier)? cardinality KwFlag*
  public static boolean itemType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "itemType")) return false;
    if (!nextTokenIs(b, "<item type>", IDENTIFIER, URL)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ITEM_TYPE, "<item type>");
    r = itemIdentifier(b, l + 1);
    r = r && itemType_1(b, l + 1);
    r = r && cardinality(b, l + 1);
    r = r && itemType_3(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (KwNamed Identifier)?
  private static boolean itemType_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "itemType_1")) return false;
    itemType_1_0(b, l + 1);
    return true;
  }

  // KwNamed Identifier
  private static boolean itemType_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "itemType_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, KWNAMED, IDENTIFIER);
    exit_section_(b, m, null, r);
    return r;
  }

  // KwFlag*
  private static boolean itemType_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "itemType_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, KWFLAG)) break;
      if (!empty_element_parsed_guard_(b, "itemType_3", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // alias | profile | extension | invariant | instance | valueSet | codeSystem | ruleSet |
  //                               mapping | logical | resource
  static boolean item_(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "item_")) return false;
    boolean r;
    r = alias(b, l + 1);
    if (!r) r = profile(b, l + 1);
    if (!r) r = extension(b, l + 1);
    if (!r) r = invariant(b, l + 1);
    if (!r) r = instance(b, l + 1);
    if (!r) r = valueSet(b, l + 1);
    if (!r) r = codeSystem(b, l + 1);
    if (!r) r = ruleSet(b, l + 1);
    if (!r) r = mapping(b, l + 1);
    if (!r) r = logical(b, l + 1);
    if (!r) r = resource(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // KwLogical Colon Identifier sdMetadata_* lrRule_*
  public static boolean logical(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "logical")) return false;
    if (!nextTokenIs(b, KWLOGICAL)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, KWLOGICAL, COLON, IDENTIFIER);
    r = r && logical_3(b, l + 1);
    r = r && logical_4(b, l + 1);
    exit_section_(b, m, LOGICAL, r);
    return r;
  }

  // sdMetadata_*
  private static boolean logical_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "logical_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!sdMetadata_(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "logical_3", c)) break;
    }
    return true;
  }

  // lrRule_*
  private static boolean logical_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "logical_4")) return false;
    while (true) {
      int c = current_position_(b);
      if (!lrRule_(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "logical_4", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // sdRule_ | addElementRule | addCRElementRule
  static boolean lrRule_(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lrRule_")) return false;
    if (!nextTokenIs(b, "", STAR, WHITESPACE)) return false;
    boolean r;
    r = sdRule_(b, l + 1);
    if (!r) r = addElementRule(b, l + 1);
    if (!r) r = addCRElementRule(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // KwMapping Colon Identifier mappingMetadata* mappingEntityRule*
  public static boolean mapping(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "mapping")) return false;
    if (!nextTokenIs(b, KWMAPPING)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, KWMAPPING, COLON, IDENTIFIER);
    r = r && mapping_3(b, l + 1);
    r = r && mapping_4(b, l + 1);
    exit_section_(b, m, MAPPING, r);
    return r;
  }

  // mappingMetadata*
  private static boolean mapping_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "mapping_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!mappingMetadata(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "mapping_3", c)) break;
    }
    return true;
  }

  // mappingEntityRule*
  private static boolean mapping_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "mapping_4")) return false;
    while (true) {
      int c = current_position_(b);
      if (!mappingEntityRule(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "mapping_4", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // mappingRule | insertRule | pathRule
  public static boolean mappingEntityRule(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "mappingEntityRule")) return false;
    if (!nextTokenIs(b, "<mapping entity rule>", STAR, WHITESPACE)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, MAPPING_ENTITY_RULE, "<mapping entity rule>");
    r = mappingRule(b, l + 1);
    if (!r) r = insertRule(b, l + 1);
    if (!r) r = pathRule(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // id | source | target | description | title
  public static boolean mappingMetadata(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "mappingMetadata")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, MAPPING_METADATA, "<mapping metadata>");
    r = id(b, l + 1);
    if (!r) r = source(b, l + 1);
    if (!r) r = target(b, l + 1);
    if (!r) r = description(b, l + 1);
    if (!r) r = title(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // ruleStart path? Arrow String String? code?
  public static boolean mappingRule(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "mappingRule")) return false;
    if (!nextTokenIs(b, "<mapping rule>", STAR, WHITESPACE)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, MAPPING_RULE, "<mapping rule>");
    r = ruleStart(b, l + 1);
    r = r && mappingRule_1(b, l + 1);
    r = r && consumeTokens(b, 0, ARROW, STRING);
    r = r && mappingRule_4(b, l + 1);
    r = r && mappingRule_5(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // path?
  private static boolean mappingRule_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "mappingRule_1")) return false;
    path(b, l + 1);
    return true;
  }

  // String?
  private static boolean mappingRule_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "mappingRule_4")) return false;
    consumeToken(b, STRING);
    return true;
  }

  // code?
  private static boolean mappingRule_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "mappingRule_5")) return false;
    code(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // (Plus | "-")? integer (Dot integer)?
  public static boolean number(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "number")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, NUMBER, "<number>");
    r = number_0(b, l + 1);
    r = r && integer(b, l + 1);
    r = r && number_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (Plus | "-")?
  private static boolean number_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "number_0")) return false;
    number_0_0(b, l + 1);
    return true;
  }

  // Plus | "-"
  private static boolean number_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "number_0_0")) return false;
    boolean r;
    r = consumeToken(b, PLUS);
    if (!r) r = consumeToken(b, "-");
    return r;
  }

  // (Dot integer)?
  private static boolean number_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "number_2")) return false;
    number_2_0(b, l + 1);
    return true;
  }

  // Dot integer
  private static boolean number_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "number_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DOT);
    r = r && integer(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ruleStart path? KwObeys Identifier (KwAnd Identifier)*
  public static boolean obeysRule(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "obeysRule")) return false;
    if (!nextTokenIs(b, "<obeys rule>", STAR, WHITESPACE)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, OBEYS_RULE, "<obeys rule>");
    r = ruleStart(b, l + 1);
    r = r && obeysRule_1(b, l + 1);
    r = r && consumeTokens(b, 0, KWOBEYS, IDENTIFIER);
    r = r && obeysRule_4(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // path?
  private static boolean obeysRule_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "obeysRule_1")) return false;
    path(b, l + 1);
    return true;
  }

  // (KwAnd Identifier)*
  private static boolean obeysRule_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "obeysRule_4")) return false;
    while (true) {
      int c = current_position_(b);
      if (!obeysRule_4_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "obeysRule_4", c)) break;
    }
    return true;
  }

  // KwAnd Identifier
  private static boolean obeysRule_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "obeysRule_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, KWAND, IDENTIFIER);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ruleStart path KwOnly targetType (KwOr targetType)*
  public static boolean onlyRule(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "onlyRule")) return false;
    if (!nextTokenIs(b, "<only rule>", STAR, WHITESPACE)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ONLY_RULE, "<only rule>");
    r = ruleStart(b, l + 1);
    r = r && path(b, l + 1);
    r = r && consumeToken(b, KWONLY);
    r = r && targetType(b, l + 1);
    r = r && onlyRule_4(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (KwOr targetType)*
  private static boolean onlyRule_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "onlyRule_4")) return false;
    while (true) {
      int c = current_position_(b);
      if (!onlyRule_4_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "onlyRule_4", c)) break;
    }
    return true;
  }

  // KwOr targetType
  private static boolean onlyRule_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "onlyRule_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KWOR);
    r = r && targetType(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // KwParent Colon itemIdentifier
  public static boolean parent(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parent")) return false;
    if (!nextTokenIs(b, KWPARENT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, KWPARENT, COLON);
    r = r && itemIdentifier(b, l + 1);
    exit_section_(b, m, PARENT, r);
    return r;
  }

  /* ********************************************************** */
  // Dot | (pathPart (Dot pathPart)*)
  public static boolean path(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "path")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PATH, "<path>");
    r = consumeToken(b, DOT);
    if (!r) r = path_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // pathPart (Dot pathPart)*
  private static boolean path_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "path_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = pathPart(b, l + 1);
    r = r && path_1_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (Dot pathPart)*
  private static boolean path_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "path_1_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!path_1_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "path_1_1", c)) break;
    }
    return true;
  }

  // Dot pathPart
  private static boolean path_1_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "path_1_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DOT);
    r = r && pathPart(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (Identifier | KwSystem) bracketSuffix*
  public static boolean pathPart(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pathPart")) return false;
    if (!nextTokenIs(b, "<path part>", IDENTIFIER, KWSYSTEM)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PATH_PART, "<path part>");
    r = pathPart_0(b, l + 1);
    r = r && pathPart_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // Identifier | KwSystem
  private static boolean pathPart_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pathPart_0")) return false;
    boolean r;
    r = consumeToken(b, IDENTIFIER);
    if (!r) r = consumeToken(b, KWSYSTEM);
    return r;
  }

  // bracketSuffix*
  private static boolean pathPart_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pathPart_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!bracketSuffix(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "pathPart_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // ruleStart path
  public static boolean pathRule(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pathRule")) return false;
    if (!nextTokenIs(b, "<path rule>", STAR, WHITESPACE)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PATH_RULE, "<path rule>");
    r = ruleStart(b, l + 1);
    r = r && path(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // KwProfile Colon Identifier sdMetadata_+ sdRule_*
  public static boolean profile(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "profile")) return false;
    if (!nextTokenIs(b, KWPROFILE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, KWPROFILE, COLON, IDENTIFIER);
    r = r && profile_3(b, l + 1);
    r = r && profile_4(b, l + 1);
    exit_section_(b, m, PROFILE, r);
    return r;
  }

  // sdMetadata_+
  private static boolean profile_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "profile_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = sdMetadata_(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!sdMetadata_(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "profile_3", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // sdRule_*
  private static boolean profile_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "profile_4")) return false;
    while (true) {
      int c = current_position_(b);
      if (!sdRule_(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "profile_4", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // number (Unit | code) String?
  public static boolean quantity(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "quantity")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, QUANTITY, "<quantity>");
    r = number(b, l + 1);
    r = r && quantity_1(b, l + 1);
    r = r && quantity_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // Unit | code
  private static boolean quantity_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "quantity_1")) return false;
    boolean r;
    r = consumeToken(b, UNIT);
    if (!r) r = code(b, l + 1);
    return r;
  }

  // String?
  private static boolean quantity_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "quantity_2")) return false;
    consumeToken(b, STRING);
    return true;
  }

  /* ********************************************************** */
  // (number | quantity) Colon (number | quantity)
  public static boolean ratio(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ratio")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, RATIO, "<ratio>");
    r = ratio_0(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && ratio_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // number | quantity
  private static boolean ratio_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ratio_0")) return false;
    boolean r;
    r = number(b, l + 1);
    if (!r) r = quantity(b, l + 1);
    return r;
  }

  // number | quantity
  private static boolean ratio_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ratio_2")) return false;
    boolean r;
    r = number(b, l + 1);
    if (!r) r = quantity(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // !(any_)
  static boolean recover(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "recover")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !recover_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (any_)
  private static boolean recover_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "recover_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = any_(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // KwReference LeftParen itemIdentifier (KwOr itemIdentifier)* RightParen
  public static boolean referenceType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "referenceType")) return false;
    if (!nextTokenIs(b, KWREFERENCE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, KWREFERENCE, LEFTPAREN);
    r = r && itemIdentifier(b, l + 1);
    r = r && referenceType_3(b, l + 1);
    r = r && consumeToken(b, RIGHTPAREN);
    exit_section_(b, m, REFERENCE_TYPE, r);
    return r;
  }

  // (KwOr itemIdentifier)*
  private static boolean referenceType_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "referenceType_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!referenceType_3_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "referenceType_3", c)) break;
    }
    return true;
  }

  // KwOr itemIdentifier
  private static boolean referenceType_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "referenceType_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KWOR);
    r = r && itemIdentifier(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // KwResource Colon Identifier sdMetadata_* lrRule_*
  public static boolean resource(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "resource")) return false;
    if (!nextTokenIs(b, KWRESOURCE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, KWRESOURCE, COLON, IDENTIFIER);
    r = r && resource_3(b, l + 1);
    r = r && resource_4(b, l + 1);
    exit_section_(b, m, RESOURCE, r);
    return r;
  }

  // sdMetadata_*
  private static boolean resource_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "resource_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!sdMetadata_(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "resource_3", c)) break;
    }
    return true;
  }

  // lrRule_*
  private static boolean resource_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "resource_4")) return false;
    while (true) {
      int c = current_position_(b);
      if (!lrRule_(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "resource_4", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // KwRuleSet Colon ruleSetReference ruleSetRule+
  public static boolean ruleSet(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ruleSet")) return false;
    if (!nextTokenIs(b, KWRULESET)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, KWRULESET, COLON);
    r = r && ruleSetReference(b, l + 1);
    r = r && ruleSet_3(b, l + 1);
    exit_section_(b, m, RULE_SET, r);
    return r;
  }

  // ruleSetRule+
  private static boolean ruleSet_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ruleSet_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ruleSetRule(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!ruleSetRule(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "ruleSet_3", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // Identifier (LeftParen Identifier (Comma Identifier)* RightParen)?
  public static boolean ruleSetReference(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ruleSetReference")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    r = r && ruleSetReference_1(b, l + 1);
    exit_section_(b, m, RULE_SET_REFERENCE, r);
    return r;
  }

  // (LeftParen Identifier (Comma Identifier)* RightParen)?
  private static boolean ruleSetReference_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ruleSetReference_1")) return false;
    ruleSetReference_1_0(b, l + 1);
    return true;
  }

  // LeftParen Identifier (Comma Identifier)* RightParen
  private static boolean ruleSetReference_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ruleSetReference_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, LEFTPAREN, IDENTIFIER);
    r = r && ruleSetReference_1_0_2(b, l + 1);
    r = r && consumeToken(b, RIGHTPAREN);
    exit_section_(b, m, null, r);
    return r;
  }

  // (Comma Identifier)*
  private static boolean ruleSetReference_1_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ruleSetReference_1_0_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!ruleSetReference_1_0_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "ruleSetReference_1_0_2", c)) break;
    }
    return true;
  }

  // Comma Identifier
  private static boolean ruleSetReference_1_0_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ruleSetReference_1_0_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, COMMA, IDENTIFIER);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // sdRule_ | addElementRule | addCRElementRule | concept | codeCaretValueRule |
  //                               codeInsertRule | vsComponent | mappingRule
  public static boolean ruleSetRule(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ruleSetRule")) return false;
    if (!nextTokenIs(b, "<rule set rule>", STAR, WHITESPACE)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, RULE_SET_RULE, "<rule set rule>");
    r = sdRule_(b, l + 1);
    if (!r) r = addElementRule(b, l + 1);
    if (!r) r = addCRElementRule(b, l + 1);
    if (!r) r = concept(b, l + 1);
    if (!r) r = codeCaretValueRule(b, l + 1);
    if (!r) r = codeInsertRule(b, l + 1);
    if (!r) r = vsComponent(b, l + 1);
    if (!r) r = mappingRule(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // WhiteSpace* Star
  public static boolean ruleStart(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ruleStart")) return false;
    if (!nextTokenIs(b, "<rule start>", STAR, WHITESPACE)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, RULE_START, "<rule start>");
    r = ruleStart_0(b, l + 1);
    r = r && consumeToken(b, STAR);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // WhiteSpace*
  private static boolean ruleStart_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ruleStart_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, WHITESPACE)) break;
      if (!empty_element_parsed_guard_(b, "ruleStart_0", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // parent | id | title | description
  static boolean sdMetadata_(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sdMetadata_")) return false;
    boolean r;
    r = parent(b, l + 1);
    if (!r) r = id(b, l + 1);
    if (!r) r = title(b, l + 1);
    if (!r) r = description(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // cardRule | flagRule | valueSetRule | fixedValueRule | containsRule | onlyRule |
  //                               obeysRule | caretValueRule | insertRule | pathRule
  static boolean sdRule_(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sdRule_")) return false;
    if (!nextTokenIs(b, "", STAR, WHITESPACE)) return false;
    boolean r;
    r = cardRule(b, l + 1);
    if (!r) r = flagRule(b, l + 1);
    if (!r) r = valueSetRule(b, l + 1);
    if (!r) r = fixedValueRule(b, l + 1);
    if (!r) r = containsRule(b, l + 1);
    if (!r) r = onlyRule(b, l + 1);
    if (!r) r = obeysRule(b, l + 1);
    if (!r) r = caretValueRule(b, l + 1);
    if (!r) r = insertRule(b, l + 1);
    if (!r) r = pathRule(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // KwSeverity Colon code
  public static boolean severity(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "severity")) return false;
    if (!nextTokenIs(b, KWSEVERITY)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, KWSEVERITY, COLON);
    r = r && code(b, l + 1);
    exit_section_(b, m, SEVERITY, r);
    return r;
  }

  /* ********************************************************** */
  // KwSource Colon Identifier
  public static boolean source(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "source")) return false;
    if (!nextTokenIs(b, KWSOURCE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, KWSOURCE, COLON, IDENTIFIER);
    exit_section_(b, m, SOURCE, r);
    return r;
  }

  /* ********************************************************** */
  // LeftParen KwBindingStrength RightParen
  public static boolean strength(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "strength")) return false;
    if (!nextTokenIs(b, LEFTPAREN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, LEFTPAREN, KWBINDINGSTRENGTH, RIGHTPAREN);
    exit_section_(b, m, STRENGTH, r);
    return r;
  }

  /* ********************************************************** */
  // KwTarget Colon String
  public static boolean target(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "target")) return false;
    if (!nextTokenIs(b, KWTARGET)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, KWTARGET, COLON, STRING);
    exit_section_(b, m, TARGET, r);
    return r;
  }

  /* ********************************************************** */
  // Identifier | referenceType | canonical
  public static boolean targetType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "targetType")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TARGET_TYPE, "<target type>");
    r = consumeToken(b, IDENTIFIER);
    if (!r) r = referenceType(b, l + 1);
    if (!r) r = canonical(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // KwTitle Colon String
  public static boolean title(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "title")) return false;
    if (!nextTokenIs(b, KWTITLE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, KWTITLE, COLON, STRING);
    exit_section_(b, m, TITLE, r);
    return r;
  }

  /* ********************************************************** */
  // KwUsage Colon code
  public static boolean usage(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "usage")) return false;
    if (!nextTokenIs(b, KWUSAGE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, KWUSAGE, COLON);
    r = r && code(b, l + 1);
    exit_section_(b, m, USAGE, r);
    return r;
  }

  /* ********************************************************** */
  // String | MultilineString | number | Datetime | Time | referenceType | canonical | code | quantity | ratio | KwBoolean
  public static boolean value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "value")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, VALUE, "<value>");
    r = consumeToken(b, STRING);
    if (!r) r = consumeToken(b, MULTILINESTRING);
    if (!r) r = number(b, l + 1);
    if (!r) r = consumeToken(b, DATETIME);
    if (!r) r = consumeToken(b, TIME);
    if (!r) r = referenceType(b, l + 1);
    if (!r) r = canonical(b, l + 1);
    if (!r) r = code(b, l + 1);
    if (!r) r = quantity(b, l + 1);
    if (!r) r = ratio(b, l + 1);
    if (!r) r = consumeToken(b, KWBOOLEAN);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // KwValueSet Colon Identifier vsMetadata_* vsRule_*
  public static boolean valueSet(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "valueSet")) return false;
    if (!nextTokenIs(b, KWVALUESET)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, KWVALUESET, COLON, IDENTIFIER);
    r = r && valueSet_3(b, l + 1);
    r = r && valueSet_4(b, l + 1);
    exit_section_(b, m, VALUE_SET, r);
    return r;
  }

  // vsMetadata_*
  private static boolean valueSet_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "valueSet_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!vsMetadata_(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "valueSet_3", c)) break;
    }
    return true;
  }

  // vsRule_*
  private static boolean valueSet_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "valueSet_4")) return false;
    while (true) {
      int c = current_position_(b);
      if (!vsRule_(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "valueSet_4", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // ruleStart path KwFrom itemIdentifier strength?
  public static boolean valueSetRule(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "valueSetRule")) return false;
    if (!nextTokenIs(b, "<value set rule>", STAR, WHITESPACE)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, VALUE_SET_RULE, "<value set rule>");
    r = ruleStart(b, l + 1);
    r = r && path(b, l + 1);
    r = r && consumeToken(b, KWFROM);
    r = r && itemIdentifier(b, l + 1);
    r = r && valueSetRule_4(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // strength?
  private static boolean valueSetRule_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "valueSetRule_4")) return false;
    strength(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // ruleStart (KwInclude | KwExclude)? (vsConceptComponent | vsFilterComponent)
  public static boolean vsComponent(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "vsComponent")) return false;
    if (!nextTokenIs(b, "<vs component>", STAR, WHITESPACE)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, VS_COMPONENT, "<vs component>");
    r = ruleStart(b, l + 1);
    r = r && vsComponent_1(b, l + 1);
    r = r && vsComponent_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (KwInclude | KwExclude)?
  private static boolean vsComponent_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "vsComponent_1")) return false;
    vsComponent_1_0(b, l + 1);
    return true;
  }

  // KwInclude | KwExclude
  private static boolean vsComponent_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "vsComponent_1_0")) return false;
    boolean r;
    r = consumeToken(b, KWINCLUDE);
    if (!r) r = consumeToken(b, KWEXCLUDE);
    return r;
  }

  // vsConceptComponent | vsFilterComponent
  private static boolean vsComponent_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "vsComponent_2")) return false;
    boolean r;
    r = vsConceptComponent(b, l + 1);
    if (!r) r = vsFilterComponent(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // KwFrom (vsFromSystem (KwAnd vsFromValueset)? | vsFromValueset (KwAnd vsFromSystem)?)
  public static boolean vsComponentFrom(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "vsComponentFrom")) return false;
    if (!nextTokenIs(b, KWFROM)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KWFROM);
    r = r && vsComponentFrom_1(b, l + 1);
    exit_section_(b, m, VS_COMPONENT_FROM, r);
    return r;
  }

  // vsFromSystem (KwAnd vsFromValueset)? | vsFromValueset (KwAnd vsFromSystem)?
  private static boolean vsComponentFrom_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "vsComponentFrom_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = vsComponentFrom_1_0(b, l + 1);
    if (!r) r = vsComponentFrom_1_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // vsFromSystem (KwAnd vsFromValueset)?
  private static boolean vsComponentFrom_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "vsComponentFrom_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = vsFromSystem(b, l + 1);
    r = r && vsComponentFrom_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (KwAnd vsFromValueset)?
  private static boolean vsComponentFrom_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "vsComponentFrom_1_0_1")) return false;
    vsComponentFrom_1_0_1_0(b, l + 1);
    return true;
  }

  // KwAnd vsFromValueset
  private static boolean vsComponentFrom_1_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "vsComponentFrom_1_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KWAND);
    r = r && vsFromValueset(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // vsFromValueset (KwAnd vsFromSystem)?
  private static boolean vsComponentFrom_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "vsComponentFrom_1_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = vsFromValueset(b, l + 1);
    r = r && vsComponentFrom_1_1_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (KwAnd vsFromSystem)?
  private static boolean vsComponentFrom_1_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "vsComponentFrom_1_1_1")) return false;
    vsComponentFrom_1_1_1_0(b, l + 1);
    return true;
  }

  // KwAnd vsFromSystem
  private static boolean vsComponentFrom_1_1_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "vsComponentFrom_1_1_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KWAND);
    r = r && vsFromSystem(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (code vsComponentFrom?) | (code (KwAnd code)* vsComponentFrom)
  public static boolean vsConceptComponent(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "vsConceptComponent")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, VS_CONCEPT_COMPONENT, "<vs concept component>");
    r = vsConceptComponent_0(b, l + 1);
    if (!r) r = vsConceptComponent_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // code vsComponentFrom?
  private static boolean vsConceptComponent_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "vsConceptComponent_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = code(b, l + 1);
    r = r && vsConceptComponent_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // vsComponentFrom?
  private static boolean vsConceptComponent_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "vsConceptComponent_0_1")) return false;
    vsComponentFrom(b, l + 1);
    return true;
  }

  // code (KwAnd code)* vsComponentFrom
  private static boolean vsConceptComponent_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "vsConceptComponent_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = code(b, l + 1);
    r = r && vsConceptComponent_1_1(b, l + 1);
    r = r && vsComponentFrom(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (KwAnd code)*
  private static boolean vsConceptComponent_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "vsConceptComponent_1_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!vsConceptComponent_1_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "vsConceptComponent_1_1", c)) break;
    }
    return true;
  }

  // KwAnd code
  private static boolean vsConceptComponent_1_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "vsConceptComponent_1_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KWAND);
    r = r && code(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // KwCodes vsComponentFrom (KwWhere vsFilterList)?
  public static boolean vsFilterComponent(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "vsFilterComponent")) return false;
    if (!nextTokenIs(b, KWCODES)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KWCODES);
    r = r && vsComponentFrom(b, l + 1);
    r = r && vsFilterComponent_2(b, l + 1);
    exit_section_(b, m, VS_FILTER_COMPONENT, r);
    return r;
  }

  // (KwWhere vsFilterList)?
  private static boolean vsFilterComponent_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "vsFilterComponent_2")) return false;
    vsFilterComponent_2_0(b, l + 1);
    return true;
  }

  // KwWhere vsFilterList
  private static boolean vsFilterComponent_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "vsFilterComponent_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KWWHERE);
    r = r && vsFilterList(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // Identifier vsFilterOperator vsFilterValue?
  public static boolean vsFilterDefinition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "vsFilterDefinition")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    r = r && vsFilterOperator(b, l + 1);
    r = r && vsFilterDefinition_2(b, l + 1);
    exit_section_(b, m, VS_FILTER_DEFINITION, r);
    return r;
  }

  // vsFilterValue?
  private static boolean vsFilterDefinition_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "vsFilterDefinition_2")) return false;
    vsFilterValue(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // vsFilterDefinition (KwAnd vsFilterDefinition)*
  public static boolean vsFilterList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "vsFilterList")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = vsFilterDefinition(b, l + 1);
    r = r && vsFilterList_1(b, l + 1);
    exit_section_(b, m, VS_FILTER_LIST, r);
    return r;
  }

  // (KwAnd vsFilterDefinition)*
  private static boolean vsFilterList_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "vsFilterList_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!vsFilterList_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "vsFilterList_1", c)) break;
    }
    return true;
  }

  // KwAnd vsFilterDefinition
  private static boolean vsFilterList_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "vsFilterList_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KWAND);
    r = r && vsFilterDefinition(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // Equal | KwCodeOperator
  public static boolean vsFilterOperator(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "vsFilterOperator")) return false;
    if (!nextTokenIs(b, "<vs filter operator>", EQUAL, KWCODEOPERATOR)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, VS_FILTER_OPERATOR, "<vs filter operator>");
    r = consumeToken(b, EQUAL);
    if (!r) r = consumeToken(b, KWCODEOPERATOR);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // code | KwBoolean | Regex | String
  public static boolean vsFilterValue(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "vsFilterValue")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, VS_FILTER_VALUE, "<vs filter value>");
    r = code(b, l + 1);
    if (!r) r = consumeToken(b, KWBOOLEAN);
    if (!r) r = consumeToken(b, REGEX);
    if (!r) r = consumeToken(b, STRING);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // KwSystem itemIdentifier
  public static boolean vsFromSystem(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "vsFromSystem")) return false;
    if (!nextTokenIs(b, KWSYSTEM)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KWSYSTEM);
    r = r && itemIdentifier(b, l + 1);
    exit_section_(b, m, VS_FROM_SYSTEM, r);
    return r;
  }

  /* ********************************************************** */
  // KwValueSetRef itemIdentifier (KwAnd itemIdentifier)*
  public static boolean vsFromValueset(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "vsFromValueset")) return false;
    if (!nextTokenIs(b, KWVALUESETREF)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KWVALUESETREF);
    r = r && itemIdentifier(b, l + 1);
    r = r && vsFromValueset_2(b, l + 1);
    exit_section_(b, m, VS_FROM_VALUESET, r);
    return r;
  }

  // (KwAnd itemIdentifier)*
  private static boolean vsFromValueset_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "vsFromValueset_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!vsFromValueset_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "vsFromValueset_2", c)) break;
    }
    return true;
  }

  // KwAnd itemIdentifier
  private static boolean vsFromValueset_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "vsFromValueset_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KWAND);
    r = r && itemIdentifier(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // id | title | description
  static boolean vsMetadata_(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "vsMetadata_")) return false;
    boolean r;
    r = id(b, l + 1);
    if (!r) r = title(b, l + 1);
    if (!r) r = description(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // vsComponent | caretValueRule | insertRule
  static boolean vsRule_(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "vsRule_")) return false;
    if (!nextTokenIs(b, "", STAR, WHITESPACE)) return false;
    boolean r;
    r = vsComponent(b, l + 1);
    if (!r) r = caretValueRule(b, l + 1);
    if (!r) r = insertRule(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // KwXPath Colon String
  public static boolean xpath(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "xpath")) return false;
    if (!nextTokenIs(b, KWXPATH)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, KWXPATH, COLON, STRING);
    exit_section_(b, m, XPATH, r);
    return r;
  }

}

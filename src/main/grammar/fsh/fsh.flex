// JFlex lexer for FHIR Shorthand (FSH), for the IntelliJ Platform (wrapped in FlexAdapter).
// Design: docs/grammar-kit-design.md (decisions D2-D8). Language reference: docs/fsh-language.md.
//
// Key points:
// - Word-level tokens like SUSHI: a word is any run of non-whitespace characters, classified by shape. Words are never split at
//   '.', '[', '#', ',' or '(' (D2).
// - A '*' is a rule marker (STAR) when only blanks precede it on its line. This is checked by looking back in the buffer, not with
//   lexer state, so incremental restarts stay correct (D4).
// - Declaration and metadata keywords need a following ':'; Reference/Canonical/CodeableReference need a following '(' (D5).
// - Bounded states only: argument lists of insert/RuleSet, and the parentheses of reference forms (D6). Every state exits at a
//   line-start '*' as a safety net.
// - Unterminated strings, triple-quoted strings and block comments end at the end of their first line (D7).
package ch.qligier.jetbrains.plugin.fss.fsh.language;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.TokenType;

import java.util.HashMap;
import java.util.Map;

import static ch.qligier.jetbrains.plugin.fss.fsh.language.psi.FshTypes.*;

%%

%class FshLexer
%implements FlexLexer
%unicode
%public
%function advance
%type IElementType

%{
  /** Keywords recognized only when followed by ':' (optionally after blanks on the same line). */
  private static final Map<String, IElementType> COLON_KEYWORDS = new HashMap<>();
  /** Keywords recognized only when followed by '(' (optionally after blanks on the same line). */
  private static final Map<String, IElementType> PAREN_KEYWORDS = new HashMap<>();
  /** Keywords recognized when the whole word equals them. The grammar also accepts them as names. */
  private static final Map<String, IElementType> WORD_KEYWORDS = new HashMap<>();

  static {
    COLON_KEYWORDS.put("Alias", KW_ALIAS);
    COLON_KEYWORDS.put("Profile", KW_PROFILE);
    COLON_KEYWORDS.put("Extension", KW_EXTENSION);
    COLON_KEYWORDS.put("Instance", KW_INSTANCE);
    COLON_KEYWORDS.put("Invariant", KW_INVARIANT);
    COLON_KEYWORDS.put("ValueSet", KW_VALUESET);
    COLON_KEYWORDS.put("CodeSystem", KW_CODESYSTEM);
    COLON_KEYWORDS.put("RuleSet", KW_RULESET);
    COLON_KEYWORDS.put("Mapping", KW_MAPPING);
    COLON_KEYWORDS.put("Logical", KW_LOGICAL);
    COLON_KEYWORDS.put("Resource", KW_RESOURCE);
    COLON_KEYWORDS.put("Parent", KW_PARENT);
    COLON_KEYWORDS.put("Id", KW_ID);
    COLON_KEYWORDS.put("Title", KW_TITLE);
    COLON_KEYWORDS.put("Description", KW_DESCRIPTION);
    COLON_KEYWORDS.put("Expression", KW_EXPRESSION);
    COLON_KEYWORDS.put("XPath", KW_XPATH);
    COLON_KEYWORDS.put("Severity", KW_SEVERITY);
    COLON_KEYWORDS.put("InstanceOf", KW_INSTANCEOF);
    COLON_KEYWORDS.put("Usage", KW_USAGE);
    COLON_KEYWORDS.put("Source", KW_SOURCE);
    COLON_KEYWORDS.put("Target", KW_TARGET);
    COLON_KEYWORDS.put("Context", KW_CONTEXT);
    COLON_KEYWORDS.put("Characteristics", KW_CHARACTERISTICS);

    PAREN_KEYWORDS.put("Reference", KW_REFERENCE);
    PAREN_KEYWORDS.put("Canonical", KW_CANONICAL);
    PAREN_KEYWORDS.put("CodeableReference", KW_CODEABLE_REFERENCE);

    WORD_KEYWORDS.put("from", KW_FROM);
    WORD_KEYWORDS.put("contains", KW_CONTAINS);
    WORD_KEYWORDS.put("named", KW_NAMED);
    WORD_KEYWORDS.put("and", KW_AND);
    WORD_KEYWORDS.put("or", KW_OR);
    WORD_KEYWORDS.put("only", KW_ONLY);
    WORD_KEYWORDS.put("obeys", KW_OBEYS);
    WORD_KEYWORDS.put("insert", KW_INSERT);
    WORD_KEYWORDS.put("include", KW_INCLUDE);
    WORD_KEYWORDS.put("exclude", KW_EXCLUDE);
    WORD_KEYWORDS.put("codes", KW_CODES);
    WORD_KEYWORDS.put("where", KW_WHERE);
    WORD_KEYWORDS.put("valueset", KW_VALUESET_REF);
    WORD_KEYWORDS.put("system", KW_SYSTEM);
    WORD_KEYWORDS.put("contentReference", KW_CONTENT_REFERENCE);
    WORD_KEYWORDS.put("true", KW_TRUE);
    WORD_KEYWORDS.put("false", KW_FALSE);
    WORD_KEYWORDS.put("MS", KW_MS);
    WORD_KEYWORDS.put("SU", KW_SU);
    WORD_KEYWORDS.put("TU", KW_TU);
    WORD_KEYWORDS.put("N", KW_N);
    WORD_KEYWORDS.put("D", KW_D);
    WORD_KEYWORDS.put("?!", KW_MOD);
  }

  private static boolean isBlank(char c) {
    return c == ' ' || c == '\t' || c == '\f' || c == ' ';
  }

  private static boolean isLineBreak(char c) {
    return c == '\n' || c == '\r';
  }

  /** True when only blanks separate {@code pos} from the start of its line (or of the buffer). Looks before the start offset. */
  private boolean atLineStart(int pos) {
    for (int i = pos - 1; i >= 0; i--) {
      char c = zzBuffer.charAt(i);
      if (isLineBreak(c)) return true;
      if (!isBlank(c)) return false;
    }
    return true;
  }

  /** True when the next non-blank character after the current token, on the same line, is {@code expected}. */
  private boolean nextNonBlankIs(char expected) {
    int i = zzMarkedPos;
    while (i < zzEndRead && isBlank(zzBuffer.charAt(i))) i++;
    return i < zzEndRead && zzBuffer.charAt(i) == expected;
  }

  /**
   * Restart points (D4): the editor re-lexes from a token whose state is 0 and stops at the first later token whose start, type and
   * state match the old ones. So only the first token of a line is lexed in YYINITIAL (state 0); the other tokens of the line are lexed
   * in IN_LINE, so that any decision that depends on the rest of its line (a line-start '*', a keyword's ':', a regex's closing '/')
   * is re-lexed after an edit on that line.
   *
   * After an unterminated token (cut at its line end, D7), a closer typed anywhere later changes that earlier token. So the rest of the
   * input is lexed in DIRTY, which has no restart point: an edit after the cut re-lexes from the cut token.
   */
  private boolean dirty;

  /** Called by FshLexerAdapter on every (re)start: lexing restarts at state-0 tokens, or in DIRTY when a caller asks for it. */
  public void resetLineState(int initialState) {
    dirty = initialState == DIRTY;
  }

  /** The state for the next token, after a token of the main rules. Leaves bounded states (entered by the action) alone. */
  private IElementType token(IElementType type) {
    int state = yystate();
    if (state != YYINITIAL && state != IN_LINE && state != DIRTY) return type;
    if (dirty) yybegin(DIRTY);
    else if (type == TokenType.WHITE_SPACE) {
      for (int i = zzStartRead; i < zzMarkedPos; i++) {
        if (isLineBreak(zzBuffer.charAt(i))) {
          yybegin(YYINITIAL);
          break;
        }
      }
    } else yybegin(IN_LINE);
    return type;
  }

  /** The state to return to when a bounded state ends in the middle of a line. */
  private int inLine() {
    return dirty ? DIRTY : IN_LINE;
  }

  /** The state to return to when a bounded state ends at a line-start '*' or declaration, which is then lexed again from there. */
  private int lineStart() {
    return dirty ? DIRTY : YYINITIAL;
  }

  /** Declaration keywords, in the order of COLON_KEYWORDS. */
  private static final java.util.Set<String> DECLARATION_KEYWORDS =
    java.util.Set.of("Alias", "Profile", "Extension", "Instance", "Invariant", "ValueSet", "CodeSystem", "RuleSet", "Mapping", "Logical", "Resource");

  /**
   * A string or triple-quoted string that would run across a line starting with a declaration (`Profile:`) counts as unterminated
   * (D7): no string of a SUSHI-clean corpus file does, while a missing closing quote would otherwise pair with a quote of a later
   * entity and swallow everything in between. Block comments are exempt: commented-out entities are common.
   */
  private IElementType stringOrCut(IElementType type) {
    for (int i = zzStartRead; i < zzMarkedPos; i++) {
      if (!isLineBreak(zzBuffer.charAt(i))) continue;
      int start = i + 1;
      while (start < zzMarkedPos && isBlank(zzBuffer.charAt(start))) start++;
      int end = start;
      while (end < zzMarkedPos && Character.isLetter(zzBuffer.charAt(end))) end++;
      if (end == start || !DECLARATION_KEYWORDS.contains(zzBuffer.subSequence(start, end).toString())) continue;
      int colon = end;
      while (colon < zzMarkedPos && isBlank(zzBuffer.charAt(colon))) colon++;
      if (colon < zzMarkedPos && zzBuffer.charAt(colon) == ':') return cutAtLineEnd(type);
    }
    return type;
  }

  /** Keeps only the first line of an unterminated token; the rest is lexed normally (D7), in DIRTY. */
  private IElementType cutAtLineEnd(IElementType type) {
    dirty = true;
    for (int i = zzStartRead; i < zzMarkedPos; i++) {
      if (isLineBreak(zzBuffer.charAt(i))) {
        yypushback(zzMarkedPos - i);
        break;
      }
    }
    return type;
  }

  /** A CODE whose '#' sits inside unclosed brackets (extension[http://x#y].value) is a path word, not a code (D8). */
  private IElementType codeOrWord() {
    int hash = -1;
    int depth = 0;
    for (int i = zzStartRead; i < zzMarkedPos; i++) {
      char c = zzBuffer.charAt(i);
      if (c == '[') depth++;
      else if (c == ']') depth--;
      else if (c == '#') {
        hash = i;
        break;
      }
    }
    return hash >= 0 && depth > 0 ? WORD : CODE;
  }

  /** Classifies a word: keywords by context, everything else is WORD (D5). */
  private IElementType word() {
    String text = yytext().toString();
    int length = text.length();

    int colon = text.indexOf(':');
    if (colon > 0) {
      IElementType keyword = COLON_KEYWORDS.get(text.substring(0, colon));
      if (keyword != null) {
        yypushback(length - colon);
        return afterKeyword(keyword);
      }
    } else {
      IElementType keyword = COLON_KEYWORDS.get(text);
      if (keyword != null && nextNonBlankIs(':')) return afterKeyword(keyword);
    }

    int paren = text.indexOf('(');
    IElementType referenceKeyword = PAREN_KEYWORDS.get(paren > 0 ? text.substring(0, paren) : text);
    if (referenceKeyword != null && (paren > 0 || nextNonBlankIs('('))) {
      if (paren > 0) yypushback(length - paren);
      yybegin(REF_OPEN);
      return referenceKeyword;
    }

    IElementType keyword = WORD_KEYWORDS.get(text);
    if (keyword != null) {
      if (keyword == KW_INSERT) yybegin(AFTER_INSERT);
      return keyword;
    }
    return WORD;
  }

  /**
   * After a colon keyword, the ':' (after blanks, and even glued to the next word: `Profile :Name`) is lexed in a state of its own.
   * Deciding it by looking back at the keyword would break the editor's incremental re-lexing: after an edit to the keyword, the
   * highlighter resynchronizes at the state-0 whitespace token and keeps the old ':' token.
   */
  private IElementType afterKeyword(IElementType keyword) {
    yybegin(keyword == KW_RULESET ? AFTER_RULESET_KEYWORD : AFTER_COLON_KEYWORD);
    return keyword;
  }

  /** True when the current token, at line start, is a declaration or metadata keyword followed by ':'. Used to leave bounded states. */
  private boolean declarationAhead() {
    if (!atLineStart(zzStartRead)) return false;
    String text = yytext().toString();
    int colon = text.indexOf(':');
    String head = colon > 0 ? text.substring(0, colon) : text;
    return COLON_KEYWORDS.containsKey(head) && (colon > 0 || nextNonBlankIs(':'));
  }
%}

BLANK               = [ \t\f ]
ANY_WS              = [ \t\f \r\n]
NONWS               = [^ \t\f \r\n]
DIGIT               = [0-9]

// Comments
BLOCK_COMMENT_OPEN  = "/*" ([^*] | "*"+ [^*/])* "*"*

// Strings: the "open" forms cannot contain their closer, so the terminated form always wins when a closer exists
STRING_BODY         = ([^\"\\] | \\[^])*
STRING_TERMINATED   = \" {STRING_BODY} \"
STRING_OPEN         = \" {STRING_BODY} \\?
TRIPLE_TERMINATED   = \"\"\" ~(\"\"\") \"? \"?
TRIPLE_OPEN         = \"\"\" ([^\"] | \"[^\"] | \"\"[^\"])* \"? \"?

// Words with a shape (mirroring SUSHI's FSHLexer.g4; on equal length the earlier rule wins)
NUMBER              = [+\-]? {DIGIT}+ ("." {DIGIT}+)? ([eE] [+\-]? {DIGIT}+)?
TIME                = {DIGIT}{2} (":" {DIGIT}{2} (":" {DIGIT}{2} ("." {DIGIT}+)?)?)? ("Z" | [+\-] {DIGIT}{2} ":" {DIGIT}{2})?
DATE_TIME           = {DIGIT}{4} ("-" {DIGIT}{2} ("-" {DIGIT}{2} ("T" {TIME})?)?)?
CARD                = {DIGIT}* ".." ({DIGIT}+ | "*")?
CODE_QUOTED_PART    = [^ \t\f \r\n\\\"] | \\\" | \\\\
// Quoted codes (#"code with spaces") stay on one line, so a stray #" cannot run across lines
CODE_QUOTED         = \" {CODE_QUOTED_PART}+ ({BLANK}+ {CODE_QUOTED_PART}+)* \"
CODE                = {NONWS}* "#" ({NONWS}+ | {CODE_QUOTED})
// A unit stays on one line (SUSHI's may span lines, but no corpus unit does): a lone quote must not swallow the following lines
UNIT                = \' [^\'\\\r\n]* \'
CARET_PATH          = "^" {NONWS}+
REGEX               = "/" ("\\/" | [^*/\r\n]) ("\\/" | [^/\r\n])* "/"

// Insert and RuleSet arguments
// Like SUSHI's PLAIN_PARAM (longest match), a comma preceded by a backslash never ends an argument, even after an escaped backslash (`\\,`). A ')' after `\\` still closes the list.
ARG_TEXT            = ([^,)\\ \t\f \r\n] | \\[^] | \\+ ",")+
BRACKET_BODY        = ([^\]] | "]" [^\]] | "]]" {BLANK}* [^,) \t\f \r\n\]])*
ARG_BRACKETED       = "[[" {BRACKET_BODY} "]]"

%state IN_LINE, DIRTY
%xstate REF_OPEN, REF_PARENS, AFTER_INSERT, AFTER_INSERT_NAME, AFTER_RULESET_KEYWORD, AFTER_COLON_KEYWORD, ARGS

%%

<YYINITIAL, IN_LINE, DIRTY> {
  {ANY_WS}+                               { return token(TokenType.WHITE_SPACE); }

  "//" [^\r\n]*                           { return token(LINE_COMMENT); }
  "/*" ~"*/"                              { return token(BLOCK_COMMENT); }
  {BLOCK_COMMENT_OPEN}                    { return token(cutAtLineEnd(BLOCK_COMMENT)); }

  {TRIPLE_TERMINATED}                     { return token(stringOrCut(MULTILINE_STRING)); }
  {TRIPLE_OPEN}                           { return token(cutAtLineEnd(MULTILINE_STRING)); }
  // A string glued to a comma (Context: "Observation.code", Patient) is a string then a comma, not one longer word
  {STRING_TERMINATED} ","                 { yypushback(1); return token(stringOrCut(STRING)); }
  {STRING_TERMINATED}                     { return token(stringOrCut(STRING)); }
  {STRING_OPEN}                           { return token(cutAtLineEnd(STRING)); }

  "(" {ANY_WS}* "example" {ANY_WS}* ")"     { return token(KW_EXAMPLE); }
  "(" {ANY_WS}* "preferred" {ANY_WS}* ")"   { return token(KW_PREFERRED); }
  "(" {ANY_WS}* "extensible" {ANY_WS}* ")"  { return token(KW_EXTENSIBLE); }
  "(" {ANY_WS}* "required" {ANY_WS}* ")"    { return token(KW_REQUIRED); }
  "(" {ANY_WS}* "exactly" {ANY_WS}* ")"     { return token(KW_EXACTLY); }

  {UNIT}                                  { return token(UNIT); }

  // A lone '*' (a '*' followed by a non-blank is part of a longer word)
  "*"                                     { return token(atLineStart(zzStartRead) ? STAR : WORD); }
  "="                                     { return token(EQUAL); }
  "->"                                    { return token(ARROW); }
  ":"                                     { return token(COLON); }
  ","                                     { return token(COMMA); }

  {NUMBER}                                { return token(NUMBER); }
  {CODE}                                  { return token(codeOrWord()); }
  {DATE_TIME}                             { return token(DATE_TIME); }
  {TIME}                                  { return token(TIME); }
  {CARD}                                  { return token(CARD); }
  {CARET_PATH}                            { return token(CARET_PATH); }
  {REGEX}                                 { return token(REGEX); }
  {NONWS}+                                { return token(word()); }
}

// After Reference / Canonical / CodeableReference, expecting '('
<REF_OPEN> {
  {BLANK}+                                { return TokenType.WHITE_SPACE; }
  "("                                     { yybegin(REF_PARENS); return LPAREN; }
  [^]                                     { yypushback(1); yybegin(inLine()); }
}

// Inside the parentheses of a reference form. Like SUSHI's REFERENCE token, whose targets are greedy SEQUENCEs, a target runs up to
// the last ')' of its word: `Reference(A))` has the target `A)`, and `Reference(A)"x"` the target `A`
<REF_PARENS> {
  {ANY_WS}+                               { return TokenType.WHITE_SPACE; }
  "*" / {BLANK}                           { if (atLineStart(zzStartRead)) { yypushback(1); yybegin(lineStart()); } else return WORD; }
  "or" / [ \t\f \r\n)]               { return KW_OR; }
  {NONWS}+                                { if (declarationAhead()) { yypushback(yylength()); yybegin(lineStart()); }
                                            else {
                                              int close = yytext().toString().lastIndexOf(')');
                                              if (close == 0) { yypushback(yylength() - 1); yybegin(inLine()); return RPAREN; }
                                              if (close > 0) yypushback(yylength() - close);
                                              return WORD;
                                            } }
}

// After 'insert' (or 'RuleSet:'), expecting a RuleSet name
<AFTER_INSERT> {
  {BLANK}+                                { return TokenType.WHITE_SPACE; }
  [^ \t\f \r\n(]+                    { yybegin(AFTER_INSERT_NAME); return WORD; }
  [^]                                     { yypushback(1); yybegin(inLine()); }
}

// After a RuleSet name, an optional '(' opens the argument (or parameter) list
<AFTER_INSERT_NAME> {
  {BLANK}+ / "("                          { return TokenType.WHITE_SPACE; }
  "("                                     { yybegin(ARGS); return LPAREN; }
  [^]                                     { yypushback(1); yybegin(inLine()); }
}

// After a declaration or metadata keyword other than 'RuleSet', expecting ':' (the keyword was only recognized because one follows)
<AFTER_COLON_KEYWORD> {
  {BLANK}+                                { return TokenType.WHITE_SPACE; }
  ":"                                     { yybegin(inLine()); return COLON; }
  [^]                                     { yypushback(1); yybegin(inLine()); }
}

// After 'RuleSet', expecting ':'
<AFTER_RULESET_KEYWORD> {
  {BLANK}+                                { return TokenType.WHITE_SPACE; }
  ":"                                     { yybegin(AFTER_INSERT); return COLON; }
  [^]                                     { yypushback(1); yybegin(inLine()); }
}

// Argument list of insert, or parameter list of RuleSet: arguments are raw text
<ARGS> {
  {ANY_WS}+                               { return TokenType.WHITE_SPACE; }
  ","                                     { return COMMA; }
  ")"                                     { yybegin(inLine()); return RPAREN; }
  {ARG_BRACKETED}                         { return ARG_BRACKETED; }
  "*" / {BLANK}                           { if (atLineStart(zzStartRead)) { yypushback(1); yybegin(lineStart()); } else return ARG_TEXT; }
  {ARG_TEXT}                              { if (declarationAhead()) { yypushback(yylength()); yybegin(lineStart()); } else return ARG_TEXT; }
  // Catch-all (e.g. a lone backslash at EOF): JFlex throws on unmatched input, which FlexAdapter turns into one BAD_CHARACTER up to EOF
  [^]                                     { return ARG_TEXT; }
}

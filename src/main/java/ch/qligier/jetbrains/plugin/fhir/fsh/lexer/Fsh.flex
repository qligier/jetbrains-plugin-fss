// Copyright 2022 Quentin Ligier. Use of this source code is governed by the MIT license
package ch.qligier.jetbrains.plugin.fhir.fsh.lexer;

import ch.qligier.jetbrains.plugin.fhir.fsh.parser.psi.FshTypes;
import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.TokenType;

%%
// Options and declarations

%class FshLexer
%implements FlexLexer
%unicode
%function advance
%type IElementType
%eof{  return;
%eof}

LineTerminator = \R
InputCharacter = [^\r\n]
WhiteSpace = [ \t\r\n\f\u00A0]

LineComment = "//" {InputCharacter}* {LineTerminator}?

KwFlag = "?!" | "MS" | "SU" | "TU" | "N" | "D"
KwBindingStrength = "example" | "preferred" | "extensible" | "required"
KwFrom = "from"
KwContains = "contains"
KwNamed = "named"
KwAnd = "and"
KwOr = "or"
KwOnly = "only"
KwObeys = "obeys"
KwBoolean = "true" | "false"
KwInclude = "include"
KwExclude = "exclude"
KwCodes = "codes"
KwWhere = "where"
KwValueSetRef = "valueset"
KwSystem = "system"
KwExactly = "exactly"
KwInsert = "insert"
KwContentReference = "contentReference"
KwReference = "Reference"
KwCanonical = "Canonical"
KwCodeOperator = "is-a" | "descendent-of" | "is-not-a" | "regex" | "in" | "not-in" | "generalizes" | "exists"


Digit = [0-9]+
Identifier = [$]? [a-zA-Z0-9\-_]+
Url = ("http")("s")?(":\/" "\/")~[ \t\r\n\f\u00A0\#]+
Urn = "urn:" ~[ \t\r\n\f\u00A0\#]+
String = "\"" (~[\"] | \r | \n | \t | "\"" | "\\")* "\""
MultilineString = "\"\"\"" .*? "\"\"\""
Unit = "'" (~[\\'])* "'"
ConceptString = "\"" {ConceptStringPart}+ ({WhiteSpace} {ConceptStringPart}+)* "\""
ConceptStringPart = (~[ \t\r\n\f\u00A0\"] | "\"" | "\\\\")
Regex = "/" ("\\/" | ~[*/\r\n])("\\/" | ~[/\r\n])* "/"
Datetime = [0-9][0-9][0-9][0-9]("-"[0-9][0-9]("-"[0-9][0-9]("T" {Time})?)?)?
Time = [0-9][0-9](":"[0-9][0-9](":"[0-9][0-9]("."[0-9]+)?)?)?("Z" | ("+" | "-")[0-9][0-9]":"[0-9][0-9])?

%%
// Lexical rules

<YYINITIAL> {

  // Item declaration keywords
  "Alias"                        { yybegin(YYINITIAL); return FshTypes.KWALIAS; }
  "Profile"                      { yybegin(YYINITIAL); return FshTypes.KWPROFILE; }
  "Extension"                    { yybegin(YYINITIAL); return FshTypes.KWEXTENSION; }
  "Instance"                     { yybegin(YYINITIAL); return FshTypes.KWINSTANCE; }
  "Invariant"                    { yybegin(YYINITIAL); return FshTypes.KWINVARIANT; }
  "ValueSet"                     { yybegin(YYINITIAL); return FshTypes.KWVALUESET; }
  "CodeSystem"                   { yybegin(YYINITIAL); return FshTypes.KWCODESYSTEM; }
  "RuleSet"                      { yybegin(YYINITIAL); return FshTypes.KWRULESET; }
  "Mapping"                      { yybegin(YYINITIAL); return FshTypes.KWMAPPING; }
  "Logical"                      { yybegin(YYINITIAL); return FshTypes.KWLOGICAL; }
  "Resource"                     { yybegin(YYINITIAL); return FshTypes.KWRESOURCE; }

  // Item metadata keywords
  "Parent"                       { yybegin(YYINITIAL); return FshTypes.KWPARENT; }
  "Id"                           { yybegin(YYINITIAL); return FshTypes.KWID; }
  "Title"                        { yybegin(YYINITIAL); return FshTypes.KWTITLE; }
  "Description"                  { yybegin(YYINITIAL); return FshTypes.KWDESCRIPTION; }
  "Expression"                   { yybegin(YYINITIAL); return FshTypes.KWEXPRESSION; }
  "XPath"                        { yybegin(YYINITIAL); return FshTypes.KWXPATH; }
  "Severity"                     { yybegin(YYINITIAL); return FshTypes.KWSEVERITY; }
  "InstanceOf"                   { yybegin(YYINITIAL); return FshTypes.KWINSTANCEOF; }
  "Usage"                        { yybegin(YYINITIAL); return FshTypes.KWUSAGE; }
  "Source"                       { yybegin(YYINITIAL); return FshTypes.KWSOURCE; }
  "Target"                       { yybegin(YYINITIAL); return FshTypes.KWTARGET; }

  // Operators and other keywords
  "="                            { yybegin(YYINITIAL); return FshTypes.EQUAL; }
  "+"                            { yybegin(YYINITIAL); return FshTypes.PLUS; }
  ","                            { yybegin(YYINITIAL); return FshTypes.COMMA; }
  "->"                           { yybegin(YYINITIAL); return FshTypes.ARROW; }
  "("                            { yybegin(YYINITIAL); return FshTypes.LEFTPAREN; }
  ")"                            { yybegin(YYINITIAL); return FshTypes.RIGHTPAREN; }
  "["                            { yybegin(YYINITIAL); return FshTypes.LEFTBRACKET; }
  "]"                            { yybegin(YYINITIAL); return FshTypes.RIGHTBRACKET; }
  "^"                            { yybegin(YYINITIAL); return FshTypes.CARET; }
  "#"                            { yybegin(YYINITIAL); return FshTypes.HASH; }
  ".."                           { yybegin(YYINITIAL); return FshTypes.DOUBLEDOT; }
  "|"                            { yybegin(YYINITIAL); return FshTypes.PIPE; }
  "*"                            { yybegin(YYINITIAL); return FshTypes.STAR; }

  // Symbols
  {Digit}                        { return FshTypes.DIGIT; }
  {Identifier}                   { yybegin(YYINITIAL); return FshTypes.IDENTIFIER; }
  {Url}                          { yybegin(YYINITIAL); return FshTypes.URL; }
  {Urn}                          { yybegin(YYINITIAL); return FshTypes.URN; }
  {MultilineString}              { yybegin(YYINITIAL); return FshTypes.MULTILINESTRING; }
  {String}                       { yybegin(YYINITIAL); return FshTypes.STRING; }
  {Unit}                         { yybegin(YYINITIAL); return FshTypes.UNIT; }
  {ConceptString}                { yybegin(YYINITIAL); return FshTypes.CONCEPTSTRING; }
  {Regex}                        { yybegin(YYINITIAL); return FshTypes.REGEX; }
  {Datetime}                     { yybegin(YYINITIAL); return FshTypes.DATETIME; }
  {Time}                         { yybegin(YYINITIAL); return FshTypes.TIME; }

  "-"                            { yybegin(YYINITIAL); return FshTypes.MINUS; } // TODO Can't be matched. Why?
  "."                            { yybegin(YYINITIAL); return FshTypes.DOT; }
  ":"                            { yybegin(YYINITIAL); return FshTypes.COLON; }

  {LineComment}                  { yybegin(YYINITIAL); return null; }
  {WhiteSpace}+                  { yybegin(YYINITIAL); return FshTypes.WHITESPACE; }
}

[^]                              { return TokenType.BAD_CHARACTER; }
<<EOF>>                          { return null; }

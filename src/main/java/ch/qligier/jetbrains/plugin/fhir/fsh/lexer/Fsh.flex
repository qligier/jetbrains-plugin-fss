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
  "Alias"                        { return FshTypes.KWALIAS; }
  "Profile"                      { return FshTypes.KWPROFILE; }
  "Extension"                    { return FshTypes.KWEXTENSION; }
  "Instance"                     { return FshTypes.KWINSTANCE; }
  "Invariant"                    { return FshTypes.KWINVARIANT; }
  "ValueSet"                     { return FshTypes.KWVALUESET; }
  "CodeSystem"                   { return FshTypes.KWCODESYSTEM; }
  "RuleSet"                      { return FshTypes.KWRULESET; }
  "Mapping"                      { return FshTypes.KWMAPPING; }
  "Logical"                      { return FshTypes.KWLOGICAL; }
  "Resource"                     { return FshTypes.KWRESOURCE; }

  // Item metadata keywords
  "Parent"                       { return FshTypes.KWPARENT; }
  "Id"                           { return FshTypes.KWID; }
  "Title"                        { return FshTypes.KWTITLE; }
  "Description"                  { return FshTypes.KWDESCRIPTION; }
  "Expression"                   { return FshTypes.KWEXPRESSION; }
  "XPath"                        { return FshTypes.KWXPATH; }
  "Severity"                     { return FshTypes.KWSEVERITY; }
  "InstanceOf"                   { return FshTypes.KWINSTANCEOF; }
  "Usage"                        { return FshTypes.KWUSAGE; }
  "Source"                       { return FshTypes.KWSOURCE; }
  "Target"                       { return FshTypes.KWTARGET; }

  // Operators and other keywords
  "="                            { return FshTypes.EQUAL; }
  "+"                            { return FshTypes.PLUS; }
  ","                            { return FshTypes.COMMA; }
  "->"                           { return FshTypes.ARROW; }
  "("                            { return FshTypes.LEFTPAREN; }
  ")"                            { return FshTypes.RIGHTPAREN; }
  "["                            { return FshTypes.LEFTBRACKET; }
  "]"                            { return FshTypes.RIGHTBRACKET; }
  "^"                            { return FshTypes.CARET; }
  "#"                            { return FshTypes.HASH; }
  ".."                           { return FshTypes.DOUBLEDOT; }
  "|"                            { return FshTypes.PIPE; }
  "*"                            { return FshTypes.STAR; }

  // Symbols
  {Digit}                        { return FshTypes.DIGIT; }
  {Identifier}                   { return FshTypes.IDENTIFIER; }
  {Url}                          { return FshTypes.URL; }
  {Urn}                          { return FshTypes.URN; }
  {MultilineString}              { return FshTypes.MULTILINESTRING; }
  {String}                       { return FshTypes.STRING; }
  {Unit}                         { return FshTypes.UNIT; }
  {ConceptString}                { return FshTypes.CONCEPTSTRING; }
  {Regex}                        { return FshTypes.REGEX; }
  {Datetime}                     { return FshTypes.DATETIME; }
  {Time}                         { return FshTypes.TIME; }

  "."                            { return FshTypes.DOT; }
  ":"                            { return FshTypes.COLON; }

  {LineComment}                  { return null; }
  {WhiteSpace}+                  { return FshTypes.WHITESPACE; }
}

[^]                              { return TokenType.BAD_CHARACTER; }
<<EOF>>                          { return null; }

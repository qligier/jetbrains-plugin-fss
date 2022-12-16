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

LineTerminator = \r|\n|\r\n
InputCharacter = [^\r\n]
WhiteSpace = [ \t\r\n\f\u00A0]

BlockComment = "/*" [^*] ~"*/" | "/*" "*"+ "/"
LineComment = "//" {InputCharacter}* {LineTerminator}?

KwFlag = "?!" | "MS" | "SU" | "TU" | "N" | "D"
KwBindingStrength = "example" | "preferred" | "extensible" | "required"
KwBoolean = "true" | "false"
KwCodeOperator = "is-a" | "descendent-of" | "is-not-a" | "regex" | "in" | "not-in" | "generalizes" | "exists"

Digit = [0-9]+
Identifier = [$]? [a-zA-Z0-9\-_]+
Url = ("http")("s")?(":\/" "\/")[^ \t\r\n\f\u00A0\#]+
Urn = "urn:" [^ \t\r\n\f\u00A0\#]+
StringToken = \" ( \\\" | [^\"\n\r] )* \"
MultilineString = (\"){3} ~(\"){3}
Unit = "'" ([^\\'])* "'"
Regex = "/" ("\\/" | [^*/\r\n])("\\/" | [^/\r\n])* "/"
Datetime = [0-9][0-9][0-9][0-9]("-"[0-9][0-9]("-"[0-9][0-9]("T" {Time})?)?)?
Time = [0-9][0-9](":"[0-9][0-9](":"[0-9][0-9]("."[0-9]+)?)?)?("Z" | ("+" | "-")[0-9][0-9]":"[0-9][0-9])?

%%
// Lexical rules

<YYINITIAL> {

  {MultilineString} { return FshTypes.MULTILINESTRING; }
  {StringToken}     { return FshTypes.STRINGTOKEN; }

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


  // Rule keywords
  "from"              { return FshTypes.KWFROM; }
  "contains"          { return FshTypes.KWCONTAINS; }
  "named"             { return FshTypes.KWNAMED; }
  "and"               { return FshTypes.KWAND; }
  "or"                { return FshTypes.KWOR; }
  "only"              { return FshTypes.KWONLY; }
  "obeys"             { return FshTypes.KWOBEYS; }
  "include"           { return FshTypes.KWINCLUDE; }
  "exclude"           { return FshTypes.KWEXCLUDE; }
  "codes"             { return FshTypes.KWCODES; }
  "where"             { return FshTypes.KWWHERE; }
  "valueset"          { return FshTypes.KWVALUESETREF; }
  "system"            { return FshTypes.KWSYSTEM; }
  "exactly"           { return FshTypes.KWEXACTLY; }
  "insert"            { return FshTypes.KWINSERT; }
  "contentReference"  { return FshTypes.KWCONTENTREFERENCE; }
  "Reference"         { return FshTypes.KWREFERENCE; }
  "Canonical"         { return FshTypes.KWCANONICAL; }
  {KwBoolean}         { return FshTypes.KWBOOLEAN; }
  {KwFlag}            { return FshTypes.KWFLAG; }
  {KwBindingStrength} { return FshTypes.KWBINDINGSTRENGTH; }
  {KwCodeOperator}    { return FshTypes.KWCODEOPERATOR; }


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
  {Unit}                         { return FshTypes.UNIT; }
  {Regex}                        { return FshTypes.REGEX; }
  {Datetime}                     { return FshTypes.DATETIME; }
  {Time}                         { return FshTypes.TIME; }
  "."                            { return FshTypes.DOT; }
  ":"                            { return FshTypes.COLON; }
  {LineComment}                  { return FshTypes.LINECOMMENT; }
  {BlockComment}                 { return FshTypes.BLOCKCOMMENT; }
  {WhiteSpace}+                  { return FshTypes.WHITESPACE; }
}

[^]                              { return TokenType.BAD_CHARACTER; }
<<EOF>>                          { return null; }

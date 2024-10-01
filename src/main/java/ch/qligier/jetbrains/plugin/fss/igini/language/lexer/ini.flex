// Copyright 2024 Quentin Ligier. Use of this source code is governed by the MIT license.
// A lexer for the INI file format, used to parse the ig.ini file.
// See https://plugins.jetbrains.com/docs/intellij/lexer-and-parser-definition.html
// See https://plugins.jetbrains.com/docs/intellij/implementing-lexer.html
package ch.qligier.jetbrains.plugin.fss.igini.language;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import ch.qligier.jetbrains.plugin.fss.igini.language.psi.IniTypes;
import com.intellij.psi.TokenType;

%%

%class IniLexer
%implements FlexLexer
%unicode
%public
%function advance
%type IElementType
%eof{  return;
%eof}

EOL= \n | \r | \r\n
COMMENT=[;#][^\r\n]*

PVALUE=[^\n\r\f\t\=\ ][^\n\r\f\t\=]*
PKEY=[^\n\r\f\ \t\=]+

WHITESPACE=[\ \t\f]+
SECTION_NAME=\[[^\]]+\]
EQUAL=\=

%state IN_VALUE
%state IN_KEY_VALUE_SEPARATOR

%%

{COMMENT}               { return IniTypes.COMMENT; }
{WHITESPACE}            { return TokenType.WHITE_SPACE; }
{SECTION_NAME}          { return IniTypes.SECTION_NAME; }

<YYINITIAL> {
    {PKEY}              { yybegin(IN_KEY_VALUE_SEPARATOR); return IniTypes.PKEY; }
    {EOL}+              { return TokenType.WHITE_SPACE; }
}
<IN_KEY_VALUE_SEPARATOR> {
    {EQUAL}             { yybegin(IN_VALUE); return IniTypes.EQUAL; }
    {EOL}               { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }
}
<IN_VALUE> {
    {PVALUE}            { return IniTypes.PVALUE; }
    {EOL}               { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }
}

.                       { return TokenType.BAD_CHARACTER; }

// Copyright 2026 Quentin Ligier. Use of this source code is governed by the MIT license.
// A JFlex lexer for the FHIR Shorthand (FSH) language.
// See https://build.fhir.org/ig/HL7/fhir-shorthand/
// See https://plugins.jetbrains.com/docs/intellij/implementing-lexer.html
package ch.qligier.jetbrains.plugin.fss.fsh.language;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import ch.qligier.jetbrains.plugin.fss.fsh.language.psi.FshTypes;
import com.intellij.psi.TokenType;

%%

%class FshLexer
%implements FlexLexer
%unicode
%public
%function advance
%type IElementType
%eof{  return;
%eof}

%state IN_STRING
%state IN_QUOTED_CODE
%state IN_MULTILINE_STRING
%state IN_BLOCK_COMMENT
%state IN_SINGLE_QUOTED

// Character classes
DIGIT           = [0-9]
LETTER          = [A-Za-z]
ALPHANUM        = {LETTER} | {DIGIT}
IDENTIFIER_CHAR = {ALPHANUM} | [_\-]

EOL             = \n | \r | \r\n
WHITESPACE      = [\ \t\f]+

// Numeric patterns
INTEGER         = -? {DIGIT}+
DECIMAL         = -? {DIGIT}+ \. {DIGIT}+
CARDINALITY     = {DIGIT}+ \.\. ({DIGIT}+ | \*)

// Date/time patterns
DATE            = {DIGIT}{4} (\- {DIGIT}{2} (\- {DIGIT}{2})?)?
TIME            = {DIGIT}{2} : {DIGIT}{2} (: {DIGIT}{2} (\. {DIGIT}+)?)?
DATETIME        = {DIGIT}{4} (\- {DIGIT}{2} (\- {DIGIT}{2} (T {DIGIT}{2} (: {DIGIT}{2} (: {DIGIT}{2} (\. {DIGIT}+)?)?)? (Z | [+\-] {DIGIT}{2} : {DIGIT}{2})?)?)?)?

// URL pattern
URL             = https?:\/\/[^\s|,)\]]+

// Alias reference
ALIAS_REF       = \$ ({ALPHANUM} | [_.\-])+

// Code token: #<code> (unquoted, no whitespace/comma)
CODE_TOKEN      = \# [^\s,\"]*

// Quoted code token: #"..."
QUOTED_CODE_START = \# \"

// Regex literal: /regex/
REGEX_LITERAL   = \/ ([^\/\\] | \\.)+ \/

// Identifier: starts with a letter
IDENTIFIER      = {LETTER} {IDENTIFIER_CHAR}*

// Sequence: alphanumeric with underscores (no leading letter required)
SEQUENCE        = ({ALPHANUM} | _)+

%%

// ─── Block comment state ──────────────────────────────

<IN_BLOCK_COMMENT> {
    "*/"                    { yybegin(YYINITIAL); return FshTypes.BLOCK_COMMENT; }
    [^*]+                   { /* accumulate */ }
    \*                      { /* accumulate */ }
}

// ─── Multiline string state (triple-quoted) ───────────

<IN_MULTILINE_STRING> {
    \"\"\"                  { yybegin(YYINITIAL); return FshTypes.MULTILINE_STRING; }
    [^\"]+                  { /* accumulate */ }
    \"                      { /* accumulate */ }
}

// ─── Single-line string state ─────────────────────────

<IN_STRING> {
    \\\"                    { /* escaped quote, accumulate */ }
    \\\\                    { /* escaped backslash, accumulate */ }
    \\.                     { /* other escape, accumulate */ }
    \"                      { yybegin(YYINITIAL); return FshTypes.STRING; }
    [^\"\\]+                { /* accumulate */ }
}

// ─── Quoted code state (#"...") ───────────────────────

<IN_QUOTED_CODE> {
    \\\"                    { /* escaped quote, accumulate */ }
    \\\\                    { /* escaped backslash, accumulate */ }
    \\.                     { /* other escape, accumulate */ }
    \"                      { yybegin(YYINITIAL); return FshTypes.QUOTED_CODE; }
    [^\"\\]+                { /* accumulate */ }
}

// ─── Single-quoted string (UCUM units) ────────────────

<IN_SINGLE_QUOTED> {
    \'                      { yybegin(YYINITIAL); return FshTypes.UCUM_UNIT; }
    [^\']+                  { /* accumulate */ }
}

// ─── YYINITIAL state ─────────────────────────────────

<YYINITIAL> {

    // Comments
    "//"[^\r\n]*            { return FshTypes.LINE_COMMENT; }
    "/*"                    { yybegin(IN_BLOCK_COMMENT); /* start accumulating */ }

    // Multiline strings (must be checked before single-line strings)
    \"\"\"                  { yybegin(IN_MULTILINE_STRING); /* start accumulating */ }

    // Quoted code: #"..."
    {QUOTED_CODE_START}     { yybegin(IN_QUOTED_CODE); /* start accumulating quoted code */ }

    // Single-line strings
    \"                      { yybegin(IN_STRING); /* start accumulating */ }

    // UCUM unit strings
    \'                      { yybegin(IN_SINGLE_QUOTED); /* start accumulating */ }

    // Double bracket delimiters (for parameterized RuleSet arguments)
    "[[" / [^\]]            { return FshTypes.DBL_LBRACKET; }
    "]]"                    { return FshTypes.DBL_RBRACKET; }

    // Entity declaration keywords (context-sensitive: followed by ':')
    "Alias"                 { return FshTypes.KW_ALIAS; }
    "Profile"               { return FshTypes.KW_PROFILE; }
    "Extension"             { return FshTypes.KW_EXTENSION; }
    "Resource"              { return FshTypes.KW_RESOURCE; }
    "Logical"               { return FshTypes.KW_LOGICAL; }
    "Instance"              { return FshTypes.KW_INSTANCE; }
    "ValueSet"              { return FshTypes.KW_VALUESET; }
    "CodeSystem"            { return FshTypes.KW_CODESYSTEM; }
    "Mapping"               { return FshTypes.KW_MAPPING; }
    "RuleSet"               { return FshTypes.KW_RULESET; }
    "Invariant"             { return FshTypes.KW_INVARIANT; }

    // Metadata keywords
    "Id"                    { return FshTypes.KW_ID; }
    "Title"                 { return FshTypes.KW_TITLE; }
    "Description"           { return FshTypes.KW_DESCRIPTION; }
    "Parent"                { return FshTypes.KW_PARENT; }
    "InstanceOf"            { return FshTypes.KW_INSTANCEOF; }
    "Usage"                 { return FshTypes.KW_USAGE; }
    "Source"                { return FshTypes.KW_SOURCE; }
    "Target"                { return FshTypes.KW_TARGET; }
    "Severity"              { return FshTypes.KW_SEVERITY; }
    "Expression"            { return FshTypes.KW_EXPRESSION; }
    "XPath"                 { return FshTypes.KW_XPATH; }
    "Context"               { return FshTypes.KW_CONTEXT; }
    "Characteristics"       { return FshTypes.KW_CHARACTERISTICS; }
    "Mixins"                { return FshTypes.KW_MIXINS; }

    // Rule keywords
    "from"                  { return FshTypes.KW_FROM; }
    "obeys"                 { return FshTypes.KW_OBEYS; }
    "only"                  { return FshTypes.KW_ONLY; }
    "contains"              { return FshTypes.KW_CONTAINS; }
    "named"                 { return FshTypes.KW_NAMED; }
    "and"                   { return FshTypes.KW_AND; }
    "or"                    { return FshTypes.KW_OR; }
    "insert"                { return FshTypes.KW_INSERT; }
    "include"               { return FshTypes.KW_INCLUDE; }
    "exclude"               { return FshTypes.KW_EXCLUDE; }
    "where"                 { return FshTypes.KW_WHERE; }
    "codes"                 { return FshTypes.KW_CODES; }
    "system"                { return FshTypes.KW_SYSTEM; }
    "units"                 { return FshTypes.KW_UNITS; }
    "contentReference"      { return FshTypes.KW_CONTENTREFERENCE; }
    "valueset"              { return FshTypes.KW_VS_VALUESET; }

    // Binding strength keywords
    "exactly"               { return FshTypes.KW_EXACTLY; }
    "example"               { return FshTypes.KW_EXAMPLE; }
    "extensible"            { return FshTypes.KW_EXTENSIBLE; }
    "preferred"             { return FshTypes.KW_PREFERRED; }
    "required"              { return FshTypes.KW_REQUIRED; }

    // Flag keywords
    "MS"                    { return FshTypes.KW_MS; }
    "SU"                    { return FshTypes.KW_SU; }
    "TU"                    { return FshTypes.KW_TU; }
    "N"                     { return FshTypes.KW_NORMATIVE; }
    "D"                     { return FshTypes.KW_DRAFT; }
    "?!"                    { return FshTypes.KW_MODIFIEREXT; }

    // Type keywords
    "Reference"             { return FshTypes.KW_REFERENCE; }
    "Canonical"             { return FshTypes.KW_CANONICAL; }
    "CodeableReference"     { return FshTypes.KW_CODEABLE_REF; }

    // Boolean literals
    "true"                  { return FshTypes.KW_TRUE; }
    "false"                 { return FshTypes.KW_FALSE; }

    // ValueSet filter operators
    "is-a"                  { return FshTypes.KW_IS_A; }
    "is-not-a"              { return FshTypes.KW_IS_NOT_A; }
    "descendent-of"         { return FshTypes.KW_DESCENDENT_OF; }
    "generalizes"           { return FshTypes.KW_GENERALIZES; }
    "not-in"                { return FshTypes.KW_NOT_IN; }
    "in"                    { return FshTypes.KW_IN; }
    "regex"                 { return FshTypes.KW_REGEX; }
    "exists"                { return FshTypes.KW_EXISTS; }

    // Operators & punctuation
    "="                     { return FshTypes.EQUALS; }
    ":"                     { return FshTypes.COLON; }
    "*"                     { return FshTypes.STAR; }
    "->"                    { return FshTypes.ARROW; }
    "+"                     { return FshTypes.PLUS; }
    ","                     { return FshTypes.COMMA; }
    "("                     { return FshTypes.LPAREN; }
    ")"                     { return FshTypes.RPAREN; }
    "["                     { return FshTypes.LBRACKET; }
    "]"                     { return FshTypes.RBRACKET; }
    "^"                     { return FshTypes.CARET; }
    "|"                     { return FshTypes.PIPE; }

    // URL (before identifier to avoid partial matches)
    {URL}                   { return FshTypes.URL; }

    // Alias reference
    {ALIAS_REF}             { return FshTypes.ALIAS_REF; }

    // Code token (#code)
    {CODE_TOKEN}            { return FshTypes.CODE; }

    // Regex literal
    {REGEX_LITERAL}         { return FshTypes.REGEX_LITERAL; }

    // Cardinality (must be before DECIMAL/INTEGER to match e.g., "0..1")
    {CARDINALITY}           { return FshTypes.CARDINALITY; }

    // DateTime (must be before DATE and DECIMAL/INTEGER)
    {DATETIME} / [TZ+\-]   { return FshTypes.DATETIME; }

    // Time
    {TIME}                  { return FshTypes.TIME; }

    // Date
    {DATE}                  { return FshTypes.DATE; }

    // Decimal (must be before INTEGER to handle "1.5")
    {DECIMAL}               { return FshTypes.DECIMAL; }

    // Integer
    {INTEGER}               { return FshTypes.INTEGER; }

    // ".."
    ".."                    { return FshTypes.DOT_DOT; }

    // "."
    "."                     { return FshTypes.DOT; }

    // Identifier (starts with letter)
    {IDENTIFIER}            { return FshTypes.IDENTIFIER; }

    // Sequence (alphanumeric with underscores; used for pure numeric-ish names)
    {SEQUENCE}              { return FshTypes.SEQUENCE; }

    // Whitespace
    {WHITESPACE}            { return TokenType.WHITE_SPACE; }

    // Newlines (significant for rule delimiting)
    {EOL}+                  { return TokenType.WHITE_SPACE; }
}

// Catch-all for bad characters
[^]                         { return TokenType.BAD_CHARACTER; }


grammar Fsh;

options { tokenVocab = FshLexer; }

doc:                (alias)* EOF;

// ALIAS
alias:              KW_ALIAS COLON aliasName EQUAL aliasValue;
aliasName:          IDENTIFIER;
aliasValue:         (URN | URL);

// PROFILE
// EXTENSION
// INVARIANT
// INSTANCE
// VALUESET
// CODESYSTEM
// RULESET
// PARAMRULESET
// MAPPING
// LOGICAL
// RESOURCE

// Rule
ruleStart:          WHITESPACES? STAR;

// Path
path:               DOT | (pathPart (DOT pathPart)*);
pathPart:           simplePathPart | bracketPathPart;
simplePathPart:     IDENTIFIER;
bracketPathPart:    IDENTIFIER bracketSuffix+;
bracketSuffix:      LEFT_BRACKET (IDENTIFIER | URL | integer | EQUAL | PLUS) RIGHT_BRACKET;

// Types
cardinality:        integer? DOUBLE_DOT (integer | STAR)?;
number:             (PLUS | MINUS)? integer (DOT integer)?;
integer:            DIGIT+;
unit:               UNIT;
code:               (DOLLAR? IDENTIFIER | URL | URN)? HASH (IDENTIFIER | CONCEPT_STRING);

//
dateTime:           DATETIME;
time:               TIME;

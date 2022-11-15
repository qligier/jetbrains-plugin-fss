grammar Fsh;

options { tokenVocab = FshLexer; }

doc:                (alias)* EOF;

// Declaration: ALIAS
alias:              KW_ALIAS COLON aliasName EQUAL aliasValue;
aliasName:          IDENTIFIER;
aliasValue:         (URN | URL);

// Declaration: PROFILE

// Declaration: EXTENSION

// Declaration: INVARIANT
invariantMetadata:  description | expression | xpath | severity;

// Declaration: INSTANCE
instanceMetadata:   instanceOf | title | description | usage;

// Declaration: VALUESET
vsMetadata:         id | title | description;

// Declaration: CODESYSTEM
csMetadata:         id | title | description;

// Declaration: RULESET

// Declaration: PARAMRULESET

// Declaration: MAPPING
mappingMetadata:    id | source | target | description | title;

// Declaration: LOGICAL

// Declaration: RESOURCE

// Metadata
sdMetadata:         parent | id | title | description;
parent:             KW_PARENT (IDENTIFIER | URL);
id:                 KW_ID IDENTIFIER;
title:              KW_TITLE STRING;
description:        KW_DESCRIPTION (STRING | MULTILINE_STRING);
expression:         KW_EXPRESSION STRING;
xpath:              KW_XPATH STRING;
severity:           KW_SEVERITY code;
instanceOf:         KW_INSTANCEOF (IDENTIFIER | URL);
usage:              KW_USAGE code;
source:             KW_SOURCE IDENTIFIER;
target:             KW_TARGET STRING;

// Rules
ruleStart:          WHITESPACES? STAR;
cardRule:           ruleStart path cardinality flag*;
flagRule:           ruleStart path flag+ (KW_AND path)*;
valueSetRule:       ruleStart path KW_FROM (IDENTIFIER | URL) strength?;

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
dateTime:           DATETIME;
time:               TIME;
flag:               KW_MOD | KW_MS | KW_SU | KW_TU | KW_NORMATIVE | KW_DRAFT;
strength:           LEFT_PAREN (KW_EXAMPLE | KW_PREFERRED | KW_EXTENSIBLE | KW_REQUIRED) RIGHT_PAREN;

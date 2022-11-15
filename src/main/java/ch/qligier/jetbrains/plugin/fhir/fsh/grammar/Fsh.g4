grammar Fsh;

options { tokenVocab = FshLexer; }

doc:                (alias)* EOF;

// Declaration: ALIAS
alias:              KW_ALIAS COLON IDENTIFIER EQUAL aliasValue;
aliasValue:         (URN | URL);

// Declaration: PROFILE
profile:            KW_PROFILE COLON IDENTIFIER sdMetadata+ sdRule*;

// Declaration: EXTENSION
extension:          KW_EXTENSION COLON IDENTIFIER sdMetadata* sdRule*;

// Declaration: INVARIANT
invariant:          KW_INVARIANT COLON IDENTIFIER invariantMetadata+;
invariantMetadata:  description | expression | xpath | severity;

// Declaration: INSTANCE
instance:           KW_INSTANCE COLON IDENTIFIER instanceMetadata* instanceRule*;
instanceMetadata:   instanceOf | title | description | usage;

// Declaration: VALUESET
valueSet:           KW_VALUESET COLON IDENTIFIER vsMetadata* vsRule*;
vsMetadata:         id | title | description;

// Declaration: CODESYSTEM
codeSystem:         KW_CODESYSTEM COLON IDENTIFIER csMetadata* csRule*;
csMetadata:         id | title | description;

// Declaration: RULESET
ruleSet:            KW_RULESET COLON RULESET_REFERENCE ruleSetRule+;

// Declaration: PARAMRULESET
paramRuleSet:       KW_RULESET COLON PARAM_RULESET_REFERENCE paramRuleSetContent;

// Declaration: MAPPING
mapping:            KW_MAPPING COLON IDENTIFIER mappingMetadata* mappingEntityRule*;
mappingMetadata:    id | source | target | description | title;

// Declaration: LOGICAL
logical:            KW_LOGICAL COLON IDENTIFIER sdMetadata* lrRule*;

// Declaration: RESOURCE
resource:           KW_RESOURCE COLON IDENTIFIER sdMetadata* lrRule*;

// Metadata
sdMetadata:         parent | id | title | description;
parent:             KW_PARENT itemIdentifier;
id:                 KW_ID IDENTIFIER;
title:              KW_TITLE STRING;
description:        KW_DESCRIPTION (STRING | MULTILINE_STRING);
expression:         KW_EXPRESSION STRING;
xpath:              KW_XPATH STRING;
severity:           KW_SEVERITY code;
instanceOf:         KW_INSTANCEOF itemIdentifier;
usage:              KW_USAGE code;
source:             KW_SOURCE IDENTIFIER;
target:             KW_TARGET STRING;

// Rules
ruleStart:          WHITESPACES? STAR;
cardRule:           ruleStart path cardinality flag*;
flagRule:           ruleStart path flag+ (KW_AND path)*;
valueSetRule:       ruleStart path KW_FROM itemIdentifier strength?;

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
code:               (DOLLAR? IDENTIFIER | URL | URN)? HASH (IDENTIFIER | CONCEPT_STRING);
dateTime:           DATETIME;
time:               TIME;
flag:               KW_MOD | KW_MS | KW_SU | KW_TU | KW_NORMATIVE | KW_DRAFT;
strength:           LEFT_PAREN (KW_EXAMPLE | KW_PREFERRED | KW_EXTENSIBLE | KW_REQUIRED) RIGHT_PAREN;
ratio:              (number | quantity) COLON  (number | quantity);
quantity:           number (UNIT | code) STRING?;
reference:          KW_REFERENCE LEFT_PAREN itemIdentifier (KW_OR itemIdentifier)* RIGHT_PAREN
itemIdentifier:     IDENTIFIER | URL;
canonical:          KW_CANONICAL LEFT_PAREN itemIdentifier (PIPE itemIdentifier)? (KW_OR itemIdentifier (PIPE itemIdentifier)?)* RIGHT_PAREN;
targetType:         IDENTIFIER | reference | canonical;
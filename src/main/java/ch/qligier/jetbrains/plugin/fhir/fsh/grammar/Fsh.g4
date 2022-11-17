grammar Fsh;

options { tokenVocab = FshLexer; }

doc:                (alias | profile | extension | invariant | instance | valueSet | codeSystem | ruleSet | mapping | logical | resource)* EOF;

// Declaration: ALIAS
alias:              KW_ALIAS COLON IDENTIFIER EQUAL aliasValue;
aliasValue:         (URN | URL);

// Declaration: PROFILE
profile:            /* decl */ KW_PROFILE COLON IDENTIFIER
                    /* meta */ (parent | id | title | description)+
                    /* rule */ sdRule*;

// Declaration: EXTENSION
extension:          /* decl */ KW_EXTENSION COLON IDENTIFIER
                    /* meta */ (parent | id | title | description)*
                    /* rule */ sdRule*;

// Declaration: INVARIANT
invariant:          KW_INVARIANT COLON IDENTIFIER invariantMetadata+;
invariantMetadata:  description | expression | xpath | severity;

// Declaration: INSTANCE
instance:           KW_INSTANCE COLON IDENTIFIER instanceMetadata* instanceRule*;
instanceMetadata:   instanceOf | title | description | usage;
instanceRule:       fixedValueRule | insertRule | pathRule;

// Declaration: VALUESET
valueSet:           /* decl */ KW_VALUESET COLON IDENTIFIER
                    /* meta */ (id | title | description)*
                    /* rule */ (vsComponent | caretValueRule | insertRule)*;
vsComponent:        ruleStart (KW_INCLUDE | KW_EXCLUDE)? (vsConceptComponent | vsFilterComponent);
vsConceptComponent: (code vsComponentFrom?) | (code (KW_AND code)* vsComponentFrom);
vsFilterComponent:  KW_CODES vsComponentFrom (KW_WHERE vsFilterList)?;
vsComponentFrom:    KW_FROM (vsFromSystem (KW_AND vsFromValueset)? | vsFromValueset (KW_AND vsFromSystem)?);
vsFromSystem:       KW_SYSTEM itemIdentifier;
vsFromValueset:     KW_VSREFERENCE itemIdentifier (KW_AND itemIdentifier)*;
vsFilterList:       vsFilterDefinition (KW_AND vsFilterDefinition)*;
vsFilterDefinition: IDENTIFIER vsFilterOperator vsFilterValue?;
vsFilterOperator:   EQUAL | KW_IS_A | KW_DESCENDEND_OF | KW_IS_NOT_A | KW_REGEX | KW_IN | KW_NOT_IN | KW_GENERALIZES | KW_EXISTS;
vsFilterValue:      code | KW_TRUE | KW_FALSE | REGEX | STRING;

// Declaration: CODESYSTEM
codeSystem:         KW_CODESYSTEM COLON IDENTIFIER csMetadata* csRule*;
csMetadata:         id | title | description;
csRule:             concept | codeCaretValueRule | codeInsertRule;

// Declaration: RULESET
ruleSet:            KW_RULESET COLON ruleSetReference ruleSetRule+;
ruleSetRule:        sdRule | addElementRule | addCRElementRule | concept | codeCaretValueRule | codeInsertRule | vsComponent | mappingRule;

// Declaration: MAPPING
mapping:            KW_MAPPING COLON IDENTIFIER mappingMetadata* mappingEntityRule*;
mappingMetadata:    id | source | target | description | title;
mappingEntityRule:  mappingRule | insertRule | pathRule;

// Declaration: LOGICAL
logical:            /* decl */ KW_LOGICAL COLON IDENTIFIER
                    /* meta */ (parent | id | title | description)*
                    /* rule */ lrRule*;

// Declaration: RESOURCE
resource:           /* decl */ KW_RESOURCE COLON IDENTIFIER
                    /* meta */ (parent | id | title | description)*
                    /* rule */ lrRule*;

// Metadata
parent:             KW_PARENT COLON itemIdentifier;
id:                 KW_ID COLON IDENTIFIER;
title:              KW_TITLE COLON STRING;
description:        KW_DESCRIPTION COLON (STRING | MULTILINE_STRING);
expression:         KW_EXPRESSION COLON STRING;
xpath:              KW_XPATH COLON STRING;
severity:           KW_SEVERITY COLON code;
instanceOf:         KW_INSTANCEOF COLON itemIdentifier;
usage:              KW_USAGE COLON code;
source:             KW_SOURCE COLON IDENTIFIER;
target:             KW_TARGET COLON STRING;

// Rules
sdRule:             cardRule | flagRule | valueSetRule | fixedValueRule | containsRule | onlyRule | obeysRule | caretValueRule | insertRule | pathRule;
lrRule:             sdRule | addElementRule | addCRElementRule;
ruleStart:          WHITESPACES? STAR;
cardRule:           ruleStart path cardinality flag*;
flagRule:           ruleStart path flag+ (KW_AND path)*;
valueSetRule:       ruleStart path KW_FROM itemIdentifier strength?;
fixedValueRule:     ruleStart path EQUAL value (LEFT_PAREN KW_EXACTLY RIGHT_PAREN)?;
containsRule:       ruleStart path KW_CONTAINS item (KW_AND item)*;
onlyRule:           ruleStart path KW_ONLY targetType (KW_OR targetType)*;
obeysRule:          ruleStart path? KW_OBEYS IDENTIFIER (KW_AND IDENTIFIER)*;
caretValueRule:     ruleStart path? CARET path EQUAL value;
codeCaretValueRule: ruleStart code* CARET path EQUAL value;
mappingRule:        ruleStart path? ARROW STRING STRING? code?;
insertRule:         ruleStart path? KW_INSERT ruleSetReference;
codeInsertRule:     ruleStart code* KW_INSERT ruleSetReference;
addCRElementRule:   ruleStart path cardinality flag* KW_CONTENTREFERENCE URL STRING (STRING | MULTILINE_STRING)?;
addElementRule:     ruleStart path cardinality flag* targetType (KW_OR targetType)* STRING (STRING | MULTILINE_STRING)?;
pathRule:           ruleStart path;

// Path
path:               DOT | (pathPart (DOT pathPart)*);
pathPart:           (IDENTIFIER | KW_SYSTEM) bracketSuffix*; // TODO: other keywords may be allowed here
bracketSuffix:      LEFT_BRACKET (IDENTIFIER | URL | integer | EQUAL | PLUS) RIGHT_BRACKET;

// Types
cardinality:        integer? DOUBLE_DOT (integer | STAR)?;
number:             (PLUS | MINUS)? integer (DOT integer)?;
integer:            DIGIT+;
code:               (URL | ((DOLLAR? IDENTIFIER | URN)? HASH (IDENTIFIER | CONCEPT_STRING))) STRING?;
flag:               KW_MOD | KW_MS | KW_SU | KW_TU | KW_NORMATIVE | KW_DRAFT;
strength:           LEFT_PAREN (KW_EXAMPLE | KW_PREFERRED | KW_EXTENSIBLE | KW_REQUIRED) RIGHT_PAREN;
ratio:              (number | quantity) COLON  (number | quantity);
quantity:           number (UNIT | code) STRING?;
reference:          KW_REFERENCE LEFT_PAREN itemIdentifier (KW_OR itemIdentifier)* RIGHT_PAREN;
itemIdentifier:     IDENTIFIER | URL;
canonical:          KW_CANONICAL LEFT_PAREN itemIdentifier (PIPE itemIdentifier)? (KW_OR itemIdentifier (PIPE itemIdentifier)?)* RIGHT_PAREN;
targetType:         IDENTIFIER | reference | canonical;
value:              STRING | MULTILINE_STRING | number | DATETIME | TIME | reference | canonical | code | quantity | ratio | bool;
item:               itemIdentifier (KW_NAMED IDENTIFIER)? cardinality flag*;
bool:               KW_TRUE | KW_FALSE;
concept:            ruleStart code+ STRING? (STRING | MULTILINE_STRING)?;
ruleSetReference:   IDENTIFIER (LEFT_PAREN IDENTIFIER (COMMA IDENTIFIER)* RIGHT_PAREN)?;

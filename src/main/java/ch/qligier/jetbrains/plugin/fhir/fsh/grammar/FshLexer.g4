lexer grammar FshLexer;

// Keywords
KW_ALIAS:               'Alias';
KW_PROFILE:             'Profile';
KW_EXTENSION:           'Extension';
KW_INSTANCE:            'Instance';
KW_INSTANCEOF:          'InstanceOf';
KW_INVARIANT:           'Invariant';
KW_VALUESET:            'ValueSet';
KW_CODESYSTEM:          'CodeSystem';
KW_RULESET:             'RuleSet';
KW_MAPPING:             'Mapping';
KW_LOGICAL:             'Logical';
KW_RESOURCE:            'Resource';

KW_PARENT:              'Parent';
KW_ID:                  'Id';
KW_TITLE:               'Title';
KW_DESCRIPTION:         'Description';
KW_EXPRESSION:          'Expression';
KW_XPATH:               'XPath';
KW_SEVERITY:            'Severity';
KW_USAGE:               'Usage';
KW_SOURCE:              'Source';
KW_TARGET:              'Target';

KW_MOD:                 '?!';
KW_MS:                  'MS';
KW_SU:                  'SU';
KW_TU:                  'TU';
KW_NORMATIVE:           'N';
KW_DRAFT:               'D';
KW_FROM:                'from';
KW_EXAMPLE:             'example';
KW_PREFERRED:           'preferred';
KW_EXTENSIBLE:          'extensible';
KW_REQUIRED:            'required';
KW_CONTAINS:            'contains';
KW_NAMED:               'named';
KW_AND:                 'and';
KW_ONLY:                'only';
KW_OR:                  'or';
KW_OBEYS:               'obeys';
KW_TRUE:                'true';
KW_FALSE:               'false';
KW_INCLUDE:             'include';
KW_EXCLUDE:             'exclude';
KW_CODES:               'codes';
KW_WHERE:               'where';
KW_VSREFERENCE:         'valueset';
KW_SYSTEM:              'system';
KW_EXACTLY:             'exactly';
KW_INSERT:              'insert';

KW_CONTENTREFERENCE:    'contentReference';
KW_REFERENCE:           'Reference';
KW_CANONICAL:           'Canonical';

KW_IS_A:                'is-a';
KW_DESCENDEND_OF:       'descendent-of';
KW_IS_NOT_A:            'is-not-a';
KW_REGEX:               'regex';
KW_IN:                  'in';
KW_NOT_IN:              'not-in';
KW_GENERALIZES:         'generalizes';
KW_EXISTS:              'exists';

// SYMBOLS
COLON:                  ':';
EQUAL:                  '=';
PLUS:                   '+';
MINUS:                  '-';
COMMA:                  ',';
ARROW:                  '->';
LEFT_PAREN:             '(';
RIGHT_PAREN:            ')';
LEFT_BRACKET:           '[';
RIGHT_BRACKET:          ']';
TRIPLE_QUOTE:           '"""';
QUOTE:                  '"';
CARET:                  '^';
HASH:                   '#';
TRIPLE_DOT:             '...';
DOUBLE_DOT:             '..';
DOT:                    '.';
SIMPLE_QUOTE:           '\'';
PIPE:                   '|';
SLASH:                  '/';
LINE_COMMENT_PREFIX:    '//';
BLOCK_COMMENT_PREFIX:   '/*';
BLOCK_COMMENT_SUFFIX:   '*/';
STAR:                   '*';
DOLLAR:                 '$';
Z:                      'Z';

DIGIT:                  [0-9];
IDENTIFIER:             DOLLAR? [a-zA-Z0-9-_]+;
URL:                    'http' 's'? '://' NON_WS+;
URN:                    'urn:' NON_WS+;

STRING:                 QUOTE (~[\\"] | '\\r' | '\\n' | '\\t' | '\\"' | '\\\\')* QUOTE;
MULTILINE_STRING:       TRIPLE_QUOTE .*? TRIPLE_QUOTE;
UNIT:                   SIMPLE_QUOTE (~[\\'])* SIMPLE_QUOTE;
CONCEPT_STRING:         QUOTE (~[ \t\r\n\f\u00A0\\"] | '\\"' | '\\\\')+ (WS (~[ \t\r\n\f\u00A0\\"] | '\\"' | '\\\\')+)* QUOTE;
REGEX:                  SLASH ('\\/' | ~[*/\r\n])('\\/' | ~[/\r\n])* SLASH;

DATETIME:               [0-9][0-9][0-9][0-9]('-'[0-9][0-9]('-'[0-9][0-9]('T' TIME)?)?)?;
//                             YEAR           -   MONTH     -    DAY      T TIME

TIME:                   [0-9][0-9](':'[0-9][0-9](':'[0-9][0-9]('.'[0-9]+)?)?)?('Z' | ('+' | '-')[0-9][0-9]':'[0-9][0-9])?;
//                         HOUR     :   MINUTE    :   SECOND    . MILLI         Z  |     +/-        HOUR   :  MINUTE
//SEQUENCE:               NON_WS+;

fragment NON_WS:        ~[ \t\r\n\f\u00A0];
fragment WS:            [ \t\r\n\f\u00A0];

// Skip these special tokens in the parser
LINE_COMMENT:           LINE_COMMENT_PREFIX .*? (NEWLINE | EOF) -> channel(HIDDEN);
COMMENT:                BLOCK_COMMENT_PREFIX .*? (BLOCK_COMMENT_SUFFIX | EOF) -> channel(HIDDEN);
WHITESPACES:            WS+ -> channel(HIDDEN);
NEWLINE:                '\r'? '\n' -> channel(HIDDEN);

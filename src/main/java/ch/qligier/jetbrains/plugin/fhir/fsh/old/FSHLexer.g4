// FSH grammar, based on commit da5a8ff
lexer grammar FSHLexer;

// KEYWORDS
KW_ALIAS:           'Alias' WS* COLON;
KW_PROFILE:         'Profile' WS* COLON;
KW_EXTENSION:       'Extension' WS* COLON;
KW_INSTANCE:        'Instance' WS* COLON;
KW_INSTANCEOF:      'InstanceOf' WS* COLON;
KW_INVARIANT:       'Invariant' WS* COLON;
KW_VALUESET:        'ValueSet' WS* COLON;
KW_CODESYSTEM:      'CodeSystem' WS* COLON;
KW_RULESET:         'RuleSet' WS* COLON -> pushMode(RULESET_OR_INSERT);
KW_MAPPING:         'Mapping' WS* COLON;
KW_LOGICAL:         'Logical' WS* COLON;
KW_RESOURCE:        'Resource' WS* COLON;
KW_PARENT:          'Parent' WS* COLON;
KW_ID:              'Id' WS* COLON;
KW_TITLE:           'Title' WS* COLON;
KW_DESCRIPTION:     'Description' WS* COLON;
KW_EXPRESSION:      'Expression' WS* COLON;
KW_XPATH:           'XPath' WS* COLON;
KW_SEVERITY:        'Severity' WS* COLON;
KW_USAGE:           'Usage' WS* COLON;
KW_SOURCE:          'Source' WS* COLON;
KW_TARGET:          'Target' WS* COLON;
KW_MOD:             '?!';
KW_MS:              'MS';
KW_SU:              'SU';
KW_TU:              'TU';
KW_NORMATIVE:       'N';
KW_DRAFT:           'D';
KW_FROM:            'from';
KW_EXAMPLE:         LEFT_PAREN WS* 'example' WS* RIGHT_PAREN;
KW_PREFERRED:       LEFT_PAREN WS* 'preferred' WS* RIGHT_PAREN;
KW_EXTENSIBLE:      LEFT_PAREN WS* 'extensible' WS* RIGHT_PAREN;
KW_REQUIRED:        LEFT_PAREN WS* 'required' WS* RIGHT_PAREN;
KW_CONTAINS:        'contains';
KW_NAMED:           'named';
KW_AND:             'and';
KW_ONLY:            'only';
KW_OR:              'or';
KW_OBEYS:           'obeys';
KW_TRUE:            'true';
KW_FALSE:           'false';
KW_INCLUDE:         'include';
KW_EXCLUDE:         'exclude';
KW_CODES:           'codes';
KW_WHERE:           'where';
KW_VSREFERENCE:     'valueset';
KW_SYSTEM:          'system';
KW_EXACTLY:         LEFT_PAREN WS* 'exactly' WS* RIGHT_PAREN;
KW_INSERT:          'insert' -> pushMode(RULESET_OR_INSERT);
KW_CONTENTREFERENCE:'contentReference';
KW_REFERENCE:       'Reference';
KW_CANONICAL:       'Canonical';

// SYMBOLS
EQUAL:              '=';
COLON:              ':';
COMMA:              ',';
ARROW:              '->';
LEFT_PAREN:         '(';
RIGHT_PAREN:        ')';
TRIPLE_QUOTE:       '"""';
QUOTE:              '"';
CARET:              '^';
HASH:               '#';
DOUBLE_DOT:         '..';
SIMPLE_QUOTE:       '\'';
PIPE:               '|';
SLASH:              '/';
LINE_COMMENT_PREFIX:  '//';
BLOCK_COMMENT_PREFIX: '/*';
BLOCK_COMMENT_SUFFIX: '*/';

// PATTERNS


RULE_START:         ([\r\n] | LINE_COMMENT) WS* STAR [ \u00A0]; //SPACES? STAR; // We include here the star indentation
STAR:               '*';

                 //  "    CHARS    "
STRING:             QUOTE (~[\\"] | '\\r' | '\\n' | '\\t' | '\\"' | '\\\\')* QUOTE;

                 //  """ CHARS """
MULTILINE_STRING:   TRIPLE_QUOTE .*? TRIPLE_QUOTE;

                 //  +/- ? DIGITS( .  DIGITS)?
NUMBER:             [+\-]? [0-9]+('.' [0-9]+)?;

                 //   '  UCUM UNIT   '
UNIT:               SIMPLE_QUOTE (~[\\'])* SIMPLE_QUOTE;

                 // SYSTEM     #  SYSTEM
CODE:               SEQUENCE? HASH (SEQUENCE | CONCEPT_STRING);


CONCEPT_STRING:      QUOTE (NONWS_STR | '\\"' | '\\\\')+ (WS (NONWS_STR | '\\"' | '\\\\')+)* QUOTE;

                 //        YEAR         ( -   MONTH   ( -    DAY    ( T TIME )?)?)?
DATETIME:           [0-9][0-9][0-9][0-9]('-'[0-9][0-9]('-'[0-9][0-9]('T' TIME)?)?)?;

                 //    HOUR   ( :   MINUTE  ( :   SECOND  ( . MILLI )?)?)?( Z  |     +/-        HOUR   :  MINUTE   )?
TIME:               [0-9][0-9](':'[0-9][0-9](':'[0-9][0-9]('.'[0-9]+)?)?)?('Z' | ('+' | '-')[0-9][0-9]':'[0-9][0-9])?;

                 // DIGITS  ..  (DIGITS |  * )
CARD:               ([0-9]+)? DOUBLE_DOT ([0-9]+ | STAR)?;

              //  Reference       (        ITEM         |         ITEM         )
REFERENCE:       KW_REFERENCE WS* LEFT_PAREN WS* SEQUENCE WS* (WS KW_OR WS+ SEQUENCE WS*)* RIGHT_PAREN;

                 // Canonical       (              URL|VERSION               or              URL|VERSION             )
CANONICAL     :    KW_CANONICAL WS* LEFT_PAREN WS* SEQUENCE (PIPE SEQUENCE)? WS* (WS KW_OR WS+ SEQUENCE (PIPE SEQUENCE)? WS*)* RIGHT_PAREN;

                 // '/' EXPRESSION '/'
REGEX:              SLASH ('\\/' | ~[*/\r\n])('\\/' | ~[/\r\n])* SLASH;

PARAMETER_DEF_LIST: LEFT_PAREN (SEQUENCE WS* COMMA WS*)* SEQUENCE RIGHT_PAREN;

// BLOCK_COMMENT must precede SEQUENCE so that a block comment without whitespace does not become a SEQUENCE
BLOCK_COMMENT:      BLOCK_COMMENT_PREFIX .*? BLOCK_COMMENT_SUFFIX -> skip;
                 // NON-WHITESPACE
SEQUENCE:           NONWS+;



// FRAGMENTS
fragment WS: [ \t\r\n\f\u00A0];
fragment NONWS: ~[ \t\r\n\f\u00A0];
fragment NONWS_STR: ~[ \t\r\n\f\u00A0\\"];

// IGNORED TOKENS
WHITESPACE:         WS -> skip;
LINE_COMMENT:       LINE_COMMENT_PREFIX .*? '\r'? '\n' -> skip;

mode RULESET_OR_INSERT;
PARAM_RULESET_REFERENCE:      WS* NONWS+ (WS* (LEFT_PAREN ('\\)' | '\\\\' | ~[)])+ RIGHT_PAREN)) -> popMode;
RULESET_REFERENCE:            WS* NONWS+ -> popMode;

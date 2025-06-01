# Grammar of the FSH format

The ANTLR4 grammar files come from the sushi project, distributed under the Apache License 2.0.

https://github.com/FHIR/sushi/tree/master/antlr/src/main/antlr

Updated on: 31/05/2025
Last commit: d9fdd64

## Update the definitions

To update the definitions, retrieve the latest version of the FSH grammar files from the sushi project.
Then, the following modifications need to be made in the lexer definition:

Replace all uses of `skip` with `channel(HIDDEN)`.
This is necessary to ensure a continuous stream of tokens, as the IntelliJ Platform will error on non-adjacent tokens.

In the section `SYMBOLS`, add the new definitions:
```antlrv4
LEFT_PAREN:         '(';
RIGHT_PAREN:        ')';
```
Replace all uses of `'('` with `LEFT_PAREN` and all uses of `')'` with `RIGHT_PAREN` (except for the lines you just
added).
This allows having dedicated tokens for parentheses, which is useful for the IntelliJ Platform.

Then, rebuild the code (described in the next section) and ensure all dependent classes are running fine.

## Generate code from definitions

This is not the regular way advertised by the JetBrains documentation to implement a custom language implementation.
Instead, we will generate a regular ANTLR4 parser and lexer (instead of a JFlex lexer and BNF parser).
Then, we will use an adapter created by ANTLR to integrate the ANTLR4 parser and lexer into the IntelliJ Platform.

To build the lexer and parser, you can follow these steps:

1. Run the Gradle task `other > generateGrammarSource`.

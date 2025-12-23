# Grammar of the INI format

These are a simple grammar for the ill-defined INI format.
It is used to parse the 'ig.ini' file in a FHIR Implementation Guide (IG).

## Generate code from definitions

This is the regular way advertised by the JetBrains documentation to implement a custom language implementation.
https://plugins.jetbrains.com/docs/intellij/implementing-lexer.html
https://plugins.jetbrains.com/docs/intellij/grammar-and-parser.html

To build the lexer and parser, you can follow these steps:

1. Open the file `ini.flex`, right-click and select "Run JFlex Generator".
   This will generate the lexer class `IniLexer.java` in the directory `src/main/gen/`.
2. Open the file `ini.bnf`, right-click and select "Generate Parser Code".
   This will generate in the directory `src/main/gen/`:
    - the parser class `IniParser.java`;
    - the PSI classes in the package `ch.qligier.jetbrains.plugin.fss.igini.language.psi`.

Warning: the parser generation can fail if the static helper methods from `IniPsiImplUtil` are not visible to the
parser generator.

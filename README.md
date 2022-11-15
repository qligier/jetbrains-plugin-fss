# jetbrains-plugin-fhir

A plugin that add supports for the [IG Publisher](https://github.com/HL7/fhir-ig-publisher) and
the [FHIR Shorthand language](https://build.fhir.org/ig/HL7/fhir-shorthand/index.html) (_FSH_).

## FSH support

This plugin adds, for FSH files:

- lexing and parsing;
- syntax highlighting;
- block and line commenting actions (`Comment with Line Comment` and `Comment with Block Comment`)
- braces matching;

## ANTLR

The ANTLR4 grammar has been modified from the [SUSHI project original one](https://github.
com/FHIR/sushi/tree/master/antlr/src/main/antlr), which ignored whitespaces and comments while parsers need a
continuous stream of tokens. The lexer and parser has been improved to produce a more precise stream of tokens to
allow/facilitate the work of the plugin.

To regenerate the Java implementation:

```shell
cd ./src/main/java/ch/qligier/jetbrains/plugin/fhir/fsh/grammar
java -jar ./antlr-4.11.1-complete.jar FshLexer.g4 -package ch.qligier.jetbrains.plugin.fhir.fsh.grammar
java -jar ./antlr-4.11.1-complete.jar Fsh.g4 -package ch.qligier.jetbrains.plugin.fhir.fsh.grammar
```

### Notice

The FHIR Shorthand ![FSH icon](src/main/resources/icons/language.png) is maybe copyrighted?

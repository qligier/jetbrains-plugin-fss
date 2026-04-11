# Grammar of the FHIR Shorthand (FSH) language

These are a grammar and lexer for the FHIR Shorthand (FSH) language, as specified by HL7:
https://build.fhir.org/ig/HL7/fhir-shorthand/

## Generate code from definitions

This follows the standard JetBrains documentation approach for custom language implementation:
- https://plugins.jetbrains.com/docs/intellij/implementing-lexer.html
- https://plugins.jetbrains.com/docs/intellij/grammar-and-parser.html

To build the lexer and parser, follow these steps:

1. Open the file `fsh.flex`, right-click and select "Run JFlex Generator".
   This will generate the lexer class `FshLexer.java` in the directory `src/main/gen/`.
2. Open the file `fsh.bnf`, right-click and select "Generate Parser Code".
   This will generate in the directory `src/main/gen/`:
    - the parser class `FshParser.java`;
    - the PSI classes in the package `ch.qligier.jetbrains.plugin.fss.fsh.language.psi`.

Warning: the parser generation can fail if the static helper methods from `FshPsiImplUtil` are not visible to the
parser generator.

## FSH Language Overview

FSH (FHIR Shorthand) is a domain-specific language for defining FHIR Implementation Guide content. It supports
11 entity types:

| Entity     | Description                                        |
|------------|----------------------------------------------------|
| Alias      | Short name for a URL or OID                        |
| Profile    | Constrains a FHIR resource or data type            |
| Extension  | Defines a FHIR extension                           |
| Resource   | Defines a custom FHIR resource                     |
| Logical    | Defines a logical model                            |
| Instance   | Defines an example or inline instance               |
| ValueSet   | Defines a FHIR value set                           |
| CodeSystem | Defines a FHIR code system                         |
| Mapping    | Maps elements to another specification             |
| RuleSet    | Reusable group of rules (may be parameterized)     |
| Invariant  | Defines a constraint (FHIRPath/XPath expression)   |

Each entity is followed by metadata (keyword: value pairs) and rules (lines starting with `*`).


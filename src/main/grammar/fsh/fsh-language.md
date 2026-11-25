# FSH for grammar writers

A parsing-oriented description of FHIR Shorthand (FSH): what the language looks like at the character, token and rule level, which
parts are hard to parse, and how often each construct occurs in real IGs. It complements the specification rather than replacing it.
Each section links to the spec and ends with what it implies for the JFlex lexer and the Grammar-Kit grammar. Those implications feed
`docs/grammar-kit-design.md` (Phase 3).

**Sources:**

- The [FSH 3.0.0 specification](https://build.fhir.org/ig/HL7/fhir-shorthand/reference.html), which takes precedence over any
  grammar.
- SUSHI 3.21.0's ANTLR grammar ([`FSHLexer.g4`](https://github.com/FHIR/sushi/blob/master/antlr/src/main/antlr/FSHLexer.g4),
  [`FSH.g4`](https://github.com/FHIR/sushi/blob/master/antlr/src/main/antlr/FSH.g4)) and its importer, `src/import/FSHImporter.ts`.
- **Corpus evidence**: SUSHI's own lexer and parser run over the 47,540 unique repository FSH files of the corpus that are at most
  2 MB. 45 larger generated CodeSystems are excluded. Numbers come from `node corpus/scripts/language-evidence.mjs`, see
  [Reproducing the numbers](#reproducing-the-numbers).
  - **"files"** means files containing the construct at least once; percentages are of those 47,540 files.
  - **"occurrences"** counts every instance.
  - 24 of the files have SUSHI syntax errors; they are still counted.
- **Lexer behavior**: statements about how SUSHI tokenizes an input were checked by running SUSHI's lexer on that input. The full
  list is in [Appendix A](#appendix-a-how-sushis-lexer-tokenizes-tricky-inputs).

Legacy FSH (SUSHI < 1.0, `Mixins:`, `units`, …) is out of scope (see PLAN.md, decision 2).

## At a glance

The hardest parts, roughly ordered by how much they shape the grammar:

| # | Difficulty | How common | Section |
|---|---|---|---|
| 1 | The rule marker `*` is only special at the start of a line; otherwise newlines are insignificant and a rule may continue on the next lines | 3.78 M rules; 8.7% of files have rules continuing on later lines | [3.1](#31-the-rule-marker) |
| 2 | The kind of a rule is only known after its path, sometimes at the end of the line | 17 rule shapes | [3.2](#32-rule-kinds-are-decided-late) |
| 3 | A "word" is any run of non-whitespace characters, so names, paths, URLs, codes and numbers compete by longest match | every file | [1.4](#14-words-longest-match-and-the-catch-all-sequence) |
| 4 | Indentation carries meaning (path context) although the grammar is otherwise whitespace-insensitive | 18% of files, 19% of rules | [3.4](#34-indentation-sets-path-context) |
| 5 | Reserved words are contextual: `system` is a keyword *and* a very common path | `system` used as a path 7,316 times in 2,037 files | [2.1](#21-declarations-and-keywords), [3.3](#33-paths) |
| 6 | Parameterized RuleSet bodies are templates, and `{param}` can appear anywhere, even inside strings and words | 2,405 definitions, 88,120 parameterized inserts | [4.2](#42-parameterized-rulesets) |
| 7 | Some constructs need their own lexing: insert arguments (`[[ ]]`, `\,` `\)`), `Context:` and `Characteristics:` lists | 6,154 files with parameterized inserts | [4.3](#43-insert-rules), [2.2](#22-metadata) |
| 8 | Tokens that contain whitespace and structure: `Profile :`, `( required )`, `Reference( A or B )`, `Canonical(x\|1.0)` | `Reference(...)` in 28.8% of files | [1.8](#18-parenthesized-forms) |
| 9 | Comments are discarded by SUSHI, glued to rule markers, and a `//` comment can end the file without a newline | line comments in 39% of files, 43% of files lack a final newline | [1.3](#13-comments) |
| 10 | Many constraints that look syntactic are semantic: id and name formats, metadata order and duplicates, which rules an entity allows, indentation multiples | 2,468 ids and names breaking the spec's format rules, all accepted by SUSHI's parser | [5](#5-semantic-rules-that-should-not-be-parse-errors) |

---

## 1. Lexical structure

### 1.1 Files and encoding

Spec: [Whitespace](https://build.fhir.org/ig/HL7/fhir-shorthand/reference.html#whitespace),
[Primitives](https://build.fhir.org/ig/HL7/fhir-shorthand/reference.html#primitives).

- **Files**: SUSHI reads every file whose name ends with lowercase `.fsh` under `<project>/input/fsh/` as UTF-8, and keeps the
  content as is. Before parsing it appends a newline if the file does not end with one; [1.3](#13-comments) explains why.
- **Byte-order mark**: SUSHI does not strip a UTF-8 BOM. The BOM becomes part of the first word (`﻿Profile:`), so the
  file fails to parse. No corpus file has one. IntelliJ strips the BOM when it loads a document, so the plugin's lexer never sees it.
- **Line endings**: LF dominates.
  - 2,175 files (4.6%) use CRLF.
  - 10 files mix CRLF and LF.
  - 7 files contain a lone CR.
- **No final newline**: 20,415 files (42.9%) do not end with a newline.
- **Non-ASCII characters**: 18,815 files (39.6%) contain some, mostly in strings, but also in paths (see [3.3](#33-paths)).
- **Typographic quotes**: 390 files contain `“` or `”`. The spec forbids them as string delimiters, but they are legal inside strings.

**Implication**: the lexer must accept `\n`, `\r\n` and lone `\r` as line terminators, and must not rely on a final newline. Any
character can appear inside strings, comments and words.

### 1.2 Whitespace

Repeated whitespace has no meaning, except:

- inside strings;
- for indentation before `*` ([3.4](#34-indentation-sets-path-context));
- between rules, which "MUST be separated" by a newline ([3.1](#31-the-rule-marker)).

| Character | Allowed as whitespace | Corpus |
|---|---|---|
| space | yes | — |
| tab | yes, except as indentation and right after `*` | 2,250 files contain tabs |
| NBSP (U+00A0) | yes, SUSHI treats it like a space, even right after `*` | 306 files; 50 rules in 6 files have `*` followed by NBSP |
| form feed | yes | — |

- **Tab right after `*`** (`*\tname`): SUSHI does not see a rule marker. The `*` becomes a word, and the rule is a syntax error.
- **Tab before `*`**: SUSHI's rule marker accepts it, but counts each tab as one column of indentation. 4 files have a tab before a
  line-start `*`.

**Implication**:

- The whitespace class is `[ \t\f ]` plus line terminators.
- "`*` followed by space or NBSP" is the rule marker; `*` followed by a tab is not. The grammar may still accept it and let an
  annotator report it, as a lenient choice.

### 1.3 Comments

Spec: [Comments](https://build.fhir.org/ig/HL7/fhir-shorthand/reference.html#comments). The syntax is JavaScript's: `// line` and
`/* block */`.

| Construct | Files | Occurrences |
|---|---:|---:|
| line comments | 18,637 (39.2%) | 279,122 |
| block comments | 1,845 (3.9%) | 3,711 |
| … spanning several lines | 1,689 | 3,008 |
| trailing comments (after code on the same line) | 3,644 (7.7%) | 39,279 |
| a line comment directly before a rule, absorbed into SUSHI's `STAR` token | 12,859 (27.0%) | 115,765 |
| `//` comment on the last line, with no final newline | 821 (1.7%) | — |
| block comment glued to a neighboring word | 1 | 2 |

How SUSHI lexes comments:

- **Comments are discarded** (`-> skip`). An IDE must keep them as tokens for highlighting, folding and the commenter.
- **`LINE_COMMENT` must end with a newline**: `'//' ~[\r\n]* [\r\n]`. A `//` comment on the last line without a newline is not a
  comment. This is why SUSHI appends a newline to every file.
- **The rule marker can swallow a comment**: `STAR` is `([\r\n] | LINE_COMMENT) WS* '*' [  ]`, so a comment line followed by a
  rule is one `STAR` token.
- **Longest match decides**: a comment is only recognized where a new token starts.
  - `http://example.org//path` is one word.
  - `#a//comment` is one code.
  - `1..1/*c*/` is one word and makes the rule invalid (SUSHI rejects it).
- **Unterminated block comment**: `/*` without `*/` is not a comment for SUSHI; `/*` becomes a word.

**Implication**:

- Emit `LINE_COMMENT` and `BLOCK_COMMENT` tokens and report them through `ParserDefinition.getCommentTokens()`.
- A line comment ends *before* the line terminator and may end at EOF.
- An unterminated block comment must still be a single token, up to EOF, so that recovery stays local.
- Whether `/*` glued to a word starts a comment is a design choice:
  - SUSHI says no.
  - An IDE could say yes and let an annotator flag the difference. The corpus has a single file with this pattern, so either
    choice is safe.

### 1.4 Words, longest match and the catch-all `SEQUENCE`

FSH has no identifier syntax. Names, paths, URLs, ids, `$aliases` and filter operators are all "any run of non-whitespace
characters": SUSHI's `SEQUENCE: NONWS+`. The other token rules compete with it, and ANTLR picks the longest match. On equal length,
the rule defined first wins.

| Input | SUSHI tokens | Why |
|---|---|---|
| `2020` | `NUMBER` | `NUMBER` is defined before `DATETIME`, same length |
| `2020-01-15` | `DATETIME` | longer than `NUMBER` |
| `10:30:00` | `TIME` | |
| `0..1`, `1..`, `..*`, `..` | `CARD` | both bounds are optional, so `..` alone is a cardinality |
| `http://example.org/x#frag` | `CODE` | `CODE` is `SEQUENCE? '#' …`; SUSHI's Alias rule accepts a `CODE` for this reason (29 aliases in 11 files) |
| `extension[http://x.org/a#b].valueString` | `CODE` | a path containing `#` becomes a code, and the rule fails to parse |
| `Profile:Foo` | `SEQUENCE` | the keyword needs whitespace (or end of word) after the colon to win |
| `Profile : Foo` | `KW_PROFILE("Profile :")`, `SEQUENCE` | whitespace before the colon is part of the keyword token |
| `'mg':2` | `SEQUENCE` | a ratio needs spaces around `:` |
| `"a\d"` | `SEQUENCE` | not a valid `STRING` ([1.5](#15-strings)), so it falls back to a word |
| `* code = insert` | `KW_INSERT`, then a lexer error | `insert` always switches the lexer to RuleSet-reference mode ([4.4](#44-lexer-modes-are-global-hazards)) |

In the corpus:

- `SEQUENCE` is the most common token after the rule marker: 2.5 M occurrences.
- 5,503 files contain `scheme://` URLs as words.
- 374 files contain `urn:` words.

**Implication**:

- The lexer works on **words**, like SUSHI. A word is classified by its shape: keyword, number, date, time, cardinality, code, URL,
  caret path, or plain word.
- Recognition must be at least as permissive as SUSHI's, otherwise valid files break. Structure inside a word (path segments,
  system/code split) is found afterwards, by PSI references or a sub-lexer; see Phase 3.
- Fine-grained tokens such as `IDENTIFIER DOT LBRACKET` cannot express "no whitespace inside a path" once whitespace is hidden from
  the parser. Avoid them.

### 1.5 Strings

Spec: [Primitives](https://build.fhir.org/ig/HL7/fhir-shorthand/reference.html#primitives),
[Triple-Quoted Strings](https://build.fhir.org/ig/HL7/fhir-shorthand/reference.html#triple-quoted-strings).

**Quoted strings** `"…"`:

- **Newlines**: they may contain raw newlines (4,893 strings in 1,898 files).
- **Escapes**: SUSHI's `STRING` accepts only `\"`, `\\`, `\n`, `\r`, `\t` and `\u`. `\u` needs no hex digits.
  - Escaped quotes appear in 3,004 files.
  - Other valid escapes appear in 1,085 files.
  - Any other backslash sequence makes the whole literal fall back to a word; `"a\d"` is not a string for SUSHI. A FHIRPath
    regex written with one backslash, as in `Expression: "matches('\d+')"`, is therefore a syntax error; authors must write `\\d`.
- **Unterminated**: an unterminated string is not a string either. Its pieces become words, and the error surfaces later.

**Triple-quoted strings** `"""…"""` (19,365 occurrences in 5,797 files, 12.2%):

- **Content**: anything up to the closing `"""`, including quotes at the end: `"""say "hi""""` is one string.
- **Indentation**: SUSHI strips common indentation, drops blank first and last lines, and blanks whitespace-only lines. This is a
  value-level transformation, not a lexical one.
- **Use**: `Description:` uses it in 3,964 files, and invariant `Expression:` in 24.

A `*` at the start of a line inside a string is not a rule marker. Strings are tokens, so a string can make a rule span lines (8,963
rules in 2,947 files).

**Implication**:

- `STRING` and `MULTILINE_STRING` tokens may span lines, and must be returned as a single token even when unterminated (up to EOF, or
  up to a heuristic stop) so that the rest of the file still lexes.
- Whether an invalid escape keeps the literal a string is a leniency choice. Keeping it a string, with an annotator warning, is far
  more robust than SUSHI's fallback. The fallback can even change the value kind: SUSHI lexes `"8655\#S08"` (no space, an invalid `\#`
  escape) as a code, and one SUSHI-clean corpus value relies on it. The grammar keeps it a string.

### 1.6 Codes and codings

Spec: [Codes and Codings](https://build.fhir.org/ig/HL7/fhir-shorthand/reference.html#codes-and-codings).

A code is `#code`, `#"code with spaces"` or `system#code`. The system can be:

- a name;
- an `$alias`;
- a URL, optionally versioned with `|version`.

A display string may follow as a separate token. In SUSHI, the whole `system|version#code` is a single `CODE` token.

| | Occurrences | Files |
|---|---:|---:|
| `CODE` tokens | 2,176,462 | 40,431 (85.0%) |
| … local (`#code`, no system) | 1,662,037 | |
| … system is an `$alias` | 363,181 | |
| … system is a name | 80,510 | |
| … system is a URL or URN | 70,734 | |
| … quoted code (`#"…"`) | 17,014 | 762 |
| … versioned system (`url\|2.68#code`) | 5,219 | 112 |
| codes followed by a display string | 334,273 | 15,133 |

Codes can contain characters such as `/`, `<=` or `:`; `#application/x-fhir-query` is common in SDC questionnaires.

**Implication**:

- `CODE` is one lexer token: optional system, `#`, then a word or a quoted string.
- Its parts (system, version, code) are text ranges for PSI references, for example to resolve `$alias` and the CodeSystem name.

### 1.7 Numbers, dates, times, cardinalities

| Form | SUSHI token | Notes |
|---|---|---|
| `-1.5e-3`, `+2`, `42` | `NUMBER` | sign and exponent allowed |
| `2024`, `2024-01`, `2024-01-15`, `2024-01-15T10:30:00.000+01:00` | `NUMBER` (bare year), else `DATETIME` | |
| `10:30`, `10:30:00.5Z` | `TIME` | |
| `0..1`, `1..`, `..*`, `..` | `CARD` | 149,445 occurrences |

SUSHI's `name` and `path` rules accept `NUMBER`, `DATETIME` and `TIME` as well as words:

- `Instance: 1` exists (86 numeric entity names in 30 files).
- 43 files have RuleSets with numeric names.

**Implication**: numbers and dates are word shapes. Wherever a name or a path is expected, the grammar must accept them as names.

### 1.8 Parenthesized forms

These SUSHI tokens include parentheses and inner whitespace:

| Form | SUSHI | Corpus |
|---|---|---|
| `(example)` `(preferred)` `(extensible)` `(required)` `(exactly)`, whitespace allowed inside | one keyword token | `( … )` with inner whitespace: 1 file |
| `Reference(A or B)` | one `REFERENCE` token: `'Reference' WS* '(' … ')'`, whitespace and newlines allowed | 104,464 in 13,703 files (28.8%); several targets in 2,390 files; inner whitespace in 631; spanning lines in 61; `\|` inside (versioned targets, `Patient?identifier=a\|b`) in 41 |
| `Canonical(url\|version or Name)` | one `CANONICAL` token | 9,826 in 3,257 files; with `\|version` in 229 |
| `CodeableReference(A or B)` | one `CODEABLE_REFERENCE` token | 235 in 162 files |

A display string can follow a reference: `Reference(JaneDoe) "Jane"`.

**Implication**: split these into tokens: `Reference`, `(`, targets, `or`, `)`. Then each target is its own PSI element that can be
resolved, renamed and completed. The keywords are only keywords when followed by `(`, which JFlex lookahead can check.

### 1.9 Quantities and ratios

Spec: [Quantities](https://build.fhir.org/ig/HL7/fhir-shorthand/reference.html#quantities).

| Construct | Example | Corpus |
|---|---|---|
| UCUM quantity | `5.4 'mg' "milligram"` | 7,623 |
| coded unit | `155.0 http://ncithesaurus-stage.nci.nih.gov#C48531 "Pound"` | 3,559 |
| with display | | 9,060 in 1,386 files |
| unit without a number (`'mg'` alone) | | 35 in 6 files |
| ratio | `1 'mg' : 2 'mL'` | **0** |

A UCUM unit is a single-quoted string (`UNIT`). A ratio needs spaces around its `:` ([1.4](#14-words-longest-match-and-the-catch-all-sequence)).

**Implication**: `UNIT` is a token. Ratios must be supported (the spec has them), but they are not a priority for corpus coverage.

### 1.10 Regular expressions

`/…/` is only meaningful as a ValueSet filter value (`where code regex /[0-9]+/`). There are 29 occurrences in 13 files. SUSHI lexes
`REGEX` everywhere, but it cannot start in the middle of a word, so URLs are safe.

**Implication**: lex `/…/` as a regex only where a word starts with `/` and ends with `/`, or only after `regex`. It is rare, so either
works.

---

## 2. Items (entities)

### 2.1 Declarations and keywords

Spec: [Structure of FSH Items](https://build.fhir.org/ig/HL7/fhir-shorthand/reference.html#structure-of-fsh-items).

An item is a declaration `Keyword: name`, then keyword statements (`Parent:`, `Id:`, …), then rules. Nothing marks the end of an
item; it ends where the next declaration starts. Rules always belong to the latest item.

| Entity | Count | | Metadata keyword | Count |
|---|---:|---|---|---:|
| Instance | 60,223 | | `Description:` | 88,631 |
| Alias | 38,570 | | `Title:` | 74,564 |
| ValueSet | 15,849 | | `InstanceOf:` | 60,223 |
| Profile | 14,882 | | `Usage:` | 54,734 |
| CodeSystem | 6,938 | | `Id:` | 39,695 |
| Extension | 4,822 | | `Parent:` | 15,952 |
| Invariant | 4,565 | | `Severity:` | 4,008 |
| RuleSet (plain) | 2,707 | | `Expression:` | 3,948 |
| RuleSet (parameterized) | 2,405 | | `Context:` | 1,598 |
| Logical | 2,129 | | `Source:` | 1,529 |
| Mapping | 1,529 | | `Target:` | 1,202 |
| Resource | 8 | | `Characteristics:` | 593 |
| | | | `XPath:` | 118 |

Lexical rules for keywords:

- **Colon required**: declaration and metadata keywords are keywords only when followed by `:`, optionally after whitespace.
  `Profile :` appears in 189 files (489 times).
- **Case-sensitive**: `profile:` is a word.
- **Whitespace after the colon**: `Profile:Foo`, with nothing after the colon, is a single word in SUSHI
  ([1.4](#14-words-longest-match-and-the-catch-all-sequence)).
- **Not necessarily at line start**: 156 keywords in 64 files are indented. A keyword could even follow other tokens on the same
  line.
- **Contextual rule keywords**: `from`, `contains`, `named`, `and`, `or`, `only`, `obeys`, `include`, `exclude`, `codes`, `where`,
  `valueset`, `system`, `insert`, `contentReference`, `true`, `false` and the flags `MS` `SU` `TU` `N` `D` `?!` are reserved by the
  spec. SUSHI's grammar still accepts most of them as names and paths (`mostAlphaKeywords`), and the corpus needs that:

  | Reserved word used as a path | Occurrences |
  |---|---:|
  | `system` | 7,316 |
  | `MS` | 6 |
  | `where`, `exclude` | 3 each |
  | `contains`, `codes`, `SU` | 2 each |

  `system` is an element of `Coding`, `Identifier`, `ContactPoint`, … so `* system = "http://…"` is everywhere in instances. No
  entity name in the corpus is a reserved word.

**Implication**:

- Declaration and metadata keywords use lookahead for `{ws}* ":"`.
- Rule keywords are contextual. The lexer may emit them as keyword tokens, but the grammar must accept every one of them wherever a
  name or a path is expected, in the parser (a `name ::= WORD | NUMBER | … | keyword` rule, as SUSHI does). Otherwise
  `* system = …` breaks in thousands of files.

### 2.2 Metadata

- **Any order**: SUSHI's grammar accepts metadata in any order (`sdMetadata+`, `instanceMetadata*`, …). Duplicates are rejected by
  the importer, not the grammar. There are none in the corpus.
- **Not after rules**: metadata after the first rule is a syntax error in SUSHI.
- **At least one for profiles**: SUSHI's grammar requires at least one metadata keyword for a Profile (`sdMetadata+`). Every corpus
  Profile has a `Parent:`; 2,359 Extensions have none, which is legal.
- **`Description:` and `Expression:` values**: a string or a triple-quoted string.
- **`Context:`** (Extensions) takes a comma-separated list. SUSHI lexes it in its own mode.
  - Items can be quoted FHIRPath (`"Observation.code"`), unquoted names or paths (`Patient`, `Element#extension`), or `url#path`.
  - 1,415 lists have a single item; a few have 10 or more.
  - 1,922 items are unquoted, 10 quoted.
  - The mode ends only at an item without a trailing comma. With `Context: Patient,`, the next line's `Description:` is read as the
    last list item, and the description string becomes a syntax error.
- **`Characteristics:`** (Logical models) takes a comma-separated list of codes (593 uses).
- **`Usage:`** takes a code (`#example`, `#definition`, `#inline`), and **`Severity:`** takes a code.

**Implication**:

- Accept any metadata in any order, with duplicates, and also after rules, as a lenient choice. Annotate instead of failing.
- Parse comma lists with ordinary tokens (`WORD`, `STRING`, `CODE`, `,`), not with a dedicated lexer mode.

### 2.3 Aliases

`Alias: $name = value`:

- **Names**: names start with `$` in 36,407 aliases (2,174 files). 2,163 aliases (339 files) have no `$`, which is legal but makes
  their uses indistinguishable from plain names.
- **Values**: values are URLs or URNs. A value with a `#` fragment is lexed as a code
  ([1.4](#14-words-longest-match-and-the-catch-all-sequence)).
- **Scope**: aliases are global to the project (all files), and a redefinition with another value is an error (semantic).

**Implication**: an Alias is a declaration with a name word and a value word or URL. References to aliases appear inside codes
(`$sct#123`), paths, `from` targets, `InstanceOf`, … so alias resolution works on text ranges.

---

## 3. Rules

Spec: [FSH Rules](https://build.fhir.org/ig/HL7/fhir-shorthand/reference.html#fsh-rules).

### 3.1 The rule marker

A rule starts with `*` followed by at least one space, as the first non-whitespace character of a line. That is the only place where
FSH is line-sensitive:

- **Rule marker token**: SUSHI's `STAR` token is `([\r\n] | LINE_COMMENT) WS* '*' [  ]`. It includes the preceding newline and
  the indentation, and a `*` on the very first line of a file is therefore not a rule marker. 3,777,644 rule markers appear in the
  corpus.
- **Rules can span lines**: newlines are ordinary whitespace inside a rule. 14,736 rules in 4,118 files (8.7%) have tokens on later
  lines, without counting multi-line strings. The typical case is a `contains` list: 41% of `contains` rules list their items on
  following lines.

  ```fsh
  * component contains
      systolic 1..1 MS and
      diastolic 1..1 MS
  ```

- **Rules end at the next rule marker or declaration**, not at a newline. A line that does not start with `*` continues the
  previous rule or metadata.

**Implication**:

- The lexer must know whether a `*` is the first non-whitespace character of its line, and emit a distinct `STAR` token only then.
  That "at line start" knowledge is lexer state, which IntelliJ's incremental lexer restarts must handle (Phase 3).
- `STAR` is also the main synchronization point for error recovery: every line-start `*` begins a new rule node, whatever happened
  before.

### 3.2 Rule kinds are decided late

Spec: [summary of rule types](https://build.fhir.org/ig/HL7/fhir-shorthand/reference.html#fsh-rules) (Table 12). After the marker,
most rules start with a path. What follows the path decides the kind:

| Shape after `* <path>` | Kind (SUSHI grammar rule) | Occurrences | Files |
|---|---|---:|---:|
| `= value (exactly)?` | assignment (`fixedValueRule`) | 1,546,304 | 25,062 |
| `^caret = value` | caret value (`caretValueRule`) | 297,793 | 20,076 |
| `insert RuleSet(…)` | insert with path context (`insertRule`) | 7,786 of 102,727 | 541 |
| `card flags*` | cardinality (`cardRule`) | 82,497 | 8,954 |
| nothing | path rule (`pathRule`) | 78,012 | 5,303 |
| `only Type (or Type)*` | type (`onlyRule`) | 40,566 | 9,376 |
| `card flags* Type (or Type)* "short" "definition"?` | add element (`addElementRule`, Logical/Resource) | 33,487 | 1,853 |
| `(and path)* flags+` | flag (`flagRule`) | 27,696 | 3,872 |
| `from ValueSet (strength)?` | binding (`valueSetRule`) | 17,593 | 6,163 |
| `-> "map" "comment"? #lang?` | mapping (`mappingRule`) | 15,317 | 968 |
| `contains item (and item)*` | contains (`containsRule`) | 15,193 | 5,795 |
| `obeys Inv (and Inv)*` | obeys (`obeysRule`) | 4,592 | 1,833 |
| `card flags* contentReference url "short" …` | add element (`addCRElementRule`) | 14 | 6 |

Rules that do not start with a path:

| Shape | Kind | Occurrences |
|---|---|---:|
| `* ^caret = value` | top-level caret value | 155,513 (16,109 files) |
| `* insert RuleSet` / `* insert RuleSet(…)` | insert | 102,727 in total |
| `* obeys Inv` | top-level obeys | 2,892 (1,292 files) |
| `* -> "map"` | top-level mapping | 667 (531 files) |
| `* #code "display" "definition"?` / `* #parent #child …` | CodeSystem concept (`concept`) | 644,899 (4,171 files); hierarchy on one line: 5,859 in 28 files |
| `* #code ^prop = value` / `* ^prop = value` in a CodeSystem | code caret value (`codeCaretValueRule`) | 505,688 |
| `* #code insert RuleSet` | code insert (`codeInsertRule`) | 631 in 2 files |
| `* include? system#code "display"` / `* include? codes from system X (and valueset Y)* (where filter (and filter)*)?` / `* exclude …` | ValueSet component (`vsComponent`) | 347,914 (implicit include 308,065, `include` 39,502, `exclude` 347) |

Ambiguities to note:

- **Cardinality**: `* name 0..1` is a cardinality rule in a Profile, but the start of an add-element rule in a Logical model if a
  type follows.
- **A word at the start**: `* system …` may be a path or the keyword; only the next token tells.
- **CodeSystems and ValueSets**: the first word decides between a code (`#x`), a path, a caret path, or a keyword (`include`,
  `exclude`, `codes`, `insert`).

**Implication**: left-factor. Parse `STAR`, then an optional head (a path, codes, or a caret path), then the tail that decides the
kind. With Grammar-Kit's ordered choice, alternatives with a distinctive token come first and the path rule comes last. `pin` after
the head keeps a rule node even when the tail is broken. An unrecognized tail becomes an "unknown rule" node instead of an error that
spreads to the following rules.

### 3.3 Paths

Spec: [FSH Paths](https://build.fhir.org/ig/HL7/fhir-shorthand/reference.html#fsh-paths). A path is one word made of dot-separated
segments. Each segment may be followed by bracketed parts.

| Feature | Example | Occurrences | Files |
|---|---|---:|---:|
| soft index `[+]` | `name[+].given` | 261,637 | 10,301 |
| soft index `[=]` | `name[=].family` | 493,803 | 6,306 |
| numeric index | `name[0]` | 306,520 | 7,889 |
| choice `[x]` | `value[x]` | 29,388 | 6,241 |
| reslicing or slice plus index | `component[a][b]`, `entry[meds][1]` | 17,227 | 1,724 |
| URL or canonical in brackets | `extension[http://hl7.org/…/us-core-race]` | 1,608 | 225 |
| `/` in a slice name | `category[us-core/social-history]` | 150 | 15 |
| `@` in a slice name | | 16 | 2 |
| non-ASCII letters or commas | `component[højde]`, `FamiliäreDispositionbeiEltern,Geschwistern…` | 321 | 40 |
| the special `.` path | `* . ^short = "…"` | 4,186 | 2,295 |
| caret paths | `^extension[0].valueString`, `component ^short` | 806,268 | 23,546 |

Notes:

- **Caret paths are their own token** in SUSHI (`CARET_SEQUENCE: '^' NONWS+`). After an element path, a space before `^` is
  required (`component ^short`).
- **Brackets can hold almost anything**: slice names, resource types (`performer[Practitioner]`), URLs, indexes. A URL with `#` in
  brackets turns the whole path into a `CODE` token in SUSHI, which then fails to parse
  ([1.4](#14-words-longest-match-and-the-catch-all-sequence)).
- **Paths start with a word, a number or a reserved word** ([2.1](#21-declarations-and-keywords)). `system` alone accounts for 7,316
  paths.

**Implication**:

- A path is one lexer token.
- Its internal structure (segments, brackets, `[x]`, soft indexes) matters for references and completion, not for parsing. Expose
  it by sub-lexing the path token, or with text-range PSI references.
- The lexer must not split a word at `[` or `.`, and must not treat `#` inside brackets as starting a code.

### 3.4 Indentation sets path context

Spec: [Indented Rules](https://build.fhir.org/ig/HL7/fhir-shorthand/reference.html#indented-rules). A rule indented below another
inherits the less-indented rule's path as a prefix. One level is exactly two spaces.

```fsh
* item[+]
  * linkId = "a"          // item[0].linkId
  * item[+]
    * linkId = "a.1"      // item[0].item[0].linkId
* status = #active        // context reset
```

Corpus:

| | |
|---|---|
| files using indentation | 8,560 (18.0%) |
| indented rules | 721,355 of 3,777,644 (19.1%) |
| indentation in spaces: count | 0: 3,056,289 · 2: 486,909 · 4: 125,163 · 6: 79,381 · 8: 21,737 · 10: 4,829 · 12: 1,006 · … · 24 (12 levels): 28 |
| odd indentation (1 space) | 5 rules in 2 files; SUSHI reports an error and ignores the context |

Semantics, all handled by SUSHI's importer rather than its grammar:

- **Which path counts**: the context is the path of the nearest less-indented rule. With several paths (`* a and b MS`), the last
  path sets the context. An indented multi-path rule applies the context to every path.
- **Rules without a path**: such a rule (top-level caret, obeys, mapping, insert) cannot carry context. Indenting under it is an
  error.
- **Soft indexes**: `[+]` in a context path is incremented once, not once per child rule.
- **CodeSystems**: indentation creates concept hierarchies.
- **ValueSets**: it attaches caret rules to the concept above them.
- **Inserts**: an indented `insert` applies its context to every inserted rule.
- **The `.` path**: it is only allowed in top-level rules.

**Implication**:

- The grammar stays flat: every rule is a sibling inside its entity.
- The indentation of a rule (the width before `*`) is available from the PSI, and the context path is computed on demand in PSI
  utilities.
- Nesting the PSI by indentation would make incremental reparsing and the formatter much harder, and gains nothing for parsing.

### 3.5 Values

Assignment values, by SUSHI's `value` alternatives:

| Value | Occurrences |
|---|---:|
| string | 1,097,852 |
| code (with optional display) | 956,636 |
| `Reference(…)` | 84,012 |
| `true` / `false` | 69,502 |
| number | 68,141 |
| name (an instance or other item, e.g. `* contained[0] = MyInstance`) | 42,239 |
| quantity | 11,182 |
| `Canonical(…)` | 9,519 |
| triple-quoted string | 6,441 |
| date/dateTime | 4,125 |
| time | 136 |
| ratio | 0 |

`(exactly)` follows 5,270 assignments in 1,645 files.

**Implication**: the value alternatives are distinguished by their first token, except quantity versus number. A number followed by
a `UNIT` or a code is a quantity; a number followed by `:` is a ratio. A value made of a single word is a name reference.

### 3.6 Other rule details

- **Flags**: `MS` (70,065), `SU` (953), `N` (55), `?!` (25), `D` (17), `TU` (0). Several flags can follow a path, a cardinality or a
  contains item. A flag rule may list several paths with `and` (502 rules in 204 files).
- **Binding**:
  - With a strength: `(required)` 8,444, `(extensible)` 3,309, `(preferred)` 2,049, `(example)` 597.
  - Without a strength: 3,194.
- **Contains**:
  - Items are `Name card flags*` or `Extension named name card flags*`. `named` is used in 2,528 files.
  - A rule lists up to 10 or more items.
  - Items often sit on following lines ([3.1](#31-the-rule-marker)).
- **Type**: `only A or B` (several types in 1,046 rules). Types are:
  - names: 22,808
  - `Reference(…)`: 19,288
  - `CodeableReference(…)`: 233
  - `Canonical(…)`: 115
- **Obeys**:
  - With a path: `* path obeys inv-1 and inv-2`.
  - Without a path: 2,892 rules, applying to the item itself.
- **Mapping**: `* path -> "target" "comment"? #mime?`. 667 rules have no path; one has a language code.
- **Add element** (Logical models and Resources):
  - `* name card flags* Type (or Type)* "short" "definition"?`.
  - Several types in 347 rules; a definition string in 20,598.
  - `contentReference` form: 14 rules.
- **ValueSet filters** (`where property operator value`):
  - Operators are plain words: `is-a` 1,195, `=` 711, `descendent-of` 422, `exists` 345, `descendant-of` 122 (a spelling variant
    the parser must accept), `in` 57, `regex` 49, `is-not-a` 3.
  - Values: code 1,802, string 728, `true`/`false` 345, regex 29.

**Implication**: filter operators are words, not keywords. Treating `in`, `regex` or `exists` as keywords would break paths and names
using those words.

---

## 4. RuleSets and insert

### 4.1 Plain RuleSets

Spec: [Defining Rule Sets](https://build.fhir.org/ig/HL7/fhir-shorthand/reference.html#defining-rule-sets).

`RuleSet: Name` followed by rules. The body may mix any rule kinds, because the RuleSet can be inserted into any item. The 2,707
plain RuleSets in the corpus contain:

- assignments: 13,582
- caret values: 10,697
- inserts: 2,525
- cardinalities: 1,593
- path rules: 1,065
- contains: 530
- types: 495
- bindings: 343
- add elements: 332
- flags: 308
- mappings: 251
- obeys: 106
- even CodeSystem concepts: 8

How SUSHI lexes the RuleSet name: `RuleSet:` switches to a mode where the name is one token, `RULESET_REFERENCE`, including leading
whitespace. Then either `(` starts a parameter list or the mode ends.

**Implication**:

- Inside a RuleSet, accept every rule kind.
- Lex the RuleSet name as an ordinary word. A `(` glued to it, or after optional whitespace, starts a parameter list.

### 4.2 Parameterized RuleSets

Spec: [Parameterized Rule Sets](https://build.fhir.org/ig/HL7/fhir-shorthand/reference.html#parameterized-rule-sets).

`RuleSet: Name(p1, p2)` declares parameters. Every `{p1}` (or `{ p1 }`) in the body is replaced textually at each `insert`, anywhere:

- inside strings;
- as a whole word;
- inside a word such as `#{type}` or `item[{index}]`.

SUSHI keeps the body as raw text: `paramRuleSetContent: STAR ~(entity keywords)*`. It only parses the body after substitution,
separately for each set of arguments.

| | |
|---|---|
| parameterized RuleSet definitions | 2,405 |
| parameters per definition | 1: 872 · 2: 654 · 3: 385 · 4: 189 · 5: 128 · 6: 106 · 7: 42 · up to 11 |

Where placeholders appear, as tokens of SUSHI's lexer applied to the raw body:

| Placeholder position | Count |
|---|---:|
| inside a string | 2,661 |
| a whole word (`{path}`, `{value}`) | 2,309 |
| inside a word (`item[{i}]`, `{prefix}Name`) | 1,430 |
| inside a code (`#{type}`, `$sct#{code}`) | 691 |
| inside an argument of a nested `insert` | 896 |
| inside `Reference(…)` | 226 |
| inside `Canonical(…)` | 47 |
| inside a caret path | 44 |
| inside a triple-quoted string | 35 |
| inside a comment absorbed by a rule marker | 16 |
| inside a UCUM unit | 2 |

The key figure: **2,223 of 2,405 bodies (92.4%) parse as valid FSH rules with the placeholders left in place**. Placeholders almost
always sit where a word, a string or a code is expected anyway. 181 bodies fail even after replacing every placeholder with `x`.
These are templates that only become FSH after substitution (for example `* {rule}` or partial keywords), or bodies that are
genuinely incomplete.

Placeholders written with spaces (`{ x }`) appear in at most 3 files. Braces that are not parameters (FHIRPath, JSON in strings)
appear in 40 bodies.

**Implication**:

- The "easiest option" chosen in PLAN.md (decision 3) is to lex the body normally and parse it as untyped rule lines. That is always
  safe.
- The corpus shows that parsing bodies with the ordinary typed-rule grammar would succeed for 92% of them, so that upgrade is cheap
  later. It needs a `{param}`-aware word shape and a fallback to untyped lines for the remaining 8%.

### 4.3 Insert rules

Spec: [Insert Rules](https://build.fhir.org/ig/HL7/fhir-shorthand/reference.html#insert-rules).

| Form | Occurrences | Files |
|---|---:|---:|
| `* insert RS` | 17,271 | 5,574 |
| `* insert RS(a, b)` | 88,120 | 6,154 (12.9%) |
| `* path insert RS(…)` | 7,786 | 541 |
| `* #code insert RS(…)` (CodeSystem) | 631 | 2 |
| whitespace between name and `(`: `insert RS (a)` | 2,196 | 662 |
| arguments per insert | 1: 16,245 · 2: 13,597 · 3: 45,378 · 4: 7,893 · 5: 2,327 · … · up to 11 | |
| `[[bracketed]]` argument | 10,139 | 719 |
| `\,` or `\)` escapes | 7,749 | 622 |
| escapes inside `[[ ]]` (for `]],` or `]])`) | 6 | 4 |
| argument spanning lines | 2,128 | 276 |
| argument containing quotes | 16,957 | 628 |
| empty argument (`RS(,b)`) | 212 | 30 |

Argument syntax, as SUSHI lexes it in two dedicated modes:

- **Separators**: arguments are separated by `,` and the list ends with `)`. Whitespace around arguments is trimmed.
- **Escapes**: inside a plain argument, `\,`, `\)` and `\\` are escapes, and anything else, including newlines and quotes, is
  literal. SUSHI's lexer takes the longest match, so a comma preceded by a backslash never separates arguments, even after an
  escaped backslash: `a\\, b` is one argument. Three corpus lines rely on this (`insert-argument-backslash-comma.fsh`).
- **`[[ … ]]`**: it wraps an argument that contains commas and parentheses. Only `]],` and `]])` need escaping inside it.
- **Arguments are text**: they are not FSH tokens. `insert RS("a, b")` has two arguments, `"a` and `b"`, because quotes have no
  meaning here.

**Implication**:

- After `insert Name(`, the lexer must switch to an argument mode with its own token types: argument text, comma, closing paren,
  `[[`/`]]` and escapes, until the closing `)`.
- This state spans lines, so it must be encoded in the lexer's restartable state.
- Each argument becomes a PSI element, so the plugin can check the argument count against the RuleSet's parameters.

### 4.4 Lexer modes are global hazards

SUSHI enters lexer modes on keyword tokens, wherever they appear:

- **`insert` and `RuleSet:`**: both enter RuleSet-reference mode, so `* code = insert` makes SUSHI's lexer fail on the rest of the line.
- **`Context:` and `Characteristics:`**: both enter list modes that end only at the last list item. A malformed list can swallow
  following tokens.

**Implication**: in the IntelliJ lexer, use modes only where they cannot run away:

- the insert argument list, bounded by the matching `)` or, as a safety net, by the next line-start `*` or declaration. This
  departs from SUSHI in one corpus file (three branches of `hl7-eu/eps`), where an argument spans lines that start with `*`. That
  file is a known gap: the safety net keeps a half-typed `insert X(` from turning the rest of the file into arguments;
- strings;
- comments.

Treat everything else, Context lists included, with ordinary tokens.

---

## 5. Semantic rules that should not be parse errors

**Principle: the grammar decides the *shape* of a file; annotators judge its *content*.** Whenever the input can be read
unambiguously, the parser builds a normal tree, and the rule is checked later by an annotator or inspection. A parse error can only
say "unexpected token". An annotator can say "this id is 71 characters long; FHIR ids are limited to 64" and offer a quick-fix. A
parse error also degrades everything after it, while an annotation on a correct tree does not.

### 5.1 Value formats

The spec gives format rules for many values. None of them belongs in the lexer or the grammar: a name, an id or a slice name is just
a word there ([1.4](#14-words-longest-match-and-the-catch-all-sequence)), whatever its length and characters.

| Value | Spec rule | Checked in the corpus | Violations |
|---|---|---:|---:|
| Instance id (`Instance: x`) | [Item Identifiers](https://build.fhir.org/ig/HL7/fhir-shorthand/reference.html#item-identifiers): ASCII letters, digits, `-` and `.`; at most 64 characters | 60,223 | 732 in 333 files |
| Mapping id (`Mapping: x`) | same | 1,529 | 222 in 205 files |
| `Id:` value | same | 39,695 | 13 in 13 files |
| Invariant id (`Invariant: x`) | same | 4,565 | 0 |
| … ids longer than 64 characters | | | 182 in 30 files, up to 100 characters |
| … ids containing `_`, the most common mistake | | | 765 in 500 files |
| … ids with other invalid characters | | | 29 in 22 files |
| … ids with non-ASCII characters | | | 2 files |
| Item name (Profile, Extension, Logical, Resource, ValueSet, CodeSystem) | [Item Names](https://build.fhir.org/ig/HL7/fhir-shorthand/reference.html#item-names): an uppercase ASCII letter, then ASCII letters, digits and `_`; at most 255 characters | 44,628 | 815 in 660 files |
| … names not starting with an uppercase letter | | | 356 in 206 files |
| … names with other characters, mostly `-` | | | 705 in 579 files |
| RuleSet name | same | 5,112 | 624 in 200 files |
| Slice name (`contains` items) | ASCII letters, digits, `_`, `-`, `@`, `/` | 32,826 | 61 in 34 files, mostly non-ASCII letters such as `højde` |
| Alias name | `$` recommended; ASCII letters, digits, `_`, `-`, `.` | 38,570 | 1, plus 2,163 without `$` |

Every one of these files parses without errors in SUSHI: the rules are not part of its grammar either. SUSHI only reports some of
them when exporting, or leaves them to the IG Publisher. Other values follow the same principle:

- **Codes, URLs and canonicals** are words or code tokens of any content.
- **Dates and times** are recognized by shape, without range checks: `2024-13-45` is still a date token.
- **Reserved words used as item or slice names** are allowed by SUSHI and discouraged by the spec.
- **Severity and Usage codes** outside their value sets.

All of these are annotations, not parse errors.

The numbers come from the same evidence script ([Reproducing the numbers](#reproducing-the-numbers)); the features are named
`format.*`.

### 5.2 Structure

SUSHI's grammar or importer rejects all of the following. For an IDE they are better reported by annotators and inspections, with
quick-fixes, on a well-formed tree:

- **Metadata**: wrong order or duplicate keywords; a missing required keyword (`Parent:` on Profile, `InstanceOf:` on Instance,
  `Source:`/`Target:` on Mapping); metadata after rules.
- **Rule kinds**: a rule kind not allowed in the current item, for example a cardinality rule in an Instance or an assignment in an
  Invariant (spec Table 7).
- **Indentation**: indentation that is not a multiple of two spaces (5 rules in the corpus); indenting under a rule without a path;
  `.` in a nested rule.
- **Aliases**: names with `|`; an alias redefined with a different value (seen in the corpus: SUSHI reports it).
- **Inserts**: a wrong number of insert arguments; an unknown RuleSet.
- **References**: unresolvable names (Parent, InstanceOf, ValueSet, invariant, alias, RuleSet).

### 5.3 Lexical forms

These forms are SUSHI syntax errors, but an IDE can read them unambiguously:

- a tab after `*`;
- invalid string escapes (`"matches('\d+')"`);
- a block comment glued to a word;
- `#` inside path brackets;
- `insert` used as a value;
- a `*` rule on the first line of a file;
- typographic quotes as string delimiters.

The grammar accepts them, and an annotator explains what SUSHI will do with them.

In the corpus, SUSHI reports semantic errors in only 18 repository files: alias redefinitions, duplicate entity names, and
indentation not in multiples of two. The format violations of 5.1 are far more common, but SUSHI does not see them when parsing.
Leniency matters most for files *being edited*: a half-typed id or a name with a typo should get a precise message, not break the
tree around it.

## 6. Out of scope

- **Legacy FSH**: SUSHI < 1.0 layouts, `Mixins:`, `units`, `Reference(A | B)` with `|` as separator.
- **Semantics beyond the PSI**: resolving soft indexes, expanding RuleSets, and checking paths against FHIR definitions belong to the
  plugin's later features, not to the grammar.

## 7. Requirements for the grammar

These carry over into `docs/grammar-kit-design.md`.

1. **Lexer coverage**: every character belongs to a token. Unterminated strings, triple-quoted strings and block comments end at EOF
   as one token. Line comments may end at EOF. Comments are tokens.
2. **Line terminators**: `\n`, `\r\n` and `\r`. Whitespace also includes tab, form feed and NBSP.
3. **Rule marker**: `*` followed by a space or NBSP, as the first non-whitespace character of a line. The "at line start" fact
   survives incremental restarts, and editor re-lexing after an edit stays correct (restart points at line starts,
   `grammar-kit-design.md` D4).
4. **Word-level lexing**: one token per whitespace-free word, classified by shape. Keywords are recognized by context:
   - declaration and metadata keywords need a following `:`;
   - `Reference`, `Canonical` and `CodeableReference` need a following `(`;
   - binding strengths and `(exactly)` are parenthesized keywords with optional inner whitespace;
   - rule keywords are tokens that the grammar also accepts as names.
5. **Contextual keywords as names**: every rule keyword, flag, number, date and time is also a valid name and path start.
6. **Parenthesized references**: `Reference(…)`, `Canonical(…)` and `CodeableReference(…)` are token sequences, with each target its
   own element; whitespace and newlines are allowed inside.
7. **Codes**: one token (`system|version#code`, or a quoted code) with text-range structure; display strings are separate tokens.
8. **Insert arguments**: a dedicated, bounded lexer mode for insert arguments (`[[ ]]`, `\,` `\)` `\\`). The only other bounded state
   covers the parentheses of `Reference(…)`, `Canonical(…)` and `CodeableReference(…)` (see `grammar-kit-design.md`, D6). There
   are no list modes, and strings and comments are single tokens.
9. **Rules**: left-factored as marker, head, then tail. Pin on the marker, with an unknown-rule fallback. Recovery synchronizes on
   the line-start `*` and on declarations.
10. **Flat structure**: a flat rule list per entity. Indentation is data on the rule, and path context is computed in PSI utilities.
11. **Lenient containment**: every metadata keyword and every rule kind is accepted in every entity, in any order
    ([5.2](#52-structure)).
12. **Format-free values**: the lexer and the grammar never encode the format rules of ids, names, slice names, alias names, codes,
    URLs or dates. Any word is accepted, whatever its length and characters, and annotators check the formats with specific messages
    and quick-fixes ([5.1](#51-value-formats)). The same goes for unambiguous lexical forms that SUSHI rejects
    ([5.3](#53-lexical-forms)).
13. **Parameterized RuleSet bodies**: never an error (decision 3). Since M2, each line is typed when it parses completely and raw
    otherwise (`grammar-kit-design.md`, D13).
14. **Performance**: parsing must be linear, with no exponential backtracking. Dense generated terminologies reach about 5 MB with
    88 k rules. The 17–79 MB files are mostly one block comment that disables about 1.6 M rules. The IDE builds no PSI above 2.5 MB
    by default (see `grammar-kit-design.md` §10).

---

## Appendix A: How SUSHI's lexer tokenizes tricky inputs

Each input was tokenized with SUSHI 3.21.0's `FSHLexer`; hidden whitespace is omitted. `SEQUENCE("*")` at the start of a line means
the snippet started at the very beginning of the input, where `STAR` cannot match because it needs a preceding newline.

| Input | Tokens |
|---|---|
| `* x = 2020` | `NUMBER("2020")` |
| `* x = 2020-01-15T10:30:00Z` | `DATETIME` |
| `* z ..*` / `* w ..` | `CARD("..*")` / `CARD("..")` |
| `Alias: $a = http://example.org/x#frag` | `KW_ALIAS SEQUENCE("$a") EQUAL CODE("http://example.org/x#frag")` |
| `* x = http://loinc.org\|2.68#1234-5 "Display"` | `CODE("http://loinc.org\|2.68#1234-5") STRING` |
| `* x = Reference( A or B ) "display"` | `REFERENCE("Reference( A or B )") STRING` |
| `* x only Reference(A or⏎ B)` | `KW_ONLY REFERENCE("Reference(A or\n B)")` |
| `* x from VS ( required )` | `KW_FROM SEQUENCE("VS") KW_REQUIRED("( required )")` |
| `Profile : Foo` | `KW_PROFILE("Profile :") SEQUENCE("Foo")` |
| `Profile:Foo` | `SEQUENCE("Profile:Foo")` |
| `profile: X` | `SEQUENCE("profile:") SEQUENCE("X")` |
| `Profile: X⏎*⇥name 1..1` | `… SEQUENCE("*") SEQUENCE("name") CARD` (tab: no rule marker) |
| `Profile: X⏎*␣name 1..1` (NBSP) | `… STAR("\n* ") SEQUENCE("name") CARD` |
| `Profile: X⏎// c⏎* name 1..1` | `… STAR("// c\n* ") …` (comment absorbed) |
| `* x = 1 'mg' : 2 'mL'` | `NUMBER UNIT COLON NUMBER UNIT` |
| `* x = 1 'mg':2 'mL'` | `NUMBER SEQUENCE("'mg':2") UNIT` |
| `* x = http://example.org//path` | `SEQUENCE("http://example.org//path")` |
| `* x = #a//comment` | `CODE("#a//comment")` |
| `* x 1..1/*c*/` | `SEQUENCE("1..1/*c*/")` |
| `* x 1..1 /*c*/ MS` | `CARD KW_MS` (comment skipped) |
| `* insert RS(a, [[b, c]], d\, e\) f)` | `KW_INSERT PARAM_RULESET_REFERENCE(" RS(") PLAIN_PARAM("a,") BRACKETED_PARAM(" [[b, c]],") LAST_PLAIN_PARAM(" d\, e\) f)")` |
| `* insert RS (a)` | `KW_INSERT PARAM_RULESET_REFERENCE(" RS (") LAST_PLAIN_PARAM("a)")` |
| `* code = insert` | `… KW_INSERT` then a token recognition error |
| `Context: Patient, "Observation.code", Element#extension` | `KW_CONTEXT UNQUOTED_CONTEXT("Patient,") QUOTED_CONTEXT LAST_UNQUOTED_CONTEXT("Element#extension")` |
| `* x = "a\d"` | `SEQUENCE("\"a\\d\"")` (not a string) |
| `* x = """say "hi""""` | `MULTILINE_STRING("\"\"\"say \"hi\"\"\"\"")` |
| `* . ^short = "s"` | `SEQUENCE(".") CARET_SEQUENCE("^short") EQUAL STRING` |
| `* extension[http://x.org/a#b].valueString = "s"` | `CODE("extension[http://x.org/a#b].valueString") EQUAL STRING` |
| `* include codes from system S where code regex /[0-9]+/` | `KW_INCLUDE KW_CODES KW_FROM KW_SYSTEM SEQUENCE KW_WHERE SEQUENCE("code") SEQUENCE("regex") REGEX` |
| `* x MS SU ?! N D TU` | `KW_MS KW_SU KW_MOD KW_NORMATIVE KW_DRAFT KW_TU` |
| `﻿Profile: X` | `SEQUENCE("﻿Profile:") SEQUENCE("X")` |
| `Description: "never closed⏎* name 1..1` | `KW_DESCRIPTION SEQUENCE("\"never") SEQUENCE("closed") STAR …` |
| `* {path} 1..1⏎* item[=].type = #{type}` | `SEQUENCE("{path}") CARD STAR SEQUENCE("item[=].type") EQUAL CODE("#{type}")` |

## Appendix B: Hand-written edge cases and SUSHI's verdicts

The committed cases in `corpus/edge-cases/handwritten/` pin the behaviors described above. The grammar should accept every
"clean" case without errors, and should recover locally on every "syntax error" case. Ideally it also accepts the cases marked
*lenient*, and leaves them to an annotator.

| File | SUSHI | What it shows |
|---|---|---|
| `binding-strength-spacing.fsh` | clean | `( required )`, `( exactly )` with inner spaces |
| `codes-and-quantities.fsh` | clean | versioned systems, quoted codes, UCUM and coded units, dates, times, signed and exponent numbers |
| `codesystem-hierarchy.fsh` | clean | indented and one-line concept hierarchies, code caret rule, code insert |
| `comment-at-eof-no-newline.fsh` | clean | `//` comment ending the file |
| `contains-multiline-with-comments.fsh` | clean | contains items on following lines, with line, trailing and block comments in between |
| `context-and-characteristics.fsh` | clean | `Context:` list, `Characteristics:`, add-element and `contentReference` rules |
| `crlf-line-endings.fsh` | clean | CRLF |
| `flags-as-names.fsh` | clean | flags (`MS`, `N`, `D`) as entity and slice names |
| `indented-rules.fsh` | clean (semantic error) | nested context, soft indexes; `.` in a nested rule is rejected by the importer |
| `insert-arguments-edge.fsh` | clean (2 expansion errors) | empty argument, space before `(`, escaped comma, `[[ ]]`, argument over two lines |
| `insert-argument-backslash-comma.fsh` | clean (1 expansion error) | `a\\, b\, c` is one argument |
| `keyword-space-before-colon.fsh` | clean | `Profile :`, `Parent :` |
| `keywords-as-names.fsh` | clean | `and`, `system`, `from`, `named`, `valueset` as names and paths |
| `multiline-strings.fsh` | clean | triple-quoted strings with quotes and `*` inside |
| `nbsp-whitespace.fsh` | clean | NBSP as whitespace, including after `*` |
| `numeric-names.fsh` | clean | `Instance: 1`, `RuleSet: 123` |
| `only-comments.fsh` | clean | no entity at all |
| `param-ruleset-brackets.fsh` | clean | placeholders in strings and codes; `[[ ]]`, `\,`, `\)` arguments; insert with path |
| `param-ruleset-template-only.fsh` | clean | a body (`* {path} {card}`) that is only FSH after substitution |
| `ratio-spaced.fsh` | clean | `1 'mg' : 2 'mL'` |
| `reference-canonical-forms.fsh` | clean | `Reference( A or B )`, several targets, versioned `Canonical`, `CodeableReference` |
| `reference-versioned-targets.fsh` | clean | `Reference (` with a space, `\|7.0.0` targets, a reference spanning lines |
| `string-escapes.fsh` | clean | all valid escapes |
| `system-as-path.fsh` | clean | `system` as a path, top-level and indented |
| `url-with-fragment-alias.fsh` | clean | alias values with `#fragment` and `urn:oid:`, alias without `$` |
| `vs-filters.fsh` | clean | filter operators as words (`is-a`, `descendant-of`, `=`, `exists`, `regex`), regex value, valueset exclusion |
| `empty.fsh` | clean | empty file |
| `block-comment-adjacent.fsh` | syntax error, *lenient* | `1..1/*no space*/` |
| `context-trailing-comma.fsh` | syntax error | runaway `Context:` list |
| `insert-as-value.fsh` | syntax error, *lenient* | `insert` as a value |
| `invalid-string-escape.fsh` | syntax error, *lenient* | `"matches('\d+')"` |
| `keyword-glued-to-name.fsh` | syntax error | `Profile:Glued` |
| `lowercase-keyword.fsh` | syntax error | `profile:` is not a keyword |
| `path-with-hash-in-brackets.fsh` | syntax error, *lenient* | `extension[http://…#y]` |
| `ratio-glued.fsh` | syntax error | `'mg':2` |
| `rule-on-first-line.fsh` | syntax error, *lenient* | `*` on line 1 |
| `tab-after-star.fsh` | syntax error, *lenient* | `*⇥name` |
| `unterminated-block-comment.fsh` | syntax error | `/*` without `*/` |
| `unterminated-multiline-string.fsh` | syntax error | `"""` without closing |
| `unterminated-string.fsh` | syntax error | `"` without closing |
| `string-missing-quote-before-declaration.fsh` | syntax error, *lenient* | a missing closing quote: SUSHI's string runs to the next entity's quote and loses that entity; the grammar cuts the string at a line-start declaration |
| `utf8-bom.fsh` | syntax error, *lenient* | BOM (IntelliJ strips it anyway) |

## Reproducing the numbers

```bash
npm run corpus:manifest
```

```bash
node corpus/scripts/language-evidence.mjs
```

The second command writes `corpus/cache/language-evidence.json`: every feature with its file count, its occurrence count and up to
five example locations, plus histograms. It runs in about a minute on 15 threads. Pass `--include-edge-cases` to also analyze the
spec and SUSHI-test snippets, and `--max-size=N` to change the 2 MB cap.

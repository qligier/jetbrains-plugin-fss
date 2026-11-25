# Lexer and grammar design (JFlex + Grammar-Kit)

How the FSH lexer and parser for the IntelliJ Platform are built, and why they differ from SUSHI's ANTLR4 grammar. It starts from
the requirements at the end of [`fsh-language.md`](fsh-language.md#7-requirements-for-the-grammar), cited as **R1** to **R14**,
and records one **decision** per topic (**D1**, **D2**, …).

**Constraints** (see PLAN.md):

- The plugin builds against IntelliJ IDEA 2025.3 and stays compatible with build 242 (2024.2).
- The grammar lives in `src/main/grammar/fsh/fsh.{flex,bnf}`, with code in the plugin's packages
  (`ch.qligier.jetbrains.plugin.fss.fsh.language…`).
- The plugin generates the code from the IDE. This sandbox generates it with the Gradle Grammar-Kit tasks.

**Verification**: platform behavior cited here was checked in the `242` branch of `JetBrains/intellij-community`: `FlexAdapter`,
`idea-flex.skeleton`, `LexerEditorHighlighter`, `LexerTestCase` and `ParsingTestCase`. Grammar-Kit behavior was checked in its README,
HOWTO and changelog (2023.3.4). Corpus numbers come from `fsh-language.md` or from probes noted inline.

## Decisions at a glance

| # | Topic | Decision |
|---|---|---|
| D1 | Parser API | Classic `PsiBuilder` / `GeneratedParserUtilBase` code, not Grammar-Kit's Kotlin `parser-api="syntax"` mode |
| D2 | Token granularity | Word-level tokens like SUSHI; words never split at `.`, `[`, `(`, `,` or `#`; structure inside words comes from PSI text ranges |
| D3 | Trivia | Explicit `WHITE_SPACE` (newlines included), `LINE_COMMENT` and `BLOCK_COMMENT` tokens |
| D4 | Rule marker, restart points | A `STAR` token for a `*` that is the first non-blank character of its line, detected by looking back in the buffer. Restart points (state 0) are line starts only, and nothing after an unterminated token is one (M5) |
| D5 | Keywords | Declaration and metadata keywords need a following `:`; `Reference`/`Canonical`/`CodeableReference` need a following `(`; rule keywords are distinct tokens that the grammar also accepts as names |
| D6 | Lexer modes | Bounded states only: insert and RuleSet argument lists, the parentheses of reference forms, the `:` after a keyword. No list modes for `Context:`/`Characteristics:` |
| D7 | Unterminated tokens | A string, triple-quoted string or block comment with no closer before EOF ends at the end of its first line; so does a string that would run across a line-start declaration (M5) |
| D8 | Leniency in the lexer | Accept the forms SUSHI rejects but that are unambiguous; annotators report them |
| D9 | Rule structure | Left-factored: `STAR head? tail?`; `upper` rules turn the generic rule node into its specific kind |
| D10 | Entity-agnostic rules | One rule grammar for every entity. Shapes that only the entity can disambiguate (CodeSystem concept vs ValueSet concept) get one shared node type |
| D11 | Error recovery | `pin` on `STAR`, declaration and metadata keywords; `recoverWhile` stops at the next line-start `*`, metadata or declaration; other text is one error element |
| D12 | Indentation | A flat list of rules per entity; indentation and context paths are computed by PSI utilities |
| D13 | Parameterized RuleSet bodies | Each line typed when it parses completely, raw otherwise; never an error (PLAN.md decision 3) |
| D14 | Names | One `name` rule accepting words, numbers, dates, times and rule keywords; keyword leaves are remapped to `WORD` |
| D15 | Values for annotators | Dedicated PSI nodes for every value an annotator checks: entity name, `Id:` value, slice names, alias names, insert arguments |
| D16 | Incremental parsing | Default full reparse with tree diff at first; entity-level reparseable blocks only if the bench shows a need |

---

## 1. Toolchain facts

### 1.1 JFlex through `FlexAdapter`

The generated lexer implements `FlexLexer` (`%implements FlexLexer`, `%function advance`, `%type IElementType`, `%unicode`). The
platform wraps it in `FlexAdapter`, whose behavior shapes several decisions:

- **Token start is the previous token's end.** `locateToken()` sets `myTokenStart = myTokenEnd` before calling `advance()`, and
  takes the end from `getTokenEnd()`. Text matched by a JFlex action that does not return is therefore *not lost*: it is merged into
  the next returned token. Gaps between tokens are impossible in the middle of a file.
- **EOF can lose text.** At end of input the skeleton returns `null` when nothing is pending. Text consumed by non-returning
  actions just before EOF ends up in no token, and IntelliJ requires full coverage (R1). Every state must handle `<<EOF>>` and return
  the pending token.
- **The state reported for a token is the state before lexing it**: `myState = myFlex.yystate()` before `advance()`.
- **Exceptions are fatal for the rest of the file.** An exception in `advance()` turns the remainder into one `BAD_CHARACTER`
  token. The lexer must never throw.

> Correction to PLAN.md: the lesson about the `dev-2026` lexer said accumulated text is "dropped from the next token". That is only
> true at EOF. In the middle of a file, `FlexAdapter` merges it into the next token.

**Version**: the Gradle setup pins JFlex 1.9.2 (the IntelliJ Platform Gradle Plugin default). The IDE's Grammar-Kit plugin bundles
JFlex 1.10.17 since 2023.3.3. Both use IntelliJ's `idea-flex.skeleton`, so the generated lexers behave the same. Align the sandbox
on 1.10.x in M0 if the artifact is available.

### 1.2 Grammar-Kit

**Parsing model**: Grammar-Kit generates a recursive-descent parser with **PEG semantics**:

- ordered choice, where the first alternative that matches wins;
- backtracking on failure;
- no left recursion except in `extends`-based expression parsing.

ANTLR's ALL(\*) prediction, which SUSHI relies on to choose among `cardRule | flagRule | … | pathRule`, has no equivalent. Order and
factoring are the author's job (section 4).

**Error handling**:

- `pin` turns a partial match into a match: once the pinned item matches, the rest is parsed "whether it matches or not", and
  errors are reported in place.
- `recoverWhile` takes a predicate rule. After the rule, the parser skips tokens while the predicate matches. Its contract (HOWTO
  §2.2): the rule is inside a loop, has a `pin`, and the predicate leaves the input intact.

**Runtime facts found in M2** (read in `GeneratedParserUtilBase`, and each one hit by the bench or the golden tests):

- **`recoverWhile` runs even when the rule does not start.** The generated code drops the fast "next token is" check for such a
  rule, and the recovery runs on failure too. A rule with recovery that is tried as one alternative among others therefore swallows
  the text up to its recovery stop. The spike grammar lost the rest of a file after leading junk this way. Call such rules behind a
  lookahead: `&STAR rule`, `&metadata_keyword metadata`.
- **A pinned rule reports an error only if expected variants exist at the error position.** Token matches register variants, but
  external rules do not. A missing name after `system` (`<<nameToken>>`) produced no error at all. The `nameToken` helper now calls
  `addVariant(builder, "<name>")` when it fails.
- **`upper` retypes the nearest framed ancestor.** A rule gets a frame when it has a `pin`, a `recoverWhile`, a modifier or a
  `name`. A plain rule has none, and an `upper` tail inside it retypes the next framed ancestor instead, such as the entity. The
  typed line of parameterized RuleSets therefore has `name="rule"`.
- **`remapCurrentToken` survives a rollback.** A keyword that a failed alternative remapped to `WORD` stays a `WORD` for the next
  alternative. Alternatives that need the keyword must therefore come before any alternative that reads the same token as a name,
  or check it with a lookahead (see `headless_obeys`).
- **`elementType=other_rule`** lets a second rule build the same node type (`typed_param_line` builds `RULE`).

**Rule modifiers**:

- `private` creates no node.
- `left` wraps the previous sibling.
- `upper` replaces the parent node and adopts its children.
- `meta` rules take parameters.
- `external` rules call hand-written code from `parserUtilClass` or `parserImports`.
- `fake` rules only shape the PSI classes.

**PSI generation**:

- Hierarchy: `extends` builds the class hierarchy and collapses redundant nodes.
- Custom code: `mixin`, `implements`, and `methods` with `psiImplUtilClass`.
- Stubs: `stubClass` and `elementTypeFactory` (the stub types themselves are hand-written).
- Comment binding: `hooks=[leftBinder=…, rightBinder=…, wsBinders=…]` attaches whitespace binders, which decide whether neighboring
  comments belong to a node.

**Performance options**:

- `consumeTokenMethod=…="consumeTokenFast"` skips error-message bookkeeping where messages do not matter.
- `generate=[token-sets="yes"]` generates `TokenSet`s for token choices.

**Live Preview** evaluates the grammar in the IDE with regexp-defined tokens. It cannot run `external` rules or the real JFlex
lexer, so it is a sketching tool, not a test.

### D1: classic `PsiBuilder` parser

Grammar-Kit 2023.3.2+ can generate a Kotlin parser on the platform's newer syntax library (`generate=[parser-api="syntax"]`,
`SyntaxGeneratedParserRuntime`). That library is not available in build 242, which the plugin supports. Use the classic generation,
which relies on the platform's own copy of `GeneratedParserUtilBase`.

Note: Grammar-Kit's next release requires IDE 252 *to run the plugin*. That is irrelevant to the generated code, which only depends
on the platform API.

---

## 2. Token model

### D2: words, as in SUSHI

FSH's unit of meaning is the **word**: a run of non-whitespace characters ([fsh-language §1.4](fsh-language.md#14-words-longest-match-and-the-catch-all-sequence)).
Paths, names, ids, URLs, `$aliases`, filter operators and slice names are all words, and SUSHI's whole grammar is built on that.

Two models were considered:

| Option | Description | Verdict |
|---|---|---|
| **(a) Word-level tokens** | One token per word, classified by shape (`WORD`, `NUMBER`, `DATE_TIME`, `TIME`, `CARD`, `CODE`, `CARET_PATH`, keywords…). Structure inside a word (path segments, code system and code) is exposed by the PSI as text ranges. | **Chosen** |
| (b) Fine-grained tokens | `IDENTIFIER DOT LBRACKET …`, with "no whitespace in between" enforced by `external` rules | Rejected |

Why option (a):

- It is what SUSHI does, so every bench differential (our tree versus SUSHI's structure) compares like with like.
- Words are never split: not at `.`, `[`, `#`, `,` or `(`. The corpus needs that.
  - **Parentheses**: 3,306 words in 277 files contain parentheses, such as the codes `#1a(0)` and `#is(LAMN)`.
  - **Commas**: commas appear inside paths (`FamiliäreDispositionbeiEltern,Geschwistern…`). A probe found 16 words in 2 files that end
    with a comma outside SUSHI's list modes, including codes such as `#M110.1,` in a file SUSHI accepts.
- Option (b) would need whitespace checks between almost every pair of tokens. The previous `dev-2026` attempt took this route and
  accepted `a . b` as a path.

**Consequence**: the parser sees few, large tokens. References inside a word are the plugin's job, through `PsiReference`s with text
ranges ([section 7](#7-psi-design)).

### D3: trivia

| Token | Content | Reported by |
|---|---|---|
| `WHITE_SPACE` (`TokenType.WHITE_SPACE`) | runs of space, tab, form feed, NBSP, `\n`, `\r` | `getWhitespaceTokens()` |
| `LINE_COMMENT` | `//` up to, not including, the line terminator, or EOF | `getCommentTokens()` |
| `BLOCK_COMMENT` | `/* … */` | `getCommentTokens()` |

Notes:

- **Newlines** stay inside `WHITE_SPACE`. No rule depends on a newline token: rules end at the next `STAR` (D4). Indentation is
  computed from offsets (D12).
- **Comments** are never absorbed into another token, unlike SUSHI's `STAR`, which swallows the comment line before a rule.

### D4: the rule marker

`STAR` is a `*` that is the first non-blank character of its line, followed by a space, NBSP, tab, end of line or EOF. It is
detected **by looking back** in the buffer from the `*` over `[ \t\f\u00A0]` to a line terminator or the buffer start. Lexer state
is not involved.

Why look back rather than use state or JFlex's `^`:

- **`^` is unreliable here.** IntelliJ's skeleton sets "at beginning of line" to true on every `reset()`, whatever the offset.
- **State would be fragile.** Restarts happen only at tokens lexed in the initial state (`LexerEditorHighlighter` walks back to a
  segment whose state is the initial state). An "at line start" flag in the state would either block most restart points, or need
  careful encoding.
- **Looking back is safe.** The platform always gives the lexer the whole buffer and a start offset: the editor highlighter,
  `LexerTestCase.checkCorrectRestart` and `PsiBuilder` all do. Looking before the start offset is therefore safe and needs no state.

Lenient choices (D8):

- **`*` followed by a tab** at line start is a `STAR`; SUSHI rejects it, and an annotator reports it.
- **`*` alone at the end of a line**, while the user is typing, is a `STAR`. The parser builds an empty rule, and completion has a
  place to work.
- **`*` on the first line of the file** is a `STAR`.
- **`*` not at line start**, or glued to a word (`*name`), is part of a word, as in SUSHI.

**Verification**: `checkZeroState(text, {STAR, declaration keywords})` asserts that these tokens are always lexed in state 0, so
every rule and declaration is a restart point. `checkCorrectRestart` runs on corpus samples (Phase 4).

**Restart points (revised in M5).** Restartability alone is not enough. The editor's `LexerEditorHighlighter` re-lexes after an
edit from a state-0 token before it, starting two segments before the change. It stops at the first token after the change whose
start, type and state match an old segment. So any lexer decision that depends on text beyond its own token can be left stale. The
M5 bench applies 145,000 random edits to a real document and compares the highlighter's segments with a full lexing. It found three
such dependencies, now fixed:

- **The `:` after a keyword and a space** (`Profile :Name`) was decided by looking back at the keyword across a whitespace token.
  Editing `Profile` left a stale `COLON`. That `:` is now lexed in the `AFTER_COLON_KEYWORD` state, entered after the keyword
  (D6).
- **A regex** spans words up to its closing `/` on the same line. Typing that `/` changed a token that starts several segments
  before the edit.
- **An unterminated token** (D7) depends on whether a closer exists anywhere later. Typing `*/`, `"""` or `"` far below changed it.

The lexer therefore uses three inclusive states for its main rules:

- `YYINITIAL` (state 0) only for the first token of a line;
- `IN_LINE` for the other tokens of the line;
- `DIRTY` for every token after an unterminated token, until the end of the input.

A `token()` helper sets the state after each token. A whitespace token that contains a line break returns to `YYINITIAL`, and a cut
token switches to `DIRTY`. Restart points are line starts. Any decision that depends on the rest of its line is re-lexed after an
edit on that line, and an edit after an unterminated token re-lexes from that token. Bounded states (D6) exit to `IN_LINE`. At a
line-start `*` or declaration, they push it back and exit to `YYINITIAL`, so that token stays a restart point.
`FshLexerAdapter.start` resets the "dirty" flag on every restart.

The `*` look-back itself was safe all along. The newline and the indentation before a line-start `*` are one whitespace token, so
the highlighter cannot resynchronize between them and the `*`. Keyword look-ahead (`Profile` followed by `:`) is safe too: it stays
within the two segments the highlighter re-lexes before a change, and within the line.

**Verification (M5)**:

- `FshEditorRelexTest` targets these cases with the real `LexerEditorHighlighter`.
- The bench's random edits find no divergence on the corpus.
- `checkZeroState` holds for all edge cases without unterminated tokens.
- `testNoRestartPointAfterUnterminatedToken` checks the dirty mode.

### D5: keywords

| Class | Tokens | Recognized when | Notes |
|---|---|---|---|
| Declaration | `Alias` `Profile` `Extension` `Instance` `Invariant` `ValueSet` `CodeSystem` `RuleSet` `Mapping` `Logical` `Resource` | the word is exactly the keyword, followed by optional `[ \t\f\u00A0]*` and `:` | The `:` is a separate `COLON` token. No corpus keyword has a newline before its colon (probe: 0), so the lookahead stays on the line. |
| Metadata | `Parent` `Id` `Title` `Description` `Expression` `XPath` `Severity` `InstanceOf` `Usage` `Source` `Target` `Context` `Characteristics` | same | |
| Reference forms | `Reference` `Canonical` `CodeableReference` | followed by optional whitespace and `(` | They enter the reference-parentheses state (D6). |
| Parenthesized | `(example)` `(preferred)` `(extensible)` `(required)` `(exactly)` | one token each, with optional inner whitespace, as in SUSHI | |
| Rule keywords | `from` `contains` `named` `and` `or` `only` `obeys` `insert` `include` `exclude` `codes` `where` `valueset` `system` `contentReference` `true` `false` | the whole word equals the keyword (longest match keeps `system.foo` a word) | Distinct tokens. The grammar also accepts them as names (D14). |
| Flags | `MS` `SU` `TU` `N` `D` `?!` | same | same |
| Symbols | `=` `->` `:` and a standalone `,` | the whole word is the symbol | A comma glued to a word stays in the word (D2). Lists strip it in the PSI. |

Keywords are case-sensitive (`profile:` is a word).

A word starting with a declaration or metadata keyword and a colon, such as `Profile:Glued`, is split into keyword, `COLON` and the
rest, with a pushback in the word action. SUSHI reads it as one word and fails. Splitting keeps the entity boundary visible to the
parser (D8).

**Why distinct tokens for rule keywords, not soft keywords lexed as `WORD`**: keyword uses vastly outnumber name uses, except for
`system`. The counts are, as keyword / as path:

| Word | As keyword | As path |
|---|---:|---:|
| `MS` | 70,313 | 6 |
| `and` | 20,768 | 0 |
| `system` | 15,609 | 7,316 |

So the lexer's guess is right most of the time, and the grammar repairs the rest (D14).

### D6: lexer states

States are bounded, and all exit at a line-start `STAR` or a declaration keyword as a safety net:

| State | Entered after | Tokens | Exits at |
|---|---|---|---|
| `YYINITIAL` (0) | — | everything above | — |
| `AFTER_INSERT` | the `insert` keyword | an optional RuleSet name word, which excludes `(` | the name; or `(` → `ARGS`; or a newline with no name yet, as in `* code = insert` |
| `AFTER_RULESET` | `RuleSet` `:` | the name word, which excludes `(` | the name; or `(` → `ARGS` |
| `AFTER_COLON_KEYWORD` (M5) | any other declaration or metadata keyword | blanks, then the `:` (also when glued to the next word) | the `:` |
| `IN_LINE`, `DIRTY` (M5, inclusive) | the first token of a line; an unterminated token | the main rules, like `YYINITIAL` | a line break (`IN_LINE` only); see D4 |
| `ARGS` | `Name(` after `insert` or `RuleSet:` | `ARG_TEXT` (plain argument, escapes `\,` `\)` `\\` included; like SUSHI, a comma after any backslash, even an escaped one, does not separate), `ARG_BRACKETED` (`[[ … ]]`, with `]]\,` and `]]\)` escapes), `COMMA`, `RPAREN`, `WHITE_SPACE` | the matching `)` |
| `REF_PARENS` | `Reference(`, `Canonical(`, `CodeableReference(` | target words (up to the last `)` of the word, as SUSHI's greedy targets: `Reference(A))` has the target `A)`; `\|` allowed, for `Profile\|7.0.0` and `Patient?identifier=a\|b`), `or`, `RPAREN`, `WHITE_SPACE` incl. newlines | `)` |

What this replaces in SUSHI:

- **`RULESET_OR_INSERT` and `PARAM_RULESET_OR_INSERT` modes** become `AFTER_INSERT`, `AFTER_RULESET` and `ARGS`.
- **The token-internal structure of `REFERENCE`, `CANONICAL` and `CODEABLE_REFERENCE`** becomes `REF_PARENS`, so each target is its
  own token (R6).
- **`LIST_OF_CONTEXTS` and `LIST_OF_CODES`** are dropped on purpose. Context items are words, strings and codes, separated by
  commas that are standalone `COMMA` tokens or glued to the item. The parser reads them as a list, and the list ends at the next
  keyword, so `Context: Patient,` followed by `Description:` no longer swallows the description (fsh-language §4.4).

**Restartability**: all states other than `YYINITIAL` cover short stretches, and every exit lands on a state-0 token, so restart points
stay dense. Multi-line strings and comments are single tokens, so they need no state.

> This refines R8 in fsh-language.md: besides the insert argument lists, the parentheses of reference forms also get a bounded
> state. Strings and comments need none.

### D7: unterminated strings and comments

Each of `STRING`, `MULTILINE_STRING` and `BLOCK_COMMENT` has a terminated pattern and an unterminated pattern:

- **The terminated pattern wins when a closer exists**. The unterminated pattern cannot cross the closer, so the terminated match is
  longer.
- **The unterminated pattern only matches when there is no closer anywhere before EOF.** In that case the action pushes back
  everything after the end of the first line.

Pushing back is safe: with no closing `"` anywhere later, nothing after the cut can pair with the opening quote. The rest of the file
lexes normally, and the parser recovers on the next line. That is far better than turning the rest of the file into one string while
the user is typing. An annotator reports the unterminated token.

**Also unterminated (M5)**:

- **A string or triple-quoted string that would run across a line starting with a declaration** (`Profile:`, `Instance:`, …). No
  string in a SUSHI-clean corpus file does; the only one is in a file SUSHI rejects. Without this rule, a deleted closing quote pairs
  with a quote of a later entity and swallows everything in between. SUSHI does exactly that and loses the entity
  (`string-missing-quote-before-declaration.fsh`). Block comments are exempt, because commented-out entities are common (651 block
  comments in the corpus contain a declaration).
- **A unit never spans lines** (`'mg'`). SUSHI's may, but no corpus unit does, and a lone `'` would otherwise swallow the following
  lines.

With these two rules, the bench's mutation check recovers every entity outside the damage (M5).

Lenient string escapes (D8): any `\x` sequence is accepted inside `STRING`. SUSHI rejects anything except `\" \\ \n \r \t \u`, and an
annotator reports the others (`"matches('\d+')"`).

### Word classification

JFlex rules mirror SUSHI's token definitions. Order matters: on equal length, the earlier rule wins, as in ANTLR.

| Token | Shape (simplified) | Notes |
|---|---|---|
| `NUMBER` | `[+-]?\d+(\.\d+)?([eE][+-]?\d+)?` | before `DATE_TIME`, so `2020` is a number |
| `DATE_TIME` | `\d{4}(-\d\d(-\d\d(T{TIME})?)?)?` | |
| `TIME` | `\d\d(:\d\d(:\d\d(\.\d+)?)?)?(Z\|[+-]\d\d:\d\d)?` | |
| `CARD` | `\d*\.\.(\d+\|\*)?` | `..` alone is a cardinality, as in SUSHI |
| `UNIT` | `'[^']*'` | UCUM |
| `CODE` | `{WORD_CHARS}*#({WORD_CHARS}+\|"…")` | If the `#` sits inside unclosed brackets (`extension[http://x#y].value`), the action returns `WORD` instead (D8). |
| `CARET_PATH` | `\^{WORD_CHARS}+` | |
| `REGEX` | `/…/` as a whole word | as in SUSHI |
| `STRING`, `MULTILINE_STRING` | see D7 | |
| `WORD` | `{WORD_CHARS}+` | everything else |

`BAD_CHARACTER` should never appear, because `WORD` covers every non-whitespace character. The bench asserts it (PLAN.md Phase 4).

### D8: leniency in the lexer

The lexer accepts these SUSHI syntax errors, because each has an unambiguous reading ([fsh-language §5.3](fsh-language.md#53-lexical-forms)):

- a tab after `*`;
- `*` on the first line;
- invalid string escapes;
- `#` inside path brackets;
- `insert` used as a value;
- a declaration keyword glued to its name;
- unterminated strings and comments (D7).

A block comment glued to a word (`1..1/*c*/`) stays part of the word, as in SUSHI: there is a single corpus file with this pattern,
and either reading is defensible.

Every lenient form gets an annotator message in the plugin explaining what SUSHI will do.

---

## 3. File and entity structure

```bnf
fshFile ::= file_item*
private file_item ::= entity | &STAR rule | <<orphanTokens>>

// `extends(".*_entity")=entity`: ENTITY collapses into the concrete node
entity ::= alias_entity | profile_entity | extension_entity | logical_entity | resource_entity | instance_entity
         | invariant_entity | value_set_entity | code_system_entity | param_rule_set_entity | rule_set_entity | mapping_entity

profile_entity ::= KW_PROFILE COLON entity_name? entity_item* { pin=1 }
// … one rule per declaration keyword; a RuleSet with a parameter list is a param_rule_set_entity (D13)

private entity_item ::= &metadata_keyword metadata | &STAR rule | junk   // any order, any kind (R11)
metadata ::= metadata_keyword COLON metadata_value? { pin=1 recoverWhile=metadata_recover }
```

- **Entities end where the next declaration keyword starts**, as in SUSHI. There is no closing token.
- **Lenient containment (R11)**: every metadata keyword and every rule kind is accepted in every entity, in any order, including
  metadata after rules. Annotators enforce the spec's tables. This also makes RuleSet bodies work, since their rules come from every
  kind of entity.
- **Orphan rules**: rules before the first declaration are plain rule nodes, not errors, and an annotator reports them. A file of
  comments only is valid (`only-comments.fsh`).
- **Junk is an error** (changed in M2): other text before the first declaration, after an entity name or after an alias value is
  one error element up to the next rule, metadata or declaration (`orphanTokens`, `junkTokens` in `FshParserUtil`). Such text is
  not an unambiguous form that an annotator could explain, and keeping it as a silent node hid it from the bench.
- **Alias**: `KW_ALIAS COLON entity_name alias_value`, where the value is `EQUAL` and a word or a code (URLs with a `#fragment` lex
  as `CODE`).
- **Metadata values**: `value (COMMA? value)*`, which covers names, strings, triple-quoted strings, codes, and the
  `Context:`/`Characteristics:` lists. Typed metadata nodes are left for M3.

---

## 4. Rules

### D9: left-factored rules with `upper`

The shared prefix is parsed once into a generic `RULE` node. A tail rule marked `upper` then replaces that node with the specific
kind, adopting all children:

```bnf
rule ::= STAR rule_body? { pin=1 recoverWhile=rule_recover }
private rule_recover ::= !(STAR | declaration_keyword | metadata_keyword)

private rule_body ::= headless_tail | vs_include_component | vs_filter_rule | codes code_tail | path rule_tail?
private headless_tail ::= caret_value_rule | insert_rule | headless_obeys | mapping_rule
private code_tail ::= caret_value_rule | insert_rule | &(STRING? KW_FROM) vs_concept_rule | concept_rule
private rule_tail ::= assignment_rule | caret_value_rule | binding_rule | only_rule | contains_rule | obeys_rule
                    | insert_rule | mapping_rule | flag_rule | card_tail
private card_tail ::= add_cr_element_rule | add_element_rule | card_rule

upper card_rule ::= CARD flag* { pin=1 }   // RULE(STAR, PATH, CARD, flags) becomes CARD_RULE(…)
upper assignment_rule ::= EQUAL value KW_EXACTLY? { pin=1 }
// …
```

- **Order**: tails that start with a distinctive token come first. The order is: `=`, `^…`, `from`, `only`, `contains`, `obeys`,
  `insert`, `->`, flags, then the cardinality-led tails: `contentReference` add-element, add-element (`CARD flag* type … "short"`,
  pinned once the type matches), then the plain cardinality. "Path and nothing else" is the path rule (generic `RULE`).
- **Prefix-less rules first**: rules without a head (`* ^x = v`, `* insert X`, `* obeys inv`, `* -> "m"`) are tried before the
  path. Rule keywords are valid path names (D14), so `* obeys inv-1` would otherwise parse `obeys` as a path, and the optional tail
  would leave `inv-1` unparsed. The spike hit exactly this.
- **`obeys` as a path**: SUSHI's prediction reads `* obeys obeys inv-1`, `* obeys 1..1 boolean "…"` and a bare `* obeys` with the
  path `obeys`. `headless_obeys` mirrors this: `obeys` starts a head-less rule only when the next token cannot start a tail after a
  path (`=`, `^…`, rule keywords, `CARD`, flags) and is not the end of the rule. `insert` is not a valid name, so it needs no such
  check.
- **Flags as types**: flags are also names, and SUSHI reads `* a 0..1 N TU "Short"` as the flag `N` and the *type* `TU`. The
  add-element tail mirrors it with `(flag !STRING)*` before the type.
- **Metadata keywords stop rule recovery** too (not only `STAR` and declarations), so that metadata after rules is read as
  metadata instead of as junk at the end of the previous rule.
- **ValueSet components** (M2):
  - `include`/`exclude` start a component only when a code or `codes` follows. Otherwise they are paths, for example an element
    named `include` in a Logical model.
  - `codes from system|valueset …` is a filter component (`VS_FILTER_RULE`). `* codes from SomeValueSet` is still a binding rule on
    the path `codes`, because only `system` or `valueset` after `from` makes a component.
  - A code with `from`, or after `include`/`exclude`, is a concept component (`VS_CONCEPT_RULE`). A code without them is a
    `CONCEPT_RULE` (D10).
  - Filters are `filter_property filter_operator value?`, where the operator is `=` or any word and the value is a code, a boolean,
    a regex or a string, as in SUSHI.
- **Cost**: every alternative is decided by its first one or two tokens, so backtracking stays shallow. Use `consumeTokenFast` on
  tail rules and `generate=[token-sets="yes"]`.
- **Unknown tails**: when no tail matches, the generic `RULE` node remains, with one error element at the unexpected token.
  `recoverWhile` then skips to the next line-start `*` or declaration, so one bad line yields one error.
- **Validated by the spike** ([section 10](#10-validation-spikes)): the generated parser marks tail rules with `_UPPER_`, so
  `RULE(STAR, PATH, CARD, …)` becomes `CARD_RULE(…)`. With `extends(".*_rule")=rule`, `FshCardRule` extends `FshRule`. An
  incomplete tail keeps its kind: `* code from` is a `BINDING_RULE` with one error element. The fallback, a generic `RULE` exposing
  its kind through a tail child, is not needed.
- **Rule naming**: Grammar-Kit generates a getter per child rule, so a rule must not be named after an inherited PSI method. A rule
  named `reference` generates `getReference()` and breaks compilation against `PsiElement.getReference()`. The same applies to
  `context` (`getContext()`), `name` (`getName()`), `parent`, `node`, `text`, `language`, `project`, … Use `reference_value`,
  `context_list`, `entity_name` instead.

### D10: one rule grammar for all entities

SUSHI has a rule set per entity kind (`sdRule`, `instanceRule`, `csRule`, `vsRule`, …), which makes misplaced rules syntax errors.
Here every entity uses the same rule grammar (R11). Some shapes are only distinguishable by the entity they appear in:

| Shape | In a CodeSystem | In a ValueSet | Node |
|---|---|---|---|
| `* #code "display" …` | concept (`ConceptRule`) | concept component (`ValueSetConceptComponentRule`) | `CONCEPT_RULE` |
| `* include #code`, `* #code from system X` | — | concept component | `VS_CONCEPT_RULE` |
| `* ^prop = v`, `* #code ^prop = v` | `codeCaretValueRule` | caret value | `CARET_VALUE_RULE` with an optional code head |
| `* #code insert RS`, `* path insert RS` | code insert | — | `INSERT_RULE` with an optional head |

The PSI interprets these nodes per entity, and the bench maps SUSHI's classes onto them (Phase 4).

### D12: flat structure and indentation

Rules are siblings inside their entity, as in SUSHI's grammar, whose importer resolves indentation from the `STAR` column:

- `FshPaths.indent(rule)` is the column of the `STAR`: its offset minus the line start offset.
- `FshPaths.contextPaths(entity)` resolves the path of every rule of an entity in one pass, the way SUSHI's importer does
  (`prependPathContext`). The plugin can cache the result per entity in a `CachedValue`.
- CodeSystem hierarchies (`#parent.#child`) and ValueSet concept contexts (`system#code`) come out of the same pass.

**Implemented in M3, and checked against SUSHI** on all 826,123 indented rules of SUSHI-clean corpus files: 100% agree. Matching
SUSHI took its corner cases:

- each rule kind feeds its own path into the context. Caret value rules and paths drop empty segments (`* reference.` is
  `reference`). Insert rules keep their path unsplit. Code caret and code insert rules feed `#code` elements, or `system#code` in
  ValueSets. ValueSet components feed one `system#code`, or reset the context;
- a rule without a path takes the context as is (`  * obeys inv-1`, `  * insert X`);
- an invalid indentation (odd, too deep, or on the first rule) keeps the rule's own path and leaves the context unchanged;
- once a context is used by a rule other than a path rule, or by any rule in an Instance, the soft index `[+]` becomes `[=]` in it;
- in `* a and b MS`, each path in turn updates the context.

Nesting the PSI by indentation was rejected. It would make the tree depend on whitespace, which complicates incremental reparsing,
the formatter, and recovery from bad indentation. SUSHI's importer does not nest either.

### D13: parameterized RuleSet bodies

A RuleSet whose name is followed by `(` is a `param_rule_set_entity`:

- Its parameter list comes from the `ARGS` state (`parameter_list` of `parameter` nodes).
- Each body line is first parsed with the normal rule grammar, and kept typed if it parses **completely**, up to the next rule,
  metadata, declaration or the end of the file (`typed_param_line ::= STAR rule_body? &rule_end`, which builds a `RULE` node).
- Any other line is a `RAW_RULE`: `STAR` followed by any tokens other than `STAR`, metadata and declaration keywords.
- Neither form reports errors, since a placeholder can stand for anything (PLAN.md decision 3).

So `* entry[{name}] only Reference({name})` is an `ONLY_RULE`, while `* entry contains {name} {min}..{max}` is raw. This was planned
as the later upgrade path, and turned out to be cheap: a failed typed attempt rolls back, including its error elements. The body is
lexed normally either way, so it is highlighted.

### D14: names

```bnf
entity_name ::= name_token
private name_token ::= <<asWord (WORD | NUMBER | DATE_TIME | TIME | rule_keywords | flags)>>
```

- **`asWord`** is a small external helper in the parser util class. It accepts any of these tokens and calls
  `builder.remapCurrentToken(WORD)` before consuming it, so the PSI leaf of a name or path is always a `WORD`, whatever the lexer
  guessed.
- **Highlighting**: the lexer-based highlighter still colors `system` as a keyword in `* system = …`. The plugin fixes this with an
  annotator that resets the color of remapped keywords. This is the usual approach for contextual keywords.
- **Paths** use the same token choice (`path_head ::= <<asWord …>>`).

### Values

```bnf
value ::= ratio | quantity | STRING | MULTILINE_STRING | NUMBER | DATE_TIME | TIME
        | reference_value | canonical_value | code_value | KW_TRUE | KW_FALSE | REGEX | name_ref
ratio ::= ratio_part COLON ratio_part { pin=2 }
quantity ::= NUMBER (UNIT | CODE) STRING? | UNIT STRING?    // tried before a bare NUMBER
reference_value ::= reference_parens STRING?                // in values: an optional display
reference_type ::= reference_parens                         // in `only` and add-element types: no display
```

- **Alternatives** are decided by the first one or two tokens.
- **Ratio, then quantity, then number**: a ratio starts like a quantity or a number, and a quantity like a number. Ratios do not
  occur in the corpus, but the spec has them.
- **References** have their targets as separate tokens from `REF_PARENS`, and become `reference_target` nodes (R6). Values and types
  need separate nodes: in `* subject 1..1 Reference(Patient) "The subject"`, the string is the add-element rule's short
  description, not a display. `canonical_value` and `canonical_type` are split the same way, for symmetry.
- **Greedy targets**: like SUSHI's `REFERENCE` token, a target runs up to the last `)` of its word, so `Reference(A))` has the
  target `A)` instead of an extra `)`. Four corpus files rely on this.

---

## 5. Error recovery

### D11: pins and recovery points

| Construct | `pin` | `recoverWhile` stops at |
|---|---|---|
| entity | its declaration keyword | the next declaration keyword |
| metadata | the keyword and `COLON` | `STAR`, any metadata keyword, any declaration keyword |
| rule | `STAR` | `STAR`, any metadata keyword, any declaration keyword |
| junk (text that is neither a rule nor metadata) | — | one error element up to the next `STAR`, metadata or declaration keyword |
| argument list, reference parentheses | the opening `(` | `)`; the lexer also ends these states at a line-start `STAR` |

Consequences:

- **Every line-start `*` begins a rule node**, whatever happened before, so an error never spreads past the end of its rule.
- **Every declaration keyword begins an entity**, so an error never spreads past the end of its entity.
- **Incomplete input gets a tree**: a half-typed rule (`* name 0..`, `* code from`) still produces its rule node, with an error at
  the end. Completion and annotators then have a context to work with.

### Comments and binders

By default, IntelliJ leaves comments between nodes outside of them. Two refinements, **implemented in M5** (`FshBinders`, golden test
`Comments.fsh`):

- **Comment lines directly before an entity** belong to the entity: comments that start their own line, with no blank line between
  them and the declaration. This is a custom left binder, so folding, structure view and "move statement" carry them along. It is
  registered on `entity`, not on the kinds: `entity` collapses into the kind's node, and that drops a hook registered on the kind.
- **A comment on the same line as the end of a rule or a metadata** belongs to it (custom right binder). A comment line between
  rules stays between them.

Tools that need an entity's declaration line use its keyword, not the node start (the bench's `declarationOffset`).

---

## 6. Incremental parsing

### D16

The platform reparses incrementally by default: it re-lexes from the nearest restart point, reparses, and diffs the trees. With dense
restart points (D4, D6), this is cheap for normal files. Two optional optimizations, to adopt only if the bench (M5) shows a need:

- **Entity-level reparse**: entities as `IReparseableElementType` blocks. An edit inside an entity reparses only that entity, if
  the new text still lexes as exactly one entity. Entities are natural blocks, since nothing outside them depends on their content.
  The spike makes this unlikely to be needed: a full parse runs at about 50–250 ms per MB, and the IDE builds no PSI above
  `idea.max.intellisense.filesize` (2.5 MB by default). Only 34 corpus files, all generated terminologies, exceed that limit.
- **Leaf reparse**: strings and comments as `IReparseableLeafElementType`, so typing inside them skips reparsing.

`ParsingTestCase` already calls `ensureCorrectReparse` in its golden tests. The bench adds random-edit reparse checks (Phase 4).

**M5 results**: neither optimization is needed.

- Incremental reparse (`BlockSupportImpl.reparseRange`, then a full dump comparison) gives the same tree as a fresh parse on 2,405
  sampled files, after one random edit each.
- Parsing stays linear on damaged input: the slowest of 92,264 mutated parses took 203 ms, for a 1.6 MB file whose original took
  139 ms.
- Restart points are now line starts rather than every token (D4). That is still dense enough: the editor re-lexes at most a line
  before an edit, or from an unterminated token while one is open.

---

## 7. PSI design

The PSI is the contract with the plugin. It follows the plugin's existing conventions from the `dev-2026` branch:

- an `FshNamedElement` mixin on entities;
- entity type and icon getters;
- structure view and breadcrumbs.

**Implemented in M6** (`handoff/README.md` lists what the plugin gets):

| Piece | Where | What |
|---|---|---|
| `FshNamedElement` | `implements("entity|.*_entity")` | `NavigatablePsiElement`, `PsiNameIdentifierOwner` and `StubBasedPsiElement<FshEntityStub>`, plus `getEntityKind()` (enum `FshEntityKind`), `getEntityType()` (the keyword), and the `Id`, `Parent` and `InstanceOf` values |
| `FshEntityMixin` | `mixin("entity")` | name identifier (`entity_name`), rename (parses `Keyword: newName` and swaps the name node), presentation (name, entity type, icon), and a navigation offset on the name rather than on the comments bound to the entity (D11) |
| `FshFile.getEntities()` | hand-written | the file's entities, read from the stub tree when the file is not parsed |
| `FshReferenceHostMixin` | `mixin(…)` on 13 node types | `ContributedReferenceHost`: references come from the plugin's `psi.referenceContributor`s |
| icons | `FshEntityKind.icon` | `icons/<kind>.svg`, from the plugin's resources (null in the sandbox, which has none) |

**Named in the BNF, not in `methods=[…]`**. The `dev-2026` grammar declared helpers with `methods=[…]` and a `psiImplUtilClass`, which only
the IDE's Grammar-Kit can resolve, not the Gradle task. Mixins and `implements` need no resolution, so command-line and IDE
generation give the same code.

### D15: every checked value has its own node

The format-free principle (R12, fsh-language §5.1) puts all format checks in annotators. For their messages and quick-fixes to target
the right text, every checked value is a node of its own, never just a token inside a bigger node:

| Node | Holds | Checked by annotators for |
|---|---|---|
| `entity_name` | the declared name or id | name or id format, uniqueness |
| `id_metadata` and its `value` | `Id:` value | id format, ≤ 64 characters |
| one `*_metadata` node per keyword (`parent_metadata`, `title_metadata`, …), each with its `value`s | metadata values | the value kind each keyword expects |
| `context_item` in `context_metadata` | one `Context:` item, quoted or not (a glued comma stays in its text) | element paths, extension URLs, FHIRPath |
| `contains_item` with a `slice_name` and an optional `extension_ref` | `contains` items | slice name format |
| `entity_name`, `alias_value` in `alias_entity` | Alias parts | `$` convention, `\|` |
| `argument` in an insert rule's `argument_list` | one argument, with an unescaped value through a PSI util | argument count vs parameters |
| `parameter` in a `param_rule_set_entity`'s `parameter_list` | RuleSet parameter declarations | unused parameters |
| `path` | a path word | path syntax, segments, `.` placement |
| `code_value` | a `CODE` token plus optional display | system resolution |
| `system_ref`, `value_set_ref`, `filter_property`, `filter_operator` | ValueSet component parts | known systems and value sets, filter operators |

### References

These nodes host `PsiReference`s, implemented in the plugin:

- **Text ranges inside words** (D2):
  - path segments and bracket contents;
  - the system part of codes (aliases, CodeSystem names);
  - `$alias` uses anywhere.
- **Whole nodes**:
  - `Parent`, `InstanceOf` and `Source` values;
  - binding value sets;
  - `only` types and reference targets;
  - `obeys` invariants;
  - `insert` RuleSet names;
  - `contains … named` extensions.

### PSI utilities (M3)

Structure inside tokens and across rules comes from utilities in `psi.util`, not from the grammar (D2, D12). They mirror SUSHI's
importer, and the bench checks them against SUSHI on the whole corpus:

| Utility | Reads | Checked against SUSHI |
|---|---|---|
| `FshText.codeParts` | system, version and code of a `CODE` token, with escapes (`\#`) and quoted codes | code parts of 3.5 M value parts: 100% (aliases aside) |
| `FshText.stringValue`, `multilineStringValue` | string values, unescaped and dedented as SUSHI does | displays in the value parts |
| `FshText.pathSegments` | segments of a path, with base and bracket ranges | through the context paths |
| `FshValues.kind` | the syntactic kind of a value (code, quantity, name, …) | 2.66 M assignment and caret values: 1 difference (see fsh-language §1.5) |
| `FshValues.code`, `quantity`, `reference`, `canonicals` | value parts (unit and its system, targets, versions) | value parts: 100% (aliases aside) |
| `FshPaths.contextPaths` | the path of every rule with its indentation context (D12) | 826,123 indented rules: 100% |

Aliases are not resolved by these utilities: the plugin resolves them through references.

### Stubs

Entities are direct children of the file, which suits stub indexing. Each stub holds the kind, name, `Id`, `Parent` and
`InstanceOf`, and serves project-wide lookup: go-to-symbol, reference resolution without parsing every file, and completion of
entity names. The stub element types are hand-written and plugged in through `elementTypeFactory` and `stubClass`.

**Implemented in M6** (`psi.stubs`):

- `elementTypeFactory(".*_entity")=FshStubElementTypes.factory` makes every entity node type an `FshEntityStubElementType`. Its
  `createPsi` builds the generated class of its kind from a stub.
- `stubClass("entity|.*_entity")=FshEntityStub` makes the generated entity classes stub-based. The `FshEntityMixin` reads the name,
  kind and metadata values from the stub when there is one.
- `FshParserDefinition.FILE` is `FshFileStubElementType`, an `IStubFileElementType`. Bump its stub version whenever the stubs or the
  entity grammar change.
- `FshEntityNameIndex` indexes entities by declared name: `find(project, name)` and `allNames(project)`.
- The plugin registers `stubElementTypeHolder` (class `FshTypes`, prefix `fsh.`) and the `stubIndex`.
- `FshPsiApiTest` checks all of this in a full platform fixture, with stub-only lookups through the index.

The classic `IStubElementType` API is used because it exists in build 242 (`sinceBuild`). Calls that 2025.3 deprecates are
avoided: `PsiFileImpl.getGreenStub` and `StubBasedPsiElementBase.getElementType`. So is `IElementType.getDebugName()`, which is internal API:
the plugin verifier flags it. The stub element type keeps its own copy of the type name.

---

## 8. Testing hooks

| Tool | Use |
|---|---|
| `LexerTestCase.doFileTest` | golden token dumps for `corpus/edge-cases/handwritten/` |
| `LexerTestCase.checkCorrectRestart` | restart consistency on the edge cases and corpus samples |
| `LexerTestCase.checkZeroState` | `STAR` and declaration keywords always in state 0 (files without unterminated tokens) |
| `FshEditorRelexTest` | the real `LexerEditorHighlighter` after targeted edits (D4) |
| `FshPsiUtilTest` | code parts, strings, path segments, values, context paths |
| `ParsingTestCase.doTest` | golden PSI dumps; also runs `ensureCorrectReparse` |
| `FshParserTest.testGoldenFilesCoverEveryNodeType` | every node type appears in a golden PSI tree |
| bench (Phase 4, M3, M5) | coverage, `BAD_CHARACTER`, errors, structure, values and paths against SUSHI, timing; random edits against the editor's re-lexing; incremental reparse; mutations and recovery |

---

## 9. Alternatives considered

| Alternative | Why not |
|---|---|
| SUSHI's ANTLR grammar through `antlr4-intellij-adaptor` (the plugin's `parser-antlr` and `dev-2025` branches) | The adaptor's last release is 0.2.0 (2024-12). ANTLR's recovery is generic, with no `pin`/`recoverWhile`, so broken input produces poor trees. There is no generated PSI. SUSHI's lexer conflicts with the IntelliJ lexer contract (skipped comments, tokens that swallow newlines and comments, runaway modes). SUSHI's grammar is a validator, not a lenient editor grammar. |
| A hand-written lexer and parser | Full control, but more code to maintain, no Live Preview, and no generated PSI. Kept as an escape hatch for individual `external` rules. |
| Grammar-Kit's Kotlin syntax-API parser | Not available in build 242 (D1). |
| Fine-grained tokens | See D2. |
| A PSI nested by indentation | See D12. |

---

## 10. Validation spikes

Five decisions rested on behavior that needed confirming before building on them. Spikes ran on 2026-11-20, with:

- the real lexer, `grammar/src/main/grammar/fsh/fsh.flex`, which meets the M0 exit criteria;
- a spike grammar, `fsh.bnf`, covering entities, metadata and most rule kinds;
- tests: `FshLexerEdgeCasesTest`, `FshParserSpikeTest`, and the opt-in `SpikeCorpusTest` (`./gradlew :bench:test -PcorpusSpike=true`).
  In M2 these became `FshParserTest` (with `testData/parser/Rules.fsh`, formerly `SpikeRules.fsh`) and the Phase 4 bench.

| # | Decision | Result | Evidence |
|---|---|---|---|
| 1 | `upper` rule kinds (D9) | **Confirmed**, with two ordering refinements now in D9 | Golden PSI tree (`testData/parser/SpikeRules.fsh`): 10 rule kinds, incomplete rules keep their kind with one local error each, and the platform's reparse sanity check passes. |
| 2 | Look-back `STAR` and restartability (D4, D6) | **Confirmed** | `checkCorrectRestart` from *every* state-0 token of all 902 edge cases (hand-written, spec, SUSHI tests), and `checkZeroState` for `STAR` and declaration keywords: no failure. On the corpus, 472,449 restarts from random state-0 tokens in 47,585 files: no divergence. |
| 3 | Cutting unterminated tokens at the line end (D7) | **Confirmed** | The golden token dumps of the three unterminated cases end the token at the line end, and the rest lexes normally. Coverage (no gap, no `BAD_CHARACTER`, tokens reach EOF): no problem on the edge cases or the corpus. |
| 4 | Keyword remapping (D14) | **Confirmed** | `* system = …` and `* identifier[0].system = …` give `PATH(WORD)`, and errors stay local. Editor highlighting stays lexer-based, so the plugin still needs its annotator (as planned). |
| 5 | Performance | **Linear and fast**; giant files are moot in the IDE | See below. |

**Performance:**

- **Lexer**: 788 M characters (all 47,585 unique repository files) in 6.1 s, about 130 M chars/s, producing 38.2 M tokens.
- **Parser** (spike grammar, building the full PSI): 26.5 s for the whole corpus. For files over 50 KB, the median is 50 ms per MB and
  the maximum 183 ms per MB. Files dense in rules, measured with a full PSI walk:
  - `edqm.fsh` (4.6 MB, 88 k rules): 561 ms
  - 1–2 MB terminologies with 15–80 k rules: 60–320 ms
- **Giant files**: the 17–79 MB Taiwanese CodeSystems are almost entirely **one block comment**. At line 1,882 of the 79 MB
  `CodeSystem_LOINC.fsh`, a `/*` comments out about 1.6 M rules until the end of the file. SUSHI agrees (1,871 rules), and these files
  lex in about 5 ms per MB.
- **IDE limits**: the IDE builds no PSI above `idea.max.intellisense.filesize` (2.5 MB by default), and does not load content above
  `idea.max.content.load.filesize` (20 MB by default). That excludes 34 and 10 corpus files respectively, all generated
  terminologies. The bench raises both limits so that every file can still be measured.

**Other spike findings, now in the decisions above:**

- **D6**: a string glued to a comma (`Context: "Observation.code", Patient`) would otherwise lex as one word. A dedicated rule
  returns the string, then the comma.
- **D9**: tails without a head must be tried before the path head, and metadata keywords stop rule recovery.
- **Rule naming**: rules must avoid names whose getters clash with `PsiElement` methods (`reference`, `context`, `name`, …).

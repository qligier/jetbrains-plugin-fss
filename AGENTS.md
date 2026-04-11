# AGENTS.md - AI Coding Agent Guide

This JetBrains IDE plugin adds FHIR® Shorthand (FSH), SUSHI, and IG Publisher support. Understand these essentials before making changes.

## Architecture Overview

The plugin modularizes support for **three domain-specific languages/file types**:

- **FSH** (`src/main/kotlin/.../fsh/`): FHIR Shorthand language - syntax highlighting via TextMate bundle
- **ig.ini** (`src/main/kotlin/.../igini/`): IG Publisher configuration - full lexer/parser/PSI implementation
- **sushi-config.yaml** (`src/main/kotlin/.../sushiconfig/`): SUSHI tool configuration - YAML annotations + JSON Schema validation

Each module is self-contained with its own file type, language definition, and extension registrations in `plugin.xml`.

## Critical Integration Points

### TextMate Bundle for FSH
- FSH syntax highlighting delegates to a TextMate bundle at `src/main/resources/fsh/fsh.tmbundle`
- Plugin manually registers the bundle via `FshTextMateBundleProvider` (implements `TextMateBundleProvider`)
- Two extensions required: `editorHighlighterProvider` + `lang.syntaxHighlighterFactory` in `plugin.xml` (see comments in plugin.xml:53-55)
- **Pattern**: Custom file types break TextMate bundle association; workaround restores it

### YAML & JSON Plugins (Optional Dependencies)
- sushi-config support loads only if YAML plugin available (config-file="plugin_with_yaml.xml")
- JSON schema validation for sushi-config requires JSON plugin (config-file="plugin_with_json.xml")
- `SushiConfigSchemaProvider` embeds a JSON schema as a resource; tests must grant `VfsRootAccess` (see `SushiConfigInsightTest.kt:19`)

### PSI & Parsing for ig.ini
- Custom INI parser generates PSI tree via ANTLR (grammar likely in `src/main/kotlin/.../igini/language/parser/`)
- `IniParserDefinition` bridges grammar to PSI elements
- `IniLexerAdapter` wraps the lexer
- Annotator walks PSI tree to validate structure (e.g., `[IG]` section must exist with required properties)

## Key Conventions & Patterns

### Specs Objects
- **`*Specs.kt`** objects centralize file metadata: `FILENAME`, section names, required properties
  - `SushiConfigSpecs`: FILENAME = "sushi-config.yaml"; maps FHIR parameters + IG Publisher parameters
  - `IgIniSpecs`: defines `[IG]` section name + "ig" and "template" keys
- Always consult specs before hardcoding strings in validators or completers

### Annotators (Quick Fixes + Inspections)
- Implement `Annotator` interface; annotate PSI elements on `annotate(element, holder)` call
- **`SushiConfigAnnotator`**: Validates sushi-config YAML
  - Detects duplicate keys with case variations (e.g., `releaseLabel` vs `releaselabel`)
  - Warns on version-specific properties (e.g., `copyrightLabel` only in FHIR R5+)
  - Creates quick fixes (e.g., `RemoveValueKeyQuickFix`) to resolve issues
- **`IgIniAnnotator`**: Validates ig.ini structure
  - Enforces `[IG]` section with mandatory `ig` and `template` properties
  - Warns on unsupported sections/properties

### FHIR Version Handling
- `SushiConfigAnnotator` parses `fhirVersion` key from YAML; maps to enum (`R4`, `R4B`, `R5`, `R6`)
- Version comparison enables property validation (e.g., `copyrightLabel` error if FHIR < R5)
- Add new versions to both the version parser map and the enum when FHIR releases new versions

### Testing Pattern
- Use `BasePlatformTestCase` from IntelliJ Platform Test Framework
- Configure test data path in `getTestDataPath()` (e.g., `src/test/testData/sushiconfig/annotation`)
- Use `myFixture.configureByText(filename, content)` to create in-memory files
- Use `myFixture.checkHighlighting(true, true, true)` to assert annotations match expected highlights
- Tests must allow JAR access if validating against embedded resources (see `SushiConfigInsightTest.setUp()`)

## Build & Workflow

### Key Gradle Tasks
```bash
./gradlew check           # Run all tests + code checks (Qodana)
./gradlew verifyPlugin    # Verify plugin compatibility across IDE versions
./gradlew build           # Build plugin JAR
./gradlew publishPlugin   # Publish to JetBrains Marketplace (requires PUBLISH_TOKEN)
./gradlew runIde          # Run plugin in sandbox IDE for manual testing
./gradlew koverReport     # Generate code coverage (Kover)
```

### Build Configuration Notes
- **Target IDE**: IntelliJ IDEA 2025.3 (IU), minimum version 242
- **JDK**: Kotlin jvmToolchain(21); Java source/target 21
- **Bundled plugins**: textmate, json, yaml
- **Pre-release channels**: Plugin version with suffix (e.g., "0.0.7-alpha.1") auto-publishes to custom channel

## Plugin Extension Points

All declared in `plugin.xml`:
- `fileType`: Register new file type (e.g., FSH, ig.ini, sushi-config)
- `annotator`: Register validation logic for a language
- `lang.parserDefinition`: Register custom parser (ig.ini only; FSH/sushi-config use TextMate/YAML plugin)
- `lang.commenter`: Enable line/block comment actions
- `completion.contributor`: Auto-completion suggestions
- `lang.syntaxHighlighterFactory`: Syntax coloring
- `textmate.bundleProvider`: Provide TextMate bundle for syntax highlighting
- `fileIconProvider`: Custom file icons

## Resource Management

- Plugin resources at `src/main/resources/META-INF/` and `src/main/resources/{fsh,sushiconfig}/`
- FSH TextMate bundle is large; embedded in JAR at `fsh/fsh.tmbundle` via Gradle task `prepareSandbox`
- JSON schema for sushi-config embedded as resource (loaded by `SushiConfigSchemaProvider`)
- Live templates for FSH at `src/main/resources/fsh/liveTemplates.xml`

## Debugging Tips

1. **Annotations not appearing?** Check `plugin.xml` extension registrations; ensure language ID matches
2. **TextMate highlighting broken?** Verify `FshTextMateBundleProvider.getBundles()` locates bundle; check `prepareSandbox` task
3. **Parser errors on ig.ini?** Grammar changes require regenerating PSI from ANTLR grammar; run `./gradlew build`
4. **Sushi-config schema validation missing?** Verify YAML plugin is installed; check `SushiConfigSchemaProvider` resource path
5. **Use `LOG.debug()` / `LOG.trace()`** (Kotlin logger) to debug annotator flow; outputs in IDE logs (`Help > Show Log in Explorer`)

## Making Changes

- **New file type?** Create module folder, define Language/FileType, register extensions in `plugin.xml`, implement Annotator
- **New validation rule?** Add to appropriate Annotator; follow existing pattern (create holder.newAnnotation + withFix)
- **New FHIR version?** Update version enum + parser map in `SushiConfigAnnotator`; update `sinceBuild` in `build.gradle.kts` if using new IDE APIs
- **Update dependencies?** Follow DEVELOPMENT.md; run `./gradlew verifyPlugin` + `./gradlew check` after changes


/*
 * Copyright 2026 Quentin Ligier. Use of this source code is governed by the MIT license.
 */

package ch.qligier.jetbrains.plugin.fss.fsh.language.parser

import com.intellij.testFramework.ParsingTestCase

/**
 * Tests for the FSH parser.
 *
 * Each `testExampleN()` method parses `ExampleN.fsh` from the test data directory and verifies
 * the resulting PSI tree matches `ExampleN.txt`.
 *
 * To regenerate expected `.txt` files after grammar changes, delete the old file and re-run the
 * test: `ParsingTestCase` will write the actual tree on the first run (and fail), then pass on
 * the second run once the file exists.
 *
 * @see [Parsing Tests](https://plugins.jetbrains.com/docs/intellij/parsing-test.html)
 */
class FshParserDefinitionTest : ParsingTestCase("", "fsh", FshParserDefinition()) {

    override fun getTestDataPath(): String = "src/test/testData/fsh/parser"

    override fun includeRanges(): Boolean = true

    // ─── Alias ───────────────────────────────────────────────────────────────

    /**
     * A single `Alias` declaration with a URL value.
     * Verifies the ALIAS node and its child tokens (KW_ALIAS, COLON, ALIAS_REF, EQUALS, URL).
     */
    fun testAliasSimple() = doTest(true)

    /**
     * A single `Alias` declaration with an identifier (non-URL) value.
     */
    fun testAliasWithIdentifier() = doTest(true)

    // ─── Profile ─────────────────────────────────────────────────────────────

    /**
     * A `Profile` declaration with `Parent`, `Id`, `Title`, and `Description` metadata,
     * and no rules. Verifies all metadata PSI nodes are parsed correctly.
     */
    fun testProfileMetadata() = doTest(true)

    /**
     * A `Profile` with cardinality, flag, and binding rules.
     */
    fun testProfileWithRules() = doTest(true)

    // ─── Instance ────────────────────────────────────────────────────────────

    /**
     * An `Instance` with `InstanceOf`, `Usage`, and a fixed-value rule.
     */
    fun testInstance() = doTest(true)

    // ─── CodeSystem ──────────────────────────────────────────────────────────

    /**
     * A `CodeSystem` with concept rules (display + definition strings).
     */
    fun testCodeSystem() = doTest(true)

    // ─── ValueSet ────────────────────────────────────────────────────────────

    /**
     * A `ValueSet` that includes codes from a system and filters them.
     */
    fun testValueSet() = doTest(true)

    // ─── Comments ────────────────────────────────────────────────────────────

    /**
     * A file containing only a line comment and a block comment, verifying both
     * comment token types appear as direct children of the file.
     */
    fun testComments() = doTest(true)

    // ─── Invariant ───────────────────────────────────────────────────────────

    /**
     * An `Invariant` with `Description`, `Expression`, `XPath`, and `Severity` metadata.
     */
    fun testInvariant() = doTest(true)

    // ─── Mapping ─────────────────────────────────────────────────────────────

    /**
     * A `Mapping` with source/target metadata and a mapping entity rule.
     */
    fun testMapping() = doTest(true)

    // ─── Multiple entities ───────────────────────────────────────────────────

    /**
     * A file containing an Alias and a Profile to verify that multiple top-level
     * ENTITY nodes are created correctly.
     */
    fun testMultipleEntities() = doTest(true)
}


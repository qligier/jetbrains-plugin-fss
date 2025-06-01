/*
 * Copyright 2025 Quentin Ligier. Use of this source code is governed by the MIT license.
 */

package ch.qligier.jetbrains.plugin.fss.fsh.antlr

import ch.qligier.jetbrains.plugin.fss.fsh.FshLanguage
import com.intellij.testFramework.ParsingTestCase
import org.antlr.intellij.adaptor.lexer.PSIElementTypeFactory
import org.junit.Test

class FshParserAdapterTest : ParsingTestCase("", "fsh", true, FshParserDefinition()) {

    init {
        // Load all IElementTypes for FSH
        PSIElementTypeFactory.defineLanguageIElementTypes(
            FshLanguage,
            FSHParser.tokenNames,
            FSHParser.ruleNames
        )
    }

    @Test
    fun testTest1() {
        doTest(true)
    }

    override fun getTestDataPath(): String = "src/test/resources/fsh/antlr/parser"
    override fun includeRanges(): Boolean = true
}

/*
 * Copyright 2026 Quentin Ligier. Use of this source code is governed by the MIT license.
 */

package ch.qligier.jetbrains.plugin.fss.fsh.structure

import com.intellij.codeInsight.daemon.impl.DaemonCodeAnalyzerImpl
import com.intellij.testFramework.fixtures.BasePlatformTestCase

class FshLineMarkerProviderTest : BasePlatformTestCase() {
    fun testOneMarkerPerEntityOnItsDeclarationLine() {
        val text =
            """
            // External Code Systems
            Alias: ${'$'}loinc = http://loinc.org
            Alias: ${'$'}sct = http://snomed.info/sct

            /* Block comment */
            // Line comment
            Profile: P
            * status MS // Trailing comment
            """.trimIndent() + "\n"
        myFixture.configureByText("test.fsh", text)
        myFixture.doHighlighting()

        val document = myFixture.editor.document
        val lines =
            DaemonCodeAnalyzerImpl
                .getLineMarkers(document, project)
                .map { document.getLineNumber(it.startOffset) }
                .sorted()
        assertEquals(listOf(1, 2, 6), lines)
    }
}

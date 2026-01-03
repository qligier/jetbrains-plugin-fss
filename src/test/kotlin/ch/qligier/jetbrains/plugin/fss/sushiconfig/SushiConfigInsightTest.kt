/*
 * Copyright 2025 Quentin Ligier. Use of this source code is governed by the MIT license.
 */

package ch.qligier.jetbrains.plugin.fss.sushiconfig

import com.intellij.testFramework.fixtures.BasePlatformTestCase
import java.io.File

class SushiConfigInsightTest : BasePlatformTestCase() {
    override fun getTestDataPath(): String = "src/test/testData/sushiconfig/annotation"

    fun testExample1() {
        loadSushiConfigFile("Example1.yaml")
        myFixture.checkHighlighting(true, true, true)
    }

    private fun loadSushiConfigFile(fileName: String) {
        val file = File(getTestDataPath(), fileName)
        myFixture.configureByText(SushiConfigSpecs.FILENAME, file.readText())
    }
}

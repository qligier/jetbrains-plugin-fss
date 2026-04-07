/*
 * Copyright 2026 Quentin Ligier. Use of this source code is governed by the MIT license.
 */

package ch.qligier.jetbrains.plugin.fss.sushiconfig

import com.intellij.openapi.application.PathManager
import com.intellij.openapi.vfs.newvfs.impl.VfsRootAccess
import com.intellij.testFramework.fixtures.BasePlatformTestCase
import java.io.File

class SushiConfigInsightTest : BasePlatformTestCase() {
    override fun getTestDataPath(): String = "src/test/testData/sushiconfig/annotation"

    override fun setUp() {
        super.setUp()
        // Allow access to the JAR file itself.
        // This is necessary for the test to access the embedded JSON schema resource.
        PathManager.getJarPathForClass(SushiConfigSchemaProvider::class.java)?.let { jarOrClassesPath ->
            VfsRootAccess.allowRootAccess(testRootDisposable, jarOrClassesPath)
        }
    }

    fun testExample1() {
        loadSushiConfigFile("Example1.yaml")
        myFixture.checkHighlighting(true, true, true)
    }

    private fun loadSushiConfigFile(fileName: String) {
        val file = File(getTestDataPath(), fileName)
        myFixture.configureByText(SushiConfigSpecs.FILENAME, file.readText())
    }
}

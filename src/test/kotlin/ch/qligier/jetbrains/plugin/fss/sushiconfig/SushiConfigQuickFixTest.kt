/*
 * Copyright 2026 Quentin Ligier. Use of this source code is governed by the MIT license.
 */

package ch.qligier.jetbrains.plugin.fss.sushiconfig

import com.intellij.openapi.application.PathManager
import com.intellij.openapi.vfs.newvfs.impl.VfsRootAccess
import com.intellij.testFramework.fixtures.BasePlatformTestCase

/**
 * Applies the sushi-config quick fixes, checking both their preview and their result.
 */
class SushiConfigQuickFixTest : BasePlatformTestCase() {
    override fun setUp() {
        super.setUp()
        myFixture.enableInspections(
            SushiConfigDuplicatePropertyInspection(),
            SushiConfigUndefinedInFhirVersionInspection(),
            SushiConfigDeprecatedInFhirVersionInspection(),
            SushiConfigMissingRecommendedPropertyInspection(),
        )
        PathManager.getJarPathForClass(SushiConfigSchemaProvider::class.java)?.let { jarOrClassesPath ->
            VfsRootAccess.allowRootAccess(testRootDisposable, jarOrClassesPath)
        }
    }

    fun testRemoveDuplicateProperty() {
        doTest(
            """
            fhirVersion: 4.0.1
            copyrightYear: 2024+
            copyrightyear: 2025+
            <caret>releaseLabel: ci-build
            releaselabel: draft
            """,
            "Remove property 'releaseLabel'",
            """
            fhirVersion: 4.0.1
            copyrightYear: 2024+
            copyrightyear: 2025+
            releaselabel: draft
            """,
        )
    }

    fun testRemovePropertyUndefinedInFhirVersion() {
        doTest(
            """
            fhirVersion: 4.0.1
            copyrightYear: 2024+
            <caret>copyrightLabel: Example
            releaseLabel: ci-build
            """,
            "Remove property 'copyrightLabel'",
            """
            fhirVersion: 4.0.1
            copyrightYear: 2024+
            releaseLabel: ci-build
            """,
        )
    }

    fun testRemoveDeprecatedProperty() {
        doTest(
            """
            fhirVersion: 5.0.0
            copyrightYear: 2024+
            releaseLabel: ci-build
            <caret>jurisdiction: urn:iso:std:iso:3166#CH
            """,
            "Remove property 'jurisdiction'",
            """
            fhirVersion: 5.0.0
            copyrightYear: 2024+
            releaseLabel: ci-build
            """,
        )
    }

    fun testAddMissingProperty() {
        doTest(
            """
            fhirVersion: 4.0.1
            copyrightYear: 2024+<caret>
            """,
            "Add property 'releaseLabel'",
            """
            fhirVersion: 4.0.1
            copyrightYear: 2024+
            releaseLabel: ci-build
            """,
        )
    }

    private fun doTest(
        before: String,
        fixName: String,
        after: String,
    ) {
        myFixture.configureByText(SushiConfigSpecs.FILENAME, before.trimIndent() + "\n")
        val fix = myFixture.findSingleIntention(fixName)
        myFixture.checkPreviewAndLaunchAction(fix)
        myFixture.checkResult(after.trimIndent() + "\n")
    }
}

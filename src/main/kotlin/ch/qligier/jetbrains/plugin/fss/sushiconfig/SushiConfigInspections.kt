/*
 * Copyright 2026 Quentin Ligier. Use of this source code is governed by the MIT license.
 */

package ch.qligier.jetbrains.plugin.fss.sushiconfig

import ch.qligier.jetbrains.plugin.fss.sushiconfig.SushiConfigSpecs.KEY_COPYRIGHT_YEAR
import ch.qligier.jetbrains.plugin.fss.sushiconfig.SushiConfigSpecs.KEY_COPYRIGHT_YEAR_LOWERCASE
import ch.qligier.jetbrains.plugin.fss.sushiconfig.SushiConfigSpecs.KEY_DEPENDENCIES
import ch.qligier.jetbrains.plugin.fss.sushiconfig.SushiConfigSpecs.KEY_RELEASE_LABEL
import ch.qligier.jetbrains.plugin.fss.sushiconfig.SushiConfigSpecs.KEY_RELEASE_LABEL_LOWERCASE
import com.intellij.codeInspection.InspectionManager
import com.intellij.codeInspection.LocalInspectionTool
import com.intellij.codeInspection.ProblemDescriptor
import com.intellij.codeInspection.ProblemsHolder
import com.intellij.openapi.project.DumbAware
import com.intellij.psi.PsiFile
import com.intellij.psi.util.lastLeaf
import org.jetbrains.yaml.psi.YAMLFile
import org.jetbrains.yaml.psi.YAMLMapping
import org.jetbrains.yaml.psi.YAMLScalar
import org.jetbrains.yaml.psi.YAMLSequence
import java.time.Year

/**
 * Base class of the 'sushi-config.yaml' inspections. Their severity is configured in plugin_with_yaml.xml and can be
 * changed by the user.
 * @see [Code Inspections](https://plugins.jetbrains.com/docs/intellij/code-inspections.html)
 * @see [SUSHI Configuration](https://fshschool.org/docs/sushi/configuration/)
 */
internal abstract class SushiConfigInspectionBase :
    LocalInspectionTool(),
    DumbAware {
    final override fun checkFile(
        file: PsiFile,
        manager: InspectionManager,
        isOnTheFly: Boolean,
    ): Array<ProblemDescriptor>? {
        if (file !is YAMLFile) return null
        // YAMLFile.getFileType() always returns YAML, so check the file type of the virtual file
        if (file.virtualFile?.fileType != SushiConfigFileType.INSTANCE) return null

        val holder = ProblemsHolder(manager, file, isOnTheFly)
        file.documents.forEach { document ->
            (document.topLevelValue as? YAMLMapping)?.let { check(it, holder) }
        }
        return holder.resultsArray
    }

    protected abstract fun check(
        mapping: YAMLMapping,
        holder: ProblemsHolder,
    )
}

/**
 * Reports a property that is set under both of its spellings, e.g. 'releaselabel' and 'releaseLabel'.
 */
internal class SushiConfigDuplicatePropertyInspection : SushiConfigInspectionBase() {
    override fun check(
        mapping: YAMLMapping,
        holder: ProblemsHolder,
    ) {
        checkPair(mapping, holder, KEY_COPYRIGHT_YEAR_LOWERCASE, KEY_COPYRIGHT_YEAR)
        checkPair(mapping, holder, KEY_RELEASE_LABEL_LOWERCASE, KEY_RELEASE_LABEL)
    }

    private fun checkPair(
        mapping: YAMLMapping,
        holder: ProblemsHolder,
        key1: String,
        key2: String,
    ) {
        val keyValue1 = mapping.getKeyValueByKey(key1) ?: return
        val keyValue2 = mapping.getKeyValueByKey(key2) ?: return
        val message = "Both '$key1' and '$key2' are used, choose only one."
        val quickFix = RemoveValueKeyQuickFix(mapping, key2).asQuickFix()
        holder.registerProblem(keyValue1, message, quickFix)
        holder.registerProblem(keyValue2, message, quickFix)
    }
}

/**
 * Reports a property that the declared FHIR version doesn't define yet.
 */
internal class SushiConfigUndefinedInFhirVersionInspection : SushiConfigInspectionBase() {
    override fun check(
        mapping: YAMLMapping,
        holder: ProblemsHolder,
    ) {
        val fhirVersion = FhirVersion.of(mapping) ?: return
        checkProperty(mapping, holder, "copyrightLabel", fhirVersion, FhirVersion.R5)
    }

    private fun checkProperty(
        mapping: YAMLMapping,
        holder: ProblemsHolder,
        key: String,
        sushiFhirVersion: FhirVersion,
        addedInVersion: FhirVersion,
    ) {
        if (sushiFhirVersion >= addedInVersion) return
        val value = mapping.getKeyValueByKey(key) ?: return
        holder.registerProblem(
            value,
            "The property '$key' was added in FHIR $addedInVersion.",
            RemoveValueKeyQuickFix(mapping, key).asQuickFix(),
        )
    }
}

/**
 * Reports a property that is deprecated in the declared FHIR version.
 */
internal class SushiConfigDeprecatedInFhirVersionInspection : SushiConfigInspectionBase() {
    override fun check(
        mapping: YAMLMapping,
        holder: ProblemsHolder,
    ) {
        val fhirVersion = FhirVersion.of(mapping) ?: return
        checkProperty(mapping, holder, "jurisdiction", fhirVersion, FhirVersion.R5)
    }

    private fun checkProperty(
        mapping: YAMLMapping,
        holder: ProblemsHolder,
        key: String,
        sushiFhirVersion: FhirVersion,
        deprecatedInVersion: FhirVersion,
    ) {
        if (sushiFhirVersion < deprecatedInVersion) return
        val value = mapping.getKeyValueByKey(key) ?: return
        holder.registerProblem(
            value,
            "The property '$key' is deprecated in FHIR $deprecatedInVersion.",
            RemoveValueKeyQuickFix(mapping, key).asQuickFix(),
        )
    }
}

/**
 * Reports the deprecated 'hl7.fhir.extensions.*' dependencies. As of SUSHI v3.19.0, they are automatically replaced
 * by the new 'hl7.fhir.uv.xver-*.*' dependencies.
 */
internal class SushiConfigDeprecatedXverDependencyInspection : SushiConfigInspectionBase() {
    override fun check(
        mapping: YAMLMapping,
        holder: ProblemsHolder,
    ) {
        val sequence = mapping.getKeyValueByKey(KEY_DEPENDENCIES)?.value as? YAMLSequence ?: return
        sequence.items
            .filter { it.text.contains("hl7.fhir.extensions.r") }
            .forEach { item ->
                holder.registerProblem(
                    item,
                    "The 'hl7.fhir.extensions.*' dependencies are deprecated and will " +
                        "be automatically replaced by the new 'hl7.fhir.uv.xver-*.*' dependencies.",
                )
            }
    }
}

/**
 * Reports a missing 'copyrightYear' or 'releaseLabel'. As of SUSHI v3.20.0, they are optional, but SUSHI warns when
 * they are absent (https://github.com/FHIR/sushi/pull/1626).
 */
internal class SushiConfigMissingRecommendedPropertyInspection : SushiConfigInspectionBase() {
    override fun check(
        mapping: YAMLMapping,
        holder: ProblemsHolder,
    ) {
        val keys = mapping.keyValues.map { it.keyText }.toSet()
        if (KEY_COPYRIGHT_YEAR !in keys && KEY_COPYRIGHT_YEAR_LOWERCASE !in keys) {
            register(mapping, holder, KEY_COPYRIGHT_YEAR, "${Year.now().value}+")
        }
        if (KEY_RELEASE_LABEL !in keys && KEY_RELEASE_LABEL_LOWERCASE !in keys) {
            register(mapping, holder, KEY_RELEASE_LABEL, "ci-build")
        }
    }

    private fun register(
        mapping: YAMLMapping,
        holder: ProblemsHolder,
        key: String,
        defaultValueForQuickFix: String,
    ) {
        holder.registerProblem(
            mapping.lastLeaf(),
            "The property '$key' should be set in the configuration file.",
            AddValueKeyQuickFix(mapping, key, defaultValueForQuickFix).asQuickFix(),
        )
    }
}

internal enum class FhirVersion {
    R4,
    R4B,
    R5,
    R6,
    ;

    companion object {
        /**
         * Returns the FHIR version declared in the configuration, or null if it is missing or unknown.
         * @see [Publication (Version) History](https://hl7.org/fhir/directory.html)
         */
        fun of(mapping: YAMLMapping): FhirVersion? {
            val value = mapping.getKeyValueByKey("fhirVersion")
            return when ((value?.value as? YAMLScalar)?.textValue) {
                "3.2.0", "3.3.0", "3.5.0", "3.5a.0", "4.0.1" -> R4

                "4.1.0", "4.3.0-snapshot1", "4.3.0" -> R4B

                "4.2.0", "4.4.0", "4.5.0", "4.6.0", "5.0.0-snapshot1", "5.0.0-ballot", "5.0.0-snapshot3",
                "5.0.0-draft-final", "5.0.0",
                -> R5

                "6.0.0-ballot1", "6.0.0-ballot2", "6.0.0-ballot3", "6.0.0-ballot4", "6.0.0-ballot5", "6.0.0-snapshot1" -> R6

                else -> null
            }
        }
    }
}

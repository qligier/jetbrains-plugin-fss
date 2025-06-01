/*
 * Copyright 2025 Quentin Ligier. Use of this source code is governed by the MIT license.
 */

package ch.qligier.jetbrains.plugin.fss.sushi_config

import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.psi.PsiElement
import org.jetbrains.yaml.psi.YAMLFile
import org.jetbrains.yaml.psi.YAMLMapping
import org.jetbrains.yaml.psi.YAMLScalar

/**
 * An annotator for the 'sushi-config.yaml' file.
 * @see [Annotator](https://plugins.jetbrains.com/docs/intellij/annotator.html)
 * @see [SUSHI Configuration](https://fshschool.org/docs/sushi/configuration/)
 */
class SushiConfigAnnotator : Annotator {
    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        if (element !is YAMLFile) {
            return
        }

        element.documents.forEach { document ->
            (document.topLevelValue as? YAMLMapping)?.let { annotate(it, holder) }
        }
    }

    private fun annotate(mapping: YAMLMapping, holder: AnnotationHolder) {
        val keys = mapping.keyValues.map { it.keyText }.toSet()

        warnDuplicateKey(holder, mapping, keys, "copyrightyear", "copyrightYear")
        warnDuplicateKey(holder, mapping, keys, "releaselabel", "releaseLabel")

        // If we can extract the declared FHIR version, we can run additional checks
        val fhirVersion = getFhirVersion(mapping)
        if (fhirVersion != null) {
            warnPropertyAddedLater(holder, mapping, "copyrightLabel", fhirVersion, FhirVersion.R5)
            warnDeprecatedProperty(holder, mapping, "jurisdiction", fhirVersion, FhirVersion.R5)
        }
    }

    private fun warnDuplicateKey(
        holder: AnnotationHolder,
        mapping: YAMLMapping,
        keys: Set<String>,
        key1: String,
        key2: String
    ) {
        if (key1 !in keys || key2 !in keys) {
            return
        }
        holder.newAnnotation(
            com.intellij.lang.annotation.HighlightSeverity.WARNING,
            "Both '$key1' and '$key2' are defined. Use only one."
        )
            .range(mapping.getKeyValueByKey(key1)!!)
            .create()
    }

    private fun warnPropertyAddedLater(
        holder: AnnotationHolder,
        mapping: YAMLMapping,
        key: String,
        sushiFhirVersion: FhirVersion,
        addedInVersion: FhirVersion
    ) {
        if (sushiFhirVersion >= addedInVersion) {
            return
        }
        val value = mapping.getKeyValueByKey(key)
        if (value == null) {
            return
        }
        holder.newAnnotation(
            com.intellij.lang.annotation.HighlightSeverity.ERROR,
            "The property '$key' was added in FHIR ${addedInVersion}."
        )
            .range(value)
            .create()
    }

    private fun warnDeprecatedProperty(
        holder: AnnotationHolder,
        mapping: YAMLMapping,
        key: String,
        sushiFhirVersion: FhirVersion,
        deprecatedInVersion: FhirVersion
    ) {
        if (sushiFhirVersion < deprecatedInVersion) {
            return
        }
        val value = mapping.getKeyValueByKey(key)
        if (value == null) {
            return
        }
        holder.newAnnotation(
            com.intellij.lang.annotation.HighlightSeverity.WARNING,
            "The property '$key' is deprecated in FHIR ${deprecatedInVersion}."
        )
            .range(value)
            .create()
    }

    private fun getFhirVersion(mapping: YAMLMapping): FhirVersion? {
        val value = mapping.getKeyValueByKey("fhirVersion")
        val versionTest = (value?.value as? YAMLScalar)?.text
        return when (versionTest) {
            "3.2.0", "3.3.0", "3.5.0", "3.5a.0", "4.0.1" -> FhirVersion.R4
            "4.1.0", "4.3.0-snapshot1", "4.3.0" -> FhirVersion.R4B
            "4.2.0", "4.4.0", "4.5.0", "4.6.0", "5.0.0-snapshot1", "5.0.0-ballot", "5.0.0-snapshot3",
            "5.0.0-draft-final", "5.0.0" -> FhirVersion.R5

            "6.0.0-ballot1", "6.0.0-ballot2", "6.0.0-ballot3" -> FhirVersion.R6
            else -> null
        }
    }

    private enum class FhirVersion(private val version: Double) : Comparable<FhirVersion> {
        R4(4.0),
        R4B(4.1),
        R5(5.0),
        R6(6.0);
    }
}



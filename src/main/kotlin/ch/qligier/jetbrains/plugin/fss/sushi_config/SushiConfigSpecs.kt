/*
 * Copyright 2025 Quentin Ligier. Use of this source code is governed by the MIT license.
 */

package ch.qligier.jetbrains.plugin.fss.sushi_config

object SushiConfigSpecs {

    const val FILENAME = "sushi-config.yaml"

    // Warning: unknown key in parameters

    // CodeSystem http://hl7.org/fhir/guide-parameter-code
    // https://build.fhir.org/codesystem-guide-parameter-code.html
    val fhirParameters = mapOf<String, String>(
        "apply" to "If the value of this string 0..* parameter is one of the metadata fields then all conformance resources will have any specified [Resource].[field] overwritten with the ImplementationGuide.[field], where field is one of: version, date, status, publisher, contact, copyright, experimental, jurisdiction, useContext.",
        "path-resource" to "The value of this string 0..* parameter is a subfolder of the build context's location that is to be scanned to load resources. Scope is (if present) a particular resource type.",
        "path-page" to "The value of this string 0..1 parameter is a subfolder of the build context's location that contains files that are part of the html content processed by the builder.",
        "path-tx-cache" to "The value of this string 0..1 parameter is a subfolder of the build context's location that is used as the terminology cache. If this is not present, the terminology cache is on the local system, not under version control.",
        "expansion-parameter" to "The value of this string 0..* parameter is a parameter (name=value) when expanding value sets for this implementation guide. This is particularly used to specify the versions of published terminologies such as SNOMED CT.",
        "rule-broken-links" to "The value of this string 0..1 parameter is either \"warning\" or \"error\" (default = \"error\"). If the value is \"warning\" then IG build tools allow the IG to be considered successfully build even when there is no internal broken links.",
        "generate-xml" to "The value of this boolean 0..1 parameter specifies whether the IG publisher creates examples in XML format. If not present, the Publication Tool decides whether to generate XML.",
        "generate-json" to "The value of this boolean 0..1 parameter specifies whether the IG publisher creates examples in JSON format. If not present, the Publication Tool decides whether to generate JSON.",
        "generate-turtle" to "The value of this boolean 0..1 parameter specifies whether the IG publisher creates examples in Turtle format. If not present, the Publication Tool decides whether to generate Turtle.",
        "html-template" to "The value of this string singleton parameter is the name of the file to use as the builder template for each generated page (see templating).",
    )

    // CodeSystem: IG Parameter Codes
    // https://build.fhir.org/ig/FHIR/fhir-tools-ig/branches/master/CodeSystem-ig-parameters.html
    val igPublisherParameters = mapOf<String, String>(
        "logging" to "",
        "generate" to "",
        "no-narrative" to "",
        "no-validate" to "",
        "no-check-usage" to "",
        "path-binary" to "",
        "path-factory" to "",
        "autoload-resources" to "",
        "codesystem-property" to "",
        "path-pages" to "",
        "path-data" to "",
        "path-other" to "",
        "path-qa" to "",
        "path-liquid" to "",
        "path-temp" to "",
        "path-output" to "",
        "path-history" to "",
        "path-expansion-params" to "",
        "path-suppressed-warnings" to "",
        "path-test" to "",
    )
}

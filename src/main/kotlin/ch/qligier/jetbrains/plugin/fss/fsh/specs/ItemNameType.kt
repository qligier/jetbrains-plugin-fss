// Copyright 2022 Quentin Ligier. Use of this source code is governed by the MIT license.
package ch.qligier.jetbrains.plugin.fss.fsh.specs

/**
 * The type of item names, as per [Keyword Statements](https://build.fhir.org/ig/HL7/fhir-shorthand/reference.html#keyword-statements)
 */
enum class ItemNameType {
    NAME,
    ID,
    EXPRESSION
}

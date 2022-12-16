// Copyright 2022 Quentin Ligier. Use of this source code is governed by the MIT license.

package ch.qligier.jetbrains.plugin.fhir.fsh.specification;

/**
 * The type of item names, as per <a
 * href="https://build.fhir.org/ig/HL7/fhir-shorthand/reference.html#keyword-statements">Keyword Statements</a>
 *
 * @author Quentin Ligier
 **/
public enum ItemNameType {
    NAME,
    ID,
    EXPRESSION
}

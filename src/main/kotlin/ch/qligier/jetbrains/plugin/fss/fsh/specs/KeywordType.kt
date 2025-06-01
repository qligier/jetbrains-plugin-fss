// Copyright 2022 Quentin Ligier. Use of this source code is governed by the MIT license.
package ch.qligier.jetbrains.plugin.fss.fsh.specs

/**
 * The types of FSH keyword.
 */
enum class KeywordType(val typeName: String) {
    ID("Id"),
    DESCRIPTION("Description"),
    TITLE("Title"),
    PARENT("Parent"),
    INSTANCE_OF("InstanceOf"),
    USAGE("Usage"),
    SOURCE("Source"),
    TARGET("Target"),
    SEVERITY("Severity"),
    XPATH("Xpath"),
    EXPRESSION("Expression");
    // Trial Use: Context
    // Trial Use: Characteristics
}

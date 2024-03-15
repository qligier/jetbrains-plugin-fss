// Copyright 2022 Quentin Ligier. Use of this source code is governed by the MIT license.

package ch.qligier.jetbrains.plugin.fhir.fsh.specification;

/**
 * The types of FSH keyword.
 *
 * @author Quentin Ligier
 **/
public enum KeywordType {

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

    private final String name;

    KeywordType(final String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}

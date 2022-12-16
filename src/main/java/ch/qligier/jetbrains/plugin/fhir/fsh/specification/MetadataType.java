// Copyright 2022 Quentin Ligier. Use of this source code is governed by the MIT license.

package ch.qligier.jetbrains.plugin.fhir.fsh.specification;

/**
 * The types of FSH metadata.
 *
 * @author Quentin Ligier
 **/
public enum MetadataType {

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

    private final String name;

    MetadataType(final String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}

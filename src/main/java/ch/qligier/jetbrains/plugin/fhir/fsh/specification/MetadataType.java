// Copyright 2022 Quentin Ligier. Use of this source code is governed by the MIT license.

package ch.qligier.jetbrains.plugin.fhir.fsh.specification;

/**
 * The types of FSH metadata.
 *
 * @author Quentin Ligier
 **/
public enum MetadataType {

    ID("id"),
    DESCRIPTION("description"),
    TITLE("title"),
    PARENT("parent"),
    INSTANCE_OF("instance of"),
    USAGE("usage"),
    SOURCE("source"),
    TARGET("target"),
    SEVERITY("severity"),
    XPATH("xpath"),
    EXPRESSION("expression");

    private final String name;

    MetadataType(final String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}

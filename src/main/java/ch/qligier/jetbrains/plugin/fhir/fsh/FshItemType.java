// Copyright 2022 Quentin Ligier. Use of this source code is governed by the MIT license.

package ch.qligier.jetbrains.plugin.fhir.fsh;

import ch.qligier.jetbrains.plugin.fhir.Icons;

import javax.swing.*;

/**
 * The types of FSH items.
 *
 * @author Quentin Ligier
 **/
public enum FshItemType {

    ALIAS("Alias", Icons.ALIAS),
    PROFILE("Profile", Icons.PROFILE),
    EXTENSION("Extension", Icons.EXTENSION),
    INVARIANT("Invariant", Icons.INVARIANT),
    INSTANCE("Instance", Icons.INSTANCE),
    VALUESET("ValueSet", Icons.VALUESET),
    CODESYSTEM("CodeSystem", Icons.CODESYSTEM),
    RULESET("RuleSet", Icons.RULESET),
    MAPPING("Mapping", Icons.MAPPING),
    LOGICAL("Logical", Icons.LOGICAL),
    RESOURCE("Resource", Icons.RESOURCE);

    private final String name;

    private final Icon icon;

    FshItemType(final String name,
                final Icon icon) {
        this.name = name;
        this.icon = icon;
    }

    public String getName() {
        return this.name;
    }

    public Icon getIcon() {
        return this.icon;
    }
}

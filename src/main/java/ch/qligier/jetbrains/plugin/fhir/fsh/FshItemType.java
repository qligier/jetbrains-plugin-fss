// Copyright 2022 Quentin Ligier. Use of this source code is governed by the MIT license.

package ch.qligier.jetbrains.plugin.fhir.fsh;

import ch.qligier.jetbrains.plugin.fhir.Icons;
import com.intellij.icons.AllIcons;

import javax.swing.*;

/**
 * The types of FSH items.
 *
 * @author Quentin Ligier
 **/
public enum FshItemType {

    ALIAS("Alias", AllIcons.Nodes.Gvariable),
    PROFILE("Profile", AllIcons.Nodes.Property),
    EXTENSION("Extension", AllIcons.Nodes.Enum),
    INVARIANT("Invariant", AllIcons.Nodes.Locked),
    INSTANCE("Instance", AllIcons.Nodes.Class),
    VALUESET("ValueSet", Icons.VALUESET),
    CODESYSTEM("CodeSystem", AllIcons.Nodes.Controller),
    RULESET("RuleSet", AllIcons.Nodes.Related),
    MAPPING("Mapping", AllIcons.Nodes.Artifact),
    LOGICAL("Logical", AllIcons.Nodes.Method),
    RESOURCE("Resource", AllIcons.Nodes.ResourceBundle);

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

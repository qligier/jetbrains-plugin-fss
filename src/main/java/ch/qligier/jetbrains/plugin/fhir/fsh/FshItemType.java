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

    ALIAS("Alias", Icons.ALIAS, FshNameType.EXPRESSION, FshMetadataPolicy.NONE),
    CODESYSTEM("CodeSystem", Icons.CODESYSTEM, FshNameType.NAME, FshMetadataPolicy.SSS),
    EXTENSION("Extension", Icons.EXTENSION, FshNameType.NAME, FshMetadataPolicy.SSSO),
    INSTANCE("Instance", Icons.INSTANCE, FshNameType.ID, FshMetadataPolicy.SSRO),
    INVARIANT("Invariant", Icons.INVARIANT, FshNameType.ID, FshMetadataPolicy.RROO),
    LOGICAL("Logical", Icons.LOGICAL, FshNameType.NAME, FshMetadataPolicy.SSSO),
    MAPPING("Mapping", Icons.MAPPING, FshNameType.ID, FshMetadataPolicy.SSSRR),
    PROFILE("Profile", Icons.PROFILE, FshNameType.NAME, FshMetadataPolicy.SSSR),
    RESOURCE("Resource", Icons.RESOURCE, FshNameType.NAME, FshMetadataPolicy.SSSO),
    RULESET("RuleSet", Icons.RULESET, FshNameType.NAME, FshMetadataPolicy.NONE),
    VALUESET("ValueSet", Icons.VALUESET, FshNameType.NAME, FshMetadataPolicy.SSS);

    private final String name;

    private final Icon icon;

    private final FshNameType nameType;

    private final FshMetadataPolicy metadataPolicy;

    FshItemType(final String name,
                final Icon icon,
                final FshNameType nameType,
                final FshMetadataPolicy metadataPolicy) {
        this.name = name;
        this.icon = icon;
        this.nameType = nameType;
        this.metadataPolicy = metadataPolicy;
    }

    public String getName() {
        return this.name;
    }

    public Icon getIcon() {
        return this.icon;
    }

    public FshNameType getNameType() {
        return this.nameType;
    }

    public FshMetadataPolicy getMetadataPolicy() {
        return this.metadataPolicy;
    }
}

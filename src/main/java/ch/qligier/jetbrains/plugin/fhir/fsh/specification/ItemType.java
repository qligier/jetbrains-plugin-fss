// Copyright 2022 Quentin Ligier. Use of this source code is governed by the MIT license.

package ch.qligier.jetbrains.plugin.fhir.fsh.specification;

import ch.qligier.jetbrains.plugin.fhir.common.Icons;

import javax.swing.*;

/**
 * The types of FSH items.
 *
 * @author Quentin Ligier
 **/
public enum ItemType {

    ALIAS("Alias", Icons.ALIAS, ItemNameType.EXPRESSION, MetadataPolicy.NONE),
    CODESYSTEM("CodeSystem", Icons.CODESYSTEM, ItemNameType.NAME, MetadataPolicy.SSS),
    EXTENSION("Extension", Icons.EXTENSION, ItemNameType.NAME, MetadataPolicy.SSSO),
    INSTANCE("Instance", Icons.INSTANCE, ItemNameType.ID, MetadataPolicy.SSRO),
    INVARIANT("Invariant", Icons.INVARIANT, ItemNameType.ID, MetadataPolicy.RROO),
    LOGICAL("Logical", Icons.LOGICAL, ItemNameType.NAME, MetadataPolicy.SSSO),
    MAPPING("Mapping", Icons.MAPPING, ItemNameType.ID, MetadataPolicy.SSSRR),
    PROFILE("Profile", Icons.PROFILE, ItemNameType.NAME, MetadataPolicy.SSSR),
    RESOURCE("Resource", Icons.RESOURCE, ItemNameType.NAME, MetadataPolicy.SSSO),
    RULESET("RuleSet", Icons.RULESET, ItemNameType.NAME, MetadataPolicy.NONE),
    VALUESET("ValueSet", Icons.VALUESET, ItemNameType.NAME, MetadataPolicy.SSS);

    private final String name;

    private final Icon icon;

    private final ItemNameType nameType;

    private final MetadataPolicy metadataPolicy;

    ItemType(final String name,
             final Icon icon,
             final ItemNameType nameType,
             final MetadataPolicy metadataPolicy) {
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

    public ItemNameType getNameType() {
        return this.nameType;
    }

    public MetadataPolicy getMetadataPolicy() {
        return this.metadataPolicy;
    }
}

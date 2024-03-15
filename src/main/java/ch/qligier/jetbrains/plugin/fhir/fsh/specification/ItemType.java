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

    ALIAS("Alias", Icons.ALIAS, ItemNameType.EXPRESSION, KeywordPolicy.NONE),
    CODESYSTEM("CodeSystem", Icons.CODESYSTEM, ItemNameType.NAME, KeywordPolicy.SSS),
    EXTENSION("Extension", Icons.EXTENSION, ItemNameType.NAME, KeywordPolicy.SSSO),
    INSTANCE("Instance", Icons.INSTANCE, ItemNameType.ID, KeywordPolicy.SSRO),
    INVARIANT("Invariant", Icons.INVARIANT, ItemNameType.ID, KeywordPolicy.RROO),
    LOGICAL("Logical", Icons.LOGICAL, ItemNameType.NAME, KeywordPolicy.SSSO),
    MAPPING("Mapping", Icons.MAPPING, ItemNameType.ID, KeywordPolicy.SSSRR),
    PROFILE("Profile", Icons.PROFILE, ItemNameType.NAME, KeywordPolicy.SSSR),
    RESOURCE("Resource", Icons.RESOURCE, ItemNameType.NAME, KeywordPolicy.SSSO),
    RULESET("RuleSet", Icons.RULESET, ItemNameType.NAME, KeywordPolicy.NONE),
    VALUESET("ValueSet", Icons.VALUESET, ItemNameType.NAME, KeywordPolicy.SSS);

    private final String name;

    private final Icon icon;

    private final ItemNameType nameType;

    private final KeywordPolicy keywordPolicy;

    ItemType(final String name,
             final Icon icon,
             final ItemNameType nameType,
             final KeywordPolicy keywordPolicy) {
        this.name = name;
        this.icon = icon;
        this.nameType = nameType;
        this.keywordPolicy = keywordPolicy;
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

    public KeywordPolicy getKeywordPolicy() {
        return this.keywordPolicy;
    }
}

// Copyright 2022 Quentin Ligier. Use of this source code is governed by the MIT license.
package ch.qligier.jetbrains.plugin.fss.fsh.specs

import javax.swing.Icon
import ch.qligier.jetbrains.plugin.fss.common.Icons

/**
 * The types of FSH items.
 */
enum class ItemType(
    val displayName: String,
    val icon: Icon,
    val nameType: ItemNameType,
    val keywordPolicy: KeywordPolicy
) {
    ALIAS("Alias", Icons.ALIAS, ItemNameType.EXPRESSION, KeywordPolicy.Companion.NONE),
    CODESYSTEM("CodeSystem", Icons.CODESYSTEM, ItemNameType.NAME, KeywordPolicy.Companion.SSS),
    EXTENSION("Extension", Icons.EXTENSION, ItemNameType.NAME, KeywordPolicy.Companion.SSSO),
    INSTANCE("Instance", Icons.INSTANCE, ItemNameType.ID, KeywordPolicy.Companion.SSRO),
    INVARIANT("Invariant", Icons.INVARIANT, ItemNameType.ID, KeywordPolicy.Companion.RROO),
    LOGICAL("Logical", Icons.LOGICAL, ItemNameType.NAME, KeywordPolicy.Companion.SSSO),
    MAPPING("Mapping", Icons.MAPPING, ItemNameType.ID, KeywordPolicy.Companion.SSSRR),
    PROFILE("Profile", Icons.PROFILE, ItemNameType.NAME, KeywordPolicy.Companion.SSSR),
    RESOURCE("Resource", Icons.RESOURCE, ItemNameType.NAME, KeywordPolicy.Companion.SSSO),
    RULESET("RuleSet", Icons.RULESET, ItemNameType.NAME, KeywordPolicy.Companion.NONE),
    VALUESET("ValueSet", Icons.VALUESET, ItemNameType.NAME, KeywordPolicy.Companion.SSS);
}

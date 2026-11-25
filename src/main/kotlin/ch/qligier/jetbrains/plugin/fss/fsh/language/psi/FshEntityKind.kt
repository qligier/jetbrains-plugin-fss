/*
 * Copyright 2026 Quentin Ligier. Use of this source code is governed by the MIT license.
 */
package ch.qligier.jetbrains.plugin.fss.fsh.language.psi

import ch.qligier.jetbrains.plugin.fss.common.FssIcons
import javax.swing.Icon

/**
 * The kinds of FSH entities, as declared by their keyword. A parameterized RuleSet is a [RULE_SET] (see
 * [FshParamRuleSetEntity] for the parameters).
 *
 * @property keyword the declaration keyword, also used as the entity type shown to users
 * @property icon the icon for this entity kind
 */
enum class FshEntityKind(
    val keyword: String,
    val icon: Icon,
) {
    ALIAS("Alias", FssIcons.FSH_ALIAS),
    PROFILE("Profile", FssIcons.FSH_PROFILE),
    EXTENSION("Extension", FssIcons.FSH_EXTENSION),
    LOGICAL("Logical", FssIcons.FSH_LOGICAL),
    RESOURCE("Resource", FssIcons.FSH_RESOURCE),
    INSTANCE("Instance", FssIcons.FSH_INSTANCE),
    INVARIANT("Invariant", FssIcons.FSH_INVARIANT),
    VALUE_SET("ValueSet", FssIcons.FSH_VALUESET),
    CODE_SYSTEM("CodeSystem", FssIcons.FSH_CODESYSTEM),
    RULE_SET("RuleSet", FssIcons.FSH_RULESET),
    MAPPING("Mapping", FssIcons.FSH_MAPPING),
    ;

    companion object {
        /** The kind of entity element type (`PROFILE_ENTITY`, `PARAM_RULE_SET_ENTITY`, …), by its debug name. */
        fun fromElementTypeName(name: String): FshEntityKind =
            when (name) {
                "ALIAS_ENTITY" -> ALIAS
                "PROFILE_ENTITY" -> PROFILE
                "EXTENSION_ENTITY" -> EXTENSION
                "LOGICAL_ENTITY" -> LOGICAL
                "RESOURCE_ENTITY" -> RESOURCE
                "INSTANCE_ENTITY" -> INSTANCE
                "INVARIANT_ENTITY" -> INVARIANT
                "VALUE_SET_ENTITY" -> VALUE_SET
                "CODE_SYSTEM_ENTITY" -> CODE_SYSTEM
                "RULE_SET_ENTITY", "PARAM_RULE_SET_ENTITY" -> RULE_SET
                "MAPPING_ENTITY" -> MAPPING
                else -> throw IllegalArgumentException("Not an entity element type: $name")
            }
    }
}

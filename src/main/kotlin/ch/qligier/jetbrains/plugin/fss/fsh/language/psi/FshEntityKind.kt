/*
 * Copyright 2026 Quentin Ligier. Use of this source code is governed by the MIT license.
 */
package ch.qligier.jetbrains.plugin.fss.fsh.language.psi

import com.intellij.openapi.util.IconLoader
import javax.swing.Icon

/**
 * The kinds of FSH entities, as declared by their keyword. A parameterized RuleSet is a [RULE_SET] (see
 * [FshParamRuleSetEntity] for the parameters).
 *
 * @property keyword the declaration keyword, also used as the entity type shown to users
 * @property iconName the icon in the plugin's resources (`icons/<name>.svg`)
 */
enum class FshEntityKind(
    val keyword: String,
    private val iconName: String,
) {
    ALIAS("Alias", "alias"),
    PROFILE("Profile", "profile"),
    EXTENSION("Extension", "extension"),
    LOGICAL("Logical", "logical"),
    RESOURCE("Resource", "resource"),
    INSTANCE("Instance", "instance"),
    INVARIANT("Invariant", "invariant"),
    VALUE_SET("ValueSet", "valueset"),
    CODE_SYSTEM("CodeSystem", "codesystem"),
    RULE_SET("RuleSet", "ruleset"),
    MAPPING("Mapping", "mapping"),
    ;

    /** The icon, or null when the resources lack it (the sandbox has no icons; the plugin has them all). */
    val icon: Icon? by lazy { IconLoader.findIcon("icons/$iconName.svg", FshEntityKind::class.java.classLoader) }

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

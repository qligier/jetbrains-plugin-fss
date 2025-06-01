// Copyright 2022 Quentin Ligier. Use of this source code is governed by the MIT license.
package ch.qligier.jetbrains.plugin.fss.fsh.specs

import java.util.EnumMap

/**
 * The cardinality policy of FSH metadata for a given item type.
 */
class KeywordPolicy(
    id: Cardinality,
    description: Cardinality,
    title: Cardinality,
    parent: Cardinality,
    instanceOf: Cardinality,
    usage: Cardinality,
    source: Cardinality,
    target: Cardinality,
    severity: Cardinality,
    xpath: Cardinality,
    expression: Cardinality,
) {
    private val map: EnumMap<KeywordType, Cardinality>

    init {
        this.map = EnumMap<KeywordType, Cardinality>(KeywordType::class.java)
        this.map.put(KeywordType.ID, id)
        this.map.put(KeywordType.DESCRIPTION, description)
        this.map.put(KeywordType.TITLE, title)
        this.map.put(KeywordType.PARENT, parent)
        this.map.put(KeywordType.INSTANCE_OF, instanceOf)
        this.map.put(KeywordType.USAGE, usage)
        this.map.put(KeywordType.SOURCE, source)
        this.map.put(KeywordType.TARGET, target)
        this.map.put(KeywordType.SEVERITY, severity)
        this.map.put(KeywordType.XPATH, xpath)
        this.map.put(KeywordType.EXPRESSION, expression)
        // Trial Use: Context
        // Trial Use: Characteristics
    }

    fun getCardinality(type: KeywordType): Cardinality {
        return this.map[type] ?: error("Unknown keyword type: $type")
    }

    enum class Cardinality {
        REQUIRED,
        OPTIONAL,
        FORBIDDEN
    }

    companion object {
        val NONE: KeywordPolicy = KeywordPolicy(
            Cardinality.FORBIDDEN, Cardinality.FORBIDDEN,
            Cardinality.FORBIDDEN, Cardinality.FORBIDDEN,
            Cardinality.FORBIDDEN, Cardinality.FORBIDDEN,
            Cardinality.FORBIDDEN, Cardinality.FORBIDDEN,
            Cardinality.FORBIDDEN, Cardinality.FORBIDDEN,
            Cardinality.FORBIDDEN
        )
        val SSS: KeywordPolicy = KeywordPolicy(
            Cardinality.OPTIONAL, Cardinality.OPTIONAL,
            Cardinality.OPTIONAL, Cardinality.FORBIDDEN,
            Cardinality.FORBIDDEN, Cardinality.FORBIDDEN,
            Cardinality.FORBIDDEN, Cardinality.FORBIDDEN,
            Cardinality.FORBIDDEN, Cardinality.FORBIDDEN,
            Cardinality.FORBIDDEN
        )
        val SSSO: KeywordPolicy = KeywordPolicy(
            Cardinality.OPTIONAL, Cardinality.OPTIONAL,
            Cardinality.OPTIONAL, Cardinality.OPTIONAL,
            Cardinality.FORBIDDEN, Cardinality.FORBIDDEN,
            Cardinality.FORBIDDEN, Cardinality.FORBIDDEN,
            Cardinality.FORBIDDEN, Cardinality.FORBIDDEN,
            Cardinality.FORBIDDEN
        )
        val SSSR: KeywordPolicy = KeywordPolicy(
            Cardinality.OPTIONAL, Cardinality.OPTIONAL,
            Cardinality.OPTIONAL, Cardinality.REQUIRED,
            Cardinality.FORBIDDEN, Cardinality.FORBIDDEN,
            Cardinality.FORBIDDEN, Cardinality.FORBIDDEN,
            Cardinality.FORBIDDEN, Cardinality.FORBIDDEN,
            Cardinality.FORBIDDEN
        )
        val SSRO: KeywordPolicy = KeywordPolicy(
            Cardinality.FORBIDDEN, Cardinality.OPTIONAL,
            Cardinality.OPTIONAL, Cardinality.FORBIDDEN,
            Cardinality.REQUIRED, Cardinality.OPTIONAL,
            Cardinality.FORBIDDEN, Cardinality.FORBIDDEN,
            Cardinality.FORBIDDEN, Cardinality.FORBIDDEN,
            Cardinality.FORBIDDEN
        )
        val RROO: KeywordPolicy = KeywordPolicy(
            Cardinality.FORBIDDEN, Cardinality.REQUIRED,
            Cardinality.FORBIDDEN, Cardinality.FORBIDDEN,
            Cardinality.FORBIDDEN, Cardinality.FORBIDDEN,
            Cardinality.FORBIDDEN, Cardinality.FORBIDDEN,
            Cardinality.REQUIRED, Cardinality.OPTIONAL,
            Cardinality.OPTIONAL
        )
        val SSSRR: KeywordPolicy = KeywordPolicy(
            Cardinality.OPTIONAL, Cardinality.OPTIONAL,
            Cardinality.OPTIONAL, Cardinality.FORBIDDEN,
            Cardinality.FORBIDDEN, Cardinality.FORBIDDEN,
            Cardinality.REQUIRED, Cardinality.REQUIRED,
            Cardinality.FORBIDDEN, Cardinality.FORBIDDEN,
            Cardinality.FORBIDDEN
        )
    }
}

/*
 * Copyright 2026 Quentin Ligier. Use of this source code is governed by the MIT license.
 */

package ch.qligier.jetbrains.plugin.fss.fsh.language.psi

import com.intellij.psi.tree.TokenSet

interface FshTokenSets {
    companion object {
        val COMMENTS: TokenSet = TokenSet.create(FshTypes.LINE_COMMENT, FshTypes.BLOCK_COMMENT)

        val STRINGS: TokenSet = TokenSet.create(FshTypes.STRING, FshTypes.MULTILINE_STRING)

        val ENTITY_KEYWORDS: TokenSet = TokenSet.create(
            FshTypes.KW_ALIAS, FshTypes.KW_PROFILE, FshTypes.KW_EXTENSION,
            FshTypes.KW_RESOURCE, FshTypes.KW_LOGICAL, FshTypes.KW_INSTANCE,
            FshTypes.KW_VALUESET, FshTypes.KW_CODESYSTEM, FshTypes.KW_MAPPING,
            FshTypes.KW_RULESET, FshTypes.KW_INVARIANT
        )

        val METADATA_KEYWORDS: TokenSet = TokenSet.create(
            FshTypes.KW_ID, FshTypes.KW_TITLE, FshTypes.KW_DESCRIPTION,
            FshTypes.KW_PARENT, FshTypes.KW_INSTANCEOF, FshTypes.KW_USAGE,
            FshTypes.KW_SOURCE, FshTypes.KW_TARGET, FshTypes.KW_SEVERITY,
            FshTypes.KW_EXPRESSION, FshTypes.KW_XPATH, FshTypes.KW_CONTEXT,
            FshTypes.KW_CHARACTERISTICS, FshTypes.KW_MIXINS
        )

        val RULE_KEYWORDS: TokenSet = TokenSet.create(
            FshTypes.KW_FROM, FshTypes.KW_OBEYS, FshTypes.KW_ONLY,
            FshTypes.KW_CONTAINS, FshTypes.KW_NAMED, FshTypes.KW_AND,
            FshTypes.KW_OR, FshTypes.KW_INSERT, FshTypes.KW_INCLUDE,
            FshTypes.KW_EXCLUDE, FshTypes.KW_WHERE, FshTypes.KW_CODES,
            FshTypes.KW_SYSTEM, FshTypes.KW_UNITS, FshTypes.KW_CONTENTREFERENCE
        )

        val FLAG_KEYWORDS: TokenSet = TokenSet.create(
            FshTypes.KW_MS, FshTypes.KW_SU, FshTypes.KW_TU,
            FshTypes.KW_NORMATIVE, FshTypes.KW_DRAFT, FshTypes.KW_MODIFIEREXT
        )

        val KEYWORDS: TokenSet = TokenSet.orSet(
            ENTITY_KEYWORDS, METADATA_KEYWORDS, RULE_KEYWORDS, FLAG_KEYWORDS
        )
    }
}


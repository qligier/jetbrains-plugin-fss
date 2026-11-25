/*
 * Copyright 2026 Quentin Ligier. Use of this source code is governed by the MIT license.
 */

package ch.qligier.jetbrains.plugin.fss.fsh.language.parser

import ch.qligier.jetbrains.plugin.fss.fsh.language.psi.FshTypes
import com.intellij.lang.PsiBuilder
import com.intellij.lang.parser.GeneratedParserUtilBase
import com.intellij.psi.tree.TokenSet

/**
 * Parsing helpers used as external rules by the generated parser (`parserUtilClass`)
 */
object FshParserUtil : GeneratedParserUtilBase() {
    /** Tokens accepted as a name or path start. Keywords and numbers are remapped to WORD */
    private val NAME_TOKENS =
        TokenSet.create(
            FshTypes.WORD,
            FshTypes.NUMBER,
            FshTypes.DATE_TIME,
            FshTypes.TIME,
            FshTypes.KW_FROM,
            FshTypes.KW_CONTAINS,
            FshTypes.KW_NAMED,
            FshTypes.KW_AND,
            FshTypes.KW_OR,
            FshTypes.KW_ONLY,
            FshTypes.KW_OBEYS,
            FshTypes.KW_INCLUDE,
            FshTypes.KW_EXCLUDE,
            FshTypes.KW_CODES,
            FshTypes.KW_WHERE,
            FshTypes.KW_VALUESET_REF,
            FshTypes.KW_SYSTEM,
            FshTypes.KW_CONTENT_REFERENCE,
            FshTypes.KW_TRUE,
            FshTypes.KW_FALSE,
            FshTypes.KW_MS,
            FshTypes.KW_SU,
            FshTypes.KW_TU,
            FshTypes.KW_N,
            FshTypes.KW_D,
        )

    /** Tokens that start a new rule or entity: never consumed as junk */
    private val BOUNDARY_TOKENS =
        TokenSet.create(
            FshTypes.STAR,
            FshTypes.KW_ALIAS,
            FshTypes.KW_PROFILE,
            FshTypes.KW_EXTENSION,
            FshTypes.KW_INSTANCE,
            FshTypes.KW_INVARIANT,
            FshTypes.KW_VALUESET,
            FshTypes.KW_CODESYSTEM,
            FshTypes.KW_RULESET,
            FshTypes.KW_MAPPING,
            FshTypes.KW_LOGICAL,
            FshTypes.KW_RESOURCE,
        )

    /** Metadata keywords: they end junk inside an entity, since metadata is accepted anywhere in an entity */
    private val METADATA_KEYWORDS =
        TokenSet.create(
            FshTypes.KW_PARENT,
            FshTypes.KW_ID,
            FshTypes.KW_TITLE,
            FshTypes.KW_DESCRIPTION,
            FshTypes.KW_EXPRESSION,
            FshTypes.KW_XPATH,
            FshTypes.KW_SEVERITY,
            FshTypes.KW_INSTANCEOF,
            FshTypes.KW_USAGE,
            FshTypes.KW_SOURCE,
            FshTypes.KW_TARGET,
            FshTypes.KW_CONTEXT,
            FshTypes.KW_CHARACTERISTICS,
        )

    private val ENTITY_JUNK_STOP = TokenSet.orSet(BOUNDARY_TOKENS, METADATA_KEYWORDS)

    /**
     * Inside an entity: consumes the text up to the next rule, metadata or declaration as one error element.
     * Used for text that is neither a rule nor metadata (for example extra words after an entity name).
     */
    @JvmStatic
    fun junkTokens(
        builder: PsiBuilder,
        level: Int,
    ): Boolean = consumeAsError(builder, ENTITY_JUNK_STOP, "Unexpected text: a rule, metadata or a declaration is expected")

    /** Before the first declaration: consumes the text up to the next rule or declaration as one error element. */
    @JvmStatic
    fun orphanTokens(
        builder: PsiBuilder,
        level: Int,
    ): Boolean = consumeAsError(builder, BOUNDARY_TOKENS, "Unexpected text: a declaration is expected")

    private fun consumeAsError(
        builder: PsiBuilder,
        stop: TokenSet,
        message: String,
    ): Boolean {
        if (builder.eof() || stop.contains(builder.tokenType)) return false
        val marker = builder.mark()
        while (!builder.eof() && !stop.contains(builder.tokenType)) builder.advanceLexer()
        marker.error(message)
        return true
    }

    /** Consumes one name token, remapping keywords and numbers to WORD so that names are uniform in the PSI. */
    @JvmStatic
    fun nameToken(
        builder: PsiBuilder,
        level: Int,
    ): Boolean {
        val type = builder.tokenType
        if (type == null || !NAME_TOKENS.contains(type)) {
            // External rules register no expected variant by themselves, and a pinned rule reports no error without one: a missing
            // name (`* include codes from system`) would otherwise go unreported
            addVariant(builder, "<name>")
            return false
        }
        if (type != FshTypes.WORD) builder.remapCurrentToken(FshTypes.WORD)
        builder.advanceLexer()
        return true
    }

    /** Consumes one token that does not start a rule or an entity. */
    @JvmStatic
    fun junkToken(
        builder: PsiBuilder,
        level: Int,
    ): Boolean {
        val type = builder.tokenType ?: return false
        if (BOUNDARY_TOKENS.contains(type)) return false
        builder.advanceLexer()
        return true
    }
}

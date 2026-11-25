/*
 * Copyright 2026 Quentin Ligier. Use of this source code is governed by the MIT license.
 */
package ch.qligier.jetbrains.plugin.fss.fsh.language.psi.util

import ch.qligier.jetbrains.plugin.fss.fsh.language.psi.*
import com.intellij.psi.util.PsiTreeUtil

/**
 * Paths: segments of a path word, and the context that indentation gives to a rule's path (D12). Rules are flat in the PSI, so the
 * context is computed here, the way SUSHI's importer does it (`prependPathContext`).
 */
object FshPaths {
    const val INDENT_WIDTH = 2

    /** The segments of a path, with ranges relative to the path element. */
    fun segments(path: FshPath): List<FshText.PathSegment> = FshText.pathSegments(path.text)

    /** The indentation of a rule: the column of its `*`, counted in characters from the start of the line. */
    fun indent(rule: FshRule): Int {
        val chars = rule.containingFile.node.chars
        val star = rule.textRange.startOffset
        var i = star
        while (i > 0 && chars[i - 1] != '\n' && chars[i - 1] != '\r') i--
        return star - i
    }

    /**
     * The path of each rule of [entity] with the context of its indentation, as a list of path elements. Elements are path
     * segments (`item[=]`), codes (`#code`) in CodeSystems, and `system#code` in ValueSets. A rule with several paths
     * (`* a and b MS`) maps to its first one; rules that take no part in the context (raw lines) are absent.
     *
     * Mirrors SUSHI, including its corner cases: a rule indented without a valid context keeps its own path, and once a context is
     * used by a rule other than a path rule, the soft index `[+]` becomes `[=]` in it, so that it is not incremented again.
     */
    fun contextPaths(entity: FshEntity): Map<FshRule, List<String>> {
        val resolver = Resolver(isInstance = entity is FshInstanceEntity)
        val result = LinkedHashMap<FshRule, List<String>>()
        val inValueSet = entity is FshValueSetEntity
        for (rule in PsiTreeUtil.getChildrenOfTypeAsList(entity, FshRule::class.java)) {
            val inputs = inputs(rule, inValueSet)
            if (inputs.isEmpty()) continue
            val indent = indent(rule)
            inputs.forEachIndexed { i, input ->
                val resolved = resolver.apply(input, indent)
                if (i == 0) result[rule] = resolved
            }
        }
        return result
    }

    /** What one rule contributes to the context. */
    private class Input(
        val path: List<String>,
        val isPathRule: Boolean = false,
        /** SUSHI applies the context of ValueSet components even below a rule without a path. */
        val suppressError: Boolean = false,
    )

    private class Resolver(
        val isInstance: Boolean,
    ) {
        private var context: MutableList<List<String>> = ArrayList()

        fun apply(
            input: Input,
            indent: Int,
        ): List<String> {
            try {
                val path = input.path
                if (!isValidContext(indent)) return path
                val index = indent / INDENT_WIDTH
                if (index == 0) {
                    context = arrayListOf(path)
                    return path
                }
                if (path == listOf(".")) return path
                val current = context[index - 1]
                if (current.isEmpty() && !input.suppressError) return path
                while (context.size > index) context.removeAt(context.size - 1)
                val full = current + path
                context.add(full)
                return full
            } finally {
                if (!input.isPathRule || isInstance) {
                    context =
                        context.mapTo(ArrayList()) { p -> p.map { it.replace("[+]", "[=]") } }
                }
            }
        }

        private fun isValidContext(indent: Int): Boolean =
            !(indent > 0 && context.isEmpty()) && indent % INDENT_WIDTH == 0 && indent / INDENT_WIDTH <= context.size
    }

    private fun inputs(
        rule: FshRule,
        inValueSet: Boolean,
    ): List<Input> {
        val paths =
            rule.node
                .getChildren(null)
                .filter { it.elementType == FshTypes.PATH }
                .map { it.text }
        val codes =
            rule.node
                .findChildByType(FshTypes.CODES)
                ?.getChildren(null)
                ?.filter { it.elementType == FshTypes.CODE }
                ?.map { FshText.codeParts(it.text) }
        val codePath = {
            codes
                .orEmpty()
                .map { if (inValueSet) "${it.systemWithVersion.orEmpty()}#${it.codeText}" else "#${it.codeText}" }
        }
        val vsConcept = {
            Input(
                if (codes?.size == 1) listOf("${codes[0].systemWithVersion ?: "undefined"}#${codes[0].codeText}") else emptyList(),
                suppressError = true,
            )
        }
        return when (rule.node.elementType) {
            FshTypes.FLAG_RULE -> {
                paths.map { Input(split(it)) }
            }

            FshTypes.CARD_RULE, FshTypes.BINDING_RULE, FshTypes.ASSIGNMENT_RULE, FshTypes.ONLY_RULE, FshTypes.CONTAINS_RULE,
            FshTypes.ADD_ELEMENT_RULE, FshTypes.ADD_CR_ELEMENT_RULE,
            -> {
                paths.take(1).map { Input(split(it)) }
            }

            FshTypes.OBEYS_RULE, FshTypes.MAPPING_RULE -> {
                listOf(Input(split(paths.firstOrNull().orEmpty())))
            }

            FshTypes.CARET_VALUE_RULE -> {
                listOf(
                    Input(
                        if (codes != null) {
                            codePath()
                        } else {
                            split(
                                paths.firstOrNull().orEmpty(),
                            )
                        },
                    ),
                )
            }

            FshTypes.INSERT_RULE -> {
                listOf(Input(if (codes != null) codePath() else paths.take(1)))
            }

            FshTypes.CONCEPT_RULE -> {
                listOf(if (inValueSet) vsConcept() else Input(codePath()))
            }

            FshTypes.VS_CONCEPT_RULE -> {
                listOf(vsConcept())
            }

            FshTypes.VS_FILTER_RULE -> {
                listOf(Input(emptyList(), suppressError = true))
            }

            FshTypes.RULE -> {
                paths.take(1).map { Input(split(it), isPathRule = true) }
            }

            else -> {
                emptyList()
            }
        }
    }

    /**
     * SUSHI's `getPathWithContext` input: the path split at its periods, without empty segments (`reference.` is `[reference]`,
     * and no path is `[]`), with the special path `.` kept whole.
     */
    private fun split(path: String): List<String> =
        if (path == ".") {
            listOf(".")
        } else {
            FshText
                .pathSegments(path)
                .map { it.range.substring(path) }
                .filter { it.isNotEmpty() }
        }
}

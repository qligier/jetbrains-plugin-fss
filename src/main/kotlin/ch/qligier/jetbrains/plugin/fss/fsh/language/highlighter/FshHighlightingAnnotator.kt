/*
 * Copyright 2026 Quentin Ligier. Use of this source code is governed by the MIT license.
 */

package ch.qligier.jetbrains.plugin.fss.fsh.language.highlighter

import ch.qligier.jetbrains.plugin.fss.fsh.language.psi.FshEntityName
import ch.qligier.jetbrains.plugin.fss.fsh.language.psi.FshTypes
import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.lang.annotation.HighlightSeverity
import com.intellij.openapi.editor.markup.TextAttributes
import com.intellij.openapi.project.DumbAware
import com.intellij.psi.PsiElement
import com.intellij.psi.impl.source.tree.LeafPsiElement

/**
 * The syntax-aware part of FSH highlighting, on top of [FshSyntaxHighlighter]:
 * - keywords and numbers used as names or paths (`* system = …`, `Profile: MS`) are remapped to WORD by the parser,
 *   but the lexer-based highlighter still colors them: their color is reset to [FshSyntaxHighlighter.IDENTIFIER];
 * - entity names (`Profile: MyProfile`) get [FshSyntaxHighlighter.ENTITY_NAME].
 */
internal class FshHighlightingAnnotator :
    Annotator,
    DumbAware {
    override fun annotate(
        element: PsiElement,
        holder: AnnotationHolder,
    ) {
        when {
            element is FshEntityName -> {
                holder
                    .newSilentAnnotation(HighlightSeverity.INFORMATION)
                    .textAttributes(FshSyntaxHighlighter.ENTITY_NAME)
                    .create()
            }

            element is LeafPsiElement && element.elementType == FshTypes.WORD && isLexedAsNonWord(element.text) -> {
                // Erase the lexer color, then apply the identifier color
                holder
                    .newSilentAnnotation(HighlightSeverity.INFORMATION)
                    .enforcedTextAttributes(TextAttributes.ERASE_MARKER)
                    .create()
                holder
                    .newSilentAnnotation(HighlightSeverity.INFORMATION)
                    .textAttributes(FshSyntaxHighlighter.IDENTIFIER)
                    .create()
            }
        }
    }

    companion object {
        /** The texts of the keyword tokens that the parser accepts as names (FshParserUtil.NAME_TOKENS) */
        private val REMAPPABLE_KEYWORDS =
            setOf(
                "from",
                "contains",
                "named",
                "and",
                "or",
                "only",
                "obeys",
                "include",
                "exclude",
                "codes",
                "where",
                "valueset",
                "system",
                "contentReference",
                "true",
                "false",
                "MS",
                "SU",
                "TU",
                "N",
                "D",
            )

        /**
         * Whether the highlighting lexer gives this WORD leaf another token type: a remappable keyword, or a number, date or time. The
         * check on numbers is approximate (any word that starts like a number), which is harmless: resetting a plain word does nothing.
         */
        private fun isLexedAsNonWord(text: String): Boolean {
            if (text in REMAPPABLE_KEYWORDS) return true
            val first = text.firstOrNull() ?: return false
            if (first.isDigit()) return true
            return (first == '+' || first == '-') && text.length > 1 && text[1].isDigit()
        }
    }
}

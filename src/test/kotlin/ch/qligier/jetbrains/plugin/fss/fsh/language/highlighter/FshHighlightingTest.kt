/*
 * Copyright 2026 Quentin Ligier. Use of this source code is governed by the MIT license.
 */

package ch.qligier.jetbrains.plugin.fss.fsh.language.highlighter

import ch.qligier.jetbrains.plugin.fss.fsh.language.psi.FshTokenType
import ch.qligier.jetbrains.plugin.fss.fsh.language.psi.FshTypes
import com.intellij.codeInsight.daemon.impl.HighlightInfo
import com.intellij.openapi.editor.colors.EditorColorsManager
import com.intellij.openapi.editor.markup.TextAttributes
import com.intellij.openapi.util.TextRange
import com.intellij.testFramework.fixtures.BasePlatformTestCase
import java.awt.Font

class FshHighlightingTest : BasePlatformTestCase() {
    fun testEveryTokenTypeHasAColor() {
        val highlighter = FshSyntaxHighlighter()
        val tokenTypes =
            FshTypes::class.java.fields
                .mapNotNull { it.get(null) as? FshTokenType }
        assertTrue(tokenTypes.isNotEmpty())
        val missing = tokenTypes.filter { highlighter.getTokenHighlights(it).isEmpty() }
        assertEmpty("Token types without a color: $missing", missing)
    }

    fun testLexerColors() {
        val text = "Profile: P\n* code from VS (required)\n* status = #final\n"
        val highlighter = FshSyntaxHighlighter()
        val lexer = highlighter.highlightingLexer
        lexer.start(text)
        val colors = mutableMapOf<String, String>()
        while (lexer.tokenType != null) {
            val keys = highlighter.getTokenHighlights(lexer.tokenType!!)
            if (keys.isNotEmpty()) colors[lexer.tokenText] = keys.first().externalName
            lexer.advance()
        }
        assertEquals("FSH_DECLARATION_KEYWORD", colors["Profile"])
        assertEquals("FSH_RULE_MARKER", colors["*"])
        assertEquals("FSH_RULE_KEYWORD", colors["from"])
        assertEquals("FSH_BINDING_STRENGTH", colors["(required)"])
        assertEquals("FSH_CODE", colors["#final"])
        assertEquals("FSH_IDENTIFIER", colors["VS"])
    }

    fun testAnnotator() {
        val text = "Profile: MS\n* system = \"x\"\n\nValueSet: VS\n* include codes from system http://x.org\n"
        myFixture.configureByText("test.fsh", text)
        val infos = myFixture.doHighlighting()

        fun rangeOf(
            word: String,
            from: Int = 0,
        ): TextRange {
            val start = text.indexOf(word, from)
            return TextRange(start, start + word.length)
        }

        fun erased(range: TextRange) = infos.any { it.range() == range && it.forcedTextAttributes == TextAttributes.ERASE_MARKER }

        fun hasKey(
            range: TextRange,
            key: String,
        ) = infos.any { it.range() == range && it.forcedTextAttributesKey?.externalName == key }

        // A flag used as an entity name: reset, then colored as an entity name
        assertTrue(erased(rangeOf("MS")))
        assertTrue(hasKey(rangeOf("MS"), "FSH_ENTITY_NAME"))
        assertTrue(hasKey(rangeOf("VS"), "FSH_ENTITY_NAME"))
        // `system` in a path is reset, `system` as a keyword is not
        assertTrue(erased(rangeOf("system")))
        assertFalse(erased(rangeOf("system", text.indexOf("from"))))
    }

    fun testFlagsAreBoldInBundledSchemes() {
        for (name in listOf("Default", "Darcula")) {
            val scheme = EditorColorsManager.getInstance().getScheme(name)
            assertNotNull("Scheme $name", scheme)
            val attributes = scheme!!.getAttributes(FshSyntaxHighlighter.FLAG)
            assertEquals("Font type in $name", Font.BOLD, attributes.fontType)
            assertNotNull("Foreground in $name", attributes.foregroundColor)
        }
    }

    private fun HighlightInfo.range() = TextRange(startOffset, endOffset)
}

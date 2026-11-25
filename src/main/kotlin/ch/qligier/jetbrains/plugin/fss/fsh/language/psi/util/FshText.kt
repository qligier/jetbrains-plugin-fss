/*
 * Copyright 2026 Quentin Ligier. Use of this source code is governed by the MIT license.
 */
package ch.qligier.jetbrains.plugin.fss.fsh.language.psi.util

import com.intellij.openapi.util.TextRange

/**
 * The structure inside single tokens (D2: words are never split by the lexer, their structure comes from text ranges). Pure text
 * functions that mirror SUSHI's importer, so that the plugin reads codes, strings and paths as SUSHI does.
 */
object FshText {
    /**
     * The parts of a `CODE` token: `system|version#code`, `#code`, `#"quoted code"`. Ranges are relative to the token text.
     * Like SUSHI's `parseCodeLexeme`, the code starts after the first `#` that is not escaped with a backslash.
     */
    data class CodeParts(
        val token: String,
        /** The system before the `|` or the `#`, or null when the code has no system. */
        val system: TextRange?,
        /** The version after the `|`, or null. */
        val version: TextRange?,
        /** The code after the `#`, quotes included when [quoted]. */
        val code: TextRange,
    ) {
        val quoted: Boolean get() = code.length >= 2 && token[code.startOffset] == '"' && token[code.endOffset - 1] == '"'

        /** The system with escapes resolved (`\#` and `\\`), without the version. */
        val systemText: String? get() = system?.let { unescapeSystem(it.substring(token)) }

        val versionText: String? get() = version?.let { unescapeSystem(it.substring(token)) }

        /** The system and version as SUSHI keeps them before resolving aliases: `system|version`. */
        val systemWithVersion: String?
            get() =
                if (system == null) {
                    null
                } else {
                    unescapeSystem(
                        TextRange(
                            system.startOffset,
                            (version ?: system).endOffset,
                        ).substring(token),
                    )
                }

        /** The code, without quotes and with escapes resolved (`\"` and `\\` in quoted codes). */
        val codeText: String
            get() {
                val raw = code.substring(token)
                return if (quoted) raw.substring(1, raw.length - 1).replace("\\\\", "\\").replace("\\\"", "\"") else raw
            }

        private fun unescapeSystem(text: String): String = text.replace("\\\\", "\\").replace("\\#", "#")
    }

    fun codeParts(token: String): CodeParts {
        var hash = -1
        var backslashes = 0
        for (i in token.indices) {
            val c = token[i]
            if (c == '#' && backslashes % 2 == 0) {
                hash = i
                break
            }
            backslashes = if (c == '\\') backslashes + 1 else 0
        }
        if (hash < 0) return CodeParts(token, null, null, TextRange(token.length, token.length))
        val code = TextRange(hash + 1, token.length)
        if (hash == 0) return CodeParts(token, null, null, code)
        val bar = token.indexOf('|')
        return if (bar in 0 until hash) {
            CodeParts(token, TextRange(0, bar), TextRange(bar + 1, hash), code)
        } else {
            CodeParts(token, TextRange(0, hash), null, code)
        }
    }

    /** The value of a `STRING` token, unescaped like SUSHI: `\"`, `\n`, `\r`, `\t`, `\uXXXX`, and `\\` for a backslash. */
    fun stringValue(token: String): String {
        val body = if (token.length >= 2 && token.endsWith('"')) token.substring(1, token.length - 1) else token.drop(1)
        return body.split("\\\\").joinToString("\\") { part ->
            UNICODE_ESCAPE
                .replace(part) { unicode(it.groupValues[1]) }
                .replace("\\\"", "\"")
                .replace("\\n", "\n")
                .replace("\\r", "\r")
                .replace("\\t", "\t")
        }
    }

    /**
     * The value of a `MULTILINE_STRING` token, like SUSHI: escapes resolved (but not `\"`), a whitespace-only first and last line
     * dropped, whitespace-only lines emptied, and the common indentation removed.
     */
    fun multilineStringValue(token: String): String {
        val body =
            if (token.length >= 6 && token.endsWith("\"\"\"")) token.substring(3, token.length - 3) else token.drop(3)
        var lines =
            body.split(Regex("\r?\n")).map { line ->
                UNICODE_ESCAPE
                    .replace(line) { unicode(it.groupValues[1]) }
                    .replace("\\n", "\n")
                    .replace("\\r", "\r")
                    .replace("\\t", "\t")
            }
        if (lines.isNotEmpty() && lines.first().isBlankJs()) lines = lines.drop(1)
        if (lines.isNotEmpty() && lines.last().isBlankJs()) lines = lines.dropLast(1)
        lines = lines.map { if (it.isBlankJs()) "" else it }
        val minSpaces =
            lines
                .filter { it.isNotEmpty() }
                .minOfOrNull { line ->
                    line.indexOfFirst { !it.isWhitespaceJs() }.let { if (it < 0) line.length else it }
                }
                ?: 0
        return lines.joinToString("\n") { if (it.length >= minSpaces) it.substring(minSpaces) else it }
    }

    /** The code of a `UNIT` token (`'mg'`): the text between the quotes, as SUSHI keeps it (no unescaping). */
    fun unitCode(token: String): String = if (token.length >= 2) token.substring(1, token.length - 1) else ""

    /** One segment of a path: `name`, `name[x]`, `name[slice]`, `name[0][+]`. Ranges are relative to the path text. */
    data class PathSegment(
        val range: TextRange,
        /** The name, with `[x]` for choice elements, as SUSHI's `PathPart.base`. */
        val base: TextRange,
        /** The contents of the bracket pairs after the base, without the brackets. */
        val brackets: List<TextRange>,
    )

    /**
     * The segments of a path, split at the periods outside brackets, as SUSHI's `splitOnPathPeriods` and `parseFSHPath` do. The
     * special path `.` is one segment. Unbalanced brackets do not throw: the rest of the segment stays in its last bracket range.
     */
    fun pathSegments(path: String): List<PathSegment> {
        if (path == ".") return listOf(PathSegment(TextRange(0, 1), TextRange(0, 1), emptyList()))
        val segments = ArrayList<PathSegment>()
        var start = 0
        var depth = 0
        for (i in 0..path.length) {
            val c = if (i < path.length) path[i] else '.'
            when {
                c == '[' -> {
                    depth++
                }

                c == ']' -> {
                    if (depth > 0) depth--
                }

                c == '.' && (depth == 0 || i == path.length) -> {
                    segments += segment(path, start, i)
                    start = i + 1
                }
            }
        }
        return segments
    }

    private fun segment(
        path: String,
        start: Int,
        end: Int,
    ): PathSegment {
        var baseEnd = path.indexOf('[', start).let { if (it < 0 || it > end) end else it }
        if (path.startsWith("[x]", baseEnd) && baseEnd + 3 <= end) baseEnd += 3
        val brackets = ArrayList<TextRange>()
        var i = baseEnd
        while (i < end) {
            if (path[i] != '[') {
                i++
                continue
            }
            var depth = 0
            var j = i
            while (j < end) {
                if (path[j] == '[') {
                    depth++
                } else if (path[j] == ']' && --depth == 0) {
                    break
                }
                j++
            }
            brackets += TextRange(i + 1, minOf(j, end))
            i = j + 1
        }
        return PathSegment(TextRange(start, end), TextRange(start, baseEnd), brackets)
    }

    private val UNICODE_ESCAPE = Regex("\\\\(u[A-Fa-f,0-9]{4})")

    /** SUSHI's `unescapeUnicode`: `String.fromCharCode(parseInt(hex, 16))`, where `parseInt` stops at the first non-hex character. */
    private fun unicode(escape: String): String {
        val hex = escape.substring(1).takeWhile { it.isLetterOrDigit() && it.lowercaseChar() in "0123456789abcdef" }
        return if (hex.isEmpty()) "\u0000" else hex.toInt(16).toChar().toString()
    }

    /** JavaScript's `\s` (used by SUSHI's regular expressions) includes NBSP and other Unicode spaces. */
    private fun Char.isWhitespaceJs(): Boolean = isWhitespace() || this == ' ' || this == '﻿'

    private fun String.isBlankJs(): Boolean = all { it.isWhitespaceJs() }
}

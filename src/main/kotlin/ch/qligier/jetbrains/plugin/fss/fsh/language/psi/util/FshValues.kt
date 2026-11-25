/*
 * Copyright 2026 Quentin Ligier. Use of this source code is governed by the MIT license.
 */
package ch.qligier.jetbrains.plugin.fss.fsh.language.psi.util

import ch.qligier.jetbrains.plugin.fss.fsh.language.psi.*
import com.intellij.psi.PsiElement
import com.intellij.psi.tree.IElementType

/** The syntactic kind of value, as SUSHI's `value` parser rule tells them apart (plus `REGEX`, which SUSHI rejects as a value). */
enum class FshValueKind {
    STRING,
    MULTILINE_STRING,
    NUMBER,
    DATE_TIME,
    TIME,
    BOOLEAN,
    CODE,
    QUANTITY,
    RATIO,
    REFERENCE,
    CANONICAL,

    /** A name: an instance, or an alias that SUSHI replaces by its value. */
    NAME,
    REGEX,
}

/**
 * Reads values from the PSI as SUSHI's importer does (`visitValue`, `visitCode`, `visitQuantity`, …). Aliases are not resolved:
 * systems, reference targets and names are returned as written, and the plugin resolves them through references.
 */
object FshValues {
    fun kind(value: FshValue): FshValueKind? {
        value.ratio?.let { return FshValueKind.RATIO }
        value.quantity?.let { return FshValueKind.QUANTITY }
        value.referenceValue?.let { return FshValueKind.REFERENCE }
        value.canonicalValue?.let { return FshValueKind.CANONICAL }
        value.codeValue?.let { return FshValueKind.CODE }
        value.nameRef?.let { return FshValueKind.NAME }
        return when (value.node.firstChildNode?.elementType) {
            FshTypes.STRING -> FshValueKind.STRING
            FshTypes.MULTILINE_STRING -> FshValueKind.MULTILINE_STRING
            FshTypes.NUMBER -> FshValueKind.NUMBER
            FshTypes.DATE_TIME -> FshValueKind.DATE_TIME
            FshTypes.TIME -> FshValueKind.TIME
            FshTypes.KW_TRUE, FshTypes.KW_FALSE -> FshValueKind.BOOLEAN
            FshTypes.REGEX -> FshValueKind.REGEX
            else -> null
        }
    }

    /** A code value: the parts of its `CODE` token, and its display string (unescaped). */
    data class Code(
        val parts: FshText.CodeParts,
        val display: String?,
    )

    fun code(value: FshCodeValue): Code =
        Code(
            FshText.codeParts(tokenText(value, FshTypes.CODE).orEmpty()),
            tokenText(value, FshTypes.STRING)?.let(FshText::stringValue),
        )

    /**
     * A quantity: `5 'mg' "milligram"`, `5 http://unitsofmeasure.org#mg`, `'mg'`. The unit system is UCUM for a quoted unit, as in
     * SUSHI, and the system of the code (as written, aliases unresolved) otherwise.
     */
    data class Quantity(
        val number: String?,
        val unitCode: String?,
        val unitSystem: String?,
        val display: String?,
    )

    fun quantity(quantity: FshQuantity): Quantity {
        val number = tokenText(quantity, FshTypes.NUMBER)
        val display = tokenText(quantity, FshTypes.STRING)?.let(FshText::stringValue)
        tokenText(quantity, FshTypes.UNIT)?.let { return Quantity(number, FshText.unitCode(it), UCUM, display) }
        val code = tokenText(quantity, FshTypes.CODE)?.let(FshText::codeParts)
        return Quantity(number, code?.codeText, code?.systemWithVersion, display)
    }

    /** A reference value: its targets (SUSHI uses the first one) and its display string. */
    data class Reference(
        val targets: List<String>,
        val display: String?,
    )

    fun reference(value: FshReferenceValue): Reference =
        Reference(
            value.referenceTargetList.map { it.text },
            tokenText(value, FshTypes.STRING)?.let(FshText::stringValue),
        )

    /** One choice of a canonical value: `Name` or `Name|version`. */
    data class Canonical(
        val name: String,
        val version: String?,
    )

    fun canonicals(value: FshCanonicalValue): List<Canonical> =
        value.referenceTargetList.map {
            val text = it.text
            val bar = text.indexOf('|')
            if (bar < 0) {
                Canonical(text, null)
            } else {
                Canonical(
                    text.substring(0, bar),
                    text.substring(bar + 1).ifEmpty { null },
                )
            }
        }

    private fun tokenText(
        element: PsiElement,
        type: IElementType,
    ): String? = element.node.findChildByType(type)?.text

    const val UCUM = "http://unitsofmeasure.org"
}

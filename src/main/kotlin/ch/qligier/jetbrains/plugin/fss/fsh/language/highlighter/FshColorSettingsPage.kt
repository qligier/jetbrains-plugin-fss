/*
 * Copyright 2026 Quentin Ligier. Use of this source code is governed by the MIT license.
 */

package ch.qligier.jetbrains.plugin.fss.fsh.language.highlighter

import ch.qligier.jetbrains.plugin.fss.common.FssIcons
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighter
import com.intellij.openapi.options.colors.AttributesDescriptor
import com.intellij.openapi.options.colors.ColorDescriptor
import com.intellij.openapi.options.colors.ColorSettingsPage
import javax.swing.Icon

/**
 * The FSH page of Settings | Editor | Color Scheme.
 */
internal class FshColorSettingsPage : ColorSettingsPage {
    override fun getIcon(): Icon = FssIcons.FSH_FILE

    override fun getHighlighter(): SyntaxHighlighter = FshSyntaxHighlighter()

    override fun getDemoText(): String = DEMO_TEXT

    override fun getAdditionalHighlightingTagToDescriptorMap(): Map<String, TextAttributesKey> = ADDITIONAL_TAGS

    override fun getAttributeDescriptors(): Array<AttributesDescriptor> = DESCRIPTORS

    override fun getColorDescriptors(): Array<ColorDescriptor> = ColorDescriptor.EMPTY_ARRAY

    override fun getDisplayName(): String = "FSH"

    companion object {
        private val DESCRIPTORS =
            arrayOf(
                AttributesDescriptor("Keywords//Declaration", FshSyntaxHighlighter.DECLARATION_KEYWORD),
                AttributesDescriptor("Keywords//Metadata", FshSyntaxHighlighter.METADATA_KEYWORD),
                AttributesDescriptor("Keywords//Rule", FshSyntaxHighlighter.RULE_KEYWORD),
                AttributesDescriptor("Keywords//Reference and canonical", FshSyntaxHighlighter.REFERENCE_KEYWORD),
                AttributesDescriptor("Keywords//Binding strength and (exactly)", FshSyntaxHighlighter.BINDING_STRENGTH),
                AttributesDescriptor("Keywords//Flag", FshSyntaxHighlighter.FLAG),
                AttributesDescriptor("Keywords//Boolean", FshSyntaxHighlighter.BOOLEAN),
                AttributesDescriptor("Values//String", FshSyntaxHighlighter.STRING),
                AttributesDescriptor("Values//Number", FshSyntaxHighlighter.NUMBER),
                AttributesDescriptor("Values//Date and time", FshSyntaxHighlighter.DATE_TIME),
                AttributesDescriptor("Values//Cardinality", FshSyntaxHighlighter.CARDINALITY),
                AttributesDescriptor("Values//Code", FshSyntaxHighlighter.CODE),
                AttributesDescriptor("Values//Unit", FshSyntaxHighlighter.UNIT),
                AttributesDescriptor("Values//Regular expression", FshSyntaxHighlighter.REGEX),
                AttributesDescriptor("Names//Entity name", FshSyntaxHighlighter.ENTITY_NAME),
                AttributesDescriptor("Names//Name or path", FshSyntaxHighlighter.IDENTIFIER),
                AttributesDescriptor("Names//Caret path", FshSyntaxHighlighter.CARET_PATH),
                AttributesDescriptor("Names//RuleSet argument", FshSyntaxHighlighter.ARGUMENT),
                AttributesDescriptor("Symbols//Rule marker", FshSyntaxHighlighter.RULE_MARKER),
                AttributesDescriptor("Symbols//Operator", FshSyntaxHighlighter.OPERATOR),
                AttributesDescriptor("Symbols//Comma", FshSyntaxHighlighter.COMMA),
                AttributesDescriptor("Symbols//Parentheses", FshSyntaxHighlighter.PARENTHESES),
                AttributesDescriptor("Comments//Line comment", FshSyntaxHighlighter.LINE_COMMENT),
                AttributesDescriptor("Comments//Block comment", FshSyntaxHighlighter.BLOCK_COMMENT),
                AttributesDescriptor("Bad character", FshSyntaxHighlighter.BAD_CHARACTER),
            )

        private val ADDITIONAL_TAGS =
            mapOf(
                "entity" to FshSyntaxHighlighter.ENTITY_NAME,
                "name" to FshSyntaxHighlighter.IDENTIFIER,
            )

        private val DEMO_TEXT =
            """
            /* Aliases and a profile */
            Alias: <entity>${'$'}sct</entity> = http://snomed.info/sct

            // A profile on Observation
            Profile: <entity>MyObservation</entity>
            Parent: Observation
            Id: my-observation
            Title: "My Observation"
            Description: ""${'"'}A profile with
            a multi-line description""${'"'}
            * status = #final (exactly)
            * code from MyValueSet (required)
            * subject only Reference(Patient or Group)
            * component contains systolic 1..1 MS and diastolic 0..1 SU ?!
            * valueQuantity = 120 'mm[Hg]' "mmHg"
            * effectiveDateTime = 2024-01-15T08:30:00Z
            * interpretation.coding.<name>system</name> = "http://example.org"
            * ^experimental = false
            * obeys my-invariant
            * insert MyRuleSet(value, [[a, b]])

            ValueSet: <entity>MyValueSet</entity>
            * include codes from system ${'$'}sct where concept is-a #404684003
            * exclude ${'$'}sct#123456 "Excluded code"
            * include codes from system http://example.org where display regex /^A.*/
            """.trimIndent()
    }
}

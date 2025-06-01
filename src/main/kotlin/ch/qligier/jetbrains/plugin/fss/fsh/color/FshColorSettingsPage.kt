/*
 * Copyright 2025 Quentin Ligier. Use of this source code is governed by the MIT license.
 */
package ch.qligier.jetbrains.plugin.fss.fsh.color

import ch.qligier.jetbrains.plugin.fss.common.Icons
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighter
import com.intellij.openapi.options.colors.AttributesDescriptor
import com.intellij.openapi.options.colors.ColorDescriptor
import com.intellij.openapi.options.colors.ColorSettingsPage
import com.intellij.openapi.util.NlsContexts
import javax.swing.Icon

/**
 * Definition of a custom page shown in the "Colors and Fonts" settings dialog for the FSH language.
 * @see [Define
 * a Color Settings Page](https://plugins.jetbrains.com/docs/intellij/syntax-highlighter-and-color-settings-page.html.define-a-color-settings-page)
 */
class FshColorSettingsPage : ColorSettingsPage {
    override fun getIcon(): Icon? = Icons.FSH_FLAME
    override fun getHighlighter(): SyntaxHighlighter = FshSyntaxHighlighter()
    override fun getDisplayName(): @NlsContexts.ConfigurableName String = "FSH"
    override fun getAttributeDescriptors(): Array<out AttributesDescriptor> = descriptors
    override fun getColorDescriptors(): Array<out ColorDescriptor> = ColorDescriptor.EMPTY_ARRAY
    override fun getAdditionalHighlightingTagToDescriptorMap(): Map<String, TextAttributesKey>? = null
    override fun getDemoText(): String = """
                // Comment.
                Profile: MyPatient
                Parent: Patient
                Description: "An example profile of the Patient resource."

                Instance: TumorSizeExample
                InstanceOf: TumorSize
                Description: "An example of a patient with a license to krill."
                * component[+].code = http://loinc.org#33728-7
                * status = #final
                * code = http://loinc.org#33728-7
                * name
                    * given[0] = "James"
                    * family = "Pond"
                """
}

private val descriptors: Array<out AttributesDescriptor> = arrayOf(
    AttributesDescriptor("Item declaration", FshSyntaxHighlighter.Companion.DECLARATION),
    AttributesDescriptor("Keyword (item metadata)", FshSyntaxHighlighter.Companion.KEYWORD),
    AttributesDescriptor("String", FshSyntaxHighlighter.Companion.STRING),
    AttributesDescriptor("Value", FshSyntaxHighlighter.Companion.VALUE),
    AttributesDescriptor("Line comment", FshSyntaxHighlighter.Companion.LINE_COMMENT),
    AttributesDescriptor("Block comment", FshSyntaxHighlighter.Companion.BLOCK_COMMENT)
)

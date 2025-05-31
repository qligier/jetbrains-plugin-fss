/*
 * Copyright 2025 Quentin Ligier. Use of this source code is governed by the MIT license.
 */
package ch.qligier.jetbrains.plugin.fss.ig_ini

import ch.qligier.jetbrains.plugin.fss.ig_ini.language.psi.IniProperty
import ch.qligier.jetbrains.plugin.fss.ig_ini.language.psi.IniSection
import ch.qligier.jetbrains.plugin.fss.ig_ini.language.psi.IniTypes
import com.intellij.codeInsight.completion.CompletionContributor
import com.intellij.codeInsight.completion.CompletionParameters
import com.intellij.codeInsight.completion.CompletionProvider
import com.intellij.codeInsight.completion.CompletionResultSet
import com.intellij.codeInsight.completion.CompletionType
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.patterns.PlatformPatterns
import com.intellij.psi.PsiElement
import com.intellij.psi.impl.source.tree.CompositeElement
import com.intellij.psi.impl.source.tree.LeafPsiElement
import com.intellij.psi.util.elementType
import com.intellij.util.ProcessingContext

/**
 * A contributor that provides completion variants for the ig.ini file.
 * @see [Completion Contributor](https://plugins.jetbrains.com/docs/intellij/completion-contributor.html)
 */
class IgIniCompletionContributor : CompletionContributor() {
    init {
        // Provide completion for keys
        this.extend(
            CompletionType.BASIC,
            PlatformPatterns.psiElement(IniTypes.PKEY),
            object : CompletionProvider<CompletionParameters?>() {
                public override fun addCompletions(
                    parameters: CompletionParameters,
                    context: ProcessingContext,
                    resultSet: CompletionResultSet
                ) {
                    resultSet.addElement(LookupElementBuilder.create(IgIniSpecs.IG_KEY_NAME))
                    resultSet.addElement(LookupElementBuilder.create(IgIniSpecs.TEMPLATE_KEY_NAME))
                }
            }
        )

        // Provide completion for values
        this.extend(
            CompletionType.BASIC,
            PlatformPatterns.psiElement(IniTypes.PVALUE),
            object : CompletionProvider<CompletionParameters?>() {
                public override fun addCompletions(
                    parameters: CompletionParameters,
                    context: ProcessingContext,
                    resultSet: CompletionResultSet
                ) {
                    if (parameters.position is LeafPsiElement) {
                        if (parameters.position.elementType !== IniTypes.PVALUE) {
                            return
                        }

                        // The leaf first parent is the IniKey, the second is the IniProperty (or a
                        // wrapping CompositeElement in some cases)
                        var parentPsi: PsiElement? = parameters.position.parent.parent
                        if (parentPsi is CompositeElement) {
                            parentPsi = parentPsi.psi
                        }

                        if (parentPsi is IniProperty) {
                            // Get the section name, if any
                            val sectionName: String? = (parentPsi.parent as? IniSection)?.getSectionName()
                            val keyName = parentPsi.getKeyName()

                            if (IgIniSpecs.IG_SECTION_NAME == sectionName) {
                                if (IgIniSpecs.TEMPLATE_KEY_NAME == keyName) {
                                    resultSet.addTemplateSuggestions()
                                }
                            }
                        }
                    }
                }
            }
        )

        // Provide completion for section names
        this.extend(
            CompletionType.BASIC,
            PlatformPatterns.psiElement(IniTypes.SECTION_NAME),
            object : CompletionProvider<CompletionParameters?>() {
                public override fun addCompletions(
                    parameters: CompletionParameters,
                    context: ProcessingContext,
                    resultSet: CompletionResultSet
                ) {
                    resultSet.addElement(LookupElementBuilder.create(IgIniSpecs.IG_SECTION_NAME))
                }
            }
        )
    }
}

private fun CompletionResultSet.addTemplateSuggestions() {
    // List from https://build.fhir.org/ig/FHIR/ig-guidance/
    this.addElement(LookupElementBuilder.create("fhir.base.template"))
    this.addElement(LookupElementBuilder.create("hl7.base.template"))
    this.addElement(LookupElementBuilder.create("hl7.fhir.template"))
    this.addElement(LookupElementBuilder.create("hl7.davinci.template"))
    this.addElement(LookupElementBuilder.create("hl7.cda.template"))
    this.addElement(LookupElementBuilder.create("hl7.other.template"))

    // List of the trusted templates
    // https://github.com/HL7/fhir-ig-publisher/blob/master/org.hl7.fhir.publisher.core/src/main/java/org/hl7/fhir/igtools/templates/TemplateManager.java#L244
    this.addElement(LookupElementBuilder.create("fhir.test.template"))
    this.addElement(LookupElementBuilder.create("hl7.au.base.template"))
    this.addElement(LookupElementBuilder.create("hl7.au.fhir.template"))
    this.addElement(LookupElementBuilder.create("hl7.utg.template"))
    this.addElement(LookupElementBuilder.create("hl7.be.fhir.template"))
    this.addElement(LookupElementBuilder.create("openhie.fhir.template"))
    this.addElement(LookupElementBuilder.create("who.fhir.template"))
    this.addElement(LookupElementBuilder.create("who.template.root"))
    this.addElement(LookupElementBuilder.create("hl7.davinci.template"))
    this.addElement(LookupElementBuilder.create("hl7.extensions.template"))
    this.addElement(LookupElementBuilder.create("ihe.fhir.template"))
    this.addElement(LookupElementBuilder.create("ch.fhir.ig.template"))
}

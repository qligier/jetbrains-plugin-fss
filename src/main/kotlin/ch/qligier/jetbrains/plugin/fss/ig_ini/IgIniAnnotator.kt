/*
 * Copyright 2025 Quentin Ligier. Use of this source code is governed by the MIT license.
 */
package ch.qligier.jetbrains.plugin.fss.ig_ini

import ch.qligier.jetbrains.plugin.fss.ig_ini.language.psi.IniFile
import ch.qligier.jetbrains.plugin.fss.ig_ini.language.psi.IniProperty
import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.lang.annotation.HighlightSeverity
import com.intellij.psi.PsiElement
import java.lang.String

/**
 * An annotator for the ig.ini file.
 *
 * @author Quentin Ligier
 * @see [Annotator](https://plugins.jetbrains.com/docs/intellij/annotator.html)
 */
class IgIniAnnotator : Annotator {
    /**
     * Annotates the specified PSI element. It is guaranteed to be executed in non-reentrant fashion. I.e there will be
     * no call of this method for this instance before previous call get completed. Multiple instances of the annotator
     * might exist simultaneously, though.
     *
     * @param element to annotate.
     * @param holder  the container which receives annotations created by the plugin.
     */
    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        if (element !is IniFile) {
            return
        }

        // Properties outside a section aren't supported by the IG Publisher
        for (property in element.getProperties()) {
            this.createWarningForUnsupportedProperty(holder, property)
        }

        var sectionIgFound = false
        for (section in element.getSections()) {
            if (IgIniSpecs.IG_SECTION_NAME != section.getSectionName()) {
                holder.newAnnotation(
                    HighlightSeverity.WEAK_WARNING,
                    String.format(
                        "The section '%s' is not supported by the IG Publisher",
                        section.getSectionName()
                    )
                )
                    .range(section.firstChild ?: section)
                    .create()
                continue
            }

            sectionIgFound = true

            var propertyTemplateFound = false
            var propertyIgFound = false
            for (property in section.getProperties()) {
                val keyName = property.getKeyName()
                if (keyName == null) {
                    continue
                }
                when (keyName) {
                    IgIniSpecs.TEMPLATE_KEY_NAME -> propertyTemplateFound = true
                    IgIniSpecs.IG_KEY_NAME -> propertyIgFound = true
                    else -> this.createWarningForUnsupportedProperty(holder, property)
                }
            }

            if (!propertyIgFound) {
                holder.newAnnotation(
                    HighlightSeverity.ERROR,
                    "The property '${IgIniSpecs.IG_KEY_NAME}' is not defined in the file"
                )
                    .range(section.firstChild)
                    .create()
            }
            if (!propertyTemplateFound) {
                holder.newAnnotation(
                    HighlightSeverity.ERROR,
                    "The property '${IgIniSpecs.TEMPLATE_KEY_NAME}' is not defined in the file"
                )
                    .range(section.firstChild)
                    .create()
            }
        }

        if (!sectionIgFound) {
            holder.newAnnotation(
                HighlightSeverity.ERROR,
                String.format(
                    "The section '%s' is not defined in the file",
                    IgIniSpecs.IG_SECTION_NAME
                )
            )
                .range(element)
                .create()
        }
    }

    private fun createWarningForUnsupportedProperty(
        holder: AnnotationHolder,
        property: IniProperty
    ) {
        val keyElement: PsiElement? = property.getKeyElement()
        holder.newAnnotation(
            HighlightSeverity.WEAK_WARNING,
            "The property '${property.getKeyName()}' is not supported by the IG Publisher",
        )
            .range(keyElement ?: property)
            .create()
    }
}

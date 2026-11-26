/*
 * Copyright 2025 Quentin Ligier. Use of this source code is governed by the MIT license.
 */

package ch.qligier.jetbrains.plugin.fss.igini

import ch.qligier.jetbrains.plugin.fss.igini.language.psi.IniFile
import ch.qligier.jetbrains.plugin.fss.igini.language.psi.IniProperty
import com.intellij.codeInspection.InspectionManager
import com.intellij.codeInspection.LocalInspectionTool
import com.intellij.codeInspection.ProblemDescriptor
import com.intellij.codeInspection.ProblemsHolder
import com.intellij.openapi.project.DumbAware
import com.intellij.psi.PsiFile

/**
 * Base class of the 'ig.ini' inspections. Their severity is configured in plugin.xml and can be changed by the user.
 * @see [Code Inspections](https://plugins.jetbrains.com/docs/intellij/code-inspections.html)
 */
abstract class IgIniInspectionBase :
    LocalInspectionTool(),
    DumbAware {
    final override fun checkFile(
        file: PsiFile,
        manager: InspectionManager,
        isOnTheFly: Boolean,
    ): Array<ProblemDescriptor>? {
        if (file !is IniFile) return null
        val holder = ProblemsHolder(manager, file, isOnTheFly)
        check(file, holder)
        return holder.resultsArray
    }

    protected abstract fun check(
        file: IniFile,
        holder: ProblemsHolder,
    )
}

/**
 * Reports a missing '[IG]' section, or a missing 'ig' or 'template' property in it.
 */
class IgIniMissingRequiredEntryInspection : IgIniInspectionBase() {
    override fun check(
        file: IniFile,
        holder: ProblemsHolder,
    ) {
        val igSections = file.getSections().filter { it.getSectionName() == IgIniSpecs.IG_SECTION_NAME }
        if (igSections.isEmpty()) {
            holder.registerProblem(file, "The section '${IgIniSpecs.IG_SECTION_NAME}' is not defined in the file")
            return
        }
        for (section in igSections) {
            val keys = section.getProperties().mapNotNull { it.getKeyName() }.toSet()
            for (required in listOf(IgIniSpecs.IG_KEY_NAME, IgIniSpecs.TEMPLATE_KEY_NAME)) {
                if (required !in keys) {
                    holder.registerProblem(
                        section.firstChild ?: section,
                        "The property '$required' is not defined in the file",
                    )
                }
            }
        }
    }
}

/**
 * Reports sections other than '[IG]', which the IG Publisher ignores.
 */
class IgIniUnsupportedSectionInspection : IgIniInspectionBase() {
    override fun check(
        file: IniFile,
        holder: ProblemsHolder,
    ) {
        for (section in file.getSections()) {
            if (section.getSectionName() != IgIniSpecs.IG_SECTION_NAME) {
                holder.registerProblem(
                    section.firstChild ?: section,
                    "The section '${section.getSectionName()}' is not supported by the IG Publisher",
                )
            }
        }
    }
}

/**
 * Reports properties outside any section, and properties of the '[IG]' section other than 'ig' and 'template'.
 */
class IgIniUnsupportedPropertyInspection : IgIniInspectionBase() {
    override fun check(
        file: IniFile,
        holder: ProblemsHolder,
    ) {
        file.getProperties().forEach { register(holder, it) }
        file
            .getSections()
            .filter { it.getSectionName() == IgIniSpecs.IG_SECTION_NAME }
            .flatMap { it.getProperties() }
            .filter { val key = it.getKeyName(); key != null && key != IgIniSpecs.IG_KEY_NAME && key != IgIniSpecs.TEMPLATE_KEY_NAME }
            .forEach { register(holder, it) }
    }

    private fun register(
        holder: ProblemsHolder,
        property: IniProperty,
    ) {
        holder.registerProblem(
            property.getKeyElement() ?: property,
            "The property '${property.getKeyName()}' is not supported by the IG Publisher",
        )
    }
}

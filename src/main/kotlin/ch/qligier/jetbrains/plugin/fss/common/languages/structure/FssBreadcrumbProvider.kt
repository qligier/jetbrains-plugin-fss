/*
 * Copyright 2026 Quentin Ligier. Use of this source code is governed by the MIT license.
 */

package ch.qligier.jetbrains.plugin.fss.common.languages.structure

import ch.qligier.jetbrains.plugin.fss.fsh.FshLanguage
import ch.qligier.jetbrains.plugin.fss.fsh.language.psi.FshEntity
import ch.qligier.jetbrains.plugin.fss.igini.IgIniLanguage
import ch.qligier.jetbrains.plugin.fss.igini.language.psi.IniProperty
import ch.qligier.jetbrains.plugin.fss.igini.language.psi.IniSection
import ch.qligier.jetbrains.plugin.fss.sushiconfig.SushiConfigLanguage
import com.intellij.lang.Language
import com.intellij.openapi.util.NlsSafe
import com.intellij.psi.PsiElement
import com.intellij.ui.breadcrumbs.BreadcrumbsProvider

/**
 * A breadcrumb provider for the whole plugin, that will be used for all the languages.
 *
 * @see [Breadcrumbs](https://plugins.jetbrains.com/docs/intellij/additional-minor-features.html#breadcrumbs)
 * @author Quentin Ligier
 **/
class FssBreadcrumbProvider : BreadcrumbsProvider {
    override fun getLanguages(): Array<out Language> = arrayOf(FshLanguage, IgIniLanguage, SushiConfigLanguage)

    override fun acceptElement(element: PsiElement): Boolean =
        element is FshEntity ||
            element is IniSection ||
            element is IniProperty

    override fun getElementInfo(element: PsiElement): @NlsSafe String =
        when (element) {
            // FSH
            is FshEntity -> "${element.getEntityType()}: ${element.name}"

            // IgIni
            is IniSection -> "Section: ${element.sectionName}"

            is IniProperty -> "property: ${element.keyName}"

            else -> ""
        }
}

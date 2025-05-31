/*
 * Copyright 2025 Quentin Ligier. Use of this source code is governed by the MIT license.
 */
package ch.qligier.jetbrains.plugin.fss.ig_ini.language.psi.impl

import ch.qligier.jetbrains.plugin.fss.ig_ini.language.psi.IniFile
import ch.qligier.jetbrains.plugin.fss.ig_ini.language.psi.IniKey
import ch.qligier.jetbrains.plugin.fss.ig_ini.language.psi.IniProperty
import ch.qligier.jetbrains.plugin.fss.ig_ini.language.psi.IniSection
import ch.qligier.jetbrains.plugin.fss.ig_ini.language.psi.IniTypes
import com.intellij.psi.util.PsiTreeUtil

object IniPsiImplUtil {
    @JvmStatic
    fun getSections(file: IniFile?): MutableList<IniSection> {
        return PsiTreeUtil.getChildrenOfTypeAsList(file, IniSection::class.java)
    }

    @JvmStatic
    fun getProperties(file: IniFile?): MutableList<IniProperty> {
        return PsiTreeUtil.getChildrenOfTypeAsList(file, IniProperty::class.java)
    }

    @JvmStatic
    fun getKeyElement(element: IniProperty?): IniKey? {
        return PsiTreeUtil.getChildOfType(element, IniKey::class.java)
    }

    @JvmStatic
    fun getKeyName(element: IniProperty): String? = element.node.findChildByType(IniTypes.KEY)?.text

    @JvmStatic
    fun getSectionName(element: IniSection): String? = element.node.findChildByType(IniTypes.SECTION_NAME)?.text

    @JvmStatic
    fun getProperties(section: IniSection?): MutableList<IniProperty> {
        return PsiTreeUtil.getChildrenOfTypeAsList(section, IniProperty::class.java)
    }
}

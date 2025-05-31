/*
 * Copyright 2025 Quentin Ligier. Use of this source code is governed by the MIT license.
 */
package ch.qligier.jetbrains.plugin.fss.ig_ini.language.psi

import ch.qligier.jetbrains.plugin.fss.ig_ini.IG_INI_FILE_TYPE
import ch.qligier.jetbrains.plugin.fss.ig_ini.IgIniLanguage
import ch.qligier.jetbrains.plugin.fss.ig_ini.language.psi.impl.IniPsiImplUtil
import com.intellij.extapi.psi.PsiFileBase
import com.intellij.openapi.fileTypes.FileType
import com.intellij.psi.FileViewProvider

class IniFile(viewProvider: FileViewProvider) : PsiFileBase(viewProvider, IgIniLanguage) {
    override fun getFileType(): FileType {
        return IG_INI_FILE_TYPE
    }

    override fun toString(): String {
        return "ig.ini file"
    }

    fun getSections(): List<IniSection> = IniPsiImplUtil.getSections(this)

    fun getProperties(): List<IniProperty> = IniPsiImplUtil.getProperties(this)
}

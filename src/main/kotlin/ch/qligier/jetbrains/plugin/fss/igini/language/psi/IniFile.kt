/*
 * Copyright 2025 Quentin Ligier. Use of this source code is governed by the MIT license.
 */

package ch.qligier.jetbrains.plugin.fss.igini.language.psi

import ch.qligier.jetbrains.plugin.fss.igini.IgIniFileType
import ch.qligier.jetbrains.plugin.fss.igini.IgIniLanguage
import ch.qligier.jetbrains.plugin.fss.igini.language.psi.impl.IniPsiImplUtil
import com.intellij.extapi.psi.PsiFileBase
import com.intellij.openapi.fileTypes.FileType
import com.intellij.psi.FileViewProvider

class IniFile(viewProvider: FileViewProvider) : PsiFileBase(viewProvider, IgIniLanguage) {
    override fun getFileType(): FileType = IgIniFileType.INSTANCE

    override fun toString(): String = "ig.ini file"

    fun getSections(): List<IniSection> = IniPsiImplUtil.getSections(this)

    fun getProperties(): List<IniProperty> = IniPsiImplUtil.getProperties(this)
}

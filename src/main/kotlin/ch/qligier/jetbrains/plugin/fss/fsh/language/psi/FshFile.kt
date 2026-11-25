/*
 * Copyright 2026 Quentin Ligier. Use of this source code is governed by the MIT license.
 */
package ch.qligier.jetbrains.plugin.fss.fsh.language.psi

import ch.qligier.jetbrains.plugin.fss.fsh.FshFileType
import ch.qligier.jetbrains.plugin.fss.fsh.FshLanguage
import com.intellij.extapi.psi.PsiFileBase
import com.intellij.openapi.fileTypes.FileType
import com.intellij.psi.FileViewProvider
import com.intellij.psi.util.PsiTreeUtil

class FshFile(
    viewProvider: FileViewProvider,
) : PsiFileBase(viewProvider, FshLanguage) {
    override fun getFileType(): FileType = FshFileType.INSTANCE

    override fun toString(): String = "FSH File"

    /** The entities of the file, in order (from the stub tree when the file is not parsed). */
    fun getEntities(): List<FshNamedElement> = PsiTreeUtil.getStubChildrenOfTypeAsList(this, FshNamedElement::class.java)

    /** The entities of one kind. */
    fun getEntities(kind: FshEntityKind): List<FshNamedElement> = getEntities().filter { it.getEntityKind() == kind }
}

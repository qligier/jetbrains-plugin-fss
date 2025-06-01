// Copyright 2025 Quentin Ligier. Use of this source code is governed by the MIT license.
package ch.qligier.jetbrains.plugin.fss.fsh.psi

import ch.qligier.jetbrains.plugin.fss.fsh.FshFileType.Companion.INSTANCE
import ch.qligier.jetbrains.plugin.fss.fsh.FshLanguage
import com.intellij.extapi.psi.PsiFileBase
import com.intellij.openapi.fileTypes.FileType
import com.intellij.psi.FileViewProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNamedElement
import org.antlr.intellij.adaptor.psi.ScopeNode

class FshPsiFile(viewProvider: FileViewProvider) : PsiFileBase(viewProvider, FshLanguage), ScopeNode {
    /**
     * Returns the file type for the file.
     *
     * @return the file type instance.
     */
    override fun getFileType(): FileType {
        return INSTANCE
    }

    /**
     * @param element
     * @return
     */
    override fun resolve(element: PsiNamedElement?): PsiElement? {
        //TODO
        return null
    }

    /**
     * Return null since a file scope has no enclosing scope. It is not itself in a scope.
     */
    override fun getContext(): ScopeNode? {
        return null
    }
}

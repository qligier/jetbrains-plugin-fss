/*
 * Copyright 2026 Quentin Ligier. Use of this source code is governed by the MIT license.
 */

package ch.qligier.jetbrains.plugin.fss.fsh.structure

import ch.qligier.jetbrains.plugin.fss.fsh.language.psi.FshNamedElement
import com.intellij.ide.structureView.StructureViewModel
import com.intellij.ide.structureView.StructureViewModelBase
import com.intellij.ide.structureView.StructureViewTreeElement
import com.intellij.ide.util.treeView.smartTree.Sorter
import com.intellij.openapi.editor.Editor
import com.intellij.psi.PsiFile

class FshStructureViewModel :
    StructureViewModelBase,
    StructureViewModel.ElementInfoProvider {
    constructor(psiFile: PsiFile, editor: Editor?) :
        super(psiFile, editor, FshStructureViewElement(psiFile)) {
        withSorters(Sorter.ALPHA_SORTER)
        withSuitableClasses(FshNamedElement::class.java)
    }

    override fun isAlwaysShowsPlus(element: StructureViewTreeElement): Boolean = false

    override fun isAlwaysLeaf(element: StructureViewTreeElement): Boolean = element.value is FshNamedElement
}

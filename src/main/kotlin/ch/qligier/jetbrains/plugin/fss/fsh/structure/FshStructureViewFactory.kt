/*
 * Copyright 2026 Quentin Ligier. Use of this source code is governed by the MIT license.
 */

package ch.qligier.jetbrains.plugin.fss.fsh.structure

import com.intellij.ide.structureView.StructureViewBuilder
import com.intellij.ide.structureView.StructureViewModel
import com.intellij.ide.structureView.TreeBasedStructureViewBuilder
import com.intellij.lang.PsiStructureViewFactory
import com.intellij.openapi.editor.Editor
import com.intellij.psi.PsiFile

/**
 * Factory for creating a structure view for FSH files.
 * This fills the "Structure" tool window with a tree representation of the FSH file's structure, allowing users to
 * navigate and understand the file's contents more easily.
 *
 * @see [Structure View](https://plugins.jetbrains.com/docs/intellij/structure-view.html)
 * @see [Structure View Factory](https://plugins.jetbrains.com/docs/intellij/structure-view-factory.html)
 */
internal class FshStructureViewFactory : PsiStructureViewFactory {
    override fun getStructureViewBuilder(psiFile: PsiFile): StructureViewBuilder =
        object : TreeBasedStructureViewBuilder() {
            override fun createStructureViewModel(editor: Editor?): StructureViewModel = FshStructureViewModel(psiFile, editor)
        }
}

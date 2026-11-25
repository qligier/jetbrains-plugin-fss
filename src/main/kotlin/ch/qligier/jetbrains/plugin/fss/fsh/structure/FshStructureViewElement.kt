/*
 * Copyright 2026 Quentin Ligier. Use of this source code is governed by the MIT license.
 */

package ch.qligier.jetbrains.plugin.fss.fsh.structure

import ch.qligier.jetbrains.plugin.fss.fsh.language.psi.FshFile
import com.intellij.ide.projectView.PresentationData
import com.intellij.ide.structureView.StructureViewTreeElement
import com.intellij.ide.util.treeView.smartTree.SortableTreeElement
import com.intellij.ide.util.treeView.smartTree.TreeElement
import com.intellij.navigation.ItemPresentation
import com.intellij.psi.NavigatablePsiElement

/**
 * The {@link StructureViewTreeElement} represents an element in the Structure View tree model. The
 * {@link SortableTreeElement} represents an item in a smart tree that allows using text other than the presentable text
 * as a key for alphabetic sorting.
 *
 * @author Quentin Ligier
 **/
class FshStructureViewElement(
    private val element: NavigatablePsiElement,
) : StructureViewTreeElement,
    SortableTreeElement {
    override fun getValue(): Any = element

    override fun getPresentation(): ItemPresentation = element.presentation ?: PresentationData()

    override fun getChildren(): Array<out TreeElement> {
        if (element is FshFile) {
            return element.getEntities().map { FshStructureViewElement(it) }.toTypedArray()
        }
        return emptyArray()
    }

    override fun getAlphaSortKey(): String = element.name ?: ""

    override fun navigate(requestFocus: Boolean) = element.navigate(requestFocus)

    override fun canNavigate(): Boolean = element.canNavigate()
}

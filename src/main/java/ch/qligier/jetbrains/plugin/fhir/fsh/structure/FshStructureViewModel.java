// Copyright 2022 Quentin Ligier. Use of this source code is governed by the MIT license.

package ch.qligier.jetbrains.plugin.fhir.fsh.structure;

import ch.qligier.jetbrains.plugin.fhir.fsh.parser.psi.FshItem;
import com.intellij.ide.structureView.StructureViewModel;
import com.intellij.ide.structureView.StructureViewModelBase;
import com.intellij.ide.structureView.StructureViewTreeElement;
import com.intellij.ide.util.treeView.smartTree.Sorter;
import com.intellij.openapi.editor.Editor;
import com.intellij.psi.PsiFile;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Defines the model for data displayed in the standard structure view. It also extends StructureViewModelBase, an
 * implementation that links the model to a text editor.
 *
 * @author Quentin Ligier
 * @see <a
 * href="https://plugins.jetbrains.com/docs/intellij/structure-view-factory.html#define-a-structure-view-model">Define a
 * Structure View Model</a>
 **/
public class FshStructureViewModel extends StructureViewModelBase implements StructureViewModel.ElementInfoProvider {

    public FshStructureViewModel(@NotNull final PsiFile psiFile,
                                 @Nullable final Editor editor) {
        super(psiFile, editor, new FshStructureViewElement(psiFile));
    }

    /**
     * @param element
     * @return
     */
    @Override
    public boolean isAlwaysShowsPlus(final StructureViewTreeElement element) {
        return false;
    }

    /**
     * @param element
     * @return
     */
    @Override
    public boolean isAlwaysLeaf(final StructureViewTreeElement element) {
        return element instanceof FshItem;
    }

    /**
     * @return
     */
    @Override
    public Sorter @NotNull [] getSorters() {
        return new Sorter[]{Sorter.ALPHA_SORTER};
    }

    @Override
    protected Class<?> @NotNull [] getSuitableClasses() {
        return new Class[]{FshItem.class};
    }
}

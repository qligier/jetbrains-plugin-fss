// Copyright 2022 Quentin Ligier. Use of this source code is governed by the MIT license.

package ch.qligier.jetbrains.plugin.fhir.fsh.structure;

import com.intellij.ide.structureView.StructureViewBuilder;
import com.intellij.ide.structureView.StructureViewModel;
import com.intellij.ide.structureView.TreeBasedStructureViewBuilder;
import com.intellij.lang.PsiStructureViewFactory;
import com.intellij.openapi.editor.Editor;
import com.intellij.psi.PsiFile;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Creating a structure view factory allows showing the structure of any file in the Structure Tool Window for easy
 * navigation between items in the current editor.
 *
 * @author Quentin Ligier
 * @see <a href="https://plugins.jetbrains.com/docs/intellij/structure-view.html">Structure View</a>
 * @see <a href="https://plugins.jetbrains.com/docs/intellij/structure-view-factory.html">Structure View Factory</a>
 **/
public class FshStructureViewFactory implements PsiStructureViewFactory {

    /**
     * @param psiFile
     * @return
     */
    @Override
    public @Nullable StructureViewBuilder getStructureViewBuilder(@NotNull final PsiFile psiFile) {
        return new TreeBasedStructureViewBuilder() {
            @NotNull
            @Override
            public StructureViewModel createStructureViewModel(@Nullable final Editor editor) {
                return new FshStructureViewModel(psiFile, editor);
            }
        };
    }
}

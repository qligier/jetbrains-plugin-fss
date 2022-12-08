// Copyright 2022 Quentin Ligier. Use of this source code is governed by the MIT license.

package ch.qligier.jetbrains.plugin.fhir.fsh.structure;

import ch.qligier.jetbrains.plugin.fhir.fsh.parser.psi.FshFile;
import ch.qligier.jetbrains.plugin.fhir.fsh.parser.psi.impl.FshItemImpl;
import com.intellij.ide.projectView.PresentationData;
import com.intellij.ide.structureView.StructureViewTreeElement;
import com.intellij.ide.util.treeView.smartTree.SortableTreeElement;
import com.intellij.ide.util.treeView.smartTree.TreeElement;
import com.intellij.navigation.ItemPresentation;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.psi.NavigatablePsiElement;
import com.intellij.util.OpenSourceUtil;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

/**
 * The {@link StructureViewTreeElement} represents an element in the Structure View tree model. The
 * {@link SortableTreeElement} represents an item in a smart tree that allows using text other than the presentable text
 * as a key for alphabetic sorting.
 *
 * @author Quentin Ligier
 **/
public class FshStructureViewElement implements StructureViewTreeElement, SortableTreeElement {

    private final NavigatablePsiElement element;

    public FshStructureViewElement(@NotNull final NavigatablePsiElement element) {
        this.element = element;
    }

    /**
     * Returns the data object (usually a PSI element) corresponding to the structure view element.
     *
     * @return the data object instance.
     */
    @Override
    public Object getValue() {
        return this.element;
    }

    /**
     * @return
     */
    @Override
    public @NotNull String getAlphaSortKey() {
        return Objects.requireNonNullElse(this.element.getName(), "");
    }

    /**
     * Returns the presentation of the tree element.
     *
     * @return the element presentation.
     */
    @Override
    public @NotNull ItemPresentation getPresentation() {
        final var presentation = this.element.getPresentation();
        return presentation != null ? presentation : new PresentationData();
    }

    /**
     * Returns the list of children of the tree element.
     *
     * @return the list of children.
     */
    @Override
    public TreeElement @NotNull [] getChildren() {
        if (this.element instanceof FshFile) {
            return ((FshFile) this.element).getItems().stream()
                    .map(item -> new FshStructureViewElement((FshItemImpl) item))
                    .toArray(TreeElement[]::new);
        }
        return new TreeElement[0];
    }

    /**
     * Open editor and select/navigate to the object there if possible. Just do nothing if navigation is not possible
     * like in case of a package
     *
     * @param requestFocus {@code true} if focus requesting is necessary
     */
    @Override
    public void navigate(final boolean requestFocus) {
        this.element.navigate(requestFocus);
    }

    /**
     * Indicates whether this instance supports navigation of any kind. Usually this method is called to ensure that
     * navigation is possible. Note that it is not called if navigation to source is supported, i.e.
     * {@link #canNavigateToSource()} returns {@code true}. We assume that this method should return {@code true} in
     * such case, so implement this method respectively.
     *
     * @return {@code false} if navigation is not possible for any reason.
     */
    @Override
    public boolean canNavigate() {
        return this.element.canNavigate();
    }

    /**
     * Indicates whether this instance supports navigation to source (that means some kind of editor). Note that
     * navigation can be supported even if this method returns {@code false}. In such cases it is not recommended to do
     * batch navigation for all navigatables available via {@link CommonDataKeys#NAVIGATABLE_ARRAY}, because it may lead
     * to opening several modal dialogs. Use {@link OpenSourceUtil#navigate} to process such arrays correctly.
     *
     * @return {@code false} if navigation to source is not possible for any reason.
     */
    @Override
    public boolean canNavigateToSource() {
        return this.element.canNavigateToSource();
    }
}

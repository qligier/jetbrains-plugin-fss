// Copyright 2022 Quentin Ligier. Use of this source code is governed by the MIT license.

package ch.qligier.jetbrains.plugin.fhir.fsh;

import ch.qligier.jetbrains.plugin.fhir.fsh.parser.psi.FshFile;
import com.intellij.lang.ASTNode;
import com.intellij.lang.folding.FoldingBuilderEx;
import com.intellij.lang.folding.FoldingDescriptor;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.project.DumbAware;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;

/**
 * Allows this plugin to define rules for folding code in the FSH language.
 *
 * @author Quentin Ligier
 * @see <a href="https://plugins.jetbrains.com/docs/intellij/folding-builder.html">Folding Builder</a>
 **/
public class FshFoldingBuilder extends FoldingBuilderEx implements DumbAware {
    public static final Logger LOG = Logger.getInstance("FshFoldingBuilder");

    /**
     * Returns the text which is displayed in the editor for the folding region related to the specified node when the
     * folding region is collapsed.
     *
     * @param node the node for which the placeholder text is requested.
     * @return the placeholder text.
     */
    @Override
    public @Nullable String getPlaceholderText(@NotNull final ASTNode node) {
        return null;
    }

    /**
     * Builds the folding regions for the specified node in the AST tree and its children.
     *
     * @param root     the element for which folding is requested.
     * @param document the document for which folding is built. Can be used to retrieve line numbers for folding
     *                 regions.
     * @param quick    whether the result should be provided as soon as possible. Is true, when an editor is opened and
     *                 we need to auto-fold something immediately, like Java imports. If true, one should perform no
     *                 reference resolving and avoid complex checks if possible.
     * @return the array of folding descriptors.
     */
    @Override
    public FoldingDescriptor @NotNull [] buildFoldRegions(@NotNull final PsiElement root,
                                                          @NotNull final Document document,
                                                          final boolean quick) {
        if (!(root instanceof FshFile)) {
            LOG.warn("PsiElement is not an instance of FshPsiFileBase, unable to build fold regions");
            return new FoldingDescriptor[0];
        }
        final var descriptors = new ArrayList<FoldingDescriptor>(1);
        final var fshFile = (FshFile) root;
        /*for (final var item : fshFile.getItems()) {
            if (item instanceof FshAliasItem) {
                // No need to fold an alias declaration
                continue;
            }
            descriptors.add(new FoldingDescriptor(item,
                                                  item.getTextRange().getStartOffset(),
                                                  item.getTextRange().getEndOffset(),
                                                  null,
                                                  item.getFoldedPlaceholder()));
        }*/
        return descriptors.toArray(new FoldingDescriptor[0]);
    }

    /**
     * Returns the default collapsed state for the folding region related to the specified node.
     *
     * @param node the node for which the collapsed state is requested.
     * @return true if the region is collapsed by default, false otherwise.
     */
    @Override
    public boolean isCollapsedByDefault(@NotNull final ASTNode node) {
        return false;
    }
}

// Copyright 2024 Quentin Ligier. Use of this source code is governed by the MIT license.

package ch.qligier.jetbrains.plugin.fhir.fsh.psi.entity;

import ch.qligier.jetbrains.plugin.fhir.fsh.specification.ItemType;
import ch.qligier.jetbrains.plugin.fhir.fsh.specification.KeywordPolicy;
import com.intellij.lang.ASTNode;
import org.antlr.intellij.adaptor.psi.ANTLRPsiNode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * PSI element representing an abstract FSH item. It will be extended for each item type.
 *
 * @author Quentin Ligier
 **/
public abstract class FshPsiItem extends ANTLRPsiNode {

    protected @Nullable String itemName;

    protected FshPsiItem(@NotNull final ASTNode node) {
        super(node);
        this.itemName = this.extractItemName(node);
    }

    /**
     * Returns the type of the item.
     */
    public abstract @NotNull ItemType getItemType();

    /**
     * Returns the keyword policy of the item.
     */
    public @NotNull KeywordPolicy getKeywordPolicy() {
        return this.getItemType().getKeywordPolicy();
    }

    /**
     * Returns the name of the item, as defined in the FSH source, or {@code null} if the item has no name.
     */
    public @Nullable String getItemName() {
        return this.itemName;
    }

    /**
     * Extracts the name of the item from the specified node.
     */
    protected abstract @Nullable String extractItemName(final @NotNull ASTNode node);

    // getKeywords

    // getRules
}

// Copyright 2024 Quentin Ligier. Use of this source code is governed by the MIT license.

package ch.qligier.jetbrains.plugin.fhir.fsh.psi.entity;

import ch.qligier.jetbrains.plugin.fhir.fsh.psi.FshPsiAntlrNode;
import ch.qligier.jetbrains.plugin.fhir.fsh.specification.ItemType;
import ch.qligier.jetbrains.plugin.fhir.fsh.specification.KeywordPolicy;
import com.intellij.lang.ASTNode;
import org.jspecify.annotations.Nullable;

/**
 * PSI element representing an abstract FSH item. It will be extended for each item type.
 *
 * @author Quentin Ligier
 **/
public abstract class FshPsiItem extends FshPsiAntlrNode {

    protected FshPsiItem(final ASTNode node) {
        super(node);
    }

    /**
     * Returns the type of the item.
     */
    public abstract ItemType getItemType();

    /**
     * Returns the keyword policy of the item.
     */
    public KeywordPolicy getKeywordPolicy() {
        return this.getItemType().getKeywordPolicy();
    }

    /**
     * Returns the name of the item, as defined in the FSH source, or {@code null} if the item has no name.
     */
    public abstract @Nullable String getItemName();

    // getKeywords

    // getRules
}

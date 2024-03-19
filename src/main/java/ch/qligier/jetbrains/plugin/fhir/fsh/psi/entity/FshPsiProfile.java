// Copyright 2024 Quentin Ligier. Use of this source code is governed by the MIT license.

package ch.qligier.jetbrains.plugin.fhir.fsh.psi.entity;

import ch.qligier.jetbrains.plugin.fhir.fsh.specification.ItemType;
import com.intellij.lang.ASTNode;
import org.jspecify.annotations.Nullable;

/**
 * PSI element representing a profile in an FSH file.
 *
 * @author Quentin Ligier
 **/
public class FshPsiProfile extends FshPsiItem {

    public FshPsiProfile(final ASTNode node) {
        super(node);
    }

    /**
     * Returns the type of the item.
     */
    @Override
    public ItemType getItemType() {
        return ItemType.PROFILE;
    }

    /**
     * Returns the name of the item, as defined in the FSH source, or {@code null} if the item has no name.
     */
    @Override
    public @Nullable String getItemName() {
        return null;
    }
}

// Copyright 2025 Quentin Ligier. Use of this source code is governed by the MIT license.
package ch.qligier.jetbrains.plugin.fss.fsh.psi.entity

import ch.qligier.jetbrains.plugin.fss.fsh.specs.ItemType
import com.intellij.lang.ASTNode

/**
 * PSI element representing a profile in an FSH file.
 */
class FshPsiProfile(node: ASTNode) : FshPsiItem(node) {
    /**
     * Returns the type of the item.
     */
    override fun getItemType(): ItemType {
        return ItemType.PROFILE
    }

    /**
     * Returns the name of the item, as defined in the FSH source, or `null` if the item has no name.
     */
    override fun getItemName(): String? {
        return null
    }
}

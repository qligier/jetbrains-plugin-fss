// Copyright 2025 Quentin Ligier. Use of this source code is governed by the MIT license.
package ch.qligier.jetbrains.plugin.fss.fsh.psi.entity

import ch.qligier.jetbrains.plugin.fss.fsh.psi.FshPsiAntlrNode
import ch.qligier.jetbrains.plugin.fss.fsh.specs.ItemType
import ch.qligier.jetbrains.plugin.fss.fsh.specs.KeywordPolicy
import com.intellij.lang.ASTNode

/**
 * PSI element representing an abstract FSH item. It will be extended for each item type.
 */
abstract class FshPsiItem protected constructor(node: ASTNode) : FshPsiAntlrNode(node) {
    /**
     * Returns the type of the item.
     */
    abstract fun getItemType(): ItemType

    /**
     * Returns the name of the item, as defined in the FSH source, or `null` if the item has no name.
     */
    abstract fun getItemName(): String?

    /**
     * Returns the keyword policy of the item.
     */
    fun getKeywordPolicy(): KeywordPolicy {
        return getItemType().keywordPolicy
    }

    // getKeywords

    // getRules
}

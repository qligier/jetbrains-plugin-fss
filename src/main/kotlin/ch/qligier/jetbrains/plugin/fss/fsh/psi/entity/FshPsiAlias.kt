// Copyright 2025 Quentin Ligier. Use of this source code is governed by the MIT license.
package ch.qligier.jetbrains.plugin.fss.fsh.psi.entity

import ch.qligier.jetbrains.plugin.fss.fsh.FshLanguage
import ch.qligier.jetbrains.plugin.fss.fsh.antlr.FSHLexer
import ch.qligier.jetbrains.plugin.fss.fsh.specs.ItemType
import com.intellij.lang.ASTNode
import org.antlr.intellij.adaptor.lexer.PSIElementTypeFactory

/**
 * PSI element representing an alias in an FSH file.
 */
class FshPsiAlias(node: ASTNode) : FshPsiItem(node) {
    override fun getItemType(): ItemType {
        return ItemType.ALIAS
    }

    override fun getItemName(): String? {
        return this.node.text //TODO get from name
    }

    val aliasValue: String?
        get() {
            val type =
                PSIElementTypeFactory.getTokenIElementTypes(FshLanguage)[FSHLexer.SEQUENCE]
            val child = this.node.findChildByType(type)
            return child?.text
        }

    override fun toString(): String {
        return "FshPsiAlias(${this.getItemName()}, ${this.aliasValue})"
    }
}

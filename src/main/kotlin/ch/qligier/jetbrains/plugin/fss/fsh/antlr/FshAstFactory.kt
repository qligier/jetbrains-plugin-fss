/*
 * Copyright 2025 Quentin Ligier. Use of this source code is governed by the MIT license.
 */

package ch.qligier.jetbrains.plugin.fss.fsh.antlr

import com.intellij.lang.DefaultASTFactoryImpl
import com.intellij.psi.impl.source.tree.CompositeElement
import com.intellij.psi.impl.source.tree.LeafElement
import com.intellij.psi.tree.IElementType
import com.jetbrains.rd.util.getLogger
import com.jetbrains.rd.util.info
import org.antlr.intellij.adaptor.lexer.TokenIElementType

class FshAstFactory : DefaultASTFactoryImpl() {
    override fun createComposite(type: IElementType): CompositeElement {
        return super.createComposite(type)
    }

    override fun createLeaf(
        type: IElementType,
        text: CharSequence
    ): LeafElement {
        if (type is TokenIElementType && type.antlrTokenType == FSHLexer.CANONICAL) {
            getLogger(FshAstFactory::class).info { "Got a canonical" }
        }
        return super.createLeaf(type, text)
    }
}

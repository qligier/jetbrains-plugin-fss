/*
 * Copyright 2025 Quentin Ligier. Use of this source code is governed by the MIT license.
 */

package ch.qligier.jetbrains.plugin.fss.fsh.antlr

import ch.qligier.jetbrains.plugin.fss.fsh.FshLanguage
import com.intellij.lang.ASTNode
import com.intellij.lang.PsiBuilder
import com.intellij.psi.impl.source.tree.FileElement
import com.intellij.psi.tree.IElementType
import com.intellij.psi.tree.IFileElementType
import org.antlr.intellij.adaptor.parser.ANTLRParserAdaptor
import org.antlr.v4.runtime.Parser
import org.antlr.v4.runtime.tree.ParseTree

class FshParserAdapter : ANTLRParserAdaptor(FshLanguage, FSHParser(null)) {
    override fun parse(
        parser: Parser,
        root: IElementType,
    ): ParseTree {
        require(parser is FSHParser) { "Parser must be an instance of FSHParser" }

        // start rule depends on root passed in; sometimes we want to create an ID node etc…
        if (root is IFileElementType) {
            return parser.doc()
        }

        // let's hope it's an ID as needed by "rename function"
        return parser.profile()
    }

    override fun parse(
        root: IElementType,
        builder: PsiBuilder
    ): ASTNode {
        val node = super.parse(root, builder)

        if (node is FileElement) {
            // todo: work on the AST here?
        }

        return node
    }
}

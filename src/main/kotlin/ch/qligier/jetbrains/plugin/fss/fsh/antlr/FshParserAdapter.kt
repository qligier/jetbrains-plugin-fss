/*
 * Copyright 2025 Quentin Ligier. Use of this source code is governed by the MIT license.
 */

package ch.qligier.jetbrains.plugin.fss.fsh.antlr

import ch.qligier.jetbrains.plugin.fss.fsh.FshLanguage
import com.intellij.lang.ASTNode
import com.intellij.lang.PsiBuilder
import com.intellij.psi.impl.source.tree.FileElement
import com.intellij.psi.impl.source.tree.LeafElement
import com.intellij.psi.impl.source.tree.LeafPsiElement
import com.intellij.psi.tree.IElementType
import com.intellij.psi.tree.IFileElementType
import org.antlr.intellij.adaptor.lexer.TokenIElementType
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
            walkAstNode(node)
        }

        return node
    }

    private fun walkAstNode(node: ASTNode) {
        if (node is LeafElement) {
            updateLeaf(node)
        }

        var child = node.firstChildNode
        while (child != null) {
            walkAstNode(child)
            child = child.treeNext
        }
    }

    private fun updateLeaf(leaf: LeafElement) {
        val antlrElementType = leaf.elementType as? TokenIElementType
        if (antlrElementType == null) {
            return
        }
        when (antlrElementType.antlrTokenType) {
            FSHLexer.STAR -> updateStarLeaf(leaf)
        }
    }

    private fun updateStarLeaf(starLeaf: LeafElement) {
        if (starLeaf.text.startsWith("*")) {
            return
        }
        val whitespacesLength = starLeaf.text.indexOf("*")
        if (whitespacesLength < 1) {
            return
        }

        /*starLeaf.rawInsertBeforeMe(LeafPsiElement(
            TokenIElementType(FSHLexer.WHITESPACE, "whitespace", FshLanguage),
            starLeaf.text.substring(0, whitespacesLength)))*/
        //starLeaf.replaceWithText(starLeaf.text.substring(whitespacesLength))
        //starLeaf.replaceWithText(starLeaf.text)

        starLeaf.treeParent.replaceChild(starLeaf, LeafPsiElement(
                starLeaf.elementType,
            starLeaf.text))

        //starLeaf.treeParent.replaceChild(starLeaf, starLeaf)
    }
}

/*
 * Copyright 2025 Quentin Ligier. Use of this source code is governed by the MIT license.
 */

package ch.qligier.jetbrains.plugin.fss.fsh.antlr

import ch.qligier.jetbrains.plugin.fss.fsh.FshLanguage
import ch.qligier.jetbrains.plugin.fss.fsh.psi.DebugPsiNode
import ch.qligier.jetbrains.plugin.fss.fsh.psi.FshPsiDocument
import ch.qligier.jetbrains.plugin.fss.fsh.psi.FshPsiFile
import ch.qligier.jetbrains.plugin.fss.fsh.psi.FshPsiName
import ch.qligier.jetbrains.plugin.fss.fsh.psi.entity.FshPsiAlias
import ch.qligier.jetbrains.plugin.fss.fsh.psi.entity.FshPsiProfile
import com.intellij.lang.ASTNode
import com.intellij.lang.ParserDefinition
import com.intellij.lang.ParserDefinition.SpaceRequirements
import com.intellij.lang.PsiParser
import com.intellij.lexer.Lexer
import com.intellij.openapi.project.Project
import com.intellij.psi.FileViewProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.tree.IFileElementType
import com.intellij.psi.tree.TokenSet
import org.antlr.intellij.adaptor.lexer.RuleIElementType
import org.antlr.intellij.adaptor.lexer.TokenIElementType

class FshParserDefinition : ParserDefinition {
    override fun createLexer(project: Project?): Lexer = FshLexerAdapter()
    override fun createParser(project: Project?): PsiParser = FshParserAdapter()
    override fun getFileNodeType(): IFileElementType = fshFileNodeType
    override fun getCommentTokens(): TokenSet = FshTokenSets.COMMENTS
    override fun getStringLiteralElements(): TokenSet = FshTokenSets.STRINGS
    override fun getWhitespaceTokens(): TokenSet = FshTokenSets.WHITESPACES
    override fun createFile(viewProvider: FileViewProvider): PsiFile = FshPsiFile(viewProvider)

    /**
     * Creates a PSI element for the specified AST node. The AST tree is a simple, semantic-free tree of AST nodes which
     * is built during the PsiBuilder parsing pass. The PSI tree is built over the AST tree and includes elements of
     * different types for different language constructs.
     * <p>
     * !!!WARNING!!! PSI element types should be unambiguously determined by AST node element types. You should not
     * produce different PSI elements from AST nodes of the same types (e.g. based on AST node content). Typically, your
     * code should be as simple as that:
     * <pre>{@code
     *   if (node.getElementType == MY_ELEMENT_TYPE) {
     *     return new MyPsiElement(node);
     *   }
     * }</pre>
     *
     * @param node the node for which the PSI element should be returned.
     * @return the PSI element matching the element type of the AST node.
     */
    override fun createElement(node: ASTNode): PsiElement {
        val elType = node.elementType
        println("Creating PSI node for element type $elType")
        if (elType is TokenIElementType) {
            return DebugPsiNode(node, "token")
        }
        if (elType !is RuleIElementType) {
            return DebugPsiNode(node, "notRule")
        }
        return when (elType.ruleIndex) {
            FSHParser.RULE_doc -> FshPsiDocument(node)
            FSHParser.RULE_alias -> FshPsiAlias(node)
            FSHParser.RULE_profile -> FshPsiProfile(node)
            FSHParser.RULE_entity -> createEntityElement(node)
            FSHParser.RULE_name -> FshPsiName(node)
            else -> DebugPsiNode(node, "default")
        }
    }

    private fun createEntityElement(node: ASTNode): PsiElement {
        val firstChild = node.firstChildNode
        if (firstChild == null) {
            throw RuntimeException()
        }
        val elType = firstChild.elementType
        if (elType !is RuleIElementType) {
            throw RuntimeException()
        }
        when (elType.ruleIndex) {
            FSHParser.RULE_profile -> return DebugPsiNode(node, "profile")
        }
        return DebugPsiNode(node, "defaultEntity")
    }

    /**
     * Checks if the specified two token types need to be separated by a space according to the language grammar. For
     * example, in Java two keywords are always separated by a space; a keyword and an opening parenthesis may be
     * separated or not separated. This is used for automatic whitespace insertion during AST modification operations.
     *
     * @param left  the first token to check.
     * @param right the second token to check.
     * @return the spacing requirements.
     */
    override fun spaceExistenceTypeBetweenTokens(left: ASTNode, right: ASTNode): SpaceRequirements {
        return SpaceRequirements.MAY
    }
}

private val fshFileNodeType: IFileElementType = IFileElementType(FshLanguage)

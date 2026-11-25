/*
 * Copyright 2026 Quentin Ligier. Use of this source code is governed by the MIT license.
 */

package ch.qligier.jetbrains.plugin.fss.fsh.language.parser

import ch.qligier.jetbrains.plugin.fss.fsh.language.lexer.FshLexerAdapter
import ch.qligier.jetbrains.plugin.fss.fsh.language.psi.FshFile
import ch.qligier.jetbrains.plugin.fss.fsh.language.psi.FshTokenSets
import ch.qligier.jetbrains.plugin.fss.fsh.language.psi.FshTypes
import ch.qligier.jetbrains.plugin.fss.fsh.language.psi.stubs.FshFileStubElementType
import com.intellij.lang.ASTNode
import com.intellij.lang.ParserDefinition
import com.intellij.lang.PsiParser
import com.intellij.lexer.Lexer
import com.intellij.openapi.project.Project
import com.intellij.psi.FileViewProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.tree.IFileElementType
import com.intellij.psi.tree.TokenSet

class FshParserDefinition : ParserDefinition {
    override fun createLexer(project: Project?): Lexer = FshLexerAdapter()

    override fun createParser(project: Project?): PsiParser = FshParser()

    override fun getFileNodeType(): IFileElementType = FILE

    override fun getCommentTokens(): TokenSet = FshTokenSets.COMMENTS

    override fun getStringLiteralElements(): TokenSet = FshTokenSets.STRINGS

    override fun createElement(node: ASTNode): PsiElement = FshTypes.Factory.createElement(node)

    override fun createFile(viewProvider: FileViewProvider): PsiFile = FshFile(viewProvider)

    companion object {
        /** The file element type, with a stub tree for entities */
        @JvmField
        val FILE: IFileElementType = FshFileStubElementType
    }
}

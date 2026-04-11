/*
 * Copyright 2026 Quentin Ligier. Use of this source code is governed by the MIT license.
 */

package ch.qligier.jetbrains.plugin.fss.fsh.language.parser

import ch.qligier.jetbrains.plugin.fss.fsh.FshLanguage
import ch.qligier.jetbrains.plugin.fss.fsh.language.lexer.FshLexerAdapter
import ch.qligier.jetbrains.plugin.fss.fsh.language.psi.FshFile
import ch.qligier.jetbrains.plugin.fss.fsh.language.psi.FshTokenSets
import ch.qligier.jetbrains.plugin.fss.fsh.language.psi.FshTypes
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

/**
 * Defines the implementation of a parser for the FSH language.
 * @see [Define a Parser](https://plugins.jetbrains.com/docs/intellij/lexer-and-parser-definition.html#define-a-parser)
 */
class FshParserDefinition : ParserDefinition {
    val file: IFileElementType = IFileElementType(FshLanguage)

    override fun createLexer(project: Project?): Lexer {
        return FshLexerAdapter()
    }

    override fun getCommentTokens(): TokenSet {
        return FshTokenSets.COMMENTS
    }

    override fun getStringLiteralElements(): TokenSet {
        return FshTokenSets.STRINGS
    }

    override fun createParser(project: Project?): PsiParser {
        return FshParser()
    }

    override fun getFileNodeType(): IFileElementType {
        return file
    }

    override fun createFile(viewProvider: FileViewProvider): PsiFile {
        return FshFile(viewProvider)
    }

    override fun createElement(node: ASTNode?): PsiElement {
        return FshTypes.Factory.createElement(node)
    }
}


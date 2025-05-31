/*
 * Copyright 2025 Quentin Ligier. Use of this source code is governed by the MIT license.
 */
package ch.qligier.jetbrains.plugin.fss.ig_ini.language.parser

import ch.qligier.jetbrains.plugin.fss.ig_ini.IgIniLanguage
import ch.qligier.jetbrains.plugin.fss.ig_ini.language.lexer.IniLexerAdapter
import ch.qligier.jetbrains.plugin.fss.ig_ini.language.psi.IniFile
import ch.qligier.jetbrains.plugin.fss.ig_ini.language.psi.IniTokenSets
import ch.qligier.jetbrains.plugin.fss.ig_ini.language.psi.IniTypes
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
 * Defines the implementation of a parser for the INI language.
 * @see [Define a
 * Parser](https://plugins.jetbrains.com/docs/intellij/lexer-and-parser-definition.html.define-a-parser)
 */
class IniParserDefinition : ParserDefinition {
    val file: IFileElementType = IFileElementType(IgIniLanguage)

    override fun createLexer(project: Project?): Lexer {
        return IniLexerAdapter()
    }

    override fun getCommentTokens(): TokenSet {
        return IniTokenSets.COMMENTS
    }

    override fun getStringLiteralElements(): TokenSet {
        return TokenSet.EMPTY
    }

    override fun createParser(project: Project?): PsiParser {
        return IniParser()
    }

    override fun getFileNodeType(): IFileElementType {
        return file
    }

    override fun createFile(viewProvider: FileViewProvider): PsiFile {
        return IniFile(viewProvider)
    }

    override fun createElement(node: ASTNode?): PsiElement {
        return IniTypes.Factory.createElement(node)
    }
}

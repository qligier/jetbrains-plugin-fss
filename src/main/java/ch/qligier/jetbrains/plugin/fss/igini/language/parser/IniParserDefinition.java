// Copyright 2024 Quentin Ligier. Use of this source code is governed by the MIT license.

package ch.qligier.jetbrains.plugin.fss.igini.language.parser;

import ch.qligier.jetbrains.plugin.fss.igini.IgIniLanguage;
import ch.qligier.jetbrains.plugin.fss.igini.language.lexer.IniLexerAdapter;
import ch.qligier.jetbrains.plugin.fss.igini.language.psi.IniFile;
import ch.qligier.jetbrains.plugin.fss.igini.language.psi.IniTokenSets;
import ch.qligier.jetbrains.plugin.fss.igini.language.psi.IniTypes;
import com.intellij.lang.ASTNode;
import com.intellij.lang.ParserDefinition;
import com.intellij.lang.PsiParser;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.project.Project;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IFileElementType;
import com.intellij.psi.tree.TokenSet;
import org.jetbrains.annotations.NotNull;

/**
 * Defines the implementation of a parser for the INI language.
 *
 * @author Quentin Ligier
 * @see <a href="https://plugins.jetbrains.com/docs/intellij/lexer-and-parser-definition.html#define-a-parser">Define a
 * Parser</a>
 **/
public class IniParserDefinition implements ParserDefinition {

    public static final IFileElementType FILE = new IFileElementType(IgIniLanguage.INSTANCE);

    @NotNull
    @Override
    public Lexer createLexer(Project project) {
        return new IniLexerAdapter();
    }

    @NotNull
    @Override
    public TokenSet getCommentTokens() {
        return IniTokenSets.COMMENTS;
    }

    @NotNull
    @Override
    public TokenSet getStringLiteralElements() {
        return TokenSet.EMPTY;
    }

    @NotNull
    @Override
    public PsiParser createParser(final Project project) {
        return new IniParser();
    }

    @NotNull
    @Override
    public IFileElementType getFileNodeType() {
        return FILE;
    }

    @NotNull
    @Override
    public PsiFile createFile(@NotNull final FileViewProvider viewProvider) {
        return new IniFile(viewProvider);
    }

    @NotNull
    @Override
    public PsiElement createElement(final ASTNode node) {
        return IniTypes.Factory.createElement(node);
    }
}

// Copyright 2022 Quentin Ligier. Use of this source code is governed by the MIT license.

package ch.qligier.jetbrains.plugin.fhir.fsh.parser;

import ch.qligier.jetbrains.plugin.fhir.fsh.FshLanguage;
import ch.qligier.jetbrains.plugin.fhir.fsh.lexer.FshLexerAdapter;
import ch.qligier.jetbrains.plugin.fhir.fsh.lexer.FshTokenSets;
import ch.qligier.jetbrains.plugin.fhir.fsh.parser.psi.FshFile;
import ch.qligier.jetbrains.plugin.fhir.fsh.parser.psi.FshTypes;
import com.intellij.lang.ASTNode;
import com.intellij.lang.ParserDefinition;
import com.intellij.lang.PsiParser;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.project.Project;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IFileElementType;
import com.intellij.psi.tree.TokenSet;
import org.jetbrains.annotations.NotNull;

/**
 * jetbrains-language-fsh
 *
 * @author Quentin Ligier
 **/
public class FshParserDefinition implements ParserDefinition {
    public static final Logger LOG = Logger.getInstance("FSHParserDefinition");
    public static final IFileElementType FILE =
            new IFileElementType(FshLanguage.INSTANCE);

    public FshParserDefinition() {
        LOG.info("FshParserDefinition");
    }

    /**
     * Returns the lexer for lexing files in the specified project. This lexer does not need to support incremental
     * relexing - it is always called for the entire file.
     *
     * @param project the project to which the lexer is connected.
     * @return the lexer instance.
     */
    @Override
    public @NotNull Lexer createLexer(final Project project) {
        return new FshLexerAdapter();
    }

    /**
     * Returns the parser for parsing files in the specified project.
     *
     * @param project the project to which the parser is connected.
     * @return the parser instance.
     */
    @Override
    public @NotNull PsiParser createParser(final Project project) {
        return new FshParser();
    }

    /**
     * Returns the set of token types which are treated as whitespace by the PSI builder. Tokens of those types are
     * automatically skipped by PsiBuilder. Whitespace elements on the bounds of nodes built by PsiBuilder are
     * automatically excluded from the text range of the nodes.
     * <p><strong>It is strongly advised you return TokenSet that only contains
     * {@link TokenType#WHITE_SPACE}, which is suitable for all the languages unless you really need to use special
     * whitespace token</strong>
     *
     * @return the set of whitespace token types.
     */
    @Override
    public @NotNull TokenSet getWhitespaceTokens() {
        return FshTokenSets.WHITESPACE;
    }

    /**
     * Returns the set of token types which are treated as comments by the PSI builder. Tokens of those types are
     * automatically skipped by PsiBuilder. Also, To Do patterns are searched in the text of tokens of those types. For
     * composite comment elements it should contain only the root element type.
     *
     * @return the set of comment token types.
     */
    @Override
    public @NotNull TokenSet getCommentTokens() {
        return TokenSet.EMPTY; // TODO
    }

    /**
     * Returns the set of element types which are treated as string literals. "Search in strings" option in refactorings
     * is applied to the contents of such tokens.
     *
     * @return the set of string literal element types.
     */
    @Override
    public @NotNull TokenSet getStringLiteralElements() {
        return FshTokenSets.STRING;
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
    @Override
    public @NotNull SpaceRequirements spaceExistenceTypeBetweenTokens(final ASTNode left, final ASTNode right) {
        /*if (left.getElementType() == PropertiesTokenTypes.END_OF_LINE_COMMENT) {
            return SpaceRequirements.MUST_LINE_BREAK;
        }*/
        return SpaceRequirements.MAY;
    }

    /**
     * Returns the element type of the node describing a file in the specified language.
     *
     * @return the file node element type.
     */
    @Override
    public @NotNull IFileElementType getFileNodeType() {
        return FILE;
    }

    /**
     * Creates a PSI element for the specified virtual file.
     *
     * @param viewProvider virtual file.
     * @return the PSI file element.
     */
    @Override
    public @NotNull PsiFile createFile(@NotNull final FileViewProvider viewProvider) {
        return new FshFile(viewProvider);
    }

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
    @Override
    public @NotNull PsiElement createElement(final ASTNode node) {
        return FshTypes.Factory.createElement(node);
    }
}

// Copyright 2024 Quentin Ligier. Use of this source code is governed by the MIT license.

package ch.qligier.jetbrains.plugin.fss.igini.language.highlighter;

import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.fileTypes.SyntaxHighlighterFactory;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * The factory of the INI syntax highlighter.
 *
 * @author Quentin Ligier
 * @see <a href="https://plugins.jetbrains.com/docs/intellij/syntax-highlighter-and-color-settings-page.html">Syntax
 * Highlighter and Color Settings Page</a>
 * @see <a href="https://plugins.jetbrains.com/docs/intellij/syntax-highlighting-and-error-highlighting.html">Syntax and
 * Error Highlighting</a>
 **/
public class IniSyntaxHighlighterFactory extends SyntaxHighlighterFactory {

    @Override
    public @NotNull SyntaxHighlighter getSyntaxHighlighter(@Nullable final Project project,
                                                           @Nullable final VirtualFile virtualFile) {
        return new IniSyntaxHighlighter();
    }
}

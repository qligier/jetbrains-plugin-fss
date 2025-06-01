// Copyright 2024 Quentin Ligier. Use of this source code is governed by the MIT license.
package ch.qligier.jetbrains.plugin.fss.fsh.color

import com.intellij.openapi.fileTypes.SyntaxHighlighter
import com.intellij.openapi.fileTypes.SyntaxHighlighterFactory
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile

class FshSyntaxHighlighterFactory : SyntaxHighlighterFactory() {
    /**
     * Override this method to provide syntax highlighting (coloring) capabilities for your language implementation. By
     * syntax highlighting we mean highlighting of keywords, comments, braces etc. where lexing the file content is
     * enough to identify proper highlighting attributes.
     *
     * Default implementation doesn't highlight anything.
     *
     * @param project     might be necessary to gather various project settings from.
     * @param virtualFile might be necessary to collect file specific settings
     * @return `SyntaxHighlighter` interface implementation for this particular language.
     */
    override fun getSyntaxHighlighter(
        project: Project?,
        virtualFile: VirtualFile?,
    ): SyntaxHighlighter = FshSyntaxHighlighter()
}

/*
 * Copyright 2025 Quentin Ligier. Use of this source code is governed by the MIT license.
 */

package ch.qligier.jetbrains.plugin.fss.igini.language

import com.intellij.lang.Commenter

/**
 * Defines the support for "Comment with Line Comment" and "Comment with Block Comment" actions in the INI language.
 *
 * @author Quentin Ligier
 * @see [com.intellij.lang.Commenter](https://plugins.jetbrains.com/docs/intellij/commenter.html)
 */
class IniCommenter : Commenter {
    override fun getLineCommentPrefix(): String = LINE_COMMENT_PREFIX

    override fun getLineCommentPrefixes(): MutableList<String> =
        mutableListOf(LINE_COMMENT_PREFIX, ALT_LINE_COMMENT_PREFIX)

    override fun getBlockCommentPrefix(): String? = null

    override fun getBlockCommentSuffix(): String? = null

    override fun getCommentedBlockCommentPrefix(): String? = null

    override fun getCommentedBlockCommentSuffix(): String? = null

    companion object {
        const val LINE_COMMENT_PREFIX: String = ";"
        const val ALT_LINE_COMMENT_PREFIX: String = "#"
    }
}

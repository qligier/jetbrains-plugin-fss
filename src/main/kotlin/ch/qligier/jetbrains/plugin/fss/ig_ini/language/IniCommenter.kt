/*
 * Copyright 2025 Quentin Ligier. Use of this source code is governed by the MIT license.
 */
package ch.qligier.jetbrains.plugin.fss.ig_ini.language

import com.intellij.lang.Commenter

/**
 * Defines the support for "Comment with Line Comment" and "Comment with Block Comment" actions in the INI language.
 * @see [Commenter](https://plugins.jetbrains.com/docs/intellij/commenter.html)
 */
class IniCommenter : Commenter {
    override fun getLineCommentPrefix(): String? {
        return LINE_COMMENT_PREFIX
    }

    override fun getLineCommentPrefixes(): MutableList<String?> {
        return mutableListOf(LINE_COMMENT_PREFIX, ALT_LINE_COMMENT_PREFIX)
    }

    override fun getBlockCommentPrefix(): String? {
        return null
    }

    override fun getBlockCommentSuffix(): String? {
        return null
    }

    override fun getCommentedBlockCommentPrefix(): String? {
        return null
    }

    override fun getCommentedBlockCommentSuffix(): String? {
        return null
    }

    companion object {
        const val LINE_COMMENT_PREFIX: String = ";"
        const val ALT_LINE_COMMENT_PREFIX: String = "#"
    }
}

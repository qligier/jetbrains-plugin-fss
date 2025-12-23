/*
 * Copyright 2025 Quentin Ligier. Use of this source code is governed by the MIT license.
 */
package ch.qligier.jetbrains.plugin.fss.fsh

import com.intellij.lang.Commenter
import com.intellij.openapi.diagnostic.thisLogger

/**
 * Defines the support for "Comment with Line Comment" and "Comment with Block Comment" actions in the FSH language.
 *
 * @author Quentin Ligier
 * @see [Comment Code](https://plugins.jetbrains.com/docs/intellij/additional-minor-features.html.comment-code)
 *
 * @see [Commenter](https://plugins.jetbrains.com/docs/intellij/commenter.html)
 */
class FshCommenter : Commenter {
    init {
        thisLogger().trace("FshCommenter built")
    }

    /**
     * Returns the string that prefixes a line comment in the language, or null if the language doesn't support line
     * comments. If the language supports several prefixes for line comments, only one of them (the most recommended to
     * use) is returned. Use [.getLineCommentPrefixes] to get all supported line comment prefixes.
     *
     * @return the line comment text, or null.
     */
    override fun getLineCommentPrefix(): String {
        thisLogger().trace("FshCommenter getLineCommentPrefix")
        return LINE_COMMENT_PREFIX
    }

    /**
     * Returns the string which marks the beginning of a block comment in the language, or null if the language doesn't
     * support block comments.
     *
     * @return the block comment start text, or null.
     */
    override fun getBlockCommentPrefix(): String {
        thisLogger().trace("FshCommenter getBlockCommentPrefix")
        return BLOCK_COMMENT_PREFIX
    }

    /**
     * Returns the string which marks the end of a block comment in the language, or null if the language doesn't
     * support block comments.
     *
     * @return the block comment end text, or null.
     */
    override fun getBlockCommentSuffix(): String {
        thisLogger().trace("FshCommenter getBlockCommentSuffix")
        return BLOCK_COMMENT_SUFFIX
    }

    /**
     * Returns the string which marks the commented beginning of a block comment in the language, or null if the
     * language doesn't support block comments.
     *
     * @return the commented block comment start text, or null.
     */
    override fun getCommentedBlockCommentPrefix(): String? {
        thisLogger().trace("FshCommenter getCommentedBlockCommentPrefix")
        return null
    }

    /**
     * Returns the string which marks the commented end of a block comment in the language, or null if the language
     * doesn't support block comments.
     *
     * @return the commented block comment end text, or null.
     */
    override fun getCommentedBlockCommentSuffix(): String? {
        thisLogger().trace("FshCommenter getCommentedBlockCommentSuffix")
        return null
    }

    companion object {
        const val LINE_COMMENT_PREFIX: String = "//"
        const val BLOCK_COMMENT_PREFIX: String = "/*"
        const val BLOCK_COMMENT_SUFFIX: String = "*/"
    }
}

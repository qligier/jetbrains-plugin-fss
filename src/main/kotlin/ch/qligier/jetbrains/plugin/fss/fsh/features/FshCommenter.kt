/*
 * Copyright 2025 Quentin Ligier. Use of this source code is governed by the MIT license.
 */

package ch.qligier.jetbrains.plugin.fss.fsh.features

import com.intellij.lang.Commenter

/**
 * Defines the support for "Comment with Line Comment" and "Comment with Block Comment" actions in the FSH language.
 * @see [Comment Code](https://plugins.jetbrains.com/docs/intellij/additional-minor-features.html#comment-code)
 * @see [Commenter](https://plugins.jetbrains.com/docs/intellij/commenter.html)
 */
class FshCommenter : Commenter {
    companion object {
        const val LINE_COMMENT_PREFIX = "//"
        const val BLOCK_COMMENT_PREFIX = "/*"
        const val BLOCK_COMMENT_SUFFIX = "*/"
    }

    /**
     * Returns the string that prefixes a line comment in the language, or null if the language doesn't support line
     * comments. If the language supports several prefixes for line comments, only one of them (the most recommended to
     * use) is returned. Use [getLineCommentPrefixes] to get all supported line comment prefixes.
     *
     * @return the line comment text, or null.
     */
    override fun getLineCommentPrefix(): String? = LINE_COMMENT_PREFIX

    /**
     * Returns the string which marks the beginning of a block comment in the language, or null if the language doesn't
     * support block comments.
     *
     * @return the block comment start text, or null.
     */
    override fun getBlockCommentPrefix(): String? = BLOCK_COMMENT_PREFIX

    /**
     * Returns the string which marks the end of a block comment in the language, or null if the language doesn't
     * support block comments.
     *
     * @return the block comment end text, or null.
     */
    override fun getBlockCommentSuffix(): String? = BLOCK_COMMENT_SUFFIX

    /**
     * Returns the string which marks the commented beginning of a block comment in the language, or null if the
     * language doesn't support block comments.
     *
     * @return the commented block comment start text, or null.
     */
    override fun getCommentedBlockCommentPrefix(): String? = "//$BLOCK_COMMENT_PREFIX"

    /**
     * Returns the string which marks the commented end of a block comment in the language, or null if the language
     * doesn't support block comments.
     *
     * @return the commented block comment end text, or null.
     */
    override fun getCommentedBlockCommentSuffix(): String? = "//$BLOCK_COMMENT_SUFFIX"
}

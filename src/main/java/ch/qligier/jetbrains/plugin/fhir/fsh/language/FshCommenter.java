package ch.qligier.jetbrains.plugin.fhir.fsh.language;

import com.intellij.lang.Commenter;
import org.jetbrains.annotations.Nullable;

/**
 * Defines the support for "Comment with Line Comment" and "Comment with Block Comment" actions in the FSH language.
 *
 * @author Quentin Ligier
 * @see <a href="https://plugins.jetbrains.com/docs/intellij/additional-minor-features.html#comment-code">Comment
 * Code</a>
 * @see <a href="https://plugins.jetbrains.com/docs/intellij/commenter.html">Commenter</a>
 **/
public class FshCommenter implements Commenter {

    public static final String LINE_COMMENT_PREFIX = "//";
    public static final String BLOCK_COMMENT_PREFIX = "/*";
    public static final String BLOCK_COMMENT_SUFFIX = "*/";

    /**
     * Returns the string that prefixes a line comment in the language, or null if the language does not support line
     * comments. If the language supports several prefixes for line comments, only one of them (the most recommended to
     * use) is returned. Use {@link #getLineCommentPrefixes()} to get all supported line comment prefixes.
     *
     * @return the line comment text, or null.
     */
    @Override
    public @Nullable String getLineCommentPrefix() {
        return LINE_COMMENT_PREFIX;
    }

    /**
     * Returns the string which marks the beginning of a block comment in the language, or null if the language does not
     * support block comments.
     *
     * @return the block comment start text, or null.
     */
    @Override
    public @Nullable String getBlockCommentPrefix() {
        return BLOCK_COMMENT_PREFIX;
    }

    /**
     * Returns the string which marks the end of a block comment in the language, or null if the language does not
     * support block comments.
     *
     * @return the block comment end text, or null.
     */
    @Override
    public @Nullable String getBlockCommentSuffix() {
        return BLOCK_COMMENT_SUFFIX;
    }

    /**
     * Returns the string which marks the commented beginning of a block comment in the language, or null if the
     * language does not support block comments.
     *
     * @return the commented block comment start text, or null.
     */
    @Override
    public @Nullable String getCommentedBlockCommentPrefix() {
        return null;
    }

    /**
     * Returns the string which marks the commented end of a block comment in the language, or null if the language does
     * not support block comments.
     *
     * @return the commented block comment end text, or null.
     */
    @Override
    public @Nullable String getCommentedBlockCommentSuffix() {
        return null;
    }
}

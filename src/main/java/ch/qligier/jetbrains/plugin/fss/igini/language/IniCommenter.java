// Copyright 2024 Quentin Ligier. Use of this source code is governed by the MIT license.

package ch.qligier.jetbrains.plugin.fss.igini.language;

import com.intellij.lang.Commenter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * Defines the support for "Comment with Line Comment" and "Comment with Block Comment" actions in the INI language.
 *
 * @author Quentin Ligier
 * @see <a href="https://plugins.jetbrains.com/docs/intellij/commenter.html">Commenter</a>
 **/
public class IniCommenter implements Commenter {

    public static final String LINE_COMMENT_PREFIX = ";";
    public static final String ALT_LINE_COMMENT_PREFIX = "#";

    @Override
    public @Nullable String getLineCommentPrefix() {
        return LINE_COMMENT_PREFIX;
    }

    @Override
    public @NotNull List<String> getLineCommentPrefixes() {
        return List.of(LINE_COMMENT_PREFIX, ALT_LINE_COMMENT_PREFIX);
    }

    @Override
    public @Nullable String getBlockCommentPrefix() {
        return null;
    }

    @Override
    public @Nullable String getBlockCommentSuffix() {
        return null;
    }

    @Override
    public @Nullable String getCommentedBlockCommentPrefix() {
        return null;
    }

    @Override
    public @Nullable String getCommentedBlockCommentSuffix() {
        return null;
    }
}

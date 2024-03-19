// Copyright 2024 Quentin Ligier. Use of this source code is governed by the MIT license.

package ch.qligier.jetbrains.plugin.fhir.fsh;

import ch.qligier.jetbrains.plugin.fhir.common.Icons;
import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jspecify.annotations.Nullable;

import javax.swing.*;

/**
 * Definition of the FSH file type.
 *
 * @author Quentin Ligier
 * @see <a href="https://plugins.jetbrains.com/docs/intellij/language-and-filetype.html">Language and File Type</a>
 **/
public class FshFileType extends LanguageFileType {
    public static final FshFileType INSTANCE = new FshFileType();

    private FshFileType() {
        super(FshLanguage.INSTANCE);
    }

    /**
     * Returns the name of the file type. The name must be unique among all file types registered in the system.
     */
    @Override
    public String getName() {
        return "FSH";
    }

    /**
     * Returns the user-readable description of the file type.
     */
    @Override
    public String getDescription() {
        return "FSH file";
    }

    /**
     * Returns the default extension for files of the type, <em>not</em> including the leading '.'.
     */
    @Override
    public String getDefaultExtension() {
        return "fsh";
    }

    /**
     * Returns the icon used for showing files of the type, or {@code null} if no icon should be shown.
     */
    @Override
    public @Nullable Icon getIcon() {
        return Icons.FSH_FILE;
    }
}

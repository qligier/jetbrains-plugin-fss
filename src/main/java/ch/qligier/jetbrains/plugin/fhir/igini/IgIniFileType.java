// Copyright 2022 Quentin Ligier. Use of this source code is governed by the MIT license.

package ch.qligier.jetbrains.plugin.fhir.igini;

import ch.qligier.jetbrains.plugin.fhir.common.Icons;
import com.intellij.openapi.fileTypes.LanguageFileType;
import com.intellij.openapi.util.NlsContexts;
import com.intellij.openapi.util.NlsSafe;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

/**
 * jetbrains-plugin-fhir
 *
 * @author Quentin Ligier
 **/
public class IgIniFileType extends LanguageFileType {

    public static final IgIniFileType INSTANCE = new IgIniFileType();

    private IgIniFileType() {
        super(IgIniLanguage.INSTANCE);
    }

    /**
     * Returns the name of the file type. The name must be unique among all file types registered in the system.
     */
    @Override
    public @NonNls @NotNull String getName() {
        return "ig.ini";
    }

    /**
     * Returns the user-readable description of the file type.
     */
    @Override
    public @NlsContexts.Label @NotNull String getDescription() {
        return "ig.ini";
    }

    /**
     * Returns the default extension for files of the type, <em>not</em> including the leading '.'.
     */
    @Override
    public @NlsSafe @NotNull String getDefaultExtension() {
        return ".ini";
    }

    /**
     * Returns the icon used for showing files of the type, or {@code null} if no icon should be shown.
     */
    @Override
    public @Nullable Icon getIcon() {
        return Icons.FHIR_FLAME;
    }
}

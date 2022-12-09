// Copyright 2022 Quentin Ligier. Use of this source code is governed by the MIT license.

package ch.qligier.jetbrains.plugin.fhir.fsh.parser.psi;

import ch.qligier.jetbrains.plugin.fhir.Icons;
import ch.qligier.jetbrains.plugin.fhir.fsh.FshFileType;
import ch.qligier.jetbrains.plugin.fhir.fsh.FshLanguage;
import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.List;

/**
 * jetbrains-language-fsh
 *
 * @author Quentin Ligier
 **/
public class FshFile extends PsiFileBase {

    /**
     * Constructor.
     *
     * @param viewProvider Manages language-specific access to PSI for a single file.
     */
    public FshFile(@NotNull final FileViewProvider viewProvider) {
        super(viewProvider, FshLanguage.INSTANCE);
    }

    /**
     * Returns the file type for the file.
     *
     * @return the file type instance.
     */
    @Override
    public @NotNull FileType getFileType() {
        return FshFileType.INSTANCE;
    }

    @Override
    public @Nullable Icon getIcon(final int flags) {
        return Icons.FSH_FILE;
    }

    public @NotNull List<FshItem> getItems() {
        return List.of(this.findChildrenByClass(FshItem.class));
    }

    @Override
    public String toString() {
        return "FshFileBase (FSH file)";
    }
}

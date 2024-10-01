// Copyright 2024 Quentin Ligier. Use of this source code is governed by the MIT license.

package ch.qligier.jetbrains.plugin.fss.igini.language.psi;

import ch.qligier.jetbrains.plugin.fss.igini.IgIniFileType;
import ch.qligier.jetbrains.plugin.fss.igini.IgIniLanguage;
import ch.qligier.jetbrains.plugin.fss.igini.language.psi.impl.IniPsiImplUtil;
import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;

/**
 * jetbrains-plugin-fss
 *
 * @author Quentin Ligier
 **/
public class IniFile extends PsiFileBase {

    public IniFile(@NotNull final FileViewProvider viewProvider) {
        super(viewProvider, IgIniLanguage.INSTANCE);
    }

    @Override
    public @NotNull FileType getFileType() {
        return IgIniFileType.INSTANCE;
    }

    @Override
    public String toString() {
        return "ig.ini file";
    }

    public @NotNull Collection<IniSection> getSections() {
        return IniPsiImplUtil.getSections(this);
    }

    public @NotNull Collection<IniProperty> getProperties() {
        return IniPsiImplUtil.getProperties(this);
    }
}

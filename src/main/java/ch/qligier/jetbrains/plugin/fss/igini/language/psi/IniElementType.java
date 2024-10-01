// Copyright 2024 Quentin Ligier. Use of this source code is governed by the MIT license.

package ch.qligier.jetbrains.plugin.fss.igini.language.psi;

import ch.qligier.jetbrains.plugin.fss.igini.IgIniLanguage;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

/**
 * jetbrains-plugin-fss
 *
 * @author Quentin Ligier
 **/
public class IniElementType extends IElementType {

    public IniElementType(@NonNls @NotNull final String debugName) {
        super(debugName, IgIniLanguage.INSTANCE);
    }
}

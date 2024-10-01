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
public class IniTokenType extends IElementType {

    public IniTokenType(@NonNls @NotNull final String debugName) {
        super(debugName, IgIniLanguage.INSTANCE);
    }

    @Override
    public String toString() {
        return "IniTokenType." + super.toString();
    }
}

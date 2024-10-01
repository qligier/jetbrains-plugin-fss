// Copyright 2024 Quentin Ligier. Use of this source code is governed by the MIT license.

package ch.qligier.jetbrains.plugin.fss.igini.language.psi.impl;

import ch.qligier.jetbrains.plugin.fss.igini.language.psi.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * jetbrains-plugin-fss
 *
 * @author Quentin Ligier
 **/
public class IniPsiImplUtil {

    public static @NotNull List<IniSection> getSections(final IniFile file) {
        return PsiTreeUtil.getChildrenOfTypeAsList(file, IniSection.class);
    }

    public static @NotNull List<IniProperty> getProperties(final IniFile file) {
        return PsiTreeUtil.getChildrenOfTypeAsList(file, IniProperty.class);
    }

    public static @Nullable IniKey getKeyElement(final IniProperty element) {
        return PsiTreeUtil.getChildOfType(element, IniKey.class);
    }

    public static @Nullable String getKeyName(final IniProperty element) {
        final ASTNode keyNode = element.getNode().findChildByType(IniTypes.KEY);
        if (keyNode != null) {
            return keyNode.getText();
        } else {
            return null;
        }
    }

    public static @Nullable String getSectionName(final IniSection element) {
        final ASTNode keyNode = element.getNode().findChildByType(IniTypes.SECTION_NAME);
        if (keyNode != null) {
            return keyNode.getText();
        } else {
            return null;
        }
    }

    public static @NotNull List<IniProperty> getProperties(final IniSection section) {
        return PsiTreeUtil.getChildrenOfTypeAsList(section, IniProperty.class);
    }
}

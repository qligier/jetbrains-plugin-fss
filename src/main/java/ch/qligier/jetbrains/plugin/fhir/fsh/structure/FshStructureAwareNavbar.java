// Copyright 2022 Quentin Ligier. Use of this source code is governed by the MIT license.

package ch.qligier.jetbrains.plugin.fhir.fsh.structure;

import ch.qligier.jetbrains.plugin.fhir.fsh.FshLanguage;
import ch.qligier.jetbrains.plugin.fhir.fsh.parser.psi.FshItem;
import com.intellij.icons.AllIcons;
import com.intellij.ide.navigationToolbar.StructureAwareNavBarModelExtension;
import com.intellij.lang.Language;
import com.intellij.openapi.diagnostic.Logger;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

/**
 * Structure aware navbar allows displaying specific file elements in the navigation bar, depending on the location of
 * the caret in it.
 * <p>
 * It depends on the {@link FshStructureViewFactory} to work.
 *
 * @author Quentin Ligier
 * @see <a href="https://plugins.jetbrains.com/docs/intellij/navbar.html">Navigation Bar</a>
 * @see <a href="https://plugins.jetbrains.com/docs/intellij/structure-aware-navbar.html">Structure Aware Navigation
 * Bar</a>
 **/
public class FshStructureAwareNavbar extends StructureAwareNavBarModelExtension {
    public static final Logger LOG = Logger.getInstance("FshStructureAwareNavbar");

    @NotNull
    @Override
    protected Language getLanguage() {
        return FshLanguage.INSTANCE;
    }

    @Override
    public @Nullable Icon getIcon(final Object object) {
        if (object instanceof FshItem) {
            return AllIcons.Nodes.Property;
        }
        return null;
    }

    @Override
    public @Nullable String getPresentableText(final Object object) {
        if (object instanceof FshItem) {
            return ((FshItem) object).getName();
        }
        return null;
    }
}

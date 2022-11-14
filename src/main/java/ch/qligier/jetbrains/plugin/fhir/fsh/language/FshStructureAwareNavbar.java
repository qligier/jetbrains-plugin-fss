package ch.qligier.jetbrains.plugin.fhir.fsh.language;

import com.intellij.ide.navigationToolbar.StructureAwareNavBarModelExtension;
import com.intellij.lang.Language;
import com.intellij.openapi.diagnostic.Logger;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

/**
 * Structure aware navbar allows displaying specific file elements in the navigation bar, depending on the location of
 * the caret in it.
 *
 * @author Quentin Ligier
 * @see <a href="https://plugins.jetbrains.com/docs/intellij/structure-aware-navbar.html">Structure Aware Navigation
 * Bar</a>
 * @see <a href="https://plugins.jetbrains.com/docs/intellij/navbar.html">Navigation Bar</a>
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
        // TODO
        return super.getIcon(object);
    }

    @Override
    public @Nullable String getPresentableText(final Object object) {
        LOG.info(String.format("FshStructureAwareNavbar: got object of type %s", object.getClass()));
        // TODO
        return null;
    }
}

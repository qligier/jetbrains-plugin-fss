// Copyright 2024 Quentin Ligier. Use of this source code is governed by the MIT license.

package ch.qligier.jetbrains.plugin.fss.fsh;

import com.intellij.openapi.application.PluginPathManager;
import com.intellij.openapi.diagnostic.Logger;
import org.jetbrains.plugins.textmate.api.TextMateBundleProvider;
import org.jspecify.annotations.NonNull;

import java.io.File;
import java.util.List;

/**
 * The provider of the FSH TextMate bundle.
 *
 * @author Quentin Ligier
 **/
public class FshTextMateBundleProvider implements TextMateBundleProvider {
    private static final Logger LOG = Logger.getInstance(FshTextMateBundleProvider.class);

    @Override
    public @NonNull List<PluginBundle> getBundles() {
        final File directory = PluginPathManager.getPluginResource(this.getClass(), "textmate");
        if (directory == null) {
            LOG.error("Could not find the FSH TextMate bundle");
            return List.of();
        }
        LOG.warn("Found the FSH TextMate bundle at " + directory.getAbsolutePath());
        System.out.println("Found the FSH TextMate bundle at " + directory.getAbsolutePath());
        return List.of(new PluginBundle("FSH", directory.toPath()));
    }
}

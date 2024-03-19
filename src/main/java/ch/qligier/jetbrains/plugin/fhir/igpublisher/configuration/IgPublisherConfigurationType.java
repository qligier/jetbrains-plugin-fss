// Copyright 2024 Quentin Ligier. Use of this source code is governed by the MIT license.

package ch.qligier.jetbrains.plugin.fhir.igpublisher.configuration;

import com.intellij.execution.configurations.ConfigurationFactory;
import com.intellij.execution.configurations.ConfigurationType;
import com.intellij.icons.AllIcons;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NonNls;

import javax.swing.*;

/**
 * The IG Publisher Configuration type.
 * <p>
 * It's useful to allow creating a configuration that can run the IG Publisher (and SUSHI) on the current project.
 *
 * @author Quentin Ligier
 * @see <a href="https://plugins.jetbrains.com/docs/intellij/run-configuration-management.html">Run Configuration
 * Management</a>
 **/
public class IgPublisherConfigurationType implements ConfigurationType {
    static final String ID = "IgPublisherConfiguration";

    /**
     * Returns the display name of the configuration type. This is used, for example, to represent the configuration
     * type in the run configurations tree, and also as the name of the action used to create the configuration.
     *
     * @return the display name of the configuration type.
     */
    @Override
    public
    @Nls(capitalization = Nls.Capitalization.Title) String getDisplayName() {
        return "IG Publisher";
    }

    /**
     * Returns the description of the configuration type. You may return the same text as the display name of the
     * configuration type.
     *
     * @return the description of the configuration type.
     */
    @Override
    public String getConfigurationTypeDescription() {
        return "IG publisher";
    }

    /**
     * Returns the 16x16 icon used to represent the configuration type.
     *
     * @return the icon
     */
    @Override
    public Icon getIcon() {
        return AllIcons.General.Information;
    }

    /**
     * The ID of the configuration type. Should be camel-cased without dashes, underscores, spaces and quotation marks.
     * The ID is used to store run configuration settings in a project or workspace file and must not change between
     * plugin versions.
     */
    @Override
    public @NonNls String getId() {
        return ID;
    }

    /**
     * Returns the configuration factories used by this configuration type. Normally each configuration type provides
     * just a single factory. You can return multiple factories if your configurations can be created in multiple
     * variants (for example, local and remote for an application server).
     *
     * @return the run configuration factories.
     */
    @Override
    public ConfigurationFactory[] getConfigurationFactories() {
        return new ConfigurationFactory[]{new IgPublisherConfigurationFactory(this)};
    }
}

// Copyright 2024 Quentin Ligier. Use of this source code is governed by the MIT license.

package ch.qligier.jetbrains.plugin.fhir.igpublisher.configuration;

import com.intellij.execution.configurations.ConfigurationFactory;
import com.intellij.execution.configurations.ConfigurationType;
import com.intellij.execution.configurations.RunConfiguration;
import com.intellij.execution.configurations.SimpleConfigurationType;
import com.intellij.openapi.components.BaseState;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.NonNls;
import org.jspecify.annotations.Nullable;

/**
 * The IG Publisher Configuration factory.
 *
 * @author Quentin Ligier
 * @see <a href="https://plugins.jetbrains.com/docs/intellij/run-configuration-management.html">Run Configuration
 * Management</a>
 **/
public class IgPublisherConfigurationFactory extends ConfigurationFactory {

    protected IgPublisherConfigurationFactory(final ConfigurationType type) {
        super(type);
    }

    /**
     * Creates a new template run configuration within the context of the specified project.
     *
     * @param project the project in which the run configuration will be used
     */
    @Override
    public RunConfiguration createTemplateConfiguration(final Project project) {
        return new IgPublisherConfiguration(project, this, "IG Publisher");
    }

    /**
     * Returns the id of the run configuration that is used for serialization. For compatibility reason the default
     * implementation calls the method {@link #getName()} and this may cause problems if {@link #getName} returns
     * localized value. So the default implementation
     * <strong>must be overridden</strong> in all inheritors. In existing implementations you need to use the same
     * value which is returned by {@link #getName()} for compatibility but store it directly in the code instead of
     * taking from a message bundle. For new configurations you may use any unique ID; if a new
     * {@link ConfigurationType} has a single {@link ConfigurationFactory}, use {@link SimpleConfigurationType}
     * instead.
     */
    @Override
    public @NonNls String getId() {
        return IgPublisherConfigurationType.ID;
    }

    /**
     * @return
     */
    @Override
    public @Nullable Class<? extends BaseState> getOptionsClass() {
        return IgPublisherConfigurationOptions.class;
    }
}

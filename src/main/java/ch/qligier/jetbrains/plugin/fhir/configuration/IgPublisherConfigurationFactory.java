//  Copyright 2022 Quentin Ligier and other contributors. Use of this source code is governed by the MIT license

package ch.qligier.jetbrains.plugin.fhir.configuration;

import com.intellij.execution.configurations.ConfigurationFactory;
import com.intellij.execution.configurations.ConfigurationType;
import com.intellij.execution.configurations.RunConfiguration;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.NotNull;

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

    @Override
    public @NotNull RunConfiguration createTemplateConfiguration(@NotNull final Project project) {
        return null;
    }
}

//  Copyright 2022 Quentin Ligier and other contributors. Use of this source code is governed by the MIT license

package ch.qligier.jetbrains.plugin.fhir.configuration;

import com.intellij.execution.ExecutionException;
import com.intellij.execution.Executor;
import com.intellij.execution.configurations.*;
import com.intellij.execution.impl.CheckableRunConfigurationEditor;
import com.intellij.execution.process.OSProcessHandler;
import com.intellij.execution.process.ProcessHandler;
import com.intellij.execution.process.ProcessHandlerFactory;
import com.intellij.execution.process.ProcessTerminatedListener;
import com.intellij.execution.runners.ExecutionEnvironment;
import com.intellij.openapi.options.SettingsEditor;
import com.intellij.openapi.options.SettingsEditorGroup;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * The IG Publisher Configuration.
 *
 * @author Quentin Ligier
 **/
public class IgPublisherConfiguration extends RunConfigurationBase<IgPublisherConfigurationOptions> {

    public IgPublisherConfiguration(final @NotNull Project project,
                                    @Nullable final ConfigurationFactory factory,
                                    @Nullable final String name) {
        super(project, factory, name);
    }

    /**
     * @return
     */
    @Override
    protected @NotNull IgPublisherConfigurationOptions getOptions() {
        return (IgPublisherConfigurationOptions) super.getOptions();
    }

    /**
     * Returns the UI control for editing the run configuration settings. If additional control over validation is
     * required, the object returned from this method may also implement {@link CheckableRunConfigurationEditor}. The
     * returned object can also implement {@link SettingsEditorGroup} if the settings it provides need to be displayed
     * in multiple tabs.
     *
     * @return the settings editor component.
     */
    @Override
    public @NotNull SettingsEditor<? extends RunConfiguration> getConfigurationEditor() {
        return null;
    }

    /**
     * Checks whether the run configuration settings are valid. Note that this check may be invoked on every change
     * (i.e. after each character typed in an input field).
     *
     * @throws RuntimeConfigurationException if the configuration settings contain a non-fatal problem which the user
     *                                       should be warned about but the execution should still be allowed.
     * @throws RuntimeConfigurationError     if the configuration settings contain a fatal problem which makes it
     *                                       impossible to execute the run configuration.
     */
    @Override
    public void checkConfiguration() throws RuntimeConfigurationException {
        super.checkConfiguration();
    }

    /**
     * Prepares for executing a specific instance of the run configuration.
     *
     * @param executor    the execution mode selected by the user (run, debug, profile etc.)
     * @param environment the environment object containing additional settings for executing the configuration.
     * @return the RunProfileState describing the process which is about to be started, or null if it's impossible to
     * start the process.
     */
    @Override
    public @Nullable RunProfileState getState(@NotNull final Executor executor,
                                              @NotNull final ExecutionEnvironment environment)
            throws ExecutionException {
        return new CommandLineState(environment) {
            @NotNull
            @Override
            protected ProcessHandler startProcess() throws ExecutionException {
                final var commandLine = new GeneralCommandLine(getOptions().getIgpPath(), "ig.ini");
                final var processHandler = ProcessHandlerFactory.getInstance().createColoredProcessHandler(commandLine);
                ProcessTerminatedListener.attach(processHandler);
                return processHandler;
            }
        };
    }
}

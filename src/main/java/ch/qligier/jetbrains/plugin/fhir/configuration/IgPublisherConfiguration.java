// Copyright 2022 Quentin Ligier. Use of this source code is governed by the MIT license.

package ch.qligier.jetbrains.plugin.fhir.configuration;

import com.intellij.execution.ExecutionException;
import com.intellij.execution.Executor;
import com.intellij.execution.configurations.*;
import com.intellij.execution.impl.CheckableRunConfigurationEditor;
import com.intellij.execution.process.ProcessHandler;
import com.intellij.execution.process.ProcessHandlerFactory;
import com.intellij.execution.process.ProcessTerminatedListener;
import com.intellij.execution.runners.ExecutionEnvironment;
import com.intellij.openapi.options.SettingsEditor;
import com.intellij.openapi.options.SettingsEditorGroup;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;

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
        return new IgPublisherSettingsEditor();
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

            /**
             * To run in command line mode, run the IG Publisher like this:
             *
             *  java -jar publisher.jar -ig [source] (-tx [url]) (-packages [directory]) (-watch)
             * parameters:
             *
             * -ig: a path or an url where the implementation guide JSON control file is found (see control file format documentation)
             * -tx: (optional) address to use for terminology server (default is http://tx.fhir.org - which is currently the only supported option).
             * Use -tx n/a to run without the terminology server (however, if your IG has vocabulary bindings, the tx server connection is required).
             * -packages: (optional) directory containing packages (tarball/gzips with implementation guide-associated artifacts with extension .tgz) to be used for packages to load without using package management infrastructure
             * -watch (optional): if this is present, the publisher will not terminate; instead, it will stay running, and watch for changes to the IG or its contents and re-run when it sees changes. Note that changes the spec or to dependent implementation guides (see below) are not picked up during watch mode
             * Advanced parameters:
             *
             * -resetTx - clear out the txCache (see comments below about managing the freshness of the txCache)
             * -resetTxErrors - delete any errors from the tcCache, but leave successful operations in the cache
             *
             *
             * @return
             * @throws ExecutionException
             */
            @NotNull
            @Override
            protected ProcessHandler startProcess() throws ExecutionException {
                final var commands = new ArrayList<String>(9);
                commands.add("java");
                commands.add("-Dfile.encoding=UTF-8");
                commands.add("-jar");
                commands.add(getOptions().getJarPath());
                commands.add("-ig");
                commands.add("ig.ini");

                if (getOptions().getUseWatch()) {
                    commands.add("-watch");
                }
                commands.add("-tx");
                if (getOptions().getUseTxServer()) {
                    commands.add(getOptions().getTxServerUrl());
                } else {
                    commands.add("n/a");
                }

                final var commandLine = new GeneralCommandLine(commands);
                if (getOptions().getUseColorAndFancyChars()) {
                    commandLine.getEnvironment().put("FORCE_COLOR", "true");
                    commandLine.getEnvironment().put("FORCE_FANCY_CHARACTERS", "true");
                }
                commandLine.setWorkDirectory(environment.getProject().getBasePath());
                final var processHandler = ProcessHandlerFactory.getInstance().createColoredProcessHandler(commandLine);
                ProcessTerminatedListener.attach(processHandler);
                return processHandler;
            }
        };
    }
}

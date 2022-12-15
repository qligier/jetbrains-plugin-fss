// Copyright 2022 Quentin Ligier. Use of this source code is governed by the MIT license.

package ch.qligier.jetbrains.plugin.fhir.configuration;

import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.fileChooser.FileChooserDescriptor;
import com.intellij.openapi.options.ConfigurationException;
import com.intellij.openapi.options.SettingsEditor;
import com.intellij.openapi.ui.ComponentValidator;
import com.intellij.openapi.ui.TextBrowseFolderListener;
import com.intellij.openapi.ui.TextFieldWithBrowseButton;
import com.intellij.openapi.ui.ValidationInfo;
import com.intellij.openapi.util.text.StringUtil;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.ui.Gray;
import com.intellij.ui.JBColor;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Supplier;
import java.util.regex.Pattern;

/**
 * The settings editor GUI for the IG Publisher configuration.
 *
 * @author Quentin Ligier
 * @see <a href="https://jetbrains.design/intellij/principles/icons/#color">Color</a>
 **/
public class IgPublisherSettingsEditor extends SettingsEditor<IgPublisherConfiguration> {
    public static final Logger LOG = Logger.getInstance("IgPublisherSettingsEditor");
    private static final Pattern IG_PUBLISHER_VERSION_PATTERN = Pattern.compile("\\d+\\.\\d+\\.\\d+");

    // Colors as per https://jetbrains.design/intellij/principles/icons/#29
    private static final Color GREEN = new JBColor(Color.decode("#62B543"), Color.decode("#62B543"));
    private static final Color RED = new JBColor(Color.decode("#E05555"), Color.decode("#E05555"));
    private static final Color GRAY = new JBColor(Gray._133, Gray._133);
    private TextFieldWithBrowseButton textFieldJarPath;
    private JPanel globalPanel;
    private JLabel igPublisherStatus;
    private JCheckBox checkboxUseWatch;
    private JCheckBox checkboxUseTxServer;
    private JTextField textFieldTxServerUrl;
    private JCheckBox checkBoxUseColorAndFancyChars;

    protected String runJarForVersion(final String jarPath) throws IOException, InterruptedException {
        final var processBuilder = new ProcessBuilder();
        processBuilder.command("java", "-Dfile.encoding=UTF-8", "-jar", jarPath, "-v");
        final Process process = processBuilder.start();
        final var output = new StringBuilder();
        final var reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

        String line;
        while ((line = reader.readLine()) != null) {
            output.append(line);
        }

        int exitVal = process.waitFor();
        if (exitVal == 0) {
            if (IG_PUBLISHER_VERSION_PATTERN.matcher(output).matches()) {
                return output.toString();
            } else {
                throw new IOException("Unexpected value read from the process");
            }
        }
        throw new IOException("The process has exited with value " + exitVal);
    }

    /**
     * @param configuration
     */
    @Override
    protected void resetEditorFrom(@NotNull final IgPublisherConfiguration configuration) {
        this.textFieldJarPath.setText(configuration.getOptions().getJarPath());
        this.checkboxUseWatch.setSelected(configuration.getOptions().getUseWatch());
        this.checkboxUseTxServer.setSelected(configuration.getOptions().getUseTxServer());
        this.textFieldTxServerUrl.setText(configuration.getOptions().getTxServerUrl());
        this.checkBoxUseColorAndFancyChars.setSelected(configuration.getOptions().getUseColorAndFancyChars());
        this.updateTxServer();
        this.updateIgPublisherStatus();
    }

    /**
     * @param configuration
     */
    @Override
    protected void applyEditorTo(@NotNull final IgPublisherConfiguration configuration) {
        configuration.getOptions().setJarPath(this.textFieldJarPath.getText());
        configuration.getOptions().setUseWatch(this.checkboxUseWatch.isSelected());
        configuration.getOptions().setUseTxServer(this.checkboxUseTxServer.isSelected());
        configuration.getOptions().setTxServerUrl(this.textFieldTxServerUrl.getText());
        configuration.getOptions().setUseColorAndFancyChars(this.checkBoxUseColorAndFancyChars.isSelected());
    }

    /**
     * @return
     */
    @Override
    protected @NotNull JComponent createEditor() {
        return this.globalPanel;
    }

    protected void updateTxServer() {
        this.textFieldTxServerUrl.setEnabled(this.checkboxUseTxServer.isSelected());
    }

    protected void updateIgPublisherStatus() {
        final String jarPath = this.textFieldJarPath.getText();
        if (jarPath.isBlank()) {
            this.igPublisherStatus.setText("An absolute path, or relative to the project root");
            this.igPublisherStatus.setForeground(GRAY);
            return;
        }

        try {
            final var output = this.runJarForVersion(jarPath);
            this.igPublisherStatus.setText("Found IG Publisher v" + output);
            this.igPublisherStatus.setForeground(GREEN);
            return;
        } catch (final Exception e) {
            LOG.debug("Caught exception while executing IG Publisher JAR", e);
        }

        this.igPublisherStatus.setText("This doesn't seem to be an IG Publisher JAR file");
        this.igPublisherStatus.setForeground(RED);
    }

    /**
     * A method magically called to initialize some UI components if their property 'Custom create' is enabled in the
     * GUI Designer.
     *
     * @see <a href="https://www.jetbrains.com/help/idea/creating-form-initialization-code.html">Creating Form
     * Initialization Code</a>
     */
    private void createUIComponents() throws ConfigurationException {
        this.textFieldJarPath = new TextFieldWithBrowseButton();
        this.textFieldJarPath.setText("publisher.jar");
        this.textFieldJarPath.setToolTipText("Select the IG Publisher JAR file");

        final var parentThis = this;
        final var listener = new TextBrowseFolderListener(new FileChooserDescriptor(false, false, true, true, false,
                                                                                    false)) {
            @Override
            protected void onFileChosen(@NotNull final VirtualFile chosenFile) {
                super.onFileChosen(chosenFile);
                ComponentValidator.getInstance(parentThis.textFieldJarPath).ifPresent(ComponentValidator::revalidate);
                updateIgPublisherStatus();
            }
        };
        this.textFieldJarPath.addBrowseFolderListener(listener);

        this.checkboxUseTxServer = new JCheckBox();
        this.checkboxUseTxServer.addChangeListener(e -> {
            updateTxServer();
        });

        new ComponentValidator(this).withValidator(new Supplier<ValidationInfo>() {
            @Override
            public ValidationInfo get() {
                final var jarPath = parentThis.textFieldJarPath.getText();
                if (StringUtil.isNotEmpty(jarPath)) {
                    try {
                        final var output = parentThis.runJarForVersion(jarPath);
                        return null;
                    } catch (final Exception e) {
                        return new ValidationInfo("Specify a valid path to an IG Publisher JAR file",
                                                  parentThis.textFieldJarPath);
                    }
                }
                return null;
            }
        }).andStartOnFocusLost().installOn(this.textFieldJarPath);
    }
}

// Copyright 2022 Quentin Ligier. Use of this source code is governed by the MIT license.

package ch.qligier.jetbrains.plugin.fhir.configuration;

import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.fileChooser.FileChooserDescriptor;
import com.intellij.openapi.options.SettingsEditor;
import com.intellij.openapi.ui.TextBrowseFolderListener;
import com.intellij.openapi.ui.TextFieldWithBrowseButton;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.ui.Gray;
import com.intellij.ui.JBColor;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
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
    private static final Color GREEN = new JBColor(new Color(89, 168, 105), new Color(89, 168, 105));
    private static final Color RED = new JBColor(new Color(219, 88, 96), new Color(219, 88, 96));
    private static final Color GRAY = new JBColor(Gray._133, Gray._133);
    private TextFieldWithBrowseButton textFieldJarPath;
    private JPanel globalPanel;
    private JLabel igPublisherStatus;
    private JCheckBox checkboxUseWatch;
    private JCheckBox checkboxUseTxServer;
    private JTextField textFieldTxServerUrl;
    private JCheckBox checkBoxUseColorAndFancyChars;

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
            System.out.println("Case1");
            this.igPublisherStatus.setText("An absolute path, or relative to the project root");
            this.igPublisherStatus.setForeground(GRAY);
            return;
        }
        final var processBuilder = new ProcessBuilder();
        processBuilder.command("java", "-Dfile.encoding=UTF-8", "-jar", jarPath, "-v");
        try {
            final Process process = processBuilder.start();
            final var output = new StringBuilder();
            final var reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line);
            }

            int exitVal = process.waitFor();
            if (exitVal == 0) {
                System.out.println("[" + output + "]");
                if (IG_PUBLISHER_VERSION_PATTERN.matcher(output).matches()) {
                    this.igPublisherStatus.setText("Found IG Publisher v" + output);
                    this.igPublisherStatus.setForeground(GREEN);
                    return;
                }
            }

        } catch (final Exception e) {
            System.out.println("Case2");
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
    private void createUIComponents() {
        this.textFieldJarPath = new TextFieldWithBrowseButton();
        this.textFieldJarPath.setText("publisher.jar");
        this.textFieldJarPath.setToolTipText("Select the IG Publisher JAR file");

        final var listener = new TextBrowseFolderListener(new FileChooserDescriptor(false, false, true, true, false,
                                                                                    false)) {
            @Override
            protected void onFileChosen(@NotNull final VirtualFile chosenFile) {
                super.onFileChosen(chosenFile);
                updateIgPublisherStatus();
            }
        };
        this.textFieldJarPath.addBrowseFolderListener(listener);

        this.checkboxUseTxServer = new JCheckBox();
        this.checkboxUseTxServer.addChangeListener(e -> {
            updateTxServer();
        });
    }
}

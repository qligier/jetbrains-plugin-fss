// Copyright 2022 Quentin Ligier. Use of this source code is governed by the MIT license.

package ch.qligier.jetbrains.plugin.fhir.igpublisher.configuration;

import com.intellij.execution.configurations.RunConfigurationOptions;
import com.intellij.openapi.components.StoredProperty;

import java.util.Objects;

/**
 * The IG Publisher Configuration options.
 *
 * @author Quentin Ligier
 **/
public class IgPublisherConfigurationOptions extends RunConfigurationOptions {

    /**
     * The path to the IG Publisher JAR file.
     */
    private final StoredProperty<String> jarPath = string(null).provideDelegate(this, "jarPath");

    /**
     * Whether to watch the project or not (-watch flag).
     */
    private final StoredProperty<Boolean> useWatch = property(false).provideDelegate(this, "useWatch");

    /**
     * Whether to use a TX server or not.
     */
    private final StoredProperty<Boolean> useTxServer = property(true).provideDelegate(this, "useTxServer");

    /**
     * The URL of the TX server.
     */
    private final StoredProperty<String> txServerUrl = string("http://tx.fhir.org").provideDelegate(this,
                                                                                                    "txServerUrl");

    /**
     * Whether to use colors and fancy characters (SUSHI only).
     */
    private final StoredProperty<Boolean> useColorAndFancyChars = property(true).provideDelegate(this,
                                                                                                 "useColorAndFancyChars");

    public String getJarPath() {
        return this.jarPath.getValue(this);
    }

    public void setJarPath(final String jarPath) {
        Objects.requireNonNull(jarPath, "jarPath shall not be null in setJarPath()");
        this.jarPath.setValue(this, jarPath);
    }

    public boolean getUseWatch() {
        return this.useWatch.getValue(this);
    }

    public void setUseWatch(final boolean useWatch) {
        this.useWatch.setValue(this, useWatch);
    }

    public boolean getUseTxServer() {
        return this.useTxServer.getValue(this);
    }

    public void setUseTxServer(final boolean useTxServer) {
        this.useTxServer.setValue(this, useTxServer);
    }

    public String getTxServerUrl() {
        return this.txServerUrl.getValue(this);
    }

    public void setTxServerUrl(final String txServerUrl) {
        Objects.requireNonNull(jarPath, "txServerUrl shall not be null in setTxServerUrl()");
        this.txServerUrl.setValue(this, txServerUrl);
    }

    public boolean getUseColorAndFancyChars() {
        return this.useColorAndFancyChars.getValue(this);
    }

    public void setUseColorAndFancyChars(final boolean useColorAndFancyChars) {
        this.useColorAndFancyChars.setValue(this, useColorAndFancyChars);
    }
}

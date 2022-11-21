//  Copyright 2022 Quentin Ligier and other contributors. Use of this source code is governed by the MIT license

package ch.qligier.jetbrains.plugin.fhir.configuration;

import com.intellij.execution.configurations.RunConfigurationOptions;
import com.intellij.openapi.components.StoredProperty;

/**
 * The IG Publisher Configuration options.
 *
 * @author Quentin Ligier
 **/
public class IgPublisherConfigurationOptions extends RunConfigurationOptions {

    private final StoredProperty<String> igpPath = string("").provideDelegate(this, "igpPath");

    public String getIgpPath() {
        return this.igpPath.getValue(this);
    }

    public void setIgpPath(final String igpPath) {
        this.igpPath.setValue(this, igpPath);
    }
}

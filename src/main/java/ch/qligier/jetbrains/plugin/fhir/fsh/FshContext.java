// Copyright 2022 Quentin Ligier. Use of this source code is governed by the MIT license.

package ch.qligier.jetbrains.plugin.fhir.fsh;

import com.intellij.codeInsight.template.TemplateActionContext;
import com.intellij.codeInsight.template.TemplateContextType;
import org.jetbrains.annotations.NotNull;

/**
 * A TemplateContextType tells the IntelliJ Platform where the Live Template is applicable: FSH files.
 *
 * @author Quentin Ligier
 * @see <a
 * href="https://plugins.jetbrains.com/docs/intellij/template-support.html#implement-templatecontexttype">Implement
 * TemplateContextType</a>
 **/
public class FshContext extends TemplateContextType {

    protected FshContext() {
        super("FSH");
    }

    @Override
    public boolean isInContext(@NotNull final TemplateActionContext templateActionContext) {
        return templateActionContext.getFile().getName().endsWith(".fsh");
    }
}

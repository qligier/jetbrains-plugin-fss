// Copyright 2024 Quentin Ligier. Use of this source code is governed by the MIT license.

package ch.qligier.jetbrains.plugin.fss.fsh;

import com.intellij.codeInsight.template.TemplateActionContext;
import com.intellij.codeInsight.template.TemplateContextType;
import org.jspecify.annotations.NonNull;

/**
 * A TemplateContextType tells the IntelliJ Platform where the Live Template is applicable: FSH files.
 *
 * @author Quentin Ligier
 * @see <a
 * href="https://plugins.jetbrains.com/docs/intellij/template-support.html#implement-templatecontexttype">Implement
 * TemplateContextType</a>
 **/
public class FshTemplateContextType extends TemplateContextType {

    protected FshTemplateContextType() {
        super("FSH");
    }

    @Override
    public boolean isInContext(@NonNull final TemplateActionContext templateActionContext) {
        return templateActionContext.getFile().getName().endsWith(".fsh");
    }
}

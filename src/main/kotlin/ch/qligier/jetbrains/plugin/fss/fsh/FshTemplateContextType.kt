/*
 * Copyright 2025 Quentin Ligier. Use of this source code is governed by the MIT license.
 */
package ch.qligier.jetbrains.plugin.fss.fsh

import com.intellij.codeInsight.template.TemplateActionContext
import com.intellij.codeInsight.template.TemplateContextType

/**
 * A TemplateContextType tells the IntelliJ Platform where the Live Template is applicable: FSH files.
 *
 * @author Quentin Ligier
 * @see [Implement TemplateContextType](https://plugins.jetbrains.com/docs/intellij/template-support.html.implement-templatecontexttype)
 */
class FshTemplateContextType : TemplateContextType("FSH") {
    override fun isInContext(templateActionContext: TemplateActionContext): Boolean =
        templateActionContext.file.name.endsWith(".fsh")
}

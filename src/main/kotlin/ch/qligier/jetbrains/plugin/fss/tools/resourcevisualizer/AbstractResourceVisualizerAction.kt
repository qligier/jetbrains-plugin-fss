/*
 * Copyright 2026 Quentin Ligier. Use of this source code is governed by the MIT license.
 */

package ch.qligier.jetbrains.plugin.fss.tools.resourcevisualizer

import ch.qligier.jetbrains.plugin.fss.tools.resourcevisualizer.operationoutcome.OperationOutcomeVisualizerDialog
import com.intellij.openapi.actionSystem.ActionUpdateThread
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.ui.Messages
import dev.ohs.fhir.model.r4.FhirR4Json
import dev.ohs.fhir.model.r4.OperationOutcome
import dev.ohs.fhir.model.r4.Resource

abstract class AbstractResourceVisualizerAction : AnAction() {
    companion object {
        protected const val DIALOG_TITLE = "FHIR Resource Visualizer"
    }

    abstract fun readTextToVisualize(event: AnActionEvent): String?

    override fun actionPerformed(event: AnActionEvent) {
        val textToVisualize = readTextToVisualize(event)
        if (textToVisualize.isNullOrEmpty()) {
            // The callee should have already shown a warning dialog if the text to visualize is null or empty, so we
            // just silently stop the execution
            return
        }

        // Try to parse the text as a FHIR R4 resource
        when (val parsed = parseFhirR4Resource(textToVisualize)) {
            is OperationOutcome -> {
                OperationOutcomeVisualizerDialog(event.project, parsed).show()
            }

            null -> {
                Messages.showErrorDialog(
                    "The content can't be parsed as a FHIR resource.",
                    DIALOG_TITLE,
                )
            }

            else -> {
                val resourceType = parsed.javaClass.simpleName
                Messages.showWarningDialog(
                    "The content is a FHIR resource of type $resourceType, but only OperationOutcome resources are currently supported for visualization.",
                    DIALOG_TITLE,
                )
            }
        }
    }

    override fun getActionUpdateThread(): ActionUpdateThread = ActionUpdateThread.BGT

    private fun parseFhirR4Resource(rawText: String): Resource? {
        val jsonR4 = FhirR4Json({ ignoreUnknownKeys = true })
        val resource: Resource
        try {
            resource = jsonR4.decodeFromString(rawText)
        } catch (_: Exception) {
            return null
        }
        return resource
    }
}

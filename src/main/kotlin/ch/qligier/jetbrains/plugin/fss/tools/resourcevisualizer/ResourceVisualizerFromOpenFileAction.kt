/*
 * Copyright 2026 Quentin Ligier. Use of this source code is governed by the MIT license.
 */

package ch.qligier.jetbrains.plugin.fss.tools.resourcevisualizer

import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.ui.Messages
import com.intellij.openapi.vfs.VirtualFile

/**
 * The action to trigger the visualization of a FHIR resource from an open file in the editor.
 **/
class ResourceVisualizerFromOpenFileAction : AbstractResourceVisualizerAction() {
    companion object {
        private val SUPPORTED_EXTENSIONS = setOf("json", "jsonc", "json5")
    }
    override fun readTextToVisualize(event: AnActionEvent): String? {
        val file = event.getData(com.intellij.openapi.actionSystem.CommonDataKeys.VIRTUAL_FILE) as VirtualFile?
        if (file == null) {
            Messages.showWarningDialog(
                event.project,
                "No file is currently open in the editor. Please open a file in the editor to visualize its content.",
                DIALOG_TITLE,
            )
            return null
        }
        return file.contentsToByteArray().decodeToString()
    }

    override fun update(event: AnActionEvent) {
        val file = event.getData(com.intellij.openapi.actionSystem.CommonDataKeys.VIRTUAL_FILE)
        event.presentation.isEnabled = file != null && file.extension in SUPPORTED_EXTENSIONS
    }
}

/*
 * Copyright 2026 Quentin Ligier. Use of this source code is governed by the MIT license.
 */

package ch.qligier.jetbrains.plugin.fss.tools.resourcevisualizer

import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.ide.CopyPasteManager
import com.intellij.openapi.ui.Messages
import java.awt.datatransfer.DataFlavor

/**
 * The action to trigger the visualization of a FHIR resource from the clipboard.
 **/
class ResourceVisualizerFromClipboardAction : AbstractResourceVisualizerAction() {
    override fun readTextToVisualize(event: AnActionEvent): String? {
        val clipboardText = CopyPasteManager.getInstance().getContents<String>(DataFlavor.stringFlavor)

        if (clipboardText.isNullOrEmpty()) {
            Messages.showWarningDialog(event.project, "The clipboard does not contain text.", DIALOG_TITLE)
            return null
        }
        return clipboardText
    }
}

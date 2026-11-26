/*
 * Copyright 2026 Quentin Ligier. Use of this source code is governed by the MIT license.
 */

package ch.qligier.jetbrains.plugin.fss.sushiconfig

import com.intellij.codeInspection.LocalQuickFix
import com.intellij.codeInspection.ProblemDescriptor
import com.intellij.codeInspection.util.IntentionFamilyName
import com.intellij.codeInspection.util.IntentionName
import com.intellij.openapi.project.Project
import org.jetbrains.yaml.psi.YAMLFile
import org.jetbrains.yaml.psi.YAMLKeyValue
import org.jetbrains.yaml.psi.YAMLMapping

class RemoveValueKeyQuickFix(
    private val keyName: String,
) : LocalQuickFix {
    override fun applyFix(
        project: Project,
        descriptor: ProblemDescriptor,
    ) {
        val file = descriptor.psiElement?.containingFile as? YAMLFile ?: return
        file.documents.forEach { document ->
            (document.topLevelValue as? YAMLMapping)?.let { mapping ->
                val keyValue: YAMLKeyValue = mapping.getKeyValueByKey(keyName) ?: return@let
                val next = keyValue.nextSibling
                if (next != null && next.text == "\n") {
                    // Also delete the newline after the key-value pair to avoid keeping an empty line
                    next.delete()
                }
                keyValue.delete()
            }
        }
    }

    override fun getFamilyName(): @IntentionFamilyName String = "Remove property"

    override fun getName(): @IntentionName String = "Remove property '$keyName'"
}

class AddValueKeyQuickFix(
    private val keyName: String,
    private val keyValue: String,
) : LocalQuickFix {
    override fun applyFix(
        project: Project,
        descriptor: ProblemDescriptor,
    ) {
        val file = descriptor.psiElement?.containingFile as? YAMLFile ?: return
        file.documents.forEach { document ->
            (document.topLevelValue as? YAMLMapping)?.putKeyValue(createKeyValue(project, keyName, keyValue))
        }
    }

    override fun getFamilyName(): @IntentionFamilyName String = "Add property"

    override fun getName(): @IntentionName String = "Add property '$keyName'"
}

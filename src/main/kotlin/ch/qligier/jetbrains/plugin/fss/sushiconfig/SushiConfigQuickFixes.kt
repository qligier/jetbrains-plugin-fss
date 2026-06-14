/*
 * Copyright 2026 Quentin Ligier. Use of this source code is governed by the MIT license.
 */

package ch.qligier.jetbrains.plugin.fss.sushiconfig

import com.intellij.codeInsight.intention.impl.BaseIntentionAction
import com.intellij.codeInspection.util.IntentionFamilyName
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.project.DumbAware
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.util.IncorrectOperationException
import org.jetbrains.yaml.psi.YAMLFile
import org.jetbrains.yaml.psi.YAMLKeyValue
import org.jetbrains.yaml.psi.YAMLMapping

class RemoveValueKeyQuickFix(
    private val keyName: String,
) : BaseIntentionAction(),
    DumbAware {
    override fun isAvailable(
        project: Project,
        editor: Editor?,
        psiFile: PsiFile?,
    ): Boolean = true

    @Throws(IncorrectOperationException::class)
    override fun invoke(
        project: Project,
        editor: Editor?,
        psiFile: PsiFile?,
    ) {
        if (psiFile !is YAMLFile) return
        psiFile.documents.forEach { document ->
            (document.topLevelValue as? YAMLMapping)?.let { mapping ->
                val keyValue: YAMLKeyValue = mapping.getKeyValueByKey(keyName) ?: return@let
                if (keyValue.nextSibling is PsiElement && keyValue.nextSibling.text == "\n") {
                    // Also delete the newline after the key-value pair to avoid keeping an empty line
                    keyValue.nextSibling.delete()
                }
                keyValue.delete()
            }
        }
    }

    override fun getFamilyName(): @IntentionFamilyName String = "Remove property"

    override fun getText(): String = "Remove property '$keyName'"
}

class AddValueKeyQuickFix(
    private val keyName: String,
    private val keyValue: String,
) : BaseIntentionAction(),
    DumbAware {
    override fun isAvailable(
        project: Project,
        editor: Editor?,
        psiFile: PsiFile?,
    ): Boolean = true

    override fun invoke(
        project: Project,
        editor: Editor?,
        psiFile: PsiFile?,
    ) {
        if (psiFile !is YAMLFile) return
        psiFile.documents.forEach { document ->
            (document.topLevelValue as? YAMLMapping)?.putKeyValue(createKeyValue(project, keyName, keyValue))
        }
    }

    override fun getFamilyName(): @IntentionFamilyName String = "Add property"

    override fun getText(): String = "Add property '$keyName'"
}

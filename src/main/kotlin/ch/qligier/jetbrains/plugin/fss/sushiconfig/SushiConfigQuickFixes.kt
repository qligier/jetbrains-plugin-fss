/*
 * Copyright 2026 Quentin Ligier. Use of this source code is governed by the MIT license.
 */

package ch.qligier.jetbrains.plugin.fss.sushiconfig

import com.intellij.codeInspection.LocalQuickFix
import com.intellij.codeInspection.util.IntentionFamilyName
import com.intellij.modcommand.ActionContext
import com.intellij.modcommand.ModPsiUpdater
import com.intellij.modcommand.Presentation
import com.intellij.modcommand.PsiUpdateModCommandAction
import org.jetbrains.yaml.psi.YAMLMapping

/**
 * Removes the property [keyName] from the [mapping]. As a ModCommand action, it works on a copy of the file, which
 * gives an accurate preview.
 */
internal class RemoveValueKeyQuickFix(
    mapping: YAMLMapping,
    private val keyName: String,
) : PsiUpdateModCommandAction<YAMLMapping>(mapping) {
    override fun invoke(
        context: ActionContext,
        element: YAMLMapping,
        updater: ModPsiUpdater,
    ) {
        val keyValue = element.getKeyValueByKey(keyName) ?: return
        // Also delete one adjacent newline to avoid keeping an empty line. The last pair has no newline after it in
        // the mapping, so delete the one before it instead.
        val next = keyValue.nextSibling
        val prev = keyValue.prevSibling
        when {
            next != null && next.text == "\n" -> next.delete()
            prev != null && prev.text == "\n" -> prev.delete()
        }
        keyValue.delete()
    }

    override fun getFamilyName(): @IntentionFamilyName String = "Remove property"

    override fun getPresentation(
        context: ActionContext,
        element: YAMLMapping,
    ): Presentation = Presentation.of("Remove property '$keyName'")
}

/**
 * Adds the property [keyName] with the value [keyValue] to the [mapping].
 */
internal class AddValueKeyQuickFix(
    mapping: YAMLMapping,
    private val keyName: String,
    private val keyValue: String,
) : PsiUpdateModCommandAction<YAMLMapping>(mapping) {
    override fun invoke(
        context: ActionContext,
        element: YAMLMapping,
        updater: ModPsiUpdater,
    ) {
        element.putKeyValue(createKeyValue(context.project(), keyName, keyValue))
    }

    override fun getFamilyName(): @IntentionFamilyName String = "Add property"

    override fun getPresentation(
        context: ActionContext,
        element: YAMLMapping,
    ): Presentation = Presentation.of("Add property '$keyName'")
}

/** Wraps a ModCommand action so it can be passed to `ProblemsHolder.registerProblem`. */
internal fun PsiUpdateModCommandAction<*>.asQuickFix(): LocalQuickFix = LocalQuickFix.from(this)!!

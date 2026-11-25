/*
 * Copyright 2026 Quentin Ligier. Use of this source code is governed by the MIT license.
 */

package ch.qligier.jetbrains.plugin.fss.fsh.structure

import ch.qligier.jetbrains.plugin.fss.common.FssIcons
import ch.qligier.jetbrains.plugin.fss.fsh.language.psi.FshNamedElement
import com.intellij.codeInsight.daemon.LineMarkerInfo
import com.intellij.codeInsight.daemon.LineMarkerProviderDescriptor
import com.intellij.openapi.editor.markup.GutterIconRenderer
import com.intellij.psi.PsiComment
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiWhiteSpace
import com.intellij.psi.util.PsiTreeUtil
import javax.swing.Icon

/**
 * Shows the entity icon in the gutter, on the line that declares a FSH entity (`Profile: …`, `ValueSet: …`, …).
 *
 * Line markers must be registered on leaf elements, so the marker is anchored on the entity's declaration keyword: the first
 * child of the entity that is not a comment or a whitespace (the entity's left binder includes its leading comments).
 *
 * @author Quentin Ligier
 **/
internal class FshLineMarkerProvider : LineMarkerProviderDescriptor() {
    override fun getName(): String = "FSH entity"

    override fun getIcon(): Icon = FssIcons.FSH_FILE

    override fun getLineMarkerInfo(element: PsiElement): LineMarkerInfo<*>? {
        if (element.firstChild != null) return null // Not a leaf
        if (element is PsiComment || element is PsiWhiteSpace) return null // A leading comment, or the whitespace around it
        val entity = element.parent as? FshNamedElement ?: return null
        if (PsiTreeUtil.skipWhitespacesAndCommentsBackward(element) != null) return null // Not the declaration keyword

        val kind = entity.getEntityKind()
        return LineMarkerInfo(
            element,
            element.textRange,
            kind.icon,
            { "${kind.keyword}: ${entity.name ?: "?"}" },
            null,
            GutterIconRenderer.Alignment.LEFT,
            { kind.keyword },
        )
    }
}

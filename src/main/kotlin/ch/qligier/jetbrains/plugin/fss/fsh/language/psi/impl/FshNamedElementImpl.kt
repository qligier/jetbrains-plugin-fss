/*
 * Copyright 2026 Quentin Ligier. Use of this source code is governed by the MIT license.
 */

package ch.qligier.jetbrains.plugin.fss.fsh.language.psi.impl

import ch.qligier.jetbrains.plugin.fss.common.FssIcons
import ch.qligier.jetbrains.plugin.fss.fsh.FshFileType
import ch.qligier.jetbrains.plugin.fss.fsh.language.psi.*
import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.ide.projectView.PresentationData
import com.intellij.lang.ASTNode
import com.intellij.navigation.ItemPresentation
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFileFactory
import com.intellij.psi.util.PsiTreeUtil
import javax.swing.Icon

/**
 * Abstract mixin base class for FSH entity PSI elements. Provides default implementations for [FshNamedElement]
 * methods: name identification, renaming, and navigation presentation.
 *
 * This class is used as the `mixin` in the BNF grammar for all entity rules, so that generated Impl classes extend it
 * instead of [ASTWrapperPsiElement] directly.
 *
 * @author Quentin Ligier
 */
abstract class FshNamedElementImpl(
    node: ASTNode,
) : ASTWrapperPsiElement(node),
    FshNamedElement {
    override fun getNameIdentifier(): PsiElement? {
        // For RuleSet: the name is inside the ruleSetId composite
        val ruleSetId = findChildByClass(FshRuleSetId::class.java)
        if (ruleSetId != null) {
            return PsiTreeUtil.getChildOfType(ruleSetId, FshNameToken::class.java)
        }
        // For most entities: direct nameToken child
        findChildByClass(FshNameToken::class.java)?.let { return it }
        // For Alias: the ALIAS_REF token
        return node.findChildByType(FshTypes.ALIAS_REF)?.psi
    }

    override fun getName(): String? = nameIdentifier?.text

    override fun setName(name: String): PsiElement {
        val nameIdentifier = nameIdentifier ?: return this
        val dummyContent =
            if (this is FshAlias) {
                val aliasName = if (name.startsWith("$")) name else "\$$name"
                "Alias: $aliasName = http://example.org"
            } else {
                "Profile: $name"
            }
        val dummyFile =
            PsiFileFactory
                .getInstance(project)
                .createFileFromText("dummy.fsh", FshFileType.INSTANCE, dummyContent)
        val newNameElement =
            if (this is FshAlias) {
                PsiTreeUtil
                    .findChildOfType(dummyFile, FshAlias::class.java)
                    ?.node
                    ?.findChildByType(FshTypes.ALIAS_REF)
                    ?.psi
            } else {
                PsiTreeUtil.findChildOfType(dummyFile, FshNameToken::class.java)
            }
        if (newNameElement != null) {
            nameIdentifier.replace(newNameElement)
        }
        return this
    }

    override fun getPresentation(): ItemPresentation = PresentationData(name ?: "?", getEntityType(), getIcon(), null)

    override fun getEntityType(): String =
        when (this) {
            is FshAlias -> "Alias"
            is FshProfile -> "Profile"
            is FshExtension -> "Extension"
            is FshResource -> "Resource"
            is FshLogical -> "Logical"
            is FshInstance -> "Instance"
            is FshValueSet -> "ValueSet"
            is FshCodeSystem -> "CodeSystem"
            is FshMapping -> "Mapping"
            is FshRuleSet -> "RuleSet"
            is FshInvariant -> "Invariant"
            else -> "Entity"
        }

    override fun getIcon(): Icon? =
        when (this) {
            is FshAlias -> FssIcons.ALIAS
            is FshProfile -> FssIcons.PROFILE
            is FshExtension -> FssIcons.EXTENSION
            is FshResource -> FssIcons.RESOURCE
            is FshLogical -> FssIcons.LOGICAL
            is FshInstance -> FssIcons.INSTANCE
            is FshValueSet -> FssIcons.VALUESET
            is FshCodeSystem -> FssIcons.CODESYSTEM
            is FshMapping -> FssIcons.MAPPING
            is FshRuleSet -> FssIcons.RULESET
            is FshInvariant -> FssIcons.INVARIANT
            else -> super.getIcon(0)
        }
}

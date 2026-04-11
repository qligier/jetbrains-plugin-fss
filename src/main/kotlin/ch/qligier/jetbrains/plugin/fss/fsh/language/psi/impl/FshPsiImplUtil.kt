/*
 * Copyright 2026 Quentin Ligier. Use of this source code is governed by the MIT license.
 */

package ch.qligier.jetbrains.plugin.fss.fsh.language.psi.impl

import ch.qligier.jetbrains.plugin.fss.fsh.language.psi.*
import com.intellij.psi.PsiElement
import com.intellij.psi.util.PsiTreeUtil

/**
 * Utility methods used by the generated PSI implementation classes.
 * Methods here are referenced in the BNF grammar via `methods = [...]`.
 */
object FshPsiImplUtil {
    // ─── Alias ─────────────────────────────────────────

    @JvmStatic
    fun getName(element: FshAlias): String? = element.node.findChildByType(FshTypes.ALIAS_REF)?.text

    @JvmStatic
    fun getAliasRef(element: FshAlias): String? = element.node.findChildByType(FshTypes.ALIAS_REF)?.text

    @JvmStatic
    fun getAliasValue(element: FshAlias): String? {
        val equalsNode = element.node.findChildByType(FshTypes.EQUALS) ?: return null
        var sibling = equalsNode.treeNext
        while (sibling != null) {
            if (sibling.elementType != com.intellij.psi.TokenType.WHITE_SPACE) {
                return sibling.text
            }
            sibling = sibling.treeNext
        }
        return null
    }

    // ─── Profile ───────────────────────────────────────

    @JvmStatic
    fun getName(element: FshProfile): String? = element.nameToken?.text

    @JvmStatic
    fun getMetadata(element: FshProfile): List<FshProfileMetadata> =
        PsiTreeUtil.getChildrenOfTypeAsList(element, FshProfileMetadata::class.java)

    @JvmStatic
    fun getRules(element: FshProfile): List<FshSdRule> = PsiTreeUtil.getChildrenOfTypeAsList(element, FshSdRule::class.java)

    // ─── Extension ─────────────────────────────────────

    @JvmStatic
    fun getName(element: FshExtension): String? = element.nameToken?.text

    @JvmStatic
    fun getMetadata(element: FshExtension): List<FshExtensionMetadata> =
        PsiTreeUtil.getChildrenOfTypeAsList(element, FshExtensionMetadata::class.java)

    @JvmStatic
    fun getRules(element: FshExtension): List<FshSdRule> = PsiTreeUtil.getChildrenOfTypeAsList(element, FshSdRule::class.java)

    // ─── Resource ──────────────────────────────────────

    @JvmStatic
    fun getName(element: FshResource): String? = element.nameToken?.text

    @JvmStatic
    fun getMetadata(element: FshResource): List<FshResourceMetadata> =
        PsiTreeUtil.getChildrenOfTypeAsList(element, FshResourceMetadata::class.java)

    @JvmStatic
    fun getRules(element: FshResource): List<FshSdRule> = PsiTreeUtil.getChildrenOfTypeAsList(element, FshSdRule::class.java)

    // ─── Logical ───────────────────────────────────────

    @JvmStatic
    fun getName(element: FshLogical): String? = element.nameToken?.text

    @JvmStatic
    fun getMetadata(element: FshLogical): List<FshLogicalMetadata> =
        PsiTreeUtil.getChildrenOfTypeAsList(element, FshLogicalMetadata::class.java)

    @JvmStatic
    fun getRules(element: FshLogical): List<FshSdRule> = PsiTreeUtil.getChildrenOfTypeAsList(element, FshSdRule::class.java)

    // ─── Instance ──────────────────────────────────────

    @JvmStatic
    fun getName(element: FshInstance): String? = element.nameToken?.text

    @JvmStatic
    fun getMetadata(element: FshInstance): List<FshInstanceMetadata> =
        PsiTreeUtil.getChildrenOfTypeAsList(element, FshInstanceMetadata::class.java)

    @JvmStatic
    fun getRules(element: FshInstance): List<FshInstanceRule> = PsiTreeUtil.getChildrenOfTypeAsList(element, FshInstanceRule::class.java)

    // ─── ValueSet ──────────────────────────────────────

    @JvmStatic
    fun getName(element: FshValueSet): String? = element.nameToken?.text

    @JvmStatic
    fun getMetadata(element: FshValueSet): List<FshVsMetadata> = PsiTreeUtil.getChildrenOfTypeAsList(element, FshVsMetadata::class.java)

    @JvmStatic
    fun getRules(element: FshValueSet): List<FshVsRule> = PsiTreeUtil.getChildrenOfTypeAsList(element, FshVsRule::class.java)

    // ─── CodeSystem ────────────────────────────────────

    @JvmStatic
    fun getName(element: FshCodeSystem): String? = element.nameToken?.text

    @JvmStatic
    fun getMetadata(element: FshCodeSystem): List<FshCsMetadata> = PsiTreeUtil.getChildrenOfTypeAsList(element, FshCsMetadata::class.java)

    @JvmStatic
    fun getRules(element: FshCodeSystem): List<FshCsRule> = PsiTreeUtil.getChildrenOfTypeAsList(element, FshCsRule::class.java)

    // ─── Mapping ───────────────────────────────────────

    @JvmStatic
    fun getName(element: FshMapping): String? = element.nameToken?.text

    @JvmStatic
    fun getMetadata(element: FshMapping): List<FshMappingEntityMetadata> =
        PsiTreeUtil.getChildrenOfTypeAsList(element, FshMappingEntityMetadata::class.java)

    @JvmStatic
    fun getRules(element: FshMapping): List<FshMappingRule> = PsiTreeUtil.getChildrenOfTypeAsList(element, FshMappingRule::class.java)

    // ─── RuleSet ───────────────────────────────────────

    @JvmStatic
    fun getName(element: FshRuleSet): String? = element.ruleSetId?.text

    @JvmStatic
    fun getRules(element: FshRuleSet): List<FshRuleSetRule> = PsiTreeUtil.getChildrenOfTypeAsList(element, FshRuleSetRule::class.java)

    // ─── Invariant ─────────────────────────────────────

    @JvmStatic
    fun getName(element: FshInvariant): String? = element.nameToken?.text

    @JvmStatic
    fun getMetadata(element: FshInvariant): List<FshInvariantMetadata> =
        PsiTreeUtil.getChildrenOfTypeAsList(element, FshInvariantMetadata::class.java)

    // ─── Path ──────────────────────────────────────────

    @JvmStatic
    fun getPathString(element: FshPath): String = element.text

    // ─── Rules ─────────────────────────────────────────

    @JvmStatic
    fun getFlags(element: FshCardRule): List<FshFlag> = PsiTreeUtil.getChildrenOfTypeAsList(element, FshFlag::class.java)

    @JvmStatic
    fun getFlags(element: FshFlagRule): List<FshFlag> = PsiTreeUtil.getChildrenOfTypeAsList(element, FshFlag::class.java)

    @JvmStatic
    fun isExactly(element: FshFixedValueRule): Boolean = element.node.findChildByType(FshTypes.KW_EXACTLY) != null

    @JvmStatic
    fun getBindingName(element: FshBindingRule): FshNameToken? = PsiTreeUtil.getChildOfType(element, FshNameToken::class.java)

    @JvmStatic
    fun getInvariantNames(element: FshObeysRule): List<FshNameToken> =
        PsiTreeUtil.getChildrenOfTypeAsList(element, FshNameToken::class.java)

    @JvmStatic
    fun getTargetTypes(element: FshOnlyRule): List<FshTargetType> = PsiTreeUtil.getChildrenOfTypeAsList(element, FshTargetType::class.java)

    @JvmStatic
    fun getContainsItems(element: FshContainsRule): List<FshContainsItem> =
        PsiTreeUtil.getChildrenOfTypeAsList(element, FshContainsItem::class.java)

    @JvmStatic
    fun getElementPath(element: FshCaretValueRule): FshPath? {
        val paths = PsiTreeUtil.getChildrenOfTypeAsList(element, FshPath::class.java)
        return if (paths.size >= 2) paths[0] else null
    }

    @JvmStatic
    fun getCaretPath(element: FshCaretValueRule): FshPath? {
        val paths = PsiTreeUtil.getChildrenOfTypeAsList(element, FshPath::class.java)
        return paths.lastOrNull()
    }

    @JvmStatic
    fun getFlags(element: FshAddElementRule): List<FshFlag> = PsiTreeUtil.getChildrenOfTypeAsList(element, FshFlag::class.java)

    @JvmStatic
    fun getTargetTypes(element: FshAddElementRule): List<FshTargetType> =
        PsiTreeUtil.getChildrenOfTypeAsList(element, FshTargetType::class.java)

    @JvmStatic
    fun getDescription(element: FshAddElementRule): PsiElement? =
        element.node.findChildByType(FshTypes.STRING)?.psi
            ?: element.node.findChildByType(FshTypes.MULTILINE_STRING)?.psi

    @JvmStatic
    fun getTarget(element: FshMappingEntityRule): PsiElement? = element.node.findChildByType(FshTypes.STRING)?.psi

    @JvmStatic
    fun getComment(element: FshMappingEntityRule): PsiElement? {
        val strings =
            element.node.getChildren(
                com.intellij.psi.tree.TokenSet
                    .create(FshTypes.STRING),
            )
        return strings.firstOrNull()?.psi
    }

    @JvmStatic
    fun getDefinition(element: FshConceptRule): PsiElement? {
        val strings =
            element.node.getChildren(
                com.intellij.psi.tree.TokenSet
                    .create(FshTypes.STRING),
            )
        return if (strings.size >= 2) strings[1].psi else null
    }
}

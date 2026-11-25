/*
 * Copyright 2026 Quentin Ligier. Use of this source code is governed by the MIT license.
 */
package ch.qligier.jetbrains.plugin.fss.fsh.language.psi.impl

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.psi.ContributedReferenceHost
import com.intellij.psi.PsiReference
import com.intellij.psi.impl.source.resolve.reference.ReferenceProvidersRegistry

/**
 * Base class of the nodes that host references (`mixin` in fsh.bnf): names of entities and RuleSets, value sets, invariants,
 * types, extensions, code systems, reference targets, paths, codes, contentReference targets, Context items and alias values.
 *
 * The references themselves come from the plugin's `psi.referenceContributor`s, so the PSI classes need no change when the plugin
 * adds or refines them.
 */
abstract class FshReferenceHostMixin(
    node: ASTNode,
) : ASTWrapperPsiElement(node),
    ContributedReferenceHost {
    override fun getReferences(): Array<PsiReference> = ReferenceProvidersRegistry.getReferencesFromProviders(this)

    override fun getReference(): PsiReference? = references.firstOrNull()
}

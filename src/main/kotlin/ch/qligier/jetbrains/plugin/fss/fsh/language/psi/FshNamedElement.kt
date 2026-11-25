/*
 * Copyright 2026 Quentin Ligier. Use of this source code is governed by the MIT license.
 */
package ch.qligier.jetbrains.plugin.fss.fsh.language.psi

import ch.qligier.jetbrains.plugin.fss.fsh.language.psi.stubs.FshEntityStub
import com.intellij.psi.NavigatablePsiElement
import com.intellij.psi.PsiNameIdentifierOwner
import com.intellij.psi.StubBasedPsiElement

/**
 * An FSH entity (Alias, Profile, …, Mapping): a named, navigable PSI element backed by a stub, which the entity name index
 * ([ch.qligier.jetbrains.plugin.fss.fsh.language.psi.stubs.FshEntityNameIndex]) finds project-wide.
 *
 * Every entity node type implements it, through `implements("entity")` and the [ch.qligier.jetbrains.plugin.fss.fsh.language.psi.impl.FshEntityMixin]
 * in fsh.bnf. Same contract as the plugin's earlier `FshNamedElement`, with the kind as an enum.
 */
interface FshNamedElement :
    NavigatablePsiElement,
    PsiNameIdentifierOwner,
    StubBasedPsiElement<FshEntityStub> {
    /** The kind of entity, from its node type (or its stub). */
    fun getEntityKind(): FshEntityKind

    /** The entity type shown to users: its declaration keyword (`Profile`, `ValueSet`, …). */
    fun getEntityType(): String = getEntityKind().keyword

    /** The `Id:` metadata value, as written, or null. */
    fun getIdValue(): String?

    /** The `Parent:` metadata value, as written, or null. */
    fun getParentValue(): String?

    /** The `InstanceOf:` metadata value, as written, or null. */
    fun getInstanceOfValue(): String?
}

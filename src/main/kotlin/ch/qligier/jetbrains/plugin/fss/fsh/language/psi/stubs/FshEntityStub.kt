/*
 * Copyright 2026 Quentin Ligier. Use of this source code is governed by the MIT license.
 */
package ch.qligier.jetbrains.plugin.fss.fsh.language.psi.stubs

import ch.qligier.jetbrains.plugin.fss.fsh.language.psi.FshEntityKind
import ch.qligier.jetbrains.plugin.fss.fsh.language.psi.FshNamedElement
import com.intellij.psi.stubs.IStubElementType
import com.intellij.psi.stubs.StubBase
import com.intellij.psi.stubs.StubElement

/**
 * The stub of an FSH entity: what project-wide features need without parsing the file (go to symbol, reference resolution,
 * completion of entity names). Entities are direct children of the file, so the stub tree is one level deep.
 */
interface FshEntityStub : StubElement<FshNamedElement> {
    val kind: FshEntityKind

    /** The declared name (for an Alias, `$name` as written), or null in an incomplete declaration. */
    val name: String?

    /** The `Id:`, `Parent:` and `InstanceOf:` metadata values, as written. */
    val idValue: String?
    val parentName: String?
    val instanceOf: String?
}

class FshEntityStubImpl(
    parent: StubElement<*>?,
    type: IStubElementType<*, *>,
    override val kind: FshEntityKind,
    override val name: String?,
    override val idValue: String?,
    override val parentName: String?,
    override val instanceOf: String?,
) : StubBase<FshNamedElement>(parent, type),
    FshEntityStub

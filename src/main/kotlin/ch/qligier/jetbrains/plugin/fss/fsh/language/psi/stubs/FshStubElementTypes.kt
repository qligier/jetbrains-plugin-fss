/*
 * Copyright 2026 Quentin Ligier. Use of this source code is governed by the MIT license.
 */
package ch.qligier.jetbrains.plugin.fss.fsh.language.psi.stubs

import ch.qligier.jetbrains.plugin.fss.fsh.FshLanguage
import ch.qligier.jetbrains.plugin.fss.fsh.language.psi.FshEntityKind
import ch.qligier.jetbrains.plugin.fss.fsh.language.psi.FshFile
import ch.qligier.jetbrains.plugin.fss.fsh.language.psi.FshNamedElement
import ch.qligier.jetbrains.plugin.fss.fsh.language.psi.impl.*
import com.intellij.psi.PsiElement
import com.intellij.psi.stubs.*
import com.intellij.psi.tree.IElementType
import com.intellij.psi.tree.IStubFileElementType

/** The element type factory that fsh.bnf names in `elementTypeFactory(".*_entity")`: every entity node type is a stub type. */
object FshStubElementTypes {
    @JvmStatic
    fun factory(name: String): IElementType = FshEntityStubElementType(name)
}

/** The FSH file's element type, with a stub tree. Bump [getStubVersion] whenever the stubs or the entity grammar change. */
object FshFileStubElementType : IStubFileElementType<PsiFileStub<FshFile>>("FSH_FILE", FshLanguage) {
    override fun getStubVersion(): Int = 1

    override fun getExternalId(): String = "fsh.FILE"
}

/** The stub element type of one entity kind (`PROFILE_ENTITY`, …). */
class FshEntityStubElementType(
    /** The node type name (`PROFILE_ENTITY`, …), kept here: `IElementType.getDebugName()` is internal API. */
    private val typeName: String,
) : IStubElementType<FshEntityStub, FshNamedElement>(typeName, FshLanguage) {
    private val kind = FshEntityKind.fromElementTypeName(typeName)

    override fun getExternalId(): String = "fsh.$this"

    override fun createStub(
        psi: FshNamedElement,
        parentStub: StubElement<out PsiElement>?,
    ): FshEntityStub =
        FshEntityStubImpl(
            parentStub,
            this,
            kind,
            psi.name,
            psi.getIdValue(),
            psi.getParentValue(),
            psi.getInstanceOfValue(),
        )

    override fun createPsi(stub: FshEntityStub): FshNamedElement =
        when (typeName) {
            "ALIAS_ENTITY" -> FshAliasEntityImpl(stub, this)
            "PROFILE_ENTITY" -> FshProfileEntityImpl(stub, this)
            "EXTENSION_ENTITY" -> FshExtensionEntityImpl(stub, this)
            "LOGICAL_ENTITY" -> FshLogicalEntityImpl(stub, this)
            "RESOURCE_ENTITY" -> FshResourceEntityImpl(stub, this)
            "INSTANCE_ENTITY" -> FshInstanceEntityImpl(stub, this)
            "INVARIANT_ENTITY" -> FshInvariantEntityImpl(stub, this)
            "VALUE_SET_ENTITY" -> FshValueSetEntityImpl(stub, this)
            "CODE_SYSTEM_ENTITY" -> FshCodeSystemEntityImpl(stub, this)
            "RULE_SET_ENTITY" -> FshRuleSetEntityImpl(stub, this)
            "PARAM_RULE_SET_ENTITY" -> FshParamRuleSetEntityImpl(stub, this)
            "MAPPING_ENTITY" -> FshMappingEntityImpl(stub, this)
            else -> throw IllegalStateException("Not an entity element type: $typeName")
        }

    override fun serialize(
        stub: FshEntityStub,
        dataStream: StubOutputStream,
    ) {
        dataStream.writeName(stub.name)
        dataStream.writeName(stub.idValue)
        dataStream.writeName(stub.parentName)
        dataStream.writeName(stub.instanceOf)
    }

    override fun deserialize(
        dataStream: StubInputStream,
        parentStub: StubElement<*>?,
    ): FshEntityStub =
        FshEntityStubImpl(
            parentStub,
            this,
            kind,
            name = dataStream.readNameString(),
            idValue = dataStream.readNameString(),
            parentName = dataStream.readNameString(),
            instanceOf = dataStream.readNameString(),
        )

    override fun indexStub(
        stub: FshEntityStub,
        sink: IndexSink,
    ) {
        stub.name?.let { sink.occurrence(FshEntityNameIndex.KEY, it) }
    }
}

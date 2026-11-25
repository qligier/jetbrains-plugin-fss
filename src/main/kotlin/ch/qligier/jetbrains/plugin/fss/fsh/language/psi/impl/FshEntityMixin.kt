/*
 * Copyright 2026 Quentin Ligier. Use of this source code is governed by the MIT license.
 */
package ch.qligier.jetbrains.plugin.fss.fsh.language.psi.impl

import ch.qligier.jetbrains.plugin.fss.fsh.FshLanguage
import ch.qligier.jetbrains.plugin.fss.fsh.language.psi.*
import ch.qligier.jetbrains.plugin.fss.fsh.language.psi.stubs.FshEntityStub
import com.intellij.extapi.psi.StubBasedPsiElementBase
import com.intellij.lang.ASTNode
import com.intellij.navigation.ItemPresentation
import com.intellij.openapi.util.NlsSafe
import com.intellij.psi.PsiComment
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFileFactory
import com.intellij.psi.PsiWhiteSpace
import com.intellij.psi.stubs.IStubElementType
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.util.IncorrectOperationException
import javax.swing.Icon

/**
 * Base class of every entity node (`mixin("entity")` in fsh.bnf): name identifier, rename, presentation and navigation, with the
 * name, kind and metadata values read from the stub when the file is not parsed.
 */
abstract class FshEntityMixin :
    StubBasedPsiElementBase<FshEntityStub>,
    FshNamedElement {
    constructor(node: ASTNode) : super(node)

    constructor(stub: FshEntityStub, type: IStubElementType<*, *>) : super(stub, type)

    override fun getEntityKind(): FshEntityKind = greenStub?.kind ?: FshEntityKind.fromElementTypeName(node.elementType.toString())

    /** The `entity_name` node. */
    override fun getNameIdentifier(): PsiElement? = node.findChildByType(FshTypes.ENTITY_NAME)?.psi

    override fun getName(): @NlsSafe String? = greenStub?.name ?: nameIdentifier?.text

    /**
     * Renames the entity: parses `Keyword: newName` and swaps the name node. Checking that the new name is valid is the plugin's
     * job (a `NamesValidator`); a name that does not parse as one name word fails here.
     */
    override fun setName(name: String): PsiElement {
        val identifier = nameIdentifier ?: throw IncorrectOperationException("The entity has no name to rename")
        val keyword = getEntityKind().keyword
        val text = if (getEntityKind() == FshEntityKind.ALIAS) "$keyword: $name = x" else "$keyword: $name"
        val dummy = PsiFileFactory.getInstance(project).createFileFromText("dummy.fsh", FshLanguage, text)
        val newIdentifier =
            dummy.node.firstChildNode
                ?.findChildByType(FshTypes.ENTITY_NAME)
                ?.takeIf { it.text == name }
                ?: throw IncorrectOperationException("Not a valid entity name: '$name'")
        identifier.node.replaceAllChildrenToChildrenOf(newIdentifier)
        return this
    }

    /** Navigation lands on the name, not on the comments that the entity's left binder includes (D11). */
    override fun getTextOffset(): Int = nameIdentifier?.textOffset ?: declarationKeyword()?.textOffset ?: super.getTextOffset()

    override fun getPresentation(): ItemPresentation =
        object : ItemPresentation {
            override fun getPresentableText(): String = name ?: "?"

            override fun getLocationString(): String = getEntityType()

            override fun getIcon(unused: Boolean): Icon = getEntityKind().icon
        }

    override fun getIcon(flags: Int): Icon? = getEntityKind().icon

    override fun getIdValue(): String? = greenStub?.idValue ?: metadataValue(FshIdMetadata::class.java)

    override fun getParentValue(): String? = greenStub?.parentName ?: metadataValue(FshParentMetadata::class.java)

    override fun getInstanceOfValue(): String? = greenStub?.instanceOf ?: metadataValue(FshInstanceOfMetadata::class.java)

    /** The text of the first value of the first metadata of [type] (metadata can repeat; annotators report it). */
    private fun metadataValue(type: Class<out FshMetadata>): String? =
        PsiTreeUtil
            .getChildrenOfTypeAsList(this, type)
            .firstOrNull()
            ?.let { PsiTreeUtil.getChildOfType(it, FshValue::class.java) }
            ?.text

    private fun declarationKeyword(): PsiElement? {
        var child = firstChild
        while (child is PsiWhiteSpace || child is PsiComment) child = child.nextSibling
        return child
    }

    /** Same format as the generated PSI classes (golden dumps); debug only, it loads the AST of a stub-backed element. */
    override fun toString(): String = "${javaClass.simpleName}(${node.elementType})"
}

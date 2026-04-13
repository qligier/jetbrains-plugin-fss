/*
 * Copyright 2026 Quentin Ligier. Use of this source code is governed by the MIT license.
 */

package ch.qligier.jetbrains.plugin.fss.fsh.language.psi

import ch.qligier.jetbrains.plugin.fss.fsh.FshFileType
import ch.qligier.jetbrains.plugin.fss.fsh.FshLanguage
import ch.qligier.jetbrains.plugin.fss.fsh.language.psi.FshEntity
import com.intellij.extapi.psi.PsiFileBase
import com.intellij.openapi.fileTypes.FileType
import com.intellij.psi.FileViewProvider
import com.intellij.psi.util.PsiTreeUtil
import kotlin.jvm.java

class FshFile(viewProvider: FileViewProvider) : PsiFileBase(viewProvider, FshLanguage) {
    override fun getFileType(): FileType = FshFileType.INSTANCE

    override fun toString(): String = "FSH file"

    fun getEntities(): List<FshEntity> = PsiTreeUtil.getChildrenOfTypeAsList(this, FshEntity::class.java)

    fun getAliases(): List<FshAlias> = PsiTreeUtil.getChildrenOfTypeAsList(this, FshAlias::class.java)

    fun getProfiles(): List<FshProfile> = PsiTreeUtil.getChildrenOfTypeAsList(this, FshProfile::class.java)

    fun getExtensions(): List<FshExtension> = PsiTreeUtil.getChildrenOfTypeAsList(this, FshExtension::class.java)

    fun getResources(): List<FshResource> = PsiTreeUtil.getChildrenOfTypeAsList(this, FshResource::class.java)

    fun getLogicals(): List<FshLogical> = PsiTreeUtil.getChildrenOfTypeAsList(this, FshLogical::class.java)

    fun getInstances(): List<FshInstance> = PsiTreeUtil.getChildrenOfTypeAsList(this, FshInstance::class.java)

    fun getValueSets(): List<FshValueSet> = PsiTreeUtil.getChildrenOfTypeAsList(this, FshValueSet::class.java)

    fun getCodeSystems(): List<FshCodeSystem> = PsiTreeUtil.getChildrenOfTypeAsList(this, FshCodeSystem::class.java)

    fun getMappings(): List<FshMapping> = PsiTreeUtil.getChildrenOfTypeAsList(this, FshMapping::class.java)

    fun getRuleSets(): List<FshRuleSet> = PsiTreeUtil.getChildrenOfTypeAsList(this, FshRuleSet::class.java)

    fun getInvariants(): List<FshInvariant> = PsiTreeUtil.getChildrenOfTypeAsList(this, FshInvariant::class.java)
}


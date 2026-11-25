/*
 * Copyright 2026 Quentin Ligier. Use of this source code is governed by the MIT license.
 */
package ch.qligier.jetbrains.plugin.fss.fsh.language.psi.stubs

import ch.qligier.jetbrains.plugin.fss.fsh.language.psi.FshNamedElement
import com.intellij.openapi.project.Project
import com.intellij.psi.search.GlobalSearchScope
import com.intellij.psi.stubs.StringStubIndexExtension
import com.intellij.psi.stubs.StubIndex
import com.intellij.psi.stubs.StubIndexKey

/** Project-wide index of FSH entities by declared name (an Alias by its `$name`). Registered as a `stubIndex` in plugin.xml. */
internal class FshEntityNameIndex : StringStubIndexExtension<FshNamedElement>() {
    override fun getKey(): StubIndexKey<String, FshNamedElement> = KEY

    override fun getVersion(): Int = super.getVersion() + 1

    companion object {
        @JvmField
        val KEY: StubIndexKey<String, FshNamedElement> = StubIndexKey.createIndexKey("fsh.entity.name")

        /** The entities declared with [name] in [scope]. */
        fun find(
            project: Project,
            name: String,
            scope: GlobalSearchScope = GlobalSearchScope.allScope(project),
        ): Collection<FshNamedElement> = StubIndex.getElements(KEY, name, project, scope, FshNamedElement::class.java)

        /** Every entity name in the project, for completion and go to symbol. */
        fun allNames(project: Project): Collection<String> = StubIndex.getInstance().getAllKeys(KEY, project)
    }
}

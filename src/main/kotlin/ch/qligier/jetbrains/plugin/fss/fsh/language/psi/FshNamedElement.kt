/*
 * Copyright 2026 Quentin Ligier. Use of this source code is governed by the MIT license.
 */

package ch.qligier.jetbrains.plugin.fss.fsh.language.psi

import com.intellij.psi.NavigatablePsiElement
import com.intellij.psi.PsiNameIdentifierOwner

/**
 * Common interface for FSH entity PSI elements (Profile, Extension, Resource, Logical, Instance, ValueSet, CodeSystem,
 * Mapping, RuleSet, Invariant, Alias). Extends [NavigatablePsiElement] for IDE navigation support and
 * [PsiNameIdentifierOwner] for name-based identification and rename refactoring.
 *
 * @author Quentin Ligier
 */
interface FshNamedElement : NavigatablePsiElement, PsiNameIdentifierOwner


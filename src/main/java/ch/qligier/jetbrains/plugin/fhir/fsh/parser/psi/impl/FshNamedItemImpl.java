// Copyright 2022 Quentin Ligier. Use of this source code is governed by the MIT license.

package ch.qligier.jetbrains.plugin.fhir.fsh.parser.psi.impl;

import ch.qligier.jetbrains.plugin.fhir.fsh.parser.psi.FshNamedItem;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import org.jetbrains.annotations.NotNull;

/**
 * Abstract implementation of a named FSH item.
 *
 * @author Quentin Ligier
 */
public abstract class FshNamedItemImpl extends ASTWrapperPsiElement implements FshNamedItem {

    /**
     * Constructor.
     *
     * @param node The AST node.
     */
    public FshNamedItemImpl(@NotNull final ASTNode node) {
        super(node);
    }
}

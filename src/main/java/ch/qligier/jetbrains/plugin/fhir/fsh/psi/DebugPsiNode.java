// Copyright 2024 Quentin Ligier. Use of this source code is governed by the MIT license.

package ch.qligier.jetbrains.plugin.fhir.fsh.psi;

import com.intellij.lang.ASTNode;
import org.antlr.intellij.adaptor.psi.ANTLRPsiNode;
import org.jetbrains.annotations.NotNull;

/**
 * jetbrains-plugin-fhir
 *
 * @author Quentin Ligier
 **/
public class DebugPsiNode extends ANTLRPsiNode {

    private final String text;
    private final ASTNode node;

    public DebugPsiNode(@NotNull final ASTNode node,
                        final String text) {
        super(node);
        this.text = text;
        this.node = node;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" + node.getElementType() + ", " + text + ")";
    }
}

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
public class FshPsiDocument extends ANTLRPsiNode {
    public FshPsiDocument(@NotNull final ASTNode node) {
        super(node);
    }
}

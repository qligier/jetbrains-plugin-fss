// Copyright 2024 Quentin Ligier. Use of this source code is governed by the MIT license.

package ch.qligier.jetbrains.plugin.fhir.fsh.psi;

import com.intellij.lang.ASTNode;
import org.antlr.intellij.adaptor.psi.ANTLRPsiNode;

/**
 * Represents a PSI node in the FSH language.
 *
 * @author Quentin Ligier
 */
public class FshPsiAntlrNode extends ANTLRPsiNode {

    public FshPsiAntlrNode(final ASTNode node) {
        super(node);
    }
}

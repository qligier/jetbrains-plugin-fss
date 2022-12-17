// Copyright 2022 Quentin Ligier. Use of this source code is governed by the MIT license.

package ch.qligier.jetbrains.plugin.fhir.fsh.parser.psi.impl;

import ch.qligier.jetbrains.plugin.fhir.fsh.parser.psi.*;
import ch.qligier.jetbrains.plugin.fhir.fsh.reference.FshReference;
import ch.qligier.jetbrains.plugin.fhir.fsh.specification.MetadataType;
import com.intellij.lang.ASTNode;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.*;
import com.intellij.psi.impl.source.tree.LeafPsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;

/**
 * Utility methods that are inserted in PSI files by the parser generator.
 *
 * @author Quentin Ligier
 * @see <a
 * href="https://plugins.jetbrains.com/docs/intellij/reference-contributor.html#define-helper-methods-for-generated-psi-elements">Define
 * Helper Methods for Generated PSI Elements</a>
 */
public class FshPsiImplUtil {

    /**
     * This class is not instantiable.
     */
    private FshPsiImplUtil() {
    }

    @Nullable
    public static PsiElement getValueElement(@NotNull final FshMetadata metadataElement) {
        return metadataElement.getFirstChild();
    }

    public static String getName(@NotNull final FshId element) {
        final ASTNode keyNode = element.getNode().findChildByType(FshTypes.IDENTIFIER);
        if (keyNode != null) {
            return keyNode.getText();
        } else {
            return null;
        }
    }

    public static PsiElement setName(@NotNull final FshId element, String newName) {
        ASTNode keyNode = element.getNode().findChildByType(FshTypes.IDENTIFIER);
        if (keyNode instanceof LeafPsiElement) {
            ((LeafPsiElement) keyNode).replaceWithText(newName);
        }
        return element;
    }

    public static PsiElement getNameIdentifier(@NotNull final FshId element) {
        ASTNode keyNode = element.getNode().findChildByType(FshTypes.IDENTIFIER);
        return keyNode != null ? keyNode.getPsi() : null;
    }

    public static FshReference getReference(@NotNull final FshIdentifierRef identifier) {
        return new FshReference(identifier, new TextRange(0, identifier.getTextLength()));
    }

    public static FshReference getReference(@NotNull final FshItemIdentifier identifier) {
        final var child = identifier.getFirstChild();
        // The ItemIdentifier should contain a leaf PsiElement(Identifier) that must be used here
        if (child != null) {
            return new FshReference(identifier, child.getTextRangeInParent());
        }
        return null;
    }

    public static int getParameterCount(@NotNull final FshRuleSetReference ruleSetReference) {
        // The item name identifier is inside a FshIdentifierRef, it won't appear here
        return (int) Arrays.stream(ruleSetReference.getChildren())
                .filter(child -> child.getNode().getElementType() == FshTypes.IDENTIFIER)
                .count();
    }

    public static MetadataType getMetadataType(@NotNull final FshMetadata metadata) {
        if (metadata instanceof FshId) {
            return MetadataType.ID;
        } else if (metadata instanceof FshDescription) {
            return MetadataType.DESCRIPTION;
        } else if (metadata instanceof FshTitle) {
            return MetadataType.TITLE;
        } else if (metadata instanceof FshParent) {
            return MetadataType.PARENT;
        } else if (metadata instanceof FshInstanceOf) {
            return MetadataType.INSTANCE_OF;
        } else if (metadata instanceof FshUsage) {
            return MetadataType.USAGE;
        } else if (metadata instanceof FshSource) {
            return MetadataType.SOURCE;
        } else if (metadata instanceof FshTarget) {
            return MetadataType.TARGET;
        } else if (metadata instanceof FshSeverity) {
            return MetadataType.SEVERITY;
        } else if (metadata instanceof FshXpath) {
            return MetadataType.XPATH;
        } else if (metadata instanceof FshExpression) {
            return MetadataType.EXPRESSION;
        } else {
            throw new IllegalStateException("Unknown implementation of FshMetadata");
        }
    }

    // FshString (PsiLanguageInjectionHost)

    /**
     * @return {@code true} if this instance can accept injections, {@code false} otherwise
     */
    public static boolean isValidHost(@NotNull final FshString fshString) {
        final var parent = fshString.getParent();
        final var parentType = (parent != null) ? parent.getNode().getElementType() : null;
        return parentType == FshTypes.TITLE || parentType == FshTypes.DESCRIPTION;
    }

    /**
     * Update the host element using the provided text of the injected file. It may be required to escape characters
     * from {@code text} in accordance with the host language syntax. The implementation may delegate to
     * {@link ElementManipulators#handleContentChange(PsiElement, String)} if {@link ElementManipulator} implementation
     * is registered for this element class.
     *
     * @param text text of the injected file
     * @return the updated instance
     */
    public static PsiLanguageInjectionHost updateText(@NotNull final FshString fshString, @NotNull String text) {
        return null;
    }

    /**
     * @return {@link LiteralTextEscaper} instance which will be used to convert the content of this host element to the
     * content of injected file
     */
    @NotNull
    public static LiteralTextEscaper<? extends PsiLanguageInjectionHost> createLiteralTextEscaper(@NotNull final FshString fshString) {
        return LiteralTextEscaper.createSimple(fshString);
    }
}

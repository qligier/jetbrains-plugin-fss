// Copyright 2022 Quentin Ligier. Use of this source code is governed by the MIT license.

package ch.qligier.jetbrains.plugin.fhir.fsh.parser.psi.impl;

import ch.qligier.jetbrains.plugin.fhir.fsh.FshItemType;
import ch.qligier.jetbrains.plugin.fhir.fsh.FshMetadataPolicy;
import ch.qligier.jetbrains.plugin.fhir.fsh.FshNameType;
import ch.qligier.jetbrains.plugin.fhir.fsh.parser.psi.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.navigation.ItemPresentation;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.util.NlsSafe;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiNameIdentifierOwner;
import com.intellij.psi.impl.source.tree.LeafPsiElement;
import com.intellij.util.ArrayUtil;
import com.intellij.util.IncorrectOperationException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of custom methods for FSH item PSI elements.
 *
 * @author Quentin Ligier
 * @see FshItemCustom
 */
public abstract class FshItemImplCustom extends ASTWrapperPsiElement implements FshItemCustom {
    public static final Logger LOG = Logger.getInstance("FshItemImplCustom");

    /**
     * Constructor.
     *
     * @param node The AST node.
     */
    public FshItemImplCustom(@NotNull final ASTNode node) {
        super(node);
    }

    /**
     * Returns the name of the element.
     *
     * @return the element name.
     */
    @Override
    public String getName() {
        final ASTNode keyNode = this.getNode().findChildByType(FshTypes.IDENTIFIER);
        if (keyNode != null) {
            return keyNode.getText();
        } else {
            return null;
        }
    }

    /**
     * Renames the element.
     *
     * @param newName the new element name.
     * @return the element corresponding to this element after the renaming (either {@code this} or a different element
     * if the renaming caused the element to be replaced).
     * @throws IncorrectOperationException if the modification is not supported or not possible for some reason.
     */
    @Override
    public PsiElement setName(@NotNull final String newName) {
        final ASTNode keyNode = this.getNode().findChildByType(FshTypes.IDENTIFIER);
        if (keyNode instanceof LeafPsiElement) {
            ((LeafPsiElement) keyNode).replaceWithText(newName);
        }
        return this;
    }

    /**
     * Implementation of {@link PsiNameIdentifierOwner#getNameIdentifier()}.
     *
     * @return
     */
    @Override
    public PsiElement getNameIdentifier() {
        final var keyNode = this.getNode().findChildByType(FshTypes.IDENTIFIER);
        if (keyNode != null) {
            return keyNode.getPsi();
        } else {
            return null;
        }
    }

    /**
     * Retrieves all PSI elements of item metadata.
     */
    @Override
    public List<FshMetadata> getMetadataElements() {
        return List.of(this.findChildrenByClass(FshMetadata.class));
    }

    /**
     * Retrieves the PSI element of an Id metadata.
     */
    @Nullable
    @Override
    public FshId getIdElement() {
        return this.findChildByClass(FshId.class);
    }

    /**
     * Retrieves the PSI element of a Description metadata.
     */
    @Nullable
    @Override
    public FshDescription getDescriptionElement() {
        return this.findChildByClass(FshDescription.class);
    }

    /**
     * Retrieves the PSI element of a Title metadata.
     */
    @Nullable
    @Override
    public FshTitle getTitleElement() {
        return this.findChildByClass(FshTitle.class);
    }

    /**
     * Retrieves the PSI element of a Parent metadata.
     */
    @Nullable
    @Override
    public FshParent getParentElement() {
        return this.findChildByClass(FshParent.class);
    }

    /**
     * Retrieves the PSI element of an InstanceOf metadata.
     */
    @Nullable
    @Override
    public FshInstanceOf getInstanceOfElement() {
        return this.findChildByClass(FshInstanceOf.class);
    }

    /**
     * Retrieves the PSI element of a Usage metadata.
     */
    @Nullable
    @Override
    public FshUsage getUsageElement() {
        return this.findChildByClass(FshUsage.class);
    }

    /**
     * Retrieves the PSI element of a Source metadata.
     */
    @Nullable
    @Override
    public FshSource getSourceElement() {
        return this.findChildByClass(FshSource.class);
    }

    /**
     * Retrieves the PSI element of a Target metadata.
     */
    @Nullable
    @Override
    public FshTarget getTargetElement() {
        return this.findChildByClass(FshTarget.class);
    }

    /**
     * Retrieves the PSI element of a Severity metadata.
     */
    @Nullable
    @Override
    public FshSeverity getSeverityElement() {
        return this.findChildByClass(FshSeverity.class);
    }

    /**
     * Retrieves the PSI element of an XPath metadata.
     */
    @Nullable
    @Override
    public FshXpath getXPathElement() {
        return this.findChildByClass(FshXpath.class);
    }

    /**
     * Retrieves the PSI element of an Expression metadata.
     */
    @Nullable
    @Override
    public FshExpression getExpressionElement() {
        return this.findChildByClass(FshExpression.class);
    }

    @Override
    public FshItemType getItemType() {
        if (this instanceof FshAlias) {
            return FshItemType.ALIAS;
        } else if (this instanceof FshProfile) {
            return FshItemType.PROFILE;
        } else if (this instanceof FshExtension) {
            return FshItemType.EXTENSION;
        } else if (this instanceof FshInvariant) {
            return FshItemType.INVARIANT;
        } else if (this instanceof FshInstance) {
            return FshItemType.INSTANCE;
        } else if (this instanceof FshValueSet) {
            return FshItemType.VALUESET;
        } else if (this instanceof FshCodeSystem) {
            return FshItemType.CODESYSTEM;
        } else if (this instanceof FshRuleSet) {
            return FshItemType.RULESET;
        } else if (this instanceof FshMapping) {
            return FshItemType.MAPPING;
        } else if (this instanceof FshLogical) {
            return FshItemType.LOGICAL;
        } else if (this instanceof FshResource) {
            return FshItemType.RESOURCE;
        }
        LOG.error("Unknown item type in getItemType()");
        return FshItemType.ALIAS;
    }

    /**
     * Generates the placeholder text shown when the item is folded.
     */
    @Override
    public String getFoldedPlaceholder() {
        return this.getItemType().getName() + ": " + this.getName();
    }

    /**
     * Returns the presentation of an item in a tree, list or similar view. Used in the structure view.
     */
    @Override
    public ItemPresentation getPresentation() {
        final var item = this;
        return new ItemPresentation() {
            /**
             * Returns the name of the object to be presented in most renderers across the program.
             *
             * @return the object name.
             */
            @Override
            public @NlsSafe @Nullable String getPresentableText() {
                return item.getName();
            }

            /**
             * Returns the location of the object (for example, the package of a class). The location string
             * is used by some renderers and usually displayed as grayed text next to the item name.
             *
             * @return the location description, or null if none is applicable.
             */
            @Override
            public @NlsSafe @Nullable String getLocationString() {
                final PsiFile file = item.getContainingFile();
                return file != null ? file.getName() : null;
            }

            /**
             * Returns the icon representing the object.
             *
             * @param unused Used to mean if open/close icons for tree renderer. No longer in use. The parameter is only there for API compatibility reason.
             */
            @Override
            public @Nullable Icon getIcon(final boolean unused) {
                return item.getItemType().getIcon();
            }
        };
    }

    /**
     * Returns the type of the item name. An expression, id or name. See
     * <a href="https://build.fhir.org/ig/HL7/fhir-shorthand/reference.html#declaration-statements">Declaration
     * Statements</a>
     */
    public FshNameType getNameType() {
        return this.getItemType().getNameType();
    }

    public FshMetadataPolicy getMetadataPolicy() {
        return this.getItemType().getMetadataPolicy();
    }

    @Override
    public <T> T @NotNull [] findChildrenByClass(Class<T> aClass) {
        List<T> result = new ArrayList<>();
        for (PsiElement cur = getFirstChild(); cur != null; cur = cur.getNextSibling()) {
            if (aClass.isInstance(cur)) result.add((T)cur);
        }
        return result.toArray(ArrayUtil.newArray(aClass, result.size()));
    }
}

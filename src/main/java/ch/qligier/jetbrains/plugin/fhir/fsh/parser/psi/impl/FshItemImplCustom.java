// Copyright 2022 Quentin Ligier. Use of this source code is governed by the MIT license.

package ch.qligier.jetbrains.plugin.fhir.fsh.parser.psi.impl;

import ch.qligier.jetbrains.plugin.fhir.fsh.parser.psi.*;
import ch.qligier.jetbrains.plugin.fhir.fsh.specification.ItemNameType;
import ch.qligier.jetbrains.plugin.fhir.fsh.specification.ItemType;
import ch.qligier.jetbrains.plugin.fhir.fsh.specification.MetadataPolicy;
import ch.qligier.jetbrains.plugin.fhir.fsh.specification.MetadataType;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.navigation.ItemPresentation;
import com.intellij.openapi.diagnostic.Logger;
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
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Implementation of custom methods for FSH item PSI elements.
 *
 * @author Quentin Ligier
 * @see FshItemCustom
 */
public abstract class FshItemImplCustom extends ASTWrapperPsiElement implements FshItemCustom {
    private static final Logger LOG = Logger.getInstance("FshItemImplCustom");

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
     * Retrieves all PSI elements of item metadata.
     */
    @Override
    public List<FshMetadata> getMetadataElements(final MetadataType type) {
        return Stream.of(this.findChildrenByClass(FshMetadata.class))
                .filter(child -> child.getMetadataType() == type)
                .collect(Collectors.toUnmodifiableList());
    }

    @Override
    @Nullable
    public FshMetadata getMetadata(final MetadataType type) {
        return Stream.of(this.findChildrenByClass(FshMetadata.class))
                .filter(child -> child.getMetadataType() == type)
                .findFirst()
                .orElse(null);
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
    public ItemType getItemType() {
        if (this instanceof FshAlias) {
            return ItemType.ALIAS;
        } else if (this instanceof FshProfile) {
            return ItemType.PROFILE;
        } else if (this instanceof FshExtension) {
            return ItemType.EXTENSION;
        } else if (this instanceof FshInvariant) {
            return ItemType.INVARIANT;
        } else if (this instanceof FshInstance) {
            return ItemType.INSTANCE;
        } else if (this instanceof FshValueSet) {
            return ItemType.VALUESET;
        } else if (this instanceof FshCodeSystem) {
            return ItemType.CODESYSTEM;
        } else if (this instanceof FshRuleSet) {
            return ItemType.RULESET;
        } else if (this instanceof FshMapping) {
            return ItemType.MAPPING;
        } else if (this instanceof FshLogical) {
            return ItemType.LOGICAL;
        } else if (this instanceof FshResource) {
            return ItemType.RESOURCE;
        }
        LOG.error("Unknown item type in getItemType()");
        return ItemType.ALIAS;
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
            public @Nullable String getPresentableText() {
                return item.getName();
            }

            /**
             * Returns the location of the object (for example, the package of a class). The location string
             * is used by some renderers and usually displayed as grayed text next to the item name.
             *
             * @return the location description, or null if none is applicable.
             */
            @Override
            public @Nullable String getLocationString() {
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
    public ItemNameType getNameType() {
        return this.getItemType().getNameType();
    }

    public MetadataPolicy getMetadataPolicy() {
        return this.getItemType().getMetadataPolicy();
    }

    @Override
    public <T> T @NotNull [] findChildrenByClass(Class<T> aClass) {
        final List<T> result = new ArrayList<>(5);
        for (PsiElement cur = getFirstChild(); cur != null; cur = cur.getNextSibling()) {
            if (aClass.isInstance(cur)) {
                result.add(aClass.cast(cur));
            }
        }
        return result.toArray(ArrayUtil.newArray(aClass, result.size()));
    }
}

// Copyright 2024 Quentin Ligier. Use of this source code is governed by the MIT license.

package ch.qligier.jetbrains.plugin.fhir.fsh.psi.entity;

import ch.qligier.jetbrains.plugin.fhir.fsh.FshLanguage;
import ch.qligier.jetbrains.plugin.fhir.fsh.grammar.FSHLexer;
import ch.qligier.jetbrains.plugin.fhir.fsh.specification.ItemType;
import com.intellij.lang.ASTNode;
import org.antlr.intellij.adaptor.lexer.PSIElementTypeFactory;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * PSI element representing an alias in an FSH file.
 *
 * @author Quentin Ligier
 **/
public class FshPsiAlias extends FshPsiItem {

    private final @Nullable String aliasValue;

    public FshPsiAlias(@NotNull final ASTNode node) {
        super(node);
        this.aliasValue = this.extractAliasValue(node);
    }

    @Override
    public @NotNull ItemType getItemType() {
        return ItemType.ALIAS;
    }

    public @Nullable String getAliasValue() {
        return this.aliasValue;
    }

    @Override
    protected @Nullable String extractItemName(@NotNull final ASTNode node) {
        return node.getText(); //TODO get from name
    }

    protected @Nullable String extractAliasValue(@NotNull final ASTNode node) {
        final var type = PSIElementTypeFactory.getTokenIElementTypes(FshLanguage.INSTANCE).get(FSHLexer.SEQUENCE);
        final var child = node.findChildByType(type);
        return (child != null) ? child.getText() : null;
    }

    @Override
    public @Nullable String toString() {
        return "FshPsiAlias(%s, %s)".formatted(this.itemName, this.aliasValue);
    }
}

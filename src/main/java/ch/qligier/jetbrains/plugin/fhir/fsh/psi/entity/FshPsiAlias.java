// Copyright 2024 Quentin Ligier. Use of this source code is governed by the MIT license.

package ch.qligier.jetbrains.plugin.fhir.fsh.psi.entity;

import ch.qligier.jetbrains.plugin.fhir.fsh.FshLanguage;
import ch.qligier.jetbrains.plugin.fhir.fsh.grammar.FshLexer;
import ch.qligier.jetbrains.plugin.fhir.fsh.specification.ItemType;
import com.intellij.lang.ASTNode;
import org.antlr.intellij.adaptor.lexer.PSIElementTypeFactory;
import org.jspecify.annotations.Nullable;


/**
 * PSI element representing an alias in an FSH file.
 *
 * @author Quentin Ligier
 **/
public class FshPsiAlias extends FshPsiItem {

    public FshPsiAlias(final ASTNode node) {
        super(node);
    }

    @Override
    public ItemType getItemType() {
        return ItemType.ALIAS;
    }

    @Override
    public @Nullable String getItemName() {
        return this.getNode().getText(); //TODO get from name
    }

    public @Nullable String getAliasValue() {
        final var type = PSIElementTypeFactory.getTokenIElementTypes(FshLanguage.INSTANCE).get(FshLexer.SEQUENCE);
        final var child = this.getNode().findChildByType(type);
        return (child != null) ? child.getText() : null;
    }

    @Override
    public @Nullable String toString() {
        return "FshPsiAlias(%s, %s)".formatted(this.getItemName(), this.getAliasValue());
    }
}

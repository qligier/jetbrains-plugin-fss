// Copyright 2024 Quentin Ligier. Use of this source code is governed by the MIT license.

package ch.qligier.jetbrains.plugin.fss.igini;

import ch.qligier.jetbrains.plugin.fss.igini.language.psi.IniProperty;
import ch.qligier.jetbrains.plugin.fss.igini.language.psi.IniSection;
import ch.qligier.jetbrains.plugin.fss.igini.language.psi.IniTypes;
import com.intellij.codeInsight.completion.*;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.psi.PsiElement;
import com.intellij.psi.impl.source.tree.CompositeElement;
import com.intellij.psi.impl.source.tree.LeafPsiElement;
import com.intellij.util.ProcessingContext;
import org.jetbrains.annotations.NotNull;

/**
 * A contributor that provides completion variants for the ig.ini file.
 *
 * @author Quentin Ligier
 * @see <a href="https://plugins.jetbrains.com/docs/intellij/completion-contributor.html">Completion Contributor</a>
 **/
public class IgIniCompletionContributor extends CompletionContributor {

    public IgIniCompletionContributor() {
        // Provide completion for keys
        this.extend(CompletionType.BASIC,
                    PlatformPatterns.psiElement(IniTypes.PKEY),
                    new CompletionProvider<>() {
                        public void addCompletions(@NotNull CompletionParameters parameters,
                                                   @NotNull ProcessingContext context,
                                                   @NotNull CompletionResultSet resultSet) {
                            resultSet.addElement(LookupElementBuilder.create(IgIniSpecs.IG_KEY_NAME));
                            resultSet.addElement(LookupElementBuilder.create(IgIniSpecs.TEMPLATE_KEY_NAME));
                        }
                    }
        );

        // Provide completion for values
        this.extend(CompletionType.BASIC,
                    PlatformPatterns.psiElement(IniTypes.PVALUE),
                    new CompletionProvider<>() {
                        public void addCompletions(@NotNull CompletionParameters parameters,
                                                   @NotNull ProcessingContext context,
                                                   @NotNull CompletionResultSet resultSet) {
                            if (parameters.getPosition() instanceof final LeafPsiElement leaf) {
                                if (leaf.getElementType() != IniTypes.PVALUE) {
                                    return;
                                }

                                // The leaf first parent is the IniKey, the second is the IniProperty (or a
                                // wrapping CompositeElement in some cases)
                                PsiElement parentPsi = leaf.getParent().getParent();
                                if (parentPsi instanceof final CompositeElement composite) {
                                    parentPsi = composite.getPsi();
                                }

                                if (parentPsi instanceof final IniProperty kv) {
                                    // Get the section name, if any
                                    String sectionName = null;
                                    if (kv.getParent() instanceof final IniSection section) {
                                        sectionName = section.getSectionName();
                                    }

                                    final String keyName = kv.getKeyName();

                                    if (IgIniSpecs.IG_SECTION_NAME.equals(sectionName)) {
                                        if (IgIniSpecs.TEMPLATE_KEY_NAME.equals(keyName)) {
                                            // List from https://build.fhir.org/ig/FHIR/ig-guidance/
                                            resultSet.addElement(LookupElementBuilder.create("fhir.base.template"));
                                            resultSet.addElement(LookupElementBuilder.create("hl7.base.template"));
                                            resultSet.addElement(LookupElementBuilder.create("hl7.fhir.template"));
                                            resultSet.addElement(LookupElementBuilder.create("hl7.davinci.template"));
                                            resultSet.addElement(LookupElementBuilder.create("hl7.cda.template"));
                                            resultSet.addElement(LookupElementBuilder.create("hl7.other.template"));
                                        }
                                    }
                                }
                            }
                        }
                    }
        );

        // Provide completion for section names
        this.extend(CompletionType.BASIC,
                    PlatformPatterns.psiElement(IniTypes.SECTION_NAME),
                    new CompletionProvider<>() {
                        public void addCompletions(@NotNull CompletionParameters parameters,
                                                   @NotNull ProcessingContext context,
                                                   @NotNull CompletionResultSet resultSet) {
                            resultSet.addElement(LookupElementBuilder.create(IgIniSpecs.IG_SECTION_NAME));
                        }
                    }
        );
    }
}

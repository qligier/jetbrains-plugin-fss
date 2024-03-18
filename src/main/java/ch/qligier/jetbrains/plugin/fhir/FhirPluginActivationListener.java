// Copyright 2024 Quentin Ligier. Use of this source code is governed by the MIT license.

package ch.qligier.jetbrains.plugin.fhir;

import ch.qligier.jetbrains.plugin.fhir.fsh.FshLanguage;
import ch.qligier.jetbrains.plugin.fhir.fsh.FshUtils;
import ch.qligier.jetbrains.plugin.fhir.fsh.grammar.FshParser;
import com.intellij.openapi.application.ApplicationActivationListener;
import com.intellij.openapi.wm.IdeFrame;
import org.antlr.intellij.adaptor.lexer.PSIElementTypeFactory;
import org.jetbrains.annotations.NotNull;

/**
 * jetbrains-plugin-fhir
 *
 * @author Quentin Ligier
 **/
public class FhirPluginActivationListener implements ApplicationActivationListener {

    /**
     * Called when app is activated by transferring focus to it.
     *
     * @param ideFrame
     */
    @Override
    public void applicationActivated(@NotNull final IdeFrame ideFrame) {
        // Load all IElementTypes for FSH
        PSIElementTypeFactory.defineLanguageIElementTypes(FshLanguage.INSTANCE,
                                                          FshParser.tokenNames,
                                                          FshParser.ruleNames);
    }
}

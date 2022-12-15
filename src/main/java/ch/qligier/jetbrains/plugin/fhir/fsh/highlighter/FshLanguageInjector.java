// Copyright 2022 Quentin Ligier. Use of this source code is governed by the MIT license.

package ch.qligier.jetbrains.plugin.fhir.fsh.highlighter;

import ch.qligier.jetbrains.plugin.fhir.fsh.parser.psi.FshString;
import com.intellij.lang.Language;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.InjectedLanguagePlaces;
import com.intellij.psi.LanguageInjector;
import com.intellij.psi.PsiLanguageInjectionHost;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * An injector of other languages into FSH files.
 *
 * @author Quentin Ligier
 **/
public class FshLanguageInjector implements LanguageInjector {

    @Nullable
    private static final Language MARKDOWN = Language.findLanguageByID("Markdown");

    /**
     * @param host                     PSI element inside which your language will be injected.
     * @param injectionPlacesRegistrar stores places where injection occurs. <br> Call its
     *                                 {@link InjectedLanguagePlaces#addPlace(Language, TextRange, String, String)}
     *                                 method to register particular injection place. For example, to inject your
     *                                 language in string literal inside quotes, you might want to <br>
     *                                 {@code injectionPlacesRegistrar.addPlace(myLanguage, new
     *                                 TextRange(1,host.getTextLength()-1))}
     */
    @Override
    public void getLanguagesToInject(@NotNull final PsiLanguageInjectionHost host,
                                     @NotNull final InjectedLanguagePlaces injectionPlacesRegistrar) {
        if (MARKDOWN == null) {
            return;
        }
        if (host instanceof FshString) {
            injectionPlacesRegistrar.addPlace(MARKDOWN, new TextRange(0, host.getTextLength()), "\"", "\"");
        }
    }
}

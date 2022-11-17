package ch.qligier.jetbrains.plugin.fhir.fsh.highlighter;

import ch.qligier.jetbrains.plugin.fhir.fsh.grammar.FshParser;
import ch.qligier.jetbrains.plugin.fhir.fsh.parser.FshTokenTypes;
import com.intellij.lang.Language;
import com.intellij.lang.injection.general.Injection;
import com.intellij.lang.injection.general.LanguageInjectionContributor;
import com.intellij.lang.injection.general.LanguageInjectionPerformer;
import com.intellij.lang.injection.general.SimpleInjection;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiLanguageInjectionHost;
import org.antlr.intellij.adaptor.psi.ANTLRPsiNode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

/**
 * Language injection is the way the IntelliJ Platform handles different languages within the same source file.
 * <p>
 * It's used to provide highlighting to Markdown in strings.
 *
 * @author Quentin Ligier
 * @see <a
 * href="https://plugins.jetbrains.com/docs/intellij/language-injection.html#languageinjectioncontributor-and-languageinjectionperformer">LanguageInjectionContributor
 * and LanguageInjectionPerformer</a>
 **/
public class FshLanguageInjectionContributor implements LanguageInjectionContributor {

    /**
     * @param context a {@link PsiElement}, which could contain the {@link Injection} of other language. Usually
     *                implementations should handle only {@link PsiLanguageInjectionHost}-s, when more complex cases
     *                (like the concatenation injection) should be handled via the corresponding
     *                {@link LanguageInjectionPerformer}
     * @return {@link Injection} which should present in the {@code context}, or {@code null} if no injection to the
     * given {@code context} could be provided by the current contributor
     */
    @Override
    public @Nullable Injection getInjection(@NotNull final PsiElement context) {
        if (context instanceof ANTLRPsiNode) {
            final var antlrNode = (ANTLRPsiNode) context;
            if (antlrNode.getNode().getElementType() == FshTokenTypes.getRuleElementType(FshParser.RULE_value))
                return new SimpleInjection(Objects.requireNonNull(Language.findLanguageByID("Markdown")),
                                           "",
                                           "",
                                           null);
        }
        return null;
    }
}

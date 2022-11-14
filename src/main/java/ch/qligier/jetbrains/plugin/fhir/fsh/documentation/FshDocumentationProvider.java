//  Copyright 2022 Quentin Ligier and other contributors. Use of this source code is governed by the MIT license

package ch.qligier.jetbrains.plugin.fhir.fsh.documentation;

import com.intellij.lang.documentation.AbstractDocumentationProvider;
import com.intellij.lang.documentation.DocumentationMarkup;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.Nullable;

/**
 * Custom languages can use the <code>com.intellij.lang.documentationProvider</code> extension point (EP) to show
 * documentation for functions, methods, classes, or other constructs right inside the IDE. Accessing the documentation
 * is done by calling <code>View | Quick Documentation</code> or hovering over a symbol, which will open a popup to show
 * type information, parameters, usage descriptions, or examples. The source of the documentation contents can vary.
 *
 * @author Quentin Ligier
 * @see <a href="https://plugins.jetbrains.com/docs/intellij/documentation.html">Documentation</a>
 * @see <a href="https://plugins.jetbrains.com/docs/intellij/documentation-provider.html">DocumentationProvider</a>
 **/
public class FshDocumentationProvider extends AbstractDocumentationProvider {
    private static final Logger LOG = Logger.getInstance(FshDocumentationProvider.class);

    /**
     * <p>Callback for asking the doc provider for the complete documentation.
     * Underlying implementation may be time-consuming, that's why this method is expected not to be called from
     * EDT.</p>
     *
     * <p>One can use {@link DocumentationMarkup} to get proper content layout. Typical sample will look like this:
     * <pre>
     * DEFINITION_START + definition + DEFINITION_END +
     * CONTENT_START + main description + CONTENT_END +
     * SECTIONS_START +
     *   SECTION_HEADER_START + section name +
     *     SECTION_SEPARATOR + "&lt;p&gt;" + section content + SECTION_END +
     *   ... +
     * SECTIONS_END
     * </pre>
     * </p>
     * To show different content on mouse hover in editor, {@link #generateHoverDoc(PsiElement, PsiElement)} should be
     * implemented.
     *
     * @param element         the element for which the documentation is requested (for example, if the mouse is over a
     *                        method reference, this will be the method to which the reference is resolved).
     * @param originalElement the element under the mouse cursor
     * @return target element's documentation, or {@code null} if provider is unable to generate documentation for the
     * given element
     */
    @Override
    public @Nullable @Nls String generateDoc(final PsiElement element, @Nullable final PsiElement originalElement) {
        System.out.printf("element %s%n", element);
        System.out.printf("originalElement %s%n", originalElement);
        return super.generateDoc(element, originalElement);
    }
}

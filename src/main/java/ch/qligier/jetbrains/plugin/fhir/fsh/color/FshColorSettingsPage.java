// Copyright 2024 Quentin Ligier. Use of this source code is governed by the MIT license.

package ch.qligier.jetbrains.plugin.fhir.fsh.color;

import ch.qligier.jetbrains.plugin.fhir.common.Icons;
import com.intellij.openapi.editor.colors.ColorKey;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.options.colors.AttributesDescriptor;
import com.intellij.openapi.options.colors.ColorDescriptor;
import com.intellij.openapi.options.colors.ColorSettingsPage;
import com.intellij.openapi.util.text.StringUtil;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.Map;

/**
 * Definition of a custom page shown in the "Colors and Fonts" settings dialog for the FSH language.
 *
 * @author Quentin Ligier
 * @see <a
 * href="https://plugins.jetbrains.com/docs/intellij/syntax-highlighter-and-color-settings-page.html#define-a-color-settings-page">Define
 * a Color Settings Page</a>
 **/
public class FshColorSettingsPage implements ColorSettingsPage {

    private static final AttributesDescriptor[] DESCRIPTORS = new AttributesDescriptor[]{
            new AttributesDescriptor("Item declaration", FshSyntaxHighlighter.DECLARATION),
            new AttributesDescriptor("Keyword (item metadata)", FshSyntaxHighlighter.KEYWORD),
            new AttributesDescriptor("String", FshSyntaxHighlighter.STRING),
            new AttributesDescriptor("Value", FshSyntaxHighlighter.VALUE),
            new AttributesDescriptor("Line comment", FshSyntaxHighlighter.LINE_COMMENT),
            new AttributesDescriptor("Block comment", FshSyntaxHighlighter.BLOCK_COMMENT)
    };

    /**
     * Returns the icon for the page, shown in the dialog tab.
     *
     * @return the icon for the page, or null if the page does not have a custom icon.
     */
    @Override
    public @Nullable Icon getIcon() {
        return Icons.FSH_FLAME;
    }

    /**
     * Returns the syntax highlighter which is used to highlight the text shown in the preview pane of the page.
     *
     * @return the syntax highlighter instance.
     */
    @Override
    public @NotNull SyntaxHighlighter getHighlighter() {
        return new FshSyntaxHighlighter();
    }

    /**
     * Returns the text shown in the preview pane. If some elements need to be highlighted in the preview text which are
     * not highlighted by the syntax highlighter, they need to be surrounded by XML-like tags, for example:
     * {@code <class>MyClass</class>}. The mapping between the names of the tags and the text attribute keys used for
     * highlighting is defined by the {@link #getAdditionalHighlightingTagToDescriptorMap()} method.
     * <p>The returned text <strong>must use {@code \n} as a line separator</strong>, so if you read it from a file
     * make sure to adjust it via {@link StringUtil#convertLineSeparators(String)}.
     * </p>
     *
     * @return the text to show in the preview pane or empty text to hide it.
     */
    @Override
    public @NonNls @NotNull String getDemoText() {
        return """
                // Comment.
                Profile: MyPatient
                Parent: Patient
                Description: "An example profile of the Patient resource."

                Instance: TumorSizeExample
                InstanceOf: TumorSize
                Description: "An example of a patient with a license to krill."
                * component[+].code = http://loinc.org#33728-7
                * status = #final
                * code = http://loinc.org#33728-7
                * name
                    * given[0] = "James"
                    * family = "Pond"
                """;
    }

    /**
     * Returns the mapping from special tag names surrounding the regions to be highlighted in the preview text (see
     * {@link #getDemoText()}) to text attribute keys used to highlight the regions.
     *
     * @return the mapping from tag names to text attribute keys, or null if the demo text does not contain any
     * additional highlighting tags.
     */
    @Override
    public @Nullable Map<String, TextAttributesKey> getAdditionalHighlightingTagToDescriptorMap() {
        return null;
    }

    /**
     * Returns the list of descriptors specifying the {@link TextAttributesKey} instances for which colors are specified
     * in the page. For such attribute keys, the user can choose all highlighting attributes (font type, background
     * color, foreground color, error stripe color and effects).
     *
     * @return the array of attribute descriptors.
     */
    @Override
    public AttributesDescriptor @NotNull [] getAttributeDescriptors() {
        return DESCRIPTORS;
    }

    /**
     * Returns the list of descriptors specifying the {@link ColorKey} instances for which colors are specified in the
     * page. For such color keys, the user can choose only the background or foreground color.
     *
     * @return the array of color descriptors.
     */
    @Override
    public ColorDescriptor @NotNull [] getColorDescriptors() {
        return ColorDescriptor.EMPTY_ARRAY;
    }

    /**
     * Returns the title of the page, shown as text in the dialog tab.
     *
     * @return the title of the custom page.
     */
    @Override
    public @NotNull String getDisplayName() {
        return "FSH";
    }
}

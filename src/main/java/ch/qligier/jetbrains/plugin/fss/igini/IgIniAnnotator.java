// Copyright 2024 Quentin Ligier. Use of this source code is governed by the MIT license.

package ch.qligier.jetbrains.plugin.fss.igini;

import ch.qligier.jetbrains.plugin.fss.igini.language.psi.IniFile;
import ch.qligier.jetbrains.plugin.fss.igini.language.psi.IniProperty;
import ch.qligier.jetbrains.plugin.fss.igini.language.psi.IniSection;
import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.lang.annotation.Annotator;
import com.intellij.lang.annotation.HighlightSeverity;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;

/**
 * An annotator for the ig.ini file.
 *
 * @author Quentin Ligier
 * @see <a href="https://plugins.jetbrains.com/docs/intellij/annotator.html">Annotator</a>
 **/
public class IgIniAnnotator implements Annotator {

    /**
     * Annotates the specified PSI element. It is guaranteed to be executed in non-reentrant fashion. I.e there will be
     * no call of this method for this instance before previous call get completed. Multiple instances of the annotator
     * might exist simultaneously, though.
     *
     * @param element to annotate.
     * @param holder  the container which receives annotations created by the plugin.
     */
    @Override
    public void annotate(@NotNull final PsiElement element, @NotNull final AnnotationHolder holder) {
        if (!(element instanceof final IniFile file)) {
            return;
        }

        // Properties outside a section aren't supported by the IG Publisher
        for (final IniProperty property : file.getProperties()) {
            this.createWarningForUnsupportedProperty(holder, property);
        }

        boolean section_ig_found = false;
        for (final IniSection section : file.getSections()) {
            if (!IgIniSpecs.IG_SECTION_NAME.equals(section.getSectionName())) {
                final var target = section.getFirstChild();
                holder.newAnnotation(HighlightSeverity.WEAK_WARNING,
                                     String.format("The section '%s' is not supported by the IG Publisher",
                                                   section.getSectionName()))
                        .range(target != null ? target : section)
                        .create();
                continue;
            }

            section_ig_found = true;

            boolean property_template_found = false;
            boolean property_ig_found = false;
            for (final IniProperty property : section.getProperties()) {
                final var keyName = property.getKeyName();
                if (keyName == null) {
                    continue;
                }
                switch (keyName) {
                    case IgIniSpecs.TEMPLATE_KEY_NAME:
                        property_template_found = true;
                        break;
                    case IgIniSpecs.IG_KEY_NAME:
                        property_ig_found = true;
                        break;
                    default:
                        this.createWarningForUnsupportedProperty(holder, property);
                        break;
                }
            }

            if (!property_ig_found) {
                holder.newAnnotation(HighlightSeverity.ERROR,
                                     String.format("The property '%s' is not defined in the file",
                                                   IgIniSpecs.IG_KEY_NAME))
                        .range(section.getFirstChild())
                        .create();
            }
            if (!property_template_found) {
                holder.newAnnotation(HighlightSeverity.ERROR,
                                     String.format("The property '%s' is not defined in the file",
                                                   IgIniSpecs.TEMPLATE_KEY_NAME))
                        .range(section.getFirstChild())
                        .create();
            }
        }

        if (!section_ig_found) {
            holder.newAnnotation(HighlightSeverity.ERROR,
                                 String.format("The section '%s' is not defined in the file",
                                               IgIniSpecs.IG_SECTION_NAME))
                    .range(file)
                    .create();
        }
    }

    private void createWarningForUnsupportedProperty(final @NotNull AnnotationHolder holder,
                                                     final @NotNull IniProperty property) {
        final PsiElement keyElement = property.getKeyElement();
        holder.newAnnotation(HighlightSeverity.WEAK_WARNING,
                             String.format("The property '%s' is not supported by the IG Publisher",
                                           property.getKeyName()))
                .range(keyElement != null ? keyElement : property)
                .create();
    }
}

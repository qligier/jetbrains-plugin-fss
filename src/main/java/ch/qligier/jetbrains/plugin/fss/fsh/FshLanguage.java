// Copyright 2024 Quentin Ligier. Use of this source code is governed by the MIT license.

package ch.qligier.jetbrains.plugin.fss.fsh;

import com.intellij.lang.Language;

/**
 * Definition of the FSH language.
 *
 * @author Quentin Ligier
 * @see <a href="https://plugins.jetbrains.com/docs/intellij/language-and-filetype.html">Language and File Type</a>
 **/
public class FshLanguage extends Language {
    public static final FshLanguage INSTANCE = new FshLanguage();

    private FshLanguage() {
        super("FSH");
    }
}

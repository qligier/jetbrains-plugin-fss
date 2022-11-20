/*
 * Copyright 2022 Quentin Ligier. Use of this source code is governed by the MIT license
 */

package ch.qligier.jetbrains.plugin.fhir.fsh;

import com.intellij.lang.Language;

/**
 * jetbrains-language-fsh
 *
 * @author Quentin Ligier
 **/
public class FshLanguage extends Language {
    public static final FshLanguage INSTANCE = new FshLanguage();

    private FshLanguage() {
        super("FSH");
    }
}

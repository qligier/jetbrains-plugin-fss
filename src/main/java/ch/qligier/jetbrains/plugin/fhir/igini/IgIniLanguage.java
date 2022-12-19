// Copyright 2022 Quentin Ligier. Use of this source code is governed by the MIT license.

package ch.qligier.jetbrains.plugin.fhir.igini;

import com.intellij.lang.Language;

/**
 * jetbrains-plugin-fhir
 *
 * @author Quentin Ligier
 **/
public class IgIniLanguage extends Language {

    public static final IgIniLanguage INSTANCE = new IgIniLanguage();

    private IgIniLanguage() {
        super("IG_INI");
    }
}

// Copyright 2024 Quentin Ligier. Use of this source code is governed by the MIT license.

package ch.qligier.jetbrains.plugin.fss.igini;

import com.intellij.lang.Language;

/**
 * jetbrains-plugin-fss
 *
 * @author Quentin Ligier
 **/
public class IgIniLanguage extends Language {

    public static final IgIniLanguage INSTANCE = new IgIniLanguage();

    private IgIniLanguage() {
        super("IG_INI");
    }
}

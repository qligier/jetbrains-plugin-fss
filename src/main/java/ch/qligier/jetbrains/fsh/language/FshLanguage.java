//  Copyright 2022 Quentin Ligier and other contributors. Use of this source code is governed by the MIT license

package ch.qligier.jetbrains.fsh.language;

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

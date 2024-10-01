// Copyright 2024 Quentin Ligier. Use of this source code is governed by the MIT license.

package ch.qligier.jetbrains.plugin.fss.igini.language.lexer;

import ch.qligier.jetbrains.plugin.fss.igini.language.IniLexer;
import com.intellij.lexer.FlexAdapter;

/**
 * jetbrains-plugin-fss
 *
 * @author Quentin Ligier
 **/
public class IniLexerAdapter extends FlexAdapter {

    public IniLexerAdapter() {
        super(new IniLexer(null));
    }
}

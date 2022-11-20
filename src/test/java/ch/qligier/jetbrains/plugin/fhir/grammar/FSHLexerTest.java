// Copyright 2022 Quentin Ligier. Use of this source code is governed by the MIT license.

package ch.qligier.jetbrains.plugin.fhir.grammar;

import ch.qligier.jetbrains.plugin.fhir.fsh.lexer.FshLexerAdapter;
import com.intellij.lexer.Lexer;
import com.intellij.testFramework.LexerTestCase;
import org.junit.jupiter.api.Test;

/**
 * jetbrains-language-fsh
 *
 * @author Quentin Ligier
 **/
public class FSHLexerTest extends LexerTestCase {

    @Test
    void testLexer() {
        final String content = "ValueSet: EventTimingCara\n" +
                "123\n" +
                "* http://hl7.org/fhir/event-timing#MORN \"Morning\"\n";

        System.out.printf(this.printTokens(content, 0));

    }

    /**
     * @return
     */
    @Override
    protected Lexer createLexer() {
        return new FshLexerAdapter();
    }

    /**
     * @return
     */
    @Override
    protected String getDirPath() {
        return "";
    }
}

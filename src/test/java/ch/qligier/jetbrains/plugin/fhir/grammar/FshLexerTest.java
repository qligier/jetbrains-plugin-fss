// Copyright 2022 Quentin Ligier. Use of this source code is governed by the MIT license.

package ch.qligier.jetbrains.plugin.fhir.grammar;

import ch.qligier.jetbrains.plugin.fhir.fsh.lexer.FshLexerAdapter;
import com.intellij.lexer.Lexer;
import com.intellij.testFramework.LexerTestCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.stream.Stream;

/**
 * Test bench for the FSH lexer (and the grammar).
 *
 * @author Quentin Ligier
 **/
public class FshLexerTest extends LexerTestCase {

    @Test
    void testLexer() {
        final String content = "ValueSet: EventTimingCara\n" +
                "123\n" +
                "* http://hl7.org/fhir/event-timing#MORN \"Morning\"\n";

        System.out.printf(this.printTokens(content, 0));

    }

    @ParameterizedTest
    @MethodSource("provideStressFilePaths")
    void testLexFile(final String resourcePath) throws IOException {
        final var contentStream = FshLexerTest.class.getResourceAsStream(resourcePath);
        assertNotNull(contentStream);
        final var content = new String(contentStream.readAllBytes(), StandardCharsets.UTF_8);
        final String printedTokens = this.printTokens(content, 0);
        assertFalse(printedTokens.contains("BAD_CHARACTER"));
    }

    /**
     * Provider of resource file paths.
     */
    static Stream<String> provideStressFilePaths() {
        return Stream.of(
                "/lexer/stress.fsh"
        );
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

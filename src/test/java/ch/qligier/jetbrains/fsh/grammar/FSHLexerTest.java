package ch.qligier.jetbrains.fsh.grammar;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.Token;
import org.junit.jupiter.api.Test;

import java.io.IOException;

/**
 * jetbrains-language-fsh
 *
 * @author Quentin Ligier
 **/
public class FSHLexerTest {

    @Test
    void testParser() throws IOException {

        final var lexer = new FSHLexer(CharStreams.fromStream(FSHLexerTest.class.getResourceAsStream("/test1.fsh")));

        Token token;
        do {
            token = lexer.nextToken();

            System.out.printf("[%s] / %s%n", token.getText(),
                              lexer.getVocabulary().getDisplayName(token.getType()));

        } while (token.getType() != FSHLexer.EOF);
    }
}

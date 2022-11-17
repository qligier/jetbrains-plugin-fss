package ch.qligier.jetbrains.plugin.fhir.grammar;

import ch.qligier.jetbrains.plugin.fhir.fsh.grammar.FshLexer;
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

        final var lexer = new FshLexer(CharStreams.fromStream(FSHLexerTest.class.getResourceAsStream("/test1.fsh")));

        Token token;
        do {
            token = lexer.nextToken();

            System.out.printf("%s [%s]%n",
                              lexer.getVocabulary().getDisplayName(token.getType()),
                              token.getText().replace("\n", "\\n"));

        } while (token.getType() != FshLexer.EOF);
    }
}

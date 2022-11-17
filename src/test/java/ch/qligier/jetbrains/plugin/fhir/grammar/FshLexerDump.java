package ch.qligier.jetbrains.plugin.fhir.grammar;

import ch.qligier.jetbrains.plugin.fhir.fsh.grammar.FshLexer;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.Token;

/**
 * jetbrains-language-fsh
 *
 * @author Quentin Ligier
 **/
public class FshLexerDump {
    public static void main(String[] args) {
        final String content = "ValueSet: EventTimingCara\n" +
                "* http://hl7.org/fhir/event-timing#MORN \"Morning\"\n";

        final var lexer = new FshLexer(CharStreams.fromString(content));

        Token token;
        do {
            token = lexer.nextToken();

            System.out.printf("%s [%s]%n",
                              lexer.getVocabulary().getDisplayName(token.getType()),
                              token.getText().replace("\n", "\\n"));

        } while (token.getType() != FshLexer.EOF);
    }
}

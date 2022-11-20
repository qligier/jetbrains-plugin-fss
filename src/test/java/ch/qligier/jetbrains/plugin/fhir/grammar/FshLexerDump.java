// Copyright 2022 Quentin Ligier. Use of this source code is governed by the MIT license.

package ch.qligier.jetbrains.plugin.fhir.grammar;

import ch.qligier.jetbrains.plugin.fhir.fsh.lexer.FshLexerAdapter;

/**
 * jetbrains-language-fsh
 *
 * @author Quentin Ligier
 **/
public class FshLexerDump {
    public static void main(String[] args) {
        final String content = "ValueSet: EventTimingCara\n" +
                "* http://hl7.org/fhir/event-timing#MORN \"Morning\"\n";

        final var lexer = new FshLexerAdapter();
/*
        Token token;
        do {
            token = lexer.nextToken();

            System.out.printf("%s [%s]%n",
                              lexer.getVocabulary().getDisplayName(token.getType()),
                              token.getText().replace("\n", "\\n"));

        } while (token.getType() != FshLexer.EOF);*/
    }
}

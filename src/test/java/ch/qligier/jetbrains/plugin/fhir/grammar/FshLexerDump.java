// Copyright 2022 Quentin Ligier. Use of this source code is governed by the MIT license.

package ch.qligier.jetbrains.plugin.fhir.grammar;

import ch.qligier.jetbrains.plugin.fhir.fsh.lexer.FshLexerAdapter;
import com.intellij.lang.TokenWrapper;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.util.text.StringUtil;
import com.intellij.psi.tree.IElementType;

/**
 * jetbrains-language-fsh
 *
 * @author Quentin Ligier
 **/
public class FshLexerDump {

    public static void main(String[] args) {
        final String content = "RuleSet: medication-ruleset\n" +
                "\n" +
                "// language=Markdown\n" +
                "* code ^short = \"Codes that<b> identify</b> *this* _medication_. If the GTIN is known, please specify it.\"";
        final var lexer = new FshLexerAdapter();

        final var out = printTokens(content, 0, lexer);
        System.out.printf(out);
    }

    private static String getTokenText(IElementType tokenType, CharSequence sequence, int start, int end) {
        return tokenType instanceof TokenWrapper
                ? ((TokenWrapper) tokenType).getValue()
                : StringUtil.replace(sequence.subSequence(start, end).toString(), "\n", "\\n");
    }

    public static String printSingleToken(CharSequence fileText, IElementType tokenType, int start, int end) {
        return tokenType + " ('" + getTokenText(tokenType, fileText, start, end) + "')\n";
    }

    public static String printTokens(CharSequence text, int start, Lexer lexer) {
        lexer.start(text, start, text.length());
        StringBuilder result = new StringBuilder();
        IElementType tokenType;
        while ((tokenType = lexer.getTokenType()) != null) {
            result.append(printSingleToken(text, tokenType, lexer.getTokenStart(), lexer.getTokenEnd()));
            lexer.advance();
        }
        return result.toString();
    }
}

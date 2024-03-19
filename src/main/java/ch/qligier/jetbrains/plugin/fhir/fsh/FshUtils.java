// Copyright 2024 Quentin Ligier. Use of this source code is governed by the MIT license.

package ch.qligier.jetbrains.plugin.fhir.fsh;

import ch.qligier.jetbrains.plugin.fhir.fsh.grammar.FshLexer;
import ch.qligier.jetbrains.plugin.fhir.fsh.grammar.FshParser;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.IFileElementType;
import org.antlr.intellij.adaptor.lexer.ANTLRLexerAdaptor;
import org.antlr.intellij.adaptor.parser.ANTLRParserAdaptor;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.tree.ParseTree;

/**
 * jetbrains-plugin-fhir
 *
 * @author Quentin Ligier
 **/
public class FshUtils {

    /**
     * This class is not instantiable.
     */
    private FshUtils() {
    }

    public static ANTLRLexerAdaptor createLexer() {
        final var antlrLexer = new FshLexer(null);
        return new ANTLRLexerAdaptor(FshLanguage.INSTANCE, antlrLexer);
    }

    public static ANTLRParserAdaptor createParser() {
        final var antlrParser = new FshParser(null);
        return new ANTLRParserAdaptor(FshLanguage.INSTANCE, antlrParser) {
            @Override
            protected ParseTree parse(Parser parser, IElementType root) {
                // start rule depends on root passed in; sometimes we want to create an ID node etc...
                if (root instanceof IFileElementType) {
                    return ((FshParser) parser).doc();
                }
                // let's hope it's an ID as needed by "rename function"
                return ((FshParser) parser).profile();
            }
        };
    }
}

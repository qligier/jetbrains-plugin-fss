// Copyright 2022 Quentin Ligier. Use of this source code is governed by the MIT license.

package ch.qligier.jetbrains.plugin.fhir.grammar;

import ch.qligier.jetbrains.plugin.fhir.fsh.parser.FshParserDefinition;
import com.intellij.testFramework.ParsingTestCase;
import org.junit.jupiter.api.Test;

/**
 * jetbrains-language-fsh
 *
 * @author Quentin Ligier
 **/
public class FSHParserTest extends ParsingTestCase {

    protected FSHParserTest() throws Exception {
        super("", "fsh", new FshParserDefinition());
        this.setUp();
    }

    @Test
    public void test1() {
        this.setName("Test1");
        doTest(true);
    }

    @Test
    public void test2() {
        this.setName("Test2");
        doTest(true);
    }

    /**
     * @return path to test data file directory relative to root of this module.
     */
    @Override
    protected String getTestDataPath() {
        return "src/test/resources/parser";
    }

    @Override
    protected boolean skipSpaces() {
        return false;
    }

    @Override
    protected boolean includeRanges() {
        return true;
    }
}

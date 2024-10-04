// Copyright 2024 Quentin Ligier. Use of this source code is governed by the MIT license.

package ch.qligier.jetbrains.plugin.fss.igini.language.parser;

import com.intellij.testFramework.ParsingTestCase;

/**
 * jetbrains-plugin-fss
 *
 * @author Quentin Ligier
 **/
public class IniParserDefinitionTest extends ParsingTestCase {

    public IniParserDefinitionTest() {
        super("", "ini", new IniParserDefinition());
    }

    /*
     * To run tests, ParsingTestCase will use the method name to find the test data file.
     * For example, if the method name is "testExample1", it will look for a file named "Example1.ini" containing the
     * code to parse, and "Example1.txt" containing the expected PSI tree after parsing.
     */

    public void testExample1() {
        this.doTest(true);
    }

    public void testExample2() {
        this.doTest(true);
    }

    /**
     * @return path to test data file directory relative to root of this module.
     */
    @Override
    protected String getTestDataPath() {
        return "src/test/testData/igini/parser/";
    }

    @Override
    protected boolean includeRanges() {
        return true;
    }
}

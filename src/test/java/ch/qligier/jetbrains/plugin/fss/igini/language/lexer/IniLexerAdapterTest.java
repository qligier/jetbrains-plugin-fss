// Copyright 2024 Quentin Ligier. Use of this source code is governed by the MIT license.

package ch.qligier.jetbrains.plugin.fss.igini.language.lexer;

import com.intellij.testFramework.EditorTestUtil;
import com.intellij.testFramework.fixtures.BasePlatformTestCase;

/**
 * jetbrains-plugin-fss
 *
 * @author Quentin Ligier
 **/
public class IniLexerAdapterTest extends BasePlatformTestCase {

    public void testExample1() {
        final var testFile = this.myFixture.configureByFile("Example1.ini");
        EditorTestUtil.testFileSyntaxHighlighting(testFile, this.getTestDataPath() + "Example1.txt", true);
    }

    public void testExample2() {
        final var testFile = this.myFixture.configureByFile("Example2.ini");
        EditorTestUtil.testFileSyntaxHighlighting(testFile, this.getTestDataPath() + "Example2.txt", true);
    }

    /**
     * Return absolute path to the test data. Not intended to be overridden in tests written as part of the IntelliJ
     * IDEA codebase; must be overridden in plugins which use the test framework.
     *
     * @see #getBasePath()
     */
    @Override
    protected String getTestDataPath() {
        return "src/test/testData/igini/lexer/";
    }
}

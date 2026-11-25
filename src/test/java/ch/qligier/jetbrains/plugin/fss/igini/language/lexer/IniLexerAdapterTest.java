// Copyright 2024 Quentin Ligier. Use of this source code is governed by the MIT license.

package ch.qligier.jetbrains.plugin.fss.igini.language.lexer;

import com.intellij.testFramework.EditorTestUtil;
import com.intellij.testFramework.fixtures.BasePlatformTestCase;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * jetbrains-plugin-fss
 *
 * @author Quentin Ligier
 **/
public class IniLexerAdapterTest extends BasePlatformTestCase {

    public void testExample1() throws IOException {
        this.checkHighlighting("Example1");
    }

    public void testExample2() throws IOException {
        this.checkHighlighting("Example2");
    }

    /*
     * The example files are not named "ig.ini", so they would not get the ig.ini file type (and its highlighter). Thus, their
     * content is loaded in a file named "ig.ini".
     */
    private void checkHighlighting(final String name) throws IOException {
        final var text = Files.readString(Path.of(this.getTestDataPath(), name + ".ini"));
        final var testFile = this.myFixture.configureByText("ig.ini", text);
        EditorTestUtil.testFileSyntaxHighlighting(testFile, this.getTestDataPath() + name + ".txt", true);
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

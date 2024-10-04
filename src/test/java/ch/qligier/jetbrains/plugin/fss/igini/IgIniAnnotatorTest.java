// Copyright 2024 Quentin Ligier. Use of this source code is governed by the MIT license.

package ch.qligier.jetbrains.plugin.fss.igini;

import com.intellij.testFramework.fixtures.BasePlatformTestCase;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/**
 * jetbrains-plugin-fss
 *
 * @author Quentin Ligier
 **/
public class IgIniAnnotatorTest extends BasePlatformTestCase {

    /*
     * Since the example files are not named "ig.ini", the fixture editor is not configured with the correct file type.
     * Thus, we load the file manually with the correct file type.
     */

    public void testExample1() throws IOException {
        this.configureIgIni("Example1.ini");
        this.myFixture.checkHighlighting(true, true, true, false);
    }

    /**
     * Return absolute path to the test data. Not intended to be overridden in tests written as part of the IntelliJ
     * IDEA codebase; must be overridden in plugins which use the test framework.
     *
     * @see #getBasePath()
     */
    @Override
    protected String getTestDataPath() {
        return "src/test/testData/igini/annotation/";
    }

    protected void configureIgIni(final String fileName) throws IOException {
        final var file = new File(this.getTestDataPath(), fileName);
        this.myFixture.configureByText("ig.ini",
                                       Files.readString(file.toPath()));
    }
}

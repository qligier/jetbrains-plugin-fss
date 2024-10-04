// Copyright 2024 Quentin Ligier. Use of this source code is governed by the MIT license.

package ch.qligier.jetbrains.plugin.fss.igini.language.psi.impl;

import ch.qligier.jetbrains.plugin.fss.igini.language.parser.IniParserDefinition;
import ch.qligier.jetbrains.plugin.fss.igini.language.psi.IniFile;
import com.intellij.psi.PsiFile;
import com.intellij.testFramework.ParsingTestCase;
import com.intellij.testFramework.TestDataFile;
import org.jetbrains.annotations.NonNls;

import java.io.IOException;

/**
 * jetbrains-plugin-fss
 *
 * @author Quentin Ligier
 **/
public class IniPsiImplUtilTest extends ParsingTestCase {

    public IniPsiImplUtilTest() {
        super("", "ini", new IniParserDefinition());
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

    @Override
    protected void checkResult(@NonNls @TestDataFile String targetDataName,
                               final PsiFile psiFile) throws IOException {

        assertTrue(psiFile instanceof IniFile);
        final var iniFile = (IniFile) psiFile;

        assertEquals(iniFile.getProperties().size(), 1);
        assertEquals(iniFile.getProperties().get(0).getKeyName(), "outside-of-section");
        assertNotNull(iniFile.getProperties().get(0).getKeyElement());
        assertEquals(iniFile.getProperties().get(0).getKeyElement().getText(), "outside-of-section");
        assertNotNull(iniFile.getProperties().get(0).getValue());
        assertEquals(iniFile.getProperties().get(0).getValue().getText(), "yes");

        assertEquals(iniFile.getSections().size(), 3);
        assertEquals(iniFile.getSections().get(0).getSectionName(), "[IG]");
        assertEquals(iniFile.getSections().get(1).getSectionName(), "[SomethingElse]");
        assertEquals(iniFile.getSections().get(2).getSectionName(), "[empty]");

        assertEquals(iniFile.getSections().get(0).getProperties().size(), 3);
        assertEquals(iniFile.getSections().get(0).getProperties().get(0).getKeyName(), "ig");
        assertEquals(iniFile.getSections().get(0).getProperties().get(0).getValue().getText(),
                     "fsh-generated/ImplementationGuide.json");
        assertEquals(iniFile.getSections().get(0).getProperties().get(1).getKeyName(), "template");
        assertEquals(iniFile.getSections().get(0).getProperties().get(1).getValue().getText(), "fhir");
        assertEquals(iniFile.getSections().get(0).getProperties().get(2).getKeyName(), "other");
        assertEquals(iniFile.getSections().get(0).getProperties().get(2).getValue().getText(), "value");

        assertEquals(iniFile.getSections().get(1).getProperties().size(), 1);
        assertEquals(iniFile.getSections().get(1).getProperties().get(0).getKeyName(), "something");
        assertEquals(iniFile.getSections().get(1).getProperties().get(0).getValue().getText(), "else");

        assertEquals(iniFile.getSections().get(2).getProperties().size(), 0);
    }
}

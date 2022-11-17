package ch.qligier.jetbrains.plugin.fhir.fsh.inspection;

import com.intellij.codeInspection.InspectionEP;
import com.intellij.codeInspection.LocalInspectionTool;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;

/**
 * jetbrains-language-fsh
 *
 * @author Quentin Ligier
 **/
public abstract class FshInspectionBase extends LocalInspectionTool {

    /**
     * @see InspectionEP#groupDisplayName
     * @see InspectionEP#groupKey
     * @see InspectionEP#groupBundle
     */
    @Override
    public @Nls(capitalization = Nls.Capitalization.Sentence) @NotNull String getGroupDisplayName() {
        return "FSH";
    }
}

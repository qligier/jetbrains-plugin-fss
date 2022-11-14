package ch.qligier.jetbrains.fsh.parser;

import ch.qligier.jetbrains.fsh.language.FshLanguage;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

/**
 * jetbrains-language-fsh
 *
 * @author Quentin Ligier
 **/
public class FshTokenType extends IElementType {

    /**
     * Creates and registers a new element type for the specified language.
     *
     * @param debugName the name of the element type, used for debugging purposes.
     */
    public FshTokenType(@NonNls @NotNull final String debugName) {
        super(debugName, FshLanguage.INSTANCE);
    }
}

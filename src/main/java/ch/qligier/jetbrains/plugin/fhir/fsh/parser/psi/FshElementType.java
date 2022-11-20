/*
 * Copyright 2022 Quentin Ligier. Use of this source code is governed by the MIT license
 */

package ch.qligier.jetbrains.plugin.fhir.fsh.parser.psi;

import ch.qligier.jetbrains.plugin.fhir.fsh.FshLanguage;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

/**
 * jetbrains-plugin-fhir
 *
 * @author Quentin Ligier
 **/
public class FshElementType extends IElementType {
    /**
     * Creates and registers a new element type for the specified language.
     *
     * @param debugName the name of the element type, used for debugging purposes.
     */
    public FshElementType(@NonNls @NotNull final String debugName) {
        super(debugName, FshLanguage.INSTANCE);
    }
}

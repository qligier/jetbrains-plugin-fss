/*
 * Copyright 2026 Quentin Ligier. Use of this source code is governed by the MIT license.
 */

package ch.qligier.jetbrains.plugin.fss.sushiconfig

import ch.qligier.jetbrains.plugin.fss.sushiconfig.SushiConfigSpecs.FILENAME
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiFileFactory
import org.jetbrains.yaml.YAMLFileType
import org.jetbrains.yaml.psi.YAMLFile
import org.jetbrains.yaml.psi.YAMLKeyValue

/**
 * A factory of elements related to the [SushiConfigLanguage].
 *
 * @author Quentin Ligier
 **/
fun createFile(
    project: Project,
    content: String,
): YAMLFile =
    PsiFileFactory
        .getInstance(project)
        .createFileFromText(FILENAME, YAMLFileType.YML, content) as YAMLFile

fun createKeyValue(
    project: Project,
    key: String,
    value: String,
): YAMLKeyValue = createFile(project, "$key: $value").firstChild.firstChild.firstChild as YAMLKeyValue

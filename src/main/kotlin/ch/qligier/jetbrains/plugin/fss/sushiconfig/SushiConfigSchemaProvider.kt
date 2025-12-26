/*
 * Copyright 2025 Quentin Ligier. Use of this source code is governed by the MIT license.
 */

package ch.qligier.jetbrains.plugin.fss.sushiconfig

import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile
import com.jetbrains.jsonSchema.extension.JsonSchemaFileProvider
import com.jetbrains.jsonSchema.extension.JsonSchemaProviderFactory
import com.jetbrains.jsonSchema.extension.SchemaType
import org.jetbrains.annotations.Nls

/**
 * Provides a JSON schema for the 'sushi-config.yaml' configuration file.
 * Although it is a YAML file, JetBrains IDEs can use JSON schemas.
 */
class SushiConfigSchemaProvider : JsonSchemaFileProvider {
    override fun isAvailable(file: VirtualFile): Boolean = file.name == SushiConfigSpecs.FILENAME

    override fun getName(): @Nls String = SushiConfigSpecs.FILENAME

    override fun getSchemaType(): SchemaType = SchemaType.embeddedSchema

    override fun getSchemaFile(): VirtualFile? = JsonSchemaProviderFactory.getResourceFile(javaClass, "/sushiconfig/schema.json")
}

class SushiConfigSchemaProviderFactory : JsonSchemaProviderFactory {
    override fun getProviders(project: Project): List<JsonSchemaFileProvider> = listOf(SushiConfigSchemaProvider())
}

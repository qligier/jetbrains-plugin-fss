/*
 * Copyright 2025 Quentin Ligier. Use of this source code is governed by the MIT license.
 */

import org.jetbrains.changelog.Changelog
import org.jetbrains.changelog.markdownToHTML
import org.jetbrains.intellij.platform.gradle.TestFrameworkType

plugins {
    id("java") // Java support
    id("org.jetbrains.kotlin.jvm") version "2.2.21" // Kotlin support
    id("org.jetbrains.intellij.platform") version "2.10.5" // IntelliJ Platform Gradle Plugin
    id("org.jetbrains.changelog") version "2.5.0" // Gradle Changelog Plugin
    id("org.jetbrains.qodana") version "2025.2.2" // Gradle Qodana Plugin
    id("org.jetbrains.kotlinx.kover") version "0.9.3" // Gradle Kover Plugin
}

group = "ch.qligier.jetbrains.plugin.fss"
version = providers.gradleProperty("pluginVersion").get()

// Set the JVM language level used to build the project.
kotlin {
    jvmToolchain(21)
}

// Configure project's dependencies
repositories {
    mavenCentral()

    // IntelliJ Platform Gradle Plugin Repositories Extension - read more: https://plugins.jetbrains.com/docs/intellij/tools-intellij-platform-gradle-plugin-repositories-extension.html
    intellijPlatform {
        defaultRepositories()
    }
}

// Dependencies are managed with Gradle version catalog - read more: https://docs.gradle.org/current/userguide/platforms.html#sub:version-catalog
dependencies {
    implementation("org.jetbrains:annotations:26.0.2-1")

    testImplementation("junit:junit:4.13.2")

    // IntelliJ Platform Gradle Plugin Dependencies Extension - read more: https://plugins.jetbrains.com/docs/intellij/tools-intellij-platform-gradle-plugin-dependencies-extension.html
    intellijPlatform {
        intellijIdea("2025.3")

        // Plugin Dependencies. Uses `platformBundledPlugins` property from the gradle.properties file for bundled IntelliJ Platform plugins.
        bundledPlugin("org.jetbrains.plugins.yaml")
        bundledPlugin("org.jetbrains.plugins.textmate")

        // Plugin Dependencies. Uses `platformPlugins` property from the gradle.properties file for plugin from JetBrains Marketplace.

        pluginVerifier()
        zipSigner()
        testFramework(TestFrameworkType.Platform)
    }
}

// Configure IntelliJ Platform Gradle Plugin - read more: https://plugins.jetbrains.com/docs/intellij/tools-intellij-platform-gradle-plugin-extension.html
intellijPlatform {
    pluginConfiguration {
        name = "FHIR and SUSHI Support"
        id = "jetbrains-plugin-fss"
        version = providers.gradleProperty("pluginVersion")

        // Extract the <!-- Plugin description --> section from README.md and provide for the plugin's manifest
        description = providers.fileContents(layout.projectDirectory.file("README.md")).asText.map {
            val start = "<!-- Plugin description -->"
            val end = "<!-- Plugin description end -->"

            with(it.lines()) {
                if (!containsAll(listOf(start, end))) {
                    throw GradleException("Plugin description section not found in README.md:\n$start ... $end")
                }
                subList(indexOf(start) + 1, indexOf(end)).joinToString("\n").let(::markdownToHTML)
            }
        }

        val changelog = project.changelog // local variable for configuration cache compatibility
        // Get the latest available change notes from the changelog file
        changeNotes = providers.gradleProperty("pluginVersion").map { pluginVersion ->
            with(changelog) {
                renderItem(
                    (getOrNull(pluginVersion) ?: getUnreleased())
                        .withHeader(false)
                        .withEmptySections(false),
                    Changelog.OutputType.HTML,
                )
            }
        }

        ideaVersion {
            // Supported build number ranges and IntelliJ Platform versions
            // https://plugins.jetbrains.com/docs/intellij/build-number-ranges.html
            // To depend on the TextMate bundle API, the plugin must start build from 241
            sinceBuild = "241"

            // Do not set `untilBuild` here but in the Marketplace directly.
            // This allows changing its value without re-publishing the plugin.
            // https://platform.jetbrains.com/t/why-cant-i-set-an-until-build-value-greater-than-251/1840
            // untilBuild = "253.*"

            // List of changes:
            // - https://plugins.jetbrains.com/docs/intellij/api-changes-list-2024.html#20243
            // - https://plugins.jetbrains.com/docs/intellij/api-notable-list-2024.html#20243
            // - https://plugins.jetbrains.com/docs/intellij/api-notable-list-2025.html
        }
    }

    signing {
        certificateChain = providers.environmentVariable("CERTIFICATE_CHAIN")
        privateKey = providers.environmentVariable("PRIVATE_KEY")
        password = providers.environmentVariable("PRIVATE_KEY_PASSWORD")
    }

    publishing {
        token = providers.environmentVariable("PUBLISH_TOKEN")
        // The pluginVersion is based on the SemVer (https://semver.org) and supports pre-release labels, like 2.1.7-alpha.3
        // Specify pre-release label to publish the plugin in a custom Release Channel automatically. Read more:
        // https://plugins.jetbrains.com/docs/intellij/deployment.html#specifying-a-release-channel
        channels = providers.gradleProperty("pluginVersion")
            .map { listOf(it.substringAfter('-', "").substringBefore('.').ifEmpty { "default" }) }
    }

    pluginVerification {
        ides {
            // The 'verifyPlugin' task is configured to test each minor version of IDEs in the configured
            // compatibility range, which can be a lot of versions.
            // Let's reduce that to the first and last versions only, to speed up the verification process.
            // https://github.com/JetBrains/intellij-platform-plugin-template/issues/462#issuecomment-2745197887
            val productReleases = ProductReleasesValueSource().get()
            val reducedProductReleases =
                if (productReleases.size > 2) listOf(productReleases.first(), productReleases.last())
                else productReleases
            ides(reducedProductReleases)
        }
    }
}

// Configure Gradle Changelog Plugin - read more: https://github.com/JetBrains/gradle-changelog-plugin
changelog {
    groups.empty()
    repositoryUrl = "https://github.com/qligier/jetbrains-plugin-fss"
}

// Configure Gradle Kover Plugin - read more: https://github.com/Kotlin/kotlinx-kover#configuration
kover {
    reports {
        total {
            xml {
                onCheck = true
            }
        }
    }
}

sourceSets {
    main {
        java {
            srcDir("src/main/kotlin")
            srcDir("src/main/gen")
        }
    }
}

tasks {
    // Set the JVM compatibility versions
    withType<JavaCompile> {
        sourceCompatibility = "21"
        targetCompatibility = "21"
    }

    wrapper {
        gradleVersion = providers.gradleProperty("gradleVersion").get()
    }

    publishPlugin {
        dependsOn(patchChangelog)
    }

    prepareSandbox {
        from("src/main/resources/fsh/fsh.tmbundle") {
            into(pluginName.map { "$it/fsh/fsh.tmbundle" })
        }
    }
    prepareTestSandbox {
        from("src/main/resources/fsh/fsh.tmbundle") {
            into(pluginName.map { "$it/fsh/fsh.tmbundle" })
        }
    }
}

intellijPlatformTesting {
    runIde {
        register("runIdeForUiTests") {
            task {
                jvmArgumentProviders += CommandLineArgumentProvider {
                    listOf(
                        "-Drobot-server.port=8082",
                        "-Dide.mac.message.dialogs.as.sheets=false",
                        "-Djb.privacy.policy.text=<!--999.999-->",
                        "-Djb.consents.confirmation.enabled=false",
                    )
                }
            }

            plugins {
                robotServerPlugin()
            }
        }
    }
}

/*
 * Copyright 2026 Quentin Ligier. Use of this source code is governed by the MIT license.
 */

import com.github.javaparser.printer.concretesyntaxmodel.CsmElement.token
import org.jetbrains.changelog.Changelog
import org.jetbrains.intellij.platform.gradle.TestFrameworkType
import org.jetbrains.intellij.platform.gradle.extensions.intellijPlatform

plugins {
    id("org.jetbrains.kotlin.jvm") version "2.4.21" // Kotlin support
    id("org.jetbrains.intellij.platform") version "2.20.1" // IntelliJ Platform Gradle Plugin
    id("org.jetbrains.changelog") version "2.5.0" // Gradle Changelog Plugin
    id("org.jetbrains.qodana") version "2026.3.1" // Gradle Qodana Plugin
    id("org.jetbrains.kotlinx.kover") version "0.9.11" // Gradle Kover Plugin
}

// Configure project's dependencies
repositories {
    mavenCentral()

    // IntelliJ Platform Gradle Plugin Repositories Extension - read more: https://plugins.jetbrains.com/docs/intellij/tools-intellij-platform-gradle-plugin-repositories-extension.html
    intellijPlatform {
        defaultRepositories()
    }
}

// Configure project's dependencies
dependencies {
    compileOnly("org.jetbrains:annotations:26.1.0")
    implementation("dev.ohs.fhir:fhir-model:1.0.0-beta03")

    testImplementation("junit:junit:4.13.2")

    // IntelliJ Platform Gradle Plugin Dependencies Extension - read more: https://plugins.jetbrains.com/docs/intellij/tools-intellij-platform-gradle-plugin-dependencies-extension.html
    intellijPlatform {
        intellijIdea("2025.3")

        // Bundled IntelliJ Platform plugins this plugin depends on
        bundledPlugin("org.jetbrains.plugins.yaml")
        bundledPlugin("com.intellij.modules.json")

        pluginVerifier()
        zipSigner()
        testFramework(TestFrameworkType.Platform)
    }
}

// Configure IntelliJ Platform Gradle Plugin - read more: https://plugins.jetbrains.com/docs/intellij/tools-intellij-platform-gradle-plugin-extension.html
intellijPlatform {
    pluginConfiguration {
        version = providers.gradleProperty("version")

        val changelog = project.changelog // local variable for configuration cache compatibility
        // Get the latest available change notes from the changelog file
        changeNotes =
            providers.gradleProperty("version").map { pluginVersion ->
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
            sinceBuild = "242"

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

    publishing {
        // The pluginVersion is based on the SemVer (https://semver.org) and supports pre-release labels, like 2.1.7-alpha.3
        // Specify pre-release label to publish the plugin in a custom Release Channel automatically. Read more:
        // https://plugins.jetbrains.com/docs/intellij/deployment.html#specifying-a-release-channel
        channels =
            providers
                .gradleProperty("version")
                .map { listOf(it.substringAfter('-', "").substringBefore('.').ifEmpty { "default" }) }
    }

    pluginVerification {
        ides {
            // The 'verifyPlugin' task is configured to test each minor version of IDEs in the configured
            // compatibility range, which can be a lot of versions.
            // Let's reduce that to the first and last versions only, to speed up the verification process and reduce
            // the storage used by the downloaded IDEs. This is especially important for GitHub actions, which have
            // limited resources.
            // https://github.com/JetBrains/intellij-platform-plugin-template/issues/462#issuecomment-4172769399
            current() // Use the current IDE because it's already downloaded
            latest { untilBuild = "242.*" } // This is the earliest supported build
            latest() // This is the latest supported build
        }
    }
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
            srcDir("src/main/gen")
        }
    }
}

tasks {
    publishPlugin {
        dependsOn(patchChangelog)
    }
}

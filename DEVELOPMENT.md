## Upgrade dependencies

The [IntelliJ Platform Plugin Template](https://github.com/JetBrains/intellij-platform-plugin-template) provides a
good template for an up-to-date plugin build configuration.

The API changes are documented for all releases:

- [Incompatible Changes](https://plugins.jetbrains.com/docs/intellij/api-changes-list.html)
- [Notable Changes and Features](https://plugins.jetbrains.com/docs/intellij/api-notable.html)

When modifying the Gradle version in `gradle.properties`, update the wrapper with:

```bash
./gradlew wrapper
```

After modifying the plugin dependencies, ensure that the plugin still passes all tests:

```bash
./gradlew check
./gradlew verifyPlugin
```

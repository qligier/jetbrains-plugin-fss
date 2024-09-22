# ![FHIR® and SUSHI Support Logo](src/main/resources/META-INF/pluginIcon.svg) JetBrains Plugin: FHIR® and SUSHI Support

<!-- Plugin description -->
A plugin that add supports for the [FHIR Shorthand language](https://build.fhir.org/ig/HL7/fhir-shorthand/index.html)
(_FSH_) and the [IG Publisher](https://github.com/HL7/fhir-ig-publisher) and [SUSHI](https://github.com/FHIR/sushi/)
tools.
<!-- Plugin description end -->

<p align="center">

![GitHub](https://img.shields.io/github/license/qligier/jetbrains-plugin-fss?style=flat-square)
![GitHub release (latest SemVer)](https://img.shields.io/github/v/release/qligier/jetbrains-plugin-fss?style=flat-square)
![GitHub last commit](https://img.shields.io/github/last-commit/qligier/jetbrains-plugin-fss?style=flat-square)
![JDK 17](https://img.shields.io/badge/JDK-17-blue?style=flat-square)
</p>

## IG Publisher support

A new configuration is available to run the _IG Publisher_ on the current project. _SUSHI_ is supported through the _IG
Publisher_.

> **Warning**
>
> It's currently the responsibility of the user to download the _IG Publisher_ and update its path in the
> configuration, and to make _SUSHI_ available in the project if needed.

## FSH language support

This plugin adds, for FSH files:

- Syntax highlighting;
- Block and line commenting actions (`Comment with Line Comment` and `Comment with Block Comment`)
- Braces matching;
- Renaming capabilities;
- Collapsable items;
- Inspection: alias should start with '$';
- Inspection: ids should be based on the item's name;

### Notice

The FHIR
Shorthand ![FSH icon](https://github.com/qligier/jetbrains-plugin-fss/raw/master/src/main/resources/icons/fsh_flame.png)
is maybe copyrighted?

The logo is derived from [Burn Fire Flame Hot](https://www.svgrepo.com/svg/404501/burn-fire-flame-hot), published
under [Creative Commons Zero](https://creativecommons.org/publicdomain/zero/1.0/) license.

_FHIR® is the registered trademark of HL7 and is used with the permission of HL7._

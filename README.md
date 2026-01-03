# ![FHIR® and SUSHI Support Logo](src/main/resources/META-INF/pluginIcon.svg) JetBrains Plugin: FHIR® and SUSHI Support

<!-- Plugin description -->
A plugin that add supports for the [FHIR Shorthand language](https://build.fhir.org/ig/HL7/fhir-shorthand/index.html)
(_FSH_), the [IG Publisher](https://github.com/HL7/fhir-ig-publisher) and [SUSHI](https://github.com/FHIR/sushi/)
tools.
<!-- Plugin description end -->

<p align="center">

![GitHub](https://img.shields.io/github/license/qligier/jetbrains-plugin-fss?style=flat-square)
![GitHub release (latest SemVer)](https://img.shields.io/github/v/release/qligier/jetbrains-plugin-fss?style=flat-square)
![GitHub last commit](https://img.shields.io/github/last-commit/qligier/jetbrains-plugin-fss?style=flat-square)
![JDK 17](https://img.shields.io/badge/JDK-17-blue?style=flat-square)
[![JETBRAINS-Marketplace](https://img.shields.io/badge/JETBRAINS-Marketplace-f8015f)](https://plugins.jetbrains.com/plugin/25435-fhir-and-sushi-support)
</p>

## FHIR® and SUSHI Support

This plugin adds, for FSH files:

- Syntax highlighting;
- Block and line commenting actions (`Comment with Line Comment` and `Comment with Block Comment`).

For the `ig.ini` file:

- Syntax highlighting;
- Auto-completion of the `IG.template` property value;
- Annotations for missing required properties.

For the `sushi-config.yaml` file:

- Annotations for the following issues:
    - Duplicate properties with different casing (e.g., `releaseLabel` and `releaselabel`);
    - Properties used with a too-old FHIR version (e.g., `copyrightLabel` with FHIR R4);
- Auto-completion for some properties (through a JSON Schema);
- Validation of some property values (through a JSON Schema).

### Screenshots

<table><tbody>
  <tr>
    <td>
        <a href="https://raw.githubusercontent.com/qligier/jetbrains-plugin-fss/refs/heads/master/.github/images/fsh1.png">
            <img src="https://raw.githubusercontent.com/qligier/jetbrains-plugin-fss/refs/heads/master/.github/images/fsh1.png" alt="FSH (1)"/>
        </a>
    </td>
    <td>
        <a href="https://raw.githubusercontent.com/qligier/jetbrains-plugin-fss/refs/heads/master/.github/images/fsh2.png">
            <img src="https://raw.githubusercontent.com/qligier/jetbrains-plugin-fss/refs/heads/master/.github/images/fsh2.png" alt="FSH (2)"/>
        </a>
    </td>
  </tr>
  <tr>
    <td>
        <a href="https://raw.githubusercontent.com/qligier/jetbrains-plugin-fss/refs/heads/master/.github/images/igini1.png">
            <img src="https://raw.githubusercontent.com/qligier/jetbrains-plugin-fss/refs/heads/master/.github/images/igini1.png" alt="ig.ini (1)"/>
        </a>
    </td>
    <td>
        <a href="https://raw.githubusercontent.com/qligier/jetbrains-plugin-fss/refs/heads/master/.github/images/igini2.png">
            <img src="https://raw.githubusercontent.com/qligier/jetbrains-plugin-fss/refs/heads/master/.github/images/igini2.png" alt="ig.ini (2)"/>
        </a>
    </td>
  </tr>
  <tr>
    <td>
        <a href="https://raw.githubusercontent.com/qligier/jetbrains-plugin-fss/refs/heads/master/.github/images/sushi-config1.png">
            <img src="https://raw.githubusercontent.com/qligier/jetbrains-plugin-fss/refs/heads/master/.github/images/sushi-config1.png" alt="sushi-config.yaml (1)"/>
        </a>
    </td>
    <td>
        <a href="https://raw.githubusercontent.com/qligier/jetbrains-plugin-fss/refs/heads/master/.github/images/sushi-config2.png">
            <img src="https://raw.githubusercontent.com/qligier/jetbrains-plugin-fss/refs/heads/master/.github/images/sushi-config2.png" alt="sushi-config.yaml (2)"/>
        </a>
    </td>
  </tr>
  <tr>
    <td>
        <a href="https://raw.githubusercontent.com/qligier/jetbrains-plugin-fss/refs/heads/master/.github/images/sushi-config1.png">
            <img src="https://raw.githubusercontent.com/qligier/jetbrains-plugin-fss/refs/heads/master/.github/images/sushi-config1.png" alt="sushi-config.yaml (3)"/>
        </a>
    </td>
    <td></td>
  </tr>
</tbody>
</table>

### Notice

The logo is derived from [Burn Fire Flame Hot](https://www.svgrepo.com/svg/404501/burn-fire-flame-hot), published
under [Creative Commons Zero](https://creativecommons.org/publicdomain/zero/1.0/) license.

_FHIR® is the registered trademark of HL7 and is used with the permission of HL7._

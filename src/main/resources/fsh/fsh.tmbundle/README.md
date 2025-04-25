# fsh.tmbundle

A TextMate 2 Bundle for the [FSH](https://build.fhir.org/ig/HL7/fhir-shorthand/index.html) (FHIR Shorthand) language.

## Installation

### JetBrains IDEs

1. Download or clone this repository on your local machine.
2. [Verify](https://www.jetbrains.com/help/idea/textmate.html#enable-the-plugin) that the plugin
   [TextMate Bundles](https://plugins.jetbrains.com/plugin/7221-textmate-bundles) is installed and enabled in your 
   JetBrains IDE (it should come pre-bundled).
3. In `Settings → Editor → TextMate Bundles`,
   [import the bundle](https://www.jetbrains.com/help/idea/textmate.html#import-textmate-bundles) you downloaded at 
   step 1.
4. Open an FSH file (with `.fsh` extension) in your JetBrains IDE and enjoy the syntax highlighting.

## Development

This bundle is based upon the `tmLanguage` implementation in the 
[vscode-language-fsh](https://github.com/standardhealth/vscode-language-fsh) project.

The `tmLanguage` file is converted from JSON to p-list using the [plist2](https://github.com/wareset/plist2) tool:

```bash
.\node_modules\.bin\plist2 .\fsh.tmLanguage.json .\fsh.tmbundle\Syntaxes\fsh.tmLanguage
```

The `info.plist` file is handcrafted.
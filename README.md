# jetbrains-plugin-fhir

A plugin that add supports for the [FHIR Shorthand language](https://build.fhir.org/ig/HL7/fhir-shorthand/index.html) (_
FSH_) and the [IG Publisher](https://github.com/HL7/fhir-ig-publisher) and [SUSHI](https://github.com/FHIR/sushi/)
tools.

## IG Publisher support

A new configuration is available to run the IG Publisher on the current project. SUSHI is supported through the IG
Publisher.

> **Warning**
>
> It's currently the responsibility of the user to download the IG Publisher and update its path in the
> configuration, and to make SUSHI available in the project if needed.

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
Shorthand ![FSH icon](https://github.com/qligier/jetbrains-plugin-fhir/raw/master/src/main/resources/icons/fsh_flame.png)
is maybe copyrighted?

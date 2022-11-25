// Use a double-slash for comments on a single line

/*
Use slash-asterisk and asterisk-slash for larger block comments.
These comments can take up multiple lines.
*/
Alias: $SCT = http://snomed.info/sct
Alias: $RaceAndEthnicityCDC = urn:oid:2.16.840.1.113883.6.238
Alias: obs-cat = http://terminology.hl7.org/CodeSystem/observation-category

CodeSystem:  YogaCS
Id: yoga-code-system
Title: "Yoga Code System"
Description:  "A brief vocabulary of yoga-related terms."
* #Sirsasana "Headstand"
    "An pose that involves standing on one's head."
* #Halasana "Plough Pose"
    "A pose from supine position, bringing legs up and over until the toes touch the ground behind the head."
* #Matsyasana "Fish Pose"
    "A pose from supine position, arching the back and pressing the chest upwards."
* #Bhujangasana "Cobra Pose"
    "A pose starting from prone position with hands pushing the shoulders upward, with legs and hips remaining on the ground."

CodeSystem: AnteaterCS
Id: anteater-code-system
Title: "Anteater Code System"
Description: "A code system for anteater taxonomy with hierarchical codes"
* #Anteater "Anteater" "Members of suborder Vermilingua, distinguished by its propensity to eat ants"
* #Anteater #Tamandua "Members of genus Tamandua" "The Tamandua genus of anteaters, mainly found in forests and grasslands"
* #Anteater #Tamandua #NorthernTamandua "Northern Tamandua" "The northern species of Tamandua anteaters"
* #Anteater #Tamandua #SouthernTamandua "Southern Tamandua" "The southern species of Tamandua anteaters"
* #Anteater #GiantAnteater "Giant Anteater" "The Giant Anteater, typically 6 - 7 feet in length"
* #active ^designation[0].use = $SCT#900000000000003001 "Fully specified name"

Extension:      USCoreEthnicityExtension
Id:             us-core-ethnicity
Title:          "US Core Ethnicity Extension"
Description:    "Concepts classifying the person into a named category of humans sharing common history, traits, geographical origin or nationality. The ethnicity codes used to represent these concepts are based upon the [CDC ethnicity and Ethnicity Code Set Version 1.0](http://www.cdc.gov/phin/resources/vocabulary/index.html) which includes over 900 concepts for representing race and ethnicity of which 43 reference ethnicity.  The ethnicity concepts are grouped by and pre-mapped to the 2 OMB ethnicity categories: - Hispanic or Latino - Not Hispanic or Latino."
// publisher, contact, and other metadata could be defined here using caret syntax (omitted)
* extension contains
    ombCategory 0..1 MS and
    detailed 0..* and
    text 1..1 MS
* extension[ombCategory] ^short = "Hispanic or Latino|Not Hispanic or Latino"
* extension[ombCategory].value[x] only Coding
* extension[ombCategory].valueCoding from OmbEthnicityCategories (required) // OmbEthnicityCategories is a value set defined by US Core
* extension[detailed] ^short = "Extended ethnicity codes"
* extension[detailed].value[x] only Coding
* extension[detailed].valueCoding from DetailedEthnicity (required) // DetailedEthnicity is defined in US Core
* extension[text] ^short = "Ethnicity text"
* extension[text].value[x] only string

Extension:      BinaryBirthSexExtension
Parent:         USCoreBirthSexExtension
Id:             binary-birthsex
Title:          "Binary Birth Sex Extension"
Description:    "As of 2019, certain US states only allow M or F on birth certificates."
* valueCode from BinaryBirthSexValueSet (required)

Instance:  EveAnyperson
InstanceOf: http://hl7.org/fhir/us/core/StructureDefinition/us-core-patient
Title:   "Eve Anyperson"
Usage:  #example
* name.given = "Eve"
* name.family = "Anyperson"
* birthDate = 1960-04-25
* extension[us-core-race].extension[ombCategory].valueCoding = RaceAndEthnicityCDC#2106-3 "White"
* extension[us-core-ethnicity].extension[ombCategory].valueCoding = RaceAndEthnicityCDC#2186-5 "Non Hispanic or Latino"

Instance:   DrDavidAnydoc
InstanceOf: http://hl7.org/fhir/us/core/StructureDefinition/us-core-practitioner
Usage:  #inline
* name.family = "Anydoc"
* name.given = "David"
* name.suffix = "MD"
* identifier[NPI].value = "8274017284"

Instance: EveAnyperson
InstanceOf: Patient
Usage: #inline // #inline means this instance should not be exported as a separate example
* name.given[0] = "Eve"
* name.family = "Anyperson"

Instance: EvesCondition
InstanceOf: Condition
Usage: #example
Description: "An example that uses contained"
* contained[0] = EveAnyperson // this inlines EveAnyperson definition here
* code = http://foo.org#bar
* subject = Reference(EveAnyperson) // this automatically creates the relative reference correctly

Instance: mCODEPrimaryCancerConditionExample01
InstanceOf: PrimaryCancerCondition
Description: "mCODE Example for Primary Cancer Condition"
Usage: #example
* id = "mCODEPrimaryCancerConditionExample01"
* clinicalStatus = $ClinStatus#active "Active"
* verificationStatus = $VerStatus#confirmed "Confirmed"
* code = $SCT#254637007 "Non-small cell lung cancer (disorder)"
* extension[HistologyMorphologyBehavior].valueCodeableConcept = $SCT#35917007 "Adenocarcinoma"
* bodySite = $SCT#39607008 "Lung structure (body structure)"
* bodySite.extension[Laterality].valueCodeableConcept = $SCT#7771000 "Left (qualifier value)"
* subject = Reference(mCODEPatientExample01)
* onsetDateTime = "2019-04-01"
* asserter = Reference(mCODEPractitionerExample01)
* stage.summary = $AJCC#3C "IIIC"
* stage.assessment = Reference(mCODETNMClinicalStageGroupExample01)

Invariant:   us-core-8
Description: "Patient.name.given or Patient.name.family or both SHALL be present"
Expression:  "family.exists() or given.exists()"
Severity:    #error
XPath:       "f:given or f:family"

Logical:        Human
Id:             human-being-logical-model
Title:          "Human Being"
Description:    "A member of the Homo sapiens species."
* name 0..* SU HumanName "Name(s) of the human" "The names by which the human is or has been known"
* birthDate 0..1 SU dateTime "The date of birth, if known"
    "The date on which the person was born. Approximations may be used if exact date is unknown."
* deceased[x] 0..1 SU boolean or dateTime or Age "Indication if the human is deceased"
    "An indication if the human has died. Boolean should not be used if date or age at death are known."
* family 0..1 BackboneElement "Family" "Members of the human's immediate family."
  * mother 0..2 FamilyMember "Mother" "Biological mother, current adoptive mother, or both."
  * father 0..2 FamilyMember "Father" "Biological father, current adoptive father, or both."
  * sibling 0..* FamilyMember "Sibling" "Other children of the human's mother and/or father."

Logical:        FamilyMember
Id:             family-member
Title:          "Family Member"
Description:    "A reference to a family member (not necessarily biologically related)."
* human 1..1 SU Reference(Human) "Family member" "A reference to the human family member"
* biological 0..1 boolean "Biologically related?"
    "A family member may not be biologically related due to adoption, blended families, etc."

Mapping:  USCorePatientToArgonaut
Source:   USCorePatient
Target:   "http://unknown.org/Argonaut-DQ-DSTU2"
Id:       argonaut-dq-dstu2
Title:    "Argonaut DSTU2"
* -> "Patient"
* extension[USCoreRaceExtension] -> "Patient.extension[http://fhir.org/guides/argonaut/StructureDefinition/argo-race]"
* extension[USCoreEthnicityExtension] -> "Patient.extension[http://fhir.org/guides/argonaut/StructureDefinition/argo-ethnicity]"
* extension[USCoreBirthSexExtension] -> "Patient.extension[http://fhir.org/guides/argonaut/StructureDefinition/argo-birthsex]"
* identifier -> "Patient.identifier"
* identifier.system -> "Patient.identifier.system"
* identifier.value -> "Patient.identifier.value"

Profile:        KnownExposureSetting
Parent:         Observation
Id:             known-exposure-setting
Title:          "Known Exposure Setting Profile"
Description:    "The setting where an individual was exposed to a contagion."
* code = $LNC#81267-7 // Setting of exposure to illness
* value[x] only CodeableConcept
* valueCodeableConcept from https://loinc.org/vs/LL3991-8 (extensible)

Resource:       EmergencyVehicle
Id:             emergency-vehicle
Title:          "Emergency Vehicle"
Description:    "An emergency vehicle, such as an ambulance or fire truck."
* identifier 0..* SU Identifier
    "Identifier(s) of the vehicle"
    "Vehicle identifiers may include VINs and serial numbers."
* make 0..1 SU Coding
    "The vehicle make"
    "The vehicle make, e.g., Chevrolet."
* make from EmergencyVehicleMake (extensible)
* model 0..1 SU Coding
    "The vehicle model"
    "The vehicle model, e.g., G4500."
* model from EmergencyVehicleModel (extensible)
* year 0..1 SU positiveInt
    "Year of manufacture"
    "The year the vehicle was manufactured"
* servicePeriod 0..1 Period
    "When the vehicle was in service"
    "Start date and end date (if applicable) when the vehicle operated."
* operator 0..* Reference(Organization or Practitioner or PractitionerRole)
    "The operator"
    "The organization or persons repsonsible for operating the vehicle"
* device 0..* Reference(Device)
    "Devices on board"
    "Devices on board the vehicle."

RuleSet: RuleSet1
* ^status = #draft
* ^experimental = true
* ^publisher = "Elbonian Medical Society"

RuleSet: SetContext(path)
* ^context[+].type = #element
* ^context[=].expression = "{path}"

ValueSet: BodyWeightPreconditionVS
Title: "Body weight preconditions."
Description:  "Circumstances for body weight measurement."
* $SCT#971000205103 "Wearing street clothes with shoes"
* $SCT#961000205106 "Wearing street clothes, no shoes"
* $SCT#951000205108 "Wearing underwear or less"

ValueSet: HistologyMorphologyBehaviorVS
Id: mcode-histology-morphology-behavior-vs
Title: "Histology Morphology Behavior Value Set"
Description: "Codes representing the structure, arrangement, and behavioral characteristics of malignant neoplasms, and cancer cells."
* include codes from system $SCT where concept is-a #367651003 "Malignant neoplasm of primary, secondary, or uncertain origin (morphologic abnormality)"
* include codes from system $SCT where concept is-a #399919001 "Carcinoma in situ - category (morphologic abnormality)"
* include codes from system $SCT where concept is-a #399983006 "In situ adenomatous neoplasm - category (morphologic abnormality)"
* exclude codes from system $SCT where concept is-a #450893003 "Papillary neoplasm, pancreatobiliary-type, with high grade intraepithelial neoplasia (morphologic abnormality)"
* exclude codes from system $SCT where concept is-a #128640002 "Glandular intraepithelial neoplasia, grade III (morphologic abnormality)"
* exclude codes from system $SCT where concept is-a #450890000 "Glandular intraepithelial neoplasia, low grade (morphologic abnormality)"
* exclude codes from system $SCT where concept is-a #703548001 "Endometrioid intraepithelial neoplasia (morphologic abnormality)"

Profile: TumorSize
Parent:  Observation
Id: example-tumor-size
Title: "Tumor Size"
Description:  "Records the one to three dimensions of a tumor"
* code = $LNC#21889-1 //"Size Tumor"
// other rules omitted
* component ^slicing.discriminator.type = #pattern
* component ^slicing.discriminator.path = "code"
* component ^slicing.rules = #open
* component ^slicing.description = "Slice based on the component.code pattern"
// Contains rule
* component contains tumorLongestDimension 1..1 and tumorOtherDimension 0..2
// Set properties of each slice
* component[tumorLongestDimension] ^short = "Longest tumor dimension"
* component[tumorLongestDimension] ^definition = "The longest tumor dimension in cm or mm."
* component[tumorLongestDimension].code = $LNC#33728-7 // "Size.maximum dimension in Tumor"
* component[tumorLongestDimension].value[x] only Quantity
* component[tumorLongestDimension].valueQuantity from TumorSizeUnitsVS (required)   // value set defined elsewhere
* component[tumorOtherDimension] ^short = "Other tumor dimension(s)"
* component[tumorOtherDimension] ^definition = "The second or third tumor dimension in cm or mm."
* component[tumorOtherDimension] ^comment = "Additional tumor dimensions should be ordered from largest to smallest."
* component[tumorOtherDimension].code = $LNC#33729-5 // "Size additional dimension in Tumor"
* component[tumorOtherDimension].value[x] only Quantity
* component[tumorOtherDimension].valueQuantity from TumorSizeUnitsVS (required)

RuleSet: Name(first, last)
* name[+].given = "{first}"
* name[=].family = "{last}"


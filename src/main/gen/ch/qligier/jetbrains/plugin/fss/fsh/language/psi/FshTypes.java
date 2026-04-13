// This is a generated file. Not intended for manual editing.
package ch.qligier.jetbrains.plugin.fss.fsh.language.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import ch.qligier.jetbrains.plugin.fss.fsh.language.psi.impl.*;

public interface FshTypes {

  IElementType ADD_ELEMENT_RULE = new FshElementType("ADD_ELEMENT_RULE");
  IElementType ALIAS = new FshElementType("ALIAS");
  IElementType BINDING_RULE = new FshElementType("BINDING_RULE");
  IElementType BINDING_STRENGTH = new FshElementType("BINDING_STRENGTH");
  IElementType BOOLEAN_VALUE = new FshElementType("BOOLEAN_VALUE");
  IElementType BRACKET_SUFFIX = new FshElementType("BRACKET_SUFFIX");
  IElementType CANONICAL_TARGET = new FshElementType("CANONICAL_TARGET");
  IElementType CANONICAL_TYPE = new FshElementType("CANONICAL_TYPE");
  IElementType CARDINALITY = new FshElementType("CARDINALITY");
  IElementType CARD_RULE = new FshElementType("CARD_RULE");
  IElementType CARET_VALUE_RULE = new FshElementType("CARET_VALUE_RULE");
  IElementType CHARACTERISTICS_METADATA = new FshElementType("CHARACTERISTICS_METADATA");
  IElementType CODEABLE_REFERENCE_TYPE = new FshElementType("CODEABLE_REFERENCE_TYPE");
  IElementType CODE_CARET_VALUE_RULE = new FshElementType("CODE_CARET_VALUE_RULE");
  IElementType CODE_SYSTEM = new FshElementType("CODE_SYSTEM");
  IElementType CODE_VALUE = new FshElementType("CODE_VALUE");
  IElementType CONCEPT_RULE = new FshElementType("CONCEPT_RULE");
  IElementType CONTAINS_ITEM = new FshElementType("CONTAINS_ITEM");
  IElementType CONTAINS_RULE = new FshElementType("CONTAINS_RULE");
  IElementType CONTEXT_ITEM = new FshElementType("CONTEXT_ITEM");
  IElementType CONTEXT_METADATA = new FshElementType("CONTEXT_METADATA");
  IElementType CS_METADATA = new FshElementType("CS_METADATA");
  IElementType CS_RULE = new FshElementType("CS_RULE");
  IElementType DATE_TIME_VALUE = new FshElementType("DATE_TIME_VALUE");
  IElementType DATE_VALUE = new FshElementType("DATE_VALUE");
  IElementType DESCRIPTION_METADATA = new FshElementType("DESCRIPTION_METADATA");
  IElementType ENTITY = new FshElementType("ENTITY");
  IElementType EXPRESSION_METADATA = new FshElementType("EXPRESSION_METADATA");
  IElementType EXTENSION = new FshElementType("EXTENSION");
  IElementType EXTENSION_METADATA = new FshElementType("EXTENSION_METADATA");
  IElementType FIXED_VALUE_RULE = new FshElementType("FIXED_VALUE_RULE");
  IElementType FLAG = new FshElementType("FLAG");
  IElementType FLAG_RULE = new FshElementType("FLAG_RULE");
  IElementType ID_METADATA = new FshElementType("ID_METADATA");
  IElementType INSERT_RULE = new FshElementType("INSERT_RULE");
  IElementType INSTANCE = new FshElementType("INSTANCE");
  IElementType INSTANCE_METADATA = new FshElementType("INSTANCE_METADATA");
  IElementType INSTANCE_OF_METADATA = new FshElementType("INSTANCE_OF_METADATA");
  IElementType INSTANCE_RULE = new FshElementType("INSTANCE_RULE");
  IElementType INVARIANT = new FshElementType("INVARIANT");
  IElementType INVARIANT_METADATA = new FshElementType("INVARIANT_METADATA");
  IElementType LOGICAL = new FshElementType("LOGICAL");
  IElementType LOGICAL_METADATA = new FshElementType("LOGICAL_METADATA");
  IElementType MAPPING = new FshElementType("MAPPING");
  IElementType MAPPING_ENTITY_METADATA = new FshElementType("MAPPING_ENTITY_METADATA");
  IElementType MAPPING_ENTITY_RULE = new FshElementType("MAPPING_ENTITY_RULE");
  IElementType MAPPING_RULE = new FshElementType("MAPPING_RULE");
  IElementType MIXINS_METADATA = new FshElementType("MIXINS_METADATA");
  IElementType NAME_TOKEN = new FshElementType("NAME_TOKEN");
  IElementType OBEYS_RULE = new FshElementType("OBEYS_RULE");
  IElementType ONLY_RULE = new FshElementType("ONLY_RULE");
  IElementType PARENT_METADATA = new FshElementType("PARENT_METADATA");
  IElementType PATH = new FshElementType("PATH");
  IElementType PATH_PART = new FshElementType("PATH_PART");
  IElementType PATH_RULE = new FshElementType("PATH_RULE");
  IElementType PROFILE = new FshElementType("PROFILE");
  IElementType PROFILE_METADATA = new FshElementType("PROFILE_METADATA");
  IElementType QUANTITY = new FshElementType("QUANTITY");
  IElementType RATIO_VALUE = new FshElementType("RATIO_VALUE");
  IElementType REFERENCE_TYPE = new FshElementType("REFERENCE_TYPE");
  IElementType RESOURCE = new FshElementType("RESOURCE");
  IElementType RESOURCE_METADATA = new FshElementType("RESOURCE_METADATA");
  IElementType RULE_SET = new FshElementType("RULE_SET");
  IElementType RULE_SET_ARGUMENT = new FshElementType("RULE_SET_ARGUMENT");
  IElementType RULE_SET_ARG_CONTENT = new FshElementType("RULE_SET_ARG_CONTENT");
  IElementType RULE_SET_ID = new FshElementType("RULE_SET_ID");
  IElementType RULE_SET_PARAM = new FshElementType("RULE_SET_PARAM");
  IElementType RULE_SET_REFERENCE = new FshElementType("RULE_SET_REFERENCE");
  IElementType RULE_SET_RULE = new FshElementType("RULE_SET_RULE");
  IElementType SD_RULE = new FshElementType("SD_RULE");
  IElementType SEVERITY_METADATA = new FshElementType("SEVERITY_METADATA");
  IElementType SOURCE_METADATA = new FshElementType("SOURCE_METADATA");
  IElementType TARGET_METADATA = new FshElementType("TARGET_METADATA");
  IElementType TARGET_TYPE = new FshElementType("TARGET_TYPE");
  IElementType TIME_VALUE = new FshElementType("TIME_VALUE");
  IElementType TITLE_METADATA = new FshElementType("TITLE_METADATA");
  IElementType USAGE_METADATA = new FshElementType("USAGE_METADATA");
  IElementType VALUE = new FshElementType("VALUE");
  IElementType VALUE_SET = new FshElementType("VALUE_SET");
  IElementType VS_COMPONENT = new FshElementType("VS_COMPONENT");
  IElementType VS_COMPONENT_FROM = new FshElementType("VS_COMPONENT_FROM");
  IElementType VS_CONCEPT_COMPONENT = new FshElementType("VS_CONCEPT_COMPONENT");
  IElementType VS_FILTER_COMPONENT = new FshElementType("VS_FILTER_COMPONENT");
  IElementType VS_FILTER_ITEM = new FshElementType("VS_FILTER_ITEM");
  IElementType VS_FILTER_LIST = new FshElementType("VS_FILTER_LIST");
  IElementType VS_FILTER_OPERATOR = new FshElementType("VS_FILTER_OPERATOR");
  IElementType VS_FILTER_VALUE = new FshElementType("VS_FILTER_VALUE");
  IElementType VS_FROM_SYSTEM = new FshElementType("VS_FROM_SYSTEM");
  IElementType VS_FROM_VALUE_SETS = new FshElementType("VS_FROM_VALUE_SETS");
  IElementType VS_METADATA = new FshElementType("VS_METADATA");
  IElementType VS_RULE = new FshElementType("VS_RULE");
  IElementType XPATH_METADATA = new FshElementType("XPATH_METADATA");

  IElementType ALIAS_REF = new FshTokenType("ALIAS_REF");
  IElementType ARROW = new FshTokenType("->");
  IElementType BLOCK_COMMENT = new FshTokenType("BLOCK_COMMENT");
  IElementType CARDINALITY_TOKEN = new FshTokenType("CARDINALITY_TOKEN");
  IElementType CARET = new FshTokenType("^");
  IElementType CODE = new FshTokenType("CODE");
  IElementType COLON = new FshTokenType(":");
  IElementType COMMA = new FshTokenType(",");
  IElementType DATE = new FshTokenType("DATE");
  IElementType DATETIME = new FshTokenType("DATETIME");
  IElementType DBL_LBRACKET = new FshTokenType("[[");
  IElementType DBL_RBRACKET = new FshTokenType("]]");
  IElementType DECIMAL = new FshTokenType("DECIMAL");
  IElementType DOT = new FshTokenType(".");
  IElementType DOT_DOT = new FshTokenType("..");
  IElementType EQUALS = new FshTokenType("=");
  IElementType IDENTIFIER = new FshTokenType("IDENTIFIER");
  IElementType INTEGER = new FshTokenType("INTEGER");
  IElementType KW_ALIAS = new FshTokenType("Alias");
  IElementType KW_AND = new FshTokenType("and");
  IElementType KW_CANONICAL = new FshTokenType("Canonical");
  IElementType KW_CHARACTERISTICS = new FshTokenType("Characteristics");
  IElementType KW_CODEABLE_REF = new FshTokenType("CodeableReference");
  IElementType KW_CODES = new FshTokenType("codes");
  IElementType KW_CODESYSTEM = new FshTokenType("CodeSystem");
  IElementType KW_CONTAINS = new FshTokenType("contains");
  IElementType KW_CONTENTREFERENCE = new FshTokenType("contentReference");
  IElementType KW_CONTEXT = new FshTokenType("Context");
  IElementType KW_DESCENDENT_OF = new FshTokenType("descendent-of");
  IElementType KW_DESCRIPTION = new FshTokenType("Description");
  IElementType KW_DRAFT = new FshTokenType("D");
  IElementType KW_EXACTLY = new FshTokenType("exactly");
  IElementType KW_EXAMPLE = new FshTokenType("example");
  IElementType KW_EXCLUDE = new FshTokenType("exclude");
  IElementType KW_EXISTS = new FshTokenType("exists");
  IElementType KW_EXPRESSION = new FshTokenType("Expression");
  IElementType KW_EXTENSIBLE = new FshTokenType("extensible");
  IElementType KW_EXTENSION = new FshTokenType("Extension");
  IElementType KW_FALSE = new FshTokenType("false");
  IElementType KW_FROM = new FshTokenType("from");
  IElementType KW_GENERALIZES = new FshTokenType("generalizes");
  IElementType KW_ID = new FshTokenType("Id");
  IElementType KW_IN = new FshTokenType("in");
  IElementType KW_INCLUDE = new FshTokenType("include");
  IElementType KW_INSERT = new FshTokenType("insert");
  IElementType KW_INSTANCE = new FshTokenType("Instance");
  IElementType KW_INSTANCEOF = new FshTokenType("InstanceOf");
  IElementType KW_INVARIANT = new FshTokenType("Invariant");
  IElementType KW_IS_A = new FshTokenType("is-a");
  IElementType KW_IS_NOT_A = new FshTokenType("is-not-a");
  IElementType KW_LOGICAL = new FshTokenType("Logical");
  IElementType KW_MAPPING = new FshTokenType("Mapping");
  IElementType KW_MIXINS = new FshTokenType("Mixins");
  IElementType KW_MODIFIEREXT = new FshTokenType("?!");
  IElementType KW_MS = new FshTokenType("MS");
  IElementType KW_NAMED = new FshTokenType("named");
  IElementType KW_NORMATIVE = new FshTokenType("N");
  IElementType KW_NOT_IN = new FshTokenType("not-in");
  IElementType KW_OBEYS = new FshTokenType("obeys");
  IElementType KW_ONLY = new FshTokenType("only");
  IElementType KW_OR = new FshTokenType("or");
  IElementType KW_PARENT = new FshTokenType("Parent");
  IElementType KW_PREFERRED = new FshTokenType("preferred");
  IElementType KW_PROFILE = new FshTokenType("Profile");
  IElementType KW_REFERENCE = new FshTokenType("Reference");
  IElementType KW_REGEX = new FshTokenType("regex");
  IElementType KW_REQUIRED = new FshTokenType("required");
  IElementType KW_RESOURCE = new FshTokenType("Resource");
  IElementType KW_RULESET = new FshTokenType("RuleSet");
  IElementType KW_SEVERITY = new FshTokenType("Severity");
  IElementType KW_SOURCE = new FshTokenType("Source");
  IElementType KW_SU = new FshTokenType("SU");
  IElementType KW_SYSTEM = new FshTokenType("system");
  IElementType KW_TARGET = new FshTokenType("Target");
  IElementType KW_TITLE = new FshTokenType("Title");
  IElementType KW_TRUE = new FshTokenType("true");
  IElementType KW_TU = new FshTokenType("TU");
  IElementType KW_UNITS = new FshTokenType("units");
  IElementType KW_USAGE = new FshTokenType("Usage");
  IElementType KW_VALUESET = new FshTokenType("ValueSet");
  IElementType KW_VS_VALUESET = new FshTokenType("valueset");
  IElementType KW_WHERE = new FshTokenType("where");
  IElementType KW_XPATH = new FshTokenType("XPath");
  IElementType LBRACKET = new FshTokenType("[");
  IElementType LINE_COMMENT = new FshTokenType("LINE_COMMENT");
  IElementType LPAREN = new FshTokenType("(");
  IElementType MULTILINE_STRING = new FshTokenType("MULTILINE_STRING");
  IElementType PIPE = new FshTokenType("|");
  IElementType PLUS = new FshTokenType("+");
  IElementType QUOTED_CODE = new FshTokenType("QUOTED_CODE");
  IElementType RBRACKET = new FshTokenType("]");
  IElementType REGEX_LITERAL = new FshTokenType("REGEX_LITERAL");
  IElementType RPAREN = new FshTokenType(")");
  IElementType SEQUENCE = new FshTokenType("SEQUENCE");
  IElementType STAR = new FshTokenType("*");
  IElementType STRING = new FshTokenType("STRING");
  IElementType TIME = new FshTokenType("TIME");
  IElementType UCUM_UNIT = new FshTokenType("UCUM_UNIT");
  IElementType URL = new FshTokenType("URL");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == ADD_ELEMENT_RULE) {
        return new FshAddElementRuleImpl(node);
      }
      else if (type == ALIAS) {
        return new FshAliasImpl(node);
      }
      else if (type == BINDING_RULE) {
        return new FshBindingRuleImpl(node);
      }
      else if (type == BINDING_STRENGTH) {
        return new FshBindingStrengthImpl(node);
      }
      else if (type == BOOLEAN_VALUE) {
        return new FshBooleanValueImpl(node);
      }
      else if (type == BRACKET_SUFFIX) {
        return new FshBracketSuffixImpl(node);
      }
      else if (type == CANONICAL_TARGET) {
        return new FshCanonicalTargetImpl(node);
      }
      else if (type == CANONICAL_TYPE) {
        return new FshCanonicalTypeImpl(node);
      }
      else if (type == CARDINALITY) {
        return new FshCardinalityImpl(node);
      }
      else if (type == CARD_RULE) {
        return new FshCardRuleImpl(node);
      }
      else if (type == CARET_VALUE_RULE) {
        return new FshCaretValueRuleImpl(node);
      }
      else if (type == CHARACTERISTICS_METADATA) {
        return new FshCharacteristicsMetadataImpl(node);
      }
      else if (type == CODEABLE_REFERENCE_TYPE) {
        return new FshCodeableReferenceTypeImpl(node);
      }
      else if (type == CODE_CARET_VALUE_RULE) {
        return new FshCodeCaretValueRuleImpl(node);
      }
      else if (type == CODE_SYSTEM) {
        return new FshCodeSystemImpl(node);
      }
      else if (type == CODE_VALUE) {
        return new FshCodeValueImpl(node);
      }
      else if (type == CONCEPT_RULE) {
        return new FshConceptRuleImpl(node);
      }
      else if (type == CONTAINS_ITEM) {
        return new FshContainsItemImpl(node);
      }
      else if (type == CONTAINS_RULE) {
        return new FshContainsRuleImpl(node);
      }
      else if (type == CONTEXT_ITEM) {
        return new FshContextItemImpl(node);
      }
      else if (type == CONTEXT_METADATA) {
        return new FshContextMetadataImpl(node);
      }
      else if (type == CS_METADATA) {
        return new FshCsMetadataImpl(node);
      }
      else if (type == CS_RULE) {
        return new FshCsRuleImpl(node);
      }
      else if (type == DATE_TIME_VALUE) {
        return new FshDateTimeValueImpl(node);
      }
      else if (type == DATE_VALUE) {
        return new FshDateValueImpl(node);
      }
      else if (type == DESCRIPTION_METADATA) {
        return new FshDescriptionMetadataImpl(node);
      }
      else if (type == EXPRESSION_METADATA) {
        return new FshExpressionMetadataImpl(node);
      }
      else if (type == EXTENSION) {
        return new FshExtensionImpl(node);
      }
      else if (type == EXTENSION_METADATA) {
        return new FshExtensionMetadataImpl(node);
      }
      else if (type == FIXED_VALUE_RULE) {
        return new FshFixedValueRuleImpl(node);
      }
      else if (type == FLAG) {
        return new FshFlagImpl(node);
      }
      else if (type == FLAG_RULE) {
        return new FshFlagRuleImpl(node);
      }
      else if (type == ID_METADATA) {
        return new FshIdMetadataImpl(node);
      }
      else if (type == INSERT_RULE) {
        return new FshInsertRuleImpl(node);
      }
      else if (type == INSTANCE) {
        return new FshInstanceImpl(node);
      }
      else if (type == INSTANCE_METADATA) {
        return new FshInstanceMetadataImpl(node);
      }
      else if (type == INSTANCE_OF_METADATA) {
        return new FshInstanceOfMetadataImpl(node);
      }
      else if (type == INSTANCE_RULE) {
        return new FshInstanceRuleImpl(node);
      }
      else if (type == INVARIANT) {
        return new FshInvariantImpl(node);
      }
      else if (type == INVARIANT_METADATA) {
        return new FshInvariantMetadataImpl(node);
      }
      else if (type == LOGICAL) {
        return new FshLogicalImpl(node);
      }
      else if (type == LOGICAL_METADATA) {
        return new FshLogicalMetadataImpl(node);
      }
      else if (type == MAPPING) {
        return new FshMappingImpl(node);
      }
      else if (type == MAPPING_ENTITY_METADATA) {
        return new FshMappingEntityMetadataImpl(node);
      }
      else if (type == MAPPING_ENTITY_RULE) {
        return new FshMappingEntityRuleImpl(node);
      }
      else if (type == MAPPING_RULE) {
        return new FshMappingRuleImpl(node);
      }
      else if (type == MIXINS_METADATA) {
        return new FshMixinsMetadataImpl(node);
      }
      else if (type == NAME_TOKEN) {
        return new FshNameTokenImpl(node);
      }
      else if (type == OBEYS_RULE) {
        return new FshObeysRuleImpl(node);
      }
      else if (type == ONLY_RULE) {
        return new FshOnlyRuleImpl(node);
      }
      else if (type == PARENT_METADATA) {
        return new FshParentMetadataImpl(node);
      }
      else if (type == PATH) {
        return new FshPathImpl(node);
      }
      else if (type == PATH_PART) {
        return new FshPathPartImpl(node);
      }
      else if (type == PATH_RULE) {
        return new FshPathRuleImpl(node);
      }
      else if (type == PROFILE) {
        return new FshProfileImpl(node);
      }
      else if (type == PROFILE_METADATA) {
        return new FshProfileMetadataImpl(node);
      }
      else if (type == QUANTITY) {
        return new FshQuantityImpl(node);
      }
      else if (type == RATIO_VALUE) {
        return new FshRatioValueImpl(node);
      }
      else if (type == REFERENCE_TYPE) {
        return new FshReferenceTypeImpl(node);
      }
      else if (type == RESOURCE) {
        return new FshResourceImpl(node);
      }
      else if (type == RESOURCE_METADATA) {
        return new FshResourceMetadataImpl(node);
      }
      else if (type == RULE_SET) {
        return new FshRuleSetImpl(node);
      }
      else if (type == RULE_SET_ARGUMENT) {
        return new FshRuleSetArgumentImpl(node);
      }
      else if (type == RULE_SET_ARG_CONTENT) {
        return new FshRuleSetArgContentImpl(node);
      }
      else if (type == RULE_SET_ID) {
        return new FshRuleSetIdImpl(node);
      }
      else if (type == RULE_SET_PARAM) {
        return new FshRuleSetParamImpl(node);
      }
      else if (type == RULE_SET_REFERENCE) {
        return new FshRuleSetReferenceImpl(node);
      }
      else if (type == RULE_SET_RULE) {
        return new FshRuleSetRuleImpl(node);
      }
      else if (type == SD_RULE) {
        return new FshSdRuleImpl(node);
      }
      else if (type == SEVERITY_METADATA) {
        return new FshSeverityMetadataImpl(node);
      }
      else if (type == SOURCE_METADATA) {
        return new FshSourceMetadataImpl(node);
      }
      else if (type == TARGET_METADATA) {
        return new FshTargetMetadataImpl(node);
      }
      else if (type == TARGET_TYPE) {
        return new FshTargetTypeImpl(node);
      }
      else if (type == TIME_VALUE) {
        return new FshTimeValueImpl(node);
      }
      else if (type == TITLE_METADATA) {
        return new FshTitleMetadataImpl(node);
      }
      else if (type == USAGE_METADATA) {
        return new FshUsageMetadataImpl(node);
      }
      else if (type == VALUE) {
        return new FshValueImpl(node);
      }
      else if (type == VALUE_SET) {
        return new FshValueSetImpl(node);
      }
      else if (type == VS_COMPONENT) {
        return new FshVsComponentImpl(node);
      }
      else if (type == VS_COMPONENT_FROM) {
        return new FshVsComponentFromImpl(node);
      }
      else if (type == VS_CONCEPT_COMPONENT) {
        return new FshVsConceptComponentImpl(node);
      }
      else if (type == VS_FILTER_COMPONENT) {
        return new FshVsFilterComponentImpl(node);
      }
      else if (type == VS_FILTER_ITEM) {
        return new FshVsFilterItemImpl(node);
      }
      else if (type == VS_FILTER_LIST) {
        return new FshVsFilterListImpl(node);
      }
      else if (type == VS_FILTER_OPERATOR) {
        return new FshVsFilterOperatorImpl(node);
      }
      else if (type == VS_FILTER_VALUE) {
        return new FshVsFilterValueImpl(node);
      }
      else if (type == VS_FROM_SYSTEM) {
        return new FshVsFromSystemImpl(node);
      }
      else if (type == VS_FROM_VALUE_SETS) {
        return new FshVsFromValueSetsImpl(node);
      }
      else if (type == VS_METADATA) {
        return new FshVsMetadataImpl(node);
      }
      else if (type == VS_RULE) {
        return new FshVsRuleImpl(node);
      }
      else if (type == XPATH_METADATA) {
        return new FshXpathMetadataImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}

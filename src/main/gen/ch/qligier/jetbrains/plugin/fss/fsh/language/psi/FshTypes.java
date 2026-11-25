// This is a generated file. Not intended for manual editing.
package ch.qligier.jetbrains.plugin.fss.fsh.language.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import ch.qligier.jetbrains.plugin.fss.fsh.language.psi.stubs.FshStubElementTypes;
import ch.qligier.jetbrains.plugin.fss.fsh.language.psi.impl.*;

public interface FshTypes {

  IElementType ADD_CR_ELEMENT_RULE = new FshElementType("ADD_CR_ELEMENT_RULE");
  IElementType ADD_ELEMENT_RULE = new FshElementType("ADD_ELEMENT_RULE");
  IElementType ALIAS_ENTITY = FshStubElementTypes.factory("ALIAS_ENTITY");
  IElementType ALIAS_VALUE = new FshElementType("ALIAS_VALUE");
  IElementType ARGUMENT = new FshElementType("ARGUMENT");
  IElementType ARGUMENT_LIST = new FshElementType("ARGUMENT_LIST");
  IElementType ASSIGNMENT_RULE = new FshElementType("ASSIGNMENT_RULE");
  IElementType BINDING_RULE = new FshElementType("BINDING_RULE");
  IElementType CANONICAL_TYPE = new FshElementType("CANONICAL_TYPE");
  IElementType CANONICAL_VALUE = new FshElementType("CANONICAL_VALUE");
  IElementType CARD_RULE = new FshElementType("CARD_RULE");
  IElementType CARET_VALUE_RULE = new FshElementType("CARET_VALUE_RULE");
  IElementType CHARACTERISTICS_METADATA = new FshElementType("CHARACTERISTICS_METADATA");
  IElementType CODES = new FshElementType("CODES");
  IElementType CODE_SYSTEM_ENTITY = FshStubElementTypes.factory("CODE_SYSTEM_ENTITY");
  IElementType CODE_VALUE = new FshElementType("CODE_VALUE");
  IElementType CONCEPT_RULE = new FshElementType("CONCEPT_RULE");
  IElementType CONTAINS_ITEM = new FshElementType("CONTAINS_ITEM");
  IElementType CONTAINS_RULE = new FshElementType("CONTAINS_RULE");
  IElementType CONTENT_REFERENCE_TARGET = new FshElementType("CONTENT_REFERENCE_TARGET");
  IElementType CONTEXT_ITEM = new FshElementType("CONTEXT_ITEM");
  IElementType CONTEXT_METADATA = new FshElementType("CONTEXT_METADATA");
  IElementType DESCRIPTION_METADATA = new FshElementType("DESCRIPTION_METADATA");
  IElementType ENTITY = new FshElementType("ENTITY");
  IElementType ENTITY_NAME = new FshElementType("ENTITY_NAME");
  IElementType EXPRESSION_METADATA = new FshElementType("EXPRESSION_METADATA");
  IElementType EXTENSION_ENTITY = FshStubElementTypes.factory("EXTENSION_ENTITY");
  IElementType EXTENSION_REF = new FshElementType("EXTENSION_REF");
  IElementType FILTER_OPERATOR = new FshElementType("FILTER_OPERATOR");
  IElementType FILTER_PROPERTY = new FshElementType("FILTER_PROPERTY");
  IElementType FLAG_RULE = new FshElementType("FLAG_RULE");
  IElementType ID_METADATA = new FshElementType("ID_METADATA");
  IElementType INSERT_RULE = new FshElementType("INSERT_RULE");
  IElementType INSTANCE_ENTITY = FshStubElementTypes.factory("INSTANCE_ENTITY");
  IElementType INSTANCE_OF_METADATA = new FshElementType("INSTANCE_OF_METADATA");
  IElementType INVARIANT_ENTITY = FshStubElementTypes.factory("INVARIANT_ENTITY");
  IElementType INVARIANT_REF = new FshElementType("INVARIANT_REF");
  IElementType LOGICAL_ENTITY = FshStubElementTypes.factory("LOGICAL_ENTITY");
  IElementType MAPPING_ENTITY = FshStubElementTypes.factory("MAPPING_ENTITY");
  IElementType MAPPING_RULE = new FshElementType("MAPPING_RULE");
  IElementType METADATA = new FshElementType("METADATA");
  IElementType NAME_REF = new FshElementType("NAME_REF");
  IElementType OBEYS_RULE = new FshElementType("OBEYS_RULE");
  IElementType ONLY_RULE = new FshElementType("ONLY_RULE");
  IElementType PARAMETER = new FshElementType("PARAMETER");
  IElementType PARAMETER_LIST = new FshElementType("PARAMETER_LIST");
  IElementType PARAM_RULE_SET_ENTITY = FshStubElementTypes.factory("PARAM_RULE_SET_ENTITY");
  IElementType PARENT_METADATA = new FshElementType("PARENT_METADATA");
  IElementType PATH = new FshElementType("PATH");
  IElementType PROFILE_ENTITY = FshStubElementTypes.factory("PROFILE_ENTITY");
  IElementType QUANTITY = new FshElementType("QUANTITY");
  IElementType RATIO = new FshElementType("RATIO");
  IElementType RAW_RULE = new FshElementType("RAW_RULE");
  IElementType REFERENCE_TARGET = new FshElementType("REFERENCE_TARGET");
  IElementType REFERENCE_TYPE = new FshElementType("REFERENCE_TYPE");
  IElementType REFERENCE_VALUE = new FshElementType("REFERENCE_VALUE");
  IElementType RESOURCE_ENTITY = FshStubElementTypes.factory("RESOURCE_ENTITY");
  IElementType RULE = new FshElementType("RULE");
  IElementType RULE_SET_ENTITY = FshStubElementTypes.factory("RULE_SET_ENTITY");
  IElementType RULE_SET_REF = new FshElementType("RULE_SET_REF");
  IElementType SEVERITY_METADATA = new FshElementType("SEVERITY_METADATA");
  IElementType SLICE_NAME = new FshElementType("SLICE_NAME");
  IElementType SOURCE_METADATA = new FshElementType("SOURCE_METADATA");
  IElementType SYSTEM_REF = new FshElementType("SYSTEM_REF");
  IElementType TARGET_METADATA = new FshElementType("TARGET_METADATA");
  IElementType TITLE_METADATA = new FshElementType("TITLE_METADATA");
  IElementType TYPE_REF = new FshElementType("TYPE_REF");
  IElementType USAGE_METADATA = new FshElementType("USAGE_METADATA");
  IElementType VALUE = new FshElementType("VALUE");
  IElementType VALUE_SET_ENTITY = FshStubElementTypes.factory("VALUE_SET_ENTITY");
  IElementType VALUE_SET_REF = new FshElementType("VALUE_SET_REF");
  IElementType VS_COMPONENT_FROM = new FshElementType("VS_COMPONENT_FROM");
  IElementType VS_CONCEPT_RULE = new FshElementType("VS_CONCEPT_RULE");
  IElementType VS_FILTER = new FshElementType("VS_FILTER");
  IElementType VS_FILTER_LIST = new FshElementType("VS_FILTER_LIST");
  IElementType VS_FILTER_RULE = new FshElementType("VS_FILTER_RULE");
  IElementType VS_FROM_SYSTEM = new FshElementType("VS_FROM_SYSTEM");
  IElementType VS_FROM_VALUE_SET = new FshElementType("VS_FROM_VALUE_SET");
  IElementType XPATH_METADATA = new FshElementType("XPATH_METADATA");

  IElementType ARG_BRACKETED = new FshTokenType("ARG_BRACKETED");
  IElementType ARG_TEXT = new FshTokenType("ARG_TEXT");
  IElementType ARROW = new FshTokenType("->");
  IElementType BLOCK_COMMENT = new FshTokenType("BLOCK_COMMENT");
  IElementType CARD = new FshTokenType("CARD");
  IElementType CARET_PATH = new FshTokenType("CARET_PATH");
  IElementType CODE = new FshTokenType("CODE");
  IElementType COLON = new FshTokenType(":");
  IElementType COMMA = new FshTokenType(",");
  IElementType DATE_TIME = new FshTokenType("DATE_TIME");
  IElementType EQUAL = new FshTokenType("=");
  IElementType KW_ALIAS = new FshTokenType("Alias");
  IElementType KW_AND = new FshTokenType("and");
  IElementType KW_CANONICAL = new FshTokenType("Canonical");
  IElementType KW_CHARACTERISTICS = new FshTokenType("Characteristics");
  IElementType KW_CODEABLE_REFERENCE = new FshTokenType("CodeableReference");
  IElementType KW_CODES = new FshTokenType("codes");
  IElementType KW_CODESYSTEM = new FshTokenType("CodeSystem");
  IElementType KW_CONTAINS = new FshTokenType("contains");
  IElementType KW_CONTENT_REFERENCE = new FshTokenType("contentReference");
  IElementType KW_CONTEXT = new FshTokenType("Context");
  IElementType KW_D = new FshTokenType("D");
  IElementType KW_DESCRIPTION = new FshTokenType("Description");
  IElementType KW_EXACTLY = new FshTokenType("(exactly)");
  IElementType KW_EXAMPLE = new FshTokenType("(example)");
  IElementType KW_EXCLUDE = new FshTokenType("exclude");
  IElementType KW_EXPRESSION = new FshTokenType("Expression");
  IElementType KW_EXTENSIBLE = new FshTokenType("(extensible)");
  IElementType KW_EXTENSION = new FshTokenType("Extension");
  IElementType KW_FALSE = new FshTokenType("false");
  IElementType KW_FROM = new FshTokenType("from");
  IElementType KW_ID = new FshTokenType("Id");
  IElementType KW_INCLUDE = new FshTokenType("include");
  IElementType KW_INSERT = new FshTokenType("insert");
  IElementType KW_INSTANCE = new FshTokenType("Instance");
  IElementType KW_INSTANCEOF = new FshTokenType("InstanceOf");
  IElementType KW_INVARIANT = new FshTokenType("Invariant");
  IElementType KW_LOGICAL = new FshTokenType("Logical");
  IElementType KW_MAPPING = new FshTokenType("Mapping");
  IElementType KW_MOD = new FshTokenType("?!");
  IElementType KW_MS = new FshTokenType("MS");
  IElementType KW_N = new FshTokenType("N");
  IElementType KW_NAMED = new FshTokenType("named");
  IElementType KW_OBEYS = new FshTokenType("obeys");
  IElementType KW_ONLY = new FshTokenType("only");
  IElementType KW_OR = new FshTokenType("or");
  IElementType KW_PARENT = new FshTokenType("Parent");
  IElementType KW_PREFERRED = new FshTokenType("(preferred)");
  IElementType KW_PROFILE = new FshTokenType("Profile");
  IElementType KW_REFERENCE = new FshTokenType("Reference");
  IElementType KW_REQUIRED = new FshTokenType("(required)");
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
  IElementType KW_USAGE = new FshTokenType("Usage");
  IElementType KW_VALUESET = new FshTokenType("ValueSet");
  IElementType KW_VALUESET_REF = new FshTokenType("valueset");
  IElementType KW_WHERE = new FshTokenType("where");
  IElementType KW_XPATH = new FshTokenType("XPath");
  IElementType LINE_COMMENT = new FshTokenType("LINE_COMMENT");
  IElementType LPAREN = new FshTokenType("(");
  IElementType MULTILINE_STRING = new FshTokenType("MULTILINE_STRING");
  IElementType NUMBER = new FshTokenType("NUMBER");
  IElementType REGEX = new FshTokenType("REGEX");
  IElementType RPAREN = new FshTokenType(")");
  IElementType STAR = new FshTokenType("STAR");
  IElementType STRING = new FshTokenType("STRING");
  IElementType TIME = new FshTokenType("TIME");
  IElementType UNIT = new FshTokenType("UNIT");
  IElementType WORD = new FshTokenType("WORD");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == ADD_CR_ELEMENT_RULE) {
        return new FshAddCrElementRuleImpl(node);
      }
      else if (type == ADD_ELEMENT_RULE) {
        return new FshAddElementRuleImpl(node);
      }
      else if (type == ALIAS_ENTITY) {
        return new FshAliasEntityImpl(node);
      }
      else if (type == ALIAS_VALUE) {
        return new FshAliasValueImpl(node);
      }
      else if (type == ARGUMENT) {
        return new FshArgumentImpl(node);
      }
      else if (type == ARGUMENT_LIST) {
        return new FshArgumentListImpl(node);
      }
      else if (type == ASSIGNMENT_RULE) {
        return new FshAssignmentRuleImpl(node);
      }
      else if (type == BINDING_RULE) {
        return new FshBindingRuleImpl(node);
      }
      else if (type == CANONICAL_TYPE) {
        return new FshCanonicalTypeImpl(node);
      }
      else if (type == CANONICAL_VALUE) {
        return new FshCanonicalValueImpl(node);
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
      else if (type == CODES) {
        return new FshCodesImpl(node);
      }
      else if (type == CODE_SYSTEM_ENTITY) {
        return new FshCodeSystemEntityImpl(node);
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
      else if (type == CONTENT_REFERENCE_TARGET) {
        return new FshContentReferenceTargetImpl(node);
      }
      else if (type == CONTEXT_ITEM) {
        return new FshContextItemImpl(node);
      }
      else if (type == CONTEXT_METADATA) {
        return new FshContextMetadataImpl(node);
      }
      else if (type == DESCRIPTION_METADATA) {
        return new FshDescriptionMetadataImpl(node);
      }
      else if (type == ENTITY) {
        return new FshEntityImpl(node);
      }
      else if (type == ENTITY_NAME) {
        return new FshEntityNameImpl(node);
      }
      else if (type == EXPRESSION_METADATA) {
        return new FshExpressionMetadataImpl(node);
      }
      else if (type == EXTENSION_ENTITY) {
        return new FshExtensionEntityImpl(node);
      }
      else if (type == EXTENSION_REF) {
        return new FshExtensionRefImpl(node);
      }
      else if (type == FILTER_OPERATOR) {
        return new FshFilterOperatorImpl(node);
      }
      else if (type == FILTER_PROPERTY) {
        return new FshFilterPropertyImpl(node);
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
      else if (type == INSTANCE_ENTITY) {
        return new FshInstanceEntityImpl(node);
      }
      else if (type == INSTANCE_OF_METADATA) {
        return new FshInstanceOfMetadataImpl(node);
      }
      else if (type == INVARIANT_ENTITY) {
        return new FshInvariantEntityImpl(node);
      }
      else if (type == INVARIANT_REF) {
        return new FshInvariantRefImpl(node);
      }
      else if (type == LOGICAL_ENTITY) {
        return new FshLogicalEntityImpl(node);
      }
      else if (type == MAPPING_ENTITY) {
        return new FshMappingEntityImpl(node);
      }
      else if (type == MAPPING_RULE) {
        return new FshMappingRuleImpl(node);
      }
      else if (type == METADATA) {
        return new FshMetadataImpl(node);
      }
      else if (type == NAME_REF) {
        return new FshNameRefImpl(node);
      }
      else if (type == OBEYS_RULE) {
        return new FshObeysRuleImpl(node);
      }
      else if (type == ONLY_RULE) {
        return new FshOnlyRuleImpl(node);
      }
      else if (type == PARAMETER) {
        return new FshParameterImpl(node);
      }
      else if (type == PARAMETER_LIST) {
        return new FshParameterListImpl(node);
      }
      else if (type == PARAM_RULE_SET_ENTITY) {
        return new FshParamRuleSetEntityImpl(node);
      }
      else if (type == PARENT_METADATA) {
        return new FshParentMetadataImpl(node);
      }
      else if (type == PATH) {
        return new FshPathImpl(node);
      }
      else if (type == PROFILE_ENTITY) {
        return new FshProfileEntityImpl(node);
      }
      else if (type == QUANTITY) {
        return new FshQuantityImpl(node);
      }
      else if (type == RATIO) {
        return new FshRatioImpl(node);
      }
      else if (type == RAW_RULE) {
        return new FshRawRuleImpl(node);
      }
      else if (type == REFERENCE_TARGET) {
        return new FshReferenceTargetImpl(node);
      }
      else if (type == REFERENCE_TYPE) {
        return new FshReferenceTypeImpl(node);
      }
      else if (type == REFERENCE_VALUE) {
        return new FshReferenceValueImpl(node);
      }
      else if (type == RESOURCE_ENTITY) {
        return new FshResourceEntityImpl(node);
      }
      else if (type == RULE) {
        return new FshRuleImpl(node);
      }
      else if (type == RULE_SET_ENTITY) {
        return new FshRuleSetEntityImpl(node);
      }
      else if (type == RULE_SET_REF) {
        return new FshRuleSetRefImpl(node);
      }
      else if (type == SEVERITY_METADATA) {
        return new FshSeverityMetadataImpl(node);
      }
      else if (type == SLICE_NAME) {
        return new FshSliceNameImpl(node);
      }
      else if (type == SOURCE_METADATA) {
        return new FshSourceMetadataImpl(node);
      }
      else if (type == SYSTEM_REF) {
        return new FshSystemRefImpl(node);
      }
      else if (type == TARGET_METADATA) {
        return new FshTargetMetadataImpl(node);
      }
      else if (type == TITLE_METADATA) {
        return new FshTitleMetadataImpl(node);
      }
      else if (type == TYPE_REF) {
        return new FshTypeRefImpl(node);
      }
      else if (type == USAGE_METADATA) {
        return new FshUsageMetadataImpl(node);
      }
      else if (type == VALUE) {
        return new FshValueImpl(node);
      }
      else if (type == VALUE_SET_ENTITY) {
        return new FshValueSetEntityImpl(node);
      }
      else if (type == VALUE_SET_REF) {
        return new FshValueSetRefImpl(node);
      }
      else if (type == VS_COMPONENT_FROM) {
        return new FshVsComponentFromImpl(node);
      }
      else if (type == VS_CONCEPT_RULE) {
        return new FshVsConceptRuleImpl(node);
      }
      else if (type == VS_FILTER) {
        return new FshVsFilterImpl(node);
      }
      else if (type == VS_FILTER_LIST) {
        return new FshVsFilterListImpl(node);
      }
      else if (type == VS_FILTER_RULE) {
        return new FshVsFilterRuleImpl(node);
      }
      else if (type == VS_FROM_SYSTEM) {
        return new FshVsFromSystemImpl(node);
      }
      else if (type == VS_FROM_VALUE_SET) {
        return new FshVsFromValueSetImpl(node);
      }
      else if (type == XPATH_METADATA) {
        return new FshXpathMetadataImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}

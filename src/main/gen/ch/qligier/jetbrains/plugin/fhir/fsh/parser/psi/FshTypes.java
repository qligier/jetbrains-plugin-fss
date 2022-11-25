// This is a generated file. Not intended for manual editing.
package ch.qligier.jetbrains.plugin.fhir.fsh.parser.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import ch.qligier.jetbrains.plugin.fhir.fsh.parser.psi.impl.*;

public interface FshTypes {

  IElementType ADD_CR_ELEMENT_RULE = new FshElementType("ADD_CR_ELEMENT_RULE");
  IElementType ADD_ELEMENT_RULE = new FshElementType("ADD_ELEMENT_RULE");
  IElementType ALIAS = new FshElementType("ALIAS");
  IElementType ALIAS_VALUE = new FshElementType("ALIAS_VALUE");
  IElementType BRACKET_SUFFIX = new FshElementType("BRACKET_SUFFIX");
  IElementType CANONICAL = new FshElementType("CANONICAL");
  IElementType CARDINALITY = new FshElementType("CARDINALITY");
  IElementType CARD_RULE = new FshElementType("CARD_RULE");
  IElementType CARET_VALUE_RULE = new FshElementType("CARET_VALUE_RULE");
  IElementType CODE = new FshElementType("CODE");
  IElementType CODE_CARET_VALUE_RULE = new FshElementType("CODE_CARET_VALUE_RULE");
  IElementType CODE_INSERT_RULE = new FshElementType("CODE_INSERT_RULE");
  IElementType CODE_SYSTEM = new FshElementType("CODE_SYSTEM");
  IElementType CONCEPT = new FshElementType("CONCEPT");
  IElementType CONTAINS_RULE = new FshElementType("CONTAINS_RULE");
  IElementType CS_RULE = new FshElementType("CS_RULE");
  IElementType DESCRIPTION = new FshElementType("DESCRIPTION");
  IElementType EXPRESSION = new FshElementType("EXPRESSION");
  IElementType EXTENSION = new FshElementType("EXTENSION");
  IElementType FIXED_VALUE_RULE = new FshElementType("FIXED_VALUE_RULE");
  IElementType FLAG_RULE = new FshElementType("FLAG_RULE");
  IElementType ID = new FshElementType("ID");
  IElementType INSERT_RULE = new FshElementType("INSERT_RULE");
  IElementType INSTANCE = new FshElementType("INSTANCE");
  IElementType INSTANCE_OF = new FshElementType("INSTANCE_OF");
  IElementType INSTANCE_RULE = new FshElementType("INSTANCE_RULE");
  IElementType INTEGER = new FshElementType("INTEGER");
  IElementType INVARIANT = new FshElementType("INVARIANT");
  IElementType ITEM = new FshElementType("ITEM");
  IElementType ITEM_IDENTIFIER = new FshElementType("ITEM_IDENTIFIER");
  IElementType LOGICAL = new FshElementType("LOGICAL");
  IElementType LR_RULE = new FshElementType("LR_RULE");
  IElementType MAPPING = new FshElementType("MAPPING");
  IElementType MAPPING_ENTITY_RULE = new FshElementType("MAPPING_ENTITY_RULE");
  IElementType MAPPING_METADATA = new FshElementType("MAPPING_METADATA");
  IElementType MAPPING_RULE = new FshElementType("MAPPING_RULE");
  IElementType NUMBER = new FshElementType("NUMBER");
  IElementType OBEYS_RULE = new FshElementType("OBEYS_RULE");
  IElementType ONLY_RULE = new FshElementType("ONLY_RULE");
  IElementType PARENT = new FshElementType("PARENT");
  IElementType PATH = new FshElementType("PATH");
  IElementType PATH_PART = new FshElementType("PATH_PART");
  IElementType PATH_RULE = new FshElementType("PATH_RULE");
  IElementType PROFILE = new FshElementType("PROFILE");
  IElementType QUANTITY = new FshElementType("QUANTITY");
  IElementType RATIO = new FshElementType("RATIO");
  IElementType REFERENCE_TYPE = new FshElementType("REFERENCE_TYPE");
  IElementType RESOURCE = new FshElementType("RESOURCE");
  IElementType RULE_SET = new FshElementType("RULE_SET");
  IElementType RULE_SET_REFERENCE = new FshElementType("RULE_SET_REFERENCE");
  IElementType RULE_SET_RULE = new FshElementType("RULE_SET_RULE");
  IElementType RULE_START = new FshElementType("RULE_START");
  IElementType SD_RULE = new FshElementType("SD_RULE");
  IElementType SEVERITY = new FshElementType("SEVERITY");
  IElementType SOURCE = new FshElementType("SOURCE");
  IElementType STRENGTH = new FshElementType("STRENGTH");
  IElementType TARGET = new FshElementType("TARGET");
  IElementType TARGET_TYPE = new FshElementType("TARGET_TYPE");
  IElementType TITLE = new FshElementType("TITLE");
  IElementType USAGE = new FshElementType("USAGE");
  IElementType VALUE = new FshElementType("VALUE");
  IElementType VALUE_SET = new FshElementType("VALUE_SET");
  IElementType VALUE_SET_RULE = new FshElementType("VALUE_SET_RULE");
  IElementType VS_COMPONENT = new FshElementType("VS_COMPONENT");
  IElementType VS_COMPONENT_FROM = new FshElementType("VS_COMPONENT_FROM");
  IElementType VS_CONCEPT_COMPONENT = new FshElementType("VS_CONCEPT_COMPONENT");
  IElementType VS_FILTER_COMPONENT = new FshElementType("VS_FILTER_COMPONENT");
  IElementType VS_FILTER_DEFINITION = new FshElementType("VS_FILTER_DEFINITION");
  IElementType VS_FILTER_LIST = new FshElementType("VS_FILTER_LIST");
  IElementType VS_FILTER_OPERATOR = new FshElementType("VS_FILTER_OPERATOR");
  IElementType VS_FILTER_VALUE = new FshElementType("VS_FILTER_VALUE");
  IElementType VS_FROM_SYSTEM = new FshElementType("VS_FROM_SYSTEM");
  IElementType VS_FROM_VALUESET = new FshElementType("VS_FROM_VALUESET");
  IElementType XPATH = new FshElementType("XPATH");

  IElementType ARROW = new FshTokenType("Arrow");
  IElementType CARET = new FshTokenType("Caret");
  IElementType COLON = new FshTokenType("Colon");
  IElementType COMMA = new FshTokenType("Comma");
  IElementType CONCEPTSTRING = new FshTokenType("ConceptString");
  IElementType DATETIME = new FshTokenType("Datetime");
  IElementType DIGIT = new FshTokenType("Digit");
  IElementType DOT = new FshTokenType("Dot");
  IElementType DOUBLEDOT = new FshTokenType("DoubleDot");
  IElementType EQUAL = new FshTokenType("Equal");
  IElementType HASH = new FshTokenType("Hash");
  IElementType IDENTIFIER = new FshTokenType("Identifier");
  IElementType KWALIAS = new FshTokenType("KwAlias");
  IElementType KWAND = new FshTokenType("KwAnd");
  IElementType KWBINDINGSTRENGTH = new FshTokenType("KwBindingStrength");
  IElementType KWBOOLEAN = new FshTokenType("KwBoolean");
  IElementType KWCANONICAL = new FshTokenType("KwCanonical");
  IElementType KWCODEOPERATOR = new FshTokenType("KwCodeOperator");
  IElementType KWCODES = new FshTokenType("KwCodes");
  IElementType KWCODESYSTEM = new FshTokenType("KwCodeSystem");
  IElementType KWCONTAINS = new FshTokenType("KwContains");
  IElementType KWCONTENTREFERENCE = new FshTokenType("KwContentReference");
  IElementType KWDESCRIPTION = new FshTokenType("KwDescription");
  IElementType KWEXACTLY = new FshTokenType("KwExactly");
  IElementType KWEXCLUDE = new FshTokenType("KwExclude");
  IElementType KWEXPRESSION = new FshTokenType("KwExpression");
  IElementType KWEXTENSION = new FshTokenType("KwExtension");
  IElementType KWFLAG = new FshTokenType("KwFlag");
  IElementType KWFROM = new FshTokenType("KwFrom");
  IElementType KWID = new FshTokenType("KwId");
  IElementType KWINCLUDE = new FshTokenType("KwInclude");
  IElementType KWINSERT = new FshTokenType("KwInsert");
  IElementType KWINSTANCE = new FshTokenType("KwInstance");
  IElementType KWINSTANCEOF = new FshTokenType("KwInstanceOf");
  IElementType KWINVARIANT = new FshTokenType("KwInvariant");
  IElementType KWLOGICAL = new FshTokenType("KwLogical");
  IElementType KWMAPPING = new FshTokenType("KwMapping");
  IElementType KWNAMED = new FshTokenType("KwNamed");
  IElementType KWOBEYS = new FshTokenType("KwObeys");
  IElementType KWONLY = new FshTokenType("KwOnly");
  IElementType KWOR = new FshTokenType("KwOr");
  IElementType KWPARENT = new FshTokenType("KwParent");
  IElementType KWPROFILE = new FshTokenType("KwProfile");
  IElementType KWREFERENCE = new FshTokenType("KwReference");
  IElementType KWRESOURCE = new FshTokenType("KwResource");
  IElementType KWRULESET = new FshTokenType("KwRuleSet");
  IElementType KWSEVERITY = new FshTokenType("KwSeverity");
  IElementType KWSOURCE = new FshTokenType("KwSource");
  IElementType KWSYSTEM = new FshTokenType("KwSystem");
  IElementType KWTARGET = new FshTokenType("KwTarget");
  IElementType KWTITLE = new FshTokenType("KwTitle");
  IElementType KWUSAGE = new FshTokenType("KwUsage");
  IElementType KWVALUESET = new FshTokenType("KwValueSet");
  IElementType KWVALUESETREF = new FshTokenType("KwValueSetRef");
  IElementType KWWHERE = new FshTokenType("KwWhere");
  IElementType KWXPATH = new FshTokenType("KwXPath");
  IElementType LEFTBRACKET = new FshTokenType("LeftBracket");
  IElementType LEFTPAREN = new FshTokenType("LeftParen");
  IElementType MULTILINESTRING = new FshTokenType("MultilineString");
  IElementType PIPE = new FshTokenType("Pipe");
  IElementType PLUS = new FshTokenType("Plus");
  IElementType REGEX = new FshTokenType("Regex");
  IElementType RIGHTBRACKET = new FshTokenType("RightBracket");
  IElementType RIGHTPAREN = new FshTokenType("RightParen");
  IElementType STAR = new FshTokenType("Star");
  IElementType STRING = new FshTokenType("String");
  IElementType TIME = new FshTokenType("Time");
  IElementType UNIT = new FshTokenType("Unit");
  IElementType URL = new FshTokenType("Url");
  IElementType URN = new FshTokenType("Urn");
  IElementType WHITESPACE = new FshTokenType("WhiteSpace");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == ADD_CR_ELEMENT_RULE) {
        return new FshAddCRElementRuleImpl(node);
      }
      else if (type == ADD_ELEMENT_RULE) {
        return new FshAddElementRuleImpl(node);
      }
      else if (type == ALIAS) {
        return new FshAliasImpl(node);
      }
      else if (type == ALIAS_VALUE) {
        return new FshAliasValueImpl(node);
      }
      else if (type == BRACKET_SUFFIX) {
        return new FshBracketSuffixImpl(node);
      }
      else if (type == CANONICAL) {
        return new FshCanonicalImpl(node);
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
      else if (type == CODE) {
        return new FshCodeImpl(node);
      }
      else if (type == CODE_CARET_VALUE_RULE) {
        return new FshCodeCaretValueRuleImpl(node);
      }
      else if (type == CODE_INSERT_RULE) {
        return new FshCodeInsertRuleImpl(node);
      }
      else if (type == CODE_SYSTEM) {
        return new FshCodeSystemImpl(node);
      }
      else if (type == CONCEPT) {
        return new FshConceptImpl(node);
      }
      else if (type == CONTAINS_RULE) {
        return new FshContainsRuleImpl(node);
      }
      else if (type == CS_RULE) {
        return new FshCsRuleImpl(node);
      }
      else if (type == DESCRIPTION) {
        return new FshDescriptionImpl(node);
      }
      else if (type == EXPRESSION) {
        return new FshExpressionImpl(node);
      }
      else if (type == EXTENSION) {
        return new FshExtensionImpl(node);
      }
      else if (type == FIXED_VALUE_RULE) {
        return new FshFixedValueRuleImpl(node);
      }
      else if (type == FLAG_RULE) {
        return new FshFlagRuleImpl(node);
      }
      else if (type == ID) {
        return new FshIdImpl(node);
      }
      else if (type == INSERT_RULE) {
        return new FshInsertRuleImpl(node);
      }
      else if (type == INSTANCE) {
        return new FshInstanceImpl(node);
      }
      else if (type == INSTANCE_OF) {
        return new FshInstanceOfImpl(node);
      }
      else if (type == INSTANCE_RULE) {
        return new FshInstanceRuleImpl(node);
      }
      else if (type == INTEGER) {
        return new FshIntegerImpl(node);
      }
      else if (type == INVARIANT) {
        return new FshInvariantImpl(node);
      }
      else if (type == ITEM) {
        return new FshItemImpl(node);
      }
      else if (type == ITEM_IDENTIFIER) {
        return new FshItemIdentifierImpl(node);
      }
      else if (type == LOGICAL) {
        return new FshLogicalImpl(node);
      }
      else if (type == LR_RULE) {
        return new FshLrRuleImpl(node);
      }
      else if (type == MAPPING) {
        return new FshMappingImpl(node);
      }
      else if (type == MAPPING_ENTITY_RULE) {
        return new FshMappingEntityRuleImpl(node);
      }
      else if (type == MAPPING_METADATA) {
        return new FshMappingMetadataImpl(node);
      }
      else if (type == MAPPING_RULE) {
        return new FshMappingRuleImpl(node);
      }
      else if (type == NUMBER) {
        return new FshNumberImpl(node);
      }
      else if (type == OBEYS_RULE) {
        return new FshObeysRuleImpl(node);
      }
      else if (type == ONLY_RULE) {
        return new FshOnlyRuleImpl(node);
      }
      else if (type == PARENT) {
        return new FshParentImpl(node);
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
      else if (type == QUANTITY) {
        return new FshQuantityImpl(node);
      }
      else if (type == RATIO) {
        return new FshRatioImpl(node);
      }
      else if (type == REFERENCE_TYPE) {
        return new FshReferenceTypeImpl(node);
      }
      else if (type == RESOURCE) {
        return new FshResourceImpl(node);
      }
      else if (type == RULE_SET) {
        return new FshRuleSetImpl(node);
      }
      else if (type == RULE_SET_REFERENCE) {
        return new FshRuleSetReferenceImpl(node);
      }
      else if (type == RULE_SET_RULE) {
        return new FshRuleSetRuleImpl(node);
      }
      else if (type == RULE_START) {
        return new FshRuleStartImpl(node);
      }
      else if (type == SD_RULE) {
        return new FshSdRuleImpl(node);
      }
      else if (type == SEVERITY) {
        return new FshSeverityImpl(node);
      }
      else if (type == SOURCE) {
        return new FshSourceImpl(node);
      }
      else if (type == STRENGTH) {
        return new FshStrengthImpl(node);
      }
      else if (type == TARGET) {
        return new FshTargetImpl(node);
      }
      else if (type == TARGET_TYPE) {
        return new FshTargetTypeImpl(node);
      }
      else if (type == TITLE) {
        return new FshTitleImpl(node);
      }
      else if (type == USAGE) {
        return new FshUsageImpl(node);
      }
      else if (type == VALUE) {
        return new FshValueImpl(node);
      }
      else if (type == VALUE_SET) {
        return new FshValueSetImpl(node);
      }
      else if (type == VALUE_SET_RULE) {
        return new FshValueSetRuleImpl(node);
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
      else if (type == VS_FILTER_DEFINITION) {
        return new FshVsFilterDefinitionImpl(node);
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
      else if (type == VS_FROM_VALUESET) {
        return new FshVsFromValuesetImpl(node);
      }
      else if (type == XPATH) {
        return new FshXpathImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}

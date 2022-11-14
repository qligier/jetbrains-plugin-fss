// Generated from java-escape by ANTLR 4.11.1
package ch.qligier.jetbrains.plugin.fhir.fsh.grammar;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class FshParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.11.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		KW_ALIAS=1, KW_PROFILE=2, KW_EXTENSION=3, KW_INSTANCE=4, KW_INSTANCEOF=5, 
		KW_INVARIANT=6, KW_VALUESET=7, KW_CODESYSTEM=8, KW_RULESET=9, KW_MAPPING=10, 
		KW_LOGICAL=11, KW_RESOURCE=12, KW_PARENT=13, KW_ID=14, KW_TITLE=15, KW_DESCRIPTION=16, 
		KW_EXPRESSION=17, KW_XPATH=18, KW_SEVERITY=19, KW_USAGE=20, KW_SOURCE=21, 
		KW_TARGET=22, KW_MOD=23, KW_MS=24, KW_SU=25, KW_TU=26, KW_NORMATIVE=27, 
		KW_DRAFT=28, KW_FROM=29, KW_EXAMPLE=30, KW_PREFERRED=31, KW_EXTENSIBLE=32, 
		KW_REQUIRED=33, KW_CONTAINS=34, KW_NAMED=35, KW_AND=36, KW_ONLY=37, KW_OR=38, 
		KW_OBEYS=39, KW_TRUE=40, KW_FALSE=41, KW_INCLUDE=42, KW_EXCLUDE=43, KW_CODES=44, 
		KW_WHERE=45, KW_VSREFERENCE=46, KW_SYSTEM=47, KW_EXACTLY=48, KW_INSERT=49, 
		KW_CONTENTREFERENCE=50, KW_IS_A=51, KW_REFERENCE=52, KW_CANONICAL=53, 
		COLON=54, EQUAL=55, PLUS=56, MINUS=57, COMMA=58, ARROW=59, LEFT_PAREN=60, 
		RIGHT_PAREN=61, LEFT_BRACKET=62, RIGHT_BRACKET=63, TRIPLE_QUOTE=64, QUOTE=65, 
		CARET=66, HASH=67, TRIPLE_DOT=68, DOUBLE_DOT=69, DOT=70, SIMPLE_QUOTE=71, 
		PIPE=72, SLASH=73, LINE_COMMENT_PREFIX=74, BLOCK_COMMENT_PREFIX=75, BLOCK_COMMENT_SUFFIX=76, 
		STAR=77, DOLLAR=78, Z=79, DIGIT=80, IDENTIFIER=81, URL=82, URN=83, EXTEND_STRING=84, 
		STRING=85, UNIT=86, CONCEPT_STRING=87, DATETIME=88, TIME=89, LINE_COMMENT=90, 
		COMMENT=91, WHITESPACES=92, NEWLINE=93;
	public static final int
		RULE_doc = 0, RULE_alias = 1, RULE_aliasName = 2, RULE_aliasValue = 3, 
		RULE_ruleStart = 4, RULE_path = 5, RULE_pathPart = 6, RULE_simplePathPart = 7, 
		RULE_bracketPathPart = 8, RULE_bracketSuffix = 9, RULE_cardinality = 10, 
		RULE_number = 11, RULE_integer = 12, RULE_unit = 13, RULE_code = 14, RULE_dateTime = 15, 
		RULE_time = 16;
	private static String[] makeRuleNames() {
		return new String[] {
			"doc", "alias", "aliasName", "aliasValue", "ruleStart", "path", "pathPart", 
			"simplePathPart", "bracketPathPart", "bracketSuffix", "cardinality", 
			"number", "integer", "unit", "code", "dateTime", "time"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'Alias'", "'Profile'", "'Extension'", "'Instance'", "'InstanceOf'", 
			"'Invariant'", "'ValueSet'", "'CodeSystem'", "'RuleSet'", "'Mapping'", 
			"'Logical'", "'Resource'", "'Parent'", "'Id'", "'Title'", "'Description'", 
			"'Expression'", "'XPath'", "'Severity'", "'Usage'", "'Source'", "'Target'", 
			"'?!'", "'MS'", "'SU'", "'TU'", "'N'", "'D'", "'from'", "'example'", 
			"'preferred'", "'extensible'", "'required'", "'contains'", "'named'", 
			"'and'", "'only'", "'or'", "'obeys'", "'true'", "'false'", "'include'", 
			"'exclude'", "'codes'", "'where'", "'valueset'", "'system'", "'exactly'", 
			"'insert'", "'contentReference'", "'is-a'", "'Reference'", "'Canonical'", 
			"':'", "'='", "'+'", "'-'", "','", "'->'", "'('", "')'", "'['", "']'", 
			"'\"\"\"'", "'\"'", "'^'", "'#'", "'...'", "'..'", "'.'", "'''", "'|'", 
			"'/'", "'//'", "'/*'", "'*/'", "'*'", "'$'", "'Z'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "KW_ALIAS", "KW_PROFILE", "KW_EXTENSION", "KW_INSTANCE", "KW_INSTANCEOF", 
			"KW_INVARIANT", "KW_VALUESET", "KW_CODESYSTEM", "KW_RULESET", "KW_MAPPING", 
			"KW_LOGICAL", "KW_RESOURCE", "KW_PARENT", "KW_ID", "KW_TITLE", "KW_DESCRIPTION", 
			"KW_EXPRESSION", "KW_XPATH", "KW_SEVERITY", "KW_USAGE", "KW_SOURCE", 
			"KW_TARGET", "KW_MOD", "KW_MS", "KW_SU", "KW_TU", "KW_NORMATIVE", "KW_DRAFT", 
			"KW_FROM", "KW_EXAMPLE", "KW_PREFERRED", "KW_EXTENSIBLE", "KW_REQUIRED", 
			"KW_CONTAINS", "KW_NAMED", "KW_AND", "KW_ONLY", "KW_OR", "KW_OBEYS", 
			"KW_TRUE", "KW_FALSE", "KW_INCLUDE", "KW_EXCLUDE", "KW_CODES", "KW_WHERE", 
			"KW_VSREFERENCE", "KW_SYSTEM", "KW_EXACTLY", "KW_INSERT", "KW_CONTENTREFERENCE", 
			"KW_IS_A", "KW_REFERENCE", "KW_CANONICAL", "COLON", "EQUAL", "PLUS", 
			"MINUS", "COMMA", "ARROW", "LEFT_PAREN", "RIGHT_PAREN", "LEFT_BRACKET", 
			"RIGHT_BRACKET", "TRIPLE_QUOTE", "QUOTE", "CARET", "HASH", "TRIPLE_DOT", 
			"DOUBLE_DOT", "DOT", "SIMPLE_QUOTE", "PIPE", "SLASH", "LINE_COMMENT_PREFIX", 
			"BLOCK_COMMENT_PREFIX", "BLOCK_COMMENT_SUFFIX", "STAR", "DOLLAR", "Z", 
			"DIGIT", "IDENTIFIER", "URL", "URN", "EXTEND_STRING", "STRING", "UNIT", 
			"CONCEPT_STRING", "DATETIME", "TIME", "LINE_COMMENT", "COMMENT", "WHITESPACES", 
			"NEWLINE"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "java-escape"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public FshParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DocContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(FshParser.EOF, 0); }
		public List<AliasContext> alias() {
			return getRuleContexts(AliasContext.class);
		}
		public AliasContext alias(int i) {
			return getRuleContext(AliasContext.class,i);
		}
		public DocContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_doc; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FshListener ) ((FshListener)listener).enterDoc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FshListener ) ((FshListener)listener).exitDoc(this);
		}
	}

	public final DocContext doc() throws RecognitionException {
		DocContext _localctx = new DocContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_doc);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(37);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==KW_ALIAS) {
				{
				{
				setState(34);
				alias();
				}
				}
				setState(39);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(40);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AliasContext extends ParserRuleContext {
		public TerminalNode KW_ALIAS() { return getToken(FshParser.KW_ALIAS, 0); }
		public TerminalNode COLON() { return getToken(FshParser.COLON, 0); }
		public AliasNameContext aliasName() {
			return getRuleContext(AliasNameContext.class,0);
		}
		public TerminalNode EQUAL() { return getToken(FshParser.EQUAL, 0); }
		public AliasValueContext aliasValue() {
			return getRuleContext(AliasValueContext.class,0);
		}
		public AliasContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_alias; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FshListener ) ((FshListener)listener).enterAlias(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FshListener ) ((FshListener)listener).exitAlias(this);
		}
	}

	public final AliasContext alias() throws RecognitionException {
		AliasContext _localctx = new AliasContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_alias);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(42);
			match(KW_ALIAS);
			setState(43);
			match(COLON);
			setState(44);
			aliasName();
			setState(45);
			match(EQUAL);
			setState(46);
			aliasValue();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AliasNameContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(FshParser.IDENTIFIER, 0); }
		public AliasNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aliasName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FshListener ) ((FshListener)listener).enterAliasName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FshListener ) ((FshListener)listener).exitAliasName(this);
		}
	}

	public final AliasNameContext aliasName() throws RecognitionException {
		AliasNameContext _localctx = new AliasNameContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_aliasName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(48);
			match(IDENTIFIER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AliasValueContext extends ParserRuleContext {
		public TerminalNode URN() { return getToken(FshParser.URN, 0); }
		public TerminalNode URL() { return getToken(FshParser.URL, 0); }
		public AliasValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aliasValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FshListener ) ((FshListener)listener).enterAliasValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FshListener ) ((FshListener)listener).exitAliasValue(this);
		}
	}

	public final AliasValueContext aliasValue() throws RecognitionException {
		AliasValueContext _localctx = new AliasValueContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_aliasValue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			_la = _input.LA(1);
			if ( !(_la==URL || _la==URN) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RuleStartContext extends ParserRuleContext {
		public TerminalNode STAR() { return getToken(FshParser.STAR, 0); }
		public TerminalNode WHITESPACES() { return getToken(FshParser.WHITESPACES, 0); }
		public RuleStartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ruleStart; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FshListener ) ((FshListener)listener).enterRuleStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FshListener ) ((FshListener)listener).exitRuleStart(this);
		}
	}

	public final RuleStartContext ruleStart() throws RecognitionException {
		RuleStartContext _localctx = new RuleStartContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_ruleStart);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(53);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WHITESPACES) {
				{
				setState(52);
				match(WHITESPACES);
				}
			}

			setState(55);
			match(STAR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PathContext extends ParserRuleContext {
		public List<TerminalNode> DOT() { return getTokens(FshParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(FshParser.DOT, i);
		}
		public List<PathPartContext> pathPart() {
			return getRuleContexts(PathPartContext.class);
		}
		public PathPartContext pathPart(int i) {
			return getRuleContext(PathPartContext.class,i);
		}
		public PathContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_path; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FshListener ) ((FshListener)listener).enterPath(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FshListener ) ((FshListener)listener).exitPath(this);
		}
	}

	public final PathContext path() throws RecognitionException {
		PathContext _localctx = new PathContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_path);
		int _la;
		try {
			setState(66);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DOT:
				enterOuterAlt(_localctx, 1);
				{
				setState(57);
				match(DOT);
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(58);
				pathPart();
				setState(63);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==DOT) {
					{
					{
					setState(59);
					match(DOT);
					setState(60);
					pathPart();
					}
					}
					setState(65);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PathPartContext extends ParserRuleContext {
		public SimplePathPartContext simplePathPart() {
			return getRuleContext(SimplePathPartContext.class,0);
		}
		public BracketPathPartContext bracketPathPart() {
			return getRuleContext(BracketPathPartContext.class,0);
		}
		public PathPartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pathPart; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FshListener ) ((FshListener)listener).enterPathPart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FshListener ) ((FshListener)listener).exitPathPart(this);
		}
	}

	public final PathPartContext pathPart() throws RecognitionException {
		PathPartContext _localctx = new PathPartContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_pathPart);
		try {
			setState(70);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(68);
				simplePathPart();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(69);
				bracketPathPart();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SimplePathPartContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(FshParser.IDENTIFIER, 0); }
		public SimplePathPartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simplePathPart; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FshListener ) ((FshListener)listener).enterSimplePathPart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FshListener ) ((FshListener)listener).exitSimplePathPart(this);
		}
	}

	public final SimplePathPartContext simplePathPart() throws RecognitionException {
		SimplePathPartContext _localctx = new SimplePathPartContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_simplePathPart);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(72);
			match(IDENTIFIER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BracketPathPartContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(FshParser.IDENTIFIER, 0); }
		public List<BracketSuffixContext> bracketSuffix() {
			return getRuleContexts(BracketSuffixContext.class);
		}
		public BracketSuffixContext bracketSuffix(int i) {
			return getRuleContext(BracketSuffixContext.class,i);
		}
		public BracketPathPartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bracketPathPart; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FshListener ) ((FshListener)listener).enterBracketPathPart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FshListener ) ((FshListener)listener).exitBracketPathPart(this);
		}
	}

	public final BracketPathPartContext bracketPathPart() throws RecognitionException {
		BracketPathPartContext _localctx = new BracketPathPartContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_bracketPathPart);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(74);
			match(IDENTIFIER);
			setState(76); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(75);
				bracketSuffix();
				}
				}
				setState(78); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==LEFT_BRACKET );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BracketSuffixContext extends ParserRuleContext {
		public TerminalNode LEFT_BRACKET() { return getToken(FshParser.LEFT_BRACKET, 0); }
		public TerminalNode RIGHT_BRACKET() { return getToken(FshParser.RIGHT_BRACKET, 0); }
		public TerminalNode IDENTIFIER() { return getToken(FshParser.IDENTIFIER, 0); }
		public TerminalNode URL() { return getToken(FshParser.URL, 0); }
		public IntegerContext integer() {
			return getRuleContext(IntegerContext.class,0);
		}
		public TerminalNode EQUAL() { return getToken(FshParser.EQUAL, 0); }
		public TerminalNode PLUS() { return getToken(FshParser.PLUS, 0); }
		public BracketSuffixContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bracketSuffix; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FshListener ) ((FshListener)listener).enterBracketSuffix(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FshListener ) ((FshListener)listener).exitBracketSuffix(this);
		}
	}

	public final BracketSuffixContext bracketSuffix() throws RecognitionException {
		BracketSuffixContext _localctx = new BracketSuffixContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_bracketSuffix);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(80);
			match(LEFT_BRACKET);
			setState(86);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				{
				setState(81);
				match(IDENTIFIER);
				}
				break;
			case URL:
				{
				setState(82);
				match(URL);
				}
				break;
			case DIGIT:
				{
				setState(83);
				integer();
				}
				break;
			case EQUAL:
				{
				setState(84);
				match(EQUAL);
				}
				break;
			case PLUS:
				{
				setState(85);
				match(PLUS);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(88);
			match(RIGHT_BRACKET);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CardinalityContext extends ParserRuleContext {
		public TerminalNode DOUBLE_DOT() { return getToken(FshParser.DOUBLE_DOT, 0); }
		public List<IntegerContext> integer() {
			return getRuleContexts(IntegerContext.class);
		}
		public IntegerContext integer(int i) {
			return getRuleContext(IntegerContext.class,i);
		}
		public TerminalNode STAR() { return getToken(FshParser.STAR, 0); }
		public CardinalityContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cardinality; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FshListener ) ((FshListener)listener).enterCardinality(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FshListener ) ((FshListener)listener).exitCardinality(this);
		}
	}

	public final CardinalityContext cardinality() throws RecognitionException {
		CardinalityContext _localctx = new CardinalityContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_cardinality);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(91);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DIGIT) {
				{
				setState(90);
				integer();
				}
			}

			setState(93);
			match(DOUBLE_DOT);
			setState(96);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DIGIT:
				{
				setState(94);
				integer();
				}
				break;
			case STAR:
				{
				setState(95);
				match(STAR);
				}
				break;
			case EOF:
				break;
			default:
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class NumberContext extends ParserRuleContext {
		public List<IntegerContext> integer() {
			return getRuleContexts(IntegerContext.class);
		}
		public IntegerContext integer(int i) {
			return getRuleContext(IntegerContext.class,i);
		}
		public TerminalNode DOT() { return getToken(FshParser.DOT, 0); }
		public TerminalNode PLUS() { return getToken(FshParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(FshParser.MINUS, 0); }
		public NumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_number; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FshListener ) ((FshListener)listener).enterNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FshListener ) ((FshListener)listener).exitNumber(this);
		}
	}

	public final NumberContext number() throws RecognitionException {
		NumberContext _localctx = new NumberContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_number);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(99);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PLUS || _la==MINUS) {
				{
				setState(98);
				_la = _input.LA(1);
				if ( !(_la==PLUS || _la==MINUS) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			setState(101);
			integer();
			setState(104);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DOT) {
				{
				setState(102);
				match(DOT);
				setState(103);
				integer();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IntegerContext extends ParserRuleContext {
		public List<TerminalNode> DIGIT() { return getTokens(FshParser.DIGIT); }
		public TerminalNode DIGIT(int i) {
			return getToken(FshParser.DIGIT, i);
		}
		public IntegerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_integer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FshListener ) ((FshListener)listener).enterInteger(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FshListener ) ((FshListener)listener).exitInteger(this);
		}
	}

	public final IntegerContext integer() throws RecognitionException {
		IntegerContext _localctx = new IntegerContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_integer);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(107); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(106);
				match(DIGIT);
				}
				}
				setState(109); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==DIGIT );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class UnitContext extends ParserRuleContext {
		public TerminalNode UNIT() { return getToken(FshParser.UNIT, 0); }
		public UnitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FshListener ) ((FshListener)listener).enterUnit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FshListener ) ((FshListener)listener).exitUnit(this);
		}
	}

	public final UnitContext unit() throws RecognitionException {
		UnitContext _localctx = new UnitContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_unit);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(111);
			match(UNIT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CodeContext extends ParserRuleContext {
		public TerminalNode HASH() { return getToken(FshParser.HASH, 0); }
		public List<TerminalNode> IDENTIFIER() { return getTokens(FshParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(FshParser.IDENTIFIER, i);
		}
		public TerminalNode CONCEPT_STRING() { return getToken(FshParser.CONCEPT_STRING, 0); }
		public TerminalNode URL() { return getToken(FshParser.URL, 0); }
		public TerminalNode URN() { return getToken(FshParser.URN, 0); }
		public TerminalNode DOLLAR() { return getToken(FshParser.DOLLAR, 0); }
		public CodeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_code; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FshListener ) ((FshListener)listener).enterCode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FshListener ) ((FshListener)listener).exitCode(this);
		}
	}

	public final CodeContext code() throws RecognitionException {
		CodeContext _localctx = new CodeContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_code);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(119);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DOLLAR:
			case IDENTIFIER:
				{
				setState(114);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==DOLLAR) {
					{
					setState(113);
					match(DOLLAR);
					}
				}

				setState(116);
				match(IDENTIFIER);
				}
				break;
			case URL:
				{
				setState(117);
				match(URL);
				}
				break;
			case URN:
				{
				setState(118);
				match(URN);
				}
				break;
			case HASH:
				break;
			default:
				break;
			}
			setState(121);
			match(HASH);
			setState(122);
			_la = _input.LA(1);
			if ( !(_la==IDENTIFIER || _la==CONCEPT_STRING) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DateTimeContext extends ParserRuleContext {
		public TerminalNode DATETIME() { return getToken(FshParser.DATETIME, 0); }
		public DateTimeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dateTime; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FshListener ) ((FshListener)listener).enterDateTime(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FshListener ) ((FshListener)listener).exitDateTime(this);
		}
	}

	public final DateTimeContext dateTime() throws RecognitionException {
		DateTimeContext _localctx = new DateTimeContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_dateTime);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(124);
			match(DATETIME);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TimeContext extends ParserRuleContext {
		public TerminalNode TIME() { return getToken(FshParser.TIME, 0); }
		public TimeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_time; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FshListener ) ((FshListener)listener).enterTime(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FshListener ) ((FshListener)listener).exitTime(this);
		}
	}

	public final TimeContext time() throws RecognitionException {
		TimeContext _localctx = new TimeContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_time);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(126);
			match(TIME);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001]\u0081\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0001\u0000\u0005\u0000$\b\u0000\n\u0000\f\u0000"+
		"\'\t\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0003"+
		"\u0001\u0003\u0001\u0004\u0003\u00046\b\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0005\u0005>\b\u0005"+
		"\n\u0005\f\u0005A\t\u0005\u0003\u0005C\b\u0005\u0001\u0006\u0001\u0006"+
		"\u0003\u0006G\b\u0006\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0004\b"+
		"M\b\b\u000b\b\f\bN\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0003"+
		"\tW\b\t\u0001\t\u0001\t\u0001\n\u0003\n\\\b\n\u0001\n\u0001\n\u0001\n"+
		"\u0003\na\b\n\u0001\u000b\u0003\u000bd\b\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0003\u000bi\b\u000b\u0001\f\u0004\fl\b\f\u000b\f\f\fm\u0001"+
		"\r\u0001\r\u0001\u000e\u0003\u000es\b\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0003\u000ex\b\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0000\u0000\u0011"+
		"\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a"+
		"\u001c\u001e \u0000\u0003\u0001\u0000RS\u0001\u000089\u0002\u0000QQWW"+
		"\u0083\u0000%\u0001\u0000\u0000\u0000\u0002*\u0001\u0000\u0000\u0000\u0004"+
		"0\u0001\u0000\u0000\u0000\u00062\u0001\u0000\u0000\u0000\b5\u0001\u0000"+
		"\u0000\u0000\nB\u0001\u0000\u0000\u0000\fF\u0001\u0000\u0000\u0000\u000e"+
		"H\u0001\u0000\u0000\u0000\u0010J\u0001\u0000\u0000\u0000\u0012P\u0001"+
		"\u0000\u0000\u0000\u0014[\u0001\u0000\u0000\u0000\u0016c\u0001\u0000\u0000"+
		"\u0000\u0018k\u0001\u0000\u0000\u0000\u001ao\u0001\u0000\u0000\u0000\u001c"+
		"w\u0001\u0000\u0000\u0000\u001e|\u0001\u0000\u0000\u0000 ~\u0001\u0000"+
		"\u0000\u0000\"$\u0003\u0002\u0001\u0000#\"\u0001\u0000\u0000\u0000$\'"+
		"\u0001\u0000\u0000\u0000%#\u0001\u0000\u0000\u0000%&\u0001\u0000\u0000"+
		"\u0000&(\u0001\u0000\u0000\u0000\'%\u0001\u0000\u0000\u0000()\u0005\u0000"+
		"\u0000\u0001)\u0001\u0001\u0000\u0000\u0000*+\u0005\u0001\u0000\u0000"+
		"+,\u00056\u0000\u0000,-\u0003\u0004\u0002\u0000-.\u00057\u0000\u0000."+
		"/\u0003\u0006\u0003\u0000/\u0003\u0001\u0000\u0000\u000001\u0005Q\u0000"+
		"\u00001\u0005\u0001\u0000\u0000\u000023\u0007\u0000\u0000\u00003\u0007"+
		"\u0001\u0000\u0000\u000046\u0005\\\u0000\u000054\u0001\u0000\u0000\u0000"+
		"56\u0001\u0000\u0000\u000067\u0001\u0000\u0000\u000078\u0005M\u0000\u0000"+
		"8\t\u0001\u0000\u0000\u00009C\u0005F\u0000\u0000:?\u0003\f\u0006\u0000"+
		";<\u0005F\u0000\u0000<>\u0003\f\u0006\u0000=;\u0001\u0000\u0000\u0000"+
		">A\u0001\u0000\u0000\u0000?=\u0001\u0000\u0000\u0000?@\u0001\u0000\u0000"+
		"\u0000@C\u0001\u0000\u0000\u0000A?\u0001\u0000\u0000\u0000B9\u0001\u0000"+
		"\u0000\u0000B:\u0001\u0000\u0000\u0000C\u000b\u0001\u0000\u0000\u0000"+
		"DG\u0003\u000e\u0007\u0000EG\u0003\u0010\b\u0000FD\u0001\u0000\u0000\u0000"+
		"FE\u0001\u0000\u0000\u0000G\r\u0001\u0000\u0000\u0000HI\u0005Q\u0000\u0000"+
		"I\u000f\u0001\u0000\u0000\u0000JL\u0005Q\u0000\u0000KM\u0003\u0012\t\u0000"+
		"LK\u0001\u0000\u0000\u0000MN\u0001\u0000\u0000\u0000NL\u0001\u0000\u0000"+
		"\u0000NO\u0001\u0000\u0000\u0000O\u0011\u0001\u0000\u0000\u0000PV\u0005"+
		">\u0000\u0000QW\u0005Q\u0000\u0000RW\u0005R\u0000\u0000SW\u0003\u0018"+
		"\f\u0000TW\u00057\u0000\u0000UW\u00058\u0000\u0000VQ\u0001\u0000\u0000"+
		"\u0000VR\u0001\u0000\u0000\u0000VS\u0001\u0000\u0000\u0000VT\u0001\u0000"+
		"\u0000\u0000VU\u0001\u0000\u0000\u0000WX\u0001\u0000\u0000\u0000XY\u0005"+
		"?\u0000\u0000Y\u0013\u0001\u0000\u0000\u0000Z\\\u0003\u0018\f\u0000[Z"+
		"\u0001\u0000\u0000\u0000[\\\u0001\u0000\u0000\u0000\\]\u0001\u0000\u0000"+
		"\u0000]`\u0005E\u0000\u0000^a\u0003\u0018\f\u0000_a\u0005M\u0000\u0000"+
		"`^\u0001\u0000\u0000\u0000`_\u0001\u0000\u0000\u0000`a\u0001\u0000\u0000"+
		"\u0000a\u0015\u0001\u0000\u0000\u0000bd\u0007\u0001\u0000\u0000cb\u0001"+
		"\u0000\u0000\u0000cd\u0001\u0000\u0000\u0000de\u0001\u0000\u0000\u0000"+
		"eh\u0003\u0018\f\u0000fg\u0005F\u0000\u0000gi\u0003\u0018\f\u0000hf\u0001"+
		"\u0000\u0000\u0000hi\u0001\u0000\u0000\u0000i\u0017\u0001\u0000\u0000"+
		"\u0000jl\u0005P\u0000\u0000kj\u0001\u0000\u0000\u0000lm\u0001\u0000\u0000"+
		"\u0000mk\u0001\u0000\u0000\u0000mn\u0001\u0000\u0000\u0000n\u0019\u0001"+
		"\u0000\u0000\u0000op\u0005V\u0000\u0000p\u001b\u0001\u0000\u0000\u0000"+
		"qs\u0005N\u0000\u0000rq\u0001\u0000\u0000\u0000rs\u0001\u0000\u0000\u0000"+
		"st\u0001\u0000\u0000\u0000tx\u0005Q\u0000\u0000ux\u0005R\u0000\u0000v"+
		"x\u0005S\u0000\u0000wr\u0001\u0000\u0000\u0000wu\u0001\u0000\u0000\u0000"+
		"wv\u0001\u0000\u0000\u0000wx\u0001\u0000\u0000\u0000xy\u0001\u0000\u0000"+
		"\u0000yz\u0005C\u0000\u0000z{\u0007\u0002\u0000\u0000{\u001d\u0001\u0000"+
		"\u0000\u0000|}\u0005X\u0000\u0000}\u001f\u0001\u0000\u0000\u0000~\u007f"+
		"\u0005Y\u0000\u0000\u007f!\u0001\u0000\u0000\u0000\u000e%5?BFNV[`chmr"+
		"w";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
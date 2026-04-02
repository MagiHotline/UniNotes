// Generated from Es1.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class Es1Parser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22;
	public static final int
		RULE_main = 0, RULE_dig = 1, RULE_seq = 2;
	private static String[] makeRuleNames() {
		return new String[] {
			"main", "dig", "seq"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", "'0, '", "'1, '", "'2, '", "'3, '", "'4, '", "'5, '", 
			"'6, '", "'7, '", "'8, '", "'9, '", "'0'", "'1'", "'2'", "'3'", "'4'", 
			"'5'", "'6'", "'7'", "'8'", "'9'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
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
	public String getGrammarFileName() { return "Es1.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public Es1Parser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MainContext extends ParserRuleContext {
		public DigContext dig() {
			return getRuleContext(DigContext.class,0);
		}
		public TerminalNode EOF() { return getToken(Es1Parser.EOF, 0); }
		public MainContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_main; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Es1Listener ) ((Es1Listener)listener).enterMain(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Es1Listener ) ((Es1Listener)listener).exitMain(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Es1Visitor ) return ((Es1Visitor<? extends T>)visitor).visitMain(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MainContext main() throws RecognitionException {
		MainContext _localctx = new MainContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_main);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(6);
			dig();
			setState(7);
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
	public static class DigContext extends ParserRuleContext {
		public SeqContext seq() {
			return getRuleContext(SeqContext.class,0);
		}
		public DigContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dig; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Es1Listener ) ((Es1Listener)listener).enterDig(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Es1Listener ) ((Es1Listener)listener).exitDig(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Es1Visitor ) return ((Es1Visitor<? extends T>)visitor).visitDig(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DigContext dig() throws RecognitionException {
		DigContext _localctx = new DigContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_dig);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(9);
			match(T__0);
			setState(10);
			seq();
			setState(11);
			match(T__1);
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
	public static class SeqContext extends ParserRuleContext {
		public SeqContext seq() {
			return getRuleContext(SeqContext.class,0);
		}
		public SeqContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_seq; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Es1Listener ) ((Es1Listener)listener).enterSeq(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Es1Listener ) ((Es1Listener)listener).exitSeq(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Es1Visitor ) return ((Es1Visitor<? extends T>)visitor).visitSeq(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SeqContext seq() throws RecognitionException {
		SeqContext _localctx = new SeqContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_seq);
		try {
			setState(44);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				enterOuterAlt(_localctx, 1);
				{
				}
				break;
			case T__2:
				enterOuterAlt(_localctx, 2);
				{
				setState(14);
				match(T__2);
				setState(15);
				seq();
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 3);
				{
				setState(16);
				match(T__3);
				setState(17);
				seq();
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 4);
				{
				setState(18);
				match(T__4);
				setState(19);
				seq();
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 5);
				{
				setState(20);
				match(T__5);
				setState(21);
				seq();
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 6);
				{
				setState(22);
				match(T__6);
				setState(23);
				seq();
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 7);
				{
				setState(24);
				match(T__7);
				setState(25);
				seq();
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 8);
				{
				setState(26);
				match(T__8);
				setState(27);
				seq();
				}
				break;
			case T__9:
				enterOuterAlt(_localctx, 9);
				{
				setState(28);
				match(T__9);
				setState(29);
				seq();
				}
				break;
			case T__10:
				enterOuterAlt(_localctx, 10);
				{
				setState(30);
				match(T__10);
				setState(31);
				seq();
				}
				break;
			case T__11:
				enterOuterAlt(_localctx, 11);
				{
				setState(32);
				match(T__11);
				setState(33);
				seq();
				}
				break;
			case T__12:
				enterOuterAlt(_localctx, 12);
				{
				setState(34);
				match(T__12);
				}
				break;
			case T__13:
				enterOuterAlt(_localctx, 13);
				{
				setState(35);
				match(T__13);
				}
				break;
			case T__14:
				enterOuterAlt(_localctx, 14);
				{
				setState(36);
				match(T__14);
				}
				break;
			case T__15:
				enterOuterAlt(_localctx, 15);
				{
				setState(37);
				match(T__15);
				}
				break;
			case T__16:
				enterOuterAlt(_localctx, 16);
				{
				setState(38);
				match(T__16);
				}
				break;
			case T__17:
				enterOuterAlt(_localctx, 17);
				{
				setState(39);
				match(T__17);
				}
				break;
			case T__18:
				enterOuterAlt(_localctx, 18);
				{
				setState(40);
				match(T__18);
				}
				break;
			case T__19:
				enterOuterAlt(_localctx, 19);
				{
				setState(41);
				match(T__19);
				}
				break;
			case T__20:
				enterOuterAlt(_localctx, 20);
				{
				setState(42);
				match(T__20);
				}
				break;
			case T__21:
				enterOuterAlt(_localctx, 21);
				{
				setState(43);
				match(T__21);
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

	public static final String _serializedATN =
		"\u0004\u0001\u0016/\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002-\b\u0002\u0001"+
		"\u0002\u0000\u0000\u0003\u0000\u0002\u0004\u0000\u0000?\u0000\u0006\u0001"+
		"\u0000\u0000\u0000\u0002\t\u0001\u0000\u0000\u0000\u0004,\u0001\u0000"+
		"\u0000\u0000\u0006\u0007\u0003\u0002\u0001\u0000\u0007\b\u0005\u0000\u0000"+
		"\u0001\b\u0001\u0001\u0000\u0000\u0000\t\n\u0005\u0001\u0000\u0000\n\u000b"+
		"\u0003\u0004\u0002\u0000\u000b\f\u0005\u0002\u0000\u0000\f\u0003\u0001"+
		"\u0000\u0000\u0000\r-\u0001\u0000\u0000\u0000\u000e\u000f\u0005\u0003"+
		"\u0000\u0000\u000f-\u0003\u0004\u0002\u0000\u0010\u0011\u0005\u0004\u0000"+
		"\u0000\u0011-\u0003\u0004\u0002\u0000\u0012\u0013\u0005\u0005\u0000\u0000"+
		"\u0013-\u0003\u0004\u0002\u0000\u0014\u0015\u0005\u0006\u0000\u0000\u0015"+
		"-\u0003\u0004\u0002\u0000\u0016\u0017\u0005\u0007\u0000\u0000\u0017-\u0003"+
		"\u0004\u0002\u0000\u0018\u0019\u0005\b\u0000\u0000\u0019-\u0003\u0004"+
		"\u0002\u0000\u001a\u001b\u0005\t\u0000\u0000\u001b-\u0003\u0004\u0002"+
		"\u0000\u001c\u001d\u0005\n\u0000\u0000\u001d-\u0003\u0004\u0002\u0000"+
		"\u001e\u001f\u0005\u000b\u0000\u0000\u001f-\u0003\u0004\u0002\u0000 !"+
		"\u0005\f\u0000\u0000!-\u0003\u0004\u0002\u0000\"-\u0005\r\u0000\u0000"+
		"#-\u0005\u000e\u0000\u0000$-\u0005\u000f\u0000\u0000%-\u0005\u0010\u0000"+
		"\u0000&-\u0005\u0011\u0000\u0000\'-\u0005\u0012\u0000\u0000(-\u0005\u0013"+
		"\u0000\u0000)-\u0005\u0014\u0000\u0000*-\u0005\u0015\u0000\u0000+-\u0005"+
		"\u0016\u0000\u0000,\r\u0001\u0000\u0000\u0000,\u000e\u0001\u0000\u0000"+
		"\u0000,\u0010\u0001\u0000\u0000\u0000,\u0012\u0001\u0000\u0000\u0000,"+
		"\u0014\u0001\u0000\u0000\u0000,\u0016\u0001\u0000\u0000\u0000,\u0018\u0001"+
		"\u0000\u0000\u0000,\u001a\u0001\u0000\u0000\u0000,\u001c\u0001\u0000\u0000"+
		"\u0000,\u001e\u0001\u0000\u0000\u0000, \u0001\u0000\u0000\u0000,\"\u0001"+
		"\u0000\u0000\u0000,#\u0001\u0000\u0000\u0000,$\u0001\u0000\u0000\u0000"+
		",%\u0001\u0000\u0000\u0000,&\u0001\u0000\u0000\u0000,\'\u0001\u0000\u0000"+
		"\u0000,(\u0001\u0000\u0000\u0000,)\u0001\u0000\u0000\u0000,*\u0001\u0000"+
		"\u0000\u0000,+\u0001\u0000\u0000\u0000-\u0005\u0001\u0000\u0000\u0000"+
		"\u0001,";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
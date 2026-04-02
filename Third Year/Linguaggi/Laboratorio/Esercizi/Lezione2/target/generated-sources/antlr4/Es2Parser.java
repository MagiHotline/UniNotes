// Generated from Es2.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class Es2Parser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23;
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
			null, "'('", "'), '", "')'", "'0, '", "'1, '", "'2, '", "'3, '", "'4, '", 
			"'5, '", "'6, '", "'7, '", "'8, '", "'9, '", "'0'", "'1'", "'2'", "'3'", 
			"'4'", "'5'", "'6'", "'7'", "'8'", "'9'"
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
	public String getGrammarFileName() { return "Es2.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public Es2Parser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MainContext extends ParserRuleContext {
		public DigContext dig() {
			return getRuleContext(DigContext.class,0);
		}
		public TerminalNode EOF() { return getToken(Es2Parser.EOF, 0); }
		public MainContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_main; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Es2Listener ) ((Es2Listener)listener).enterMain(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Es2Listener ) ((Es2Listener)listener).exitMain(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Es2Visitor ) return ((Es2Visitor<? extends T>)visitor).visitMain(this);
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
		public DigContext dig() {
			return getRuleContext(DigContext.class,0);
		}
		public DigContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dig; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Es2Listener ) ((Es2Listener)listener).enterDig(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Es2Listener ) ((Es2Listener)listener).exitDig(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Es2Visitor ) return ((Es2Visitor<? extends T>)visitor).visitDig(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DigContext dig() throws RecognitionException {
		DigContext _localctx = new DigContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_dig);
		try {
			setState(18);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(9);
				match(T__0);
				setState(10);
				seq();
				setState(11);
				match(T__1);
				setState(12);
				dig();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(14);
				match(T__0);
				setState(15);
				seq();
				setState(16);
				match(T__2);
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
	public static class SeqContext extends ParserRuleContext {
		public DigContext dig() {
			return getRuleContext(DigContext.class,0);
		}
		public SeqContext seq() {
			return getRuleContext(SeqContext.class,0);
		}
		public SeqContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_seq; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Es2Listener ) ((Es2Listener)listener).enterSeq(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Es2Listener ) ((Es2Listener)listener).exitSeq(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Es2Visitor ) return ((Es2Visitor<? extends T>)visitor).visitSeq(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SeqContext seq() throws RecognitionException {
		SeqContext _localctx = new SeqContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_seq);
		try {
			setState(71);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(21);
				match(T__3);
				setState(22);
				dig();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(23);
				match(T__4);
				setState(24);
				dig();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(25);
				match(T__5);
				setState(26);
				dig();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(27);
				match(T__6);
				setState(28);
				dig();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(29);
				match(T__7);
				setState(30);
				dig();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(31);
				match(T__8);
				setState(32);
				dig();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(33);
				match(T__9);
				setState(34);
				dig();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(35);
				match(T__10);
				setState(36);
				dig();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(37);
				match(T__11);
				setState(38);
				dig();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(39);
				match(T__12);
				setState(40);
				dig();
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(41);
				match(T__3);
				setState(42);
				seq();
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(43);
				match(T__4);
				setState(44);
				seq();
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(45);
				match(T__5);
				setState(46);
				seq();
				}
				break;
			case 15:
				enterOuterAlt(_localctx, 15);
				{
				setState(47);
				match(T__6);
				setState(48);
				seq();
				}
				break;
			case 16:
				enterOuterAlt(_localctx, 16);
				{
				setState(49);
				match(T__7);
				setState(50);
				seq();
				}
				break;
			case 17:
				enterOuterAlt(_localctx, 17);
				{
				setState(51);
				match(T__8);
				setState(52);
				seq();
				}
				break;
			case 18:
				enterOuterAlt(_localctx, 18);
				{
				setState(53);
				match(T__9);
				setState(54);
				seq();
				}
				break;
			case 19:
				enterOuterAlt(_localctx, 19);
				{
				setState(55);
				match(T__10);
				setState(56);
				seq();
				}
				break;
			case 20:
				enterOuterAlt(_localctx, 20);
				{
				setState(57);
				match(T__11);
				setState(58);
				seq();
				}
				break;
			case 21:
				enterOuterAlt(_localctx, 21);
				{
				setState(59);
				match(T__12);
				setState(60);
				seq();
				}
				break;
			case 22:
				enterOuterAlt(_localctx, 22);
				{
				setState(61);
				match(T__13);
				}
				break;
			case 23:
				enterOuterAlt(_localctx, 23);
				{
				setState(62);
				match(T__14);
				}
				break;
			case 24:
				enterOuterAlt(_localctx, 24);
				{
				setState(63);
				match(T__15);
				}
				break;
			case 25:
				enterOuterAlt(_localctx, 25);
				{
				setState(64);
				match(T__16);
				}
				break;
			case 26:
				enterOuterAlt(_localctx, 26);
				{
				setState(65);
				match(T__17);
				}
				break;
			case 27:
				enterOuterAlt(_localctx, 27);
				{
				setState(66);
				match(T__18);
				}
				break;
			case 28:
				enterOuterAlt(_localctx, 28);
				{
				setState(67);
				match(T__19);
				}
				break;
			case 29:
				enterOuterAlt(_localctx, 29);
				{
				setState(68);
				match(T__20);
				}
				break;
			case 30:
				enterOuterAlt(_localctx, 30);
				{
				setState(69);
				match(T__21);
				}
				break;
			case 31:
				enterOuterAlt(_localctx, 31);
				{
				setState(70);
				match(T__22);
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

	public static final String _serializedATN =
		"\u0004\u0001\u0017J\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0003\u0001\u0013\b\u0001\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0003\u0002H\b\u0002\u0001\u0002\u0000\u0000\u0003\u0000\u0002"+
		"\u0004\u0000\u0000e\u0000\u0006\u0001\u0000\u0000\u0000\u0002\u0012\u0001"+
		"\u0000\u0000\u0000\u0004G\u0001\u0000\u0000\u0000\u0006\u0007\u0003\u0002"+
		"\u0001\u0000\u0007\b\u0005\u0000\u0000\u0001\b\u0001\u0001\u0000\u0000"+
		"\u0000\t\n\u0005\u0001\u0000\u0000\n\u000b\u0003\u0004\u0002\u0000\u000b"+
		"\f\u0005\u0002\u0000\u0000\f\r\u0003\u0002\u0001\u0000\r\u0013\u0001\u0000"+
		"\u0000\u0000\u000e\u000f\u0005\u0001\u0000\u0000\u000f\u0010\u0003\u0004"+
		"\u0002\u0000\u0010\u0011\u0005\u0003\u0000\u0000\u0011\u0013\u0001\u0000"+
		"\u0000\u0000\u0012\t\u0001\u0000\u0000\u0000\u0012\u000e\u0001\u0000\u0000"+
		"\u0000\u0013\u0003\u0001\u0000\u0000\u0000\u0014H\u0001\u0000\u0000\u0000"+
		"\u0015\u0016\u0005\u0004\u0000\u0000\u0016H\u0003\u0002\u0001\u0000\u0017"+
		"\u0018\u0005\u0005\u0000\u0000\u0018H\u0003\u0002\u0001\u0000\u0019\u001a"+
		"\u0005\u0006\u0000\u0000\u001aH\u0003\u0002\u0001\u0000\u001b\u001c\u0005"+
		"\u0007\u0000\u0000\u001cH\u0003\u0002\u0001\u0000\u001d\u001e\u0005\b"+
		"\u0000\u0000\u001eH\u0003\u0002\u0001\u0000\u001f \u0005\t\u0000\u0000"+
		" H\u0003\u0002\u0001\u0000!\"\u0005\n\u0000\u0000\"H\u0003\u0002\u0001"+
		"\u0000#$\u0005\u000b\u0000\u0000$H\u0003\u0002\u0001\u0000%&\u0005\f\u0000"+
		"\u0000&H\u0003\u0002\u0001\u0000\'(\u0005\r\u0000\u0000(H\u0003\u0002"+
		"\u0001\u0000)*\u0005\u0004\u0000\u0000*H\u0003\u0004\u0002\u0000+,\u0005"+
		"\u0005\u0000\u0000,H\u0003\u0004\u0002\u0000-.\u0005\u0006\u0000\u0000"+
		".H\u0003\u0004\u0002\u0000/0\u0005\u0007\u0000\u00000H\u0003\u0004\u0002"+
		"\u000012\u0005\b\u0000\u00002H\u0003\u0004\u0002\u000034\u0005\t\u0000"+
		"\u00004H\u0003\u0004\u0002\u000056\u0005\n\u0000\u00006H\u0003\u0004\u0002"+
		"\u000078\u0005\u000b\u0000\u00008H\u0003\u0004\u0002\u00009:\u0005\f\u0000"+
		"\u0000:H\u0003\u0004\u0002\u0000;<\u0005\r\u0000\u0000<H\u0003\u0004\u0002"+
		"\u0000=H\u0005\u000e\u0000\u0000>H\u0005\u000f\u0000\u0000?H\u0005\u0010"+
		"\u0000\u0000@H\u0005\u0011\u0000\u0000AH\u0005\u0012\u0000\u0000BH\u0005"+
		"\u0013\u0000\u0000CH\u0005\u0014\u0000\u0000DH\u0005\u0015\u0000\u0000"+
		"EH\u0005\u0016\u0000\u0000FH\u0005\u0017\u0000\u0000G\u0014\u0001\u0000"+
		"\u0000\u0000G\u0015\u0001\u0000\u0000\u0000G\u0017\u0001\u0000\u0000\u0000"+
		"G\u0019\u0001\u0000\u0000\u0000G\u001b\u0001\u0000\u0000\u0000G\u001d"+
		"\u0001\u0000\u0000\u0000G\u001f\u0001\u0000\u0000\u0000G!\u0001\u0000"+
		"\u0000\u0000G#\u0001\u0000\u0000\u0000G%\u0001\u0000\u0000\u0000G\'\u0001"+
		"\u0000\u0000\u0000G)\u0001\u0000\u0000\u0000G+\u0001\u0000\u0000\u0000"+
		"G-\u0001\u0000\u0000\u0000G/\u0001\u0000\u0000\u0000G1\u0001\u0000\u0000"+
		"\u0000G3\u0001\u0000\u0000\u0000G5\u0001\u0000\u0000\u0000G7\u0001\u0000"+
		"\u0000\u0000G9\u0001\u0000\u0000\u0000G;\u0001\u0000\u0000\u0000G=\u0001"+
		"\u0000\u0000\u0000G>\u0001\u0000\u0000\u0000G?\u0001\u0000\u0000\u0000"+
		"G@\u0001\u0000\u0000\u0000GA\u0001\u0000\u0000\u0000GB\u0001\u0000\u0000"+
		"\u0000GC\u0001\u0000\u0000\u0000GD\u0001\u0000\u0000\u0000GE\u0001\u0000"+
		"\u0000\u0000GF\u0001\u0000\u0000\u0000H\u0005\u0001\u0000\u0000\u0000"+
		"\u0002\u0012G";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
// Generated from it/univr/pl/IntExp.g4 by ANTLR 4.13.2
package it.univr.pl;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class IntExpParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, LPAR=11, RPAR=12, ADD=13, MUL=14, WS=15;
	public static final int
		RULE_main = 0, RULE_exp = 1, RULE_nat = 2, RULE_seq = 3;
	private static String[] makeRuleNames() {
		return new String[] {
			"main", "exp", "nat", "seq"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'0'", "'1'", "'2'", "'3'", "'4'", "'5'", "'6'", "'7'", "'8'", 
			"'9'", "'('", "')'", "'+'", "'*'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, "LPAR", 
			"RPAR", "ADD", "MUL", "WS"
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
	public String getGrammarFileName() { return "IntExp.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public IntExpParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MainContext extends ParserRuleContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode EOF() { return getToken(IntExpParser.EOF, 0); }
		public MainContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_main; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IntExpVisitor ) return ((IntExpVisitor<? extends T>)visitor).visitMain(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MainContext main() throws RecognitionException {
		MainContext _localctx = new MainContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_main);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(8);
			exp();
			setState(9);
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
	public static class ExpContext extends ParserRuleContext {
		public ExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp; }
	 
		public ExpContext() { }
		public void copyFrom(ExpContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ValContext extends ExpContext {
		public NatContext nat() {
			return getRuleContext(NatContext.class,0);
		}
		public ValContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IntExpVisitor ) return ((IntExpVisitor<? extends T>)visitor).visitVal(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AddContext extends ExpContext {
		public TerminalNode LPAR() { return getToken(IntExpParser.LPAR, 0); }
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public TerminalNode ADD() { return getToken(IntExpParser.ADD, 0); }
		public TerminalNode RPAR() { return getToken(IntExpParser.RPAR, 0); }
		public AddContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IntExpVisitor ) return ((IntExpVisitor<? extends T>)visitor).visitAdd(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MulContext extends ExpContext {
		public TerminalNode LPAR() { return getToken(IntExpParser.LPAR, 0); }
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public TerminalNode MUL() { return getToken(IntExpParser.MUL, 0); }
		public TerminalNode RPAR() { return getToken(IntExpParser.RPAR, 0); }
		public MulContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IntExpVisitor ) return ((IntExpVisitor<? extends T>)visitor).visitMul(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpContext exp() throws RecognitionException {
		ExpContext _localctx = new ExpContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_exp);
		try {
			setState(24);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				_localctx = new ValContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(11);
				nat();
				}
				break;
			case 2:
				_localctx = new AddContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(12);
				match(LPAR);
				setState(13);
				exp();
				setState(14);
				match(ADD);
				setState(15);
				exp();
				setState(16);
				match(RPAR);
				}
				break;
			case 3:
				_localctx = new MulContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(18);
				match(LPAR);
				setState(19);
				exp();
				setState(20);
				match(MUL);
				setState(21);
				exp();
				setState(22);
				match(RPAR);
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
	public static class NatContext extends ParserRuleContext {
		public SeqContext seq() {
			return getRuleContext(SeqContext.class,0);
		}
		public NatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nat; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IntExpVisitor ) return ((IntExpVisitor<? extends T>)visitor).visitNat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NatContext nat() throws RecognitionException {
		NatContext _localctx = new NatContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_nat);
		try {
			setState(45);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				enterOuterAlt(_localctx, 1);
				{
				setState(26);
				match(T__0);
				}
				break;
			case T__1:
				enterOuterAlt(_localctx, 2);
				{
				setState(27);
				match(T__1);
				setState(28);
				seq();
				}
				break;
			case T__2:
				enterOuterAlt(_localctx, 3);
				{
				setState(29);
				match(T__2);
				setState(30);
				seq();
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 4);
				{
				setState(31);
				match(T__3);
				setState(32);
				seq();
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 5);
				{
				setState(33);
				match(T__4);
				setState(34);
				seq();
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 6);
				{
				setState(35);
				match(T__5);
				setState(36);
				seq();
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 7);
				{
				setState(37);
				match(T__6);
				setState(38);
				seq();
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 8);
				{
				setState(39);
				match(T__7);
				setState(40);
				seq();
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 9);
				{
				setState(41);
				match(T__8);
				setState(42);
				seq();
				}
				break;
			case T__9:
				enterOuterAlt(_localctx, 10);
				{
				setState(43);
				match(T__9);
				setState(44);
				seq();
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
	public static class SeqContext extends ParserRuleContext {
		public SeqContext seq() {
			return getRuleContext(SeqContext.class,0);
		}
		public SeqContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_seq; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IntExpVisitor ) return ((IntExpVisitor<? extends T>)visitor).visitSeq(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SeqContext seq() throws RecognitionException {
		SeqContext _localctx = new SeqContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_seq);
		try {
			setState(68);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case EOF:
			case RPAR:
			case ADD:
			case MUL:
				enterOuterAlt(_localctx, 1);
				{
				}
				break;
			case T__0:
				enterOuterAlt(_localctx, 2);
				{
				setState(48);
				match(T__0);
				setState(49);
				seq();
				}
				break;
			case T__1:
				enterOuterAlt(_localctx, 3);
				{
				setState(50);
				match(T__1);
				setState(51);
				seq();
				}
				break;
			case T__2:
				enterOuterAlt(_localctx, 4);
				{
				setState(52);
				match(T__2);
				setState(53);
				seq();
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 5);
				{
				setState(54);
				match(T__3);
				setState(55);
				seq();
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 6);
				{
				setState(56);
				match(T__4);
				setState(57);
				seq();
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 7);
				{
				setState(58);
				match(T__5);
				setState(59);
				seq();
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 8);
				{
				setState(60);
				match(T__6);
				setState(61);
				seq();
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 9);
				{
				setState(62);
				match(T__7);
				setState(63);
				seq();
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 10);
				{
				setState(64);
				match(T__8);
				setState(65);
				seq();
				}
				break;
			case T__9:
				enterOuterAlt(_localctx, 11);
				{
				setState(66);
				match(T__9);
				setState(67);
				seq();
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
		"\u0004\u0001\u000fG\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0003\u0001\u0019\b\u0001\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002.\b"+
		"\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003E\b\u0003\u0001"+
		"\u0003\u0000\u0000\u0004\u0000\u0002\u0004\u0006\u0000\u0000W\u0000\b"+
		"\u0001\u0000\u0000\u0000\u0002\u0018\u0001\u0000\u0000\u0000\u0004-\u0001"+
		"\u0000\u0000\u0000\u0006D\u0001\u0000\u0000\u0000\b\t\u0003\u0002\u0001"+
		"\u0000\t\n\u0005\u0000\u0000\u0001\n\u0001\u0001\u0000\u0000\u0000\u000b"+
		"\u0019\u0003\u0004\u0002\u0000\f\r\u0005\u000b\u0000\u0000\r\u000e\u0003"+
		"\u0002\u0001\u0000\u000e\u000f\u0005\r\u0000\u0000\u000f\u0010\u0003\u0002"+
		"\u0001\u0000\u0010\u0011\u0005\f\u0000\u0000\u0011\u0019\u0001\u0000\u0000"+
		"\u0000\u0012\u0013\u0005\u000b\u0000\u0000\u0013\u0014\u0003\u0002\u0001"+
		"\u0000\u0014\u0015\u0005\u000e\u0000\u0000\u0015\u0016\u0003\u0002\u0001"+
		"\u0000\u0016\u0017\u0005\f\u0000\u0000\u0017\u0019\u0001\u0000\u0000\u0000"+
		"\u0018\u000b\u0001\u0000\u0000\u0000\u0018\f\u0001\u0000\u0000\u0000\u0018"+
		"\u0012\u0001\u0000\u0000\u0000\u0019\u0003\u0001\u0000\u0000\u0000\u001a"+
		".\u0005\u0001\u0000\u0000\u001b\u001c\u0005\u0002\u0000\u0000\u001c.\u0003"+
		"\u0006\u0003\u0000\u001d\u001e\u0005\u0003\u0000\u0000\u001e.\u0003\u0006"+
		"\u0003\u0000\u001f \u0005\u0004\u0000\u0000 .\u0003\u0006\u0003\u0000"+
		"!\"\u0005\u0005\u0000\u0000\".\u0003\u0006\u0003\u0000#$\u0005\u0006\u0000"+
		"\u0000$.\u0003\u0006\u0003\u0000%&\u0005\u0007\u0000\u0000&.\u0003\u0006"+
		"\u0003\u0000\'(\u0005\b\u0000\u0000(.\u0003\u0006\u0003\u0000)*\u0005"+
		"\t\u0000\u0000*.\u0003\u0006\u0003\u0000+,\u0005\n\u0000\u0000,.\u0003"+
		"\u0006\u0003\u0000-\u001a\u0001\u0000\u0000\u0000-\u001b\u0001\u0000\u0000"+
		"\u0000-\u001d\u0001\u0000\u0000\u0000-\u001f\u0001\u0000\u0000\u0000-"+
		"!\u0001\u0000\u0000\u0000-#\u0001\u0000\u0000\u0000-%\u0001\u0000\u0000"+
		"\u0000-\'\u0001\u0000\u0000\u0000-)\u0001\u0000\u0000\u0000-+\u0001\u0000"+
		"\u0000\u0000.\u0005\u0001\u0000\u0000\u0000/E\u0001\u0000\u0000\u0000"+
		"01\u0005\u0001\u0000\u00001E\u0003\u0006\u0003\u000023\u0005\u0002\u0000"+
		"\u00003E\u0003\u0006\u0003\u000045\u0005\u0003\u0000\u00005E\u0003\u0006"+
		"\u0003\u000067\u0005\u0004\u0000\u00007E\u0003\u0006\u0003\u000089\u0005"+
		"\u0005\u0000\u00009E\u0003\u0006\u0003\u0000:;\u0005\u0006\u0000\u0000"+
		";E\u0003\u0006\u0003\u0000<=\u0005\u0007\u0000\u0000=E\u0003\u0006\u0003"+
		"\u0000>?\u0005\b\u0000\u0000?E\u0003\u0006\u0003\u0000@A\u0005\t\u0000"+
		"\u0000AE\u0003\u0006\u0003\u0000BC\u0005\n\u0000\u0000CE\u0003\u0006\u0003"+
		"\u0000D/\u0001\u0000\u0000\u0000D0\u0001\u0000\u0000\u0000D2\u0001\u0000"+
		"\u0000\u0000D4\u0001\u0000\u0000\u0000D6\u0001\u0000\u0000\u0000D8\u0001"+
		"\u0000\u0000\u0000D:\u0001\u0000\u0000\u0000D<\u0001\u0000\u0000\u0000"+
		"D>\u0001\u0000\u0000\u0000D@\u0001\u0000\u0000\u0000DB\u0001\u0000\u0000"+
		"\u0000E\u0007\u0001\u0000\u0000\u0000\u0003\u0018-D";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
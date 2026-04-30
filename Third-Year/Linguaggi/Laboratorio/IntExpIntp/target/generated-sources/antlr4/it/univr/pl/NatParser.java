// Generated from it/univr/pl/Nat.g4 by ANTLR 4.13.2
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
public class NatParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10;
	public static final int
		RULE_main = 0, RULE_nat = 1, RULE_seq = 2;
	private static String[] makeRuleNames() {
		return new String[] {
			"main", "nat", "seq"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'0'", "'1'", "'2'", "'3'", "'4'", "'5'", "'6'", "'7'", "'8'", 
			"'9'"
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
	public String getGrammarFileName() { return "Nat.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public NatParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MainContext extends ParserRuleContext {
		public NatContext nat() {
			return getRuleContext(NatContext.class,0);
		}
		public TerminalNode EOF() { return getToken(NatParser.EOF, 0); }
		public MainContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_main; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NatVisitor ) return ((NatVisitor<? extends T>)visitor).visitMain(this);
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
			nat();
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
			if ( visitor instanceof NatVisitor ) return ((NatVisitor<? extends T>)visitor).visitNat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NatContext nat() throws RecognitionException {
		NatContext _localctx = new NatContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_nat);
		try {
			setState(28);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				enterOuterAlt(_localctx, 1);
				{
				setState(9);
				match(T__0);
				}
				break;
			case T__1:
				enterOuterAlt(_localctx, 2);
				{
				setState(10);
				match(T__1);
				setState(11);
				seq();
				}
				break;
			case T__2:
				enterOuterAlt(_localctx, 3);
				{
				setState(12);
				match(T__2);
				setState(13);
				seq();
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 4);
				{
				setState(14);
				match(T__3);
				setState(15);
				seq();
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 5);
				{
				setState(16);
				match(T__4);
				setState(17);
				seq();
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 6);
				{
				setState(18);
				match(T__5);
				setState(19);
				seq();
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 7);
				{
				setState(20);
				match(T__6);
				setState(21);
				seq();
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 8);
				{
				setState(22);
				match(T__7);
				setState(23);
				seq();
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 9);
				{
				setState(24);
				match(T__8);
				setState(25);
				seq();
				}
				break;
			case T__9:
				enterOuterAlt(_localctx, 10);
				{
				setState(26);
				match(T__9);
				setState(27);
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
			if ( visitor instanceof NatVisitor ) return ((NatVisitor<? extends T>)visitor).visitSeq(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SeqContext seq() throws RecognitionException {
		SeqContext _localctx = new SeqContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_seq);
		try {
			setState(51);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case EOF:
				enterOuterAlt(_localctx, 1);
				{
				}
				break;
			case T__0:
				enterOuterAlt(_localctx, 2);
				{
				setState(31);
				match(T__0);
				setState(32);
				seq();
				}
				break;
			case T__1:
				enterOuterAlt(_localctx, 3);
				{
				setState(33);
				match(T__1);
				setState(34);
				seq();
				}
				break;
			case T__2:
				enterOuterAlt(_localctx, 4);
				{
				setState(35);
				match(T__2);
				setState(36);
				seq();
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 5);
				{
				setState(37);
				match(T__3);
				setState(38);
				seq();
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 6);
				{
				setState(39);
				match(T__4);
				setState(40);
				seq();
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 7);
				{
				setState(41);
				match(T__5);
				setState(42);
				seq();
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 8);
				{
				setState(43);
				match(T__6);
				setState(44);
				seq();
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 9);
				{
				setState(45);
				match(T__7);
				setState(46);
				seq();
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 10);
				{
				setState(47);
				match(T__8);
				setState(48);
				seq();
				}
				break;
			case T__9:
				enterOuterAlt(_localctx, 11);
				{
				setState(49);
				match(T__9);
				setState(50);
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
		"\u0004\u0001\n6\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003"+
		"\u0001\u001d\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u00024\b"+
		"\u0002\u0001\u0002\u0000\u0000\u0003\u0000\u0002\u0004\u0000\u0000E\u0000"+
		"\u0006\u0001\u0000\u0000\u0000\u0002\u001c\u0001\u0000\u0000\u0000\u0004"+
		"3\u0001\u0000\u0000\u0000\u0006\u0007\u0003\u0002\u0001\u0000\u0007\b"+
		"\u0005\u0000\u0000\u0001\b\u0001\u0001\u0000\u0000\u0000\t\u001d\u0005"+
		"\u0001\u0000\u0000\n\u000b\u0005\u0002\u0000\u0000\u000b\u001d\u0003\u0004"+
		"\u0002\u0000\f\r\u0005\u0003\u0000\u0000\r\u001d\u0003\u0004\u0002\u0000"+
		"\u000e\u000f\u0005\u0004\u0000\u0000\u000f\u001d\u0003\u0004\u0002\u0000"+
		"\u0010\u0011\u0005\u0005\u0000\u0000\u0011\u001d\u0003\u0004\u0002\u0000"+
		"\u0012\u0013\u0005\u0006\u0000\u0000\u0013\u001d\u0003\u0004\u0002\u0000"+
		"\u0014\u0015\u0005\u0007\u0000\u0000\u0015\u001d\u0003\u0004\u0002\u0000"+
		"\u0016\u0017\u0005\b\u0000\u0000\u0017\u001d\u0003\u0004\u0002\u0000\u0018"+
		"\u0019\u0005\t\u0000\u0000\u0019\u001d\u0003\u0004\u0002\u0000\u001a\u001b"+
		"\u0005\n\u0000\u0000\u001b\u001d\u0003\u0004\u0002\u0000\u001c\t\u0001"+
		"\u0000\u0000\u0000\u001c\n\u0001\u0000\u0000\u0000\u001c\f\u0001\u0000"+
		"\u0000\u0000\u001c\u000e\u0001\u0000\u0000\u0000\u001c\u0010\u0001\u0000"+
		"\u0000\u0000\u001c\u0012\u0001\u0000\u0000\u0000\u001c\u0014\u0001\u0000"+
		"\u0000\u0000\u001c\u0016\u0001\u0000\u0000\u0000\u001c\u0018\u0001\u0000"+
		"\u0000\u0000\u001c\u001a\u0001\u0000\u0000\u0000\u001d\u0003\u0001\u0000"+
		"\u0000\u0000\u001e4\u0001\u0000\u0000\u0000\u001f \u0005\u0001\u0000\u0000"+
		" 4\u0003\u0004\u0002\u0000!\"\u0005\u0002\u0000\u0000\"4\u0003\u0004\u0002"+
		"\u0000#$\u0005\u0003\u0000\u0000$4\u0003\u0004\u0002\u0000%&\u0005\u0004"+
		"\u0000\u0000&4\u0003\u0004\u0002\u0000\'(\u0005\u0005\u0000\u0000(4\u0003"+
		"\u0004\u0002\u0000)*\u0005\u0006\u0000\u0000*4\u0003\u0004\u0002\u0000"+
		"+,\u0005\u0007\u0000\u0000,4\u0003\u0004\u0002\u0000-.\u0005\b\u0000\u0000"+
		".4\u0003\u0004\u0002\u0000/0\u0005\t\u0000\u000004\u0003\u0004\u0002\u0000"+
		"12\u0005\n\u0000\u000024\u0003\u0004\u0002\u00003\u001e\u0001\u0000\u0000"+
		"\u00003\u001f\u0001\u0000\u0000\u00003!\u0001\u0000\u0000\u00003#\u0001"+
		"\u0000\u0000\u00003%\u0001\u0000\u0000\u00003\'\u0001\u0000\u0000\u0000"+
		"3)\u0001\u0000\u0000\u00003+\u0001\u0000\u0000\u00003-\u0001\u0000\u0000"+
		"\u00003/\u0001\u0000\u0000\u000031\u0001\u0000\u0000\u00004\u0005\u0001"+
		"\u0000\u0000\u0000\u0002\u001c3";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
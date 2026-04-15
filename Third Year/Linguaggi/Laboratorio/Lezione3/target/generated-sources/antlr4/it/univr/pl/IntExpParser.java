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
		VAR=1, INT=2, LPAR=3, RPAR=4, ADD=5, MUL=6, SUB=7, DIV=8, MOD=9, EQUALS=10, 
		SEMICOLON=11, WS=12;
	public static final int
		RULE_main = 0, RULE_exp = 1;
	private static String[] makeRuleNames() {
		return new String[] {
			"main", "exp"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, "'('", "')'", "'+'", "'*'", "'-'", "'/'", "'mod'", 
			"'='", "';'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "VAR", "INT", "LPAR", "RPAR", "ADD", "MUL", "SUB", "DIV", "MOD", 
			"EQUALS", "SEMICOLON", "WS"
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
			setState(4);
			exp();
			setState(5);
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
		public TerminalNode INT() { return getToken(IntExpParser.INT, 0); }
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
	public static class DivContext extends ExpContext {
		public TerminalNode LPAR() { return getToken(IntExpParser.LPAR, 0); }
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public TerminalNode DIV() { return getToken(IntExpParser.DIV, 0); }
		public TerminalNode RPAR() { return getToken(IntExpParser.RPAR, 0); }
		public DivContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IntExpVisitor ) return ((IntExpVisitor<? extends T>)visitor).visitDiv(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SubContext extends ExpContext {
		public TerminalNode LPAR() { return getToken(IntExpParser.LPAR, 0); }
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public TerminalNode SUB() { return getToken(IntExpParser.SUB, 0); }
		public TerminalNode RPAR() { return getToken(IntExpParser.RPAR, 0); }
		public SubContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IntExpVisitor ) return ((IntExpVisitor<? extends T>)visitor).visitSub(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MODContext extends ExpContext {
		public TerminalNode LPAR() { return getToken(IntExpParser.LPAR, 0); }
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public TerminalNode MOD() { return getToken(IntExpParser.MOD, 0); }
		public TerminalNode RPAR() { return getToken(IntExpParser.RPAR, 0); }
		public MODContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IntExpVisitor ) return ((IntExpVisitor<? extends T>)visitor).visitMOD(this);
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
	@SuppressWarnings("CheckReturnValue")
	public static class VarContext extends ExpContext {
		public TerminalNode VAR() { return getToken(IntExpParser.VAR, 0); }
		public TerminalNode EQUALS() { return getToken(IntExpParser.EQUALS, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(IntExpParser.SEMICOLON, 0); }
		public VarContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IntExpVisitor ) return ((IntExpVisitor<? extends T>)visitor).visitVar(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AccessContext extends ExpContext {
		public TerminalNode VAR() { return getToken(IntExpParser.VAR, 0); }
		public AccessContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IntExpVisitor ) return ((IntExpVisitor<? extends T>)visitor).visitAccess(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SeqContext extends ExpContext {
		public TerminalNode VAR() { return getToken(IntExpParser.VAR, 0); }
		public TerminalNode EQUALS() { return getToken(IntExpParser.EQUALS, 0); }
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public TerminalNode SEMICOLON() { return getToken(IntExpParser.SEMICOLON, 0); }
		public SeqContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IntExpVisitor ) return ((IntExpVisitor<? extends T>)visitor).visitSeq(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpContext exp() throws RecognitionException {
		ExpContext _localctx = new ExpContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_exp);
		try {
			setState(50);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				_localctx = new ValContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(7);
				match(INT);
				}
				break;
			case 2:
				_localctx = new AccessContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(8);
				match(VAR);
				}
				break;
			case 3:
				_localctx = new VarContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(9);
				match(VAR);
				setState(10);
				match(EQUALS);
				setState(11);
				exp();
				setState(12);
				match(SEMICOLON);
				}
				break;
			case 4:
				_localctx = new SeqContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(14);
				match(VAR);
				setState(15);
				match(EQUALS);
				setState(16);
				exp();
				setState(17);
				match(SEMICOLON);
				setState(18);
				exp();
				}
				break;
			case 5:
				_localctx = new AddContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(20);
				match(LPAR);
				setState(21);
				exp();
				setState(22);
				match(ADD);
				setState(23);
				exp();
				setState(24);
				match(RPAR);
				}
				break;
			case 6:
				_localctx = new MulContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(26);
				match(LPAR);
				setState(27);
				exp();
				setState(28);
				match(MUL);
				setState(29);
				exp();
				setState(30);
				match(RPAR);
				}
				break;
			case 7:
				_localctx = new SubContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(32);
				match(LPAR);
				setState(33);
				exp();
				setState(34);
				match(SUB);
				setState(35);
				exp();
				setState(36);
				match(RPAR);
				}
				break;
			case 8:
				_localctx = new DivContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(38);
				match(LPAR);
				setState(39);
				exp();
				setState(40);
				match(DIV);
				setState(41);
				exp();
				setState(42);
				match(RPAR);
				}
				break;
			case 9:
				_localctx = new MODContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(44);
				match(LPAR);
				setState(45);
				exp();
				setState(46);
				match(MOD);
				setState(47);
				exp();
				setState(48);
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

	public static final String _serializedATN =
		"\u0004\u0001\f5\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u00013\b\u0001\u0001"+
		"\u0001\u0000\u0000\u0002\u0000\u0002\u0000\u0000:\u0000\u0004\u0001\u0000"+
		"\u0000\u0000\u00022\u0001\u0000\u0000\u0000\u0004\u0005\u0003\u0002\u0001"+
		"\u0000\u0005\u0006\u0005\u0000\u0000\u0001\u0006\u0001\u0001\u0000\u0000"+
		"\u0000\u00073\u0005\u0002\u0000\u0000\b3\u0005\u0001\u0000\u0000\t\n\u0005"+
		"\u0001\u0000\u0000\n\u000b\u0005\n\u0000\u0000\u000b\f\u0003\u0002\u0001"+
		"\u0000\f\r\u0005\u000b\u0000\u0000\r3\u0001\u0000\u0000\u0000\u000e\u000f"+
		"\u0005\u0001\u0000\u0000\u000f\u0010\u0005\n\u0000\u0000\u0010\u0011\u0003"+
		"\u0002\u0001\u0000\u0011\u0012\u0005\u000b\u0000\u0000\u0012\u0013\u0003"+
		"\u0002\u0001\u0000\u00133\u0001\u0000\u0000\u0000\u0014\u0015\u0005\u0003"+
		"\u0000\u0000\u0015\u0016\u0003\u0002\u0001\u0000\u0016\u0017\u0005\u0005"+
		"\u0000\u0000\u0017\u0018\u0003\u0002\u0001\u0000\u0018\u0019\u0005\u0004"+
		"\u0000\u0000\u00193\u0001\u0000\u0000\u0000\u001a\u001b\u0005\u0003\u0000"+
		"\u0000\u001b\u001c\u0003\u0002\u0001\u0000\u001c\u001d\u0005\u0006\u0000"+
		"\u0000\u001d\u001e\u0003\u0002\u0001\u0000\u001e\u001f\u0005\u0004\u0000"+
		"\u0000\u001f3\u0001\u0000\u0000\u0000 !\u0005\u0003\u0000\u0000!\"\u0003"+
		"\u0002\u0001\u0000\"#\u0005\u0007\u0000\u0000#$\u0003\u0002\u0001\u0000"+
		"$%\u0005\u0004\u0000\u0000%3\u0001\u0000\u0000\u0000&\'\u0005\u0003\u0000"+
		"\u0000\'(\u0003\u0002\u0001\u0000()\u0005\b\u0000\u0000)*\u0003\u0002"+
		"\u0001\u0000*+\u0005\u0004\u0000\u0000+3\u0001\u0000\u0000\u0000,-\u0005"+
		"\u0003\u0000\u0000-.\u0003\u0002\u0001\u0000./\u0005\t\u0000\u0000/0\u0003"+
		"\u0002\u0001\u000001\u0005\u0004\u0000\u000013\u0001\u0000\u0000\u0000"+
		"2\u0007\u0001\u0000\u0000\u00002\b\u0001\u0000\u0000\u00002\t\u0001\u0000"+
		"\u0000\u00002\u000e\u0001\u0000\u0000\u00002\u0014\u0001\u0000\u0000\u0000"+
		"2\u001a\u0001\u0000\u0000\u00002 \u0001\u0000\u0000\u00002&\u0001\u0000"+
		"\u0000\u00002,\u0001\u0000\u0000\u00003\u0003\u0001\u0000\u0000\u0000"+
		"\u00012";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
// Generated from it/univr/pl/Magi.g4 by ANTLR 4.13.2
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
public class MagiParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		LPAR=1, RPAR=2, LCUR=3, RCUR=4, IF=5, ELSE=6, WHILE=7, PRINT=8, FLOAT=9, 
		ADD=10, MUL=11, SUB=12, DIV=13, MOD=14, POW=15, BOOL=16, NOT=17, EQ=18, 
		NEQ=19, LT=20, GT=21, LTE=22, GTE=23, AND=24, OR=25, ASSIGN=26, SEMICOLON=27, 
		STRING=28, VAR=29, WS=30, COMMENT=31, LINE_COMMENT=32;
	public static final int
		RULE_main = 0, RULE_com = 1, RULE_exp = 2;
	private static String[] makeRuleNames() {
		return new String[] {
			"main", "com", "exp"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", "'{'", "'}'", "'if'", "'else'", "'while'", "'print'", 
			null, "'+'", "'*'", "'-'", "'/'", "'mod'", "'^'", null, "'!'", "'=='", 
			"'!='", "'<'", "'>'", "'<='", "'>='", "'&&'", "'||'", "'='", "';'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "LPAR", "RPAR", "LCUR", "RCUR", "IF", "ELSE", "WHILE", "PRINT", 
			"FLOAT", "ADD", "MUL", "SUB", "DIV", "MOD", "POW", "BOOL", "NOT", "EQ", 
			"NEQ", "LT", "GT", "LTE", "GTE", "AND", "OR", "ASSIGN", "SEMICOLON", 
			"STRING", "VAR", "WS", "COMMENT", "LINE_COMMENT"
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
	public String getGrammarFileName() { return "Magi.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public MagiParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MainContext extends ParserRuleContext {
		public ComContext com() {
			return getRuleContext(ComContext.class,0);
		}
		public TerminalNode EOF() { return getToken(MagiParser.EOF, 0); }
		public MainContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_main; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MagiVisitor ) return ((MagiVisitor<? extends T>)visitor).visitMain(this);
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
			com(0);
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
	public static class ComContext extends ParserRuleContext {
		public ComContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_com; }
	 
		public ComContext() { }
		public void copyFrom(ComContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PrintContext extends ComContext {
		public TerminalNode PRINT() { return getToken(MagiParser.PRINT, 0); }
		public TerminalNode LPAR() { return getToken(MagiParser.LPAR, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(MagiParser.RPAR, 0); }
		public PrintContext(ComContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MagiVisitor ) return ((MagiVisitor<? extends T>)visitor).visitPrint(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class VarContext extends ComContext {
		public TerminalNode VAR() { return getToken(MagiParser.VAR, 0); }
		public TerminalNode ASSIGN() { return getToken(MagiParser.ASSIGN, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public VarContext(ComContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MagiVisitor ) return ((MagiVisitor<? extends T>)visitor).visitVar(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class WhileContext extends ComContext {
		public TerminalNode WHILE() { return getToken(MagiParser.WHILE, 0); }
		public TerminalNode LPAR() { return getToken(MagiParser.LPAR, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(MagiParser.RPAR, 0); }
		public TerminalNode LCUR() { return getToken(MagiParser.LCUR, 0); }
		public ComContext com() {
			return getRuleContext(ComContext.class,0);
		}
		public TerminalNode RCUR() { return getToken(MagiParser.RCUR, 0); }
		public WhileContext(ComContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MagiVisitor ) return ((MagiVisitor<? extends T>)visitor).visitWhile(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IfContext extends ComContext {
		public TerminalNode IF() { return getToken(MagiParser.IF, 0); }
		public TerminalNode LPAR() { return getToken(MagiParser.LPAR, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(MagiParser.RPAR, 0); }
		public TerminalNode LCUR() { return getToken(MagiParser.LCUR, 0); }
		public ComContext com() {
			return getRuleContext(ComContext.class,0);
		}
		public TerminalNode RCUR() { return getToken(MagiParser.RCUR, 0); }
		public IfContext(ComContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MagiVisitor ) return ((MagiVisitor<? extends T>)visitor).visitIf(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IfElseContext extends ComContext {
		public TerminalNode IF() { return getToken(MagiParser.IF, 0); }
		public TerminalNode LPAR() { return getToken(MagiParser.LPAR, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(MagiParser.RPAR, 0); }
		public List<TerminalNode> LCUR() { return getTokens(MagiParser.LCUR); }
		public TerminalNode LCUR(int i) {
			return getToken(MagiParser.LCUR, i);
		}
		public List<ComContext> com() {
			return getRuleContexts(ComContext.class);
		}
		public ComContext com(int i) {
			return getRuleContext(ComContext.class,i);
		}
		public List<TerminalNode> RCUR() { return getTokens(MagiParser.RCUR); }
		public TerminalNode RCUR(int i) {
			return getToken(MagiParser.RCUR, i);
		}
		public TerminalNode ELSE() { return getToken(MagiParser.ELSE, 0); }
		public IfElseContext(ComContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MagiVisitor ) return ((MagiVisitor<? extends T>)visitor).visitIfElse(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SeqContext extends ComContext {
		public List<ComContext> com() {
			return getRuleContexts(ComContext.class);
		}
		public ComContext com(int i) {
			return getRuleContext(ComContext.class,i);
		}
		public TerminalNode SEMICOLON() { return getToken(MagiParser.SEMICOLON, 0); }
		public SeqContext(ComContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MagiVisitor ) return ((MagiVisitor<? extends T>)visitor).visitSeq(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComContext com() throws RecognitionException {
		return com(0);
	}

	private ComContext com(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ComContext _localctx = new ComContext(_ctx, _parentState);
		ComContext _prevctx = _localctx;
		int _startState = 2;
		enterRecursionRule(_localctx, 2, RULE_com, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(46);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				{
				_localctx = new VarContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(10);
				match(VAR);
				setState(11);
				match(ASSIGN);
				setState(12);
				exp(0);
				}
				break;
			case 2:
				{
				_localctx = new IfContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(13);
				match(IF);
				setState(14);
				match(LPAR);
				setState(15);
				exp(0);
				setState(16);
				match(RPAR);
				setState(17);
				match(LCUR);
				setState(18);
				com(0);
				setState(19);
				match(RCUR);
				}
				break;
			case 3:
				{
				_localctx = new IfElseContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(21);
				match(IF);
				setState(22);
				match(LPAR);
				setState(23);
				exp(0);
				setState(24);
				match(RPAR);
				setState(25);
				match(LCUR);
				setState(26);
				com(0);
				setState(27);
				match(RCUR);
				setState(28);
				match(ELSE);
				setState(29);
				match(LCUR);
				setState(30);
				com(0);
				setState(31);
				match(RCUR);
				}
				break;
			case 4:
				{
				_localctx = new WhileContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(33);
				match(WHILE);
				setState(34);
				match(LPAR);
				setState(35);
				exp(0);
				setState(36);
				match(RPAR);
				setState(37);
				match(LCUR);
				setState(38);
				com(0);
				setState(39);
				match(RCUR);
				}
				break;
			case 5:
				{
				_localctx = new PrintContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(41);
				match(PRINT);
				setState(42);
				match(LPAR);
				setState(43);
				exp(0);
				setState(44);
				match(RPAR);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(53);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new SeqContext(new ComContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_com);
					setState(48);
					if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
					setState(49);
					match(SEMICOLON);
					setState(50);
					com(6);
					}
					} 
				}
				setState(55);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
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
	public static class AndOrContext extends ExpContext {
		public Token op;
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public TerminalNode AND() { return getToken(MagiParser.AND, 0); }
		public TerminalNode OR() { return getToken(MagiParser.OR, 0); }
		public AndOrContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MagiVisitor ) return ((MagiVisitor<? extends T>)visitor).visitAndOr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NotContext extends ExpContext {
		public TerminalNode NOT() { return getToken(MagiParser.NOT, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public NotContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MagiVisitor ) return ((MagiVisitor<? extends T>)visitor).visitNot(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ParenContext extends ExpContext {
		public TerminalNode LPAR() { return getToken(MagiParser.LPAR, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(MagiParser.RPAR, 0); }
		public ParenContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MagiVisitor ) return ((MagiVisitor<? extends T>)visitor).visitParen(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class EqExpContext extends ExpContext {
		public Token op;
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public TerminalNode EQ() { return getToken(MagiParser.EQ, 0); }
		public TerminalNode NEQ() { return getToken(MagiParser.NEQ, 0); }
		public EqExpContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MagiVisitor ) return ((MagiVisitor<? extends T>)visitor).visitEqExp(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AccessContext extends ExpContext {
		public TerminalNode VAR() { return getToken(MagiParser.VAR, 0); }
		public AccessContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MagiVisitor ) return ((MagiVisitor<? extends T>)visitor).visitAccess(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BoolContext extends ExpContext {
		public TerminalNode BOOL() { return getToken(MagiParser.BOOL, 0); }
		public BoolContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MagiVisitor ) return ((MagiVisitor<? extends T>)visitor).visitBool(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CmpExpContext extends ExpContext {
		public Token op;
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public TerminalNode LT() { return getToken(MagiParser.LT, 0); }
		public TerminalNode LTE() { return getToken(MagiParser.LTE, 0); }
		public TerminalNode GT() { return getToken(MagiParser.GT, 0); }
		public TerminalNode GTE() { return getToken(MagiParser.GTE, 0); }
		public CmpExpContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MagiVisitor ) return ((MagiVisitor<? extends T>)visitor).visitCmpExp(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class Arith2Context extends ExpContext {
		public Token op;
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public TerminalNode MUL() { return getToken(MagiParser.MUL, 0); }
		public TerminalNode DIV() { return getToken(MagiParser.DIV, 0); }
		public TerminalNode MOD() { return getToken(MagiParser.MOD, 0); }
		public Arith2Context(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MagiVisitor ) return ((MagiVisitor<? extends T>)visitor).visitArith2(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PowContext extends ExpContext {
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public TerminalNode POW() { return getToken(MagiParser.POW, 0); }
		public PowContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MagiVisitor ) return ((MagiVisitor<? extends T>)visitor).visitPow(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class Arith1Context extends ExpContext {
		public Token op;
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public TerminalNode ADD() { return getToken(MagiParser.ADD, 0); }
		public TerminalNode SUB() { return getToken(MagiParser.SUB, 0); }
		public Arith1Context(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MagiVisitor ) return ((MagiVisitor<? extends T>)visitor).visitArith1(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FloatContext extends ExpContext {
		public TerminalNode FLOAT() { return getToken(MagiParser.FLOAT, 0); }
		public FloatContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MagiVisitor ) return ((MagiVisitor<? extends T>)visitor).visitFloat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpContext exp() throws RecognitionException {
		return exp(0);
	}

	private ExpContext exp(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpContext _localctx = new ExpContext(_ctx, _parentState);
		ExpContext _prevctx = _localctx;
		int _startState = 4;
		enterRecursionRule(_localctx, 4, RULE_exp, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(66);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FLOAT:
				{
				_localctx = new FloatContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(57);
				match(FLOAT);
				}
				break;
			case BOOL:
				{
				_localctx = new BoolContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(58);
				match(BOOL);
				}
				break;
			case VAR:
				{
				_localctx = new AccessContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(59);
				match(VAR);
				}
				break;
			case NOT:
				{
				_localctx = new NotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(60);
				match(NOT);
				setState(61);
				exp(2);
				}
				break;
			case LPAR:
				{
				_localctx = new ParenContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(62);
				match(LPAR);
				setState(63);
				exp(0);
				setState(64);
				match(RPAR);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(88);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(86);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
					case 1:
						{
						_localctx = new PowContext(new ExpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(68);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(69);
						match(POW);
						setState(70);
						exp(8);
						}
						break;
					case 2:
						{
						_localctx = new Arith2Context(new ExpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(71);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(72);
						((Arith2Context)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 26624L) != 0)) ) {
							((Arith2Context)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(73);
						exp(8);
						}
						break;
					case 3:
						{
						_localctx = new Arith1Context(new ExpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(74);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(75);
						((Arith1Context)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==ADD || _la==SUB) ) {
							((Arith1Context)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(76);
						exp(7);
						}
						break;
					case 4:
						{
						_localctx = new EqExpContext(new ExpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(77);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(78);
						((EqExpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==EQ || _la==NEQ) ) {
							((EqExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(79);
						exp(6);
						}
						break;
					case 5:
						{
						_localctx = new AndOrContext(new ExpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(80);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(81);
						((AndOrContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==AND || _la==OR) ) {
							((AndOrContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(82);
						exp(5);
						}
						break;
					case 6:
						{
						_localctx = new CmpExpContext(new ExpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(83);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(84);
						((CmpExpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 15728640L) != 0)) ) {
							((CmpExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(85);
						exp(4);
						}
						break;
					}
					} 
				}
				setState(90);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 1:
			return com_sempred((ComContext)_localctx, predIndex);
		case 2:
			return exp_sempred((ExpContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean com_sempred(ComContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 5);
		}
		return true;
	}
	private boolean exp_sempred(ExpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 8);
		case 2:
			return precpred(_ctx, 7);
		case 3:
			return precpred(_ctx, 6);
		case 4:
			return precpred(_ctx, 5);
		case 5:
			return precpred(_ctx, 4);
		case 6:
			return precpred(_ctx, 3);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001 \\\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003"+
		"\u0001/\b\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0005\u00014\b\u0001"+
		"\n\u0001\f\u00017\t\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0003\u0002C\b\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0005\u0002W\b\u0002\n\u0002\f\u0002Z\t\u0002"+
		"\u0001\u0002\u0000\u0002\u0002\u0004\u0003\u0000\u0002\u0004\u0000\u0005"+
		"\u0002\u0000\u000b\u000b\r\u000e\u0002\u0000\n\n\f\f\u0001\u0000\u0012"+
		"\u0013\u0001\u0000\u0018\u0019\u0001\u0000\u0014\u0017g\u0000\u0006\u0001"+
		"\u0000\u0000\u0000\u0002.\u0001\u0000\u0000\u0000\u0004B\u0001\u0000\u0000"+
		"\u0000\u0006\u0007\u0003\u0002\u0001\u0000\u0007\b\u0005\u0000\u0000\u0001"+
		"\b\u0001\u0001\u0000\u0000\u0000\t\n\u0006\u0001\uffff\uffff\u0000\n\u000b"+
		"\u0005\u001d\u0000\u0000\u000b\f\u0005\u001a\u0000\u0000\f/\u0003\u0004"+
		"\u0002\u0000\r\u000e\u0005\u0005\u0000\u0000\u000e\u000f\u0005\u0001\u0000"+
		"\u0000\u000f\u0010\u0003\u0004\u0002\u0000\u0010\u0011\u0005\u0002\u0000"+
		"\u0000\u0011\u0012\u0005\u0003\u0000\u0000\u0012\u0013\u0003\u0002\u0001"+
		"\u0000\u0013\u0014\u0005\u0004\u0000\u0000\u0014/\u0001\u0000\u0000\u0000"+
		"\u0015\u0016\u0005\u0005\u0000\u0000\u0016\u0017\u0005\u0001\u0000\u0000"+
		"\u0017\u0018\u0003\u0004\u0002\u0000\u0018\u0019\u0005\u0002\u0000\u0000"+
		"\u0019\u001a\u0005\u0003\u0000\u0000\u001a\u001b\u0003\u0002\u0001\u0000"+
		"\u001b\u001c\u0005\u0004\u0000\u0000\u001c\u001d\u0005\u0006\u0000\u0000"+
		"\u001d\u001e\u0005\u0003\u0000\u0000\u001e\u001f\u0003\u0002\u0001\u0000"+
		"\u001f \u0005\u0004\u0000\u0000 /\u0001\u0000\u0000\u0000!\"\u0005\u0007"+
		"\u0000\u0000\"#\u0005\u0001\u0000\u0000#$\u0003\u0004\u0002\u0000$%\u0005"+
		"\u0002\u0000\u0000%&\u0005\u0003\u0000\u0000&\'\u0003\u0002\u0001\u0000"+
		"\'(\u0005\u0004\u0000\u0000(/\u0001\u0000\u0000\u0000)*\u0005\b\u0000"+
		"\u0000*+\u0005\u0001\u0000\u0000+,\u0003\u0004\u0002\u0000,-\u0005\u0002"+
		"\u0000\u0000-/\u0001\u0000\u0000\u0000.\t\u0001\u0000\u0000\u0000.\r\u0001"+
		"\u0000\u0000\u0000.\u0015\u0001\u0000\u0000\u0000.!\u0001\u0000\u0000"+
		"\u0000.)\u0001\u0000\u0000\u0000/5\u0001\u0000\u0000\u000001\n\u0005\u0000"+
		"\u000012\u0005\u001b\u0000\u000024\u0003\u0002\u0001\u000630\u0001\u0000"+
		"\u0000\u000047\u0001\u0000\u0000\u000053\u0001\u0000\u0000\u000056\u0001"+
		"\u0000\u0000\u00006\u0003\u0001\u0000\u0000\u000075\u0001\u0000\u0000"+
		"\u000089\u0006\u0002\uffff\uffff\u00009C\u0005\t\u0000\u0000:C\u0005\u0010"+
		"\u0000\u0000;C\u0005\u001d\u0000\u0000<=\u0005\u0011\u0000\u0000=C\u0003"+
		"\u0004\u0002\u0002>?\u0005\u0001\u0000\u0000?@\u0003\u0004\u0002\u0000"+
		"@A\u0005\u0002\u0000\u0000AC\u0001\u0000\u0000\u0000B8\u0001\u0000\u0000"+
		"\u0000B:\u0001\u0000\u0000\u0000B;\u0001\u0000\u0000\u0000B<\u0001\u0000"+
		"\u0000\u0000B>\u0001\u0000\u0000\u0000CX\u0001\u0000\u0000\u0000DE\n\b"+
		"\u0000\u0000EF\u0005\u000f\u0000\u0000FW\u0003\u0004\u0002\bGH\n\u0007"+
		"\u0000\u0000HI\u0007\u0000\u0000\u0000IW\u0003\u0004\u0002\bJK\n\u0006"+
		"\u0000\u0000KL\u0007\u0001\u0000\u0000LW\u0003\u0004\u0002\u0007MN\n\u0005"+
		"\u0000\u0000NO\u0007\u0002\u0000\u0000OW\u0003\u0004\u0002\u0006PQ\n\u0004"+
		"\u0000\u0000QR\u0007\u0003\u0000\u0000RW\u0003\u0004\u0002\u0005ST\n\u0003"+
		"\u0000\u0000TU\u0007\u0004\u0000\u0000UW\u0003\u0004\u0002\u0004VD\u0001"+
		"\u0000\u0000\u0000VG\u0001\u0000\u0000\u0000VJ\u0001\u0000\u0000\u0000"+
		"VM\u0001\u0000\u0000\u0000VP\u0001\u0000\u0000\u0000VS\u0001\u0000\u0000"+
		"\u0000WZ\u0001\u0000\u0000\u0000XV\u0001\u0000\u0000\u0000XY\u0001\u0000"+
		"\u0000\u0000Y\u0005\u0001\u0000\u0000\u0000ZX\u0001\u0000\u0000\u0000"+
		"\u0005.5BVX";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
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
		LPAR=1, RPAR=2, LCUR=3, RCUR=4, IF=5, ELSE=6, WHILE=7, PRINT=8, CONCAT=9, 
		FLOAT=10, ADD=11, MUL=12, SUB=13, DIV=14, MOD=15, POW=16, TYPE=17, BOOL=18, 
		NOT=19, EQ=20, NEQ=21, LT=22, GT=23, LTE=24, GTE=25, AND=26, OR=27, ASSIGN=28, 
		SEMICOLON=29, STRING=30, VAR=31, WS=32, COMMENT=33, LINE_COMMENT=34, NOP=35, 
		INT=36;
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
			"':'", null, "'+'", "'*'", "'-'", "'/'", "'mod'", "'^'", null, null, 
			"'!'", "'=='", "'!='", "'<'", "'>'", "'<='", "'>='", "'&&'", "'||'", 
			"':='", "';'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "LPAR", "RPAR", "LCUR", "RCUR", "IF", "ELSE", "WHILE", "PRINT", 
			"CONCAT", "FLOAT", "ADD", "MUL", "SUB", "DIV", "MOD", "POW", "TYPE", 
			"BOOL", "NOT", "EQ", "NEQ", "LT", "GT", "LTE", "GTE", "AND", "OR", "ASSIGN", 
			"SEMICOLON", "STRING", "VAR", "WS", "COMMENT", "LINE_COMMENT", "NOP", 
			"INT"
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
		public TerminalNode SEMICOLON() { return getToken(MagiParser.SEMICOLON, 0); }
		public PrintContext(ComContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MagiVisitor ) return ((MagiVisitor<? extends T>)visitor).visitPrint(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DeclContext extends ComContext {
		public TerminalNode TYPE() { return getToken(MagiParser.TYPE, 0); }
		public TerminalNode VAR() { return getToken(MagiParser.VAR, 0); }
		public TerminalNode ASSIGN() { return getToken(MagiParser.ASSIGN, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(MagiParser.SEMICOLON, 0); }
		public DeclContext(ComContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MagiVisitor ) return ((MagiVisitor<? extends T>)visitor).visitDecl(this);
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
	public static class NOPContext extends ComContext {
		public TerminalNode NOP() { return getToken(MagiParser.NOP, 0); }
		public NOPContext(ComContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MagiVisitor ) return ((MagiVisitor<? extends T>)visitor).visitNOP(this);
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
		public SeqContext(ComContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MagiVisitor ) return ((MagiVisitor<? extends T>)visitor).visitSeq(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AssignContext extends ComContext {
		public TerminalNode VAR() { return getToken(MagiParser.VAR, 0); }
		public TerminalNode ASSIGN() { return getToken(MagiParser.ASSIGN, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(MagiParser.SEMICOLON, 0); }
		public AssignContext(ComContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MagiVisitor ) return ((MagiVisitor<? extends T>)visitor).visitAssign(this);
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
			setState(56);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				{
				_localctx = new DeclContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(10);
				match(TYPE);
				setState(11);
				match(VAR);
				setState(12);
				match(ASSIGN);
				setState(13);
				exp(0);
				setState(14);
				match(SEMICOLON);
				}
				break;
			case 2:
				{
				_localctx = new AssignContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(16);
				match(VAR);
				setState(17);
				match(ASSIGN);
				setState(18);
				exp(0);
				setState(19);
				match(SEMICOLON);
				}
				break;
			case 3:
				{
				_localctx = new IfContext(_localctx);
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
				}
				break;
			case 4:
				{
				_localctx = new IfElseContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(29);
				match(IF);
				setState(30);
				match(LPAR);
				setState(31);
				exp(0);
				setState(32);
				match(RPAR);
				setState(33);
				match(LCUR);
				setState(34);
				com(0);
				setState(35);
				match(RCUR);
				setState(36);
				match(ELSE);
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
				_localctx = new WhileContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(41);
				match(WHILE);
				setState(42);
				match(LPAR);
				setState(43);
				exp(0);
				setState(44);
				match(RPAR);
				setState(45);
				match(LCUR);
				setState(46);
				com(0);
				setState(47);
				match(RCUR);
				}
				break;
			case 6:
				{
				_localctx = new PrintContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(49);
				match(PRINT);
				setState(50);
				match(LPAR);
				setState(51);
				exp(0);
				setState(52);
				match(RPAR);
				setState(53);
				match(SEMICOLON);
				}
				break;
			case 7:
				{
				_localctx = new NOPContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(55);
				match(NOP);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(62);
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
					setState(58);
					if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
					setState(59);
					com(7);
					}
					} 
				}
				setState(64);
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
	public static class StringContext extends ExpContext {
		public TerminalNode STRING() { return getToken(MagiParser.STRING, 0); }
		public StringContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MagiVisitor ) return ((MagiVisitor<? extends T>)visitor).visitString(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ConcatContext extends ExpContext {
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public TerminalNode CONCAT() { return getToken(MagiParser.CONCAT, 0); }
		public ConcatContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MagiVisitor ) return ((MagiVisitor<? extends T>)visitor).visitConcat(this);
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
	@SuppressWarnings("CheckReturnValue")
	public static class IntContext extends ExpContext {
		public TerminalNode INT() { return getToken(MagiParser.INT, 0); }
		public IntContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MagiVisitor ) return ((MagiVisitor<? extends T>)visitor).visitInt(this);
			else return visitor.visitChildren(this);
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
			setState(77);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FLOAT:
				{
				_localctx = new FloatContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(66);
				match(FLOAT);
				}
				break;
			case INT:
				{
				_localctx = new IntContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(67);
				match(INT);
				}
				break;
			case BOOL:
				{
				_localctx = new BoolContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(68);
				match(BOOL);
				}
				break;
			case STRING:
				{
				_localctx = new StringContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(69);
				match(STRING);
				}
				break;
			case VAR:
				{
				_localctx = new AccessContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(70);
				match(VAR);
				}
				break;
			case NOT:
				{
				_localctx = new NotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(71);
				match(NOT);
				setState(72);
				exp(2);
				}
				break;
			case LPAR:
				{
				_localctx = new ParenContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(73);
				match(LPAR);
				setState(74);
				exp(0);
				setState(75);
				match(RPAR);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(102);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(100);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
					case 1:
						{
						_localctx = new ConcatContext(new ExpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(79);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(80);
						match(CONCAT);
						setState(81);
						exp(11);
						}
						break;
					case 2:
						{
						_localctx = new PowContext(new ExpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(82);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(83);
						match(POW);
						setState(84);
						exp(8);
						}
						break;
					case 3:
						{
						_localctx = new Arith2Context(new ExpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(85);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(86);
						((Arith2Context)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 53248L) != 0)) ) {
							((Arith2Context)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(87);
						exp(8);
						}
						break;
					case 4:
						{
						_localctx = new Arith1Context(new ExpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(88);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(89);
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
						setState(90);
						exp(7);
						}
						break;
					case 5:
						{
						_localctx = new EqExpContext(new ExpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(91);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(92);
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
						setState(93);
						exp(6);
						}
						break;
					case 6:
						{
						_localctx = new AndOrContext(new ExpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(94);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(95);
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
						setState(96);
						exp(5);
						}
						break;
					case 7:
						{
						_localctx = new CmpExpContext(new ExpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(97);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(98);
						((CmpExpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 62914560L) != 0)) ) {
							((CmpExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(99);
						exp(4);
						}
						break;
					}
					} 
				}
				setState(104);
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
			return precpred(_ctx, 6);
		}
		return true;
	}
	private boolean exp_sempred(ExpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 10);
		case 2:
			return precpred(_ctx, 8);
		case 3:
			return precpred(_ctx, 7);
		case 4:
			return precpred(_ctx, 6);
		case 5:
			return precpred(_ctx, 5);
		case 6:
			return precpred(_ctx, 4);
		case 7:
			return precpred(_ctx, 3);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001$j\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002\u0002"+
		"\u0007\u0002\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u00019\b\u0001\u0001\u0001"+
		"\u0001\u0001\u0005\u0001=\b\u0001\n\u0001\f\u0001@\t\u0001\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002"+
		"N\b\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0005\u0002e\b\u0002"+
		"\n\u0002\f\u0002h\t\u0002\u0001\u0002\u0000\u0002\u0002\u0004\u0003\u0000"+
		"\u0002\u0004\u0000\u0005\u0002\u0000\f\f\u000e\u000f\u0002\u0000\u000b"+
		"\u000b\r\r\u0001\u0000\u0014\u0015\u0001\u0000\u001a\u001b\u0001\u0000"+
		"\u0016\u0019z\u0000\u0006\u0001\u0000\u0000\u0000\u00028\u0001\u0000\u0000"+
		"\u0000\u0004M\u0001\u0000\u0000\u0000\u0006\u0007\u0003\u0002\u0001\u0000"+
		"\u0007\b\u0005\u0000\u0000\u0001\b\u0001\u0001\u0000\u0000\u0000\t\n\u0006"+
		"\u0001\uffff\uffff\u0000\n\u000b\u0005\u0011\u0000\u0000\u000b\f\u0005"+
		"\u001f\u0000\u0000\f\r\u0005\u001c\u0000\u0000\r\u000e\u0003\u0004\u0002"+
		"\u0000\u000e\u000f\u0005\u001d\u0000\u0000\u000f9\u0001\u0000\u0000\u0000"+
		"\u0010\u0011\u0005\u001f\u0000\u0000\u0011\u0012\u0005\u001c\u0000\u0000"+
		"\u0012\u0013\u0003\u0004\u0002\u0000\u0013\u0014\u0005\u001d\u0000\u0000"+
		"\u00149\u0001\u0000\u0000\u0000\u0015\u0016\u0005\u0005\u0000\u0000\u0016"+
		"\u0017\u0005\u0001\u0000\u0000\u0017\u0018\u0003\u0004\u0002\u0000\u0018"+
		"\u0019\u0005\u0002\u0000\u0000\u0019\u001a\u0005\u0003\u0000\u0000\u001a"+
		"\u001b\u0003\u0002\u0001\u0000\u001b\u001c\u0005\u0004\u0000\u0000\u001c"+
		"9\u0001\u0000\u0000\u0000\u001d\u001e\u0005\u0005\u0000\u0000\u001e\u001f"+
		"\u0005\u0001\u0000\u0000\u001f \u0003\u0004\u0002\u0000 !\u0005\u0002"+
		"\u0000\u0000!\"\u0005\u0003\u0000\u0000\"#\u0003\u0002\u0001\u0000#$\u0005"+
		"\u0004\u0000\u0000$%\u0005\u0006\u0000\u0000%&\u0005\u0003\u0000\u0000"+
		"&\'\u0003\u0002\u0001\u0000\'(\u0005\u0004\u0000\u0000(9\u0001\u0000\u0000"+
		"\u0000)*\u0005\u0007\u0000\u0000*+\u0005\u0001\u0000\u0000+,\u0003\u0004"+
		"\u0002\u0000,-\u0005\u0002\u0000\u0000-.\u0005\u0003\u0000\u0000./\u0003"+
		"\u0002\u0001\u0000/0\u0005\u0004\u0000\u000009\u0001\u0000\u0000\u0000"+
		"12\u0005\b\u0000\u000023\u0005\u0001\u0000\u000034\u0003\u0004\u0002\u0000"+
		"45\u0005\u0002\u0000\u000056\u0005\u001d\u0000\u000069\u0001\u0000\u0000"+
		"\u000079\u0005#\u0000\u00008\t\u0001\u0000\u0000\u00008\u0010\u0001\u0000"+
		"\u0000\u00008\u0015\u0001\u0000\u0000\u00008\u001d\u0001\u0000\u0000\u0000"+
		"8)\u0001\u0000\u0000\u000081\u0001\u0000\u0000\u000087\u0001\u0000\u0000"+
		"\u00009>\u0001\u0000\u0000\u0000:;\n\u0006\u0000\u0000;=\u0003\u0002\u0001"+
		"\u0007<:\u0001\u0000\u0000\u0000=@\u0001\u0000\u0000\u0000><\u0001\u0000"+
		"\u0000\u0000>?\u0001\u0000\u0000\u0000?\u0003\u0001\u0000\u0000\u0000"+
		"@>\u0001\u0000\u0000\u0000AB\u0006\u0002\uffff\uffff\u0000BN\u0005\n\u0000"+
		"\u0000CN\u0005$\u0000\u0000DN\u0005\u0012\u0000\u0000EN\u0005\u001e\u0000"+
		"\u0000FN\u0005\u001f\u0000\u0000GH\u0005\u0013\u0000\u0000HN\u0003\u0004"+
		"\u0002\u0002IJ\u0005\u0001\u0000\u0000JK\u0003\u0004\u0002\u0000KL\u0005"+
		"\u0002\u0000\u0000LN\u0001\u0000\u0000\u0000MA\u0001\u0000\u0000\u0000"+
		"MC\u0001\u0000\u0000\u0000MD\u0001\u0000\u0000\u0000ME\u0001\u0000\u0000"+
		"\u0000MF\u0001\u0000\u0000\u0000MG\u0001\u0000\u0000\u0000MI\u0001\u0000"+
		"\u0000\u0000Nf\u0001\u0000\u0000\u0000OP\n\n\u0000\u0000PQ\u0005\t\u0000"+
		"\u0000Qe\u0003\u0004\u0002\u000bRS\n\b\u0000\u0000ST\u0005\u0010\u0000"+
		"\u0000Te\u0003\u0004\u0002\bUV\n\u0007\u0000\u0000VW\u0007\u0000\u0000"+
		"\u0000We\u0003\u0004\u0002\bXY\n\u0006\u0000\u0000YZ\u0007\u0001\u0000"+
		"\u0000Ze\u0003\u0004\u0002\u0007[\\\n\u0005\u0000\u0000\\]\u0007\u0002"+
		"\u0000\u0000]e\u0003\u0004\u0002\u0006^_\n\u0004\u0000\u0000_`\u0007\u0003"+
		"\u0000\u0000`e\u0003\u0004\u0002\u0005ab\n\u0003\u0000\u0000bc\u0007\u0004"+
		"\u0000\u0000ce\u0003\u0004\u0002\u0004dO\u0001\u0000\u0000\u0000dR\u0001"+
		"\u0000\u0000\u0000dU\u0001\u0000\u0000\u0000dX\u0001\u0000\u0000\u0000"+
		"d[\u0001\u0000\u0000\u0000d^\u0001\u0000\u0000\u0000da\u0001\u0000\u0000"+
		"\u0000eh\u0001\u0000\u0000\u0000fd\u0001\u0000\u0000\u0000fg\u0001\u0000"+
		"\u0000\u0000g\u0005\u0001\u0000\u0000\u0000hf\u0001\u0000\u0000\u0000"+
		"\u00058>Mdf";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
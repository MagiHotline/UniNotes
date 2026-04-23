// Generated from it/univr/pl/Magi.g4 by ANTLR 4.13.2
package it.univr.pl;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class MagiLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		VAR=1, FLOAT=2, INT=3, DIV=4, WS=5;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"VAR", "LPAR", "RPAR", "ADD", "MUL", "SUB", "FLOAT", "INT", "DIV", "MOD", 
			"POW", "EQUALS", "SEMICOLON", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, "'/'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "VAR", "FLOAT", "INT", "DIV", "WS"
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


	public MagiLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Magi.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000\u0005[\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0001\u0000\u0005\u0000\u001f"+
		"\b\u0000\n\u0000\f\u0000\"\t\u0000\u0001\u0001\u0001\u0001\u0001\u0002"+
		"\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0005"+
		"\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006"+
		"2\b\u0006\u0001\u0006\u0001\u0006\u0004\u00066\b\u0006\u000b\u0006\f\u0006"+
		"7\u0003\u0006:\b\u0006\u0001\u0007\u0001\u0007\u0003\u0007>\b\u0007\u0001"+
		"\u0007\u0001\u0007\u0005\u0007B\b\u0007\n\u0007\f\u0007E\t\u0007\u0003"+
		"\u0007G\b\u0007\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\n\u0001\n\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\r\u0004\rV\b"+
		"\r\u000b\r\f\rW\u0001\r\u0001\r\u0000\u0000\u000e\u0001\u0001\u0003\u0000"+
		"\u0005\u0000\u0007\u0000\t\u0000\u000b\u0000\r\u0002\u000f\u0003\u0011"+
		"\u0004\u0013\u0000\u0015\u0000\u0017\u0000\u0019\u0000\u001b\u0005\u0001"+
		"\u0000\u0005\u0002\u0000AZaz\u0001\u000009\u0001\u0000--\u0001\u00001"+
		"9\u0003\u0000\t\n\r\r  Y\u0000\u0001\u0001\u0000\u0000\u0000\u0000\r\u0001"+
		"\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011\u0001"+
		"\u0000\u0000\u0000\u0000\u001b\u0001\u0000\u0000\u0000\u0001 \u0001\u0000"+
		"\u0000\u0000\u0003#\u0001\u0000\u0000\u0000\u0005%\u0001\u0000\u0000\u0000"+
		"\u0007\'\u0001\u0000\u0000\u0000\t)\u0001\u0000\u0000\u0000\u000b+\u0001"+
		"\u0000\u0000\u0000\r9\u0001\u0000\u0000\u0000\u000fF\u0001\u0000\u0000"+
		"\u0000\u0011H\u0001\u0000\u0000\u0000\u0013J\u0001\u0000\u0000\u0000\u0015"+
		"N\u0001\u0000\u0000\u0000\u0017P\u0001\u0000\u0000\u0000\u0019R\u0001"+
		"\u0000\u0000\u0000\u001bU\u0001\u0000\u0000\u0000\u001d\u001f\u0007\u0000"+
		"\u0000\u0000\u001e\u001d\u0001\u0000\u0000\u0000\u001f\"\u0001\u0000\u0000"+
		"\u0000 \u001e\u0001\u0000\u0000\u0000 !\u0001\u0000\u0000\u0000!\u0002"+
		"\u0001\u0000\u0000\u0000\" \u0001\u0000\u0000\u0000#$\u0005(\u0000\u0000"+
		"$\u0004\u0001\u0000\u0000\u0000%&\u0005)\u0000\u0000&\u0006\u0001\u0000"+
		"\u0000\u0000\'(\u0005+\u0000\u0000(\b\u0001\u0000\u0000\u0000)*\u0005"+
		"*\u0000\u0000*\n\u0001\u0000\u0000\u0000+,\u0005-\u0000\u0000,\f\u0001"+
		"\u0000\u0000\u0000-:\u0003\u000f\u0007\u0000.2\u0003\u000f\u0007\u0000"+
		"/0\u0005-\u0000\u000002\u00050\u0000\u00001.\u0001\u0000\u0000\u00001"+
		"/\u0001\u0000\u0000\u000023\u0001\u0000\u0000\u000035\u0005.\u0000\u0000"+
		"46\u0007\u0001\u0000\u000054\u0001\u0000\u0000\u000067\u0001\u0000\u0000"+
		"\u000075\u0001\u0000\u0000\u000078\u0001\u0000\u0000\u00008:\u0001\u0000"+
		"\u0000\u00009-\u0001\u0000\u0000\u000091\u0001\u0000\u0000\u0000:\u000e"+
		"\u0001\u0000\u0000\u0000;G\u00050\u0000\u0000<>\u0007\u0002\u0000\u0000"+
		"=<\u0001\u0000\u0000\u0000=>\u0001\u0000\u0000\u0000>?\u0001\u0000\u0000"+
		"\u0000?C\u0007\u0003\u0000\u0000@B\u0007\u0001\u0000\u0000A@\u0001\u0000"+
		"\u0000\u0000BE\u0001\u0000\u0000\u0000CA\u0001\u0000\u0000\u0000CD\u0001"+
		"\u0000\u0000\u0000DG\u0001\u0000\u0000\u0000EC\u0001\u0000\u0000\u0000"+
		"F;\u0001\u0000\u0000\u0000F=\u0001\u0000\u0000\u0000G\u0010\u0001\u0000"+
		"\u0000\u0000HI\u0005/\u0000\u0000I\u0012\u0001\u0000\u0000\u0000JK\u0005"+
		"m\u0000\u0000KL\u0005o\u0000\u0000LM\u0005d\u0000\u0000M\u0014\u0001\u0000"+
		"\u0000\u0000NO\u0005^\u0000\u0000O\u0016\u0001\u0000\u0000\u0000PQ\u0005"+
		"=\u0000\u0000Q\u0018\u0001\u0000\u0000\u0000RS\u0005;\u0000\u0000S\u001a"+
		"\u0001\u0000\u0000\u0000TV\u0007\u0004\u0000\u0000UT\u0001\u0000\u0000"+
		"\u0000VW\u0001\u0000\u0000\u0000WU\u0001\u0000\u0000\u0000WX\u0001\u0000"+
		"\u0000\u0000XY\u0001\u0000\u0000\u0000YZ\u0006\r\u0000\u0000Z\u001c\u0001"+
		"\u0000\u0000\u0000\t\u0000 179=CFW\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
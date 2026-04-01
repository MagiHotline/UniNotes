// Generated from PalindromeWords.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link PalindromeWordsParser}.
 */
public interface PalindromeWordsListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link PalindromeWordsParser#main}.
	 * @param ctx the parse tree
	 */
	void enterMain(PalindromeWordsParser.MainContext ctx);
	/**
	 * Exit a parse tree produced by {@link PalindromeWordsParser#main}.
	 * @param ctx the parse tree
	 */
	void exitMain(PalindromeWordsParser.MainContext ctx);
	/**
	 * Enter a parse tree produced by {@link PalindromeWordsParser#pal}.
	 * @param ctx the parse tree
	 */
	void enterPal(PalindromeWordsParser.PalContext ctx);
	/**
	 * Exit a parse tree produced by {@link PalindromeWordsParser#pal}.
	 * @param ctx the parse tree
	 */
	void exitPal(PalindromeWordsParser.PalContext ctx);
}
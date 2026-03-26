// Generated from BinWords.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link BinWordsParser}.
 */
public interface BinWordsListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link BinWordsParser#main}.
	 * @param ctx the parse tree
	 */
	void enterMain(BinWordsParser.MainContext ctx);
	/**
	 * Exit a parse tree produced by {@link BinWordsParser#main}.
	 * @param ctx the parse tree
	 */
	void exitMain(BinWordsParser.MainContext ctx);
	/**
	 * Enter a parse tree produced by {@link BinWordsParser#bin}.
	 * @param ctx the parse tree
	 */
	void enterBin(BinWordsParser.BinContext ctx);
	/**
	 * Exit a parse tree produced by {@link BinWordsParser#bin}.
	 * @param ctx the parse tree
	 */
	void exitBin(BinWordsParser.BinContext ctx);
}
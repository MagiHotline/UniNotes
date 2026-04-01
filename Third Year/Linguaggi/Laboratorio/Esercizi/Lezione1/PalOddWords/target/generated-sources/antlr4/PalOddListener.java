// Generated from PalOdd.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link PalOddParser}.
 */
public interface PalOddListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link PalOddParser#main}.
	 * @param ctx the parse tree
	 */
	void enterMain(PalOddParser.MainContext ctx);
	/**
	 * Exit a parse tree produced by {@link PalOddParser#main}.
	 * @param ctx the parse tree
	 */
	void exitMain(PalOddParser.MainContext ctx);
	/**
	 * Enter a parse tree produced by {@link PalOddParser#pal}.
	 * @param ctx the parse tree
	 */
	void enterPal(PalOddParser.PalContext ctx);
	/**
	 * Exit a parse tree produced by {@link PalOddParser#pal}.
	 * @param ctx the parse tree
	 */
	void exitPal(PalOddParser.PalContext ctx);
}
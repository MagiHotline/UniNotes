// Generated from PalEven.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link PalEvenParser}.
 */
public interface PalEvenListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link PalEvenParser#main}.
	 * @param ctx the parse tree
	 */
	void enterMain(PalEvenParser.MainContext ctx);
	/**
	 * Exit a parse tree produced by {@link PalEvenParser#main}.
	 * @param ctx the parse tree
	 */
	void exitMain(PalEvenParser.MainContext ctx);
	/**
	 * Enter a parse tree produced by {@link PalEvenParser#pal}.
	 * @param ctx the parse tree
	 */
	void enterPal(PalEvenParser.PalContext ctx);
	/**
	 * Exit a parse tree produced by {@link PalEvenParser#pal}.
	 * @param ctx the parse tree
	 */
	void exitPal(PalEvenParser.PalContext ctx);
}
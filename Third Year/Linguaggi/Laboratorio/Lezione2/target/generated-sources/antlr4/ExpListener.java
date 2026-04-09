// Generated from Exp.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ExpParser}.
 */
public interface ExpListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ExpParser#main}.
	 * @param ctx the parse tree
	 */
	void enterMain(ExpParser.MainContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpParser#main}.
	 * @param ctx the parse tree
	 */
	void exitMain(ExpParser.MainContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterExp(ExpParser.ExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitExp(ExpParser.ExpContext ctx);
}
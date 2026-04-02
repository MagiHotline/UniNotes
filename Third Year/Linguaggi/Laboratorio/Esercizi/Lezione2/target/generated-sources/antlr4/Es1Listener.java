// Generated from Es1.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link Es1Parser}.
 */
public interface Es1Listener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link Es1Parser#main}.
	 * @param ctx the parse tree
	 */
	void enterMain(Es1Parser.MainContext ctx);
	/**
	 * Exit a parse tree produced by {@link Es1Parser#main}.
	 * @param ctx the parse tree
	 */
	void exitMain(Es1Parser.MainContext ctx);
	/**
	 * Enter a parse tree produced by {@link Es1Parser#dig}.
	 * @param ctx the parse tree
	 */
	void enterDig(Es1Parser.DigContext ctx);
	/**
	 * Exit a parse tree produced by {@link Es1Parser#dig}.
	 * @param ctx the parse tree
	 */
	void exitDig(Es1Parser.DigContext ctx);
	/**
	 * Enter a parse tree produced by {@link Es1Parser#seq}.
	 * @param ctx the parse tree
	 */
	void enterSeq(Es1Parser.SeqContext ctx);
	/**
	 * Exit a parse tree produced by {@link Es1Parser#seq}.
	 * @param ctx the parse tree
	 */
	void exitSeq(Es1Parser.SeqContext ctx);
}
// Generated from Es2.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link Es2Parser}.
 */
public interface Es2Listener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link Es2Parser#main}.
	 * @param ctx the parse tree
	 */
	void enterMain(Es2Parser.MainContext ctx);
	/**
	 * Exit a parse tree produced by {@link Es2Parser#main}.
	 * @param ctx the parse tree
	 */
	void exitMain(Es2Parser.MainContext ctx);
	/**
	 * Enter a parse tree produced by {@link Es2Parser#dig}.
	 * @param ctx the parse tree
	 */
	void enterDig(Es2Parser.DigContext ctx);
	/**
	 * Exit a parse tree produced by {@link Es2Parser#dig}.
	 * @param ctx the parse tree
	 */
	void exitDig(Es2Parser.DigContext ctx);
	/**
	 * Enter a parse tree produced by {@link Es2Parser#seq}.
	 * @param ctx the parse tree
	 */
	void enterSeq(Es2Parser.SeqContext ctx);
	/**
	 * Exit a parse tree produced by {@link Es2Parser#seq}.
	 * @param ctx the parse tree
	 */
	void exitSeq(Es2Parser.SeqContext ctx);
}
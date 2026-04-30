// Generated from Seq.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SeqParser}.
 */
public interface SeqListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SeqParser#main}.
	 * @param ctx the parse tree
	 */
	void enterMain(SeqParser.MainContext ctx);
	/**
	 * Exit a parse tree produced by {@link SeqParser#main}.
	 * @param ctx the parse tree
	 */
	void exitMain(SeqParser.MainContext ctx);
	/**
	 * Enter a parse tree produced by {@link SeqParser#seq}.
	 * @param ctx the parse tree
	 */
	void enterSeq(SeqParser.SeqContext ctx);
	/**
	 * Exit a parse tree produced by {@link SeqParser#seq}.
	 * @param ctx the parse tree
	 */
	void exitSeq(SeqParser.SeqContext ctx);
}
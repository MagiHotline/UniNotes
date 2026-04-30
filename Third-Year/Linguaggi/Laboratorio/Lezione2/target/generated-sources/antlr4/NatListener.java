// Generated from Nat.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link NatParser}.
 */
public interface NatListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link NatParser#main}.
	 * @param ctx the parse tree
	 */
	void enterMain(NatParser.MainContext ctx);
	/**
	 * Exit a parse tree produced by {@link NatParser#main}.
	 * @param ctx the parse tree
	 */
	void exitMain(NatParser.MainContext ctx);
	/**
	 * Enter a parse tree produced by {@link NatParser#nat}.
	 * @param ctx the parse tree
	 */
	void enterNat(NatParser.NatContext ctx);
	/**
	 * Exit a parse tree produced by {@link NatParser#nat}.
	 * @param ctx the parse tree
	 */
	void exitNat(NatParser.NatContext ctx);
	/**
	 * Enter a parse tree produced by {@link NatParser#seq}.
	 * @param ctx the parse tree
	 */
	void enterSeq(NatParser.SeqContext ctx);
	/**
	 * Exit a parse tree produced by {@link NatParser#seq}.
	 * @param ctx the parse tree
	 */
	void exitSeq(NatParser.SeqContext ctx);
}
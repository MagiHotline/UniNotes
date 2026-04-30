// Generated from Nat.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link NatParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface NatVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link NatParser#main}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMain(NatParser.MainContext ctx);
	/**
	 * Visit a parse tree produced by {@link NatParser#nat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNat(NatParser.NatContext ctx);
	/**
	 * Visit a parse tree produced by {@link NatParser#seq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSeq(NatParser.SeqContext ctx);
}
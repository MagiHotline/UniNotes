// Generated from Es2.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link Es2Parser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface Es2Visitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link Es2Parser#main}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMain(Es2Parser.MainContext ctx);
	/**
	 * Visit a parse tree produced by {@link Es2Parser#dig}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDig(Es2Parser.DigContext ctx);
	/**
	 * Visit a parse tree produced by {@link Es2Parser#seq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSeq(Es2Parser.SeqContext ctx);
}
// Generated from Exp.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ExpParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ExpVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ExpParser#main}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMain(ExpParser.MainContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExp(ExpParser.ExpContext ctx);
}
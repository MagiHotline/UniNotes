// Generated from PalOdd.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link PalOddParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface PalOddVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link PalOddParser#main}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMain(PalOddParser.MainContext ctx);
	/**
	 * Visit a parse tree produced by {@link PalOddParser#pal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPal(PalOddParser.PalContext ctx);
}
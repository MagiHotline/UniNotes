// Generated from PalEven.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link PalEvenParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface PalEvenVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link PalEvenParser#main}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMain(PalEvenParser.MainContext ctx);
	/**
	 * Visit a parse tree produced by {@link PalEvenParser#pal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPal(PalEvenParser.PalContext ctx);
}
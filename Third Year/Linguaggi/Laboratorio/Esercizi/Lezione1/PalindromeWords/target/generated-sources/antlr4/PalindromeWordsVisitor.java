// Generated from PalindromeWords.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link PalindromeWordsParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface PalindromeWordsVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link PalindromeWordsParser#main}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMain(PalindromeWordsParser.MainContext ctx);
	/**
	 * Visit a parse tree produced by {@link PalindromeWordsParser#pal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPal(PalindromeWordsParser.PalContext ctx);
}
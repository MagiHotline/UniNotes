// Generated from Seq.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link SeqParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface SeqVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link SeqParser#main}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMain(SeqParser.MainContext ctx);
	/**
	 * Visit a parse tree produced by {@link SeqParser#seq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSeq(SeqParser.SeqContext ctx);
}
// Generated from it/univr/pl/Magi.g4 by ANTLR 4.13.2
package it.univr.pl;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link MagiParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface MagiVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link MagiParser#main}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMain(MagiParser.MainContext ctx);
	/**
	 * Visit a parse tree produced by the {@code val}
	 * labeled alternative in {@link MagiParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVal(MagiParser.ValContext ctx);
	/**
	 * Visit a parse tree produced by the {@code paren}
	 * labeled alternative in {@link MagiParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParen(MagiParser.ParenContext ctx);
	/**
	 * Visit a parse tree produced by the {@code var}
	 * labeled alternative in {@link MagiParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar(MagiParser.VarContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Access}
	 * labeled alternative in {@link MagiParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAccess(MagiParser.AccessContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arith2}
	 * labeled alternative in {@link MagiParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArith2(MagiParser.Arith2Context ctx);
	/**
	 * Visit a parse tree produced by the {@code pow}
	 * labeled alternative in {@link MagiParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPow(MagiParser.PowContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arith1}
	 * labeled alternative in {@link MagiParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArith1(MagiParser.Arith1Context ctx);
	/**
	 * Visit a parse tree produced by the {@code seq}
	 * labeled alternative in {@link MagiParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSeq(MagiParser.SeqContext ctx);
}
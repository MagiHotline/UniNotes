// Generated from it/univr/pl/IntExp.g4 by ANTLR 4.13.2
package it.univr.pl;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link IntExpParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface IntExpVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link IntExpParser#main}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMain(IntExpParser.MainContext ctx);
	/**
	 * Visit a parse tree produced by the {@code val}
	 * labeled alternative in {@link IntExpParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVal(IntExpParser.ValContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Access}
	 * labeled alternative in {@link IntExpParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAccess(IntExpParser.AccessContext ctx);
	/**
	 * Visit a parse tree produced by the {@code var}
	 * labeled alternative in {@link IntExpParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar(IntExpParser.VarContext ctx);
	/**
	 * Visit a parse tree produced by the {@code seq}
	 * labeled alternative in {@link IntExpParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSeq(IntExpParser.SeqContext ctx);
	/**
	 * Visit a parse tree produced by the {@code add}
	 * labeled alternative in {@link IntExpParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdd(IntExpParser.AddContext ctx);
	/**
	 * Visit a parse tree produced by the {@code mul}
	 * labeled alternative in {@link IntExpParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMul(IntExpParser.MulContext ctx);
	/**
	 * Visit a parse tree produced by the {@code sub}
	 * labeled alternative in {@link IntExpParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSub(IntExpParser.SubContext ctx);
	/**
	 * Visit a parse tree produced by the {@code div}
	 * labeled alternative in {@link IntExpParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDiv(IntExpParser.DivContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MOD}
	 * labeled alternative in {@link IntExpParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMOD(IntExpParser.MODContext ctx);
}
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
	 * Visit a parse tree produced by the {@code print}
	 * labeled alternative in {@link MagiParser#com}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrint(MagiParser.PrintContext ctx);
	/**
	 * Visit a parse tree produced by the {@code decl}
	 * labeled alternative in {@link MagiParser#com}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecl(MagiParser.DeclContext ctx);
	/**
	 * Visit a parse tree produced by the {@code while}
	 * labeled alternative in {@link MagiParser#com}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhile(MagiParser.WhileContext ctx);
	/**
	 * Visit a parse tree produced by the {@code if}
	 * labeled alternative in {@link MagiParser#com}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf(MagiParser.IfContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ifElse}
	 * labeled alternative in {@link MagiParser#com}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfElse(MagiParser.IfElseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NOP}
	 * labeled alternative in {@link MagiParser#com}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNOP(MagiParser.NOPContext ctx);
	/**
	 * Visit a parse tree produced by the {@code seq}
	 * labeled alternative in {@link MagiParser#com}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSeq(MagiParser.SeqContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assign}
	 * labeled alternative in {@link MagiParser#com}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign(MagiParser.AssignContext ctx);
	/**
	 * Visit a parse tree produced by the {@code access}
	 * labeled alternative in {@link MagiParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAccess(MagiParser.AccessContext ctx);
	/**
	 * Visit a parse tree produced by the {@code bool}
	 * labeled alternative in {@link MagiParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBool(MagiParser.BoolContext ctx);
	/**
	 * Visit a parse tree produced by the {@code string}
	 * labeled alternative in {@link MagiParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitString(MagiParser.StringContext ctx);
	/**
	 * Visit a parse tree produced by the {@code concat}
	 * labeled alternative in {@link MagiParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConcat(MagiParser.ConcatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code float}
	 * labeled alternative in {@link MagiParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFloat(MagiParser.FloatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code int}
	 * labeled alternative in {@link MagiParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInt(MagiParser.IntContext ctx);
	/**
	 * Visit a parse tree produced by the {@code andOr}
	 * labeled alternative in {@link MagiParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndOr(MagiParser.AndOrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code not}
	 * labeled alternative in {@link MagiParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNot(MagiParser.NotContext ctx);
	/**
	 * Visit a parse tree produced by the {@code paren}
	 * labeled alternative in {@link MagiParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParen(MagiParser.ParenContext ctx);
	/**
	 * Visit a parse tree produced by the {@code eqExp}
	 * labeled alternative in {@link MagiParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqExp(MagiParser.EqExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code cmpExp}
	 * labeled alternative in {@link MagiParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmpExp(MagiParser.CmpExpContext ctx);
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
}
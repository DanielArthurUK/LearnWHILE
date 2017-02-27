// Generated from While.g4 by ANTLR 4.6

	package uk.danielarthur.learnwhile.interpreter;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link WhileParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface WhileVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link WhileParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(WhileParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link WhileParser#progName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgName(WhileParser.ProgNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link WhileParser#readVar}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReadVar(WhileParser.ReadVarContext ctx);
	/**
	 * Visit a parse tree produced by {@link WhileParser#writeVar}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWriteVar(WhileParser.WriteVarContext ctx);
	/**
	 * Visit a parse tree produced by {@link WhileParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExp(WhileParser.ExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link WhileParser#nil}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNil(WhileParser.NilContext ctx);
	/**
	 * Visit a parse tree produced by {@link WhileParser#cons}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCons(WhileParser.ConsContext ctx);
	/**
	 * Visit a parse tree produced by {@link WhileParser#hd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHd(WhileParser.HdContext ctx);
	/**
	 * Visit a parse tree produced by {@link WhileParser#tl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTl(WhileParser.TlContext ctx);
	/**
	 * Visit a parse tree produced by {@link WhileParser#bracketedExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBracketedExp(WhileParser.BracketedExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link WhileParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(WhileParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link WhileParser#stmtList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmtList(WhileParser.StmtListContext ctx);
	/**
	 * Visit a parse tree produced by {@link WhileParser#elseBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElseBlock(WhileParser.ElseBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link WhileParser#command}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommand(WhileParser.CommandContext ctx);
	/**
	 * Visit a parse tree produced by {@link WhileParser#assign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign(WhileParser.AssignContext ctx);
	/**
	 * Visit a parse tree produced by {@link WhileParser#whileLoop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileLoop(WhileParser.WhileLoopContext ctx);
	/**
	 * Visit a parse tree produced by {@link WhileParser#ifElse}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfElse(WhileParser.IfElseContext ctx);
	/**
	 * Visit a parse tree produced by {@link WhileParser#ifStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(WhileParser.IfStatementContext ctx);
}
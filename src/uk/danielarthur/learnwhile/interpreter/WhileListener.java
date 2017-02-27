// Generated from While.g4 by ANTLR 4.6

	package uk.danielarthur.learnwhile.interpreter;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link WhileParser}.
 */
public interface WhileListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link WhileParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(WhileParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link WhileParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(WhileParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link WhileParser#progName}.
	 * @param ctx the parse tree
	 */
	void enterProgName(WhileParser.ProgNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link WhileParser#progName}.
	 * @param ctx the parse tree
	 */
	void exitProgName(WhileParser.ProgNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link WhileParser#readVar}.
	 * @param ctx the parse tree
	 */
	void enterReadVar(WhileParser.ReadVarContext ctx);
	/**
	 * Exit a parse tree produced by {@link WhileParser#readVar}.
	 * @param ctx the parse tree
	 */
	void exitReadVar(WhileParser.ReadVarContext ctx);
	/**
	 * Enter a parse tree produced by {@link WhileParser#writeVar}.
	 * @param ctx the parse tree
	 */
	void enterWriteVar(WhileParser.WriteVarContext ctx);
	/**
	 * Exit a parse tree produced by {@link WhileParser#writeVar}.
	 * @param ctx the parse tree
	 */
	void exitWriteVar(WhileParser.WriteVarContext ctx);
	/**
	 * Enter a parse tree produced by {@link WhileParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterExp(WhileParser.ExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link WhileParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitExp(WhileParser.ExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link WhileParser#nil}.
	 * @param ctx the parse tree
	 */
	void enterNil(WhileParser.NilContext ctx);
	/**
	 * Exit a parse tree produced by {@link WhileParser#nil}.
	 * @param ctx the parse tree
	 */
	void exitNil(WhileParser.NilContext ctx);
	/**
	 * Enter a parse tree produced by {@link WhileParser#cons}.
	 * @param ctx the parse tree
	 */
	void enterCons(WhileParser.ConsContext ctx);
	/**
	 * Exit a parse tree produced by {@link WhileParser#cons}.
	 * @param ctx the parse tree
	 */
	void exitCons(WhileParser.ConsContext ctx);
	/**
	 * Enter a parse tree produced by {@link WhileParser#hd}.
	 * @param ctx the parse tree
	 */
	void enterHd(WhileParser.HdContext ctx);
	/**
	 * Exit a parse tree produced by {@link WhileParser#hd}.
	 * @param ctx the parse tree
	 */
	void exitHd(WhileParser.HdContext ctx);
	/**
	 * Enter a parse tree produced by {@link WhileParser#tl}.
	 * @param ctx the parse tree
	 */
	void enterTl(WhileParser.TlContext ctx);
	/**
	 * Exit a parse tree produced by {@link WhileParser#tl}.
	 * @param ctx the parse tree
	 */
	void exitTl(WhileParser.TlContext ctx);
	/**
	 * Enter a parse tree produced by {@link WhileParser#bracketedExp}.
	 * @param ctx the parse tree
	 */
	void enterBracketedExp(WhileParser.BracketedExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link WhileParser#bracketedExp}.
	 * @param ctx the parse tree
	 */
	void exitBracketedExp(WhileParser.BracketedExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link WhileParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(WhileParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link WhileParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(WhileParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link WhileParser#stmtList}.
	 * @param ctx the parse tree
	 */
	void enterStmtList(WhileParser.StmtListContext ctx);
	/**
	 * Exit a parse tree produced by {@link WhileParser#stmtList}.
	 * @param ctx the parse tree
	 */
	void exitStmtList(WhileParser.StmtListContext ctx);
	/**
	 * Enter a parse tree produced by {@link WhileParser#elseBlock}.
	 * @param ctx the parse tree
	 */
	void enterElseBlock(WhileParser.ElseBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link WhileParser#elseBlock}.
	 * @param ctx the parse tree
	 */
	void exitElseBlock(WhileParser.ElseBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link WhileParser#command}.
	 * @param ctx the parse tree
	 */
	void enterCommand(WhileParser.CommandContext ctx);
	/**
	 * Exit a parse tree produced by {@link WhileParser#command}.
	 * @param ctx the parse tree
	 */
	void exitCommand(WhileParser.CommandContext ctx);
	/**
	 * Enter a parse tree produced by {@link WhileParser#assign}.
	 * @param ctx the parse tree
	 */
	void enterAssign(WhileParser.AssignContext ctx);
	/**
	 * Exit a parse tree produced by {@link WhileParser#assign}.
	 * @param ctx the parse tree
	 */
	void exitAssign(WhileParser.AssignContext ctx);
	/**
	 * Enter a parse tree produced by {@link WhileParser#whileLoop}.
	 * @param ctx the parse tree
	 */
	void enterWhileLoop(WhileParser.WhileLoopContext ctx);
	/**
	 * Exit a parse tree produced by {@link WhileParser#whileLoop}.
	 * @param ctx the parse tree
	 */
	void exitWhileLoop(WhileParser.WhileLoopContext ctx);
	/**
	 * Enter a parse tree produced by {@link WhileParser#ifElse}.
	 * @param ctx the parse tree
	 */
	void enterIfElse(WhileParser.IfElseContext ctx);
	/**
	 * Exit a parse tree produced by {@link WhileParser#ifElse}.
	 * @param ctx the parse tree
	 */
	void exitIfElse(WhileParser.IfElseContext ctx);
	/**
	 * Enter a parse tree produced by {@link WhileParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(WhileParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link WhileParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(WhileParser.IfStatementContext ctx);
}
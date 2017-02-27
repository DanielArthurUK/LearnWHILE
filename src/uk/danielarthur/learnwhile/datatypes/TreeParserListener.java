// Generated from TreeParser.g4 by ANTLR 4.6

	package uk.danielarthur.learnwhile.datatypes;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link TreeParserParser}.
 */
public interface TreeParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link TreeParserParser#binaryTree}.
	 * @param ctx the parse tree
	 */
	void enterBinaryTree(TreeParserParser.BinaryTreeContext ctx);
	/**
	 * Exit a parse tree produced by {@link TreeParserParser#binaryTree}.
	 * @param ctx the parse tree
	 */
	void exitBinaryTree(TreeParserParser.BinaryTreeContext ctx);
	/**
	 * Enter a parse tree produced by {@link TreeParserParser#nil}.
	 * @param ctx the parse tree
	 */
	void enterNil(TreeParserParser.NilContext ctx);
	/**
	 * Exit a parse tree produced by {@link TreeParserParser#nil}.
	 * @param ctx the parse tree
	 */
	void exitNil(TreeParserParser.NilContext ctx);
}
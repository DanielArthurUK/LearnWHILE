// Generated from TreeParser.g4 by ANTLR 4.6

	package uk.danielarthur.learnwhile.datatypes;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link TreeParserParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface TreeParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link TreeParserParser#binaryTree}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryTree(TreeParserParser.BinaryTreeContext ctx);
	/**
	 * Visit a parse tree produced by {@link TreeParserParser#nil}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNil(TreeParserParser.NilContext ctx);
}
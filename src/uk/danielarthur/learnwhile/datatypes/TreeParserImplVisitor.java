package uk.danielarthur.learnwhile.datatypes;

/**
 * Visitor that generates a BinaryTree AST from the Antlr4 generated lexer and parser.
 * @author Daniel Arthur
 * @version February 2017
 * @see uk.danielarthur.learnwhile.datatypes.BinaryTree
 */
public class TreeParserImplVisitor extends TreeParserBaseVisitor<BinaryTree> {
    @Override
    public BinaryTree visitBinaryTree(TreeParserParser.BinaryTreeContext ctx){
        if(ctx.nil() == null) {
            return new BinaryTree(visitBinaryTree(ctx.binaryTree(0)), visitBinaryTree(ctx.binaryTree(1)));
        }
        else {
            return new BinaryTree();
        }
    }
}

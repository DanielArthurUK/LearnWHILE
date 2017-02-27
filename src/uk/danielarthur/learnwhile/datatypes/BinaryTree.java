package uk.danielarthur.learnwhile.datatypes;

import java.util.ArrayList;
import java.util.List;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
/**
 * The BinaryTree class is an abstract datatype that represents a BinaryTree that is compatible
 * with WHILE programs. Much like a normal Binary Tree, nodes may have either zero or two
 * children. In WHILE programs, parent nodes are not allowed values. Leaf nodes are called atoms
 * and can only have the value 'nil'.
 * 
 * @author Daniel Arthur
 * @version February 2017
 */
public class BinaryTree {
    
    private BinaryTree left;
    private BinaryTree right;
    
    /**
     * Flag returned by the bool() method that indicates a tree can be decoded as boolean TRUE.
     * @see bool()
     */
    public static final int BOOL_TRUE = 1;
    
    /**
     * Flag returned by the bool() method that indicates a tree can be decoded as boolean FALSE.
     * @see bool()
     */
    public static final int BOOL_FALSE = 0;
    
    /**
     * Flag returned by the bool() method that indicates a tree cannot be decoded as a boolean value.
     * @see bool()
     */
    public static final int BOOL_CANNOT_BE_DECODED = -1;
    
    /**
     * Flag returned by the natural() method that indicates a tree cannot be decoded as a natural number.
     * @see natural()
     */
    public static final int NATURAL_CANNOT_BE_DECODED = -1;
    
    private static final String nil = "nil";
    
    /**
     * Constructs an empty binary tree with one 'nil' atom.
     */
    public BinaryTree() {}
    
    /**
     * Constructs a binary tree with two children left and right.
     * @param left The left side of the binary tree to construct (or head).
     * @param right The right side of the binary tree to construct (or tail). 
     */
    public BinaryTree(BinaryTree left, BinaryTree right) {
        this.left = left;
        this.right = right;
    }
    
    /**
     * Returns the head (left) of the Binary Tree.
     * @return The head of this binary tree.
     */
    public BinaryTree head() {
        return this.isNil() ? new BinaryTree() : left;
    }
    
    /**
     * Returns the tail (right) of the Binary Tree.
     * @return The tail of this binary tree.
     */
    public BinaryTree tail() {
        return this.isNil() ? new BinaryTree() : right;
    }
    
    /**
     * A method to indicate whether a binary tree has any nodes or is just empty.
     * @return True if this binary tree is an empty binary tree with one atom, false otherwise. 
     */
    public boolean isNil() {
        return left == null && right == null;
    }
    
    /**
     * Returns a natural number if this tree encodes one, or returns NATURAL_CANNOT_BE_DECODED otherwise.
     * @return A natural number if one can be decoded, NATURAL_CANNOT_BE_DECODED otherwise.
     * @see NATURAL_CANNOT_BE_DECODED
     */
    public int natural() {
        if(this.isNil()) {
            return 0;
        }
        else {
            int num = 0;
            BinaryTree toDo = this;
            while(!toDo.isNil()) {
                if(toDo.head().isNil()) {
                    toDo = toDo.tail();
                    num++;
                }
                else {
                    return -1;
                }
            }
            return num;
        }
    }
    
    /**
     * Returns a boolean representation of this Binary Tree.
     * @return BOOL_TRUE if this tree represents true, BOOL_FALSE if it represents false or BOOL_CANNOT_BE_DECODED if a boolean value cannot be decoded
     * @see BOOL_TRUE
     * @see BOOL_FALSE
     * @see BOOL_CANNOT_BE_DECODED
     */
    public int bool() {
        if(isNil()) {
            return BOOL_FALSE;
        }
        else if (head().isNil() && tail().isNil()) {
            return BOOL_TRUE;
        }
        else {
            return BOOL_CANNOT_BE_DECODED;
        }
    }
    
    /**
     * Generates a binary tree that represents a natural number.
     * @param n The natural number to be encoded as a binary tree.
     * @return A binary tree encoding of n.
     */
    public static BinaryTree generateNatural(int n) {
        if(n <= 0) {
            return new BinaryTree();
        }
        else {
            BinaryTree tree = new BinaryTree();
            for(int i = 0; i < n; i++) {
                tree = new BinaryTree(new BinaryTree(), tree);
            }
            return tree;
        }
    }
    
    /**
     * Generates a binary tree that encodes the input as a list of trees.
     * @param list The list of Binary Trees to be encoded as a single tree.
     * @return A single binary tree representing each of the trees in list as a list.
     */
    public static BinaryTree generateList(BinaryTree[] list) {
        if(list.length == 0) { 
            return new BinaryTree();
        }
        else {
            BinaryTree result = new BinaryTree(list[list.length - 1], new BinaryTree());
            for(int i = list.length-2; i >= 0; i--) {
                result = new BinaryTree(list[i], result);
            }
            return result;
        }
    }
    
    /**
     * Parses a binary tree from a String input in the form of &lt;<i>left</i>.<i>right</i>&rt;
     * @param treeDef The string to be parsed as a binary tree.
     * @return A binary tree representing the definition given as treeDef.
     * @throws InvalidTreeDefinitionException Thrown if a tree cannot be parsed from the input.
     */
    public static BinaryTree parseBinaryTree (String treeDef) throws InvalidTreeDefinitionException {
        try {
            return generateNatural(Integer.parseUnsignedInt(treeDef));
        } catch(NumberFormatException ex) {
            CharStream stream = new ANTLRInputStream(treeDef);
            TreeParserLexer lexer = new TreeParserLexer(stream);
            TokenStream tokens = new CommonTokenStream(lexer);
            TreeParserParser parser = new TreeParserParser(tokens);
            ParseTree tree = parser.binaryTree();
            TreeParserImplVisitor visitor = new TreeParserImplVisitor();
            return visitor.visit(tree);
        }
    }
    
    /**
     * Create a nested java.util.List of natural numbers from a Binary Tree
     * @param tree The binary tree to be converted as a list
     * @return A nested list of natural numbers.
     * @see java.util.List
     */
    public static List<Object> naturalList(BinaryTree tree) {
        ArrayList<Object> list = new ArrayList<>();
        BinaryTree toDo = tree;
        while(!toDo.isNil()) {
            BinaryTree item = toDo.head();
            if(item.natural() == -1) {
                list.add(naturalList(item));
            }
            else {
                list.add(item.natural());
            }
            toDo = toDo.tail();
        }
        return list;
    }
    
    /**
     * Converts a nested java.util.List of natural numbers to a String.
     * @param list The nested list to be translated to a String
     * @return A String representation of the nested list.
     * @see java.util.List
     */
    public static String natListToString(List<Object> list) {
        if(list.isEmpty()) {
            return "[]";
        }
        else if(list.size() == 1) {
            if(list.get(0) instanceof Integer) {
                return "["+list.get(0)+"]";
            }
            else {
                return "["+natListToString((ArrayList<Object>) list.get(0))+"]";
            }
        }
        else {
            String listRep = "[";
            for(int i = 0; i < list.size() - 1; i++) {
                if(list.get(i) instanceof Integer) {
                    listRep += list.get(i);
                }
                else {
                    listRep += natListToString((ArrayList<Object>) list.get(i));
                }
                listRep += ", ";
            }
            if(list.get(list.size() - 1) instanceof Integer) {
                listRep += list.get(list.size() - 1);
            }
            else {
                listRep += natListToString((ArrayList<Object>) list.get(list.size() - 1));
            }
            listRep += "]";
            return listRep;
        }
    }
    
    @Override
    public String toString() {
        if(left == null && right == null) {
            return nil;
        }
        else {
            return "<"+left.toString()+"."+right.toString()+">";
        }
    }
}

package uk.danielarthur.learnwhile.interpreter;

import java.util.HashMap;
import uk.danielarthur.learnwhile.datatypes.BinaryTree;

/**
 * Represents the Store for a WHILE Program. It holds BinaryTrees as values and can be referenced by Variables.
 * @author Daniel Arthur
 * @version February 2017
 * @see java.util.HashMap
 */
public class Store extends HashMap<Variable,BinaryTree> {
    
    /**
     * Create a new empty store.
     */
    public Store () {
        super();
    }
    
    /**
     * Get a BinaryTree from the store.
     * @param key The Variable to be accessed in the store.
     * @return The Variable's value in the store if it exists. If it doesn't exist, then an empty Binary Tree is returned.
     */
    @Override
    public BinaryTree get(Object key) {
        BinaryTree bt = super.get((Variable) key);
        if(bt != null) {
            return bt;
        }
        else {
            BinaryTree empty = new BinaryTree();
            put((Variable) key, empty);
            return empty;
        }
    }
    
}

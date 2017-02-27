package uk.danielarthur.learnwhile.interpreter;

import java.io.File;
import java.io.IOException;
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import uk.danielarthur.learnwhile.datatypes.BinaryTree;

/**
 * The interpreter class takes a String or File of WHILE code, compiles it upon construction and then interprets it.
 * @author Daniel Arthur
 * @version February 2017
 */
public class Interpreter {
    
    private Program ast;
    
    /**
     * Create a new Interpreter from a String of WHILE code.
     * @param whileCode The code to compile.
     */
    public Interpreter(String whileCode) {
        this((CharStream) new ANTLRInputStream(whileCode));
    }
    
    /**
     * Create a new interpreter from a File of WHILE code.
     * @param whileFile The file containing the WHILE code to be compiled.
     * @throws IOException Thrown if an error occurs whilst reading the file.
     */
    public Interpreter(File whileFile) throws IOException {
        this((CharStream) new ANTLRFileStream(whileFile.getAbsolutePath()));
    }
    
    private Interpreter(CharStream stream) {
        WhileLexer lexer = new WhileLexer(stream);
        TokenStream tokens = new CommonTokenStream(lexer);
        WhileParser parser = new WhileParser(tokens);
        ParseTree tree = parser.program();
        ProgramVisitor visitor = new ProgramVisitor();
        ast = (Program) visitor.visit(tree);
    }
    
    /**
     * Interpret the WHILE code using the given input, and return a BinaryTree as output.
     * @param input The input or 'read' variable for the program.
     * @return The output tree from the 'write' variable of the program.
     */
    public BinaryTree run(BinaryTree input) {
        
        Store store = new Store();
        store.put(ast.getReadVar(), input);
        
        evaluateBlock(ast.getBlock(), store);        
        
        return store.get(ast.getWriteVar());
    }
    
    /**
     * Returns the AST of the program
     * @return The Abstract Syntax Tree (AST) of the WHILE program
     * @see uk.danielarthur.learnwhile.interpreter.Program
     */
    public Program getAST() {
        return ast;
    }
    
    private void evaluateAssign(Assign assign, Store store) {
        Variable var = assign.getVar();
        Expression exp = assign.getExpression();
        
        BinaryTree tree = evaluateExpression(exp, store);
        store.put(var, tree);
    }
    
    private void evaluateWhile(While w, Store store) {
        Expression exp = w.getCondition();
        Block body = w.getBlock();
        
        BinaryTree condition = evaluateExpression(exp, store);
        
        if(!condition.isNil()) {
            evaluateBlock(body, store);
            condition = evaluateExpression(exp, store);
        }
    }
    
    private void evaluateIf(If i, Store store) {
        Expression exp = i.getCondition();
        Block body = i.getBlock();
        
        BinaryTree condition = evaluateExpression(exp, store);
        
        if(!condition.isNil()) {
            evaluateBlock(body, store);
        }
    }
    
    private void evaluateIfElse(IfElse ie, Store store) {
        Expression exp = ie.getCondition();
        Block body = ie.getBlock();
        Block elseBody = ie.getElseBlock();
        
        BinaryTree condition = evaluateExpression(exp, store);
        
        if(!condition.isNil()) {
            evaluateBlock(body, store);
        }
        else {
            evaluateBlock(elseBody, store);
        }
    }
    
    private void evaluateBlock (Block body, Store store) {
        evaluateStatementList(body.getStatementList(), store);
    }
 
    private void evaluateStatementList(StatementList stmtList, Store store) {
        Command head = stmtList.getHead();
        StatementList tail = stmtList.getTail();
        
        evaluateCommand(head, store);
        
        if(tail != null) {
            evaluateStatementList(tail, store);
        }
        
    }
    
    private void evaluateCommand (Command command, Store store) {
        if(command instanceof Assign) {
            evaluateAssign((Assign) command, store);
        }
        else if(command instanceof While) {
            evaluateWhile((While) command, store);
        }
        else if(command instanceof If) {
            evaluateIf((If) command, store);
        }
        else if(command instanceof IfElse) {
            evaluateIfElse((IfElse) command, store);
        }
    }
    
    private BinaryTree evaluateExpression(Expression exp, Store store) {
        if(exp instanceof Variable) {
            return store.get((Variable) exp);
        }
        else if(exp instanceof Nil) {
            return new BinaryTree();
        }
        else if(exp instanceof Cons) {
            Expression left = ((Cons) exp).getLeft();
            Expression right = ((Cons) exp).getRight();
            
            BinaryTree treeLeft = evaluateExpression(left, store);
            BinaryTree treeRight = evaluateExpression(right, store);
            
            return new BinaryTree(treeLeft, treeRight);
        }
        else if(exp instanceof Hd) {
            BinaryTree tree = evaluateExpression(((Hd) exp).getExp(), store);
            return tree.head();
        }
        else if(exp instanceof Tl) {
            BinaryTree tree = evaluateExpression(((Tl) exp).getExp(), store);
            return tree.tail();
        }
        else {
            return null;
        }
    }
}
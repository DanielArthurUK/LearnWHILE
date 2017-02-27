package uk.danielarthur.learnwhile.interpreter;

import java.util.Objects;

/**
 * The Program class represents the uppermost node of the Abstract Syntax Tree for WHILE Programs in LearnWHILE.
 * @author Daniel Arthur
 * @version February 2017
 */
public class Program extends ASTNode {
    private Variable progName;
    private Variable readVar;
    private Block block;
    private Variable writeVar;
    
    /**
     * Construct a new program
     * @param progName The variable that is the name of the program
     * @param readVar The 'read' or input variable of the program.
     * @param block The block of instructions to execute within the program.
     * @param writeVar The 'write' or output variable of the program.
     */
    public Program(Variable progName, Variable readVar, Block block, Variable writeVar) {
        this.progName = progName;
        this.readVar = readVar;
        this.block = block;
        this.writeVar = writeVar;
    }
    
    /**
     * Get the program name Variable
     * @return The program name Variable
     */
    public Variable getProgramName() {
        return progName;
    }
    
    /**
     * Get the read Variable
     * @return The read Variable
     */
    public Variable getReadVar() {
        return readVar;
    }
    
    /**
     * Get the program body
     * @return The program body Block
     */
    public Block getBlock() {
        return block;
    }
    
    /**
     * Get the write Variable
     * @return The write Variable
     */
    public Variable getWriteVar() {
        return writeVar;
    }
    
    @Override
    public String toString() {
        return "Program: "+progName.toString()+"\n"+
                "Read: "+readVar.getVarName()+"\n"+
                "Block: \n"+
                indent(block.toString())+"\n"+
                "Write: "+writeVar.getVarName();
    }
}

/**
 * The ASTNode that represents a list of statements within a program's body.
 * @author Daniel Arthur
 * @version February 2017
 */
class Block extends ASTNode {
    private StatementList stmtList;
    
    /**
     * Create a new Block with a list of Statements
     * @param stmtList The list of Statements within the program Block.
     */
    public Block(StatementList stmtList) {
        this.stmtList = stmtList;
    }
    
    /**
     * Create an empty block
     */
    public Block() {
        stmtList = null;
    }
    
    /**
     * Get the list of statements encapsulated by this block.
     * @return 
     */
    public StatementList getStatementList() {
        return stmtList;
    }
    
    @Override
    public String toString() {
        if(stmtList == null) {
            return "";
        }
        else {
            return stmtList.toString();
        }
    }
}

/**
 * This StatementList class holds a list of executable commands for a WHILE program.
 * @author Daniel Arthur
 * @version February 2017
 */
class StatementList extends ASTNode {
    private Command head;
    private StatementList tail;
    
    /**
     * Create a new statement list with a first command and a statement list of other commands.
     * @param head
     * @param tail 
     */
    public StatementList(Command head, StatementList tail) {
        this.head = head;
        this.tail = tail;
    }
    
    /**
     * Get the first command of this statement list.
     * @return The first command of this statement list.
     */
    public Command getHead() {
        return head;
    }
    
    /**
     * Get the rest of the commands of this statement list.
     * @return The rest of the statement list.
     */
    public StatementList getTail() {
        return tail;
    }
    
    @Override
    public String toString() {
        String s = head.toString();
        if(tail != null) {
            s += "\n"+tail.toString();
        }
        return s;
    }
}

/**
 * Abstract class for all AST nodes
 * @author Daniel Arthur
 * @version February 2017
 */
abstract class ASTNode {
    
    /**
     * Indent a string by one tab space
     * @param s The string to indent
     * @return Indented version of s
     */
    public static String indent(String s) {
        return "\t"+s;
    }
}

/**
 * Abstract class representing all Commands
 * @author Daniel Arthur
 * @version February 2017
 */
abstract class Command extends ASTNode {}

/**
 * Abstract class representing all Expressions
 * @author Daniel Arthur
 * @version February
 */
abstract class Expression extends ASTNode {}

/**
 * Class representing the assignment command
 * @author Daniel Arthur
 * @version February 2017
 */
class Assign extends Command {
    private Variable var;
    private Expression exp;
    
    /**
     * Create a new assignment (assign Expression exp to Variable var)
     * @param var The variable to assign
     * @param exp The expression to assign to var
     */
    public Assign(Variable var, Expression exp) {
        this.var = var;
        this.exp = exp;
    }
    
    /**
     * Get the variable to be assigned
     * @return The variable to be assigned
     */
    public Variable getVar() {
        return var;
    }
    
    /**
     * Get the expression
     * @return The expression
     */
    public Expression getExpression() {
        return exp;
    }
    
    @Override
    public String toString() {
        return var.toString()+" := "+exp.toString();
    }
}

/**
 * Class representing a while loop
 * @author Daniel Arthur
 * @version February 2017
 */
class While extends Command {
    private Expression condition;
    private Block block;
    
    /**
     * Create a while loop
     * @param condition The condition of the while loop
     * @param block The body of the while loop
     */
    public While(Expression condition, Block block) {
        this.condition = condition;
        this.block = block;
    }
    
    /**
     * Get the condition of the loop
     * @return The condition of the loop
     */
    public Expression getCondition() {
        return condition;
    }
    
    /**
     * Get the body of the loop
     * @return The body of the loop
     */
    public Block getBlock() {
        return block;
    }
    
    @Override
    public String toString() {
        return "while "+condition.toString()+": \n"+
                indent(block.toString());
    }
    
}

/**
 * Class representing an If statement
 * @author Daniel Arthur
 * @version February 2017
 */
class If extends Command {
    private Expression condition;
    private Block block;
    
    /**
     * Create a new If statement
     * @param condition The condition of the if
     * @param block The body of the if
     */
    public If(Expression condition, Block block) {
        this.condition = condition;
        this.block = block;
    }
    
    /**
     * Get the condition of the If
     * @return The condition of the If
     */
    public Expression getCondition() {
        return condition;
    }
    
    /**
     * Get the body of the If
     * @return The body of the If
     */
    public Block getBlock() {
        return block;
    }
    
    @Override
    public String toString() {
        return "if "+condition.toString()+" then: \n"+
                indent(block.toString());
    }
}

/**
 * Creates an If Then Else statement
 * @author Daniel Arthur
 * @version February 2017
 */
class IfElse extends Command {
    private Expression condition;
    private Block block;
    private Block elseBlock;
    
    /**
     * Create a new If then Else statement
     * @param condition The condition of the If Then Else
     * @param block The body of the If
     * @param elseBlock The body of the Else
     */
    public IfElse(Expression condition, Block block, Block elseBlock) {
        this.condition = condition;
        this.block = block;
        this.elseBlock = elseBlock;
    }
    
    /**
     * Get the condition of the if
     * @return The condition of the if
     */
    public Expression getCondition() {
        return condition;
    }
    
    /**
     * Get the body of the If
     * @return The body of the if
     */
    public Block getBlock() {
        return block;
    }
    
    /**
     * Get the body of the else
     * @return The body of the else
     */
    public Block getElseBlock() {
        return block;
    }
    
    @Override
    public String toString() {
        return "if "+condition.toString()+" then: \n"+
                indent(block.toString())+"\n"+
                "else:\n"+
                indent(elseBlock.toString());
    }
}

/**
 * Class representing a Variable
 * @author Daniel Arthur
 * @version February 2017
 */
class Variable extends Expression {
    private String varName;
    
    /**
     * Create a new variable
     * @param varName The name of the variable
     */
    public Variable(String varName) {
        this.varName = varName;
    }
    
    /**
     * Get the name of the variable
     * @return The name of the variable
     */
    public String getVarName() {
        return varName;
    }
    
    @Override
    public boolean equals(Object var) {
        if(var instanceof Variable) {
            if(((Variable) var).getVarName().equals(this.getVarName())) {
                return true;
            } 
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.varName);
        return hash;
    }
    
    @Override
    public String toString() {
        return varName;
    }
}

/**
 * Class representing the Nil value
 * @author Daniel Arthur
 * @version February 2017
 */
class Nil extends Expression {
    @Override
    public String toString() {
        return "nil";
    }
}

/**
 * Class representing the cons operation
 * @author Daniel Arthur
 * @version February 2017
 */
class Cons extends Expression {
    private Expression left;
    private Expression right;
    
    /**
     * Create a new cons expression
     * @param left The left (first) parameter of the cons expression
     * @param right The right (second) parameter of the cons expression 
     */
    public Cons(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }
    
    /**
     * Return the left (first) parameter of the cons expression.
     * @return The left (first) parameter of the cons expression.
     */
    public Expression getLeft() {
        return left;
    }
    
    /**
     * Return the right (second) parameter of the cons expression.
     * @return The right (second) parameter of the cons expression.
     */
    public Expression getRight() {
        return right;
    }
    
    @Override
    public String toString() {
        return "cons "+left.toString()+" "+right.toString();
    }
}

/**
 * Class representing the hd operation
 * @author Daniel Arthur
 * @version February 2017
 */
class Hd extends Expression {
    private Expression exp;
    
    /**
     * Create a new hd operation
     * @param exp The expression to find the hd of
     */
    public Hd (Expression exp) {
        this.exp = exp;
    }
    
    /**
     * Get the expression
     * @return The expression
     */
    public Expression getExp() {
        return exp;
    }
    
    @Override
    public String toString() {
        return "hd "+exp.toString();
    }
}

/**
 * Class representing the tl operation
 * @author Daniel Arthur
 * @version February 2017
 */
class Tl extends Expression {
    private Expression exp;
    
    /**
     * Create a new tl operation
     * @param exp The expression to find the tl of
     */
    public Tl (Expression exp) {
        this.exp = exp;
    }
    
    /**
     * Get the expression
     * @return The expression
     */
    public Expression getExp() {
        return exp;
    }
    
    @Override
    public String toString() {
        return "tl "+exp.toString();
    }
}

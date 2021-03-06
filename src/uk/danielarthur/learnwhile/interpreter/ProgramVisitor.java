package uk.danielarthur.learnwhile.interpreter;

/**
 * A Visitor that walks the parse tree generated by Antlr4 and produces an AST
 * @author Daniel Arthur
 * @version February 2017
 */
public class ProgramVisitor extends WhileBaseVisitor<ASTNode> {
    @Override
    public ASTNode visitProgram(WhileParser.ProgramContext ctx) {
        Variable readVar = new Variable(ctx.readVar().getText());
        Variable writeVar = new Variable(ctx.writeVar().getText());
        return new Program((Variable) visitProgName(ctx.progName()), readVar, (Block) visitBlock(ctx.block()), writeVar);
    }
    
    @Override public ASTNode visitProgName(WhileParser.ProgNameContext ctx) {
        return new Variable(ctx.getText());
    }
    
    @Override public ASTNode visitReadVar(WhileParser.ReadVarContext ctx) {
        return new Variable(ctx.getText());
    }
    
    @Override public ASTNode visitWriteVar(WhileParser.WriteVarContext ctx) {
        return new Variable(ctx.getText());
    }
    
    @Override public ASTNode visitExp(WhileParser.ExpContext ctx) {
        if(ctx.ID() != null) {
            return new Variable(ctx.ID().getText());
        }
        else {
            return visitChildren(ctx);
        }
    }
    
    @Override public ASTNode visitNil(WhileParser.NilContext ctx) {
        return new Nil();
    }
    
    @Override public ASTNode visitCons(WhileParser.ConsContext ctx) {
        return new Cons((Expression) visitExp(ctx.exp(0)), (Expression) visitExp(ctx.exp(1)));
    }
    
    @Override public ASTNode visitHd(WhileParser.HdContext ctx) {
        return new Hd((Expression) visitExp(ctx.exp()));
    }
    
    @Override public ASTNode visitTl(WhileParser.TlContext ctx) {
        return new Tl((Expression) visitExp(ctx.exp()));
    }
    
    @Override public ASTNode visitBracketedExp(WhileParser.BracketedExpContext ctx) {
        return visitExp(ctx.exp());
    }
    
    @Override public ASTNode visitBlock(WhileParser.BlockContext ctx) {
        if(ctx.stmtList() != null) {
            return new Block((StatementList) visitStmtList(ctx.stmtList()));
        }
        else {
            return new Block();
        }
    }
    
    @Override public ASTNode visitStmtList(WhileParser.StmtListContext ctx) {
        if(ctx != null) {
            return new StatementList((Command) visitCommand(ctx.command()), (StatementList) visitStmtList(ctx.stmtList()));
        }
        else {
            return null;
        }
    }
    
    @Override public ASTNode visitElseBlock(WhileParser.ElseBlockContext ctx) {
        return (Block) visitBlock(ctx.block());
    }
    
    @Override public ASTNode visitCommand(WhileParser.CommandContext ctx) { return visitChildren(ctx); }
    
    @Override public ASTNode visitAssign(WhileParser.AssignContext ctx) {
        return new Assign(new Variable(ctx.ID().getText()), (Expression) visitExp(ctx.exp()));
    }
    
    @Override public ASTNode visitWhileLoop(WhileParser.WhileLoopContext ctx) {
        return new While((Expression) visitExp(ctx.exp()), (Block) visitBlock(ctx.block()));
    }
    
    @Override public ASTNode visitIfElse(WhileParser.IfElseContext ctx) {
        return new IfElse((Expression) visitExp(ctx.exp()), (Block) visitBlock(ctx.block()), (Block) visitElseBlock(ctx.elseBlock()));
    }
    
    @Override public ASTNode visitIfStatement(WhileParser.IfStatementContext ctx) {
        return new If((Expression) visitExp(ctx.exp()), (Block) visitBlock(ctx.block()));
    }
}

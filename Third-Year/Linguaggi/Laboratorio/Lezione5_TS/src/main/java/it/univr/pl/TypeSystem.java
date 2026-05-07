package it.univr.pl;

import java.util.HashMap;
import java.util.Map;

import it.univr.pl.exception.TypeMismatchException;
import it.univr.pl.exception.VarDeclarationException;
import it.univr.pl.type.*;


public class TypeSystem extends MagiBaseVisitor<Type> {

    private final Map<String, ExpType> memory = new HashMap<>();

    @Override
    public ComType visitMain(MagiParser.MainContext ctx) {
        return (ComType) visit(ctx.com());
    }

    private ComType visitCom(MagiParser.ComContext ctx) {
        return (ComType) visit(ctx);
    }

    private SimpleType visitBoolExp(MagiParser.ExpContext ctx) {
        ExpType expType = (ExpType) visit(ctx);
        if (!expType.isCompatible(SimpleType.BOOL)) { // not boolean expression
            String err = "Type mismatch: boolean expression expected.\n" +
                         "@" + ctx.start.getLine() + ":" +
                         ctx.start.getCharPositionInLine() + "\n";
            throw new TypeMismatchException(err);
        }

        return SimpleType.BOOL;
    }

    private SimpleType visitStringExp(MagiParser.ExpContext ctx) {
        ExpType expType = (ExpType) visit(ctx);
        if (!expType.isCompatible(SimpleType.STRING)) {
            // not string expression
            String err = "Type mismatch: string expression expected.\n" +
                         "@" + ctx.start.getLine() + ":" + ctx.start.getCharPositionInLine() + "\n";
            throw new TypeMismatchException(err);
        }

        return SimpleType.STRING;
    }

    private SimpleType visitNumExp(MagiParser.ExpContext ctx) {
        ExpType expType = (ExpType) visit(ctx);
        if (!expType.isCompatible(SimpleType.INT) && !expType.isCompatible(SimpleType.FLOAT)) {
            // not numeric expression
            String err = "Type mismatch: numeric expression expected.\n" +
                         "@" + ctx.start.getLine() + ":" + ctx.start.getCharPositionInLine() + "\n";
            throw new TypeMismatchException(err);
        }

        return (SimpleType) expType;
    }

    // IMPLEMENT SCOPING AND VISIBILITYS
    @Override
    public ComType visitDecl(MagiParser.DeclContext ctx) {
        String id = ctx.VAR().getText();
        SimpleType type = SimpleType.fromString(ctx.TYPE().getText());

        memory.put(id, type);
        return ComType.INSTANCE;
    }

    @Override
    public ComType visitAssign(MagiParser.AssignContext ctx) {
        String id = ctx.VAR().getText();

        // Assigning to a variable that is not in memory
        if (!memory.containsKey(id)) {
            String err = "Variable " + id + " assigned but never declared.\n" +
                         "@" + ctx.start.getLine() + ":" + ctx.start.getCharPositionInLine() + "\n";
            throw new VarDeclarationException(err);
        }

        // Type checking
        ExpType varType = memory.get(id);
        ExpType expType = (ExpType)visit(ctx.exp());
        if (!expType.isCompatible(varType)) {
            String err = "Variable " + id + " cannot be assigned with " + expType.getName() + ".\n"+
                         "@" + ctx.start.getLine() + ":" + ctx.start.getCharPositionInLine() + "\n";
            throw new TypeMismatchException(err);
        }

        return ComType.INSTANCE;
    }

    @Override
    public Type visitAccess(MagiParser.AccessContext ctx) {
        String id = ctx.VAR().getText();

        // Assigning to a variable that is not in memory
        if (!memory.containsKey(id)) {
            String err = "Variable " + id + " not declared.\n" +
                         "@" + ctx.start.getLine() + ":" + ctx.start.getCharPositionInLine() + "\n";
            throw new VarDeclarationException(err);
        }

        return memory.get(id);
    }

    @Override
    public Type visitWhile(MagiParser.WhileContext ctx) {
        visitBoolExp(ctx.exp());

        return visit(ctx.com());
    }

    @Override
    public ComType visitIf(MagiParser.IfContext ctx) {
        visitBoolExp(ctx.exp());

        return visitCom(ctx.com());
    }

    @Override
    public ComType visitIfElse(MagiParser.IfElseContext ctx) {
        visitBoolExp(ctx.exp());

        visitCom(ctx.com(0));

        return visitCom(ctx.com(1));
    }

    @Override
    public ComType visitSeq(MagiParser.SeqContext ctx) {
        visitCom(ctx.com(0));
        return visitCom(ctx.com(1));
    }

    @Override
    public ComType visitNOP(MagiParser.NOPContext ctx) {
        return ComType.INSTANCE;
    }

    @Override
    public SimpleType visitString(MagiParser.StringContext ctx) {
        return SimpleType.STRING;
    }

    @Override
    public SimpleType visitInt(MagiParser.IntContext ctx) {
        return SimpleType.INT;
    }

    @Override
    public SimpleType visitFloat(MagiParser.FloatContext ctx) {
        return SimpleType.FLOAT;
    }

    @Override
    public SimpleType visitBool(MagiParser.BoolContext ctx) {
        return SimpleType.BOOL;
    }

    @Override
    public SimpleType visitArith1(MagiParser.Arith1Context ctx) {
        SimpleType left = visitNumExp(ctx.exp(0));
        SimpleType right = visitNumExp(ctx.exp(1));

        if (left != right) {
            String err = "Type mismatch: the operation cannot be applied to the given operands.\n" +
                         "@" + ctx.start.getLine() + ":" + ctx.start.getCharPositionInLine() + "\n";
            throw new TypeMismatchException(err);
        }

        return left;
    }
}

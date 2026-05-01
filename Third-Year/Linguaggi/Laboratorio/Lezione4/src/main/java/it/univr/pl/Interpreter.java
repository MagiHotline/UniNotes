package it.univr.pl;
import java.util.HashMap;

import it.univr.pl.value.BoolValue;
import it.univr.pl.value.ComValue;
import it.univr.pl.value.ExpValue;
import it.univr.pl.value.FloatValue;
import it.univr.pl.value.Value;
import it.univr.pl.MagiParser.ExpContext;
import it.univr.pl.exception.*;

// AGGIUNGERE SUPPORTO ALLE STRINGHE
// AGGIUNGERE COMANDO CHE STAMPA STRINGHE
// CONCATENARE DUE STRINGHE
// only STRINGS can be PRINTED
// add nop that does nothing

public class Interpreter extends MagiBaseVisitor<Value> {

    static HashMap<String, ExpValue<?>> memory = new HashMap<>();

    @Override
    public Value visitMain(MagiParser.MainContext ctx) {
        return visit(ctx.com());
    }

    private FloatValue visitFloatExp(ExpContext ctx) {
        try {
            return (FloatValue) visit(ctx);
        } catch(ClassCastException e) {
            String err = ctx.start.getLine()+ ": " + ctx.start.getCharPositionInLine();
            throw new TypeMismatchException(err);
        }
    }

    @Override
    public ExpValue<?> visitArith1(MagiParser.Arith1Context ctx) {
        FloatValue left = visitFloatExp(ctx.exp(0));
        FloatValue right = visitFloatExp(ctx.exp(1));

        float left_v = left.toJavaValue();
        float right_v = right.toJavaValue();

        switch (ctx.op.getType()) {
            case MagiParser.ADD: {
                return new ExpValue<Float>(left_v + right_v);
            }
            case MagiParser.SUB: {
                return new ExpValue<Float>(left_v + right_v);
            }
        }

        return null; // unreachable
    }

    @Override
    public ExpValue<?> visitArith2(MagiParser.Arith2Context ctx) {
        FloatValue left = visitFloatExp(ctx.exp(0));
        FloatValue right = visitFloatExp(ctx.exp(1));

        float left_v = left.toJavaValue();
        float right_v = right.toJavaValue();

        switch (ctx.op.getType()) {
           case MagiParser.MUL: {
               return new ExpValue<Float>(left_v * right_v);
           }
           case MagiParser.DIV: {
               return new ExpValue<Float>(left_v / right_v);
           }
           case MagiParser.MOD: {
               return new ExpValue<Float>(left_v % right_v);
           }

        }

        return null; // unreachable
    }

    private BoolValue visitBoolExp(ExpContext ctx) throws TypeMismatchException {
        try {
            return (BoolValue) visit(ctx);
        } catch(ClassCastException e) {
            String err = ctx.start.getLine()+ ": " + ctx.start.getCharPositionInLine();
            throw new TypeMismatchException(err);
        }
    }

    @Override
    public ComValue visitIf(MagiParser.IfContext ctx) {
        BoolValue condition = visitBoolExp(ctx.exp());

        return condition.toJavaValue() ?
            (ComValue)visit(ctx.com()) : ComValue.INSTANCE;
    }

    public ComValue visitIfElse(MagiParser.IfElseContext ctx) {
        BoolValue condition = visitBoolExp(ctx.exp());

        return condition.toJavaValue() ?
            (ComValue)visit(ctx.com(0)) : (ComValue)visit(ctx.com(1));
    }


    @Override
    public ComValue visitWhile(MagiParser.WhileContext ctx) {
        BoolValue condition = visitBoolExp(ctx.exp());

        if (condition.toJavaValue()) {
            visit(ctx.com());
            return visitWhile(ctx);
        } else {
            return ComValue.INSTANCE;
        }
    }

    @Override
    public ExpValue<?> visitPow(MagiParser.PowContext ctx) {
        FloatValue left = visitFloatExp(ctx.exp(0));
        FloatValue right = visitFloatExp(ctx.exp(1));

        float left_v = left.toJavaValue();
        float right_v = right.toJavaValue();

        float res = 1;
        for(float i = 1; i <= right_v; i++) {
            res *= left_v;
        }

        return new ExpValue<Float>(res);
    }

    @Override
    public FloatValue visitFloat(MagiParser.FloatContext ctx) {
        return new FloatValue(Float.parseFloat(ctx.getText()));
    }

    /// Assignment
    @Override
    public Value visitVar(MagiParser.VarContext ctx) {
        String var = ctx.VAR().getText();
        ExpValue<?> val = (ExpValue<?>) visit(ctx.exp());
        memory.put(var, val);
        return ComValue.INSTANCE;
    }

    @Override
    public Value visitSeq(MagiParser.SeqContext ctx) {
        visit(ctx.com(0));
        return (ComValue) visit(ctx.com(1));
    }

    /// Visit identifier
    @Override
    public ExpValue<?> visitAccess(MagiParser.AccessContext ctx) {

        String id = ctx.VAR().getText();

        if (!memory.containsKey(id)) {
            String err = "Variable" + id + " used but not initialized"
            + "@" + ctx.start.getLine()+ ": " + ctx.start.getCharPositionInLine();

            throw new UnknownVariableException(err);
        }

        return memory.get(id);
    }

    @Override
    public BoolValue visitBool(MagiParser.BoolContext ctx) {
        return new BoolValue(Boolean.parseBoolean(ctx.getText()));
    }

    @Override
    public Value visitEqExp(MagiParser.EqExpContext ctx) {
        ExpValue<?> left = (ExpValue<?>) visit(ctx.exp(0));
        ExpValue<?> right = (ExpValue<?>) visit(ctx.exp(1));

        return switch (ctx.op.getType()) {
            case MagiParser.EQ -> new BoolValue(left.equals(right));
            case MagiParser.NEQ -> new BoolValue(!left.equals(right));
            default -> null; // unreachable
        };

    }

    @Override
    public Value visitAndOr(MagiParser.AndOrContext ctx) {
        BoolValue left = visitBoolExp(ctx.exp(0));
        BoolValue right = visitBoolExp(ctx.exp(1));

        boolean left_v = left.toJavaValue();
        boolean right_v = right.toJavaValue();

        return switch(ctx.op.getType()) {
            case MagiParser.AND -> new BoolValue(left_v && right_v);
            case MagiParser.OR -> new BoolValue(left_v || right_v);
            default -> null;    // unreachable
        };
    }


    @Override
    public Value visitCmpExp(MagiParser.CmpExpContext ctx) {
        FloatValue left = visitFloatExp(ctx.exp(0));
        FloatValue right = visitFloatExp(ctx.exp(1));

        float left_v = left.toJavaValue();
        float right_v = right.toJavaValue();

        return switch(ctx.op.getType()) {
            case MagiParser.LT -> new BoolValue(left_v < right_v);
            case MagiParser.LTE -> new BoolValue(left_v <= right_v);
            case MagiParser.GT -> new BoolValue(left_v > right_v);
            case MagiParser.GTE -> new BoolValue(left_v >= right_v);
            default -> null;    // unreachable
        };
    }

    @Override
    public Value visitNot(MagiParser.NotContext ctx) {
        BoolValue exp = visitBoolExp(ctx.exp());
        return new BoolValue(!exp.toJavaValue());
    }

    @Override
    public ComValue visitPrint(MagiParser.PrintContext ctx) {
        ExpValue<?> val = (ExpValue<?>)visit(ctx.exp());
        System.out.println(val.toJavaValue());
        return ComValue.INSTANCE;
    }
}

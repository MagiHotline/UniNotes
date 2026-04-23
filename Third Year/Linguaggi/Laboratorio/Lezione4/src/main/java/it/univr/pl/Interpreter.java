package it.univr.pl;
import java.util.HashMap;

public class Interpreter extends MagiBaseVisitor<Float> {

    static HashMap<String, Float> memory = new HashMap<>();

    @Override
    public Float visitMain(MagiParser.MainContext ctx) {
        return visit(ctx.exp());
    }

    @Override
    public Float visitArith1(MagiParser.Arith1Context ctx) {
        float left = visit(ctx.exp(0));
        float right = visit(ctx.exp(1));

        switch (ctx.op.getType()) {
            case MagiParser.ADD: {
                return left + right;
            }
            case MagiParser.SUB: {
                return left - right;
            }
        }

        return 0.0f; // unreachable
    }

    @Override
    public Float visitArith2(MagiParser.Arith2Context ctx) {
        float left = visit(ctx.exp(0));
        float right = visit(ctx.exp(1));

        switch (ctx.op.getType()) {
           case MagiParser.MUL: {
               return left * right;
           }
           case MagiParser.DIV: {
               return left / right;
           }
           case MagiParser.MOD: {
               return left % right;
           }

        }

        return 0.0f;
    }

    @Override
    public Float visitPow(MagiParser.PowContext ctx) {
        float left = visit(ctx.exp(0));
        float right = visit(ctx.exp(1));
        float res = 1;
        for(float i = 1; i <= right; i++) {
            res *= left;
        }
        return res;
    }

    @Override
    public Float visitVal(MagiParser.ValContext ctx) {
        return Float.parseFloat(ctx.getText());
    }

    @Override
    public Float visitVar(MagiParser.VarContext ctx) {
        float val = visit(ctx.exp());
        String var = ctx.VAR().toString();
        memory.put(var, val);
        return val;
    }

    @Override
    public Float visitSeq(MagiParser.SeqContext ctx) {
        float val = visit(ctx.exp(0));
        String var = ctx.VAR().toString();
        memory.put(var, val);
        return visit(ctx.exp(1));
    }

    @Override
    public Float visitAccess(MagiParser.AccessContext ctx) {
        return memory.getOrDefault(ctx.VAR().toString(), 0.0f);
    }
}

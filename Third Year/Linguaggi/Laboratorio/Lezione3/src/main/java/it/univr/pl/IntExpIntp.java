package it.univr.pl;
import java.util.HashMap;

public class IntExpIntp extends IntExpBaseVisitor<Integer> {

    static HashMap<String, Integer> memory = new HashMap<>();

    @Override
    public Integer visitMain(IntExpParser.MainContext ctx) {
        return visit(ctx.exp());
    }

    @Override
    public Integer visitAdd(IntExpParser.AddContext ctx) {
        int left = visit(ctx.exp(0));
        int right = visit(ctx.exp(1));
        return left + right;
    }

    @Override
    public Integer visitMul(IntExpParser.MulContext ctx) {
        int left = visit(ctx.exp(0));
        int right = visit(ctx.exp(1));
        return left * right;
    }

    @Override
    public Integer visitSub(IntExpParser.SubContext ctx) {
        int left = visit(ctx.exp(0));
        int right = visit(ctx.exp(1));
        return left - right;
    }

    @Override
    public Integer visitDiv(IntExpParser.DivContext ctx) {
        int left = visit(ctx.exp(0));
        int right = visit(ctx.exp(1));
        return left / right;
    }

    @Override
    public Integer visitMOD(IntExpParser.MODContext ctx) {
        int left = visit(ctx.exp(0));
        int right = visit(ctx.exp(1));
        return left % right;
    }

    @Override
    public Integer visitVal(IntExpParser.ValContext ctx) {
        return Integer.parseInt(ctx.getText());
    }

    @Override
    public Integer visitVar(IntExpParser.VarContext ctx) {
        int val = visit(ctx.exp());
        String var = ctx.VAR().toString();
        memory.put(var, val);
        return val;
    }

    @Override
    public Integer visitSeq(IntExpParser.SeqContext ctx) {
        int val = visit(ctx.exp(0));
        String var = ctx.VAR().toString();
        memory.put(var, val);
        return visit(ctx.exp(1));
    }

    @Override
    public Integer visitAccess(IntExpParser.AccessContext ctx) {
        return memory.getOrDefault(ctx.VAR().toString(), 0);
    }
}

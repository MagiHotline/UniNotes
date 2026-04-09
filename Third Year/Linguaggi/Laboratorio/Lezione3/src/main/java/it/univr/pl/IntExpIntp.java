package it.univr.pl;

public class IntExpIntp extends IntExpBaseVisitor<Integer> {

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

        int lhs = visit(ctx.VAR());

        return 0;
    }
}

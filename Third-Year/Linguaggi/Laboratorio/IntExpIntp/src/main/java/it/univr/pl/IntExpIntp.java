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
    public Integer visitMul(IntExpParser.MulContext ctx) {
        int left = visit(ctx.exp(0));
        int right = visit(ctx.exp(1));
        return left * right;
    }

    @Override
    public Integer visitVal(IntExpParser.ValContext ctx) {
        return Integer.parseInt(ctx.getText());
    }
}

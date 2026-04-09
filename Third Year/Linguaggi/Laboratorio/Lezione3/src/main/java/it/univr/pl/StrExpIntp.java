package it.univr.pl;

public class StrExpIntp extends IntExpBaseVisitor<String> {

    @Override
    public String visitMain(IntExpParser.MainContext ctx) {
        return visit(ctx.exp());
    }

    @Override
    public String visitAdd(IntExpParser.AddContext ctx) {
        String left = visit(ctx.exp(0));
        String right = visit(ctx.exp(1));
        return "(" + left + " plus " + right + ")";
    }

    @Override
    public String visitSub(IntExpParser.SubContext ctx) {
        String lhs = visit(ctx.exp(0));
        String rhs = visit(ctx.exp(1));
        return "(" + lhs + " minus " + rhs + ")";
    }

    @Override
    public String visitDiv(IntExpParser.DivContext ctx) {
        String lhs = visit(ctx.exp(0));
        String rhs = visit(ctx.exp(1));
        return "(" + lhs + " div " + rhs + ")";
    }

    @Override
    public String visitMOD(IntExpParser.MODContext ctx) {
        String lhs = visit(ctx.exp(0));
        String rhs = visit(ctx.exp(1));
        return "(" + lhs + " mod " + rhs + ")";
    }

    @Override
    public String visitMul(IntExpParser.MulContext ctx) {
        String left = visit(ctx.exp(0));
        String right = visit(ctx.exp(1));
        return "(" + left + " times " + right + ")";
    }

    @Override
    public String visitVal(IntExpParser.ValContext ctx) {
        return ctx.getText();
    }
}

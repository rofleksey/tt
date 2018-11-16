package expression;

public class Lambda extends Expression {
    public Lambda(Expression left, Expression right) {
        super("lambda", left, right);
    }

    @Override
    String genToStr() {
        return "(\\"+left+"."+right+")";
    }
}

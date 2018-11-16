package expression;

public class Application extends Expression {

    public Application(Expression left, Expression right) {
        super("app", left, right);
    }

    @Override
    String genToStr() {
        return "(" + left+" "+right + ")";
    }
}

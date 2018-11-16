package expression;

public class Variable extends Expression {
    String name;

    public Variable(String name) {
        super("var", null, null);
        this.name = name;
    }

    @Override
    String genToStr() {
        return name;
    }
}

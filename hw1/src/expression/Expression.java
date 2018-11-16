package expression;

import java.util.Objects;

public abstract class Expression {
    Expression left, right;
    String key, toStringCache;
    boolean hashCached = false;
    int hashCache;

    public Expression(String key, Expression left, Expression right) {
        this.key = key;
        this.left = left;
        this.right = right;
    }

    public int genHash() {
        return Objects.hash(key, left, right);
    }

    abstract String genToStr();

    @Override
    public int hashCode() {
        if(!hashCached) {
            hashCached = true;
            hashCache = genHash();
        }
        return hashCache;
    }

    @Override
    public String toString() {
        if(toStringCache == null) {
            toStringCache = genToStr();
        }
        return toStringCache;
    }
}

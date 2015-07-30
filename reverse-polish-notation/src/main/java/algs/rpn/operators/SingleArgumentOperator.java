package algs.rpn.operators;

public interface SingleArgumentOperator extends Operator {

    double evaluate(double p);

    @Override
    default double evaluate(double arg, double... args) {
        return evaluate(arg);
    }

    @Override
    default boolean isSingleArgument() {
        return true;
    }
}

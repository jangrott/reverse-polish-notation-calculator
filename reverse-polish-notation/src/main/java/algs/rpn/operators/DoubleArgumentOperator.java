package algs.rpn.operators;

public interface DoubleArgumentOperator extends Operator{

    double evaluate(double p, double q);

    @Override
    default double evaluate(double arg, double... args) {
        return evaluate(arg, args[0]);
    }

    @Override
    default boolean isSingleArgument() {
        return false;
    }
}

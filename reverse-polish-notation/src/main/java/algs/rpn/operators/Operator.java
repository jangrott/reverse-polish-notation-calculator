package algs.rpn.operators;

public interface Operator {

    boolean isSingleArgument();

    double evaluate(double arg, double ... args);
}

package algs.rpn.operators.impl;

import algs.rpn.operators.DoubleArgumentOperator;

public class Multiplication implements DoubleArgumentOperator {

    @Override
    public double evaluate(double p, double q) {
        return q * p;
    }
}

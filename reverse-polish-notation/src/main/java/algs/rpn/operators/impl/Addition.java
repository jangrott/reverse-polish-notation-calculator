package algs.rpn.operators.impl;

import algs.rpn.operators.DoubleArgumentOperator;

public class Addition implements DoubleArgumentOperator {

    @Override
    public double evaluate(double p, double q) {
        return q + p;
    }
}

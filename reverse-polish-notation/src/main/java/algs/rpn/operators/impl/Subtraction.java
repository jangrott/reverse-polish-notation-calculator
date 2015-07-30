package algs.rpn.operators.impl;

import algs.rpn.operators.DoubleArgumentOperator;

public class Subtraction implements DoubleArgumentOperator {

    @Override
    public double evaluate(double p, double q) {
        return q - p;
    }
}

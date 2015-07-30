package algs.rpn.operators.impl;

import algs.rpn.operators.SingleArgumentOperator;

public class SquareRoot implements SingleArgumentOperator {

    @Override
    public double evaluate(double p) {
        return Math.sqrt(p);
    }
}

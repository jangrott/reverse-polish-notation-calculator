package algs.rpn.operators.impl;

import algs.rpn.operators.Operator;

import java.util.Stack;

public class SquareRoot implements Operator {

    @Override
    public double evaluate(Stack<Double> elements) {
        double p = elements.pop();

        return Math.sqrt(p);
    }
}

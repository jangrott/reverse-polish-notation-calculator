package algs.rpn.operators.impl;

import algs.rpn.operators.Operator;

import java.util.Stack;

public class Subtraction implements Operator {

    @Override
    public double evaluate(Stack<Double> elements) {
        double p = elements.pop();
        double q = elements.pop();

        return q - p;
    }
}

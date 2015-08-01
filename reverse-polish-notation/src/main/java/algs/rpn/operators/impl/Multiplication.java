package algs.rpn.operators.impl;

import algs.rpn.operators.Operator;

import java.util.Stack;

import static com.google.common.base.Preconditions.checkArgument;

public class Multiplication implements Operator {

    @Override
    public double evaluate(Stack<Double> elements) {
        checkArgument(elements.size() == 2, "Multiplication requires exactly two elements");

        double p = elements.pop();
        double q = elements.pop();

        return q * p;
    }
}

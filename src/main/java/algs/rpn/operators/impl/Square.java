package algs.rpn.operators.impl;

import algs.rpn.operators.Operator;

import java.util.Stack;

import static com.google.common.base.Preconditions.checkArgument;

public class Square implements Operator{

    @Override
    public double evaluate(Stack<Double> elements) {
        checkArgument(elements.size() >= 1, "Square requires at least one element!");

        double p = elements.pop();

        return Math.pow(p, 2);
    }
}

package algs.rpn.operators.impl;

import algs.rpn.operators.Operator;

import java.util.Stack;

import static com.google.common.base.Preconditions.checkArgument;

public class SquareRoot implements Operator {

    @Override
    public double evaluate(Stack<Double> elements) {
        checkArgument(elements.size() == 1, "Square root requires exactly one element!");

        double p = elements.pop();

        return Math.sqrt(p);
    }
}

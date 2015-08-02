package algs.rpn.operators;

import java.util.Stack;

@FunctionalInterface
public interface Operator {

    double evaluate(Stack<Double> elements);
}

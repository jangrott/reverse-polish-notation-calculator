package algs.rpn.operators;

import java.util.Stack;

public interface Operator {

    double evaluate(Stack<Double> elements);
}

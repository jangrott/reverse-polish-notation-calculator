package algs.rpn;

import algs.rpn.operators.Operator;
import algs.rpn.operators.impl.*;
import com.google.common.collect.ImmutableMap;
import com.google.common.primitives.Doubles;

import java.util.Arrays;
import java.util.Map;
import java.util.Stack;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Strings.isNullOrEmpty;

public class RPNCalculator implements Calculator {

    private Stack<Double> stack = new Stack<>();

    @Override
    public double calculate(String expression) {
        checkArgument(!isNullOrEmpty(expression), "Expression can not be null or empty!");

        String[] elementsOfExpression = expression.split("\\s+");

        Arrays.stream(elementsOfExpression).forEach(this::evaluate);

        return stack.pop();
    }

    private void evaluate(String element) {
        Double value;
        if ((value = Doubles.tryParse(element)) != null) {
            stack.push(value);
        } else {
            evaluateOperator(
                    operators.get(element)
            );
        }
    }

    private void evaluateOperator(Operator operator) {
        if (operator.isSingleArgument()) {
            stack.push(
                    operator.evaluate(stack.pop())
            );
            return;
        }

        stack.push(
                operator.evaluate(stack.pop(), stack.pop())
        );
    }

    private Map<String, Operator> operators = ImmutableMap.<String, Operator>builder()
            .put("+", new Addition())
            .put("-", new Subtraction())
            .put("*", new Multiplication())
            .put("/", new Division())
            .put("sqrt", new SquareRoot())
            .build();
}
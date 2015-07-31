package algs.rpn;

import algs.rpn.operators.Operator;
import algs.rpn.operators.impl.*;
import com.google.common.collect.ImmutableMap;
import com.google.common.primitives.Doubles;

import java.util.Arrays;
import java.util.Map;
import java.util.Stack;
import java.util.function.Function;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Strings.isNullOrEmpty;

public class RPNCalculator implements Calculator {

    private Double value;

    private Stack<Double> stack = new Stack<>();

    @Override
    public double calculate(String expression) {
        checkArgument(!isNullOrEmpty(expression), "Expression can not be null or empty!");

        String[] elements = expression.split("\\s+");

        Arrays.stream(elements)
                .map(evaluator)
                .forEach(stack::push);

        return stack.pop();
    }

    private Function<String, Double> evaluator =
            e -> parseAndAssignValueOrNull(e) != null ? value : evaluateOperator(e);

    private Double parseAndAssignValueOrNull(String e) {
        return value = Doubles.tryParse(e);
    }

    private double evaluateOperator(String e) {
        return operators.get(e).evaluate(stack);
    }

    private static Map<String, Operator> operators = ImmutableMap.<String, Operator>builder()
            .put("+", new Addition())
            .put("-", new Subtraction())
            .put("*", new Multiplication())
            .put("/", new Division())
            .put("sqrt", new SquareRoot())
            .build();
}
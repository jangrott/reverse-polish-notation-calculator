package algs.rpn;

import com.google.common.primitives.Doubles;

import java.util.Arrays;
import java.util.Stack;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Strings.isNullOrEmpty;

public class RPNCalculator implements Calculator {

    private Stack<Double> stack = new Stack<>();

    @Override
    public double calculate(String expression) {
        checkArgument(!isNullOrEmpty(expression), "Expression can not be null or empty!");

        String[] elementsOfExpression = expression.split("\\s+");

        Arrays.stream(elementsOfExpression)
                .forEach(this::evaluate);

        return stack.pop();
    }

    private void evaluate(String element) {
        Double value;
        if ((value = Doubles.tryParse(element)) != null) {
            stack.push(value);
        } else {
            evaluateOperator(element);
        }
    }

    private void evaluateOperator(String symbol) {
        double p = stack.pop();
        double q = stack.pop();

        switch (symbol) {
            case "+":
                stack.push(q + p);
                break;
            case "-":
                stack.push(q - p);
                break;
            case "*":
                stack.push(q * p);
                break;
            case "/":
                stack.push(q / p);
                break;
        }
    }
}

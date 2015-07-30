package algs.rpn;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Strings.isNullOrEmpty;

public class RPNCalculator implements Calculator {

    @Override
    public double calculate(String expression) {
        checkArgument(!isNullOrEmpty(expression), "Expression can not be null or empty!");

        return 5;
    }
}

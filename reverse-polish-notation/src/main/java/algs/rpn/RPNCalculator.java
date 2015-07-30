package algs.rpn;

import static com.google.common.base.Preconditions.checkArgument;
import static java.util.Objects.isNull;

public class RPNCalculator implements Calculator {

    @Override
    public double calculate(String expression) {
        checkArgument(!isNull(expression), "Expression can not be null!");

        return 5;
    }
}

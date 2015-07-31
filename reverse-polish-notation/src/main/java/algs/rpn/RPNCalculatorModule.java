package algs.rpn;

import algs.rpn.operators.Operator;
import algs.rpn.operators.impl.*;
import com.google.common.collect.ImmutableMap;
import dagger.Module;
import dagger.Provides;

import java.util.Map;

@Module(
        staticInjections = RPNCalculator.class
)
public class RPNCalculatorModule {

    @Provides
    Map<String, Operator> operators() {
        return ImmutableMap.<String, Operator>builder()
                .put("+", new Addition())
                .put("-", new Subtraction())
                .put("*", new Multiplication())
                .put("/", new Division())
                .put("sqrt", new SquareRoot())
                .build();
    }
}
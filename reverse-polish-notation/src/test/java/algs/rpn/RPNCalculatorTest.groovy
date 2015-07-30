package algs.rpn;

import spock.lang.Specification
import spock.lang.Unroll;

@Unroll
public class RPNCalculatorSpec extends Specification {

    def "The calculation result of simple expression \"#expression\" is #result"() {
        expect:
        new RPNCalculator().calculate(expression) == 5
        where:
        expression  ||  result
        "2 3 +"     ||  5
    }
}
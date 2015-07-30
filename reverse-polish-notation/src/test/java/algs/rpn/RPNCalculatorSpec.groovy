package algs.rpn;

import spock.lang.Specification
import spock.lang.Unroll;

@Unroll
public class RPNCalculatorSpec extends Specification {

    def calculator = new RPNCalculator()

    def "The calculation result of simple expression \"#expression\" is #result"() {
        expect:
        calculator.calculate(expression) == 5
        where:
        expression  ||  result
        "2 3 +"     ||  5
    }

    def "The calculation of expression with value equal to null throws exception"() {
        when:
        calculator.calculate(null);
        then:
        thrown IllegalArgumentException
    }

    def "The calculation of expression with empty value throws exception"() {
        when:
        calculator.calculate("")
        then:
        thrown IllegalArgumentException
    }
}
package algs.rpn

import dagger.ObjectGraph;
import spock.lang.Specification
import spock.lang.Unroll

import static algs.rpn.RPNCalculator.aRPNCalculator;

@Unroll
class RPNCalculatorSpec extends Specification {

    def setupSpec() {
        ObjectGraph.create(new RPNCalculatorModule()).injectStatics()
    }

    def "The calculation result of simple expression \"#expression\" is #result"() {
        expect:
        aRPNCalculator().calculate(expression) == result
        where:
        expression  ||  result
        "2 3 +"     ||  5
        "4 2 -"     ||  2
        "3 3 *"     ||  9
        "9 2 /"     ||  4.5
        "4 sqrt"    ||  2
        "3 ^"       ||  9
    }

    def "The calculation of expression with value equal to null throws exception"() {
        when:
        aRPNCalculator().calculate(null);
        then:
        thrown IllegalArgumentException
    }

    def "The calculation of expression with empty value throws exception"() {
        when:
        aRPNCalculator().calculate("")
        then:
        thrown IllegalArgumentException
    }
}
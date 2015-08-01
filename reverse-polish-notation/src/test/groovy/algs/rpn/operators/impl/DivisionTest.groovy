package algs.rpn.operators.impl

import spock.lang.Specification
import spock.lang.Unroll

@Unroll
class DivisionTest extends Specification implements OperatorTest {

    def division = new Division()

    def "The division result #p from #q is #quotient"() {
        setup:
        List<Double> args = Arrays.asList((double) p, (double) q)
        clearAndSetupStack(args)
        expect:
        division.evaluate(elements) == quotient
        where:
        p  || q  || quotient
        4  || 1  || 4
        24 || 12 || 2
        27 || 9  || 3
        1  || 1  || 1
    }
}

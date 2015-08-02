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
        0  || 1  || 0
    }

    def "The dividing less than two elements #args throws exception"() {
        setup:
        clearAndSetupStack(args)
        when:
        division.evaluate(elements)
        then:
        thrown IllegalArgumentException
        where:
        args << [[], [2]]
    }

    def "The dividing by zero throws exception"() {
        setup:
        clearAndSetupStack(Arrays.asList((double)4, (double)0))
        when:
        division.evaluate(elements)
        then:
        thrown IllegalArgumentException
    }
}
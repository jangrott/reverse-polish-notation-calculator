package algs.rpn.operators.impl

import spock.lang.Specification
import spock.lang.Unroll

@Unroll
class SubtractionSpec extends Specification implements OperatorSpec {

    def subtraction = new Subtraction()

    def "The subtraction result #p from #q is #odds"() {
        setup:
        List<Double> args = Arrays.asList((double) p, (double) q)
        clearAndSetupStack(args)
        expect:
        subtraction.evaluate(elements) == odds
        where:
        p  || q  || odds
        4  || 1  || 3
        34 || 12 || 22
        32 || 9  || 23
        1  || 0  || 1
    }

    def "The subtracting less than two elements #args throws exception"() {
        setup:
        clearAndSetupStack(args)
        when:
        subtraction.evaluate(elements)
        then:
        thrown IllegalArgumentException
        where:
        args << [[]]
    }
}

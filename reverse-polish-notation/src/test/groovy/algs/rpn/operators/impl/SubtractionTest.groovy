package algs.rpn.operators.impl

import spock.lang.Specification
import spock.lang.Unroll

@Unroll
class SubtractionTest extends Specification implements OperatorTest {

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
}

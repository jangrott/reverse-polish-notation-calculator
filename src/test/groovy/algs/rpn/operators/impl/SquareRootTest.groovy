package algs.rpn.operators.impl

import spock.lang.Specification
import spock.lang.Unroll

@Unroll
class SquareRootTest extends Specification implements OperatorTest {

    def squareRoot = new SquareRoot()

    def "The square root result #p is #root"() {
        setup:
        List<Double> args = Arrays.asList((double) p)
        clearAndSetupStack(args)
        expect:
        squareRoot.evaluate(elements) == root
        where:
        p   || root
        4   || 2
        9   || 3
        144 || 12
        1   || 1
    }

    def "The square root less than one elements #args throws exception"() {
        setup:
        clearAndSetupStack([])
        when:
        squareRoot.evaluate(elements)
        then:
        thrown IllegalArgumentException
    }
}
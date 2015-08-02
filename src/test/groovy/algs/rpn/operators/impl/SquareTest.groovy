package algs.rpn.operators.impl

import spock.lang.Specification
import spock.lang.Unroll

@Unroll
class SquareTest extends Specification implements OperatorTest {

    def square = new Square()

    def "The square result #p is #squareResult"() {
        setup:
        List<Double> args = Arrays.asList((double) p)
        clearAndSetupStack(args)
        expect:
        square.evaluate(elements) == squareResult
        where:
        p  || squareResult
        4  || 16
        9  || 81
        12 || 144
        1  || 1
        0  || 0
    }

    def "The square root more or less than one elements #args throws exception"() {
        setup:
        clearAndSetupStack(args)
        when:
        square.evaluate(elements)
        then:
        thrown IllegalArgumentException
        where:
        args << [[4, 3, 9], [], [2, 1]]
    }
}

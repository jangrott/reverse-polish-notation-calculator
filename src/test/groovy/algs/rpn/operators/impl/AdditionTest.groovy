package algs.rpn.operators.impl

import spock.lang.Specification
import spock.lang.Unroll

@Unroll
class AdditionTest extends Specification implements OperatorTest {

    def addition = new Addition()

    def "The addition result #p to #q is #sum"() {
        setup:
        List<Double> args = Arrays.asList((double) p, (double) q)
        clearAndSetupStack(args)
        expect:
        addition.evaluate(elements) == sum
        where:
        p  || q  || sum
        2  || 3  || 5
        3  || 12 || 15
        34 || 23 || 57
        1  || 0  || 1
    }

    def "The adding less than two elements #args throws exception"() {
        setup:
        clearAndSetupStack(args)
        when:
        addition.evaluate(elements)
        then:
        thrown IllegalArgumentException
        where:
        args << [[], [2]]
    }
}
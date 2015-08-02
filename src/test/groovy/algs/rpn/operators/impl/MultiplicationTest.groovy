package algs.rpn.operators.impl

import spock.lang.Specification
import spock.lang.Unroll

@Unroll
class MultiplicationTest extends Specification implements OperatorTest {

    def multiplication = new Multiplication()

    def "The multiplication result #p from #q is #product"() {
        setup:
        List<Double> args = Arrays.asList((double) p, (double) q)
        clearAndSetupStack(args)
        expect:
        multiplication.evaluate(elements) == product
        where:
        p  || q  || product
        4  || 1  || 4
        24 || 12 || 288
        27 || 9  || 243
        1  || 1  || 1
    }

    def "The multiplication more or less than two elements #args throws exception"() {
        setup:
        clearAndSetupStack(args)
        when:
        multiplication.evaluate(elements)
        then:
        thrown IllegalArgumentException
        where:
        args << [[4, 3, 9], [], [2]]
    }
}

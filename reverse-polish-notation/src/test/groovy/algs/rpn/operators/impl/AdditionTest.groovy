package algs.rpn.operators.impl

import spock.lang.Specification
import spock.lang.Unroll

@Unroll
class AdditionTest extends Specification implements OperatorTest{

    def addition = new Addition()

    def "The result of addition #p to #q is #sum"() {
        setup:
        setupStack(p, q)
        expect:
        addition.evaluate(stack) == sum
        where:
        p   ||  q   ||  sum
        2   ||  3   ||  5
        3   ||  12  ||  15
        34  ||  23  ||  57
        1   ||  0   ||  1
    }
}

interface OperatorTest {

    def stack = new Stack<Double>()

    def setupStack = {double ... args -> args.each { stack.push(it)}}
}

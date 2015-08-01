package algs.rpn.operators.impl

interface OperatorTest {

    def elements = new Stack<Double>();

    def clearAndSetupStack = { List<Double> args -> elements.clear(); args.each { elements.push(it) } }
}

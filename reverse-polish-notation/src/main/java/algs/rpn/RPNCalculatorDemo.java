package algs.rpn;

import dagger.ObjectGraph;

public class RPNCalculatorDemo {

    static {
        ObjectGraph.create(new RPNCalculatorModule()).injectStatics();
    }

    public static void main(String[] args) {
        // todo
    }
}
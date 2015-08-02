package algs.rpn;

import dagger.ObjectGraph;

import java.util.Scanner;

import static algs.rpn.RPNCalculator.aRPNCalculator;

public class RPNCalculatorDemo {

    static {
        ObjectGraph.create(new RPNCalculatorModule()).injectStatics();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while(scanner.hasNextLine()) {
            String expression = scanner.nextLine();
            System.out.println(String.format("The result of \"%s\" RPN expression is %f", expression, calculateExpressionInRPN(expression)));
        }
    }

    private static double calculateExpressionInRPN(String expression) {
        return aRPNCalculator().calculate(expression);
    }
}
package com.shpp.p2p.cs.ihordienko.assignment11;

import com.shpp.p2p.cs.ihordienko.assignment11.records.Variable;

import java.util.ArrayList;

/**
 * Assignment10Part1 class in an implementation of a calculator
 * input occurs through args passed when running the file
 * first argument must be an expression, example: "x+2";
 * after it, you can enter variables, read example on line 14
 * <p>
 * supported operations are:
 * subtraction (-); addition (+); multiplying (*); dividing (/); raising to power (*)
 * <p>
 * supports variables, please input them in a way like: "a=3" / "a = 3" or similar,
 * only one letter long variables are supported
 */
public class Assignment11Part1 {
    /**
     * Main method of the program
     * handles user input and general logic of the program
     */
    public static void main(String[] args) {
        try {
            ExpressionParser expressionParser = new ExpressionParser();
            String formula = expressionParser.getExpression(args);
            ArrayList<Variable> variables = new ArrayList<>();

            if (args.length > 1) {
                variables = expressionParser.getVariables(args);
            }

            Assignment10Part1Parser parser = new Assignment10Part1Parser();
            Assignment10Part1Calculator calculator = new Assignment10Part1Calculator();

//            System.out.println("formula: " + formula);

            ArrayList<Token> result = parser.parseExpression(formula, variables);

//            System.out.println("Parsed expression: " + result);
            System.out.println(calculator.calculate(result, variables));


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

package com.shpp.p2p.cs.ihordienko.assignment11;

import com.shpp.p2p.cs.ihordienko.assignment11.handlers.calculatorHandlers.CalculatorFunctionHandler;
import com.shpp.p2p.cs.ihordienko.assignment11.handlers.calculatorHandlers.CalculatorNumberHandler;
import com.shpp.p2p.cs.ihordienko.assignment11.handlers.calculatorHandlers.CalculatorOperatorHandler;
import com.shpp.p2p.cs.ihordienko.assignment11.handlers.calculatorHandlers.CalculatorVariableHandler;
import com.shpp.p2p.cs.ihordienko.assignment11.interfaces.CalculatorHandler;
import com.shpp.p2p.cs.ihordienko.assignment11.records.Variable;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Assignment10Part1Calculator class handles core logic of calculating result of the expression
 * based on tokenised representation of it
 */
public class Assignment10Part1Calculator {

    /*Supported calculation handlers*/
    private static final List<CalculatorHandler> HANDLERS = List.of(
            new CalculatorNumberHandler(),
            new CalculatorOperatorHandler(),
            new CalculatorVariableHandler(),
            new CalculatorFunctionHandler()
    );

    /**
     * iterating trough tokens applying specified operations to them
     * returns result of calculating the expression
     */
    public double calculate(ArrayList<Token> expression, ArrayList<Variable> variables) {
        Stack<Double> numberStack = new Stack<>();
        for (Token token : expression) {
            handleToken(token, numberStack, variables);
        }

        double result = numberStack.pop();
        numberStack.setSize(0);
        return result;
    }

    /**
     * iterating through handlers to find suitable one
     */
    private boolean handleToken(Token token, Stack<Double> numberStack, ArrayList<Variable> variables) {
        for (CalculatorHandler handler : HANDLERS) {
            if (handler.handler(token, numberStack, variables)) {
                return true;
            }
        }
        return false;
    }
}


package com.shpp.p2p.cs.ihordienko.assignment11.handlers.calculatorHandlers;

import com.shpp.p2p.cs.ihordienko.assignment11.Token;
import com.shpp.p2p.cs.ihordienko.assignment11.interfaces.CalculatorHandler;
import com.shpp.p2p.cs.ihordienko.assignment11.records.Variable;

import java.util.ArrayList;
import java.util.Stack;

/**
 * class provides core logic for handling calculation of number token in expression
 */
public class CalculatorNumberHandler implements CalculatorHandler {

    /**
     * pushes number in the stack
     * returns true if success, false if its not a number
     */
    @Override
    public boolean handler(Token token, Stack<Double> numberStack, ArrayList<Variable> variables) {
        if (!token.isNumber()) {
            return false;
        }

        numberStack.push(token.getNumber());
        return true;
    }
}

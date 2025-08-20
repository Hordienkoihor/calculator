package com.shpp.p2p.cs.ihordienko.assignment11.handlers.calculatorHandlers;

import com.shpp.p2p.cs.ihordienko.assignment11.Token;
import com.shpp.p2p.cs.ihordienko.assignment11.interfaces.CalculatorHandler;
import com.shpp.p2p.cs.ihordienko.assignment11.records.Variable;

import java.util.ArrayList;
import java.util.Stack;

/**
 * class provides core logic for handling calculation of variable token in expression
 */
public class CalculatorVariableHandler implements CalculatorHandler {

    /**
     * takes value of a variable from list  and pushes it in the stack
     * returns true if success, false if its not a variable
     */
    @Override
    public boolean handler(Token token, Stack<Double> numberStack, ArrayList<Variable> variables) {
        if (!token.isVariable()) {
            return false;
        }

        for (Variable variable : variables) {
            if (variable.getTitle() == token.getVariable()) {
                numberStack.push(variable.getValue());
                break;
            }
        }
        return true;
    }
}

package com.shpp.p2p.cs.ihordienko.assignment11.handlers.calculatorHandlers;

import com.shpp.p2p.cs.ihordienko.assignment11.Token;
import com.shpp.p2p.cs.ihordienko.assignment11.enums.Functions;
import com.shpp.p2p.cs.ihordienko.assignment11.interfaces.CalculatorHandler;
import com.shpp.p2p.cs.ihordienko.assignment11.records.Variable;

import java.util.ArrayList;
import java.util.Stack;

/**
 * class provides core logic for handling calculation of  function token in expression
 */
public class CalculatorFunctionHandler implements CalculatorHandler {

    /**
     * takes last humber from the stack and pushes result of evaluating back
     * returns true if success, false if its not a function
     */
    @Override
    public boolean handler(Token token, Stack<Double> numberStack, ArrayList<Variable> variables) {
        if (!token.isFunction()) {
            return false;
        }

        Functions function = token.getFunction();

        double value = !numberStack.isEmpty() ? numberStack.pop() : 0;
        numberStack.push(function.execute(value));

        return true;
    }
}

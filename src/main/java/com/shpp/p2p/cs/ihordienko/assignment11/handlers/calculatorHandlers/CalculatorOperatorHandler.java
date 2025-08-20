package com.shpp.p2p.cs.ihordienko.assignment11.handlers.calculatorHandlers;

import com.shpp.p2p.cs.ihordienko.assignment11.Token;
import com.shpp.p2p.cs.ihordienko.assignment11.enums.Operators;
import com.shpp.p2p.cs.ihordienko.assignment11.interfaces.CalculatorHandler;
import com.shpp.p2p.cs.ihordienko.assignment11.records.Variable;

import java.util.ArrayList;
import java.util.Stack;

/**
 * class provides core logic for handling calculation of operator token in expression
 */
public class CalculatorOperatorHandler implements CalculatorHandler {

    /**
     * takes last two numbers from the stack and pushes result of evaluating back
     * returns true if success, false if its not an operator
     */
    @Override
    public boolean handler(Token token, Stack<Double> numberStack, ArrayList<Variable> variables) {
        if (!token.isOperator()) {
            return false;
        }
        Operators operator = token.getOperator();

        if (operator == Operators.UNARY_MINUS) {
            numberStack.push(operator.execute(numberStack.pop(), null));
            return true;
        }

        double right = !numberStack.isEmpty() ? numberStack.pop() : 0;
        double left = !numberStack.isEmpty() ? numberStack.pop() : 0;
        numberStack.push(token.getOperator().execute(left, right));
        return true;
    }
}

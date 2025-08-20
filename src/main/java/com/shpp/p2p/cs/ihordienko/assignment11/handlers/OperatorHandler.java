package com.shpp.p2p.cs.ihordienko.assignment11.handlers;

import com.shpp.p2p.cs.ihordienko.assignment11.StackToken;
import com.shpp.p2p.cs.ihordienko.assignment11.Token;
import com.shpp.p2p.cs.ihordienko.assignment11.enums.Operators;
import com.shpp.p2p.cs.ihordienko.assignment11.interfaces.HandlerInterface;
import com.shpp.p2p.cs.ihordienko.assignment11.records.HandlerResult;
import com.shpp.p2p.cs.ihordienko.assignment11.records.Variable;

import java.util.ArrayList;
import java.util.Stack;

import static com.shpp.p2p.cs.ihordienko.assignment11.enums.Operators.*;

/**
 * class provides core logic for handling parsing of  operators in expression
 */
public class OperatorHandler implements HandlerInterface {

    /**
     * pushes everything with higher priority from the  stack until hit with less priority operator a
     * nd pushes representing token to opretator stack
     * returns instance of  HandlerResult record
     * if all vent good -> (true, index + 1)
     * if not a number -> (false, index)
     */
    @Override
    public HandlerResult handler(
            String formula,
            Stack<StackToken> operatorStack,
            StringBuilder numberBuffer,
            ArrayList<Token> result,
            ArrayList<Variable> variables,
            char character,
            int index
    ) {
        if (!isOperator(character)) {
            return new HandlerResult(false, index);
        }

        Operators op = getOperator(character);

        if (isUnaryMinus(op, formula, index)) {
            op = UNARY_MINUS;
        }
        getOperatorsWithHigherPriority(op, operatorStack, result);
        operatorStack.push(new StackToken(op));


        return new HandlerResult(true, index + 1);
    }

    /**
     * getOperatorsWithHigherPriority takes an operator as input
     * iterates through operator stack pushing operators with less priority to result list as tokens
     * until hit an operator with higher priority
     */
    private void getOperatorsWithHigherPriority(Operators op, Stack<StackToken> operatorStack, ArrayList<Token> result) {
        if (op.equals(OPEN_BRACE)) return;

        while (!operatorStack.empty()) {
            StackToken top = operatorStack.peek();

            if (!top.isOperator()) {
                result.add(new Token(operatorStack.pop().getFunction()));
            } else {
                Operators topOperator = top.getOperator();
                if (topOperator.getPriority() >= op.getPriority()) {
                    result.add(new Token(operatorStack.pop().getOperator()));
                } else {
                    break;
                }
            }
        }
    }

    /**
     * checks for unary_minus
     */
    private boolean isUnaryMinus(Operators op, String formula, int index) {
        if (op.equals(UNARY_MINUS)) return true;

        if (op.equals(MINUS)) {
            if (index == 0) {
                return true;
            }

            char previous = formula.charAt(index - 1);
            return isOperator(previous) || previous == OPEN_BRACE.getTitle();
        }

        return false;
    }
}

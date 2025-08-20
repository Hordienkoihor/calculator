package com.shpp.p2p.cs.ihordienko.assignment11.handlers;


import com.shpp.p2p.cs.ihordienko.assignment11.StackToken;
import com.shpp.p2p.cs.ihordienko.assignment11.Token;
import com.shpp.p2p.cs.ihordienko.assignment11.interfaces.HandlerInterface;
import com.shpp.p2p.cs.ihordienko.assignment11.records.HandlerResult;
import com.shpp.p2p.cs.ihordienko.assignment11.records.Variable;

import java.util.ArrayList;
import java.util.Stack;

import static com.shpp.p2p.cs.ihordienko.assignment11.enums.Operators.OPEN_BRACE;

/**
 * class provides core logic for handling parsing of  closing braces in expression
 */
public class CloseBracketHandler implements HandlerInterface {

    private static final char CLOSE_BRACE = ')';

    /**
     * pushes everything from operator stack until hit an open brace
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
        if (character != CLOSE_BRACE) {
            return new HandlerResult(false, index);
        }

        while (!operatorStack.empty()) {
            StackToken token = operatorStack.pop();
            if (token.isOperator()) {
                if (token.getOperator().getTitle() == (OPEN_BRACE.getTitle())) {
                    break;
                }
                result.add(new Token(token.getOperator()));
            } else if (token.isFunction()) {
                result.add(new Token(token.getFunction()));
            }
        }

        return new HandlerResult(true, index + 1);
    }

}

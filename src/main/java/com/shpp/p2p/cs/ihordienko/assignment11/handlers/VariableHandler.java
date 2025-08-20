package com.shpp.p2p.cs.ihordienko.assignment11.handlers;

import com.shpp.p2p.cs.ihordienko.assignment11.StackToken;
import com.shpp.p2p.cs.ihordienko.assignment11.Token;
import com.shpp.p2p.cs.ihordienko.assignment11.interfaces.HandlerInterface;
import com.shpp.p2p.cs.ihordienko.assignment11.records.HandlerResult;
import com.shpp.p2p.cs.ihordienko.assignment11.records.Variable;

import java.util.ArrayList;
import java.util.Stack;

/**
 * class provides core logic for handling parsing of variable  in expression
 */
public class VariableHandler implements HandlerInterface {

    /**
     * parses variable from given formula and pushes representing token to result list
     * returns instance of  HandlerResult record
     * if all vent good -> (true, newIndex)
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
        if (!isVariable(character, variables)) {
            return new HandlerResult(false, index);
        }

        handleVariable(character, result);
        return new HandlerResult(true, index + 1);
    }

    /**
     * checks if the character is a variable
     * */
    private boolean isVariable(char variable, ArrayList<Variable> variables) {
        for (Variable v : variables) {
            if (v.getTitle() == variable) return true;
        }
        return false;
    }

    /**
     * ads new Token with value of a matching variable to result list
     * else throw exception
     * */
    private void handleVariable(char variable, ArrayList<Token> result) {
        result.add(new Token(variable));
    }
}

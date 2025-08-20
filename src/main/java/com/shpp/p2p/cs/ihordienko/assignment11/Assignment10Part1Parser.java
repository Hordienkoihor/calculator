package com.shpp.p2p.cs.ihordienko.assignment11;

import com.shpp.p2p.cs.ihordienko.assignment11.handlers.*;
import com.shpp.p2p.cs.ihordienko.assignment11.interfaces.HandlerInterface;
import com.shpp.p2p.cs.ihordienko.assignment11.records.HandlerResult;
import com.shpp.p2p.cs.ihordienko.assignment11.records.Variable;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Assignment10Part1Calculator class handles core logic of parsing given expression to tokenised form
 */
public class Assignment10Part1Parser {

    /*Supported parsing handlers*/
    private static final List<HandlerInterface> HANDLERS = List.of(
            new NumberHandler(),
            new OperatorHandler(),
            new VariableHandler(),
            new CloseBracketHandler(),
            new FunctionHandler()
    );

    /**
     * parseEquation method handles formula transformation to a postfix notation
     * using reversed polish notation
     *
     * @param variables - variables to change in a parsed formula
     * @return parsed formula
     */
    public ArrayList<Token> parseExpression(String formula, ArrayList<Variable> variables) {
        StringBuilder numberBuffer = new StringBuilder();
        ArrayList<Token> result = new ArrayList<>();
        Stack<StackToken> operatorStack = new Stack<>();

        int i = 0;
        while (i < formula.length()) {
            char current = formula.charAt(i);
            i = parseCharacter(current, formula, i, variables, result, operatorStack, numberBuffer);
        }
        addLeftoverOperators(result, operatorStack);

        return result;
    }

    /// looking for type of character and applying specific functional to it
    private int parseCharacter(
            char character,
            String formula,
            int index,
            ArrayList<Variable> variables,
            ArrayList<Token> result,
            Stack<StackToken> operatorStack,
            StringBuilder numberBuffer
    ) {
        for (HandlerInterface handler : HANDLERS) {
            HandlerResult res = handler.handler(formula, operatorStack, numberBuffer, result, variables, character, index);

            if (res.success()) {
                return res.newIndex();
            }
        }
        throw new IllegalArgumentException("Unexpected: " + character);
    }

    /// pushes operators left in the stack as tokens to result array
    private void addLeftoverOperators(ArrayList<Token> result, Stack<StackToken> operatorStack) {
        while (!operatorStack.isEmpty()) {
            if (operatorStack.peek().isOperator()) {
                result.add(new Token(operatorStack.pop().getOperator()));
            } else {
                result.add(new Token(operatorStack.pop().getFunction()));
            }
        }
    }
}
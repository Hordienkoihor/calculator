package com.shpp.p2p.cs.ihordienko.assignment11.handlers;

import com.shpp.p2p.cs.ihordienko.assignment11.Assignment10Part1Parser;
import com.shpp.p2p.cs.ihordienko.assignment11.ExpressionParser;
import com.shpp.p2p.cs.ihordienko.assignment11.StackToken;
import com.shpp.p2p.cs.ihordienko.assignment11.Token;
import com.shpp.p2p.cs.ihordienko.assignment11.interfaces.HandlerInterface;
import com.shpp.p2p.cs.ihordienko.assignment11.records.HandlerResult;
import com.shpp.p2p.cs.ihordienko.assignment11.records.Variable;

import java.util.ArrayList;
import java.util.Stack;

import static com.shpp.p2p.cs.ihordienko.assignment11.enums.Functions.getFunction;
import static com.shpp.p2p.cs.ihordienko.assignment11.enums.Functions.isFunction;

/**
 * class provides logic to handle function instances of expression
 * works with instances of Functions enum
 * can handle variables and numbers as arguments
 */
public class FunctionHandler implements HandlerInterface {

    /*declares type of braces to enclose function argument*/
    private final static char OPEN_BRACE = '(';

    /*declares type of braces to enclose function argument*/
    private final static char CLOSE_BRACE = ')';

    /*defines minus sign*/
    private final static char MINUS = '-';

    /**
     * handles case when passed char is part of a function
     * works with instances of Functions enum
     * can handle variables and numbers as arguments
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
        String subString = formula.substring(index, formula.length());
        int openBracketIndex = subString.indexOf('(');

        //if substring has no open brace its not a function
        if (openBracketIndex == -1) {
            return new HandlerResult(false, index);
        }

        //check for function support
        String expectedFunction = subString.substring(0, openBracketIndex);

        if (!isFunction(expectedFunction)) {
            return new HandlerResult(false, index);
        }


        //indexes of braces enclosing argument
        int openBraceIndex = index + expectedFunction.length();
        int closeBraceIndex = getClosingBracket(formula, openBraceIndex);
        String argument = formula.substring(openBraceIndex + 1, closeBraceIndex);

        ExpressionParser parser = new ExpressionParser();
        Assignment10Part1Parser assignment10Parser = new Assignment10Part1Parser();
        result.addAll(assignment10Parser.parseExpression(parser.stripSpaces(argument), variables));

        result.add(new Token(getFunction(expectedFunction)));

        return new HandlerResult(true, closeBraceIndex + 1);
    }

    /**
     * implements mechanism of counting brackets inside function arguments
     * returns index of bracket closing for open bracket at start index
     **/
    private int getClosingBracket(String formula, int start) {
        int current = start;
        int depth = 0;

        while (current < formula.length()) {
            char ch = formula.charAt(current);
            if (ch == OPEN_BRACE) {
                depth++;
            } else if (ch == CLOSE_BRACE) {
                depth--;
                if (depth == 0) {
                    break;
                }
            }
            current++;
        }
        return current;
    }
}


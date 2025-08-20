package com.shpp.p2p.cs.ihordienko.assignment11.handlers;

import com.shpp.p2p.cs.ihordienko.assignment11.StackToken;
import com.shpp.p2p.cs.ihordienko.assignment11.Token;
import com.shpp.p2p.cs.ihordienko.assignment11.enums.Operators;
import com.shpp.p2p.cs.ihordienko.assignment11.interfaces.HandlerInterface;
import com.shpp.p2p.cs.ihordienko.assignment11.records.HandlerResult;
import com.shpp.p2p.cs.ihordienko.assignment11.records.Variable;

import java.util.ArrayList;
import java.util.Stack;

/**
 * class provides core logic for handling parsing of number  in expression
 */
public class NumberHandler implements HandlerInterface {

    private static final char DOT = '.';

    /**
     * parses number from given formula and pushes representing token to result list
     * returns instance of  HandlerResult record
     * if all vent good -> (true, newIndex)
     * if not a number -> (false, index)
     * throws exception if number is corrupted
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
        if (!isPartOfANumber(formula, index, character)) {
            return new HandlerResult(false, index);
        }

        int newIndex = index;
        while (newIndex < formula.length() && isPartOfANumber(formula, newIndex, formula.charAt(newIndex))) {
            numberBuffer.append(formula.charAt(newIndex));
            newIndex++;
        }

        result.add(new Token(Double.parseDouble(numberBuffer.toString())));
        numberBuffer.setLength(0);
        return new HandlerResult(true, newIndex);
    }

    /// checks for character to be a part of the number
    private boolean isPartOfANumber(String formula, int index, char character) {
        validateNumberPart(formula, character, index);
        return (Character.isDigit(character) || isDot(character));
    }

    /// checks if character is what is defined as dot
    private boolean isDot(char character) {
        return (DOT == character);
    }

    /**
     * validateNumberPart checks for dot being in cases:
     * first in a formula;
     * going after an operator
     */
    private void validateNumberPart(String formula, char current, int index) {
        if (isDot(current)) {
            if (index == 0) {
                throw new NumberFormatException("Formula Error: number can't start with a dot");
            }

            char previous = formula.charAt(index - 1);

            if (Operators.isOperator(previous)) {
                throw new NumberFormatException("Formula Error: dot can't follow operator directly");
            }

            if (isDot(previous)) {
                throw new NumberFormatException("Formula Error: dot can't follow another dot");
            }
        }
    }
}

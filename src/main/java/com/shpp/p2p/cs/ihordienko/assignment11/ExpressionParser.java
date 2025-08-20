package com.shpp.p2p.cs.ihordienko.assignment11;

import com.shpp.p2p.cs.ihordienko.assignment11.exceptions.InvalidExpressionException;
import com.shpp.p2p.cs.ihordienko.assignment11.exceptions.NoExpressionProvidedException;
import com.shpp.p2p.cs.ihordienko.assignment11.exceptions.NoVariableProvidedException;
import com.shpp.p2p.cs.ihordienko.assignment11.exceptions.VariableFormatException;
import com.shpp.p2p.cs.ihordienko.assignment11.records.Variable;

import java.util.ArrayList;

/**
 * class provides instruments to parse expression and variables from args[] or any String[]
 */
public class ExpressionParser {
    /*symbol representing separator between variable name and value*/
    private static final char VARIABLE_SEPARATOR = '=';
    /*minimal length of the string to be treated as variable*/
    private static final int MIN_VARIABLE_LENGTH = 3;

    /*open brace value*/
    private static final int OPEN_BRACE = '(';
    /*close brace value*/
    private static final int CLOSE_BRACE = ')';

    /**
     * parseVariable returns instance of Variable record from string representing it
     *
     * @return new Variable with set name and value
     */
    public Variable parseVariable(String variable) {
        if (variable.length() < MIN_VARIABLE_LENGTH) {
            throw new NoVariableProvidedException("Error: not a valid variable");
        }

        try {
            return new Variable(variable.charAt(0), Double.parseDouble(variable.substring(variable.indexOf(VARIABLE_SEPARATOR) + 1)));
        } catch (NumberFormatException e) {
            throw new VariableFormatException("Error: not a valid variable, must be a number");
        }
    }

    /**
     * getExpression method takes expression from args, with all spaces cleared
     */
    public String getExpression(String[] args) {
        if (args == null || args.length == 0) {
            throw new NoExpressionProvidedException("Error: no expression provided");
        }

        if (!countBraces(args[0])) {
            throw new InvalidExpressionException("Error: braces don't match");
        }

        return stripSpaces(args[0].toLowerCase());
    }

    /**
     * getVariables method gets array of args, parsing variables from it
     * assuming variables start from index of 1
     */
    public ArrayList<Variable> getVariables(String[] args) {
        ArrayList<Variable> variables = new ArrayList<>();
        for (int i = 1; i < args.length; i++) {
            variables.add(parseVariable(stripSpaces(args[i])));
        }
        return variables;
    }

    /**
     * clears string from spaces
     */
    public String stripSpaces(String s) {
        return s.replaceAll("\\s+", "");
    }

    /**
     * counts each braces type is string
     *  if numbers not equal return false
     *  else return true
     * */
    private boolean countBraces(String s) {
        int openBraceCounter = 0;
        int closeBraceCounter = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == OPEN_BRACE) {
                openBraceCounter++;
            }
            if (s.charAt(i) == CLOSE_BRACE) {
                closeBraceCounter++;
            }

        }
        return openBraceCounter == closeBraceCounter;
    }
}

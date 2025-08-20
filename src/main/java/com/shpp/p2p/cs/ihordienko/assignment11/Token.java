package com.shpp.p2p.cs.ihordienko.assignment11;

import com.shpp.p2p.cs.ihordienko.assignment11.enums.Functions;
import com.shpp.p2p.cs.ihordienko.assignment11.enums.Operators;
import com.shpp.p2p.cs.ihordienko.assignment11.exceptions.IncorrectTokenType;

/**
 * Token class defines token for parsed expression
 * can be two types, ether operator or a number
 */
public class Token {
    //class fields
    private final TokenType type;
    private double number;
    private Operators operator;
    private char variableName;
    private Functions function;

    //constructor for number
    public Token(double number) {
        this.type = TokenType.NUMBER;
        this.number = number;
    }

    //constructor for operator
    public Token(Operators operator) {
        this.type = TokenType.OPERATOR;
        this.operator = operator;
    }

    public Token(char variable) {
        this.type = TokenType.VARIABLE;
        this.variableName = variable;
    }

    public Token(Functions function) {
        this.type = TokenType.FUNCTION;
        this.function = function;
    }

    /**
     * returns boolean value of is the token type an operator
     */
    public boolean isOperator() {
        return type == TokenType.OPERATOR;
    }

    /**
     * returns boolean value of is the token type a number
     */
    public boolean isNumber() {
        return type == TokenType.NUMBER;
    }

    public boolean isVariable() {
        return type == TokenType.VARIABLE;
    }

    public boolean isFunction() {
        return type == TokenType.FUNCTION;
    }

    /**
     * returns operator nested in token
     */
    public Operators getOperator() {
        if (type != TokenType.OPERATOR) {
            throw new IncorrectTokenType("Not an operator");
        }
        return operator;
    }

    /**
     * returns number nested in token
     */
    public double getNumber() {
        if (type != TokenType.NUMBER) {
            throw new IncorrectTokenType("Not a number");
        }
        return number;
    }

    /**
     * returns variable name nested in token
     */
    public char getVariable() {
        if (type != TokenType.VARIABLE) {
            throw new IncorrectTokenType("Not a variable");
        }

        return variableName;
    }

    /**
     * returns name nested in token
     */
    public Functions getFunction() {
        if (type != TokenType.FUNCTION) {
            throw new IncorrectTokenType("Not a variable");
        }

        return function;
    }

    @Override
    public String toString() {
        return type + " " + operator + " " + number + " " + variableName;
    }


    private enum TokenType {
        OPERATOR, NUMBER, FUNCTION, VARIABLE,
    }
}

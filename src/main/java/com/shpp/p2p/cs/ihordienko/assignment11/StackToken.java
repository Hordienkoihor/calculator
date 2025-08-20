package com.shpp.p2p.cs.ihordienko.assignment11;

import com.shpp.p2p.cs.ihordienko.assignment11.enums.Functions;
import com.shpp.p2p.cs.ihordienko.assignment11.enums.Operators;
import com.shpp.p2p.cs.ihordienko.assignment11.exceptions.IncorrectTokenType;

public class StackToken {
    //class fields
    private final StackToken.TokenType type;
    private Operators operator;
    private Functions function;

    //constructor for operator
    public StackToken(Operators operator) {
        this.type = StackToken.TokenType.OPERATOR;
        this.operator = operator;
    }

    public StackToken(Functions function) {
        this.type = StackToken.TokenType.FUNCTION;
        this.function = function;
    }

    /**
     * returns boolean value of is the token type an operator
     */
    public boolean isOperator() {
        return type == StackToken.TokenType.OPERATOR;
    }

    public boolean isFunction() {
        return type == StackToken.TokenType.FUNCTION;
    }

    /**
     * returns operator nested in token
     */
    public Operators getOperator() {
        if (type != StackToken.TokenType.OPERATOR) {
            throw new IncorrectTokenType("Not an operator");
        }
        return operator;
    }

    /**
     * returns name nested in token
     */
    public Functions getFunction() {
        if (type != StackToken.TokenType.FUNCTION) {
            throw new IncorrectTokenType("Not a variable");
        }

        return function;
    }

    @Override
    public String toString() {
        return type + " " + operator + " " + function;
    }

    private enum TokenType {
        OPERATOR,
        FUNCTION,
    }
}

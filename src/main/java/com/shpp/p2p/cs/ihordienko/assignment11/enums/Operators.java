package com.shpp.p2p.cs.ihordienko.assignment11.enums;

import com.shpp.p2p.cs.ihordienko.assignment11.exceptions.OperatorNotFoundException;
import com.shpp.p2p.cs.ihordienko.assignment11.interfaces.ExecuteOperator;

/**
 * ENUM representing each operator supported in the program
 * defines exclusive execute functional for each operator
 */
public enum Operators implements ExecuteOperator {
    PLUS('+', 0) {
        public Double execute(Double num1, Double num2) {
            return num1 + num2;
        }
    },
    MINUS('-', 0) {
        public Double execute(Double num1, Double num2) {
            return num1 - num2;
        }
    },
    MULTIPLY('*', 2) {
        public Double execute(Double num1, Double num2) {
            return num1 * num2;
        }
    },
    DIVIDE('/', 2) {
        public Double execute(Double num1, Double num2) {
            if (num2 == 0) {
                throw new ArithmeticException("Division by zero");
            }
            return num1 / num2;
        }
    },
    POW('^', 3) {
        public Double execute(Double num1, Double num2) {
            return Math.pow(num1, num2);
        }
    },
    UNARY_MINUS('~', 4) {
        public Double execute(Double num1, Double num2) {
            return -num1;
        }
    },
    OPEN_BRACE('(', -1) {
        public Double execute(Double num1, Double num2) {
            return null;
        }
    };

    /*tittle of an operator*/
    private final char title;
    /*priority of an operator*/
    private final int priority;

    Operators(char title, int priority) {
        this.title = title;
        this.priority = priority;
    }

    /**
     * method checks for at least 1 entry of given title
     * returns true if found, false if not
     */
    public static boolean isOperator(char ch) {
        for (Operators op : Operators.values()) {
            if (op.title == ch) {
                return true;
            }
        }
        return false;
    }

    /**
     * method checks for at least 1 entry of given title
     * returns operator if found, null if not
     */
    public static Operators getOperator(char title) {
        for (Operators op : Operators.values()) {
            if (op.title == title) {
                return op;
            }
        }
        throw new OperatorNotFoundException();
    }

    /*returns operator title*/
    public char getTitle() {
        return title;
    }

    /*returns operator priority*/
    public int getPriority() {
        return priority;
    }
}

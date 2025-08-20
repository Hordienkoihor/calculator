package com.shpp.p2p.cs.ihordienko.assignment11.enums;

import com.shpp.p2p.cs.ihordienko.assignment11.exceptions.FunctionNotFoundException;
import com.shpp.p2p.cs.ihordienko.assignment11.interfaces.ExecuteFunction;

/**
 * ENUM representing each function supported in the program
 * defines exclusive execute functional for each function
 */
public enum Functions implements ExecuteFunction {
    SIN("sin") {
        public double execute(double input) {
            return Math.sin(input);
        }
    },
    COS("cos") {
        public double execute(double input) {
            return Math.cos(input);
        }
    },
    TAN("tan") {
        public double execute(double input) {
            return Math.tan(input);
        }
    },
    ATAN("atan") {
        public double execute(double input) {
            return Math.atan(input);
        }
    },
    LOG10("log10") {
        public double execute(double input) {
            if (input <= 0){
                throw new IllegalArgumentException("cant get log from negative value or 0");

            }

            return Math.log10(input);
        }
    },
    LOG2("log2") {
        public double execute(double input) {
            if (input <= 0){
                throw new IllegalArgumentException("cant get log from negative value or 0");

            }

            return (Math.log(input) /  Math.log(2));
        }
    },
    SQRT("sqrt") {
        public double execute(double input) {
            if (input < 0){
                throw new IllegalArgumentException("cant get sqrt from negative value");

            }
            
            return Math.sqrt(input);
        }
    };

    /*title of a function*/
    private final String title;

    /*standard constructor*/
    Functions(String title) {
        this.title = title;
    }

    /**
     * method checks for function with the same title
     * returns true if found, false if not
     */
    public static boolean isFunction(String name) {
        for (Functions fn : Functions.values()) {
            if (fn.title.equals(name)) {
                return true;
            }
        }
        return false;
    }

    /**
     * method looks for function with the same title
     * returns found function if found, throws exception if not
     */
    public static Functions getFunction(String name) {
        for (Functions fn : Functions.values()) {
            if (fn.title.equals(name)) {
                return fn;
            }
        }
        throw new FunctionNotFoundException("Unknown function: " + name);
    }

    public String getTitle() {
        return title;
    }

}

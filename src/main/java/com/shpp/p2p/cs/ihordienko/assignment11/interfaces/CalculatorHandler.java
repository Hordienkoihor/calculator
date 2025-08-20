package com.shpp.p2p.cs.ihordienko.assignment11.interfaces;

import com.shpp.p2p.cs.ihordienko.assignment11.Token;
import com.shpp.p2p.cs.ihordienko.assignment11.records.Variable;

import java.util.ArrayList;
import java.util.Stack;

/**
 * interface describing calculation handler
 */
@FunctionalInterface
public interface CalculatorHandler {
    boolean handler(Token token, Stack<Double> numberStack, ArrayList<Variable> variables);
}

package com.shpp.p2p.cs.ihordienko.assignment11.interfaces;

import com.shpp.p2p.cs.ihordienko.assignment11.StackToken;
import com.shpp.p2p.cs.ihordienko.assignment11.Token;
import com.shpp.p2p.cs.ihordienko.assignment11.records.HandlerResult;
import com.shpp.p2p.cs.ihordienko.assignment11.records.Variable;

import java.util.ArrayList;
import java.util.Stack;

/**
 * interface describing parsing handler
 * */
@FunctionalInterface
public interface HandlerInterface {
    HandlerResult handler(
            String formula,
            Stack<StackToken> operatorStack,
            StringBuilder numberBuffer,
            ArrayList<Token> result,
            ArrayList<Variable> variables,
            char character,
            int index
            );
}

package com.shpp.p2p.cs.ihordienko.assignment11.exceptions;

public class OperatorNotFoundException extends RuntimeException {
    public OperatorNotFoundException(String message) {
        super(message);
    }

    public OperatorNotFoundException() {
        super();
    }
}

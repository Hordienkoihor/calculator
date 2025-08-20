package com.shpp.p2p.cs.ihordienko.assignment11.exceptions;

public class NoExpressionProvidedException extends RuntimeException {
    public NoExpressionProvidedException(String message) {
        super(message);
    }

    public NoExpressionProvidedException() {
        super();
    }
}

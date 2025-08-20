package com.shpp.p2p.cs.ihordienko.assignment11.exceptions;

public class NoVariableProvidedException extends RuntimeException {
    public NoVariableProvidedException(String message) {
        super(message);
    }

    public NoVariableProvidedException() {
        super();
    }
}

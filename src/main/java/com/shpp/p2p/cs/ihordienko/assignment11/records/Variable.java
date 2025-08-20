package com.shpp.p2p.cs.ihordienko.assignment11.records;

public record Variable(char title, double value) {
    public char getTitle() {
        return title;
    }

    public double getValue() {
        return value;
    }
}

package com.shpp.p2p.cs.ihordienko.assignment11.records;

/**
 * record used as result for handler operation
 * value success indicates success of the handling
 * value newIndex returns index where handler ended its work
 * */
public record HandlerResult(boolean success, int newIndex) {
}

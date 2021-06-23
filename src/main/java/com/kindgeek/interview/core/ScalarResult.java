package com.kindgeek.interview.core;

public class ScalarResult extends Result {

    private final int value;

    public ScalarResult(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

package com.kindgeek.interview.core;

import java.util.List;

public class ListResult extends Result {

    private final List<Integer> value;

    public ListResult(List<Integer> value) {
        this.value = value;
    }

    public List<Integer> getValue() {
        return value;
    }
}

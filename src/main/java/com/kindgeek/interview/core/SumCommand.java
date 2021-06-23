package com.kindgeek.interview.core;

import java.util.List;

public class SumCommand implements Command {

    @Override
    public ScalarResult execute(List<Integer> input) {
        if (input == null) {
            throw new NullPointerException("input is null");
        }

        int sum = input.stream().mapToInt(item -> item).sum();

        return new ScalarResult(sum);
    }
}

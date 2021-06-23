package com.kindgeek.interview.core;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ZipCommand implements Command {

    private final List<Integer> config;

    public ZipCommand(List<Integer> config) {
        this.config = Objects.requireNonNull(config);
    }

    @Override
    public ListResult execute(List<Integer> input) {
        if (input == null) {
            throw new NullPointerException("input is null");
        }

        int inputSize = input.size();
        int configSize = config.size();

        var result = IntStream.range(0, Math.max(inputSize, configSize))
                .map(index -> (index < inputSize ? input.get(index) : 0) + (index < configSize ? config.get(index) : 0))
                .boxed()
                .collect(Collectors.toList());

        return new ListResult(result);
    }
}

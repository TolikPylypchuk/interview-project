package com.kindgeek.interview.core;

import java.util.List;

public class DistinctCommand implements Command {

    @Override
    public Result execute(List<Integer> input) {
        if (input == null) {
            throw new NullPointerException("input");
        }

        var sortCommand = new SortCommand();
        var result = sortCommand.execute(input);
        var sortedInput = result.getValue();

        return null;
    }
}

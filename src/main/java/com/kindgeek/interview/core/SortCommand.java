package com.kindgeek.interview.core;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SortCommand implements Command {

    @Override
    public ListResult execute(List<Integer> input) {
        if (input == null) {
            throw new NullPointerException("input is null");
        }

        var copy = new ArrayList<>(input);
        copy.sort(Comparator.naturalOrder());

        return new ListResult(copy);
    }
}

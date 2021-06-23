package com.kindgeek.interview.core;

import java.util.List;

public interface Command {

    Result execute(List<Integer> input);
}

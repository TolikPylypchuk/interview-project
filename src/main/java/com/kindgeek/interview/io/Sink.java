package com.kindgeek.interview.io;

import com.kindgeek.interview.core.Result;

public interface Sink {

    void write(Result result) throws Exception;
}

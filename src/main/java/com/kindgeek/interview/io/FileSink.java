package com.kindgeek.interview.io;

import com.kindgeek.interview.core.ListResult;
import com.kindgeek.interview.core.Result;
import com.kindgeek.interview.core.ScalarResult;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;

public class FileSink implements Sink {

    private final String path;

    public FileSink(String path) {
        this.path = path;
    }

    @Override
    public void write(Result result) throws Exception {
        try (var writer = Files.newBufferedWriter(Path.of(path))) {
            if (result instanceof ScalarResult scalarResult) {
                writer.write(scalarResult.getValue());
            } else if (result instanceof ListResult listResult) {
                var content = listResult.getValue().stream().map(Object::toString).collect(Collectors.joining(","));
                writer.write(content);
            }
        }
    }
}

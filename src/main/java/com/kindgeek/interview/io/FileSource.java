package com.kindgeek.interview.io;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FileSource implements Source {

    private final String path;

    public FileSource(String path) {
        this.path = path;
    }

    @Override
    public List<Integer> readInput() throws Exception {
        try (var reader = Files.newBufferedReader(Path.of(path))) {
            return reader.lines()
                    .flatMap(line -> Arrays.stream(line.split(",")))
                    .map(Integer::valueOf)
                    .collect(Collectors.toList());
        }
    }
}

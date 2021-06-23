package com.kindgeek.interview;

import com.kindgeek.interview.core.*;
import com.kindgeek.interview.io.FileSink;
import com.kindgeek.interview.io.FileSource;
import com.kindgeek.interview.io.Sink;
import com.kindgeek.interview.io.Source;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class Main {

    public static void main(String[] args) throws Exception {
        var cmd = parseCommandLine(args);
        var command = createCommand(cmd);

        var source = createInputSource(cmd);
        var input = source.readInput();

        var result = command.execute(input);

        var sink = createSink(cmd);
        sink.write(result);
    }

    private static CommandLine parseCommandLine(String[] args) throws ParseException {
        var options = new Options();

        options.addOption("cmd", true, "command to execute");
        options.addOption("input", true, "the input source");
        options.addOption("input-type", true, "the input type");
        options.addOption("output", true, "the output sink");
        options.addOption("output-type", true, "the output type");
        options.addOption("config", true, "the config source");
        options.addOption("config-type", true, "the config type");

        var parser = new DefaultParser();

        return parser.parse(options, args);
    }

    private static Command createCommand(CommandLine cmd) throws Exception {
        return switch (cmd.getOptionValue("cmd").toLowerCase()) {
            case "sum" -> new SumCommand();
            case "sort" -> new SortCommand();
            case "distinct" -> new DistinctCommand();
            case "zip" -> {
                var source = createConfigSource(cmd);
                yield new ZipCommand(source.readInput());
            }
            default -> throw new RuntimeException("Wrong command");
        };
    }

    private static Source createInputSource(CommandLine cmd) {
        return switch (cmd.getOptionValue("input-type").toLowerCase()) {
            case "file" -> new FileSource(cmd.getOptionValue("input"));
            default -> throw new RuntimeException("Wrong input type");
        };
    }

    private static Source createConfigSource(CommandLine cmd) {
        return switch (cmd.getOptionValue("config-type").toLowerCase()) {
            case "file" -> new FileSource(cmd.getOptionValue("config"));
            default -> throw new RuntimeException("Wrong config type");
        };
    }

    private static Sink createSink(CommandLine cmd) {
        return switch (cmd.getOptionValue("output-type").toLowerCase()) {
            case "file" -> new FileSink(cmd.getOptionValue("output"));
            default -> throw new RuntimeException("Wrong output type");
        };
    }
}

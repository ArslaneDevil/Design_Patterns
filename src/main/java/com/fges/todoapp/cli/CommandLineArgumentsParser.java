package com.fges.todoapp.cli;

import org.apache.commons.cli.*;

public class CommandLineArgumentsParser {

    public static CommandLine parseArguments(String[] args) throws ParseException {
        Options clioptions = new Options();
        clioptions.addRequiredOption("s", "source", true, "File containing the todos");
        clioptions.addOption("d", "done", false, "Mark todo as done");
        clioptions.addOption("o", "output", true, "Output file for migration");

        DefaultParser parser = new DefaultParser();

        return parser.parse(clioptions, args);
    }
}
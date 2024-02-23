package com.fges.todoapp;

import com.fges.todoapp.cli.CommandLineArgumentsParser;
import com.fges.todoapp.model.TodoItem;
import com.fges.todoapp.repository.CsvTodoRepository;
import com.fges.todoapp.repository.JsonTodoRepository;
import com.fges.todoapp.repository.TodoRepository;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.ParseException;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public class App {

    public static void main(String[] args) throws Exception {
        System.exit(exec(args));
    }

    public static int exec(String[] args) throws IOException, ParseException {
        CommandLine cmd = CommandLineArgumentsParser.parseArguments(args);
        String fileName = cmd.getOptionValue("s");
        boolean isDone = cmd.hasOption("done");
        TodoRepository repository;

        List<String> positionalArgs = cmd.getArgList();
        if (positionalArgs.isEmpty()) {
            System.err.println("Missing Command");
            return 1;
        }

        String command = positionalArgs.get(0);

        Path filePath = Path.of(fileName);
        if (fileName.endsWith(".json")) {
            repository = new JsonTodoRepository(filePath);
        } else if (fileName.endsWith(".csv")) {
            repository = new CsvTodoRepository(filePath);
        } else {
            throw new IllegalArgumentException("Unsupported file format");
        }

        if (command.equals("insert") && args.length > 1) {
            TodoItem newItem = new TodoItem(positionalArgs.get(1), isDone);
            repository.insert(newItem);
        } else if (command.equals("list")) {
            repository.findAll(isDone); // Vous devrez modifier cette méthode pour filtrer par l'état done si nécessaire
        } else {
            System.err.println("Unsupported command");
            return 1;
        }

        System.err.println("Done.");
        return 0;
    }
}

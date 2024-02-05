package com.fges.todoapp;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;

public class TodoCommandHandler {
    private FileReader fileReader;
    private FileWriter fileWriter;

    public TodoCommandHandler(String fileName) {
        Path filePath = Paths.get(fileName);
        if (fileName.endsWith(".json")) {
            this.fileReader = new JsonFileReader(filePath);
            this.fileWriter = new JsonFileWriter(filePath);
        } else if (fileName.endsWith(".csv")) {
            // sdfdsfds
            // Initialize CSV reader and writer
            // this.fileReader = new CsvFileReader(filePath);
            // this.fileWriter = new CsvFileWriter(filePath);
        }
    }

    public void executeCommand(String command, String[] args) throws IOException {
        switch (command) {
            case "insert":
                if (args.length < 1) throw new IllegalArgumentException("Missing TODO name");
                String todo = args[0];
                fileWriter.writeTodo(todo);
                break;
            case "list":
                fileReader.readTodos().forEach(System.out::println);
                break;
            default:
                throw new IllegalArgumentException("Unknown command: " + command);
        }
    }
}

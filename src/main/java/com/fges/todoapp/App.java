package com.fges.todoapp;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.fges.todoapp.Storage.Todo.CSV.TodoReaderCSVStorage;
import com.fges.todoapp.Storage.Todo.CSV.TodoWriterCSVStorage;
import com.fges.todoapp.Storage.Todo.Json.TodoReaderJsonStorage;
import com.fges.todoapp.Storage.Todo.Json.TodoWriterJsonStorage;
import com.fges.todoapp.Storage.Todo.service.TodoWriterStorage;
import org.apache.commons.cli.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Hello world!
 */
public class App {

    /**
     * Do not change this method
     */
    public static void main(String[] args) throws Exception {
        System.exit(exec(args));
    }

    public static int exec(String[] args) throws Exception {
        Options cliOptions = new Options();
        CommandLineParser parser = new DefaultParser();

        cliOptions.addRequiredOption("s", "source", true, "File containing the todos");

        CommandLine cmd;
        try {
            cmd = parser.parse(cliOptions, args);
        } catch (ParseException ex) {
            System.err.println("Fail to parse arguments: " + ex.getMessage());
            return 1;
        }

        String fileName = cmd.getOptionValue("s");

        List<String> positionalArgs = cmd.getArgList();
        if (positionalArgs.isEmpty()) {
            System.err.println("Missing Command");
            return 1;
        }

        String command = positionalArgs.get(0);

        Path filePath = Paths.get(fileName);

        String fileContent = "";

        if (Files.exists(filePath)) {
            fileContent = Files.readString(filePath);
        }

        if (command.equals("insert")) {
            if (positionalArgs.size() < 2) {
                System.err.println("Missing TODO name");
                return 1;
            }
            String todo = positionalArgs.get(1);

            if (fileName.endsWith(".json")) {
                // JSON
                /*
                ObjectMapper mapper = new ObjectMapper();
                JsonNode actualObj = mapper.readTree(fileContent);
                if (actualObj instanceof MissingNode) {
                    // Node was not reconised
                    actualObj = JsonNodeFactory.instance.arrayNode();
                }

                if (actualObj instanceof ArrayNode arrayNode) {
                    arrayNode.add(todo);
                }

                Files.writeString(filePath, actualObj.toString());
                */
                TodoWriterJsonStorage Add_todo = new TodoWriterJsonStorage(fileContent, filePath);
                Add_todo.writeTodo(todo);
            }

            if (fileName.endsWith(".csv")) {
                // CSV
                /*
                if (!fileContent.endsWith("\n") && !fileContent.isEmpty()) {
                    fileContent += "\n";
                }
                fileContent += todo;

                Files.writeString(filePath, fileContent);
                */
                TodoWriterCSVStorage Add_todo = new TodoWriterCSVStorage(fileContent, filePath);
                Add_todo.writeTodo(todo);
            }

        }


        if (command.equals("list")) {
            if (fileName.endsWith(".json")) {
                // JSON
                /*
                ObjectMapper mapper = new ObjectMapper();
                JsonNode actualObj = mapper.readTree(fileContent);
                if (actualObj instanceof MissingNode) {
                    // Node was not recognised
                    actualObj = JsonNodeFactory.instance.arrayNode();
                }

                if (actualObj instanceof ArrayNode arrayNode) {
                    arrayNode.forEach(node -> System.out.println("- " + node.toString()));
                }
                 */
                TodoReaderJsonStorage list_todos = new TodoReaderJsonStorage(fileContent);
                list_todos.listTodo();
            }
            if (fileName.endsWith(".csv")) {
                // CSV
                /*
                System.out.println(Arrays.stream(fileContent.split("\n"))
                        .map(todo -> "- " + todo)
                        .collect(Collectors.joining("\n"))
                );
                 */
                TodoReaderCSVStorage list_todos = new TodoReaderCSVStorage(fileContent);
                list_todos.listTodo();
            }
        }

        System.err.println("Done.");
        return 0;
    }
}
package com.fges.todoapp;

import com.fges.todoapp.web.TodoServer;
import com.fges.todoapp.Service.TodoService;
import com.fges.todoapp.Storage.TodoStorageFactory;
import com.fges.todoapp.cli.CommandLineArgumentsParser;
import com.fges.todoapp.Storage.TodoStorage;
import com.fges.todoapp.model.TodoItem;

import com.fges.todoapp.web.provider.TodoProvider;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.ParseException;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public class App {

    public static void main(String[] args) throws Exception {
        System.exit(exec(args));
    }

    public static int exec(String[] args) throws IOException, ParseException, InterruptedException {
        CommandLine cmd = CommandLineArgumentsParser.parseArguments(args);
        String fileName = cmd.getOptionValue("s");
        boolean isDone = cmd.hasOption("done");
        Path path = Path.of(fileName);
        TodoStorageFactory todoStorageFactory = new TodoStorageFactory(path);
        TodoStorage todoStorage = todoStorageFactory.getTodoStorage(fileName);
        TodoProvider todoProvider = new TodoProvider(todoStorage);

        if (todoStorage == null) {
            System.err.println("Unknown storage type, exiting...");
            System.exit(1);
        }

        var todoService = new TodoService(todoStorage);

        List<String> positionalArgs = cmd.getArgList();
        if (positionalArgs.isEmpty()) {
            System.err.println("Missing Command");
            return 1;
        }

        String command = positionalArgs.get(0);

        switch (command) {
            case "migrate" -> todoService.migrate(cmd);
            case "insert" -> {
                TodoItem newItem = new TodoItem(positionalArgs.get(1), isDone);
                todoService.insert(newItem);
            }
            case "list" -> todoService.listTodos(isDone);
            case "web" -> {
                int port = Integer.parseInt(cmd.getOptionValue("port", "8888"));
                TodoServer todoServer = new TodoServer(todoProvider,port);
                todoServer.start();
                Thread.sleep(300000);
            }
            default -> System.err.println("Error Command");
        }

        System.err.println("Done.");
        return 0;
    }
}

package com.fges.todoapp.Service;

import com.fges.todoapp.Storage.TodoStorage;
import com.fges.todoapp.Storage.TodoStorageFactory;
import com.fges.todoapp.model.TodoItem;

import org.apache.commons.cli.CommandLine;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public class TodoMigrate {
    public void migrate(CommandLine cmd, TodoStorage todoStorage) throws IOException {
        String outputFileName = cmd.getOptionValue("output");
        Path outputPath = Path.of(outputFileName);
        TodoStorageFactory todoStorageFactory = new TodoStorageFactory(outputPath);
        TodoStorage outputRepository = todoStorageFactory.getTodoStorage(outputFileName);
        List<TodoItem> todos = todoStorage.getAllTodos();
        for (TodoItem todo : todos) {
            outputRepository.insert(todo);
        }
    }
}

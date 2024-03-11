package com.fges.todoapp.Storage.Csv;

import com.fges.todoapp.model.TodoItem;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class TodoCsvGetAll extends AbtractTodoCsvStorage{

    protected TodoCsvGetAll(Path filePath) {
        super(filePath);
    }

    public List<TodoItem> getAllTodos() throws IOException {
        List<TodoItem> todos = new ArrayList<>();
        if (Files.exists(filePath)) {
            List<String> lines = Files.readAllLines(filePath);
            for (String line : lines) {
                boolean done = line.startsWith("Done: ");
                String name = done ? line.substring(6) : line;
                todos.add(new TodoItem(name, done));
            }
        }
        return todos;
    }
}

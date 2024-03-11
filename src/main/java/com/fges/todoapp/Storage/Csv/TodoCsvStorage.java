package com.fges.todoapp.Storage.Csv;

import com.fges.todoapp.Storage.TodoStorage;
import com.fges.todoapp.model.TodoItem;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public class TodoCsvStorage implements TodoStorage {
    private final Path filePath;

    public TodoCsvStorage(Path filePath) {
        this.filePath = filePath;
    }

    @Override
    public void insert(TodoItem item) throws IOException {
        new TodoCsvInsert(filePath).insert(item);
    }

    @Override
    public void findAll(boolean onlyDone) throws IOException {
        new TodoCsvList(filePath).findAll(onlyDone);
    }
    @Override
    public List<TodoItem> getAllTodos() throws IOException {
        return new TodoCsvGetAll(filePath).getAllTodos();
    }

}

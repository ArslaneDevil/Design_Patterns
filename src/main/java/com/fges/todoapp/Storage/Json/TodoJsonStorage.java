package com.fges.todoapp.Storage.Json;

import com.fges.todoapp.Storage.TodoStorage;
import com.fges.todoapp.model.TodoItem;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public class TodoJsonStorage implements TodoStorage {

    private final Path filePath;

    public TodoJsonStorage(Path filePath) {
        this.filePath = filePath;
    }

    @Override
    public void insert(TodoItem item) throws IOException {
        new TodoJsonInsert(filePath).insert(item);
    }

    @Override
    public void findAll(boolean onlyDone) throws IOException {
        new TodoJsonList(filePath).findAll(onlyDone);
    }

    @Override
    public List<TodoItem> getAllTodos() throws IOException {
        return new TodoJsonGetAll(filePath).getAllTodos();
    }

}

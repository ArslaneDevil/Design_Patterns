package com.fges.todoapp.Storage.Json;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fges.todoapp.model.TodoItem;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class TodoJsonGetAll extends AbtractTodoJsonStorage {

    protected TodoJsonGetAll(Path filePath) {
        super(filePath);
    }

    public List<TodoItem> getAllTodos() throws IOException {
        if (Files.exists(filePath)) {
            return mapper.readValue(filePath.toFile(), new TypeReference<List<TodoItem>>(){});
        }
        return new ArrayList<>();
    }

}

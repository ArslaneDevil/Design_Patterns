package com.fges.todoapp.Storage.Json;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.nio.file.Path;

abstract class AbtractTodoJsonStorage {
    protected final Path filePath;

    protected final ObjectMapper mapper = new ObjectMapper();

    protected AbtractTodoJsonStorage(Path filePath) {
        this.filePath = filePath;
    }
}

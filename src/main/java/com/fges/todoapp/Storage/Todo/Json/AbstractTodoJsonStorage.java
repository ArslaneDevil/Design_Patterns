package com.fges.todoapp.Storage.Todo.Json;

import com.fasterxml.jackson.databind.ObjectMapper;

abstract class AbstractTodoJsonStorage {

    protected final String fileContent;

    protected final ObjectMapper objectMapper = new ObjectMapper();

    protected AbstractTodoJsonStorage(String fileContent) {
        this.fileContent = fileContent;
    }


}


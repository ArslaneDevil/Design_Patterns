package com.fges.todoapp.Storage.Todo.Json;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.MissingNode;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


public class TodoWriterJsonStorage extends AbstractTodoJsonStorage {
    private final Path filePath;

    public TodoWriterJsonStorage(String fileContent, Path filePath) {
        super(fileContent);
        this.filePath = filePath;
    }

    public void writeTodo(String todo) throws IOException {

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
    }
}

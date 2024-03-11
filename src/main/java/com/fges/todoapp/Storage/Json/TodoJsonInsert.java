package com.fges.todoapp.Storage.Json;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.fges.todoapp.model.TodoItem;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class TodoJsonInsert extends AbtractTodoJsonStorage {
    protected TodoJsonInsert(Path filePath) {
        super(filePath);
    }

    public void insert(TodoItem item) throws IOException {
        String fileContent = "";

        if (Files.exists(filePath)) {
            fileContent = Files.readString(filePath);
        }
        ObjectMapper mapper = new ObjectMapper();
        JsonNode actualObj = mapper.readTree(fileContent);
        if (actualObj instanceof MissingNode) {
            // Node was not reconised
            actualObj = JsonNodeFactory.instance.arrayNode();
        }

        if (actualObj instanceof ArrayNode arrayNode) {
            arrayNode.add(mapper.valueToTree(item));
        }

        Files.writeString(filePath, mapper.writerWithDefaultPrettyPrinter().writeValueAsString(actualObj));
    }
}

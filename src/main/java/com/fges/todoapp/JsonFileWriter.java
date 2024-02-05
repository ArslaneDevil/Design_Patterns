package com.fges.todoapp;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;


public class JsonFileWriter implements FileWriter {
    private final Path filePath;

    public JsonFileWriter(Path filePath) {
        this.filePath = filePath;
    }

    @Override
    public void writeTodo(String todo) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        ArrayNode arrayNode;
        if (Files.exists(filePath)) {
            String content = Files.readString(filePath);
            JsonNode rootNode = mapper.readTree(content);
            if (rootNode instanceof ArrayNode) {
                arrayNode = (ArrayNode) rootNode;
            } else {
                arrayNode = JsonNodeFactory.instance.arrayNode();
            }
        } else {
            arrayNode = JsonNodeFactory.instance.arrayNode();
        }
        arrayNode.add(todo);
        Files.writeString(filePath, mapper.writeValueAsString(arrayNode));
    }
}

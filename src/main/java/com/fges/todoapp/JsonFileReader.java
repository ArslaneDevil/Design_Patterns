package com.fges.todoapp;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class JsonFileReader implements FileReader {
    private final Path filePath;

    public JsonFileReader(Path filePath) {
        this.filePath = filePath;
    }

    @Override
    public List<String> readTodos() throws IOException {
        List<String> todos = new ArrayList<>();
        if (Files.exists(filePath)) {
            String content = Files.readString(filePath);
            ObjectMapper mapper = new ObjectMapper();
            JsonNode rootNode = mapper.readTree(content);
            if (rootNode instanceof ArrayNode) {
                rootNode.forEach(node -> todos.add(node.asText()));
            }
        }
        return todos;
    }
}

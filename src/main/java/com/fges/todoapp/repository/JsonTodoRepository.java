package com.fges.todoapp.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.fges.todoapp.model.TodoItem;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class JsonTodoRepository implements TodoRepository {
    private final Path filePath;
    private final ObjectMapper mapper = new ObjectMapper();

    public JsonTodoRepository(Path filePath) {
        this.filePath = filePath;
    }

    @Override
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

    @Override
    public void findAll(boolean onlyDone) throws IOException {
        String fileContent = "";

        if (Files.exists(filePath)) {
            fileContent = Files.readString(filePath);
        }
        JsonNode actualObj = mapper.readTree(fileContent);
        if (actualObj instanceof ArrayNode arrayNode) {
            arrayNode.forEach(node -> {
                boolean done = node.get("done").asBoolean();
                if (!onlyDone || done) {
                    System.out.println("- " + (done ? "Done: " : "") + node.get("name").asText());
                }
            });
        }
    }

    @Override
    public List<TodoItem> getAllTodos() throws IOException {
        if (Files.exists(filePath)) {
            return mapper.readValue(filePath.toFile(), new TypeReference<List<TodoItem>>(){});
        }
        return new ArrayList<>();
    }

}

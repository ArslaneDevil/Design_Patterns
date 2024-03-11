package com.fges.todoapp.Storage.Json;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class TodoJsonList extends AbtractTodoJsonStorage {

    protected TodoJsonList(Path filePath) {
        super(filePath);
    }

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
}

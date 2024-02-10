package com.fges.todoapp.Storage.Todo.Json;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.fges.todoapp.Storage.Todo.Todo;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;


public class TodoReaderJsonStorage extends AbstractTodoJsonStorage {

    public TodoReaderJsonStorage(String fileContent) {
        super(fileContent);
    }

    public void listTodo() throws IOException {
        JsonNode actualObj = objectMapper.readTree(fileContent);
        if (actualObj instanceof MissingNode) {
            // Node was not recognised
            actualObj = JsonNodeFactory.instance.arrayNode();
        }

        if (actualObj instanceof ArrayNode arrayNode) {
            arrayNode.forEach(node -> System.out.println("- " + node.toString()));
        }

        }
}
    /*
    public List<Todo> listTodo() throws Exception {


        try {
            fileContent = Files.readString(Path.of(fileContent));
            //System.out.println(fileContent);
        } catch (Exception _ignored) {
            fileContent = "[]";
        }
        return objectMapper.readValue(fileContent, new TypeReference<>() {
        });
    }
        */


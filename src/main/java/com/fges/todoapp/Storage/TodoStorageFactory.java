package com.fges.todoapp.Storage;

import com.fges.todoapp.Storage.Csv.TodoCsvStorage;
import com.fges.todoapp.Storage.Json.TodoJsonStorage;

import java.nio.file.Path;
import java.util.Map;
import java.util.function.Function;

public class TodoStorageFactory {
    private final Path path;
    private final Map<TodoStorage, Function<String, Boolean>> todoStoragePredicates;


    public TodoStorageFactory( Path path) {

        this.path = path;

        // this list could be made with a dependency injection library
        todoStoragePredicates = Map.of(
                new TodoJsonStorage(path), (fileName) -> fileName.endsWith(".json"),
                new TodoCsvStorage(path), (fileName) -> fileName.endsWith(".csv")
        );
    }


    public TodoStorage getTodoStorage(String fileName) {
        for (Map.Entry<TodoStorage, Function<String, Boolean>> entry : todoStoragePredicates.entrySet()) {
            if (entry.getValue().apply(fileName)) {
                return entry.getKey();
            }
        }

        return null;
    }
}

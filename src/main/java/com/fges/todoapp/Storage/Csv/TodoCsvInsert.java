package com.fges.todoapp.Storage.Csv;

import com.fges.todoapp.model.TodoItem;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class TodoCsvInsert extends AbtractTodoCsvStorage{

    protected TodoCsvInsert(Path filePath) {
        super(filePath);
    }

    public void insert(TodoItem item) throws IOException {

        if (!Files.exists(filePath)) {
            Files.createFile(filePath);
        }
        String content = item.isDone() ? "Done: " + item.getName() : item.getName();
        Files.writeString(filePath, content + "\n", StandardOpenOption.APPEND, StandardOpenOption.CREATE);

    }
}

package com.fges.todoapp.Storage.Todo.CSV;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class TodoWriterCSVStorage extends AbstractTodoCSVStorage{
    private final Path filePath;

    public TodoWriterCSVStorage(String fileContent, Path filePath) {
        super(fileContent);
        this.filePath = filePath;
    }

    public void writeTodo(String todo) throws IOException {
        if (!fileContent.endsWith("\n") && !fileContent.isEmpty()) {
            fileContent += "\n";
        }
        fileContent += todo;

        Files.writeString(filePath, fileContent);
    }
}

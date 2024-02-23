package com.fges.todoapp.repository;

import com.fges.todoapp.model.TodoItem;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CsvTodoRepository implements TodoRepository {
    private final Path filePath;

    public CsvTodoRepository(Path filePath) {
        this.filePath = filePath;
    }

    @Override
    public void insert(TodoItem item) throws IOException {
        if (!Files.exists(filePath)) {
            Files.createFile(filePath);
        }

        String content = Files.readString(filePath);
        content += (item.isDone() ? "Done: " : "") + item.getName() + "\n";
        Files.writeString(filePath, content);
    }

    @Override
    public void findAll(boolean onlyDone) throws IOException {
        String fileContent = "";

        if (Files.exists(filePath)) {
            fileContent = Files.readString(filePath);
        }
        Stream<String> lines = Arrays.stream(fileContent.split("\n"));
        if (onlyDone) {
            lines = lines.filter(line -> line.startsWith("Done: "));
        }
        System.out.println(lines.map(todo -> "- " + todo).collect(Collectors.joining("\n")));
    }

    @Override
    public List<TodoItem> getAllTodos() throws IOException {
        List<TodoItem> todos = new ArrayList<>();
        Files.lines(filePath).forEach(line -> {
            boolean done = line.startsWith("Done: ");
            String name = done ? line.substring(6) : line;
            todos.add(new TodoItem(name, done));
        });
        return todos;
    }
}

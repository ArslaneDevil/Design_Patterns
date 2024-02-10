package com.fges.todoapp.Storage.Todo.CSV;

import java.util.Arrays;
import java.util.stream.Collectors;

public class TodoReaderCSVStorage extends AbstractTodoCSVStorage {

    public TodoReaderCSVStorage(String fileContent) {
        super(fileContent);
    }

    public void listTodo() throws Exception {
        System.out.println(Arrays.stream(fileContent.split("\n"))
                .map(todo -> "- " + todo)
                .collect(Collectors.joining("\n"))
        );
    }

}

package com.fges.todoapp.Service;

import com.fges.todoapp.Storage.TodoListStorage;

import java.io.IOException;

public class TodoListService {
    private TodoListStorage todoListStorage;

    public TodoListService(TodoListStorage todoListStorage) {
        this.todoListStorage = todoListStorage;
    }

    public void list(boolean onlyDone) throws IOException {
        todoListStorage.findAll(onlyDone);
    }
}

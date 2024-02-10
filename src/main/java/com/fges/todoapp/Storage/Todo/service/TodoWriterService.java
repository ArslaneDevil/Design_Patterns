package com.fges.todoapp.Storage.Todo.service;

import com.fges.todoapp.Storage.Todo.Todo;

public class TodoWriterService {

    public TodoWriterStorage todoWriterStorage;

    public TodoWriterService(TodoWriterStorage todoWriterStorage) {
        this.todoWriterStorage = todoWriterStorage;
    }

    public void writeTodo(Todo todo) throws Exception {
        todoWriterStorage.writeTodo(todo);
    }
}

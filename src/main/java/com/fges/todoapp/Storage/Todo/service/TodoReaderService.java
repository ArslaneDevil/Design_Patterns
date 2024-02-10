package com.fges.todoapp.Storage.Todo.service;

import com.fges.todoapp.Storage.Todo.Todo;

import java.util.List;

public class TodoReaderService {

    public TodoReaderStorage todoReaderStorage;

    public TodoReaderService(TodoReaderStorage todoReaderStorage) {
        this.todoReaderStorage = todoReaderStorage;
    }

    public List<Todo> listTodo() throws Exception {
        return  todoReaderStorage.listTodo();
    }
}

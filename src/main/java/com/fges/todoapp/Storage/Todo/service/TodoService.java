package com.fges.todoapp.Storage.Todo.service;

import com.fges.todoapp.Storage.Todo.Todo;

import java.util.List;

public class TodoService {

    private final TodoStorage todoStorage;

    public TodoService(TodoStorage todoStorage) {
        this.todoStorage = todoStorage;
    }

    public void writeTodo(Todo todo) throws Exception {
        new TodoWriterService(todoStorage).writeTodo(todo);
    }

    public List<Todo> listTodo() throws Exception {
        return new TodoReaderService(todoStorage).listTodo();
    }
}

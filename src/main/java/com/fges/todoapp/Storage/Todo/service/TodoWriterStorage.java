package com.fges.todoapp.Storage.Todo.service;

import com.fges.todoapp.Storage.Todo.Todo;

public interface TodoWriterStorage {

    void writeTodo(Todo todo) throws Exception;
}

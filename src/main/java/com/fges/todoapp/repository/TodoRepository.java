package com.fges.todoapp.repository;

import com.fges.todoapp.model.TodoItem;

import java.io.IOException;
import java.util.List;

public interface TodoRepository {
    void insert(TodoItem item) throws IOException;

    void findAll(boolean onlyDone) throws IOException;

    List<TodoItem> getAllTodos() throws IOException;
}

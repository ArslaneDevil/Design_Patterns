package com.fges.todoapp.Storage;

import com.fges.todoapp.model.TodoItem;

import java.io.IOException;
import java.util.List;

public interface TodoGetAllStorage {
    List<TodoItem> getAllTodos() throws IOException;
}

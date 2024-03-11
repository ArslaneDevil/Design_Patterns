package com.fges.todoapp.Service;

import com.fges.todoapp.Storage.TodoGetAllStorage;
import com.fges.todoapp.model.TodoItem;

import java.io.IOException;
import java.util.List;

public class TodoGetAllService {
    public TodoGetAllStorage todoGetAllStorage;

    public TodoGetAllService(TodoGetAllStorage todoGetAllStorage) {
        this.todoGetAllStorage = todoGetAllStorage;
    }

    List<TodoItem> getAllTodos() throws IOException {

        return todoGetAllStorage.getAllTodos();
    }
}

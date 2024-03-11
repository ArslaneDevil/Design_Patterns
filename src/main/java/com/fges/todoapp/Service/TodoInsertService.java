package com.fges.todoapp.Service;

import com.fges.todoapp.Storage.TodoInsertStorage;
import com.fges.todoapp.model.TodoItem;

import java.io.IOException;

public class TodoInsertService {
    public TodoInsertStorage todoInsertStorage;

    public TodoInsertService(TodoInsertStorage todoInsertStorage) {
        this.todoInsertStorage = todoInsertStorage;
    }

    public void insertTodo(TodoItem todo) throws IOException {

        todoInsertStorage.insert(todo);
    }
}

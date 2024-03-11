package com.fges.todoapp.Storage;

import com.fges.todoapp.model.TodoItem;

import java.io.IOException;

public interface TodoInsertStorage {

    void insert(TodoItem item) throws IOException;
}

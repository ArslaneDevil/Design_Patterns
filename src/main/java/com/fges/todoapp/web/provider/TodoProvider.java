package com.fges.todoapp.web.provider;

import com.fges.todoapp.Storage.TodoStorage;
import fr.anthonyquere.dumbcrud.CrudProvider;
import com.fges.todoapp.model.TodoItem;

import java.util.List;

public class TodoProvider implements CrudProvider<TodoItem> {
    private final TodoStorage todoStorage;

    public TodoProvider(TodoStorage todoStorage) {
        this.todoStorage = todoStorage;
    }

    @Override
    public void add(TodoItem todoItem) throws Exception {
        try {
            todoStorage.insert(todoItem);
        }catch ( Exception e){
            throw new Exception();
        }

    }

    @Override
    public List<TodoItem> list() throws Exception {
        try {
            return todoStorage.getAllTodos();
        }catch ( Exception e){
            throw new Exception();
        }
    }
}

package com.fges.todoapp.Service;

import com.fges.todoapp.Storage.TodoStorage;
import com.fges.todoapp.model.TodoItem;
import org.apache.commons.cli.CommandLine;

import java.io.IOException;
import java.util.List;

public class TodoService {

    private final TodoStorage todoStorage;

    public TodoService(TodoStorage todoStorage) {
        this.todoStorage = todoStorage;
    }

    public void insert(TodoItem todo) throws IOException {


        new TodoInsertService(todoStorage).insertTodo(todo);
    }

    public void listTodos(boolean onlyDone) throws IOException {
        new TodoListService(todoStorage).list(onlyDone);
    }

    public List<TodoItem> getAllTodos() throws IOException {
        return new TodoGetAllService(todoStorage).getAllTodos();
    }

    public void migrate(CommandLine cmd) throws IOException {
        new TodoMigrate().migrate(cmd, todoStorage);
    }
}

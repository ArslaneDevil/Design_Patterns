package com.fges.todoapp.Storage.Todo.Json;

import com.fges.todoapp.Storage.Todo.Todo;
import com.fges.todoapp.Storage.Todo.service.TodoStorage;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

abstract class TodoJsonStorage implements TodoStorage {
    /*
    private final String fileName;


    private  Path filePath;

    public TodoJsonStorage(String fileName, Path filePath) {
        this.fileName = fileName;
        this.filePath = filePath;
    }

    public TodoJsonStorage(String fileName) {
        this.fileName = fileName;
    }

    public void writeTodo(Todo todo) throws Exception {
        Path filePath = Paths.get(fileName);
        var todoReaderJsonStorage = new TodoReaderJsonStorage(fileName);
        new TodoWriterJsonStorage(fileName, filePath, todoReaderJsonStorage).writeTodo(todo);
    }

    public List<Todo> listTodo() throws Exception {
        return new TodoReaderJsonStorage(fileName).listTodo();
    }
     */

}

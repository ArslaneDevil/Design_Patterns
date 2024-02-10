package com.fges.todoapp.Storage.Todo.CSV;

abstract class AbstractTodoCSVStorage {
    protected String fileContent;

    protected AbstractTodoCSVStorage(String fileContent) {
        this.fileContent = fileContent;
    }
}

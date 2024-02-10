package com.fges.todoapp.Storage.Todo.service;

import com.fges.todoapp.Storage.Todo.Todo;

import java.util.List;

public interface TodoReaderStorage {

    List<Todo> listTodo() throws  Exception;
}

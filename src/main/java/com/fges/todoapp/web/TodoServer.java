package com.fges.todoapp.web;

import com.fges.todoapp.model.TodoItem;
import com.fges.todoapp.web.provider.TodoProvider;
import fr.anthonyquere.dumbcrud.DummyCrudEndpoint;

import java.io.IOException;

public class TodoServer {
    private final TodoProvider todoProvider;
    private int port;

    public TodoServer(TodoProvider todoProvider, int port) {
        this.todoProvider = todoProvider;
        this.port = port;
    }

    public void start() throws IOException, InterruptedException {
        DummyCrudEndpoint<TodoItem> dummyCrudEndpoint = new DummyCrudEndpoint<>("todos", todoProvider, TodoItem.class);
        dummyCrudEndpoint.run(port);

    }
}

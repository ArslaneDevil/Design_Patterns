package com.fges.todoapp;

import java.io.IOException;

public interface FileWriter {
    void writeTodo(String todo) throws IOException;
}

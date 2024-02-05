package com.fges.todoapp;

import java.io.IOException;
import java.util.List;

public interface FileReader {
    List<String> readTodos() throws IOException;
}

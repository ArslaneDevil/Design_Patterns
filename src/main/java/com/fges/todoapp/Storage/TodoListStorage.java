package com.fges.todoapp.Storage;

import java.io.IOException;

public interface TodoListStorage {
    void findAll(boolean onlyDone) throws IOException;
}

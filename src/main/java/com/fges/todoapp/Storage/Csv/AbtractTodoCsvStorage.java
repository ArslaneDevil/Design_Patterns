package com.fges.todoapp.Storage.Csv;

import java.nio.file.Path;

abstract class AbtractTodoCsvStorage {
    protected final Path filePath;

    protected AbtractTodoCsvStorage(Path filePath) {
        this.filePath = filePath;
    }
}

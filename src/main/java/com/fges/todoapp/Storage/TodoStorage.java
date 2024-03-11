package com.fges.todoapp.Storage;

public interface TodoStorage extends
        TodoInsertStorage,
        TodoListStorage,
        //TodoMigrateStorage,
        TodoGetAllStorage
{

}

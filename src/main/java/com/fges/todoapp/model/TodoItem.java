package com.fges.todoapp.model;

public class TodoItem {
    private String name;
    private boolean done;

    public TodoItem(){}
    public TodoItem(String name, boolean done) {
        this.name = name;
        this.done = done;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    @Override
    public String toString() {
        return (done ? "Done: " : "") + name;
    }
}

package com.example.rxjava1;

public class Task {

    private int id;
    private String name;
    private boolean boo;

    public Task(int id, String name, boolean boo) {
        this.id = id;
        this.name = name;
        this.boo = boo;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isBoo() {
        return boo;
    }
}

package com.example.retrofitpostexandroid;

public class User {

    private String name;
    private String job;
    private String id;
    private String createdAt;

    public User(String name, String job, String id, String createdAt) {
        this.name = name;
        this.job = job;
        this.id = id;
        this.createdAt = createdAt;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

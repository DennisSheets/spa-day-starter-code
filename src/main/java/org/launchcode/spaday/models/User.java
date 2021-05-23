package org.launchcode.spaday.models;

import java.time.LocalDateTime;
import java.util.Date;

public class User {
    private int id;
    private int nextId;
    private String username;
    private String email;
    private String password;
    private LocalDateTime dateJoined;

    public User() {
    }

    public User(String username, String email, String password) {
        this();
        this.username = username;
        this.email = email;
        this.password = password;
        this.id = nextId;
        this.dateJoined = LocalDateTime.now();
        nextId++;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public LocalDateTime getDateJoined() {
        return dateJoined;
    }
}

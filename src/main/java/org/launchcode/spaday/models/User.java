package org.launchcode.spaday.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class User {
    @NotBlank(message = "A username is required!")
    @Size(min=5, max=15, message = "Enter a user name that is between 5 and 15 characters!")
    private String username;

    @Email(message= "You must provide a proper email!")
    private String email;

    @Size(min=6, message = "Your password must contain at least 6 characters!")
    private String password;

    @NotNull(message = "Passwords do not match")
    private String verifyPassword;

    private int id;
    private static int nextId = 1;

    public User() {
        this.id = nextId;
        nextId++;
    }

    public User(String username, String email, String password,String verifyPassword) {
        this();
        this.username = username;
        this.email = email;
        this.password = password;
        this.verifyPassword = verifyPassword;

    }

    private void checkPassword(){
        if(password != null && verifyPassword != null && !password.equals(verifyPassword)){
            verifyPassword = null;
        }
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
        checkPassword();
    }

    public String getVerifyPassword() {
        return verifyPassword;
    }

    public void setVerifyPassword(String verifyPassword) {
        this.verifyPassword = verifyPassword;
        checkPassword();
    }

    public int getId() {
        return id;
    }

    public static int getNextId() {
        return nextId;
    }
}

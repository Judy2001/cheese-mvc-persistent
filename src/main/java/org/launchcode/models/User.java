package org.launchcode.models;


import org.hibernate.validator.constraints.Email;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


//@Entity
public class User {

    //@Id
    //@GeneratedValue
    private int id;

    @NotNull
    @Size(min=2, max=15, message = "Username must be 2-15 letters long")
    private String username;

    @Email(message = "Not a valid email address")
    private String email;

    @NotNull
    @Size(min=8, max=25, message = "Password must be 8-25 characters long")
    private String password;


    public User(String username, String email) {
        this.username = username;
        this.email = email;
    }


    public User() {
    }


    public void setAUser(User newUser) {
    }


    public int getId() {
        return id;
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

}
/*
package org.launchcode.models;


import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;


//@Entity
public class User {

    //@Id
    //@GeneratedValue
    private int id;

    @NotNull
    @Size(min=5, max=15, message = "Username must be 5-15 letters long")
    private String username;

    @Email(message = "Not a valid email address")
    private String email;

    @NotNull
    @Size(min=1, message = "Password must not be empty")
    private String password;

    @OneToMany
    @JoinColumn(name = "food_day_id")
    private static ArrayList<User> users = new ArrayList<>();


    public User(String username, String email) {
        this.username = username;
        this.email = email;
    }


    public User() {
    }


*/
/*    public void setAUser(User newUser) {
    }*//*



    public static void add(User newUser) {

        users.add(newUser);
    }


    public static void remove(int id) {
        User userToRemove = getById(id);
        users.remove(userToRemove);
    }


    public static ArrayList<User> getAll() {
        return users;
    }


    public static User getById(int id) {

        User theUser = null;

        for (User candidateUser : users) {
            if (candidateUser.getId() == id) {
                theUser = candidateUser;
            }
        }

        return theUser;
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

}*/

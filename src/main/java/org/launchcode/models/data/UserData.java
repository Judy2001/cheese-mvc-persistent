package org.launchcode.models.data;

import org.launchcode.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;


//@Repository
//@Transactional
public class UserData {

    static ArrayList<User> users = new ArrayList<>();


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

}
